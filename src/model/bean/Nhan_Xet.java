package model.bean;

import java.sql.Timestamp;

public class Nhan_Xet {
	private int id_nhan_xet;
	private int id_bai_viet;
	private int id_user;
	private String noi_dung;
	private String hinh_anh;
	private String ho_va_ten;
	private Timestamp ngay_tao;
	public Nhan_Xet(int id_nhan_xet, int id_bai_viet, int id_user, String noi_dung, String hinh_anh, String ho_va_ten,
			Timestamp ngay_tao) {
		super();
		this.id_nhan_xet = id_nhan_xet;
		this.id_bai_viet = id_bai_viet;
		this.id_user = id_user;
		this.noi_dung = noi_dung;
		this.hinh_anh = hinh_anh;
		this.ho_va_ten = ho_va_ten;
		this.ngay_tao = ngay_tao;
	}
	public Nhan_Xet() {
		super();
	}
	public int getId_nhan_xet() {
		return id_nhan_xet;
	}
	public void setId_nhan_xet(int id_nhan_xet) {
		this.id_nhan_xet = id_nhan_xet;
	}
	public int getId_bai_viet() {
		return id_bai_viet;
	}
	public void setId_bai_viet(int id_bai_viet) {
		this.id_bai_viet = id_bai_viet;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}
	public String getHo_va_ten() {
		return ho_va_ten;
	}
	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
	}
	public Timestamp getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Timestamp ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	
}
