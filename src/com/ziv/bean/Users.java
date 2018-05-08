package com.ziv.bean;

public class Users {
	private String UserName;
	private Integer Powers;
	private String Password;

	public String getUserName(){
		return UserName;
	}
	public void setUserName(String UserName){
		this.UserName = UserName;
	}
	public Integer getPowers(){
		return Powers;
	}
	public void setPowers(Integer Powers){
		this.Powers = Powers;
	}
	public String getPassword(){
		return Password;
	}
	public void setPassword(String Password){
		this.Password = Password;
	}
}
