package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
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
	private SimpleDateFormat sdf;

	/**
	 * @see DemoBaseServlet#DemoBaseServlet()
	 */
	public DatabaseSysdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS zZ");
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
			String formatedDate = sdf.format(date);
			request.setAttribute("bean", formatedDate);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
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
		pw.print("<body><br><br><b>");
		Object obj = request.getAttribute("bean");
		pw.print(obj != null ? obj.toString() : "null");
		pw.println("</b><br><br><a href=\"javascript:history.back();\">Back to Index</a>");
		pw.println("</body></html>");
		pw.flush();
		pw.close();
	}
}
