package com.sync.weixin.handler;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.model.Membership;
import com.sync.util.log.LogFactory;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 会员卡的领取事件
 * @author chuliang
 *
 */
@Component
public class UserGetCardHandler extends AbstractHandler {
	
	private static Logger logger = LogFactory.getLogger("weixin");

	@Autowired
	private MembershipMapper membershipMapper;
	
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {
    	
    	Membership membership = membershipMapper.selectByOpenId(wxMessage.getFromUser());
    	if(null == membership) {
    		Membership new_membership = new Membership();
    		new_membership.setCode(wxMessage.getUserCardCode());
    		new_membership.setDianyuanId(wxMessage.getOuterId());
        	new_membership.setCardId(wxMessage.getCardId());
        	new_membership.setHasActive(false);
        	new_membership.setLevel(0);
        	new_membership.setOpenid(wxMessage.getFromUser());
        	
        	membershipMapper.insertSelective(new_membership);
    	}
    	
    	//接收处理用户发送的地理位置消息
    	logger.info("user_get_card handler in ........");
        return null;
    }
    

}
