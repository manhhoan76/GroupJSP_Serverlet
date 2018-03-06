package model.bean;

import java.sql.Timestamp;

public class Nhom {
	private int id_nhom;
	private String ten_nhom;
	private String mo_ta;
	private int cong_khai;
	private int id_admin;
	private Timestamp ngay_tao;
	public Nhom(int id_nhom, String ten_nhom, String mo_ta, int cong_khai, int id_admin, Timestamp ngay_tao) {
		super();
		this.id_nhom = id_nhom;
		this.ten_nhom = ten_nhom;
		this.mo_ta = mo_ta;
		this.cong_khai = cong_khai;
		this.id_admin = id_admin;
		this.ngay_tao = ngay_tao;
	}
	public Nhom() {
		super();
	}
	public int getId_nhom() {
		return id_nhom;
	}
	public void setId_nhom(int id_nhom) {
		this.id_nhom = id_nhom;
	}
	public String getTen_nhom() {
		return ten_nhom;
	}
	public void setTen_nhom(String ten_nhom) {
		this.ten_nhom = ten_nhom;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	public int getCong_khai() {
		return cong_khai;
	}
	public void setCong_khai(int cong_khai) {
		this.cong_khai = cong_khai;
	}
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public Timestamp getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Timestamp ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	
	
}
