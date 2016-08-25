/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.EmployeeListBean;
import com.ibm.jp.sample.bean.EmployeeDetailBean;
import com.ibm.jp.sample.model.EmployeeModel;

/**
 * 従業員詳細情報表示制御サーブレット
 * <br><br>
 * データソースは共通基底サーブレットクラス(DemoBaseServlet)で定義しています。
 * 
 * @author y_akamatsu
 * @see DemoBaseServlet
 */
@WebServlet("/empDetail")
public class EmployeeDetailServlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _DESTINATION = "/WEB-INF/jsp/employeedetail.jsp";

	/**
	 * @see DemoBaseServlet#DemoBaseServlet()
	 */
	public EmployeeDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDetailBean bean = new EmployeeDetailBean();
		bean.setMessage("");
		bean.setEmpNo(request.getParameter("searchEmpNo"));
		String empNo = request.getParameter("empNo");

		if (isEmpty(empNo)) {
			EmployeeListBean sample01Bean = new EmployeeListBean();
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
