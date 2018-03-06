package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Bai_Dang;
import model.bean.Nhan_Xet;
import model.dao.Bai_DangDAO;
import model.dao.Nhan_XetDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogController() {
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
			int idBD = Integer.parseInt(request.getParameter("idbd"));
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			Bai_Dang objBD = bdDAO.getObj(idBD);
			Nhan_XetDAO nxDAO = new Nhan_XetDAO();
			ArrayList<Nhan_Xet> listNX = nxDAO.getItems(idBD);
			request.setAttribute("objBD", objBD);
			request.setAttribute("listNX", listNX);
			RequestDispatcher rd = request.getRequestDispatcher("/blogdetail.jsp");
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
