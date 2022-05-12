package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JdbcConnector.DBUtils;

public class TeacherSubject {
private Integer tid;
private Integer sid;
private Integer suid;
private String teacherQuery = "select c.cname,s.sname,t.tname,t.tfirstname,t.tlastname,t.dob,t.phonenumber,t.designation,t.address from \r\n" + 
		"classes c,subtecmapping su, teacher t,subject s where su.tid=t.tid and su.sid=s.sid and su.cid=c.cid and c.cid = ?";
private String subQuery = "select c.cname,s.sname from classes c,subtecmapping su, subject s where su.sid=s.sid and su.cid=c.cid and c.cid = ?";
private String stuQuery = "select s.suid,s.suname,s.sufirstname,s.sulastname,s.dob,s.joineddate,s.phonenumber,s.cid,c.cname from student s,classes c\r\n" + 
		"where s.cid=c.cid and c.cid = ?";
public Integer getTid() {
	return tid;
}
public void setTid(Integer tid) {
	this.tid = tid;
}
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
}
public Integer getSuid() {
	return suid;
}
public void setSuid(Integer suid) {
	this.suid = suid;
}
public String getTeacherQuery() {
	return teacherQuery;
}
public void setTeacherQuery(String teacherQuery) {
	this.teacherQuery = teacherQuery;
}
public String getSubQuery() {
	return subQuery;
}
public void setSubQuery(String subQuery) {
	this.subQuery = subQuery;
}
public String getStuQuery() {
	return stuQuery;
}
public void setStuQuery(String stuQuery) {
	this.stuQuery = stuQuery;
}
@Override
public String toString() {
	return "TeacherSubject [tid=" + tid + ", sid=" + sid + ", suid=" + suid + ", teacherQuery=" + teacherQuery
			+ ", subQuery=" + subQuery + ", stuQuery=" + stuQuery + ", getTid()=" + getTid() + ", getSid()=" + getSid()
			+ ", getSuid()=" + getSuid() + ", getTeacherQuery()=" + getTeacherQuery() + ", getSubQuery()="
			+ getSubQuery() + ", getStuQuery()=" + getStuQuery() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}


public ResultSet getTeacherList(int cid) throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	System.out.println(teacherQuery);
	PreparedStatement ps = con.prepareStatement(teacherQuery);
	ps.setInt(1, cid);
	ResultSet rs = ps.executeQuery();
	return rs;
}

public ResultSet getStudentList(int cid) throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	System.out.println(stuQuery);
	PreparedStatement ps = con.prepareStatement(stuQuery);
	ps.setInt(1, cid);
	ResultSet rs = ps.executeQuery();
	return rs;
}

public ResultSet getSubList(int cid) throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	System.out.println(subQuery);
	PreparedStatement ps = con.prepareStatement(subQuery);
	ps.setInt(1, cid);
	ResultSet rs = ps.executeQuery();
	return rs;
}

}
