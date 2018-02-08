package com.sync.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.model.Wx_shop;
import com.sync.mybatis.mapper.Wx_shopMapper;
import com.sync.service.interfaces.WeNagativeService;
import com.sync.util.log.LogFactory;
import com.sync.weixin.service.WeixinService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.store.WxMpStoreInfo;

/**
 * @author chulilang
 *
 */
@Service
public class WeNagativeServiceImpl implements WeNagativeService {
	public static final Logger logger = LogFactory.getLogger("main");
	public static final Logger error = LogFactory.getLogger("error");

    @Autowired
    private Wx_shopMapper wx_shopMapper;
    
    @Autowired
    private WeixinService weixinService;
    
    @Override
    public Boolean syncWeShops() {
        try {
    		
            List<WxMpStoreInfo> shoplist = (List<WxMpStoreInfo>)weixinService.getStoreService().listAll();
            for (WxMpStoreInfo shopinfo : shoplist) {
                if (wx_shopMapper.findCountByPoid(shopinfo.getBaseInfo().getPoiId()) == 0) {
                    Wx_shop wxshop = new Wx_shop();
                    wxshop.setAccountId(1);
                    wxshop.setAddress(shopinfo.getBaseInfo().getAddress());
                    wxshop.setBranchName(shopinfo.getBaseInfo().getBranchName());
                    wxshop.setBusinessName(shopinfo.getBaseInfo().getBusinessName());
                    wxshop.setCategories(getWxshopCategoryStr(shopinfo.getBaseInfo()
                            .getCategories()));
                    wxshop.setCity(shopinfo.getBaseInfo().getCity());
                    wxshop.setDistrict(shopinfo.getBaseInfo().getDistrict());
                    wxshop.setIntroduction(shopinfo.getBaseInfo().getIntroduction());
                    wxshop.setLatitude(String.valueOf(shopinfo.getBaseInfo().getLatitude()));
                    wxshop.setLongitude(String.valueOf(shopinfo.getBaseInfo().getLongitude()));
                    wxshop.setOffsetType((byte) shopinfo.getBaseInfo().getOffsetType().intValue());
                    wxshop.setOpenTime(shopinfo.getBaseInfo().getOpenTime());
                    wxshop.setProvince(shopinfo.getBaseInfo().getProvince());
                    wxshop.setSid(shopinfo.getBaseInfo().getPoiId());
                    wxshop.setTelephone(shopinfo.getBaseInfo().getTelephone());
                    wx_shopMapper.insertSelective(wxshop);
                }
            }
        } catch (WxErrorException e) {
            logger.error("there is a WxErrorException "+ e.toString());
            return false;
        } catch (Exception e) {
            logger.error("there is a Exception "+ e.toString());
            return false;
        }
        return true;
    }

    @Override
    public Wx_shop getShopInfoByPoid(String poi_id) {
        List<Wx_shop> wxShopList = wx_shopMapper.getShopInfoByPoid(poi_id);
        Wx_shop wx_shop = new Wx_shop();
        if (wxShopList != null && wxShopList.size() > 0) {
            wx_shop = wxShopList.get(0);
        }
        return wx_shop;
    }

    @Override
    public Wx_shop getShopInfoByShopId(int id) {
        return wx_shopMapper.selectByPrimaryKey(id);
    }

    private String getWxshopCategoryStr(String[] category) {
        if (category.length > 0) {
            StringBuffer sf = new StringBuffer();
            for (String name : category) {
                sf.append(name);
                sf.append(" ");
            }
            return sf.toString();
        }
        return null;
    }

}
