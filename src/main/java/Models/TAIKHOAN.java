package Models;

public class TAIKHOAN {
	private String maKH;
	private String taiKhoan;
	private String matKhau;
	private String phanQuyen;
	
	public TAIKHOAN() {
		super();
	}

	public TAIKHOAN(String maKH, String taiKhoan, String matKhau, String phanQuyen) {
		super();
		this.maKH = maKH;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	
}
