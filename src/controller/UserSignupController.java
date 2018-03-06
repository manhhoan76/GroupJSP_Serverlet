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
import javax.servlet.http.Part;

import model.bean.Khoa;
import model.bean.SV;
import model.dao.KhoaDAO;
import model.dao.SVDAO;
import util.GetFileNameUtil;

@MultipartConfig
/**
 * Servlet implementation class IndexController
 */
public class UserSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSignupController() {
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
		KhoaDAO khoaDAO = new KhoaDAO();
		ArrayList<Khoa> listKhoa = khoaDAO.getItemsByIDKHoa();
		request.setAttribute("listKhoa", listKhoa);
		RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
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
		String hovaten = request.getParameter("ho_va_ten");
		System.out.println(hovaten);
		String tendangnhap = request.getParameter("tendangnhap");
		String matkhau = request.getParameter("mat_khau");
		System.out.println(matkhau);
		int idlop = Integer.parseInt(request.getParameter("id_lop"));
		System.out.println(idlop);
		final Part part = request.getPart("hinhanh");
		// lấy tên file
		String filename = GetFileNameUtil.getFileName(part);
		if (!filename.isEmpty()) {
			// đường dẫn lưu file
			final String path = request.getServletContext().getRealPath("/files");
			System.out.println(path);
			File dirPath = new File(path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
			// ghi file
			String filePath = path + File.separator + filename;
			part.write(filePath);
		}
		SVDAO svDAO = new SVDAO();
		SV objSV = new SV(0, tendangnhap, hovaten, null, matkhau, idlop, null, 0, null, filename, null, null);
		if (svDAO.checkTenDN(tendangnhap) != null) {
			response.sendRedirect(request.getContextPath() + "/signup?msg=2");
			return;
		} else {
			if (svDAO.addSV(objSV) > 0) {
				// ThÃªm thÃ nh cÃ´ng
				response.sendRedirect(request.getContextPath() + "/login?msg=1");
				return;
			} else {
				// thÃªm tháº¥t báº¡i
				response.sendRedirect(request.getContextPath() + "/signup?msg=1");
				return;
			}
		}
	}

}
