package com.ziv.bean;

public class Score {
	private Integer Score;
	private Integer SCid;
	private String Sid;
	private String Cid;

	public Integer getScore(){
		return Score;
	}
	public void setScore(Integer Score){
		this.Score = Score;
	}
	public Integer getSCid(){
		return SCid;
	}
	public void setSCid(Integer SCid){
		this.SCid = SCid;
	}
	public String getSid(){
		return Sid;
	}
	public void setSid(String Sid){
		this.Sid = Sid;
	}
	public String getCid(){
		return Cid;
	}
	public void setCid(String Cid){
		this.Cid = Cid;
	}
}
