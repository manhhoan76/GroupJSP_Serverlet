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
public class MakeFactoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeFactoryController() {
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
			RequestDispatcher rd = request.getRequestDispatcher("/addkhoa.jsp");
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
			String tenkhoa = request.getParameter("tenkhoa");
			KhoaDAO khoaDAO = new KhoaDAO();
			HttpSession ses = request.getSession();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			Khoa objKhoa = new Khoa(0, tenkhoa);
			if (SVLogin.getId_sv() != 1) {
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			} else {
				if (khoaDAO.addKhoa(objKhoa) > 0) {
					// ThÃªm thÃ nh cÃ´ng
					response.sendRedirect(request.getContextPath() + "/khoa?msg=1");
					return;
				} else {
					// thÃªm tháº¥t báº¡i
					response.sendRedirect(request.getContextPath() + "/khoa?msg=0");
					return;
				}
			}
		}

	}
}
