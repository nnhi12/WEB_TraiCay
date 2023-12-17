package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.LOAISP;
import Util.HandleException;
import Util.JDBC;

public class LoaiSPDAO {
	private static final String SELECT_LoaiSP = "SELECT * FROM loaisp";
	
	public LoaiSPDAO() {}
	
	public List<LOAISP> selectNCC() throws SQLException {
		List<LOAISP> LSPs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LoaiSP)) {

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String MaLoaiSP = rs.getString("MaLoaiSP");
                String TenLoai = rs.getString("TenLoai");
			LSPs.add(new LOAISP(MaLoaiSP, TenLoai));
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return LSPs;
	}
}
