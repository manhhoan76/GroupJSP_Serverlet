package model.bean;

import java.sql.Timestamp;

public class Thanh_Vien_Nhom {
	private int id_sv;
	private int id_nhom;
	private Timestamp ngay_vao;
	public Thanh_Vien_Nhom(int id_sv, int id_nhom, Timestamp ngay_vao) {
		super();
		this.id_sv = id_sv;
		this.id_nhom = id_nhom;
		this.ngay_vao = ngay_vao;
	}
	public Thanh_Vien_Nhom() {
		super();
	}
	public int getId_sv() {
		return id_sv;
	}
	public void setId_sv(int id_sv) {
		this.id_sv = id_sv;
	}
	public int getId_nhom() {
		return id_nhom;
	}
	public void setId_nhom(int id_nhom) {
		this.id_nhom = id_nhom;
	}
	public Timestamp getNgay_vao() {
		return ngay_vao;
	}
	public void setNgay_vao(Timestamp ngay_vao) {
		this.ngay_vao = ngay_vao;
	}
	
	
}
