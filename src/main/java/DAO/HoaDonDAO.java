package DAO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import Models.HOADON;
import Models.SANPHAM;
import Models.CHITIETHOADON;
import Models.GIAOVAN;
import Models.GIAMGIA;

import Util.HandleException;
import Util.JDBC;

public class HoaDonDAO {
	private static final String SELECT_HOADON = "SELECT * FROM hoadon WHERE MaHD = ?";
	private static final String SELECT_CHITIETHD = "SELECT *  FROM chitiethoadon WHERE MaHD = ?";
  private static final String SELECT_HoaDon= "select \r\n"
				+ "gv.TinhTrang,cthd.SoLuong, sp.DonViTinh, kh.HoTen,kh.DiaChi,kh.SDT, hd.NgayDatHang, sp.HinhAnh,sp.TenSP,hd.TongTien,gg.GiaTri,cthd.TongTien from  `dtdm`.chitiethoadon cthd\r\n"
				+ "inner join `dtdm`.hoadon hd on cthd.MaHD = hd.MaHD\r\n"
				+ "inner join `dtdm`.sanpham sp on cthd.MaSP = sp.MaSP\r\n"
				+ "inner join `dtdm`.khachhang kh on hd.MaKH = kh.MaKH\r\n"
				+ "inner join `dtdm`.giaovan gv on hd.MaHD = gv.MaHD\r\n"
				+ "inner join `dtdm`.giamgia gg on gg.MaGG = hd.MaGG\r\n"
				+ " where MaHD =?;";
  	private static final String TongTien = "SELECT SUM((COALESCE(S.Gia - (S.Gia * G.GiaTri / 100), S.Gia)) * GH.SoLuong) AS TongTien "
  			+ "FROM giohang GH "
  			+ "JOIN sanpham S ON GH.MaSP = S.MaSP "
  			+ "LEFT JOIN giamgia G ON S.MaGG = G.MaGG "
  			+ "WHERE GH.MaKH = ?;";
  	
  	private static final String INSERT_HOADON_SQL = "INSERT INTO hoadon values (?, ?, ?, ?, ?, ?, ?)";
	public HoaDonDAO() {}
	
	public HOADON layHoaDon(String MaHD) {
		HOADON hd = null;
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOADON)) {
				preparedStatement.setString(1, MaHD);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaKH = rs.getString("MaKH");
					Float TongTien = rs.getFloat("TongTien");
					String MaGG = rs.getString("MaGG");
					String pttt = rs.getString("PhuongThucTT");
					Date ngaydat = rs.getDate("NgayDatHang");
					Boolean trangthai = rs.getBoolean("TrangThai");
					hd = new HOADON(MaHD, MaKH, TongTien, MaGG, pttt, ngaydat, trangthai);
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return hd;
	}
	
	public List<CHITIETHOADON> layChiTiet(String MaHD){
		List<CHITIETHOADON> chitiets = new ArrayList<>();
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHITIETHD)) {
				preparedStatement.setString(1, MaHD);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String MaSP = rs.getString("MaSP");
					int SL = rs.getInt("SoLuong");
					Float TongTien = rs.getFloat("TongTien");
					chitiets.add(new CHITIETHOADON(MaHD, MaSP, SL, TongTien));
				}
			} catch (SQLException exception) {
				HandleException.printSQLException(exception);
			}
		return chitiets;
	}
	
	public float TongTienHD (String MaKH)
	{
		float tongtien = 0;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(TongTien);)
        {
        	preparedStatement.setString(1, MaKH);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                tongtien = rs.getFloat("TongTien");
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return tongtien;
	}
	
	public String findNextMaHD() {
	    String sql = "SELECT MAX(MaHD) FROM hoadon";
	    String nextMaHD = "HD001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaHD = rs.getString(1);
	        }
	        
	        if (nextMaHD == null) {
	        	return "HD001";
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaHD.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "HD" + numberStr;
	}
	
	public void insertSP(HOADON hd) throws SQLException {
		System.out.println(INSERT_HOADON_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOADON_SQL)) {
            preparedStatement.setString(1, hd.getMaHD());
            preparedStatement.setString(2, hd.getMaKH());
            preparedStatement.setFloat(3, hd.getTongTien());
            preparedStatement.setString(4, hd.getMaGG());
            preparedStatement.setString(5, hd.getPhuongThucTT());
            preparedStatement.setDate(6, hd.getNgayDatHang());
            preparedStatement.setBoolean(7, hd.isTrangThai());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
