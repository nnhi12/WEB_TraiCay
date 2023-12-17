package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.GIAMGIA;
import Util.HandleException;
import Util.JDBC;

public class GiamGiaDAO {
	private static final String SELECT_GiamGia = "SELECT * FROM giamgia";
	
	public GiamGiaDAO() {}
	
	public List<GIAMGIA> selectNCC() throws SQLException {
		List<GIAMGIA> GGs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GiamGia)) {

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String MaGG = rs.getString("MaGG");
                int GiaTri = rs.getInt("GiaTri");
			GGs.add(new GIAMGIA(MaGG, GiaTri));
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return GGs;
	}
}
