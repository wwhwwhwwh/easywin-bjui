package com.westar.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westar.common.model.RpNotifyRecord;
import com.westar.common.model.UserInfo;
import com.westar.login.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public UserInfo queryUserInfo(UserInfo userInfo) {
		return loginDao.queryUserInfo(userInfo);
		
	}

	public void updateRpNotifyRecord(RpNotifyRecord rpNotifyRecord) {
		System.out.println(rpNotifyRecord.toString());
	}

}
