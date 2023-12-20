package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.KHACHHANG;
import Models.TAIKHOAN;
import Util.HandleException;
import Util.JDBC;

public class TaiKhoanDAO {
	private static final String SELECT_TAIKHOAN = "SELECT TaiKhoan, MatKhau FROM taikhoan WHERE MaTaiKhoan = ?";
	String SqlCreateTK = "INSERT INTO taikhoan (MaTaiKhoan, TaiKhoan, MatKhau, PhanQuyen) VALUE (?,?,?,?)";
	static String sqlLogin = "SELECT MaTaiKhoan FROM taikhoan WHERE TaiKhoan = ? and MatKhau = ?";
    static String id = null;
	
	public TaiKhoanDAO() {}
	
	public TAIKHOAN layThongTinTaiKhoang(String MaTK) {
		TAIKHOAN tk = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAIKHOAN)) {
				preparedStatement.setString(1, MaTK);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					String taikhoan = rs.getString("TaiKhoan");
	                String matkhau = rs.getString("MatKhau");
					tk = new TAIKHOAN(taikhoan, matkhau);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return tk;
	}
	public boolean CreateNewTK(String accountCode, String TaiKhoan, String MatKhau) throws SQLException {
		   Connection conn = JDBC.getConnection();
		   
		   String Phanquyen = "KhachHang";
	        try {
	            PreparedStatement ps = conn.prepareStatement(SqlCreateTK);
	            ps.setString(1, accountCode);
	            ps.setString(2, TaiKhoan);
	            ps.setString(3, MatKhau);
	            ps.setString(4, Phanquyen);	            

	            int rowsInsert = ps.executeUpdate();
	            return rowsInsert > 0;
	        }finally {
	            JDBC.closeConnection(conn);
	        }
	   }
	   
	   public String LOGIN(String TaiKhoan, String MatKhau) throws SQLException{

	        Connection conn = JDBC.getConnection();
	        try
	        {
	            PreparedStatement statement = conn.prepareStatement(sqlLogin);
	            statement.setString(1, TaiKhoan);
	            statement.setString(2, MatKhau);
	            ResultSet rs = statement.executeQuery();
	            while(rs.next())
	            {
	                id = rs.getString("MaTaiKhoan");
	            }
	        } catch (SQLException e) {
	        	HandleException.printSQLException(e);
	            return null;
	        } finally {
	            JDBC.closeConnection(conn);
	        }
	        return id;

	    }
	   
	   public TAIKHOAN selectTaiKhoanByMaTK(String maTK) {
	        TAIKHOAN taikhoan = null;
	        Connection conn = JDBC.getConnection();
	        try {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM taikhoan WHERE MaTaiKhoan = ?");
	            ps.setString(1, maTK);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                taikhoan = new TAIKHOAN();
	                taikhoan.setMaTK(rs.getString("MaTaiKhoan"));
	                taikhoan.setTaiKhoan(rs.getString("TaiKhoan"));
	                taikhoan.setMatKhau(rs.getString("MatKhau"));
	                taikhoan.setPhanQuyen(rs.getString("PhanQuyen"));	                
	            }
	        } catch (SQLException e) {
	            HandleException.printSQLException(e);
	        } finally {
	            JDBC.closeConnection(conn);
	        }
	        return taikhoan;
	    }
	   
	  
}
