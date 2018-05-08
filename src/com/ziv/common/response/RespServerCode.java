package com.ziv.common.response;

public enum RespServerCode {
	
	SUCCESS(1,"SUCCESS"),
	ERROR(0,"SUCCESS");
	
	private final int code;
	private final String dsec;
	public int getCode() {
		return code;
	}
	public String getDsec() {
		return dsec;
	}
	RespServerCode(int code , String desc){
		this.code = code;
		this.dsec = desc;
	}
	
}
