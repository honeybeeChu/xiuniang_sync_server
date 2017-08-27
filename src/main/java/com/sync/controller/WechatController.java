package com.sync.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sync.util.log.LogFactory;
import com.sync.util.log.LogObj;
import com.sync.weixin.service.WeixinService;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 公众号的微信交互接口
 * 
 * @author chuliang
 *
 */
@RestController
@RequestMapping("/xiuniang/api")
public class WechatController {
	private static Logger logger = LogFactory.getLogger("weixin");

	@Autowired
	private WeixinService wxService;

	@GetMapping(produces = "text/plain;charset=utf-8")
	public void authGet(HttpServletResponse response,
			@RequestParam(name = "signature", required = false) String signature,
			@RequestParam(name = "timestamp", required = false) String timestamp,
			@RequestParam(name = "nonce", required = false) String nonce,
			@RequestParam(name = "echostr", required = false) String echostr) {

		logger.info("\n接收到来自微信服务器的认证消息是 ：" + signature + timestamp + nonce + echostr);

		if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
			logger.error("请求参数中的signature, timestamp, nonce, echostr有空值错误");
		}

		if (this.getWxService().checkSignature(timestamp, nonce, signature)) {
			logger.info("sdk checkSignature 方法返回成功，返回的echostr:" + echostr);
			try {
				response.getWriter().write(String.copyValueOf(echostr.toCharArray()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.error("sdk checkSignature 方法返回失败");
		}

	}

	@PostMapping(produces = "application/xml; charset=UTF-8")
	public void post(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取url中参数
			String signature = request.getParameter("signature");
			String echostr = request.getParameter("echostr");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String encrypt_type = request.getParameter("encrypt_type");
			String msg_signature = request.getParameter("msg_signature");
			String requestBody = getRequestPostMsg(request);

			LogObj logObj = new LogObj();
			logObj.putSysKey(LogObj.MODULE, "y").putSysKey(LogObj.STEP, "request");
			logObj.putData("signature", signature).putData("encrypt_type", encrypt_type)
					.putData("msg_signature", msg_signature)
					.putData("timestamp", timestamp)
					.putData("nonce", nonce)
					.putData("requestBody",requestBody);

			logger.info(logObj);

			if (!this.getWxService().checkSignature(timestamp, nonce, signature)) {
				logger.error("非法请求，可能属于伪造的请求！");
				throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
			}

			String out = null;
			if (encrypt_type == null) {
				// 明文传输的消息
				WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
				WxMpXmlOutMessage outMessage = this.getWxService().route(inMessage);
				if (outMessage == null) {
					return;
				}

				out = outMessage.toXml();
			} else if ("aes".equals(encrypt_type)) {
				logger.info("encrypt_type..");
				// aes加密的消息
				WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody,
						this.getWxService().getWxMpConfigStorage(), timestamp, nonce, msg_signature);
				logger.info("\n消息解密后内容为：\n{} " + inMessage.toString());
				WxMpXmlOutMessage outMessage = this.getWxService().route(inMessage);
				if (outMessage == null) {
					logger.error("outMessage == null");
					return;
				}
				out = outMessage.toEncryptedXml(this.getWxService().getWxMpConfigStorage());
			}

			logger.debug("\n组装回复信息：{} " + out);
			response.getWriter().write(out);
			return;
		} catch (Exception e) {
			logger.error("there is exception occured,{}" + e.toString());
			return;
		}
	}

	public String getRequestPostMsg(HttpServletRequest request) throws IOException {
		// 处理接收消息
		InputStream in = request.getInputStream();
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		return xmlMsg.toString();
	}

	private WeixinService getWxService() {
		return this.wxService;
	}

}
