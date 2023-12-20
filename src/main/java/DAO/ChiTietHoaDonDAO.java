package DAO;

import java.sql.Connection;
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
		
		private String ChonHoaDonTheoKH = "SELECT * \r\n"
				+ "from  chitiethoadon cthd\r\n"
				+ "inner join hoadon hd on cthd.MaHD = hd.MaHD\r\n"
				+ "inner join sanpham sp on cthd.MaSP = sp.MaSP\r\n"
				+ "inner join khachhang kh on hd.MaKH = kh.MaKH\r\n"
				+ "inner join giaovan gv on hd.MaHD = gv.MaHD\r\n"
				+ "inner join giamgia gg on gg.MaGG = hd.MaGG where kh.MaKH =?;";	
		private String ChonHoaDonTheoMaHD = "SELECT * \r\n"
				+ "from  chitiethoadon cthd\r\n"
				+ "inner join hoadon hd on cthd.MaHD = hd.MaHD\r\n"
				+ "inner join sanpham sp on cthd.MaSP = sp.MaSP\r\n"
				+ "inner join khachhang kh on hd.MaKH = kh.MaKH\r\n"
				+ "inner join giaovan gv on hd.MaHD = gv.MaHD\r\n"
				+ "inner join giamgia gg on gg.MaGG = hd.MaGG  where cthd.MaHD =?;";
		
		private static final String INSERT_Chitiethoadon_SQL = "INSERT INTO chitiethoadon values (?, ?, ?, ?)";
		
		public List<CHITIETHOADON> selectallhoadon(String MaKH)
		{			
			List<CHITIETHOADON> cthd = new ArrayList<>();
			Connection connection = JDBC.getConnection();
			try (
					PreparedStatement preparedStatement = connection.prepareStatement(ChonHoaDonTheoKH))
					{
						preparedStatement.setString(1, MaKH); 
						ResultSet rs = preparedStatement.executeQuery();
					    System.out.println(preparedStatement);
					while (rs.next()) {
						CHITIETHOADON chitiethd = new CHITIETHOADON();
						chitiethd.setMaHD(rs.getString("MaHD"));
						chitiethd.setSoLuong(rs.getInt("SoLuong"));
						chitiethd.setTongTien(rs.getFloat("TongTien"));		
						GIAOVAN giaovan = new GIAOVAN();
						giaovan.setTinhTrang(rs.getString("TinhTrang"));
						chitiethd.setGiaoVan(giaovan);
						KHACHHANG khachhang = new KHACHHANG();
						khachhang.setHoTen(rs.getString("HoTen"));
						khachhang.setDiaChi(rs.getString("DiaChi"));
						khachhang.setsDT(rs.getString("SDT"));			
						khachhang.setMaKH(rs.getString("MaKH"));
						chitiethd.setKhachHang(khachhang);
						HOADON hoadon = new HOADON();
						hoadon.setNgayDatHang(rs.getDate("NgayDatHang"));
						chitiethd.setHD(hoadon);
						SANPHAM sanpham = new SANPHAM();
						sanpham.setTenSP(rs.getString("TenSP"));
						sanpham.setDonViTinh(rs.getString("DonViTinh"));
						chitiethd.setSanPham(sanpham);
						cthd.add(chitiethd);
						  System.out.println(rs);		
					}
				} catch (SQLException exception) {
					HandleException.printSQLException(exception);
				}
				return cthd;
		}
		
		public  CHITIETHOADON selectchitiet(String MaHD)
		{
			CHITIETHOADON cthd = null;
			 try (
        		Connection connection = JDBC.getConnection();
	            PreparedStatement state = connection.prepareStatement(ChonHoaDonTheoMaHD);) {
	        	state.setString(1, MaHD); 
	        	System.out.println(state);	        
	            ResultSet rs = state.executeQuery();           
	            while (rs.next()) {
	            	CHITIETHOADON chitiethd = new CHITIETHOADON();
					chitiethd.setMaHD(rs.getString("MaHD"));
					chitiethd.setSoLuong(rs.getInt("SoLuong"));
					chitiethd.setTongTien(rs.getFloat("TongTien"));		
					GIAOVAN giaovan = new GIAOVAN();
					giaovan.setTinhTrang(rs.getString("TinhTrang"));
					chitiethd.setGiaoVan(giaovan);
					KHACHHANG khachhang = new KHACHHANG();
					khachhang.setHoTen(rs.getString("HoTen"));
					khachhang.setDiaChi(rs.getString("DiaChi"));
					khachhang.setsDT(rs.getString("SDT"));			
					khachhang.setMaKH(rs.getString("MaKH"));
					chitiethd.setKhachHang(khachhang);
					HOADON hoadon = new HOADON();
					hoadon.setNgayDatHang(rs.getDate("NgayDatHang"));
					chitiethd.setHD(hoadon);
					SANPHAM sanpham = new SANPHAM();
					sanpham.setTenSP(rs.getString("TenSP"));
					sanpham.setDonViTinh(rs.getString("DonViTinh"));
					chitiethd.setSanPham(sanpham);
	                cthd = chitiethd;
		            }
		        } catch (SQLException exception) {
		            HandleException.printSQLException(exception);
		        }
			return cthd;
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
