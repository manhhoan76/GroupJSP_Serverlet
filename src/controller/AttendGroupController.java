package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Nhom;
import model.bean.Thanh_Vien_Nhom;
import model.dao.NhomDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class AttendGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendGroupController() {
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
		Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
		tvDAO.addThanhVien(idNhom, idSV);
			response.sendRedirect(request.getContextPath() + "/chi-tiet-nhom?idNhom="+idNhom);
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
