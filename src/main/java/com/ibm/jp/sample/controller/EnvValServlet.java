/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.EnvValsBean;

/**
 * 環境変数表示制御サーブレット<br>
 * <br>
 * Bluemix Liberty for Javaランタイムの環境変数を表示する。
 * 
 * @author y_akamatsu
 */
@WebServlet("/env")
public class EnvValServlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _DESTINATION = "/WEB-INF/jsp/env-val.jsp";
       
    /**
     * @see DemoBaseServlet#DemoBaseServlet()
     */
    public EnvValServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnvValsBean bean = new EnvValsBean();
		bean.setEnvironment(System.getenv());

		request.setAttribute("bean", bean);
		request.getRequestDispatcher(_DESTINATION).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
