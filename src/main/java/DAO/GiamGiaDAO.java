package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.GIAMGIA;
import Util.HandleException;
import Util.JDBC;

public class GiamGiaDAO {
	private static final String SELECT_GiamGia = "SELECT * FROM giamgia";
	private static final String INSERT_GianGia = "INSERT INTO giamgia"+"(MaGG,GiaTri,NgayHetHan) Value"+"(?,?,?);";
	private static final String SELECT_GG_By_ID = "SELECT GiaTri,NgayHetHan  FROM giamgia WHERE MaGG =?;";
	private static final String DELETE_GiamGia = "DELETE from giamgia where MaGG =?;";
	private static final String UPDATE_GiamGia  ="UPDATE giamgia set GiaTri=?,NgayHetHan=? WHERE MaGG =?";
	public GiamGiaDAO() {}
	

	public List<GIAMGIA> selectallgiamgia() throws SQLException {
		List<GIAMGIA> GGs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GiamGia)) {
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String MaGG = rs.getString("MaGG");
                int GiaTri = rs.getInt("GiaTri");        
                LocalDate NgayHan = rs.getDate("NgayHetHan").toLocalDate();
			GGs.add(new GIAMGIA(MaGG,GiaTri,NgayHan));
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return GGs;
	}
	public void insertGiamgia(GIAMGIA giamgia)  throws SQLException 
	{
		 try (
			 Connection connection = JDBC.getConnection(); 
			 PreparedStatement state = connection.prepareStatement(INSERT_GianGia)) {
			 state.setString(1, giamgia.getMaGG());
			 state.setInt(2, giamgia.getGiaTri());
			 state.setDate(3,JDBC.getSQLDate( giamgia.getNgayHetHan()));
			 state.executeUpdate();
	        } catch (SQLException exception) {
	            HandleException.printSQLException(exception);
	        }
	}
	 public GIAMGIA selectGiamgia(String MaGG) {
		 GIAMGIA giamgia = null;      
	        try (
        		Connection connection = JDBC.getConnection();
	            PreparedStatement state = connection.prepareStatement(SELECT_GG_By_ID);) {
	        	state.setString(1, MaGG);	        
	            ResultSet rs = state.executeQuery();         
	            while (rs.next()) {
	             
	                String magg = rs.getString("MaGG");
	                int giatri = rs.getInt("GiaTri");
	             
	                LocalDate ngayhethan = rs.getDate("NgayHetHan").toLocalDate();
	            
	                giamgia = new GIAMGIA(magg,giatri,ngayhethan);
	            }
	        } catch (SQLException exception) {
	            HandleException.printSQLException(exception);
	        }
	        return giamgia;
	    }
	 public boolean deleteGiamgia(String MaGG) throws SQLException {
	        boolean rowDeleted;
	        try (
        		Connection connection = JDBC.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(DELETE_GiamGia);) {
	            statement.setString(1, MaGG);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	 public boolean updateTodo(GIAMGIA giamgia) throws SQLException {
	        boolean rowUpdated;
	        try (
        		Connection connection = JDBC.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(UPDATE_GiamGia);) {
	        	statement.setInt(1, giamgia.getGiaTri());
	        	statement.setDate(2, JDBC.getSQLDate(giamgia.getNgayHetHan()));
	        	statement.setString(3, giamgia.getMaGG());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }

}
