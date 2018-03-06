package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.Define;
import model.bean.Bai_Dang;
import model.bean.SV;
import model.dao.Bai_DangDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (AuthUtil.checkUser(request) == false) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
			String key = request.getParameter("key");
			System.out.println(key);
			HttpSession session = request.getSession();
			SV objUserInfor = (SV) session.getAttribute("userLogin");
			int sumNews = 0;
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			sumNews = bdDAO.countBai_DangByKey(objUserInfor.getId_sv(), key);
			System.out.println(sumNews);
			int sumPage = (int) Math.ceil((float) sumNews / Define.ROW_COUNT_ADMIN);
			request.setAttribute("sumPage", sumPage);
			int current_page = 1;
			if (request.getParameter("page") != null) {
				current_page = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("current_page", current_page);
			int offset = (current_page - 1) * Define.ROW_COUNT_ADMIN;
			ArrayList<Bai_Dang> listBD = bdDAO.getItemsPaginationByKey(objUserInfor.getId_sv(), key, offset,
					Define.ROW_COUNT_ADMIN);
			request.setAttribute("listBD", listBD);
			request.setAttribute("key", key);
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);
		}
	}

}
