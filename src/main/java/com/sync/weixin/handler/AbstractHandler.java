package com.sync.weixin.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;

/**
 * 
 * @author chuliang
 *
 */
public abstract class AbstractHandler implements WxMpMessageHandler {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected final Gson gson = new Gson();

}
