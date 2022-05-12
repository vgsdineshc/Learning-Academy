package com.actions;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Teacher;

/**
 * Servlet implementation class TeacherclassAction
 */
public class TeacherclassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherclassAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("actionname");
		String[] actionName = action.split("_");
		String actionTrigger = actionName[0];
		int tid = Integer.parseInt(actionName[1]);
		HttpSession session = request.getSession();
		session.setAttribute("actionTrigger", actionTrigger);
		session.setAttribute("tid", tid);
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		
		String redirctAction = "";
		if(actionTrigger.equals("ADDNEWTEACHER"))
		{
			redirctAction = "/pages/teacherinsert.jsp";
			
		}
		if(actionTrigger.equals("EDIT"));
		{
			try {
				redirctAction = actionLoadDetails.GetTeacherList(request, response, tid, actionTrigger);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(actionTrigger.equals("DELETE"))
		{
			try {
				redirctAction = actionLoadDetails.DeleteTeacherDetails(request, response, tid, actionTrigger);
				actionLoadDetails.GetTeachersList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirctAction);
		
		//classList
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		String redirectAction = "/pages/teacher.jsp";
		HttpSession session = request.getSession();
		String actionTrigger = (String)session.getAttribute("actionTrigger");
		System.out.println(request.getParameter("jod")+" "+Date.valueOf(request.getParameter("jod")));
		int tid = (int) session.getAttribute("tid");
		ActionLoadDetails loadDetails = new ActionLoadDetails();
		try {
			
			teacher.setTid(Integer.parseInt(request.getParameter("tid")));
			teacher.setTname(request.getParameter("tname"));
			teacher.setTfirstname(request.getParameter("tufsname"));
			teacher.setTlastname(request.getParameter("tulsname"));
			teacher.setAddress(request.getParameter("address"));
			System.out.println((request.getParameter("jod")));
			teacher.setJoineddate(Date.valueOf(request.getParameter("jod")));
			teacher.setDob(Date.valueOf(request.getParameter("dob")));
			teacher.setPhonenumber(Integer.parseInt(request.getParameter("phno")));
			teacher.setDesignation(request.getParameter("designation"));
			System.out.println(teacher);
			redirectAction = loadDetails.SAVEORUPDATETEACHER(request,response,teacher,actionTrigger,tid);
		loadDetails.GetTeachersList(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectAction);
		dispatcher.forward(request, response);
	}
	

}
