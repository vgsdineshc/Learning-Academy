package com.actions;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Studentclass;

/**
 * Servlet implementation class StudentclassAction
 */
public class StudentclassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentclassAction() {
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
		int suid = Integer.parseInt(actionName[1]);
		HttpSession session = request.getSession();
		session.setAttribute("actionTrigger", actionTrigger);
		session.setAttribute("suid", suid);
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		
		String redirctAction = "";
		if(actionTrigger.equals("ADDNEWSTUDENT"))
		{
			redirctAction = "/pages/studentinsert.jsp";
			actionLoadDetails.getClasses(request, response);
		}
		if(actionTrigger.equals("EDIT"));
		{
			try {
				redirctAction = actionLoadDetails.GetStudeList(request, response, suid, actionTrigger);
				actionLoadDetails.getClasses(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(actionTrigger.equals("DELETE"))
		{
			try {
				redirctAction = actionLoadDetails.DeleteStudendDetails(request, response, suid, actionTrigger);
				actionLoadDetails.GetStudeList(request,response);
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
		Studentclass studentclass = new Studentclass();
		String redirectAction = "/pages/student.jsp";
		HttpSession session = request.getSession();
		String actionTrigger = (String)session.getAttribute("actionTrigger");
		System.out.println(request.getParameter("jod")+" "+Date.valueOf(request.getParameter("jod")));
		int suid = (int) session.getAttribute("suid");
		ActionLoadDetails loadDetails = new ActionLoadDetails();
		try {
			
		studentclass.setCid(Integer.parseInt(request.getParameter("cid")));
		studentclass.setSuname(request.getParameter("suname"));
		studentclass.setSufirstname(request.getParameter("sufsname"));
		studentclass.setSulastname(request.getParameter("sulsname"));
		studentclass.setAddress(request.getParameter("address"));
		System.out.println((request.getParameter("jod")));
		studentclass.setJoineddate(Date.valueOf(request.getParameter("jod")));
		studentclass.setDob(Date.valueOf(request.getParameter("dob")));
		studentclass.setPhonenumber(Integer.parseInt(request.getParameter("phno")));
		System.out.println(studentclass);
		redirectAction = loadDetails.SAVEORUPDATESTUDENT(request,response,studentclass,actionTrigger,suid);
		loadDetails.GetStudeList(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectAction);
		dispatcher.forward(request, response);
	}

}
