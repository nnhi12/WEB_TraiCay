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
}
