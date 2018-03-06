package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;
import model.bean.Nhom;
import model.bean.Khoa;
import util.ConnectDBUtil;

public class KhoaDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public KhoaDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public int addKhoa(Khoa objKhoa) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO khoa (ten_khoa)  VALUES (?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objKhoa.getTen_khoa());
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
	public ArrayList<Khoa> getItemsByIDKHoa() {
		ArrayList<Khoa> listKhoa = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from khoa";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Khoa objKhoa = new Khoa(rs.getInt("id_khoa"), rs.getString("ten_khoa"));
				listKhoa.add(objKhoa);
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
		return listKhoa;
	}
	public Khoa getobject(int idKhoa) {
		Khoa objKhoa = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from khoa where id_khoa="+idKhoa;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
			 objKhoa = new Khoa(rs.getInt("id_khoa"), rs.getString("ten_khoa"));
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
		return objKhoa;
	}
	public int editKhoa(Khoa objkhoa) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "update khoa set ten_khoa =?  where id_khoa=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objkhoa.getTen_khoa());
			pst.setInt(2, objkhoa.getId_khoa());
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

	public ArrayList<Khoa> getItemsPagination(int offset, int rowcount) {
		ArrayList<Khoa> listKhoa = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from khoa limit "+offset+","+rowcount;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Khoa objKhoa = new Khoa(rs.getInt("id_khoa"), rs.getString("ten_khoa"));
				listKhoa.add(objKhoa);
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
		return listKhoa;
	}
	public ArrayList<Khoa> getItems() {
		ArrayList<Khoa> listKhoa = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from khoa ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Khoa objKhoa = new Khoa(rs.getInt("id_khoa"), rs.getString("ten_khoa"));
				listKhoa.add(objKhoa);
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
		return listKhoa;
	}
	public int countKhoa() {
		int sumKhoa = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumKhoa FROM khoa";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumKhoa = rs.getInt("sumKhoa");
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
		return sumKhoa;
	}
}
