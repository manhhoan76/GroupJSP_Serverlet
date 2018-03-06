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
public class EditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditNewsController() {
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
			int idbd = Integer.parseInt(request.getParameter("idbd"));
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			Bai_Dang objBD = bdDAO.getObj(idbd);
			request.setAttribute("objBD", objBD);
			RequestDispatcher rd = request.getRequestDispatcher("/editnews.jsp");
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
			int idbd = Integer.parseInt(request.getParameter("idbd"));
			HttpSession ses = request.getSession();
			Bai_DangDAO bdDAO = new Bai_DangDAO();
			Bai_Dang objBDOld = bdDAO.getObj(idbd);
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Bai_Dang objBD = new Bai_Dang(idbd, tenBD, noidung, objBDOld.getId_nhom(), objBDOld.getNgay_tao(),
					SVLogin.getId_sv(), null, null);
			if (SVLogin.getId_sv() != objBDOld.getId_user()) {
				response.sendRedirect(
						request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objBDOld.getId_nhom() + "&msg=4");
			} else {
				if (bdDAO.editNhom(objBD) > 0) {
					// ThÃªm thÃ nh cÃ´ng
					response.sendRedirect(
							request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objBDOld.getId_nhom() + "&msg=2");
					return;
				} else {
					// thÃªm tháº¥t báº¡i
					response.sendRedirect(
							request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objBDOld.getId_nhom() + "&msg=3");
					return;
				}
			}
		}
	}
}
