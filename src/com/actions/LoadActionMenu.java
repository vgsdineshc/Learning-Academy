package com.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Classes;

/**
 * Servlet implementation class Adminlogin
 */
public class LoadActionMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement preparedStatement = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadActionMenu() {
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
		
		//classes
		ArrayList<Classes> classList = new ArrayList<Classes>();
		ActionLoadDetails loadDetails = new ActionLoadDetails();
		classList = loadDetails.getClasses(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/menu.jsp");
		dispatcher.forward(request, response);
		//}
	}

}
