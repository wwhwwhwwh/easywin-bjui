package com.westar.common.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import com.westar.base.annotation.DefaultFiled;
import com.westar.base.annotation.Filed;
import com.westar.base.annotation.Identity;
import com.westar.base.annotation.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** 
 * 人员信息表
 */
@Table
@JsonInclude(Include.NON_NULL)
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 4034583568024738594L;
	/** 
	* id主键
	*/
	@Identity
	private Integer id;
	/** 
	* 记录创建时间
	*/
	@DefaultFiled
	private String recordCreateTime;
	/** 
	* 人员名称
	*/
	@Filed
	private String userName;
	/** 
	* 拼音 全拼
	*/
	@Filed
	private String allSpelling;
	/** 
	* 拼音 首字母
	*/
	@Filed
	private String firstSpelling;
	/** 
	* 登陆密码
	*/
	@Filed
	private String password;
	/** 
	* 联系人固定电话
	*/
	@Filed
	private String linePhone;
	/** 
	* 移动电话
	*/
	@Filed
	private String movePhone;
	/** 
	* 电子邮件
	*/
	@Filed
	private String email;
	/** 
	* 微信
	*/
	@Filed
	private String wechat;
	/** 
	* 0女1男
	*/
	@Filed
	private String gender;
	/** 
	* 生日
	*/
	@Filed
	private String birthday;
	/** 
	* 登录别名
	*/
	@Filed
	private String nickname;
	/** 
	* qq
	*/
	@Filed
	private String qq;
	/** 
	* 个性签名
	*/
	@Filed
	private String selfIntr;

	/****************以上主要为系统表字段********************/
	
	/**
	 * 无参构造
	 */
	public UserInfo() {}
	public UserInfo(Integer comId,Integer userId) {
		this.comId = comId;
		this.id = userId;
	}
	
	private String enrollNumber;
	private Integer comId;
	private String enabled;
	private String remark;
	private String lastOnlineTime;
	private String admin;
	private String job;
	private Integer depId;
	private String checkState;
	private String bigHeadPortrait;
	private String mediumHeadPortrait;
	private String smallHeadPortrait;
	private Integer jifenScore;
	//操作的IP地址
	private String optIP;
	/** 
	* 是否在线0否1是2表示查询所有
	*/
	private String ifOnline;
	/** 
	* 性别
	*/
	private String genderName;
	/** 
	* 部门名称
	*/
	private String depName;
	/** 
	* 直属下属成员数
	*/
	private Integer countSub;
	private String autoEject;
	
	private String alterInfo;
	
	/** 
	* 入职时间
	*/
	private String hireDate;
	/** 
	* 上次登录时间
	*/
	private String lastLoginTime;
	/** 
	* 登录次数
	*/
	private Integer loginTimes;
	/** 
	* 是否为首席默认不是
	*/
	private String isChief;
	/** 
	* 用户加入的所有团队个数
	*/
	private Integer userInOrgNums;
	/**
	 * 是否过期
	 */
	private Integer inService;

	/** 
	* 请假次数
	*/
	private Integer leaveTimeT;
	/** 
	* 请假总时长
	*/
	private String leaveTotal;
	/** 
	* 加班次数
	*/
	private Integer overTimeT;
	/** 
	* 加班总时长
	*/
	private String overTimeTotal;
	/** 
	* 迟到次数
	*/
	private Integer lateTime;
	/** 
	* 早退次数
	*/
	private Integer leaveEarlyTime;
	/** 
	* 异常次数
	*/
	private Integer unusualTime;
	/** 
	* 旷工次数
	*/
	private Integer absentTime;
	/** 
	* 是否查看
	*/
	private String isView;
	/** 
	* 查看时间
	*/
	private String viewTime;
	/** 
	* 个人默认显示组主键
	*/
	private Integer defShowGrpId;
	/**
	 * 代理人主键
	 */
	private Integer forMeDoUserId;
	/**
	 * 代理人名称
	 */
	private String forMeDoUserName;
	/**
	 * 所属角色列表用逗号连接的字符串
	 */
	private String roles;

	/****************以上为自己添加字段********************/
	/** 
	* id主键
	* @param id
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/** 
	* id主键
	* @return
	*/
	public Integer getId() {
		return id;
	}

	/** 
	* 记录创建时间
	* @param recordCreateTime
	*/
	public void setRecordCreateTime(String recordCreateTime) {
		this.recordCreateTime = recordCreateTime;
	}

	/** 
	* 记录创建时间
	* @return
	*/
	public String getRecordCreateTime() {
		return recordCreateTime;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getComId() {
		return comId;
	}

	/** 
	* 人员名称
	* @param userName
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** 
	* 人员名称
	* @return
	*/
	public String getUserName() {
		return userName;
	}

	/** 
	* 拼音 全拼
	* @param allSpelling
	*/
	public void setAllSpelling(String allSpelling) {
		this.allSpelling = allSpelling;
	}

	/** 
	* 拼音 全拼
	* @return
	*/
	public String getAllSpelling() {
		return allSpelling;
	}

	/** 
	* 拼音 首字母
	* @param firstSpelling
	*/
	public void setFirstSpelling(String firstSpelling) {
		this.firstSpelling = firstSpelling;
	}

	/** 
	* 拼音 首字母
	* @return
	*/
	public String getFirstSpelling() {
		return firstSpelling;
	}

	/** 
	* 登陆密码
	* @param password
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	* 登陆密码
	* @return
	*/
	public String getPassword() {
		return password;
	}

	/** 
	* 联系人固定电话
	* @param linePhone
	*/
	public void setLinePhone(String linePhone) {
		this.linePhone = linePhone;
	}

	/** 
	* 联系人固定电话
	* @return
	*/
	public String getLinePhone() {
		return linePhone;
	}

	/** 
	* 移动电话
	* @param movePhone
	*/
	public void setMovePhone(String movePhone) {
		this.movePhone = movePhone;
	}

	/** 
	* 移动电话
	* @return
	*/
	public String getMovePhone() {
		return movePhone;
	}

	/** 
	* 电子邮件
	* @param email
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	* 电子邮件
	* @return
	*/
	public String getEmail() {
		return email;
	}

	/** 
	* 微信
	* @param wechat
	*/
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	/** 
	* 微信
	* @return
	*/
	public String getWechat() {
		return wechat;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSelfIntr() {
		return selfIntr;
	}
	public void setSelfIntr(String selfIntr) {
		this.selfIntr = selfIntr;
	}
	public String getEnrollNumber() {
		return enrollNumber;
	}
	public void setEnrollNumber(String enrollNumber) {
		this.enrollNumber = enrollNumber;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLastOnlineTime() {
		return lastOnlineTime;
	}
	public void setLastOnlineTime(String lastOnlineTime) {
		this.lastOnlineTime = lastOnlineTime;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getBigHeadPortrait() {
		return bigHeadPortrait;
	}
	public void setBigHeadPortrait(String bigHeadPortrait) {
		this.bigHeadPortrait = bigHeadPortrait;
	}
	public String getMediumHeadPortrait() {
		return mediumHeadPortrait;
	}
	public void setMediumHeadPortrait(String mediumHeadPortrait) {
		this.mediumHeadPortrait = mediumHeadPortrait;
	}
	public String getSmallHeadPortrait() {
		return smallHeadPortrait;
	}
	public void setSmallHeadPortrait(String smallHeadPortrait) {
		this.smallHeadPortrait = smallHeadPortrait;
	}
	public Integer getJifenScore() {
		return jifenScore;
	}
	public void setJifenScore(Integer jifenScore) {
		this.jifenScore = jifenScore;
	}
	public String getOptIP() {
		return optIP;
	}
	public void setOptIP(String optIP) {
		this.optIP = optIP;
	}
	public String getIfOnline() {
		return ifOnline;
	}
	public void setIfOnline(String ifOnline) {
		this.ifOnline = ifOnline;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Integer getCountSub() {
		return countSub;
	}
	public void setCountSub(Integer countSub) {
		this.countSub = countSub;
	}
	public String getAutoEject() {
		return autoEject;
	}
	public void setAutoEject(String autoEject) {
		this.autoEject = autoEject;
	}
	public String getAlterInfo() {
		return alterInfo;
	}
	public void setAlterInfo(String alterInfo) {
		this.alterInfo = alterInfo;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getIsChief() {
		return isChief;
	}
	public void setIsChief(String isChief) {
		this.isChief = isChief;
	}
	public Integer getUserInOrgNums() {
		return userInOrgNums;
	}
	public void setUserInOrgNums(Integer userInOrgNums) {
		this.userInOrgNums = userInOrgNums;
	}
	public Integer getInService() {
		return inService;
	}
	public void setInService(Integer inService) {
		this.inService = inService;
	}
	public Integer getLeaveTimeT() {
		return leaveTimeT;
	}
	public void setLeaveTimeT(Integer leaveTimeT) {
		this.leaveTimeT = leaveTimeT;
	}
	public String getLeaveTotal() {
		return leaveTotal;
	}
	public void setLeaveTotal(String leaveTotal) {
		this.leaveTotal = leaveTotal;
	}
	public Integer getOverTimeT() {
		return overTimeT;
	}
	public void setOverTimeT(Integer overTimeT) {
		this.overTimeT = overTimeT;
	}
	public String getOverTimeTotal() {
		return overTimeTotal;
	}
	public void setOverTimeTotal(String overTimeTotal) {
		this.overTimeTotal = overTimeTotal;
	}
	public Integer getLateTime() {
		return lateTime;
	}
	public void setLateTime(Integer lateTime) {
		this.lateTime = lateTime;
	}
	public Integer getLeaveEarlyTime() {
		return leaveEarlyTime;
	}
	public void setLeaveEarlyTime(Integer leaveEarlyTime) {
		this.leaveEarlyTime = leaveEarlyTime;
	}
	public Integer getUnusualTime() {
		return unusualTime;
	}
	public void setUnusualTime(Integer unusualTime) {
		this.unusualTime = unusualTime;
	}
	public Integer getAbsentTime() {
		return absentTime;
	}
	public void setAbsentTime(Integer absentTime) {
		this.absentTime = absentTime;
	}
	public String getIsView() {
		return isView;
	}
	public void setIsView(String isView) {
		this.isView = isView;
	}
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	public Integer getDefShowGrpId() {
		return defShowGrpId;
	}
	public void setDefShowGrpId(Integer defShowGrpId) {
		this.defShowGrpId = defShowGrpId;
	}
	public Integer getForMeDoUserId() {
		return forMeDoUserId;
	}
	public void setForMeDoUserId(Integer forMeDoUserId) {
		this.forMeDoUserId = forMeDoUserId;
	}
	public String getForMeDoUserName() {
		return forMeDoUserName;
	}
	public void setForMeDoUserName(String forMeDoUserName) {
		this.forMeDoUserName = forMeDoUserName;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	
}
