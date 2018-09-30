package com.westar.common.redis.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.westar.common.redis.JedisClient;

@Repository(value = "jedisClient")
public class JedisClientSingle implements JedisClient {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void setObject(String key, String value) {
		redisTemplate.boundValueOps(key).set(value);
	}

	@Override
	public String getObject(String key) {
		Object value = redisTemplate.boundValueOps(key).get();
		if (null != value) {
			return value.toString();
		}
		return null;
	}

	@Override
	public void expressObject(String key, Integer miniuts) {
		redisTemplate.expire(key, miniuts, TimeUnit.MINUTES);

	}

	@Override
	public void deleteObject(String key) {
		redisTemplate.delete(key);

	}
}
