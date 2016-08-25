/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
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

import com.ibm.jp.sample.bean.EmployeeListBean;
import com.ibm.jp.sample.entity.Employee;
import com.ibm.jp.sample.model.EmployeeModel;

/**
 * 従業員一覧検索画面制御サーブレット<br>
 * <br>
 * データソースは共通基底サーブレットクラス(DemoBaseServlet)で定義しています。
 * 
 * @author y_akamatsu
 * @see DemoBaseServlet
 * 
 */
@WebServlet("/empList" )
public class EmployeeListServlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _DESTINATION = "/WEB-INF/jsp/employeelist.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeListBean bean = (EmployeeListBean) request.getAttribute("bean");
		if (bean == null) {
			String empNo = request.getParameter("empNo");
			if(!isEmpty(empNo)){
				doPost(request, response);
				return;
			}
			bean = new EmployeeListBean();
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
		EmployeeListBean bean = new EmployeeListBean();
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
