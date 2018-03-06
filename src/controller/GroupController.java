package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Define;
import model.bean.Nhom;
import model.dao.Bai_DangDAO;
import model.dao.NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class GroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupController() {
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
			NhomDAO nhomDAO = new NhomDAO();
			int sumNhom = 0;
			sumNhom = nhomDAO.countNhom();
			int sumPage = (int) Math.ceil((float) sumNhom / Define.ROW_COUNT_ADMIN);
			request.setAttribute("sumPage", sumPage);
			int current_page = 1;
			if (request.getParameter("page") != null) {
				current_page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("current_page", current_page);
			int offset = (current_page - 1) * Define.ROW_COUNT_ADMIN;
			ArrayList<Nhom> listNhomCongKhai = (ArrayList<Nhom>) nhomDAO.getListNhomPagination(offset,
					Define.ROW_COUNT_ADMIN);
			request.setAttribute("listNhomCK", listNhomCongKhai);
			RequestDispatcher rd = request.getRequestDispatcher("/group.jsp");
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
