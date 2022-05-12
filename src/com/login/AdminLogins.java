package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.LoginCred;

/**
 * Servlet Filter implementation class AdminLogins
 */
public class AdminLogins implements Filter {

	
    /**
     * Default constructor. 
     */
    public AdminLogins() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
		PrintWriter pw=response.getWriter();
		String uName = request.getParameter(LoginCred.uName);
		String pwd = request.getParameter(LoginCred.pwd);
		
		session.setAttribute(LoginCred.uName, uName);
		session.setAttribute(LoginCred.pwd, pwd);
		
		if(request.getParameter(LoginCred.getuName()).equals(request.getParameter(LoginCred.getPwd()))) {
			System.out.println("filter authentication passed ");
			chain.doFilter(request, response);//it goes to the web.xml file and go to the url patter
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
			dispatcher.include(request, response);
			pw.print("check the credentials");
		}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
