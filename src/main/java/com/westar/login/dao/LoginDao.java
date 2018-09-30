package com.westar.login.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.westar.common.dao.BaseDao;
import com.westar.common.model.UserInfo;

@Repository
public class LoginDao extends BaseDao{

	public UserInfo queryUserInfo(UserInfo userInfo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("\n select * ");
		sql.append("\n from userInfo a ");
		sql.append("\n where 1=1 and a.id=1 ");
		return (UserInfo) this.objectQuery(sql.toString(), args.toArray(), UserInfo.class);
	}

}
