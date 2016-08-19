/**
 * 
 */
package com.ibm.jp.sample.entity;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * 
 * @author y_akamatsu
 *
 */
public class EmpPhoto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7755494533015656409L;

	/**
	 * 社員番号
	 */
	private String empNo;

	/**
	 * 画像フォーマット
	 */
	private String mimeType;

	/**
	 * 画像データ
	 */
	private ByteArrayOutputStream photo;

	public EmpPhoto() {
		// TODO Auto-generated constructor stub
	}

	public final String getEmpNo() {
		return empNo;
	}

	public final void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public final String getMimeType() {
		return mimeType;
	}

	public final void setMimeType(String photoFormat) {
		this.mimeType = photoFormat;
	}

	public final ByteArrayOutputStream getPhoto() {
		return photo;
	}

	public final void setPhoto(ByteArrayOutputStream photo) {
		this.photo = photo;
	}

}
