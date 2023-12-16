package Models;

public class GIOHANG {
	private String maSP;
	private String maKH;
	private int soLuong;
	
	public GIOHANG() {
		super();
	}
	
	public GIOHANG(String maSP, String maKH, int soLuong) {
		super();
		this.maSP = maSP;
		this.maKH = maKH;
		this.soLuong = soLuong;
	}
	
	public String getMaSP() {
		return maSP;
	}
	
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	
	public String getMaKH() {
		return maKH;
	}
	
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}  
}
