/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * EMPLOYEE表エンティティ
 * 
 * @author y_akamatsu
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442098928084160900L;

	/**
	 * 社員番号
	 */
	private String empNo;

	/**
	 * 名
	 */
	private String firstNme;

	/**
	 * ミドルネームイニシャル
	 */
	private String midInit;

	/**
	 * 姓
	 */
	private String lastName;

	/**
	 * 所属
	 */
	private String workDept;

	/**
	 * 電話番号
	 */
	private String phoneNo;

	/**
	 * 入社日
	 */
	private Date hireDate;

	/**
	 * 職種
	 */
	private String job;

	/**
	 * 最終学歴
	 */
	private Integer edLevel;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * 生年月日
	 */
	private Date birthDate;

	/**
	 * 給与
	 */
	private BigDecimal salary;

	/**
	 * 賞与
	 */
	private BigDecimal bonus;

	/**
	 * 
	 */
	private BigDecimal comm;

	/**
	 * 
	 */
	public Employee() {
	}

	public final String getEmpNo() {
		return empNo;
	}

	public final void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public final String getFirstNme() {
		return firstNme;
	}

	public final void setFirstNme(String firstNme) {
		this.firstNme = firstNme;
	}

	public final String getMidInit() {
		return midInit;
	}

	public final void setMidInit(String midInit) {
		this.midInit = midInit;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getWorkDept() {
		return workDept;
	}

	public final void setWorkDept(String workDept) {
		this.workDept = workDept;
	}

	public final String getPhoneNo() {
		return phoneNo;
	}

	public final void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public final Date getHireDate() {
		return hireDate;
	}

	public final void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public final String getJob() {
		return job;
	}

	public final void setJob(String job) {
		this.job = job;
	}

	public final Integer getEdLevel() {
		return edLevel;
	}

	public final void setEdLevel(Integer edLevel) {
		this.edLevel = edLevel;
	}

	public final String getSex() {
		return sex;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}

	public final Date getBirthDate() {
		return birthDate;
	}

	public final void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public final BigDecimal getSalary() {
		return salary;
	}

	public final void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public final BigDecimal getBonus() {
		return bonus;
	}

	public final void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public final BigDecimal getComm() {
		return comm;
	}

	public final void setComm(BigDecimal comm) {
		this.comm = comm;
	}

}
