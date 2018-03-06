package model.bean;

public class SV {
	private int id_sv;
	private String ten_dang_nhap;
	private String ho_va_ten;
	private String email;
	private String mat_khau;
	private int id_lop;
	private String ten_lop;
	private int id_khoa;
	private String ten_khoa;
	private String hinh_anh;
	private String dia_chi;
	private String so_dt;
	public SV(int id_sv, String ten_dang_nhap, String ho_va_ten, String email, String mat_khau, int id_lop,
			String ten_lop, int id_khoa, String ten_khoa, String hinh_anh, String dia_chi, String so_dt) {
		super();
		this.id_sv = id_sv;
		this.ten_dang_nhap = ten_dang_nhap;
		this.ho_va_ten = ho_va_ten;
		this.email = email;
		this.mat_khau = mat_khau;
		this.id_lop = id_lop;
		this.ten_lop = ten_lop;
		this.id_khoa = id_khoa;
		this.ten_khoa = ten_khoa;
		this.hinh_anh = hinh_anh;
		this.dia_chi = dia_chi;
		this.so_dt = so_dt;
	}
	public SV() {
		super();
	}
	public int getId_sv() {
		return id_sv;
	}
	public void setId_sv(int id_sv) {
		this.id_sv = id_sv;
	}
	public String getTen_dang_nhap() {
		return ten_dang_nhap;
	}
	public void setTen_dang_nhap(String ten_dang_nhap) {
		this.ten_dang_nhap = ten_dang_nhap;
	}
	public String getHo_va_ten() {
		return ho_va_ten;
	}
	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public int getId_lop() {
		return id_lop;
	}
	public void setId_lop(int id_lop) {
		this.id_lop = id_lop;
	}
	public String getTen_lop() {
		return ten_lop;
	}
	public void setTen_lop(String ten_lop) {
		this.ten_lop = ten_lop;
	}
	public int getId_khoa() {
		return id_khoa;
	}
	public void setId_khoa(int id_khoa) {
		this.id_khoa = id_khoa;
	}
	public String getTen_khoa() {
		return ten_khoa;
	}
	public void setTen_khoa(String ten_khoa) {
		this.ten_khoa = ten_khoa;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSo_dt() {
		return so_dt;
	}
	public void setSo_dt(String so_dt) {
		this.so_dt = so_dt;
	}

	
}
