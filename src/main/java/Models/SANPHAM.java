package Models;

public class SANPHAM {
	private String maSP;
	private String tenSP;
	private String maLoaiSP;
	private int soLuong;
	private String donViTinh;
	private float gia;
	private String hinhAnh;
	private String maGG;
	private String maNCC;
	
	public SANPHAM() {
		super();
	}

	public SANPHAM(String maSP, String tenSP, String maLoaiSP, int soLuong, String donViTinh, float gia, String hinhAnh,
			String maGG, String maNCC) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maLoaiSP = maLoaiSP;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.maGG = maGG;
		this.maNCC = maNCC;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMaGG() {
		return maGG;
	}

	public void setMaGG(String maGG) {
		this.maGG = maGG;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	
}
