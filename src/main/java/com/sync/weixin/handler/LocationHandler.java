package com.sync.weixin.handler;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sync.model.Wx_shop;
import com.sync.mybatis.mapper.Wx_shopMapper;
import com.sync.util.PathUtils;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.weixin.service.WeixinService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.builder.kefu.NewsBuilder;

/**
 * 
 * @author chuliang
 *
 */
@Component
public class LocationHandler extends AbstractHandler {
	
	@Autowired
	private WeixinService weixinService;

	@Autowired
	private Wx_shopMapper wx_shopMapper;
	
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {
        if (wxMessage.getMsgType().equals(WxConsts.XML_MSG_LOCATION)) {
            try {

				Map<Integer, Wx_shop> shopMap = getNearest3Shop(1, wxMessage.getLocationY(),
						wxMessage.getLocationX());

				if (null != shopMap) {
					NewsBuilder basebuild = WxMpKefuMessage.NEWS().toUser(wxMessage.getFromUser());

					int _time = 0;
					for (Map.Entry<Integer, Wx_shop> entry : shopMap.entrySet()) {
						_time++;
						if (_time < 3) {
							logger.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());
							
							double distance_to_kilometer = Math.ceil(entry.getKey() / 1000);

							WxMpKefuMessage.WxArticle article1 = new WxMpKefuMessage.WxArticle();
							article1.setUrl(getNewsUrl(entry.getValue(), String.valueOf(wxMessage.getLocationY()),
									String.valueOf(wxMessage.getLocationX()), entry.getValue().getLongitude(),
									entry.getValue().getLatitude()));
							article1.setPicUrl(getPublicNewsPic());
							article1.setDescription("最近店铺距离");
							article1.setTitle(entry.getValue().getBusinessName() + entry.getValue().getBranchName()
									+ ": " + distance_to_kilometer + "公里");
							basebuild.addArticle(article1);
						}
					}
					
					WxMpKefuMessage message = basebuild.build();
					//发送消息
					weixinService.getKefuService().sendKefuMessage(message);
				}
				return null;
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
        
        return null;
    }
    
    
    
    private String getNewsUrl(Wx_shop shop, String fromLongitude, String fromLatitude, String toLongitude,
			String toLatitude) {
		StringBuffer sf = new StringBuffer();
		sf.append(PropertyPlaceholder.getProperty("application_url")).append("navigate/shopinfo.do?&account_id=")
		.append(shop.getAccountId())
		.append("&poi_id=")
		.append(shop.getSid())
				.append("&fromLongitude=").append(fromLongitude).append("&fromLatitude=").append(fromLatitude)
				.append("&toLongitude=").append(toLongitude).append("&toLatitude=").append(toLatitude);

		return sf.toString();
	}

	private Map<Integer, Wx_shop> getNearest3Shop(int account_id, Double longitude, Double latitude) {
		List<Wx_shop> wxshoplist = wx_shopMapper.getAllShopsByAccountid(account_id);

		if (wxshoplist.size() > 0) {
			Map<Integer, Wx_shop> shopmap = new TreeMap<Integer, Wx_shop>();
			for (Wx_shop shop : wxshoplist) {
				Double distance = (Double) PathUtils.getDistance(longitude, latitude,
						Double.parseDouble(shop.getLongitude()), Double.parseDouble(shop.getLatitude()));
				shopmap.put(distance.intValue(), shop);
			}
			return shopmap;
		}
		return null;
	}

	/**
	 * @return
	 */
	private String getPublicNewsPic() {
		
		String appurl = PropertyPlaceholder.getProperty("application_url");
		return appurl + "resource/image/native_news_pic";
	}

}
