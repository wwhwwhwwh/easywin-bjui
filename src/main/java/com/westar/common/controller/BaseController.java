package com.westar.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.westar.base.cons.SessionKeyConstant;
import com.westar.base.context.SessionContext;
import com.westar.base.model.system.CommonConstant;
import com.westar.base.model.system.Notification;
import com.westar.base.util.RequestContextHolderUtil;
import com.westar.base.util.UUIDGenerator;
import com.westar.common.model.UserInfo;
import com.westar.common.redis.JedisClient;

@Controller
public class BaseController {
	
	@Resource
	JedisClient jedisClient;
	/**
	 * 注销用户
	 * @param sid
	 */
	@SuppressWarnings("unchecked")
	protected void logOut(String sid) {
		
		String key = CommonConstant.SESSION_USER_KEY+":" + sid;
		jedisClient.deleteObject(key);
		
		HttpSession session = RequestContextHolderUtil.getSession();
		Map<String, Map<String, Object>> map = (Map<String, Map<String, Object>>) session.getAttribute(SessionKeyConstant.SESSION_CONTEXT);
		if (map == null) {
			map = new HashMap<String, Map<String, Object>>(14);
		}
		Map<String, Object> m = map.get(SessionKeyConstant.USER_CONTEXT);
		if (m == null) {
			m = new HashMap<String, Object>(14);
		}
		 
		//移除的对象
		UserInfo userInfo = (UserInfo) m.remove(sid);
		if(null!=userInfo){
			//sessionMap中移除当前用户
			SessionContext.sessionMap.remove(userInfo.getId());
			//sidMap中移除当前用户
			SessionContext.sidMap.remove(userInfo.getId());
		}
		
		map.put(SessionKeyConstant.USER_CONTEXT, m);
		session.setAttribute(SessionKeyConstant.SESSION_CONTEXT, map);
		
	}
	
	/**
	 * 获取保存在Session中的对象
	 * @return
	 */
	protected Object getSessionObj(String key) {
		Object obj = jedisClient.getObject(key);
		if(null != obj) {
			return obj;
		}else {
			String sid = this.getSid();
			HttpSession sessionForGet = RequestContextHolderUtil.getSessionForGet();
			if(null==sessionForGet){
				return null;
			}
			
			Map<String, Map<String, Object>> map = (Map<String, Map<String, Object>>) sessionForGet.getAttribute(SessionKeyConstant.SESSION_CONTEXT);
			if (map == null) {
				return null;
			}
			Map<String, Object> m = map.get(key);
			if (m == null) {
				return null;
			}
			if (map != null && sid != null) {
				obj = m.get(sid);
				jedisClient.setObject(key, JSONObject.toJSONString(obj));
				return obj;
			}
			return null;
		}
	}
	
	/**
	 * 获取保存在Session中的登录人员信息
	 * @return
	 */
	protected UserInfo getSessionUser() {
		String sid = this.getSid();
		String key = CommonConstant.SESSION_USER_KEY+":" + sid;
		Object object = this.getSessionObj(key);
		if(null != object) {
			UserInfo userInfo = null;
			if(object instanceof String) {
				userInfo = JSONObject.parseObject(object.toString(), UserInfo.class);
			}else if(object instanceof UserInfo){
				userInfo = (UserInfo) object;
			}
			jedisClient.expressObject(key, CommonConstant.SESSION_USER_EXPRESS);
			return userInfo;
		}else {
			return null;
		}
	}
	/**
	 * 修改登录人员信息
	 * @return
	 */
	protected void updateSessionUser(UserInfo obj) {
		String sid = this.getSid();
		String key = CommonConstant.SESSION_USER_KEY+":" + sid;
		jedisClient.setObject(key, JSONObject.toJSONString(obj));
		jedisClient.expressObject(key, CommonConstant.SESSION_USER_EXPRESS);
		
		HttpSession session = RequestContextHolderUtil.getSession();
		Map<String, Map<String, Object>> map = (Map<String, Map<String, Object>>) session.getAttribute(SessionKeyConstant.SESSION_CONTEXT);
		Map<String, Object> m = map.get(SessionKeyConstant.USER_CONTEXT);
		m.put(this.getSid(), obj);
		map.put(SessionKeyConstant.USER_CONTEXT, m);
		session.setAttribute(SessionKeyConstant.SESSION_CONTEXT, map);
		
	}
	/**
	 * 保存对象到Session中
	 * @param user
	 */
	protected String addSessionUser(Object obj) {
		
		//缓存到redis
		String sid = UUIDGenerator.getUUID();
		String key = CommonConstant.SESSION_USER_KEY + ":" + sid;
		jedisClient.setObject(key, JSONObject.toJSONString(obj));
		jedisClient.expressObject(key, CommonConstant.SESSION_USER_EXPRESS);
		
		//缓存到HttpSession
		HttpSession session = RequestContextHolderUtil.getSession();
		Map<String, Map<String, Object>> map = (Map<String, Map<String, Object>>) session.getAttribute(SessionKeyConstant.SESSION_CONTEXT);
		if (map == null) {
			map = new HashMap<String, Map<String, Object>>(14);
		}
		Map<String, Object> m = map.get(key);
		if (m == null) {
			m = new HashMap<String, Object>(14);
		}
		m.put(sid, obj);
		map.put(SessionKeyConstant.USER_CONTEXT, m);
		session.setAttribute(SessionKeyConstant.SESSION_CONTEXT, map);
		
		return sid;
	}
	
	/**
	 * 保存Web消息
	 * @param type
	 * @param content
	 */
	protected void setNotification(int type, String content) {
		Notification notification = new Notification(type, content);
		RequestContextHolderUtil.getSession().setAttribute(CommonConstant.NOTIFICATION_CONTEXT, notification);
	}

	/**
	 * 获取SID，如果为NULL 返回空字符
	 * @return
	 */
	protected String getSid() {
		HttpServletRequest request = RequestContextHolderUtil.getRequest();
		return request.getParameter("sid");
	}
}
