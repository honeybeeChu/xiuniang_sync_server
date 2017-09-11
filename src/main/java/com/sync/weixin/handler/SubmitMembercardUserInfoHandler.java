package com.sync.weixin.handler;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.mapper.Points_ruleMapper;
import com.sync.mybatis.model.Membership;
import com.sync.mybatis.model.Points_rule;
import com.sync.util.log.LogFactory;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.weixin.constant.WechatConstant;

import me.chanjar.weixin.common.exception.WxErrorException;
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
	

	@Autowired
	private MembershipMapper membershipMapper;
	
	@Autowired
	private Points_ruleMapper points_ruleMapper;
	
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {
    	
    	logger.info("会员卡的激活事件 openid:" + wxMessage.getFromUser());
    	Membership membership = membershipMapper.selectByOpenId(wxMessage.getFromUser());
    	if(null != membership) {
    		
    		JSONObject obj = new JSONObject();
    		obj.put("card_id", wxMessage.getCardId());
    		obj.put("code", wxMessage.getUserCardCode());
    		
    		try {
				String returnStr = wxMpService.post(WechatConstant.MEMBERCARD_USERINFO_GET, obj.toJSONString());
				JSONArray info_array = JSONArray.parseArray(JSONObject.parseObject(JSONObject.parseObject(returnStr).getString("user_info")).getString("common_field_list"));
				
				for(int index=0;index<info_array.size();index++){
					JSONObject info_obj = info_array.getJSONObject(index);
					//姓名
					if("USER_FORM_INFO_FLAG_NAME".equals(info_obj.getString("name"))) {
						membership.setName(info_obj.getString("value"));
					}
					//手机
					else if("USER_FORM_INFO_FLAG_MOBILE".equals(info_obj.getString("name"))) {
						membership.setPhone(info_obj.getString("value"));
					}
					//性别
					else if("USER_FORM_INFO_FLAG_SEX".equals(info_obj.getString("name"))) {
						membership.setSex("男".equals(info_obj.getString("value")) ? 1 : 0);
					}
					//生日
					else if("USER_FORM_INFO_FLAG_BIRTHDAY".equals(info_obj.getString("name"))) {
						membership.setBirthday(info_obj.getString("value"));
					}
					//行业
					else if("USER_FORM_INFO_FLAG_INDUSTRY".equals(info_obj.getString("name"))) {
						membership.setIndustry(info_obj.getString("value"));
					}
					//地址
					else if("USER_FORM_INFO_FLAG_LOCATION".equals(info_obj.getString("name"))) {
						membership.setLocation(info_obj.getString("value"));
					}
				}
				membership.setHasActive(true);
				int updatecount = membershipMapper.updateByPrimaryKeySelective(membership);
				
				// 保存信息到百盛的数据库中去
				if(0 < updatecount) {
					JSONObject efast_member = new JSONObject();
					efast_member.put("card_id", wxMessage.getUserCardCode());
					efast_member.put("gkmc", membership.getName());
					efast_member.put("phone", membership.getPhone());
					efast_member.put("sex", 0 == membership.getSex() ? "女" : "男");
					efast_member.put("birthday", membership.getBirthday());
					efast_member.put("shopid", "");
					efast_member.put("address", membership.getLocation());
					
					//根据会员等级设置线下折扣率
					Points_rule rule = points_ruleMapper.selectByLevel(membership.getLevel());
					efast_member.put("rate", rule.getDiscount());
					
					wxMpService.post(PropertyPlaceholder.getProperty("SYNCVIPINFO_INFO_URL").toString(), 
							efast_member.toJSONString());
				}
				
				logger.info("会员卡的激活后，获取用户填写的信息为:" + returnStr);
			} catch (WxErrorException e) {
				logger.error("会员卡的激活后，获取用户填写的信息报错: " + e.toString());
			}
    	}
    	
        return null;
        
    }

}
