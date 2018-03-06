package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Bai_Dang;
import model.bean.Khoa;
import model.bean.Nhom;
import model.bean.SV;
import model.dao.Bai_DangDAO;
import model.dao.KhoaDAO;
import model.dao.NhomDAO;
import model.dao.SVDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;
import util.GetFileNameUtil;

@MultipartConfig
/**
 * Servlet implementation class IndexController
 */
public class MakeNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeNewsController() {
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
			request.setAttribute("idNhom", idNhom);
			RequestDispatcher rd = request.getRequestDispatcher("/addnews.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (AuthUtil.checkUser(request) == false) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
			String tenBD = request.getParameter("tenbd");
			String noidung = request.getParameter("ndbd");
			int idNhom = Integer.parseInt(request.getParameter("idNhom"));
			HttpSession ses = request.getSession();
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Bai_Dang objBD = new Bai_Dang(0, tenBD, noidung, idNhom, null, SVLogin.getId_sv(), null, null);
			if (bdDAO.addBD(objBD) > 0) {
				// ThÃªm thÃ nh cÃ´ng
				response.sendRedirect(request.getContextPath() + "/chi-tiet-nhom?idNhom=" + idNhom + "&msg=5");
				return;
			} else {
				// thÃªm tháº¥t báº¡i
				response.sendRedirect(request.getContextPath() + "/chi-tiet-nhom?idNhom=" + idNhom + "&msg=6");
				return;
			}
		}
	}

}
