package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.SANPHAM;
import Util.HandleException;
import Util.JDBC;

public class SanPhamDAO {
	private static final String SELECT_SANPHAM = "SELECT * FROM sanpham";
	private static final String SELECT_SANPHAM_BYMaSP = "SELECT * FROM sanpham WHERE MaSP = ?";
	private static final String INSERT_SANPHAM_SQL = "INSERT INTO sanpham" +
	        "  (MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, HinhAnh, MaGG, MaNCC) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	public SanPhamDAO() {}
	
	public SANPHAM layThongTinSP(String MaSP) throws SQLException, IOException{
		SANPHAM sp = null;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SANPHAM_BYMaSP);)
        {
        	preparedStatement.setString(1, MaSP);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                String TenSP = rs.getString("TenSP");
                String MaLoaiSP = rs.getString("MaLoaiSP");
                int SoLuong = rs.getInt("SoLuong");
                String DonViTinh = rs.getString("DonViTinh");
                Float Gia = rs.getFloat("Gia");
                InputStream imageStream = rs.getBinaryStream("HinhAnh");
                byte[] HinhAnh = null;
                if (imageStream != null) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = imageStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    HinhAnh = outputStream.toByteArray();
                }
                String MaGG = rs.getString("MaGG");
                String MaNCC = rs.getString("MaNCC");
                sp = new SANPHAM(MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, HinhAnh, MaGG, MaNCC);
               
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return sp;
	}
	
	public String findNextMaSP() {
	    String sql = "SELECT MAX(MaSP) FROM sanpham";
	    String nextMaSP = "SP001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaSP = rs.getString(1);
	        }
	        
	        if (nextMaSP == null) {
	        	return "SP001";
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaSP.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "SP" + numberStr;
	}
	
	public List<SANPHAM> selectSP() throws SQLException {
		List<SANPHAM> sanphams = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SANPHAM)) {

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
                String TenSP = rs.getString("TenSP");
                int SoLuong = rs.getInt("SoLuong");
                String DonViTinh = rs.getString("DonViTinh");
                Float Gia = rs.getFloat("Gia");
			sanphams.add(new SANPHAM(MaSP, TenSP, SoLuong, DonViTinh, Gia));
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return sanphams;
	}
	
	public void insertSP(SANPHAM sp) throws SQLException {
		System.out.println(INSERT_SANPHAM_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SANPHAM_SQL)) {
            preparedStatement.setString(1, sp.getMaSP());
            preparedStatement.setString(2, sp.getTenSP());
            preparedStatement.setString(3, sp.getMaLoaiSP());
            preparedStatement.setInt(4, sp.getSoLuong());
            preparedStatement.setString(5, sp.getDonViTinh());
            preparedStatement.setFloat(6, sp.getGia());
            preparedStatement.setBytes(7, sp.getHinhAnh());
            preparedStatement.setString(8, sp.getMaGG());
            preparedStatement.setString(9, sp.getMaNCC());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
