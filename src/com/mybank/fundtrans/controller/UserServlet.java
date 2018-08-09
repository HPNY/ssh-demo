package com.mybank.fundtrans.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybank.fundtrans.dao.UserDao;
import com.mybank.fundtrans.dao.UserDaoJDBCImpl;
import com.mybank.fundtrans.domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		UserDao userDao=new UserDaoJDBCImpl();
		switch (flag) {
		case "1":
			String userName = request.getParameter("loginUser");
			String userPassword = request.getParameter("loginPassword");
			User user = userDao.login(userName, userPassword);
			if(user==null){
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
		case "2":
			request.getSession().removeAttribute("user");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
