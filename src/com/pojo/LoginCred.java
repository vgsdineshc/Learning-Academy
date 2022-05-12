package com.pojo;

public class LoginCred {

	public static String uName = "uName";
	public static String pwd = "pwd";
	public static String getuName() {
		return uName;
	}
	public static void setuName(String uName) {
		LoginCred.uName = uName;
	}
	public static String getPwd() {
		return pwd;
	}
	public static void setPwd(String pwd) {
		LoginCred.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LoginCred [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
