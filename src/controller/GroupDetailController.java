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
import model.bean.Nhom;
import model.bean.SV;
import model.dao.Bai_DangDAO;
import model.dao.NhomDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class GroupDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupDetailController() {
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
			HttpSession session = request.getSession();
			SV SVLogin = (SV) session.getAttribute("userLogin");
			Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
			if (tvDAO.checkThanhVien(SVLogin.getId_sv(), idNhom) != null) {
				Bai_DangDAO bdDAO = new Bai_DangDAO();
				int sumNews = bdDAO.countBai_DangByIDNhom(idNhom);
				int sumPage = (int) Math.ceil((float) sumNews / Define.ROW_COUNT_ADMIN);
				request.setAttribute("sumPage", sumPage);
				int current_page = 1;
				if (request.getParameter("page") != null) {
					current_page = Integer.parseInt(request.getParameter("page"));
				}
				request.setAttribute("current_page", current_page);
				int offset = (current_page - 1) * Define.ROW_COUNT_ADMIN;
				ArrayList<Bai_Dang> listBD = bdDAO.getItemsPaginationByidNhom(idNhom, offset, Define.ROW_COUNT_ADMIN);
				request.setAttribute("listBDNhom", listBD);
				request.setAttribute("idNhom", idNhom);
				NhomDAO nhomDAO = new NhomDAO();
				Nhom objNhom = nhomDAO.getItem(idNhom);
				request.setAttribute("infoNhom", objNhom);
				RequestDispatcher rd = request.getRequestDispatcher("/group-detail.jsp");
				rd.forward(request, response);
			} else {
				NhomDAO nhomDAO = new NhomDAO();
				Nhom objNhom = nhomDAO.getItem(idNhom);
				ArrayList<SV> listThanhVien = (ArrayList<SV>) tvDAO.getIThanhVienNhom(idNhom);
				request.setAttribute("listThanhVien", listThanhVien);
				request.setAttribute("infoNhom", objNhom);
				request.setAttribute("msg", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/userGroupNotIn.jsp");
				rd.forward(request, response);
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
