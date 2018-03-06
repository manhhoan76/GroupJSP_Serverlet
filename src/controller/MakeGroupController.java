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

import model.bean.Khoa;
import model.bean.Nhom;
import model.bean.SV;
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
public class MakeGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeGroupController() {
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
			RequestDispatcher rd = request.getRequestDispatcher("/addgroup.jsp");
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
			String tennhom = request.getParameter("tennhom");
			System.out.println(tennhom);
			String mota = request.getParameter("mota");
			NhomDAO nhomDAO = new NhomDAO();
			HttpSession ses = request.getSession();
			Thanh_Vien_NhomDAO tvDAO = new Thanh_Vien_NhomDAO();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Nhom objNhom = new Nhom(0, tennhom, mota, 1, SVLogin.getId_sv(), null);
			if (nhomDAO.addNhom(objNhom) > 0) {
				Nhom objNhomAdd = (Nhom) nhomDAO.getObjNhomByID_Admin(SVLogin.getId_sv());
				tvDAO.addThanhVien(objNhomAdd.getId_nhom(), SVLogin.getId_sv());
				// ThÃªm thÃ nh cÃ´ng
				response.sendRedirect(request.getContextPath() + "/nhom?msg=1");
				return;
			} else {
				// thÃªm tháº¥t báº¡i
				response.sendRedirect(request.getContextPath() + "/nhom?msg=0");
				return;
			}
		}

	}
}
