package Models;

public class SANPHAM {
	private String maSP;
	private String tenSP;
	private String maLoaiSP;
	private int soLuong;
	private String donViTinh;
	private float gia;
	private byte[] hinhAnh;
	private String maGG;
	private String maNCC;
	private String encodedHinhAnh;
	
	public SANPHAM() {
		super();
	}
	
	public SANPHAM(String maSP, String tenSP, float gia, String encodedHinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
		this.encodedHinhAnh = encodedHinhAnh;
	}



	public String getEncodedHinhAnh() {
		return encodedHinhAnh;
	}



	public void setEncodedHinhAnh(String encodedHinhAnh) {
		this.encodedHinhAnh = encodedHinhAnh;
	}
	
	public SANPHAM(String maSP, String tenSP, String maLoaiSP, int soLuong, String donViTinh, float gia, String maGG,
			String maNCC) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maLoaiSP = maLoaiSP;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.gia = gia;
		this.maGG = maGG;
		this.maNCC = maNCC;
	}

	public SANPHAM(String maSP, String tenSP, int soLuong, String donViTinh, float gia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.gia = gia;
	}

	public SANPHAM(String maSP, String tenSP, String maLoaiSP, int soLuong, String donViTinh, float gia, byte[] hinhAnh,
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

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
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
