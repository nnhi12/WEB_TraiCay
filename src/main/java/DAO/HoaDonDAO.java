package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Models.GIAMGIA;
import Util.HandleException;
import Util.JDBC;

public class HoaDonDAO {
		private static final String SELECT_HoaDon= "select \r\n"
				+ "gv.TinhTrang,cthd.SoLuong, sp.DonViTinh, kh.HoTen,kh.DiaChi,kh.SDT, hd.NgayDatHang, sp.HinhAnh,sp.TenSP,hd.TongTien,gg.GiaTri,cthd.TongTien from  `dtdm`.chitiethoadon cthd\r\n"
				+ "inner join `dtdm`.hoadon hd on cthd.MaHD = hd.MaHD\r\n"
				+ "inner join `dtdm`.sanpham sp on cthd.MaSP = sp.MaSP\r\n"
				+ "inner join `dtdm`.khachhang kh on hd.MaKH = kh.MaKH\r\n"
				+ "inner join `dtdm`.giaovan gv on hd.MaHD = gv.MaHD\r\n"
				+ "inner join `dtdm`.giamgia gg on gg.MaGG = hd.MaGG\r\n"
				+ " where MaHD =?;";
				
		

}
