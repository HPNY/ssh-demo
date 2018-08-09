package com.mybank.fundtrans.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.domain.Fund;

/**
 * Servlet implementation class FundServlet
 */
@WebServlet("/FundServlet")
public class FundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		FundDao fundDao=new FundDaoJDBCImpl();
		String flag=request.getParameter("flag");
		switch (flag) {
		case "1":
			String fundName=request.getParameter("fundName");
			String fundStatus=request.getParameter("fundStatus");
			Double fundPrice=Double.parseDouble(request.getParameter("fundPrice"));
			String fundDes=request.getParameter("fundDes");
			Fund fund=new Fund();
			fund.setName(fundName);
			fund.setDescription(fundDes);
			fund.setPrice(fundPrice);
			fund.setStatus(fundStatus);
			fund.setCreateTime(new Date());
			fundDao.insert(fund);
			List funds1=fundDao.findAll();
			request.setAttribute("fundList", funds1);
			request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response);
			break;
		case "2":
			request.getRequestDispatcher("fund/fund_add.jsp").forward(request, response);
			break;
		case "3":
			List funds=fundDao.findAll();
			request.setAttribute("fundList", funds);
			request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response);
			break;
		case "4":
			String fundId=request.getParameter("id");
			request.getRequestDispatcher("fund/fund_update.jsp?id="+fundId).forward(request, response);
			break;
		case "5":
			String fundName1=request.getParameter("fundName");
			String fundStatus1=request.getParameter("fundStatus");
			Double fundPrice1= Double.parseDouble(request.getParameter("fundPrice"));
			String fundDes1=request.getParameter("fundDes");
			Integer fundId1= Integer.parseInt(request.getParameter("id"));
			Fund fund1= new Fund();
			fund1.setId(fundId1);
			fund1.setName(fundName1);
			fund1.setDescription(fundDes1);
			fund1.setPrice(fundPrice1);
			fund1.setStatus(fundStatus1);
			fund1.setCreateTime(new Date());
			fundDao.update(fund1);
			List funds2=fundDao.findAll();
			request.setAttribute("fundList",funds2);
			request.getRequestDispatcher("fund/fund_list.jsp").forward(request,response);
			break;
		case "6":
			Integer fundId2= Integer.parseInt(request.getParameter("id"));
			fundDao.delete(fundId2);
			List funds3=fundDao.findAll();
			request.setAttribute("fundList",funds3);
			request.getRequestDispatcher("fund/fund_list.jsp").forward(request,response);
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
