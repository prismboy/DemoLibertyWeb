/*
 * Bluemix Liberty for Java サンプルアプリケーション
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * ランタイムの環境変数を保持する。
 * 
 * @author y_akamatsu
 *
 */
public class EnvValsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 755016026132181429L;

	private Map<String, String> environment;

	/**
	 * 
	 */
	public EnvValsBean() {
	}

	public final Map<String, String> getEnvironment() {
		return environment;
	}

	public final void setEnvironment(Map<String, String> environment) {
		this.environment = environment;
	}

}
