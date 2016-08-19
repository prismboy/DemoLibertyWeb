package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.entity.EmpPhoto;
import com.ibm.jp.sample.model.EmpPhotoModel;

/**
 * Servlet implementation class EmpPhotoServlet
 */
@WebServlet({ "/EmpPhotoServlet", "/getPhoto" })
public class EmpPhotoServlet extends DemoBaseServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> mimeMap = new TreeMap<String, String>();

	private ServletContext servletContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpPhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		mimeMap.put("bitmap", "image/x-bmp");
		mimeMap.put("gif", "image/gif");
		mimeMap.put("png", "image/png");
		servletContext = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empNo = request.getParameter("empNo");

		if (!isEmpty(empNo)) {
			try {
				EmpPhotoModel model = EmpPhotoModel.getInstance(dataSource);
				EmpPhoto empPhoto = model.getPhoto(empNo);
				if (isEmpty(empPhoto.getMimeType())) {
					putNoImage(response);
				} else {
					putEmpPhoto(response, empPhoto);
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		} else {
			putNoImage(response);
		}
	}

	private void putEmpPhoto(HttpServletResponse response, EmpPhoto empPhoto) throws IOException {
		response.setContentType(mimeMap.get(empPhoto.getMimeType()));
		byte[] buf = empPhoto.getPhoto().toByteArray();
		response.setContentLength(buf.length);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(buf, 0, buf.length);
		sos.flush();
		sos.close();
	}

	private void putNoImage(HttpServletResponse response) throws IOException {
		response.setContentType(mimeMap.get("png"));
		InputStream is = servletContext.getResourceAsStream("/images/no_image.png");
		ServletOutputStream sos = response.getOutputStream();
		byte[] buf = new byte[256];
		int reads = 0;
		while ((reads = is.read(buf, 0, 256)) > 0) {
			sos.write(buf, 0, reads);
		}
		sos.flush();
		sos.close();
		is.close();
	}
}
