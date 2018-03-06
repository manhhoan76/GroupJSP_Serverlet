package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Nhom;
import model.bean.SV;
import model.bean.Thanh_Vien_Nhom;
import model.dao.Bai_DangDAO;
import model.dao.NhomDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class DelGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelGroupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (AuthUtil.checkUser(request) == false) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
			int idNhom = Integer.parseInt(request.getParameter("idNhom"));
			Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			NhomDAO nhomDAO = new NhomDAO();
			Nhom objNhom = nhomDAO.getItem(idNhom);
			HttpSession session = request.getSession();
			SV SVLogin = (SV) session.getAttribute("userLogin");
			if (SVLogin.getId_sv() != objNhom.getId_admin()) {
				response.sendRedirect(request.getContextPath() + "/trang-chu?msg=1");
			} else {
				bdDAO.delBai_Dang(idNhom);
				nhomDAO.delNhom(idNhom);
				tvDAO.delThanhVienNhom(idNhom);
				response.sendRedirect(request.getContextPath() + "/nhom");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
