package com.actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.pojo.SubjectClass;

/**
 * Servlet implementation class LoadActionSubject
 */
public class LoadActionSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadActionSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionname = request.getParameter("actionname");
		System.out.println(actionname);
		String split[] = actionname.split("_");
		String action = split[0];
		int sid = Integer.parseInt(split[1]);
		System.out.println(action+"  "+sid);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		session.setAttribute("sid", sid);
		String redirectpage = "";
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		switch (action) {
		case "ADDNEWSUB":
			try {
				redirectpage = actionLoadDetails.getSubjectListSingle(sid,request,response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "EDIT":
			try {
				redirectpage = actionLoadDetails.getSubjectListSingle(sid,request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "DELETE":
			try {
				redirectpage = actionLoadDetails.DELETESUBJECT(sid, request, response);
				actionLoadDetails.GetSubjectList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectpage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sname = request.getParameter("sname");
		HttpSession httpSession = request.getSession();
		String action = (String)httpSession.getAttribute("action");
		int sid = (int)httpSession.getAttribute("sid");
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		String redirectAction = actionLoadDetails.SAVEORUPDATESUB(sid, request, response, action, sname);
		try {
			actionLoadDetails.GetSubjectList(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectAction);
		dispatcher.forward(request, response);
		
	}

}
