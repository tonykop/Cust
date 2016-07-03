package com.maoguang.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maoguang.factory.BasicFactory;
import com.maoguang.service.CustService;

/**
 * Servlet implementation class BatchDelServlet
 */
@WebServlet("/servlet/BatchDelServlet")
public class BatchDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		String [] ids=request.getParameterValues("delId");
		service.batchDel(ids);
		//request.getRequestDispatcher("/servlet/ListCustServlet.jsp").forward(request, response);
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
