package com.maoguang.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maoguang.domain.Cust;
import com.maoguang.factory.BasicFactory;
import com.maoguang.service.CustService;

/**
 * Servlet implementation class CustInfoServlet
 */
@WebServlet("/servlet/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		String id=request.getParameter("id");
		Cust cust=service.findCustById(id);
		if(cust==null){
			throw new RuntimeException("找不到要修改的用户");
		}
		
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
