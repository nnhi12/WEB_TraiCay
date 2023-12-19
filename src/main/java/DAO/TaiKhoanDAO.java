package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.TAIKHOAN;
import Util.HandleException;
import Util.JDBC;

public class TaiKhoanDAO {
	private static final String SELECT_TAIKHOAN = "SELECT TaiKhoan, MatKhau FROM taikhoan WHERE MaTaiKhoan = ?";
	
	public TaiKhoanDAO() {}
	
	public TAIKHOAN layThongTinTaiKhoang(String MaTK) {
		TAIKHOAN tk = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAIKHOAN)) {
				preparedStatement.setString(1, MaTK);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					String taikhoan = rs.getString("TaiKhoan");
	                String matkhau = rs.getString("MatKhau");
					tk = new TAIKHOAN(taikhoan, matkhau);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return tk;
	}
}
