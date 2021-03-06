/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * デモ用サーブレットの基底クラス
 * <br><br>
 * データソースのインスタンスは、javax.annotation.Resourceアノテーションによりインジェクションしています。<br>
 * <br>
 * JNDI名：jdbc/sampleDB
 * 
 * @author y_akamatsu
 *
 */
public abstract class DemoBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * SAMPLEデータベースへのデータソース
	 */
	@Resource(name = "jdbc/sampleDB")
	protected DataSource dataSource;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoBaseServlet() {
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
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String dest, Object bean)
			throws ServletException, IOException {
		setResponseHeaders(response);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher(dest).forward(request, response);
	}

	protected boolean isEmpty(String data) {
		return data == null || "".equals(data);
	}

	protected void setResponseHeaders(HttpServletResponse response) {
		response.setHeader("cache", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
	}
}
