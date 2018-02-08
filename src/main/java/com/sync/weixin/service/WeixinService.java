package com.sync.weixin.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.util.log.LogFactory;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.weixin.handler.AbstractHandler;
import com.sync.weixin.handler.KfSessionHandler;
import com.sync.weixin.handler.LocationHandler;
import com.sync.weixin.handler.LogHandler;
import com.sync.weixin.handler.MenuHandler;
import com.sync.weixin.handler.MsgHandler;
import com.sync.weixin.handler.NullHandler;
import com.sync.weixin.handler.StoreCheckNotifyHandler;
import com.sync.weixin.handler.SubmitMembercardUserInfoHandler;
import com.sync.weixin.handler.SubscribeHandler;
import com.sync.weixin.handler.UnsubscribeHandler;
import com.sync.weixin.handler.UserGetCardHandler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.kefu.result.WxMpKfOnlineList;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.constant.WxMpEventConstants;

import org.apache.log4j.Logger;

/**
 * @author chuliang
 */
@Service
public class WeixinService extends WxMpServiceImpl {
	
	private static final Logger logger = LogFactory.getLogger("weixin");

	@Autowired
	protected LogHandler logHandler;

	@Autowired
	protected NullHandler nullHandler;

	@Autowired
	protected KfSessionHandler kfSessionHandler;

	@Autowired
	protected StoreCheckNotifyHandler storeCheckNotifyHandler;

	@Autowired
	private LocationHandler locationHandler;

	@Autowired
	private MenuHandler menuHandler;

	@Autowired
	private MsgHandler msgHandler;
	
	@Autowired
	private UserGetCardHandler userGetCardHandler;
	
	@Autowired
	private SubmitMembercardUserInfoHandler submitMembercardUserInfoHandler;
	
	@Autowired
	private UnsubscribeHandler unsubscribeHandler;

	@Autowired
	private SubscribeHandler subscribeHandler;

	private WxMpMessageRouter router;

	@PostConstruct
	public void init() {
		logger.info("wexinservice init .....");
		final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId(PropertyPlaceholder.getProperty("wx_appid"));// 设置微信公众号的appid
		config.setSecret(PropertyPlaceholder.getProperty("wx_appsecret"));// 设置微信公众号的app corpSecret
		config.setToken(PropertyPlaceholder.getProperty("wx_token"));// 设置微信公众号的token
		config.setAesKey(PropertyPlaceholder.getProperty("wx_aeskey"));// 设置消息加解密密钥
		super.setWxMpConfigStorage(config);

		this.refreshRouter();
	}

	private void refreshRouter() {
		final WxMpMessageRouter newRouter = new WxMpMessageRouter(this);

		// 记录所有事件的日志
		newRouter.rule().handler(this.logHandler).next();

		// 接收客服会话管理事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxMpEventConstants.CustomerService.KF_CREATE_SESSION).handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxMpEventConstants.CustomerService.KF_CLOSE_SESSION).handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxMpEventConstants.CustomerService.KF_SWITCH_SESSION).handler(this.kfSessionHandler).end();

		// 门店审核事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxMpEventConstants.POI_CHECK_NOTIFY)
				.handler(this.storeCheckNotifyHandler).end();

		// 自定义菜单事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.BUTTON_CLICK)
				.handler(menuHandler).end();

		// 点击菜单连接事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.BUTTON_VIEW)
				.handler(this.nullHandler).end();

		// 关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SUBSCRIBE)
				.handler(subscribeHandler).end();

		// 取消关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_UNSUBSCRIBE)
				.handler(unsubscribeHandler).end();

		// 上报地理位置事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_LOCATION)
				.handler(locationHandler).end();
		
		// 领取会员卡事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event("user_get_card")
						.handler(userGetCardHandler).end();
		
		// 激活会员卡事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event("submit_membercard_user_info")
						.handler(submitMembercardUserInfoHandler).end();		
				
		// 接收地理位置消息
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION).handler(locationHandler).end();

		// 扫码事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SCAN)
				.handler(this.getScanHandler()).end();

		// 默认
		newRouter.rule().async(false).handler(msgHandler).end();

		this.router = newRouter;
	}

	public WxMpXmlOutMessage route(WxMpXmlMessage message) {
		try {
			return this.router.route(message);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	public boolean hasKefuOnline() {
		try {
			WxMpKfOnlineList kfOnlineList = this.getKefuService().kfOnlineList();
			return kfOnlineList != null && kfOnlineList.getKfOnlineList().size() > 0;
		} catch (Exception e) {
			this.logger.error("获取客服在线状态异常: " + e.getMessage(), e);
		}

		return false;
	}

//	protected MenuHandler getMenuHandler() {
//		return this.menuHandler;
//	}
//
//	protected SubscribeHandler getSubscribeHandler() {
//		return this.subscribeHandler;
//	}
//
//	protected UnsubscribeHandler getUnsubscribeHandler() {
//		return this.unsubscribeHandler;
//	}
//
//	protected AbstractHandler getLocationHandler() {
//		return this.locationHandler;
//	}
//
//	protected MsgHandler getMsgHandler() {
//		return this.msgHandler;
//	}
//	
//	protected UserGetCardHandler geUser_get_cardHandler() {
//		return this.userGetCardHandler;
//	}
//	
//	
//	protected SubmitMembercardUserInfoHandler getSubmitMembercardUserInfoHandler() {
//		return this.submitMembercardUserInfoHandler;
//	}
	
	

	protected AbstractHandler getScanHandler() {
		return null;
	}

}
