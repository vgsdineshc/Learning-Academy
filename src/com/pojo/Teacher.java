package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.JdbcConnector.DBUtils;

public class Teacher {
	private Integer tid;
	private String tname;
	private String tfirstname;
	private String tlastname;
	private String address;
	private Date dob;
	private Date joineddate;
	private Integer cid;
	private Integer phonenumber;
	private String designation;
	private String sqlBulk = "select * from teacher";
	private String sqlSINGLE = "select * from teacher where tid = ?";
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTfirstname() {
		return tfirstname;
	}
	public void setTfirstname(String tfirstname) {
		this.tfirstname = tfirstname;
	}
	public String getTlastname() {
		return tlastname;
	}
	public void setTlastname(String tlastname) {
		this.tlastname = tlastname;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSqlBulk() {
		return sqlBulk;
	}
	public void setSqlBulk(String sqlBulk) {
		this.sqlBulk = sqlBulk;
	}
	public String getSqlSINGLE() {
		return sqlSINGLE;
	}
	public void setSqlSINGLE(String sqlSINGLE) {
		this.sqlSINGLE = sqlSINGLE;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tfirstname=" + tfirstname + ", tlastname=" + tlastname
				+ ", address=" + address + ", dob=" + dob + ", joineddate=" + joineddate + ", cid=" + cid
				+ ", phonenumber=" + phonenumber + ", designation=" + designation + ", sqlBulk=" + sqlBulk
				+ ", sqlSINGLE=" + sqlSINGLE + ", getTid()=" + getTid() + ", getTname()=" + getTname()
				+ ", getTfirstname()=" + getTfirstname() + ", getTlastname()=" + getTlastname() + ", getAddress()="
				+ getAddress() + ", getDob()=" + getDob() + ", getJoineddate()=" + getJoineddate() + ", getCid()="
				+ getCid() + ", getPhonenumber()=" + getPhonenumber() + ", getDesignation()=" + getDesignation()
				+ ", getSqlBulk()=" + getSqlBulk() + ", getSqlSINGLE()=" + getSqlSINGLE() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public ResultSet getTeacherList () throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtils.getDBConnection();
		PreparedStatement ps = con.prepareStatement(sqlBulk);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet getTeacherList (int tid) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtils.getDBConnection();
		PreparedStatement ps = con.prepareStatement(sqlSINGLE);
		ps.setInt(1, tid);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
}
