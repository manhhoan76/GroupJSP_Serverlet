package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Bai_Dang;
import model.bean.SV;
import model.bean.Thanh_Vien_Nhom;
import util.ConnectDBUtil;

public class Thanh_Vien_NhomDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public Thanh_Vien_NhomDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public int addThanhVien(int idNhom, int idSV) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO thanh_vien_nhom (id_nhom, id_sv)  VALUES (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNhom);
			pst.setInt(2,idSV);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int delThanhVienNhom(int idSV, int idNhom) {
		int resut=0;
		conn = connectDBUtil.getConnection();
		String sql = "delete from thanh_vien_nhom where id_sv=? && id_nhom=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idSV);
			pst.setInt(2, idNhom);
			resut = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resut;
	}
	public int delThanhVienNhom(int idNhom) {
		int resut=0;
		conn = connectDBUtil.getConnection();
		String sql = "delete from thanh_vien_nhom where id_nhom=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNhom);
			resut = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resut;
	}
	public ArrayList<SV> getIThanhVienNhom(int idNhom) {
		ArrayList<SV> listSV = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql="SELECT sv.id_sv, ten_dang_nhap, ho_va_ten, email, mat_khau, sv.id_lop, hinh_anh, dia_chi, so_dt, lop.ten_lop, lop.id_khoa, khoa.ten_khoa FROM `sv` INNER JOIN lop ON sv.id_lop = lop.id_lop INNER JOIN khoa ON lop.id_khoa=khoa.id_khoa INNER JOIN thanh_vien_nhom ON sv.id_sv=thanh_vien_nhom.id_sv\r\n" + 
				"WHERE thanh_vien_nhom.id_nhom="+idNhom+" ORDER BY thanh_vien_nhom.ngay_vao DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				SV objSV = new SV(rs.getInt("id_sv"), rs.getString("ten_dang_nhap"), rs.getString("ho_va_ten"), rs.getString("email"), rs.getString("mat_khau"), rs.getInt("id_lop"), rs.getString("ten_lop"), rs.getInt("id_khoa"), rs.getString("ten_khoa"), rs.getString("hinh_anh"), rs.getString("dia_chi"), rs.getString("so_dt"));
				listSV.add(objSV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return listSV;

	}
	public Thanh_Vien_Nhom checkThanhVien(int idSV, int idNhom) {
		Thanh_Vien_Nhom objTV = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from thanh_vien_nhom where id_sv="+idSV+" && id_nhom= " +idNhom;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objTV = new Thanh_Vien_Nhom(rs.getInt("id_sv"), rs.getInt("id_nhom"), rs.getTimestamp("ngay_vao")); 
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return objTV;

	}

}
