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
import Models.HOADON;
import Util.HandleException;
import Util.JDBC;

public class GiaoVanDAO {
	private static final String SELECT_ALL_GIAOVAN = "SELECT * FROM giaovan";
	private static final String SELECT_GIAOVAN = "SELECT * FROM giaovan WHERE MaGV = ?";
	private static final String UPDATE_TINHTRANG_GIAOVAN = "UPDATE giaovan SET TinhTrang = ? WHERE MAGV = ?";
	private static final String UPDATE_NGAYNHAN_GIAOVAN = "UPDATE giaovan SET NgayNhanHang = ?, TinhTrang = ? WHERE MAGV = ?";
  	private static final String INSERT_GIAOVAN_SQL = "INSERT INTO giaovan (MaGV, MaHD, TinhTrang) values (?, ?, ?)";
  	private static final String SELECT_ALL_TinhTrangGIAOVAN = "SELECT TinhTrang from hoadon hd inner join giaovan gv on hd.MaHD = gv.MaHD where MaKH = ?;";
  	private static final String SELECT_GIAOVAN_ByMaHD = "SELECT * FROM giaovan WHERE MaHD = ?";
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
	
	public String findNextMaGV() {
	    String sql = "SELECT MAX(MaGV) FROM giaovan";
	    String nextMaGV = "GV001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaGV = rs.getString(1);
	        }
	        
	        if (nextMaGV == null) {
	        	return "GV001";
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaGV.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "GV" + numberStr;
	}
	
	public void insertGV(GIAOVAN gv) throws SQLException {
		System.out.println(INSERT_GIAOVAN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GIAOVAN_SQL)) {
            preparedStatement.setString(1, gv.getMaGV());
            preparedStatement.setString(2, gv.getMaHD());
            preparedStatement.setString(3, gv.getTinhTrang());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public List<String> layTTGiaoVan(String MaKH){
		List <String> tts = new ArrayList<>();
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TinhTrangGIAOVAN)) {
				preparedStatement.setString(1, MaKH);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String tinhtrang = rs.getString("TinhTrang");
					tts.add(tinhtrang);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return tts;
	}
	
	public GIAOVAN layGiaoVanByMaHD(String MaHD){
		GIAOVAN gv = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GIAOVAN_ByMaHD)) {
				preparedStatement.setString(1, MaHD);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String tinhtrang = rs.getString("TinhTrang");
					gv = new GIAOVAN(MaHD, tinhtrang);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return gv;
	}
}
