package com.bridgelabz.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description="Login Servlet Testing",
		urlPatterns= {"/LoginServlet"},
				initParams= {
						@WebInitParam(name="user",value="kshitija"),
						@WebInitParam(name="password",value="Kshitija")
				}
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
			String user=request.getParameter("user");
			String password=request.getParameter("password");
			
			String userID=getServletConfig().getInitParameter(user);
			String pass=getServletConfig().getInitParameter(password);
			if(userID.equals(user)&& pass.equals(password)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoinSuccess.jsp").forward(request,response);
	}else {
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
		PrintWriter out=response.getWriter();
		out.println("<font color=red>either user name or password is wrong,</font>");
		rd.include(request,response);
	}
	}

}
