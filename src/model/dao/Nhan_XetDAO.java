package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Bai_Dang;
import model.bean.Nhan_Xet;
import model.bean.SV;
import util.ConnectDBUtil;

public class Nhan_XetDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private ConnectDBUtil connectDBUtil;

	public Nhan_XetDAO() {
		this.connectDBUtil = new ConnectDBUtil();
	}
	public ArrayList<Nhan_Xet> getItems(int idBV) {
		ArrayList<Nhan_Xet> listNX = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql ="SELECT id_nhan_xet, id_bai_viet, id_user, noi_dung, ngay_tao, sv.hinh_anh, sv.ho_va_ten FROM nhan_xet INNER JOIN sv on sv.id_sv=nhan_xet.id_user WHERE id_bai_viet="+idBV;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Nhan_Xet objNX = new Nhan_Xet(rs.getInt("id_nhan_xet"), rs.getInt("id_bai_viet"), rs.getInt("id_user"), rs.getString("noi_dung"), rs.getString("hinh_anh"),rs.getString("ho_va_ten"), rs.getTimestamp("ngay_tao"));
				listNX.add(objNX);
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

		return listNX;

	}
	public int addComment(Nhan_Xet objNX) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO nhan_xet (id_bai_viet, id_user, noi_dung)  VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objNX.getId_bai_viet());
			pst.setInt(2, objNX.getId_user());
			pst.setString(3, objNX.getNoi_dung());
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

	
}
