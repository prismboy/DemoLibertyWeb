/**
 * 
 */
package com.ibm.jp.sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

/**
 * @author y_akamatsu
 *
 */
public class DatabaseSysdateModel {

	/**
	 * 
	 */
	private DatabaseSysdateModel() {
		// TODO Auto-generated constructor stub
	}

	public static Date getSysdate(DataSource datasource) throws SQLException {
		Connection connection = datasource.getConnection();
		java.sql.Date date = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM SYSIBM.SYSDUMMY1");
			rs.next();
			date = rs.getDate(1);
			rs.close();
			stmt.close();
		} finally {
			connection.close();
		}
		return date;
	}
}
