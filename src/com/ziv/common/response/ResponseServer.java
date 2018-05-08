package com.ziv.common.response;

import java.io.Serializable;

public class ResponseServer<T> implements Serializable{
	
	private static final long serialVersionUID = -8443931766979227423L;
	
	private int stats;
	private String msg;
	private T data;
	
	public ResponseServer(String msg, T data) {
		this.msg = msg;
		this.data =data;
	}
	
	public ResponseServer(T data) {
		this.data =data;
	}
	
	public ResponseServer(int stats,String msg, T data) {
		this.stats = stats;
		this.msg = msg;
		this.data =data;
	}
	
	public ResponseServer(int stats,String msg) {
		this.stats = stats;
		this.msg = msg;
	}
	
	public int getStats() {
		return stats;
	}
	public String getMsg() {
		return msg;
	}
	public T getData() {
		return data;
	}
	
	public static <T> ResponseServer<T> successMsg(String msg){
		return new ResponseServer<T>(RespServerCode.SUCCESS.getCode(),msg);
	}
	
	public static <T> ResponseServer<T> successMsg(T data){
		return new ResponseServer<T>(data);
	}
	
	public static <T> ResponseServer<T> successMsg(String msg,T data){
		return new ResponseServer<T>(RespServerCode.SUCCESS.getCode(),msg,data);
	}
	
	public static <T> ResponseServer<T> errorMsg(String msg){
		return new ResponseServer<T>(RespServerCode.ERROR.getCode(),msg);
	}
	
	public static <T> ResponseServer<T> errorMsg(String msg,T data){
		return new ResponseServer<T>(RespServerCode.ERROR.getCode(),msg,data);
	}
	public void toStringSelf() {
		System.out.println("ResponseServer [stats=" + stats + ", msg=" + msg + ", data="
				+ data + "]");
	}
}
