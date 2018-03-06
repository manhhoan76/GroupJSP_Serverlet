package model.bean;

public class Khoa {
	private int id_khoa;
	private String  ten_khoa;
	public Khoa(int id_khoa, String ten_khoa) {
		super();
		this.id_khoa = id_khoa;
		this.ten_khoa = ten_khoa;
	}
	public Khoa() {
		super();
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
	
}
