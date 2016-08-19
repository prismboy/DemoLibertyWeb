/**
 * 
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;

import com.ibm.jp.sample.entity.Employee;

/**
 * @author y_akamatsu
 *
 */
public class DbSample02Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995341061494023634L;

	/**
	 * お知らせ
	 */
	private String message;

	/**
	 * 検索条件
	 */
	private String empNo;

	/**
	 * 社員情報
	 */
	private Employee entity;

	/**
	 * 
	 */
	public DbSample02Bean() {
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

	public final Employee getEntity() {
		return entity;
	}

	public final void setEntity(Employee entity) {
		this.entity = entity;
	}

}
