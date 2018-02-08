package com.sync.weixin.handler;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sync.util.log.LogFactory;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;

/**
 * 
 * @author chuliang
 *
 */
public abstract class AbstractHandler implements WxMpMessageHandler {

//    protected Logger logger = LoggerFactory.getLogger(getClass());
	protected Logger logger = LogFactory.getLogger("weixin");
    protected final Gson gson = new Gson();

}
