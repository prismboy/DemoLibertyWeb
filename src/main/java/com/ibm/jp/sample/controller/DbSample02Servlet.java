package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.DbSample01Bean;
import com.ibm.jp.sample.bean.DbSample02Bean;
import com.ibm.jp.sample.model.EmployeeModel;

/**
 * Servlet implementation class DbSample02Servlet
 */
@WebServlet({ "/DbSample02Servlet", "/sample02" })
public class DbSample02Servlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _DESTINATION = "/WEB-INF/jsp/sample02.jsp";

	/**
	 * @see DemoBaseServlet#DemoBaseServlet()
	 */
	public DbSample02Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbSample02Bean bean = new DbSample02Bean();
		bean.setMessage("");
		bean.setEmpNo(request.getParameter("searchEmpNo"));
		String empNo = request.getParameter("empNo");

		if (isEmpty(empNo)) {
			DbSample01Bean sample01Bean = new DbSample01Bean();
			sample01Bean.setMessage("従業員番号は必須です。");
			sample01Bean.setEmpNo(bean.getEmpNo());
			forward(request, response, "/sample01", sample01Bean);
			return;
		}

		try {
			EmployeeModel model = EmployeeModel.getInstance(dataSource);
			bean.setEntity(model.getEmpInfo(empNo));
			forward(request, response, _DESTINATION, bean);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
