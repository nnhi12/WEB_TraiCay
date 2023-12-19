package Models;

public class TAIKHOAN {
	private String maTK;
	private String taiKhoan;
	private String matKhau;
	private String phanQuyen;
	
	public TAIKHOAN() {
		super();
	}
	
	public TAIKHOAN(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public TAIKHOAN(String maTK, String taiKhoan, String matKhau, String phanQuyen) {
		super();
		this.maTK = maTK;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
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
