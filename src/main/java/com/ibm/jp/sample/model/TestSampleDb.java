/**
 * 
 */
package com.ibm.jp.sample.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author y_akamatsu
 *
 */
public class TestSampleDb {
	// テスト用コード
	private static final String _CLASS_NAME = "com.ibm.db2.jcc.DB2Driver";
	private static final String _URL = "jdbc:db2://localhost:51000/sample";
	private static final String _USER = "db2inst1";
	private static final String _PASSWD = "db2inst1";
	// テスト用コード

	/**
	 * 
	 */
	public TestSampleDb() {
		// TODO Auto-generated constructor stub
	}

	// テスト用コード
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("SAMPLEデータベースの表を指定してください。");
			System.exit(9);
		}

		TestSampleDb model = new TestSampleDb();

		try {
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + args[0]);
			model.describe(rs.getMetaData());
			rs.close();
			stmt.close();
			con.rollback();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void describe(ResultSetMetaData rsmd) throws Exception {
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			String columnName = rsmd.getColumnName(i);
			String columnType = rsmd.getColumnTypeName(i);
			System.out.println(i + "¥t" + columnName + "¥t" + columnType);
		}
	}

	private static Connection connect() throws Exception {
		DriverManager.registerDriver((Driver) Class.forName(_CLASS_NAME).newInstance());
		Connection con = DriverManager.getConnection(_URL, _USER, _PASSWD);
		con.setAutoCommit(false);
		return con;

	}
}
