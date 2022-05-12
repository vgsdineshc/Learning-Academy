package com.actions;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Classes;

/**
 * Servlet implementation class TopMenuActions
 */
public class TopMenuActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopMenuActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("actionMenu");
		System.out.println(action);
		String redirectAction = "";
		ActionLoadDetails loadDetails = new ActionLoadDetails();
		try
		{
		switch (action) {
		case "CL":
			ArrayList<Classes> classList = new ArrayList<Classes>();
			classList = loadDetails.getClasses(request, response);
			redirectAction = "/pages/menu.jsp";
			break;
		case "SL":
			redirectAction = loadDetails.GetStudeList(request,response);
			break;
		case "SUL":
			redirectAction = loadDetails.GetSubjectList(request,response);
			break;
			
		case "TL":
			redirectAction = loadDetails.GetTeachersList(request,response);
			break;

		default:
			break;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectAction);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
