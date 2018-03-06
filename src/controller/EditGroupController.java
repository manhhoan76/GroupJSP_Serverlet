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
public class EditGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditGroupController() {
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
			int idnhom = Integer.parseInt(request.getParameter("idNhom"));
			NhomDAO nhomDAO = new NhomDAO();
			Nhom objNhom = nhomDAO.getItem(idnhom);
			request.setAttribute("objNhom", objNhom);
			RequestDispatcher rd = request.getRequestDispatcher("/editgroup.jsp");
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
			int idNhom = Integer.parseInt(request.getParameter("idNhom"));
			String tennhom = request.getParameter("tennhom");
			System.out.println(tennhom);
			String mota = request.getParameter("mota");
			int congkhai = Integer.parseInt(request.getParameter("congkhai"));
			NhomDAO nhomDAO = new NhomDAO();
			Nhom objNhomOld = nhomDAO.getItem(idNhom);
			HttpSession ses = request.getSession();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Nhom objNhom = new Nhom(objNhomOld.getId_nhom(), tennhom, mota, congkhai, SVLogin.getId_sv(),
					objNhomOld.getNgay_tao());
			if (SVLogin.getId_sv() != objNhomOld.getId_admin()) {
				response.sendRedirect(
						request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objNhomOld.getId_nhom() + "&msg=4");
			} else {
				if (nhomDAO.editNhom(objNhom) > 0) {
					// ThÃªm thÃ nh cÃ´ng
					response.sendRedirect(
							request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objNhomOld.getId_nhom() + "&msg=2");
					return;
				} else {
					// thÃªm tháº¥t báº¡i
					response.sendRedirect(
							request.getContextPath() + "/chi-tiet-nhom?idNhom=" + objNhomOld.getId_nhom() + "&msg=3");
					return;
				}
			}
		}
	}
}
