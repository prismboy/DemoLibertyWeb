package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.DbSample01Bean;
import com.ibm.jp.sample.entity.Employee;
import com.ibm.jp.sample.model.EmployeeModel;

/**
 * Servlet implementation class DbSample01Servlet
 */
@WebServlet({ "/DbSample01Servlet", "/sample01" })
public class DbSample01Servlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _DESTINATION = "/WEB-INF/jsp/sample01.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DbSample01Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbSample01Bean bean = (DbSample01Bean) request.getAttribute("bean");
		if (bean == null) {
			String empNo = request.getParameter("empNo");
			if(!isEmpty(empNo)){
				doPost(request, response);
				return;
			}
			bean = new DbSample01Bean();
			bean.setMessage("");
			bean.setEmpNo("");
			bean.setList(new ArrayList<Employee>());
		}
		forward(request, response, _DESTINATION, bean);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empNo = request.getParameter("empNo");
		DbSample01Bean bean = new DbSample01Bean();
		if (isEmpty(empNo)) {
			bean.setMessage("検索条件が未入力です。");
			bean.setEmpNo("");
			forward(request, response, _DESTINATION, bean);
			return;
		} else {
			bean.setMessage("");
			bean.setEmpNo(empNo);
		}

		try {
			EmployeeModel model = EmployeeModel.getInstance(dataSource);
			bean.setList(model.listEmployee(empNo));
			if(bean.getList().size()==0){
				bean.setMessage("検索条件を変更してください。");
			} else if(bean.getList().size()>20) {
				bean.setMessage("ヒット件数が制限を超えました。検索条件を変更してください。");
			}
			forward(request, response, _DESTINATION, bean);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
