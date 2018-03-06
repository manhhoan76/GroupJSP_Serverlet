package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Bai_Dang;
import model.bean.Nhom;
import model.bean.SV;
import util.ConnectDBUtil;

public class NhomDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public NhomDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public int addNhom(Nhom objNhom) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO nhom (ten_nhom,mo_ta, cong_khai, id_admin)  VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNhom.getTen_nhom());
			pst.setString(2,objNhom.getMo_ta());
			pst.setInt(3, objNhom.getCong_khai());
			pst.setInt(4, objNhom.getId_admin());
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

	public int editNhom(Nhom objNhom) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "update nhom set ten_nhom =? ,mo_ta =?, cong_khai=?, ngay_tao =? where id_nhom=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNhom.getTen_nhom());
			pst.setString(2,objNhom.getMo_ta());
			pst.setInt(3, objNhom.getCong_khai());
			pst.setTimestamp(4, objNhom.getNgay_tao());
			pst.setInt(5, objNhom.getId_nhom());
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

	public int delNhom( int idNhom) {
		int resut=0;
		conn = connectDBUtil.getConnection();
		String sql = "delete from nhom where id_nhom=?";
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
	public Nhom getItem(int idNhom) {
		Nhom objNhom = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM nhom where id_nhom=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNhom);
			rs = pst.executeQuery();
			if (rs.next()) {
				objNhom = new Nhom(rs.getInt("id_nhom"), rs.getString("ten_nhom"), rs.getString("mo_ta"), rs.getInt("cong_khai"), rs.getInt("id_admin"), rs.getTimestamp("ngay_tao"));
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

		return objNhom;

	}
	public Nhom getObjNhomByID_Admin(int idSV) {
		Nhom objNhom = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT nhom.id_nhom, ten_nhom, mo_ta, cong_khai, id_admin, ngay_tao FROM nhom where nhom.id_admin="+idSV+" order by id_nhom desc limit 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
			 objNhom = new Nhom(rs.getInt("id_nhom"), rs.getString("ten_nhom"), rs.getString("mo_ta"), rs.getInt("cong_khai"), rs.getInt("id_admin"), rs.getTimestamp("ngay_tao"));
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

		return objNhom;

	}
	public ArrayList<Nhom> getItemsBySV(int idSV) {
		ArrayList<Nhom> listNhom = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT nhom.id_nhom, ten_nhom, mo_ta, cong_khai, id_admin, ngay_tao FROM nhom INNER JOIN thanh_vien_nhom ON nhom.id_nhom = thanh_vien_nhom.id_nhom WHERE  thanh_vien_nhom.id_sv="+idSV;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Nhom objNhom = new Nhom(rs.getInt("id_nhom"), rs.getString("ten_nhom"), rs.getString("mo_ta"), rs.getInt("cong_khai"), rs.getInt("id_admin"), rs.getTimestamp("ngay_tao"));
				listNhom.add(objNhom);
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

		return listNhom;

	}
	public int countNhom() {
		int sumNhom = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumNhom FROM nhom  WHERE nhom.cong_khai=1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumNhom = rs.getInt("sumNhom");
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
		return sumNhom;
	}
	public ArrayList<Nhom> getListNhomPagination(int offset,int rowcount) {
		ArrayList<Nhom> listNhom = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT nhom.id_nhom, ten_nhom, mo_ta, cong_khai, id_admin, ngay_tao FROM nhom  WHERE nhom.cong_khai=1 limit "+offset+","+rowcount;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Nhom objNhom = new Nhom(rs.getInt("id_nhom"), rs.getString("ten_nhom"), rs.getString("mo_ta"), rs.getInt("cong_khai"), rs.getInt("id_admin"), rs.getTimestamp("ngay_tao"));
				listNhom.add(objNhom);
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

		return listNhom;

	}
}
