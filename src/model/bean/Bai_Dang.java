package model.bean;

import java.sql.Timestamp;

public class Bai_Dang {
	private int id_bai_dang;
	private String ten_bai_dang;
	private String noi_dung;
	private int id_nhom;
	private Timestamp ngay_tao;
	private int id_user;
	private String ho_va_ten;
	private String ten_nhom;
	public Bai_Dang(int id_bai_dang, String ten_bai_dang, String noi_dung, int id_nhom, Timestamp ngay_tao, int id_user,
			String ho_va_ten, String ten_nhom) {
		super();
		this.id_bai_dang = id_bai_dang;
		this.ten_bai_dang = ten_bai_dang;
		this.noi_dung = noi_dung;
		this.id_nhom = id_nhom;
		this.ngay_tao = ngay_tao;
		this.id_user = id_user;
		this.ho_va_ten = ho_va_ten;
		this.ten_nhom = ten_nhom;
	}
	public Bai_Dang() {
		super();
	}
	public int getId_bai_dang() {
		return id_bai_dang;
	}
	public void setId_bai_dang(int id_bai_dang) {
		this.id_bai_dang = id_bai_dang;
	}
	public String getTen_bai_dang() {
		return ten_bai_dang;
	}
	public void setTen_bai_dang(String ten_bai_dang) {
		this.ten_bai_dang = ten_bai_dang;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	public int getId_nhom() {
		return id_nhom;
	}
	public void setId_nhom(int id_nhom) {
		this.id_nhom = id_nhom;
	}
	public Timestamp getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Timestamp ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getHo_va_ten() {
		return ho_va_ten;
	}
	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
	}
	public String getTen_nhom() {
		return ten_nhom;
	}
	public void setTen_nhom(String ten_nhom) {
		this.ten_nhom = ten_nhom;
	}
	
	 
}
