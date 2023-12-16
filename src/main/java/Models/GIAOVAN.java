package Models;

import java.sql.Date;

public class GIAOVAN {
	private String maGV;
	private String maHD;
	private Date ngayNhanHang;
	private String tinhTrang;
	
	public GIAOVAN() {
		super();
	}

	public GIAOVAN(String maGV, String maHD, Date ngayNhanHang, String tinhTrang) {
		super();
		this.maGV = maGV;
		this.maHD = maHD;
		this.ngayNhanHang = ngayNhanHang;
		this.tinhTrang = tinhTrang;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgayNhanHang() {
		return ngayNhanHang;
	}

	public void setNgayNhanHang(Date ngayNhanHang) {
		this.ngayNhanHang = ngayNhanHang;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
