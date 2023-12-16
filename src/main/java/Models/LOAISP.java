package Models;

public class LOAISP {
	private String maLoaiSP;
	private String tenLoai;
	
	public LOAISP() {
		super();
	}
	
	public LOAISP(String maLoaiSP, String tenLoai) {
		super();
		this.maLoaiSP = maLoaiSP;
		this.tenLoai = tenLoai;
	}

	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	
}
