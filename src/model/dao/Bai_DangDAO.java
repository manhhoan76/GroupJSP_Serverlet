package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Bai_Dang;
import model.bean.Nhom;
import util.ConnectDBUtil;

public class Bai_DangDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public Bai_DangDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public int delBD( int idBD) {
		int resut=0;
		conn = connectDBUtil.getConnection();
		String sql = "delete from bai_dang where id_bai_dang=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idBD);
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
	public int editNhom(Bai_Dang objBD) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "update bai_dang set ten_bai_dang =? ,noi_dung =?, ngay_tao =? where id_bai_dang=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objBD.getTen_bai_dang());
			pst.setString(2,objBD.getNoi_dung() );
			pst.setTimestamp(3, objBD.getNgay_tao());
			pst.setInt(4, objBD.getId_bai_dang());
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

	public int addBD(Bai_Dang objBD) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO bai_dang (ten_bai_dang,noi_dung, id_nhom, id_user)  VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objBD.getTen_bai_dang());
			pst.setString(2,objBD.getNoi_dung());
			pst.setInt(3, objBD.getId_nhom());
			pst.setInt(4, objBD.getId_user());
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

	String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, id_nhom, id_user, ngay_tao, sv.ho_va_ten FROM `bai_dang` INNER JOIN sv ON bai_dang.id_user=sv.id_sv WHERE id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv=3)";
	public int delBai_Dang( int idNhom) {
		int resut=0;
		conn = connectDBUtil.getConnection();
		String sql = "delete from bai_dang where id_nhom=?";
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
	public ArrayList<Bai_Dang> getItemsPagination(int idSV, int offset, int row_count) {
		ArrayList<Bai_Dang> listBD = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, bai_dang.id_nhom, id_user, bai_dang.ngay_tao, sv.ho_va_ten,  nhom.ten_nhom FROM bai_dang INNER JOIN sv ON bai_dang.id_user=sv.id_sv  INNER JOIN nhom ON nhom.id_nhom=bai_dang.id_nhom WHERE bai_dang.id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv="
				+ idSV + ")  ORDER BY bai_dang.ngay_tao DESC limit  " + offset + "," + row_count;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Bai_Dang objBD = new Bai_Dang(rs.getInt("id_bai_dang"), rs.getString("ten_bai_dang"),
						rs.getString("noi_dung"), rs.getInt("id_nhom"), rs.getTimestamp("ngay_tao"),
						rs.getInt("id_user"), rs.getString("ho_va_ten"), rs.getString("ten_nhom"));
				listBD.add(objBD);
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

		return listBD;

	}
	public ArrayList<Bai_Dang> getItemsPaginationByKey(int idSV, String key, int offset, int row_count) {
		ArrayList<Bai_Dang> listBD = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, bai_dang.id_nhom, id_user, bai_dang.ngay_tao, sv.ho_va_ten,  nhom.ten_nhom FROM bai_dang INNER JOIN sv ON bai_dang.id_user=sv.id_sv  INNER JOIN nhom ON nhom.id_nhom=bai_dang.id_nhom WHERE bai_dang.id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv="
				+ idSV + ") && ten_bai_dang like '%"+key+"%'  ORDER BY bai_dang.ngay_tao DESC limit  " + offset + "," + row_count;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Bai_Dang objBD = new Bai_Dang(rs.getInt("id_bai_dang"), rs.getString("ten_bai_dang"),
						rs.getString("noi_dung"), rs.getInt("id_nhom"), rs.getTimestamp("ngay_tao"),
						rs.getInt("id_user"), rs.getString("ho_va_ten"), rs.getString("ten_nhom"));
				listBD.add(objBD);
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

		return listBD;

	}

	public ArrayList<Bai_Dang> getItemsPaginationByidNhom(int idNhom, int offset, int row_count) {
		ArrayList<Bai_Dang> listBD = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, bai_dang.id_nhom, id_user, bai_dang.ngay_tao, sv.ho_va_ten,  nhom.ten_nhom FROM bai_dang INNER JOIN sv ON bai_dang.id_user=sv.id_sv  INNER JOIN nhom ON nhom.id_nhom=bai_dang.id_nhom WHERE bai_dang.id_nhom ="+idNhom+" ORDER BY bai_dang.ngay_tao DESC limit  "
				+ offset + "," + row_count;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Bai_Dang objBD = new Bai_Dang(rs.getInt("id_bai_dang"), rs.getString("ten_bai_dang"),
						rs.getString("noi_dung"), rs.getInt("id_nhom"), rs.getTimestamp("ngay_tao"),
						rs.getInt("id_user"), rs.getString("ho_va_ten"), rs.getString("ten_nhom"));
				listBD.add(objBD);
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

		return listBD;

	}

	public Bai_Dang getObj(int idBD) {
		Bai_Dang objBD = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, bai_dang.id_nhom, id_user, bai_dang.ngay_tao, sv.ho_va_ten,  nhom.ten_nhom FROM bai_dang INNER JOIN sv ON bai_dang.id_user=sv.id_sv  INNER JOIN nhom ON nhom.id_nhom=bai_dang.id_nhom WHERE  bai_dang.id_bai_dang="
				+ idBD;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objBD = new Bai_Dang(rs.getInt("id_bai_dang"), rs.getString("ten_bai_dang"), rs.getString("noi_dung"),
						rs.getInt("id_nhom"), rs.getTimestamp("ngay_tao"), rs.getInt("id_user"),
						rs.getString("ho_va_ten"), rs.getString("ten_nhom"));
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

		return objBD;

	}

	public ArrayList<Bai_Dang> getItemsMakeByUser(int idSV) {
		ArrayList<Bai_Dang> listBD = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT  id_bai_dang,noi_dung, ten_bai_dang, bai_dang.id_nhom, id_user, bai_dang.ngay_tao, sv.ho_va_ten,  nhom.ten_nhom FROM bai_dang INNER JOIN sv ON bai_dang.id_user=sv.id_sv  INNER JOIN nhom ON nhom.id_nhom=bai_dang.id_nhom WHERE bai_dang.id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv="
				+ idSV + ")  && bai_dang.id_user=" + idSV + "  ORDER BY bai_dang.ngay_tao DESC limit  4";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Bai_Dang objBD = new Bai_Dang(rs.getInt("id_bai_dang"), rs.getString("ten_bai_dang"),
						rs.getString("noi_dung"), rs.getInt("id_nhom"), rs.getTimestamp("ngay_tao"),
						rs.getInt("id_user"), rs.getString("ho_va_ten"), rs.getString("ten_nhom"));
				listBD.add(objBD);
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

		return listBD;

	}

	public int countBai_DangByKey(int idUser, String key) {
		int sumBD = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumBD FROM `bai_dang` WHERE id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv="
				+ idUser + ") && ten_bai_dang like '%"+key+"%'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumBD = rs.getInt("sumBD");
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
		return sumBD;
	}
	public int countBai_Dang(int idUser) {
		int sumBD = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumBD FROM `bai_dang` WHERE id_nhom IN (SELECT id_nhom from thanh_vien_nhom WHERE id_sv="
				+ idUser + ")";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumBD = rs.getInt("sumBD");
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
		return sumBD;
	}
	public int countBai_DangByIDNhom(int idNhom) {
		int sumBD = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumBD FROM `bai_dang` WHERE id_nhom="+idNhom;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumBD = rs.getInt("sumBD");
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
		return sumBD;
	}
}
