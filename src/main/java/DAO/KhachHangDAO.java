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
	String SqlCreateKH = "INSERT INTO khachhang (MaKH, HoTen, GioiTinh, NgaySinh, DiaChi, SDT, MaTaiKhoan) VALUE (?,?,?,?,?,?,?)";
	private static final String LayMaKH ="SELECT MaKH FROM khachhang WHERE MaTaiKhoan = ?;";
			
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
	
	public boolean CreateNewKH(KHACHHANG Khachhang) throws SQLException {
		   Connection conn = JDBC.getConnection();
	        try {
	            PreparedStatement ps = conn.prepareStatement(SqlCreateKH);
	            ps.setString(1, Khachhang.getMaKH());
	            ps.setString(2, Khachhang.getHoTen());
	            ps.setString(3, Khachhang.getGioiTinh());
	            ps.setDate(4, new java.sql.Date(Khachhang.getNgaySinh().getTime()));
	            ps.setString(5, Khachhang.getDiaChi());
	            ps.setString(6, Khachhang.getsDT());
	            ps.setString(7, Khachhang.getMaTaiKhoan());	    

	            int rowsInsert = ps.executeUpdate();
	            return rowsInsert > 0;
	        }finally {
	            JDBC.closeConnection(conn);
	        }
	   }
	public String layMaKH(String MaTK) {
		String MaKH = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LayMaKH)) {
				preparedStatement.setString(1, MaTK);
				ResultSet rs = preparedStatement.executeQuery();				
				while (rs.next()) {
					 MaKH = rs.getString("MaKH");
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return MaKH;
	}
	
	public String findNextMaKH() {
	    String sql = "SELECT MAX(MaKH) FROM khachhang";
	    String nextMaKH = "KH001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaKH = rs.getString(1);
	        }
	        
	        if (nextMaKH == null) {
	        	return "KH001";
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaKH.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "KH" + numberStr;
	}

}
