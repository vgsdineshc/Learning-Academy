package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JdbcConnector.DBUtils;

public class SubjectClass {

	private Integer sid;
	private String sname;
	private String sqlSelect = "select * from subject"; 
	private String sqlSelectSingle = "select * from subject where sid = ?";
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSqlSelect() {
		return sqlSelect;
	}
	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}
	public String getSqlSelectSingle() {
		return sqlSelectSingle;
	}
	public void setSqlSelectSingle(String sqlSelectSingle) {
		this.sqlSelectSingle = sqlSelectSingle;
	}
	@Override
	public String toString() {
		return "SubjectClass [sid=" + sid + ", sname=" + sname + ", sqlSelect=" + sqlSelect + ", sqlSelectSingle="
				+ sqlSelectSingle + "]";
	}
	
	public ResultSet getSubjectList()
	{
		try {
			connection = DBUtils.getDBConnection();
			ps = connection.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet getSubjectListSingle(int sid2) {
		try {
			connection = DBUtils.getDBConnection();
			ps = connection.prepareStatement(sqlSelectSingle);
			ps.setInt(1, sid2);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
}
