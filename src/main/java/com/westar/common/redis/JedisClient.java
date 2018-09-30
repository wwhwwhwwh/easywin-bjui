package com.westar.common.redis;

public interface JedisClient {

	void setObject(String key,String value);
	String getObject(String key);
	void expressObject(String key,Integer miniuts);
	void deleteObject(String key);
	
}
