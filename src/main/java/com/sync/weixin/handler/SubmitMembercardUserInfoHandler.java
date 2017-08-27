package com.sync.weixin.handler;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sync.util.log.LogFactory;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 会员卡的激活事件
 * @author chuliang
 *
 */
@Component
public class SubmitMembercardUserInfoHandler extends AbstractHandler {
	private static Logger logger = LogFactory.getLogger("weixin");

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {
        if (wxMessage.getMsgType().equals("submit_membercard_user_info")) {
        	logger.info("submit_membercard_user_info in ......");
        }
        return null;
    }

}
