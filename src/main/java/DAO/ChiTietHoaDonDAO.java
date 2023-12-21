package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.CHITIETHOADON;
import Models.GIAMGIA;
import Models.GIAOVAN;
import Models.HOADON;
import Models.KHACHHANG;
import Models.SANPHAM;
import Util.HandleException;
import Util.JDBC;

public class ChiTietHoaDonDAO {

	public ChiTietHoaDonDAO() {}
		
		private String ChonHoaDonTheoKH = "SELECT * from  hoadon where MaKH = ?;";	
		private String ChonHoaDonTheoMaHD = "SELECT * from chitiethoadon where MaHD = ?";
		
		private static final String INSERT_Chitiethoadon_SQL = "INSERT INTO chitiethoadon values (?, ?, ?, ?)";
		
		public List<HOADON> selectallhoadon(String MaKH)
		{			
			List<HOADON> hds = new ArrayList<>();
			Connection connection = JDBC.getConnection();
			try (
					PreparedStatement preparedStatement = connection.prepareStatement(ChonHoaDonTheoKH))
					{
						preparedStatement.setString(1, MaKH); 
						ResultSet rs = preparedStatement.executeQuery();
					    System.out.println(preparedStatement);
					while (rs.next()) {
						String MaHD = rs.getString("MaHD");
						Float TongTien = rs.getFloat("TongTien");
						String PTTT = rs.getString("PhuongThucTT");
						Date NgayDatHang = rs.getDate("NgayDatHang");
						hds.add(new HOADON(MaHD, MaKH, TongTien, PTTT, NgayDatHang));
						  System.out.println(rs);		
					}
				} catch (SQLException exception) {
					HandleException.printSQLException(exception);
				}
				return hds;
		}
		
		public  List<CHITIETHOADON> selectchitiet(String MaHD)
		{
			List<CHITIETHOADON> cthds = new ArrayList<>();
			 try (
        		Connection connection = JDBC.getConnection();
	            PreparedStatement state = connection.prepareStatement(ChonHoaDonTheoMaHD);) {
	        	state.setString(1, MaHD); 
	        	System.out.println(state);	        
	            ResultSet rs = state.executeQuery();           
	            while (rs.next()) {
						String MaSP = rs.getString("MaSP");
						int SoLuong = rs.getInt("SoLuong");
						cthds.add(new CHITIETHOADON(MaHD, MaSP, SoLuong));
		            }
		        } catch (SQLException exception) {
		            HandleException.printSQLException(exception);
		        }
			return cthds;
		}
		
		public void insertCTHD(CHITIETHOADON chitiet) throws SQLException {
			System.out.println(INSERT_Chitiethoadon_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Chitiethoadon_SQL)) {
	            preparedStatement.setString(1, chitiet.getMaHD());
	            preparedStatement.setString(2, chitiet.getMaSP());
	            preparedStatement.setInt(3, chitiet.getSoLuong());
	            preparedStatement.setFloat(4, chitiet.getTongTien());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException exception) {
	            HandleException.printSQLException(exception);
	        }
		}
}
