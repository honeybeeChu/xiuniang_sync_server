package com.sync.weixin.handler;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sync.util.log.LogFactory;
import com.sync.weixin.builer.TextBuilder;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author chuliang
 *
 */
@Component
public class LocationHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {
        if (wxMessage.getMsgType().equals(WxConsts.XML_MSG_LOCATION)) {
            try {
            	this.logger.info("用户位置已经收到");
                String content = "感谢反馈，您的的地理位置已收到！";
                return new TextBuilder().build(content, wxMessage, null);
            } catch (Exception e) {
                this.logger.error("位置消息接收处理失败", e);
                return null;
            }
        }

        //上报地理位置事件
        this.logger.info("\n上报地理位置 。。。 ");
        this.logger.info("\n纬度 : " + wxMessage.getLatitude());
        this.logger.info("\n经度 : " + wxMessage.getLongitude());
        this.logger.info("\n精度 : " + String.valueOf(wxMessage.getPrecision()));
        
        //TODO  可以将用户地理位置信息保存到本地数据库，以便以后使用
        
        return null;
    }

}
