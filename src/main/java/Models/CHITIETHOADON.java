package Models;

public class CHITIETHOADON {
	private String maHD;
	private String maSP;
	private int soLuong;
	private float tongTien;
	
	public CHITIETHOADON() {
		super();
	}

	public CHITIETHOADON(String maHD, String maSP, int soLuong) {
		super();
		this.maHD = maHD;
		this.maSP = maSP;
		this.soLuong = soLuong;
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
