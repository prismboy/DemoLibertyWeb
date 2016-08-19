package com.ibm.jp.sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ibm.jp.sample.entity.Employee;

/**
 * EMPLOYEE表を検索するロジッククラス
 * 
 * @author y_akamatsu
 *
 */
public class EmployeeModel {
	private Connection connection;

	private EmployeeModel() {
	}

	public static EmployeeModel getInstance(DataSource dataSource) throws SQLException {
		EmployeeModel model = new EmployeeModel();
		model.setConnection(dataSource.getConnection());
		return model;
	}

	public List<Employee> listEmployee(String empNo) throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		String cond = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT EMPNO,FIRSTNME,LASTNAME,HIREDATE FROM EMPLOYEE");
			if (empNo != null && !"".equals(empNo)) {
				sb.append(" WHERE EMPNO ");
				if (empNo.contains("*")) {
					sb.append("LIKE ?");
					cond = empNo.replaceAll("\\*", "%");
				} else {
					sb.append("= ?");
				}
			}
			if (cond!=null) {
				empNo = cond;
			}
			PreparedStatement pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, empNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				Employee employee = new Employee();
				employee.setEmpNo(rs.getString(++i));
				employee.setFirstNme(rs.getString(++i));
				employee.setLastName(rs.getString(++i));
				employee.setHireDate(rs.getDate(++i));
				list.add(employee);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}

		return list;
	}

	public Employee getEmpInfo(String empNo) throws SQLException {
		Employee bean = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO,HIREDATE,JOB,EDLEVEL,SEX,BIRTHDATE,SALARY,BONUS,COMM FROM EMPLOYEE WHERE EMPNO = ?");
			pstmt.setString(1, empNo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Employee();
				int i = 0;
				bean.setEmpNo(rs.getString(++i));
				bean.setFirstNme(rs.getString(++i));
				bean.setMidInit(rs.getString(++i));
				bean.setLastName(rs.getString(++i));
				bean.setWorkDept(rs.getString(++i));
				bean.setPhoneNo(rs.getString(++i));
				bean.setHireDate(rs.getDate(++i));
				bean.setJob(rs.getString(++i));
				bean.setEdLevel(rs.getInt(++i));
				bean.setSex(rs.getString(++i));
				bean.setBirthDate(rs.getDate(++i));
				bean.setSalary(rs.getBigDecimal(++i));
				bean.setBonus(rs.getBigDecimal(++i));
				bean.setComm(rs.getBigDecimal(++i));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}

		return bean;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
