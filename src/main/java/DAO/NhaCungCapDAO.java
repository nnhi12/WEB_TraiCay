package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.NHACUNGCAP;
import Util.HandleException;
import Util.JDBC;

public class NhaCungCapDAO {
	private static final String SELECT_NhaCungCap = "SELECT * FROM nhacungcap";
	
	public NhaCungCapDAO() {}
	
	public List<NHACUNGCAP> selectNCC() throws SQLException {
		List<NHACUNGCAP> NCCs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NhaCungCap)) {

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String MaNCC = rs.getString("MaNCC");
                String TenNCC = rs.getString("TenNCC");
			NCCs.add(new NHACUNGCAP(MaNCC, TenNCC));
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return NCCs;
	}
}
