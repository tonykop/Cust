package com.maoguang.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.maoguang.domain.Cust;
import com.maoguang.factory.BasicFactory;
import com.maoguang.service.CustService;

/**
 * Servlet implementation class UpdateCustServlet
 */
@WebServlet("/servlet/UpdateCustServlet")
public class UpdateCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		
		try {
			//封装数据校验数据
			Cust cust=new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			String[] prefs=request.getParameterValues("preference");
			StringBuffer buffer=new StringBuffer();
			for(String pref:prefs){
				buffer.append(pref+",");
			}
			String pref=buffer.substring(0,buffer.length()-1);
			cust.setPreference(pref);
	         service.updateCust(cust);
			//response.sendRedirect(request.getContextPath()+"/listCust.jsp");
	         request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request,response);
	}

}
