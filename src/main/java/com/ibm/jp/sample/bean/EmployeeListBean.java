/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;
import java.util.List;

import com.ibm.jp.sample.entity.Employee;

/**
 * 従業員一覧検索画面用Beanクラス<br>
 * <br>
 * 
 * @author y_akamatsu
 *
 */
public class EmployeeListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7985075847603752257L;

	/**
	 * お知らせ
	 */
	private String message;

	/**
	 * 検索条件
	 */
	private String empNo;

	/**
	 * 検索結果一覧
	 */
	private List<Employee> list;

	/**
	 * 
	 */
	public EmployeeListBean() {
		// TODO Auto-generated constructor stub
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

	public final String getEmpNo() {
		return empNo;
	}

	public final void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public final List<Employee> getList() {
		return list;
	}

	public final void setList(List<Employee> list) {
		this.list = list;
	}

}
