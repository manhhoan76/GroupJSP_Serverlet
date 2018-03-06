package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Define;
import model.bean.Khoa;
import model.bean.Lop;
import model.bean.Nhom;
import model.dao.Bai_DangDAO;
import model.dao.KhoaDAO;
import model.dao.LopDAO;
import model.dao.NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassController() {
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
			LopDAO lopDAO = new LopDAO();
			int sumLop = 0;
			sumLop = lopDAO.countLop();
			int sumPage = (int) Math.ceil((float) sumLop / Define.ROW_COUNT_ADMIN);
			request.setAttribute("sumPage", sumPage);
			int current_page = 1;
			if (request.getParameter("page") != null) {
				current_page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("current_page", current_page);
			int offset = (current_page - 1) * Define.ROW_COUNT_ADMIN;
			ArrayList<Lop> listLop = (ArrayList<Lop>) lopDAO.getListLopPagination(offset, Define.ROW_COUNT_ADMIN);
			KhoaDAO khoaDAO = new KhoaDAO();
			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) khoaDAO.getItems();
			request.setAttribute("listLop", listLop);
			request.setAttribute("listKhoa", listKhoa);
			RequestDispatcher rd = request.getRequestDispatcher("/lop.jsp");
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
