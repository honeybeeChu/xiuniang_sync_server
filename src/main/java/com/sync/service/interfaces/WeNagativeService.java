package com.sync.service.interfaces;

import com.sync.model.Wx_shop;

public interface WeNagativeService {
	Boolean syncWeShops();
	Wx_shop getShopInfoByPoid(String poi_id);
	Wx_shop getShopInfoByShopId(int id);
}
