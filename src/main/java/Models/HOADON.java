package Models;

import java.sql.Date;

public class HOADON {
	private String maHD;
	private String maKH;
	private float tongTien;
	private String maGG;
	private String phuongThucTT;
	private Date ngayDatHang;
	private boolean trangThai;
	
	public HOADON() {
		super();
	}

	public HOADON(String maHD, String maKH, float tongTien, String maGG, String phuongThucTT, Date ngayDatHang,
			boolean trangThai) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tongTien = tongTien;
		this.maGG = maGG;
		this.phuongThucTT = phuongThucTT;
		this.ngayDatHang = ngayDatHang;
		this.trangThai = trangThai;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaGG() {
		return maGG;
	}

	public void setMaGG(String maGG) {
		this.maGG = maGG;
	}

	public String getPhuongThucTT() {
		return phuongThucTT;
	}

	public void setPhuongThucTT(String phuongThucTT) {
		this.phuongThucTT = phuongThucTT;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
