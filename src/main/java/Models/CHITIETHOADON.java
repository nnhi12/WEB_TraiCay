package Models;

public class CHITIETHOADON {
	private String maHD;
	private String maSP;
	private int soLuong;
	private float tongTien;
	
	public CHITIETHOADON() {
		super();
	}
	private GIAOVAN giaovan;
	public GIAOVAN getGiaoVan()
	{
		return giaovan;
	}
	public void setGiaoVan(GIAOVAN giaovan)
	{
		this.giaovan = giaovan;
	}
	private KHACHHANG khachhang;
	public KHACHHANG getKhachHang()
	{
		return khachhang;
	}
	public void setKhachHang(KHACHHANG khachhang)
	{
		this.khachhang = khachhang;
	}
	private HOADON hoadon;
	public HOADON getHD()
	{
		return hoadon;
	}
	public void setHD(HOADON hoadon)
	{
		this.hoadon = hoadon;
	}
	private SANPHAM sanpham;
	public SANPHAM getSanPham()
	{
		return sanpham;
	}
	public void setSanPham(SANPHAM sanpham)
	{
		this.sanpham = sanpham;
	}
	private GIAMGIA giamgia;
	public GIAMGIA getGiamGia()
	{
		return giamgia;
	}
	public void setGiamGia(GIAMGIA giamgia)
	{
		this.giamgia = giamgia;
	}
	public CHITIETHOADON(String maHD, String maSP, int soLuong, float tongTien) {
		super();
		this.maHD = maHD;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}
	
	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
}
