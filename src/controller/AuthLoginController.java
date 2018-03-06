package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SV;
import model.dao.SVDAO;
import util.StringLibrary;

/**
 * Servlet implementation class AdminIndexController
 */
public class AuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthLoginController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SVDAO svDAO = new SVDAO();
		StringLibrary library = new StringLibrary();
		String username = request.getParameter("tendangnhap");
		String password = request.getParameter("matkhau");
		HttpSession session = request.getSession();
		SV objSV = svDAO.getItem(username, password);
		if (svDAO.getItem(username, password) != null) {
				session.setAttribute("userLogin", objSV);
				response.sendRedirect(request.getContextPath() + "/trang-chu");
				return;
		} else {
			// thêm thất bại
			response.sendRedirect(request.getContextPath() + "/login?msg=0");
			return;
		}
	}
}
