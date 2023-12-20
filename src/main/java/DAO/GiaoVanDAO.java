package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.GIAOVAN;
import Util.HandleException;
import Util.JDBC;

public class GiaoVanDAO {
	private static final String SELECT_ALL_GIAOVAN = "SELECT * FROM giaovan";
	private static final String SELECT_GIAOVAN = "SELECT * FROM giaovan WHERE MaGV = ?";
	private static final String UPDATE_TINHTRANG_GIAOVAN = "UPDATE giaovan SET TinhTrang = ? WHERE MAGV = ?";
	private static final String UPDATE_NGAYNHAN_GIAOVAN = "UPDATE giaovan SET NgayNhanHang = ?, TinhTrang = ? WHERE MAGV = ?";
	
	public GiaoVanDAO() {};
	
	public List<GIAOVAN> layAllGiaoVan(){
		List<GIAOVAN> gvs = new ArrayList<>();
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GIAOVAN)) {
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaGV = rs.getString("MaGV");
					String MaHD = rs.getString("MaHD");
					Date NgayNhan = rs.getDate("NgayNhanHang");
					String tinhtrang = rs.getString("TinhTrang");
					gvs.add(new GIAOVAN(MaGV, MaHD, NgayNhan, tinhtrang));
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return gvs;
	}
	
	public GIAOVAN layGiaoVan(String MaGV){
		GIAOVAN gv = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GIAOVAN)) {
				preparedStatement.setString(1, MaGV);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaHD = rs.getString("MaHD");
					Date NgayNhan = rs.getDate("NgayNhanHang");
					String tinhtrang = rs.getString("TinhTrang");
					gv = new GIAOVAN(MaGV, MaHD, NgayNhan, tinhtrang);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return gv;
	}
	public boolean updateTinhTrang(String MaGV, String tt) {
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TINHTRANG_GIAOVAN)) {
				preparedStatement.setString(1, tt);
				preparedStatement.setString(2, MaGV);
				preparedStatement.executeUpdate();
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return true;
	}
	
	public boolean updateNgayNhan(String MaGV, String tt) {
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NGAYNHAN_GIAOVAN)) {
				LocalDate currentDate = LocalDate.now();
				Date date = Date.valueOf(currentDate);
				preparedStatement.setDate(1, date);
				preparedStatement.setString(2, tt);
				preparedStatement.setString(3, MaGV);
				preparedStatement.executeUpdate();
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return true;
	}
}
