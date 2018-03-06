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
import model.bean.Lop;
import model.bean.Nhom;
import model.bean.SV;
import model.dao.KhoaDAO;
import model.dao.LopDAO;
import model.dao.NhomDAO;
import model.dao.SVDAO;
import model.dao.Thanh_Vien_NhomDAO;
import util.AuthUtil;
import util.GetFileNameUtil;

@MultipartConfig
/**
 * Servlet implementation class IndexController
 */
public class EditClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditClassController() {
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
			int idlop = Integer.parseInt(request.getParameter("idlop"));
			LopDAO lopDAO = new LopDAO();
			Lop objLop = lopDAO.getobject(idlop);
			request.setAttribute("objLop", objLop);
			KhoaDAO khoaDAO = new KhoaDAO();
			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) khoaDAO.getItems();
			request.setAttribute("listKhoa", listKhoa);
			RequestDispatcher rd = request.getRequestDispatcher("/editlop.jsp");
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
			String tenlop = request.getParameter("tenlop");
			LopDAO lopDAO = new LopDAO();
			int idlop = Integer.parseInt(request.getParameter("idlop"));
			int idkhoa = Integer.parseInt(request.getParameter("idkhoa"));
			HttpSession ses = request.getSession();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Lop objLop = new Lop(idlop, tenlop, idkhoa);
			Lop objLopOLD = lopDAO.getobject(idlop);
			if (SVLogin.getId_sv() != 1) {
				response.sendRedirect(request.getContextPath() + "/lop?&msg=4");
			} else {
				if (lopDAO.checkTenLop(tenlop) != null && !tenlop.equals(objLopOLD.getTen_lop())) {
					response.sendRedirect(request.getContextPath() + "/lop?msg=7");
				} else {
					if (lopDAO.editLop(objLop) > 0) {
						// ThÃªm thÃ nh cÃ´ng
						response.sendRedirect(request.getContextPath() + "/lop?&msg=2");
						return;
					} else {
						// thÃªm tháº¥t báº¡i
						response.sendRedirect(request.getContextPath() + "/lop?msg=3");
						return;
					}
				}
			}
		}
	}
}
