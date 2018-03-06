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
import model.dao.NhomDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class OutGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutGroupController() {
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
			int idSV = Integer.parseInt(request.getParameter("svid"));
			int idNhom = Integer.parseInt(request.getParameter("idNhom"));

			NhomDAO nhomDAO = new NhomDAO();
			Nhom objNhom = nhomDAO.getItem(idNhom);
			Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
			HttpSession session = request.getSession();
			SV SVLogin = (SV) session.getAttribute("userLogin");
			if (SVLogin.getId_sv() != idSV) {
				response.sendRedirect(request.getContextPath() + "/trang-chu?msg=1");
			} else {
				if (idSV == objNhom.getId_admin()) {
					response.sendRedirect(request.getContextPath() + "/chi-tiet-nhom?idNhom=" + idNhom + "&msg=1");
				} else {
					tvDAO.delThanhVienNhom(idSV, idNhom);
					response.sendRedirect(request.getContextPath() + "/nhom");
				}
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
