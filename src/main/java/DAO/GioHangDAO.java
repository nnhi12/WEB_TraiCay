package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.GIOHANG;
import Util.HandleException;
import Util.JDBC;

public class GioHangDAO {
	private static final String layTatCaGio = "SELECT * from giohang where MaKH = ?";
	private static final String ThemVaoGioHang = "INSERT INTO giohang values (?, ?, ?)";
	private static final String SuaGioHang = "UPDATE giohang set SoLuong = ? where MaSP = ? and MaKH = ?";
	private static final String XoaGioHang = "DELETE from giohang where MaSP = ? and MaKH = ?";
	private static final String layTenSPTrongGio = "SELECT TenSP FROM giohang JOIN sanpham ON giohang.MaSP = sanpham.MaSP "
			+ "WHERE giohang.MaKH = ?";
	private static final String layGiaSPTrongGio = "SELECT Gia FROM giohang JOIN sanpham ON giohang.MaSP = sanpham.MaSP "
			+ "WHERE giohang.MaKH = ?";
	
	public List<GIOHANG> layGH(String MaKH) throws SQLException {
		System.out.println(layTatCaGio);
        // try-with-resource statement will auto close the connection.
		List <GIOHANG> giohangs = new ArrayList < > ();
		
        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(layTatCaGio);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, MaKH);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaSP = rs.getString("MaSP");
                int SoLuong = rs.getInt("SoLuong");
                giohangs.add(new GIOHANG(MaSP, MaKH, SoLuong));
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return giohangs;
	}
	
	public List<String> layTenSP_TheoKH(String MaKH) throws SQLException {
		System.out.println(layTenSPTrongGio);
        // try-with-resource statement will auto close the connection.
		List <String> tens = new ArrayList < > ();
		
        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(layTenSPTrongGio);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, MaKH);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String TenSP = rs.getString("TenSP");
                tens.add(TenSP);
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return tens;
	}
	
	public List<Float> layGiaSP_TheoKH(String MaKH) throws SQLException {
		System.out.println(layGiaSPTrongGio);
        // try-with-resource statement will auto close the connection.
		List <Float> gias = new ArrayList < > ();
		
        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(layGiaSPTrongGio);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, MaKH);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Float GiaSP = rs.getFloat("Gia");
                gias.add(GiaSP);
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return gias;
	}
	
	public void insertGH(GIOHANG gh) throws SQLException {
		System.out.println(ThemVaoGioHang);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ThemVaoGioHang)) {
            preparedStatement.setString(1, gh.getMaSP());
            preparedStatement.setString(2, gh.getMaKH());
            preparedStatement.setInt(3, gh.getSoLuong());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public void updateGH(GIOHANG gh) throws SQLException {
		System.out.println(SuaGioHang);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SuaGioHang)) {
            preparedStatement.setString(3, gh.getMaKH());
            preparedStatement.setString(2, gh.getMaSP());
            preparedStatement.setInt(1, gh.getSoLuong());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public void deleteGH(GIOHANG gh) throws SQLException {
		System.out.println(XoaGioHang);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(XoaGioHang)) {
            preparedStatement.setString(2, gh.getMaKH());
            preparedStatement.setString(1, gh.getMaSP());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
