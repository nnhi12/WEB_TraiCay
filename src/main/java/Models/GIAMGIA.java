package Models;

import java.sql.Date;

public class GIAMGIA {
	private String maGG;
	private int giaTri;
	private Date ngayHetHan;
	
	public GIAMGIA() {
		super();
	}
	
	public GIAMGIA(String maGG, int giaTri) {
		super();
		this.maGG = maGG;
		this.giaTri = giaTri;
	}

	public GIAMGIA(String maGG, int giaTri, Date ngayHetHan) {
		super();
		this.maGG = maGG;
		this.giaTri = giaTri;
		this.ngayHetHan = ngayHetHan;
	}

	public String getMaGG() {
		return maGG;
	}

	public void setMaGG(String maGG) {
		this.maGG = maGG;
	}

	public int getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
}
