package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.model.DatabaseSysdateModel;

/**
 * Servlet implementation class DatabaseSysdateServlet
 */
@WebServlet("/dbSysdate")
public class DatabaseSysdateServlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see DemoBaseServlet#DemoBaseServlet()
	 */
	public DatabaseSysdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = null;
		try {
			date = DatabaseSysdateModel.getSysdate(dataSource);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		request.setAttribute("bean", date);
		rendar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void rendar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		setResponseHeaders(response);
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Database System date</title></head>");
		pw.print("<body><br><br>");
		Object obj = request.getAttribute("bean");
		pw.print(obj != null ? obj.toString() : "null");
		pw.println("<br><br><a href=\"javascript:history.back();\">Back to Index</a>");
		pw.println("</body></html>");
		pw.flush();
		pw.close();
	}
}
