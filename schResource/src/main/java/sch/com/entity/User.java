package sch.com.entity;

import java.io.Serializable;

/**
 * �û�ʵ����
 * @author yang
 *
 */
public class User{
	private Integer UserId;
	private String userName;
	private String userPwd;
	private String UserRealName;//�û���ʵ����
	private int majorId;//רҵ�γ�ID
	private int userStatus;//�û�״̬
	private String arr;
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRealName() {
		return UserRealName;
	}
	public void setUserRealName(String userRealName) {
		UserRealName = userRealName;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", userPwd=" + userPwd + ", UserRealName="
				+ UserRealName + ", majorId=" + majorId + ", userStatus=" + userStatus + ", arr=" + arr + "]";
	}
	
}
