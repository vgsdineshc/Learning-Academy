package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.JdbcConnector.DBUtils;
import com.pojo.Classes;

public class Studentclass {
private Integer suid;
private String suname;
private String sufirstname;
private String sulastname;
private String address;
private Date dob;
private Date joineddate;
private Integer cid;
private Integer phonenumber;
private String cname;
private String studentQuery = "select s.suid,s.suname,s.sufirstname,s.sulastname,s.dob,s.joineddate,s.phonenumber,s.cid,c.cname,s.address from student s,classes c where s.cid=c.cid";
private String studentQuerySuID = "select s.suid,s.suname,s.sufirstname,s.sulastname,s.dob,s.joineddate,s.phonenumber,s.cid,c.cname,s.address from student s,classes c where s.cid=c.cid and s.suid = ?";



public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getStudentQuery() {
	return studentQuery;
}
public void setStudentQuery(String studentQuery) {
	this.studentQuery = studentQuery;
}
public Integer getSuid() {
	return suid;
}
public void setSuid(Integer suid) {
	this.suid = suid;
}
public String getSuname() {
	return suname;
}
public void setSuname(String suname) {
	this.suname = suname;
}
public String getSufirstname() {
	return sufirstname;
}
public void setSufirstname(String sufirstname) {
	this.sufirstname = sufirstname;
}
public String getSulastname() {
	return sulastname;
}
public void setSulastname(String sulastname) {
	this.sulastname = sulastname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public Date getJoineddate() {
	return joineddate;
}
public void setJoineddate(Date joineddate) {
	this.joineddate = joineddate;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public Integer getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(Integer phonenumber) {
	this.phonenumber = phonenumber;
}

public ResultSet getStudentDetails() throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	PreparedStatement preparedStatement = con.prepareStatement(studentQuery);
	ResultSet rs = preparedStatement.executeQuery();
	return rs;
}
public ResultSet getStudentDetails(int suid2) throws ClassNotFoundException, SQLException{
	Connection con = DBUtils.getDBConnection();
	PreparedStatement preparedStatement = con.prepareStatement(studentQuerySuID);
	preparedStatement.setInt(1, suid2);
	ResultSet rs = preparedStatement.executeQuery();
	// TODO Auto-generated method stub
	return rs;
}
}
