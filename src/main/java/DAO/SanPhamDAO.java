package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import Models.SANPHAM;
import Util.HandleException;
import Util.JDBC;


public class SanPhamDAO {
	private static final String SELECT_SANPHAM = "SELECT * FROM sanpham";
	private static final String SELECT_SANPHAM_BYMaSP = "SELECT * FROM sanpham WHERE MaSP = ?";
	private static final String SELECT_ANH_BYMaSP = "SELECT HinhAnh FROM sanpham WHERE MaSP = ?";
	private static final String INSERT_SANPHAM_SQL = "INSERT INTO sanpham" +
	        "  (MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, HinhAnh, MaGG, MaNCC) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String DELETE_SANPHAM_BYMaSP = "DELETE FROM sanpham WHERE MaSP = ?;";
	private static final String UPDATE_SANPHAM = "UPDATE sanpham SET TenSP = ?, MaLoaiSP = ?, SoLuong =?, DonViTinh =?, Gia = ?, HinhAnh = ?, MaGG = ?, MaNCC = ? WHERE MaSP = ?;";
	private static final String SELECT_LISTSP = "SELECT MaSP, TenSP, Gia, HinhAnh FROM sanpham";
	
	private static final String GiaDaGiam = "SELECT S.MaSP, COALESCE(S.Gia - (S.Gia * G.GiaTri / 100), S.Gia) AS GiaSauGiam "
			+ "FROM sanpham S "
			+ "LEFT JOIN giamgia G ON S.MaGG = G.MaGG "
			+ "WHERE S.MaSP = ?;";
	
	private static final String Update_SL_Sau_ThanhToan = "UPDATE SANPHAM "
			+ "SET SoLuong = SoLuong - ( "
			+ "    SELECT SoLuong "
			+ "    FROM GIOHANG "
			+ "    WHERE GIOHANG.MaSP = SANPHAM.MaSP "
			+ "      AND GIOHANG.MaKH = ? "
			+ ") "
			+ "WHERE MaSP IN ( "
			+ "    SELECT MaSP "
			+ "    FROM GIOHANG "
			+ "    WHERE MaKH = ? "
			+ ")";
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
                String MaGG = rs.getString("MaGG");
                String MaNCC = rs.getString("MaNCC");
                sp = new SANPHAM(MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, MaGG, MaNCC);
               
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return sp;
	}
	
	public byte[] layDuLieuAnh(String MaSP) throws SQLException, IOException {
	    byte[] HinhAnh = null;
	    ResultSet rs = null;

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANH_BYMaSP)) {
	        preparedStatement.setString(1, MaSP);
	        rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            InputStream imageStream = rs.getBinaryStream("HinhAnh");

	            if (imageStream != null) {
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead;
	                while ((bytesRead = imageStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                HinhAnh = outputStream.toByteArray();
	            }
	        }
	    } catch (SQLException exception) {
	    	HandleException.printSQLException(exception);
	    }
	    return HinhAnh;
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

	public boolean deleteSP(String MaSP) throws SQLException {
		boolean rowDeleted;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SANPHAM_BYMaSP);) {
            statement.setString(1, MaSP);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
	}
	
	public boolean updateSP(SANPHAM sp) throws SQLException {
		boolean rowUpdated;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SANPHAM);) {
        	statement.setString(1, sp.getTenSP());
            statement.setString(2, sp.getMaLoaiSP());
            statement.setInt(3, sp.getSoLuong());
            statement.setString(4, sp.getDonViTinh());
            statement.setFloat(5, sp.getGia());
            statement.setBytes(6, sp.getHinhAnh());
            statement.setString(7, sp.getMaGG());
            statement.setString(8, sp.getMaNCC());
            statement.setString(9, sp.getMaSP());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
	}
	
	public List<SANPHAM> getAllSP() throws IOException {
        List<SANPHAM> sanphams = new ArrayList<>();
        Connection conn = JDBC.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_LISTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	String MaSP = rs.getString("MaSP");
                String TenSP = rs.getString("TenSP");
                Float Gia = rs.getFloat("Gia");
                byte[] HinhAnh = null;
                InputStream imageStream = rs.getBinaryStream("HinhAnh");
	            if (imageStream != null) {
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead;
	                while ((bytesRead = imageStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                HinhAnh = outputStream.toByteArray();
	            }                
                String base64Image = Base64.getEncoder().encodeToString(HinhAnh);
                
                sanphams.add(new SANPHAM(MaSP, TenSP, Gia, base64Image));          	
            	
                                
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        } finally {
            JDBC.closeConnection(conn);
        }
        return sanphams;
    }
	
	public float GiaSauGiam (String MaSP)
	{
		float giaSauGiam = 0;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(GiaDaGiam);)
        {
        	preparedStatement.setString(1, MaSP);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                giaSauGiam = rs.getFloat("GiaSauGiam");
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return giaSauGiam;
	}
	
	public void updateSLSP(String MaKH) throws SQLException {
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement( Update_SL_Sau_ThanhToan );) {
        	statement.setString(1, MaKH);
        	statement.setString(2, MaKH);
            statement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
