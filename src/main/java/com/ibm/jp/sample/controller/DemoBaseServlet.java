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

	private void setResponseHeaders(HttpServletResponse response) {
		response.setHeader("cache", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
	}
}
