package com.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JdbcConnector.DBUtils;
import com.pojo.Classes;

/**
 * Servlet implementation class LoadActionClasses
 */
public class LoadActionClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement preparedStatement = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadActionClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionName = request.getParameter("actionname");
		ActionLoadDetails actionLoadDetails = new ActionLoadDetails();
		String[] actionNameArray = actionName.split("_");
		String action= actionNameArray[0];
		int cid= Integer.parseInt(actionNameArray[1]);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("cid", cid);
		httpSession.setAttribute("action", action);
		String redirectPage = "";
		try {
		  switch (action) 
		  { 
		  case "EDIT": 
			  redirectPage = actionLoadDetails.EDIT(cid,request,response,action); break; 
		  case "DELETE":
			  redirectPage = actionLoadDetails.DELETE(cid,request,response); 
			  actionLoadDetails.getClasses(request, response);
		  break; 
		  case "TSACTION":redirectPage = actionLoadDetails.TSACTION(cid,request,response); break; 
		  case "CRACTION":redirectPage = actionLoadDetails.CRACTION(cid,request,response); break; 
		  case "ADDNEWCLASS": 
			  redirectPage=actionLoadDetails.ADDNEWCLASS(cid,request,response); break; 
		  }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session = request.getSession(); 
		  System.out.println(session.getAttribute("cid")+ " "+request.getParameter("cName")+" "+session.getAttribute("action"));
		  int cid = Integer.parseInt(""+session.getAttribute("cid"));
		  String action = ""+session.getAttribute("action");
		  String cName = request.getParameter("cName");
		  ArrayList<Classes> classList = new ArrayList<Classes>();
		  ActionLoadDetails loadDetails = new ActionLoadDetails();
		  loadDetails.SAVEORUPDATE(cid, request, response, action,cName);
		  classList = loadDetails.getClasses(request, response);
		  RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/menu.jsp"); 
		  dispatcher.forward(request,response);
		 
	}
	

}
