package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;
import model.bean.Lop;
import util.ConnectDBUtil;

public class LopDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public LopDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public Lop getobject(int idlop) {
		Lop objLop = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from lop where id_lop="+idlop;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objLop = new Lop(rs.getInt("id_lop"), rs.getString("ten_lop"), rs.getInt("id_khoa"));
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
		return objLop;
	}
	public Lop checkTenLop(String  tenLop) {
		Lop objLop = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from lop where ten_lop like '"+tenLop+"'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objLop = new Lop(rs.getInt("id_lop"), rs.getString("ten_lop"), rs.getInt("id_khoa"));
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
		return objLop;
	}
	public int editLop(Lop objlop) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "update lop set ten_lop =?, id_khoa=?  where id_lop=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objlop.getTen_lop());
			pst.setInt(2, objlop.getId_khoa());
			pst.setInt(3, objlop.getId_lop());
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
	public int addLop(Lop objLop) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO lop (ten_lop, id_khoa)  VALUES (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objLop.getTen_lop());
			pst.setInt(2, objLop.getId_khoa());
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
	public ArrayList<Lop> getItemsByIDKHoa(int id_khoa) {
		ArrayList<Lop> listLop = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from lop where id_khoa="+id_khoa;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Lop objLop = new Lop(rs.getInt("id_lop"), rs.getString("ten_lop"), rs.getInt("id_khoa"));
				listLop.add(objLop);
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
		return listLop;
	}
	public ArrayList<Lop> getListLopPagination(int off, int rowc) {
		ArrayList<Lop> listLop = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * from lop order by id_khoa  limit "+off+","+rowc;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Lop objLop = new Lop(rs.getInt("id_lop"), rs.getString("ten_lop"), rs.getInt("id_khoa"));
				listLop.add(objLop);
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
		return listLop;
	}
	public int countLop() {
		int sumLop = 0;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT count(*) as sumLop FROM lop";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumLop = rs.getInt("sumLop");
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
		return sumLop;
	}
}
