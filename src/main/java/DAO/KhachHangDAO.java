package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.KHACHHANG;
import Util.HandleException;
import Util.JDBC;

public class KhachHangDAO {
	private static final String SELECT_ALL_KHACHHANG = "SELECT * FROM khachhang";
	private static final String SELECT_KHACHHANG = "SELECT * FROM khachhang WHERE MaKH = ?";
	
	public KhachHangDAO() {}
	
	public List<KHACHHANG> layAllThongTinKhachHang() {
		List<KHACHHANG> khachhangs = new ArrayList <>();
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHACHHANG)) {
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaKH = rs.getString("MaKH");
					String ten = rs.getString("HoTen");
	                String gt = rs.getString("GioiTinh");
	                Date ngaysinh = rs.getDate("NgaySinh");
	                String diachi = rs.getString("DiaChi");	
	                String sdt = rs.getString("SDT");	
	                String matk = rs.getString("MaTaiKhoan");
					khachhangs.add(new KHACHHANG(MaKH, ten, gt, ngaysinh, diachi, sdt, matk));
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return khachhangs;
	}
	
	public KHACHHANG layThongTinKhachHang(String MaKH) {
		KHACHHANG kh = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHACHHANG)) {
				preparedStatement.setString(1, MaKH);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					String ten = rs.getString("HoTen");
	                String gt = rs.getString("GioiTinh");
	                Date ngaysinh = rs.getDate("NgaySinh");
	                String diachi = rs.getString("DiaChi");	
	                String sdt = rs.getString("SDT");	
	                String matk = rs.getString("MaTaiKhoan");
					kh = new KHACHHANG(MaKH, ten, gt, ngaysinh, diachi, sdt, matk);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return kh;
	}
}
