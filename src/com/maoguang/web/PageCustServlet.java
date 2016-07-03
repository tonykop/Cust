package com.maoguang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maoguang.domain.Cust;
import com.maoguang.domain.Page;
import com.maoguang.factory.BasicFactory;
import com.maoguang.service.CustService;

/**
 * Servlet implementation class PageCustServlet
 */
@WebServlet("/servlet/PageCustServlet")
public class PageCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		int thispage=Integer.parseInt(request.getParameter("thispage"));
		int rowperpage=5;
	  Page page=service.pageCust(thispage,rowperpage);
	   request.setAttribute("page", page);
	   request.getRequestDispatcher("/pageList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
