package com.actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SavesubjectTeacherMap
 */
public class SavesubjectTeacherMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavesubjectTeacherMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int suid = Integer.parseInt(request.getParameter("suid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println(suid+" "+tid+" "+cid);
		String redirecAction = "";
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		try {
			 redirecAction = actionLoadDetails.SAVEORUPDATETEACHERSUBJECTMAPPING(request,response,suid,tid,cid);
			actionLoadDetails.getClasses(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirecAction);
		dispatcher.forward(request, response);
	}

}
