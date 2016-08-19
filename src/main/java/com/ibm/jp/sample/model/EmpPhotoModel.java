/**
 * 
 */
package com.ibm.jp.sample.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ibm.jp.sample.entity.EmpPhoto;

/**
 * @author y_akamatsu
 *
 */
public class EmpPhotoModel {
	private static int _BUFFER_SIZE = 256;
	private Connection connection;

	/**
	 * 社員写真データ
	 */
	private EmpPhoto empPhoto;

	/**
	 * 
	 */
	private EmpPhotoModel() {
	}

	public static EmpPhotoModel getInstance(DataSource dataSource) throws SQLException {
		EmpPhotoModel model = new EmpPhotoModel();
		model.setConnection(dataSource.getConnection());
		return model;
	}

	public EmpPhoto getPhoto(String empNo) throws SQLException, IOException {
		empPhoto = new EmpPhoto();
		empPhoto.setEmpNo(empNo);
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select PHOTO_FORMAT, PICTURE from emp_photo where EMPNO = ?");
			pstmt.setString(1, empNo);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) return empPhoto;
			empPhoto.setMimeType(rs.getString(1));
			InputStream is = rs.getBinaryStream(2);
			ByteArrayOutputStream photo = new ByteArrayOutputStream();
			byte[] buf = new byte[256];
			int reads;
			while ((reads = is.read(buf, 0, _BUFFER_SIZE)) > 0) {
				photo.write(buf, 0, reads);
			}
			is.close();
			photo.close();
			empPhoto.setPhoto(photo);
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

		return empPhoto;
	}

	public final EmpPhoto getEmpPhoto() {
		return empPhoto;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
