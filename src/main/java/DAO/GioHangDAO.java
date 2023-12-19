package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.GIOHANG;
import Util.HandleException;
import Util.JDBC;

public class GioHangDAO {
	private static final String ThemVaoGioHang = "INSERT INTO giohang values (?, ?, ?)";
	private static final String SuaGioHang = "UPDATE giohang set SoLuong = ? where MaSP = ? and MaKH = ?";
	private static final String XoaGioHang = "DELETE giohang  where MaSP = ? and MaKH = ?";
	
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
            preparedStatement.setString(2, gh.getMaKH());
            preparedStatement.setString(3, gh.getMaSP());
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
            preparedStatement.setString(1, gh.getMaKH());
            preparedStatement.setString(2, gh.getMaSP());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
