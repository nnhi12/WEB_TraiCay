package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.HOADON;
import Models.CHITIETHOADON;
import Models.GIAOVAN;
import Util.HandleException;
import Util.JDBC;

public class HoaDonDAO {
	private static final String SELECT_HOADON = "SELECT * FROM hoadon WHERE MaHD = ?";
	private static final String SELECT_CHITIETHD = "SELECT *  FROM chitiethoadon WHERE MaHD = ?";
	
	public HoaDonDAO() {}
	
	public HOADON layHoaDon(String MaHD) {
		HOADON hd = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOADON)) {
				preparedStatement.setString(1, MaHD);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaKH = rs.getString("MaKH");
					Float TongTien = rs.getFloat("TongTien");
					String MaGG = rs.getString("MaGG");
					String pttt = rs.getString("PhuongThucTT");
					Date ngaydat = rs.getDate("NgayDatHang");
					Boolean trangthai = rs.getBoolean("TrangThai");
					hd = new HOADON(MaHD, MaKH, TongTien, MaGG, pttt, ngaydat, trangthai);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return hd;
	}
	
	public List<CHITIETHOADON> layChiTiet(String MaHD){
		List<CHITIETHOADON> chitiets = new ArrayList<>();
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHITIETHD)) {
				preparedStatement.setString(1, MaHD);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaSP = rs.getString("MaSP");
					int SL = rs.getInt("SoLuong");
					Float TongTien = rs.getFloat("TongTien");
					chitiets.add(new CHITIETHOADON(MaHD, MaSP, SL, TongTien));
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return chitiets;
	}
}
