package Models;

import java.time.LocalDate;

public class GIAMGIA {
	private String maGG;
	private int giaTri;
	private LocalDate ngayHetHan;
	
	
	public GIAMGIA(String maGG, int giaTri) {
		super();
		this.maGG = maGG;
		this.giaTri = giaTri;
	}

	public GIAMGIA(String maGG, int giaTri, LocalDate ngayHetHan) {
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

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
}
