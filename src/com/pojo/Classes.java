package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JdbcConnector.DBUtils;

public class Classes {
private Integer cid;
private String cname;
private static String classQuery = "select * from classes";
private static String classQuerySingle = "select * from classes where cid = ?";


public static String getClassQuery() {
	return classQuery;
}
public static void setClassQuery(String classQuery) {
	Classes.classQuery = classQuery;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

public ResultSet getClassDetails() throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	PreparedStatement preparedStatement = con.prepareStatement(Classes.getClassQuery());
	ResultSet rs = preparedStatement.executeQuery();
	return rs;
}

public ResultSet getClassDetailsSingle(int cid) throws ClassNotFoundException, SQLException
{
	Connection con = DBUtils.getDBConnection();
	PreparedStatement preparedStatement = con.prepareStatement(Classes.classQuerySingle);
	preparedStatement.setInt(1, cid);
	ResultSet rs = preparedStatement.executeQuery();
	return rs;
}
@Override
public String toString() {
	return "Classes [cid=" + cid + ", cname=" + cname + ", getCid()=" + getCid() + ", getCname()=" + getCname()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}


}
