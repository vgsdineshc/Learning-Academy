package com.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JdbcConnector.DBUtils;
import com.pojo.Classes;
import com.pojo.Studentclass;
import com.pojo.SubjectClass;
import com.pojo.Teacher;
import com.pojo.TeacherSubject;

public class ActionLoadDetails {
Connection con;
PreparedStatement ps;
	
public ArrayList<Classes> getClasses (HttpServletRequest request, HttpServletResponse response)
{
	HttpSession httpSession = request.getSession();
	Classes classes = new Classes();
	ArrayList<Classes> classList = new ArrayList<Classes>();
	try {
		ResultSet rs = classes.getClassDetails();
		
		if (rs==null)
		{
			
		}
		else
		{
			while(rs.next())
			{
				classes = new Classes();
				classes.setCid(rs.getInt(1));
				classes.setCname(rs.getString(2));
				classList.add(classes);
			}
				
			httpSession.setAttribute("classList", classList);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	return classList;
	
}

public String EDIT(int cid,HttpServletRequest request, HttpServletResponse response,String action) {
	try {
	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/EditClass.jsp";
}
public String DELETE(int cid,HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	PrintWriter pw;
	try {
		pw = response.getWriter();
		pw.print(cid);
		String sql = "delete from classes where cid = ?";
		con = DBUtils.getDBConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1,cid);
		ps.executeUpdate();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "/pages/menu.jsp";
}
public String TSACTION(int cid,HttpServletRequest request, HttpServletResponse response) throws SQLException {
	
	try {
		SubjectClass subjectClass = new SubjectClass();
		ResultSet rs = subjectClass.getSubjectList();
		ArrayList<SubjectClass> getSuList = new ArrayList<SubjectClass>();
		while(rs.next())
		{
			subjectClass = new SubjectClass();
			subjectClass.setSid(rs.getInt(1));
			subjectClass.setSname(rs.getString(2));
			getSuList.add(subjectClass);
		}
		HttpSession session = request.getSession();
		session.setAttribute("getSuList", getSuList);
		
		Teacher teacher = new Teacher();
		ResultSet rs1 = teacher.getTeacherList();
		ArrayList<Teacher> teacherclasseslist = new ArrayList<Teacher>();
			while(rs1.next()) {
			teacher = new Teacher();
			teacher.setTid(rs1.getInt(1));
			teacher.setTname(rs1.getString(2));
			teacher.setTfirstname(rs1.getString(3));
			teacher.setTlastname(rs1.getString(4));
			java.sql.Date sqlDate = new java.sql.Date(rs1.getDate(5).getTime());
	        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
	        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        teacher.setDob(utilDate);
			java.sql.Date sqlDate1 = new java.sql.Date(rs1.getDate(6).getTime());
	        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
	        teacher.setJoineddate(utilDate1);
	        teacher.setPhonenumber(rs1.getInt(7));
	        teacher.setAddress(rs1.getString(8));
	        teacher.setDesignation(rs1.getString(9));
			teacherclasseslist.add(teacher);
			}
	
		
		System.out.println(teacherclasseslist.size());
		session.setAttribute("teacherclasseslist", teacherclasseslist);
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/teachersubject.jsp";
}
public String  CRACTION(int cid,HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	System.out.println(cid);
	TeacherSubject ts = new TeacherSubject();
	Classes cs = new Classes();
	ResultSet SubjectListCR = ts.getSubList(cid);
	ResultSet StudentListCR = ts.getStudentList(cid);
	ResultSet TeacherListCR = ts.getTeacherList(cid);
	ResultSet ClassListCR = cs.getClassDetailsSingle(cid);
	HttpSession httpSession = request.getSession();
	
	//System.out.println(SubjectListCR.next()+" "+StudentListCR.next()+" "+TeacherListCR.next()+ " "+ClassListCR.next());
	//System.out.println(SubjectListCR.isBeforeFirst()+" "+StudentListCR.isBeforeFirst()+" "+TeacherListCR.isBeforeFirst()+ " "+ClassListCR.isBeforeFirst());
	//System.out.println(SubjectListCR.last()+" "+StudentListCR.last()+" "+TeacherListCR.last()+ " "+ClassListCR.last());
	
	httpSession.setAttribute("SubjectListCR1", SubjectListCR);
	httpSession.setAttribute("StudentListCR1", StudentListCR);
	httpSession.setAttribute("TeacherListCR1", TeacherListCR);
	httpSession.setAttribute("ClassListCR1", ClassListCR);
	return "/pages/classreport.jsp";
}
public String ADDNEWCLASS(int cid,HttpServletRequest request, HttpServletResponse response) {
	PrintWriter pw;
	try {
		pw = response.getWriter();
		pw.print(cid);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/EditClass.jsp";
}
	
public String SAVEORUPDATE(int cid,HttpServletRequest request, HttpServletResponse response,String action, String cName) {
	try {
	 
		String sql = "";
		con = DBUtils.getDBConnection();
		System.out.println(action+" "+cid+" "+cName);
		if(action.equals("EDIT"))
		{
			System.out.println(action+" "+cid+" "+cName);
			sql = "update classes set cname = ? where cid = ?";
			System.out.println(action+" "+cid+" "+cName+" "+sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, cName);
			ps.setInt(2, cid);
			ps.executeUpdate();
		}
		
		if(action.equals("ADDNEWCLASS"))
		{
			sql = "insert into classes (cname) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cName);
			ps.executeUpdate();
		}
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/menu.jsp";
}

public String GetStudeList(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException
{
	Studentclass studentclass = new Studentclass();
	ArrayList<Studentclass> studentclasseslist = new ArrayList<Studentclass>();
	HttpSession httpSession = request.getSession();
	ResultSet rs = studentclass.getStudentDetails();
	if(rs!=null)
	{
		while(rs.next()) {
			//s.suid,s.suname,s.sufirstname,s.sulastname,s.dob,s.joineddate,s.phonenumber,s.cid,c.cname
		studentclass = new Studentclass();
		studentclass.setSuid(rs.getInt(1));
		studentclass.setSuname(rs.getString(2));
		studentclass.setSufirstname(rs.getString(3));
		studentclass.setSulastname(rs.getString(4));
		java.sql.Date sqlDate = new java.sql.Date(rs.getDate(5).getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		studentclass.setDob(utilDate);
		java.sql.Date sqlDate1 = new java.sql.Date(rs.getDate(6).getTime());
        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
		studentclass.setJoineddate(utilDate1);
		studentclass.setPhonenumber(rs.getInt(7));
		studentclass.setCid(rs.getInt(8));
		studentclass.setCname(rs.getString(9));
		studentclass.setAddress(rs.getString(10));
		studentclasseslist.add(studentclass);
		}
		httpSession.setAttribute("studentclasseslist", studentclasseslist);
	}
	return "/pages/student.jsp";
}

public String SAVEORUPDATESTUDENT(HttpServletRequest request, HttpServletResponse response, Studentclass studentclass, String actionTrigger, int suid) throws ClassNotFoundException, SQLException
{
String sql = "";
con = DBUtils.getDBConnection();
if(actionTrigger.equals("ADDNEWSTUDENT"))
{
	sql = "insert into student (suname,sufirstname,sulastname,dob,joineddate,phonenumber,address,cid) values (?,?,?,?,?,?,?,?)";
	ps = con.prepareStatement(sql);
	ps.setString(1, studentclass.getSuname());
	ps.setString(2, studentclass.getSufirstname());
	ps.setString(3, studentclass.getSulastname());
	System.out.println(studentclass.getDob());
	ps.setDate(4, new Date(studentclass.getDob().getTime()));
	ps.setDate(5, new Date(studentclass.getJoineddate().getTime()));
	ps.setInt(6, studentclass.getPhonenumber());
	ps.setString(7, studentclass.getAddress());
	ps.setInt(8, studentclass.getCid());
}
if(actionTrigger.equals("EDIT"))
{
	sql = "update student set suname=?,sufirstname=?, sulastname =?,dob=?,joineddate=?,phonenumber=?,address=?,cid=? where suid = ? ";
	ps = con.prepareStatement(sql);
	ps.setString(1, studentclass.getSuname());
	ps.setString(2, studentclass.getSufirstname());
	ps.setString(3, studentclass.getSulastname());
	System.out.println(studentclass.getDob());
	ps.setDate(4, new Date(studentclass.getDob().getTime()));
	ps.setDate(5, new Date(studentclass.getJoineddate().getTime()));
	ps.setInt(6, studentclass.getPhonenumber());
	ps.setString(7, studentclass.getAddress());
	ps.setInt(8, studentclass.getCid());
	ps.setInt(9, suid);
		
}

try {
	
	
	ps.executeUpdate();
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return "/pages/student.jsp";
}

public String GetStudeList(HttpServletRequest request, HttpServletResponse response, int suid, String actionTrigger) throws ClassNotFoundException, SQLException {
	
	Studentclass studentclass = new Studentclass();
	ArrayList<Studentclass> studentclasseslist = new ArrayList<Studentclass>();
	HttpSession httpSession = request.getSession();
	ResultSet rs = studentclass.getStudentDetails(suid);
	if(rs!=null)
	{
		while(rs.next()) {
			//s.suid,s.suname,s.sufirstname,s.sulastname,s.dob,s.joineddate,s.phonenumber,s.cid,c.cname
		studentclass = new Studentclass();
		studentclass.setSuid(rs.getInt(1));
		studentclass.setSuname(rs.getString(2));
		studentclass.setSufirstname(rs.getString(3));
		studentclass.setSulastname(rs.getString(4));
		java.sql.Date sqlDate = new java.sql.Date(rs.getDate(5).getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		studentclass.setDob(utilDate);
		java.sql.Date sqlDate1 = new java.sql.Date(rs.getDate(6).getTime());
        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
		studentclass.setJoineddate(utilDate1);
		studentclass.setPhonenumber(rs.getInt(7));
		studentclass.setCid(rs.getInt(8));
		studentclass.setCname(rs.getString(9));
		studentclass.setAddress(rs.getString(10));
		studentclasseslist.add(studentclass);
		}
		httpSession.setAttribute("studentclasseslist", studentclasseslist);
	}
	
	return "/pages/studentinsert.jsp";
	
}

public String DeleteStudendDetails(HttpServletRequest request, HttpServletResponse response, int suid,
		String actionTrigger) throws ClassNotFoundException, SQLException {

	String sql = "delete from student where suid = ?";
	con = DBUtils.getDBConnection();
	ps = con.prepareStatement(sql);
	ps.setInt(1,suid);
	ps.executeUpdate();
	
	return "/pages/student.jsp";
}

public String GetSubjectList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
SubjectClass subjectClass = new SubjectClass();
	ResultSet rs = subjectClass.getSubjectList();
	ArrayList<SubjectClass> getSuList = new ArrayList<SubjectClass>();
	while(rs.next())
	{
		subjectClass = new SubjectClass();
		subjectClass.setSid(rs.getInt(1));
		subjectClass.setSname(rs.getString(2));
		getSuList.add(subjectClass);
	}
	HttpSession session = request.getSession();
	session.setAttribute("getSuList", getSuList);
	return "/pages/subject.jsp";
}

public String SAVEORUPDATESUB(int sid, HttpServletRequest request, HttpServletResponse response, String action,
		String sname) {
	try {
		 
		String sql = "";
		con = DBUtils.getDBConnection();
		System.out.println(action+" "+sid+" "+sname);
		if(action.equals("EDIT"))
		{
			System.out.println(action+" "+sid+" "+sname);
			sql = "update subject set sname = ? where sid = ?";
			System.out.println(action+" "+sid+" "+sname+" "+sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setInt(2, sid);
			ps.executeUpdate();
		}
		
		if(action.equals("ADDNEWSUB"))
		{
			sql = "insert into subject (sname) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.executeUpdate();
		}
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/subject.jsp";
}

public String getSubjectListSingle(int sid, HttpServletRequest request, HttpServletResponse response) throws SQLException {
	SubjectClass subjectClass = new SubjectClass();
	ResultSet rs = subjectClass.getSubjectListSingle(sid);
	ArrayList<SubjectClass> getSuList = new ArrayList<SubjectClass>();
	while(rs.next())
	{
		subjectClass = new SubjectClass();
		subjectClass.setSid(rs.getInt(1));
		subjectClass.setSname(rs.getString(2));
		getSuList.add(subjectClass);
	}
	HttpSession session = request.getSession();
	session.setAttribute("getSuList", getSuList);
	return "/pages/subjectinsert.jsp";
	
}

public String ADDNEWSUBJECT(int sid,HttpServletRequest request, HttpServletResponse response) {
	PrintWriter pw;
	try {
		pw = response.getWriter();
		pw.print(sid);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "/pages/subjectinsert.jsp";
}

public String DELETESUBJECT(int sid, HttpServletRequest request, HttpServletResponse response)throws ClassNotFoundException, SQLException {

	System.out.println(sid);
	String sql = "delete from subject where sid = ?";
	con = DBUtils.getDBConnection();
	ps = con.prepareStatement(sql);
	ps.setInt(1,sid);
	ps.executeUpdate();
	return "/pages/subject.jsp";
}

public String GetTeachersList(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

	Teacher teacher = new Teacher();
	ResultSet rs = teacher.getTeacherList();
	HttpSession httpSession = request.getSession();
	ArrayList<Teacher> teacherclasseslist = new ArrayList<Teacher>();
	if(rs!=null)
	{
		while(rs.next()) {
		teacher = new Teacher();
		teacher.setTid(rs.getInt(1));
		teacher.setTname(rs.getString(2));
		teacher.setTfirstname(rs.getString(3));
		teacher.setTlastname(rs.getString(4));
		java.sql.Date sqlDate = new java.sql.Date(rs.getDate(5).getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        teacher.setDob(utilDate);
		java.sql.Date sqlDate1 = new java.sql.Date(rs.getDate(6).getTime());
        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
        teacher.setJoineddate(utilDate1);
        teacher.setPhonenumber(rs.getInt(7));
        teacher.setAddress(rs.getString(8));
        teacher.setDesignation(rs.getString(9));
		teacherclasseslist.add(teacher);
		}
	}
		httpSession.setAttribute("teacherclasseslist", teacherclasseslist);
	return "/pages/teacher.jsp";
}

public String SAVEORUPDATETEACHER(HttpServletRequest request, HttpServletResponse response, Teacher teacher,
		String actionTrigger, int tid) throws SQLException, ClassNotFoundException {

	String sql = "";
	con = DBUtils.getDBConnection();
	if(actionTrigger.equals("ADDNEWTEACHER"))
	{
		sql = "insert into teacher (tname,tfirstname,tlastname,dob,joineddate,phonenumber,address,designation) values (?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, teacher.getTname());
		ps.setString(2, teacher.getTfirstname());
		ps.setString(3, teacher.getTlastname());
		System.out.println(teacher.getDob());
		ps.setDate(4, new Date(teacher.getDob().getTime()));
		ps.setDate(5, new Date(teacher.getJoineddate().getTime()));
		ps.setInt(6, teacher.getPhonenumber());
		ps.setString(7, teacher.getAddress());
		ps.setString(8, teacher.getDesignation());
	}
	if(actionTrigger.equals("EDIT"))
	{
		sql = "update teacher set tname=?,tfirstname=?, tlastname =?,dob=?,joineddate=?,phonenumber=?,address=?,designation=? where tid = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, teacher.getTname());
		ps.setString(2, teacher.getTfirstname());
		ps.setString(3, teacher.getTlastname());
		System.out.println(teacher.getDob());
		ps.setDate(4, new Date(teacher.getDob().getTime()));
		ps.setDate(5, new Date(teacher.getJoineddate().getTime()));
		ps.setInt(6, teacher.getPhonenumber());
		ps.setString(7, teacher.getAddress());
		ps.setString(8, teacher.getDesignation());
		ps.setInt(9, tid);
			
	}

	try {
		
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "/pages/teacher.jsp";
	}

public String DeleteTeacherDetails(HttpServletRequest request, HttpServletResponse response, int tid,
		String actionTrigger) throws ClassNotFoundException, SQLException {
	System.out.println(tid);
	String sql = "delete from teacher where tid = ?";
	con = DBUtils.getDBConnection();
	ps = con.prepareStatement(sql);
	ps.setInt(1,tid);
	ps.executeUpdate();
	return "/pages/teacher.jsp";
}

public String GetTeacherList(HttpServletRequest request, HttpServletResponse response, int tid, String actionTrigger) throws ClassNotFoundException, SQLException {
	Teacher teacher = new Teacher();
	ResultSet rs = teacher.getTeacherList(tid);
	HttpSession httpSession = request.getSession();
	ArrayList<Teacher> teacherclasseslist = new ArrayList<Teacher>();
	if(rs!=null)
	{
		while(rs.next()) {
		teacher = new Teacher();
		teacher.setTid(rs.getInt(1));
		teacher.setTname(rs.getString(2));
		teacher.setTfirstname(rs.getString(3));
		teacher.setTlastname(rs.getString(4));
		java.sql.Date sqlDate = new java.sql.Date(rs.getDate(5).getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        teacher.setDob(utilDate);
		java.sql.Date sqlDate1 = new java.sql.Date(rs.getDate(6).getTime());
        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
        teacher.setJoineddate(utilDate1);
        teacher.setPhonenumber(rs.getInt(7));
        teacher.setAddress(rs.getString(8));
        teacher.setDesignation(rs.getString(9));
		teacherclasseslist.add(teacher);
		}
	}
		httpSession.setAttribute("teacherclasseslist", teacherclasseslist);
	return "/pages/teacherinsert.jsp";
}

public String  SAVEORUPDATETEACHERSUBJECTMAPPING(HttpServletRequest request, HttpServletResponse response, int suid,
		int tid, int cid) throws ClassNotFoundException, SQLException {
Connection con = DBUtils.getDBConnection();	
String sql = "insert into subtecmapping (cid,tid,sid) values(?,?,?)";
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1, cid);
ps.setInt(2, tid);
ps.setInt(3, suid);
ps.executeUpdate();
return "/pages/menu.jsp";
}



}
