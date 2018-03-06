package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Nhom;
import model.bean.SV;
import model.dao.NhomDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class UserGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserGroupController() {
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
			NhomDAO nhomDAO = new NhomDAO();
			Nhom objNhom = nhomDAO.getItem(idNhom);
			ArrayList<SV> listThanhVien = (ArrayList<SV>) tvDAO.getIThanhVienNhom(idNhom);
			request.setAttribute("listThanhVien", listThanhVien);
			request.setAttribute("infoNhom", objNhom);
			RequestDispatcher rd = request.getRequestDispatcher("/userGroup.jsp");
			rd.forward(request, response);
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
