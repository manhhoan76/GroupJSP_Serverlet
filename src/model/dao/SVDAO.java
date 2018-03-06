package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;
import model.bean.SV;
import util.ConnectDBUtil;

public class SVDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public SVDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	
	public SV getItem(String tenDN, String Mk) {
		SV objSV = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM sv where ten_dang_nhap=? && mat_khau = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tenDN);
			pst.setString(2, Mk);
			rs = pst.executeQuery();
			if (rs.next()) {
				objSV = new SV(rs.getInt("id_sv"), rs.getString("ten_dang_nhap"), rs.getString("ho_va_ten"), rs.getString("email"), rs.getString("mat_khau"), rs.getInt("id_lop"), null, 0, null, rs.getString("hinh_anh"), rs.getString("dia_chi"), rs.getString("so_dt"));
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

		return objSV;

	}
	public SV checkTenDN(String tenDN) {
		SV objSV = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM sv where ten_dang_nhap=? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tenDN);
			rs = pst.executeQuery();
			if (rs.next()) {
				objSV = new SV(rs.getInt("id_sv"), rs.getString("ten_dang_nhap"), rs.getString("ho_va_ten"), rs.getString("email"), rs.getString("mat_khau"), rs.getInt("id_lop"), null, 0, null, rs.getString("hinh_anh"), rs.getString("dia_chi"), rs.getString("so_dt"));
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

		return objSV;

	}
	public int editSV(SV objSV) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "update sv set ho_va_ten =?, email=?, mat_khau=?, id_lop=?, hinh_anh=?, dia_chi=?, so_dt=?  where id_sv=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSV.getHo_va_ten());
			pst.setString(2, objSV.getEmail());
			pst.setString(3, objSV.getMat_khau());
			pst.setInt(4, objSV.getId_lop());
			pst.setString(5, objSV.getHinh_anh());
			pst.setString(6, objSV.getDia_chi());
			pst.setString(7, objSV.getSo_dt());
			pst.setInt(8, objSV.getId_sv());
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
	public SV getObj(int idSV) {
		SV objSV = null;
		conn = connectDBUtil.getConnection();
		String sql ="SELECT sv.id_sv, ten_dang_nhap, ho_va_ten, email, mat_khau, sv.id_lop, hinh_anh, dia_chi, so_dt, lop.ten_lop, lop.id_khoa, khoa.ten_khoa FROM `sv` INNER JOIN lop ON sv.id_lop = lop.id_lop INNER JOIN khoa ON lop.id_khoa=khoa.id_khoa where sv.id_sv=?";	
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idSV);
			rs = pst.executeQuery();
			if (rs.next()) {
				objSV = new SV(rs.getInt("id_sv"), rs.getString("ten_dang_nhap"), rs.getString("ho_va_ten"), rs.getString("email"), rs.getString("mat_khau"), rs.getInt("id_lop"), rs.getString("ten_lop"),rs.getInt("id_khoa"), rs.getString("ten_khoa"), rs.getString("hinh_anh"), rs.getString("dia_chi"), rs.getString("so_dt"));
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

		return objSV;

	}
	public int addSV(SV objSV) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO sv (ho_va_ten, ten_dang_nhap, mat_khau, id_lop, hinh_anh)  VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSV.getHo_va_ten());
			pst.setString(2, objSV.getTen_dang_nhap());
			pst.setString(3,objSV.getMat_khau());
			pst.setInt(4, objSV.getId_lop());
			pst.setString(5, objSV.getHinh_anh());
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

	public ArrayList<SV> getSVByIdKhoa(int idKHoa) {
		ArrayList<SV> listSV = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql="SELECT sv.id_sv, ten_dang_nhap, ho_va_ten, email, mat_khau, sv.id_lop, hinh_anh, dia_chi, so_dt, lop.ten_lop, lop.id_khoa, khoa.ten_khoa FROM `sv` INNER JOIN lop ON sv.id_lop = lop.id_lop INNER JOIN khoa ON lop.id_khoa=khoa.id_khoa WHERE khoa.id_khoa ="+idKHoa;
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
	public ArrayList<SV> getSVByIdLop(int idLop) {
		ArrayList<SV> listSV = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql="SELECT sv.id_sv, ten_dang_nhap, ho_va_ten, email, mat_khau, sv.id_lop, hinh_anh, dia_chi, so_dt, lop.ten_lop, lop.id_khoa, khoa.ten_khoa FROM `sv` INNER JOIN lop ON sv.id_lop = lop.id_lop INNER JOIN khoa ON lop.id_khoa=khoa.id_khoa WHERE lop.id_lop ="+idLop;
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
}
