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
import model.bean.SV;
import model.dao.KhoaDAO;
import model.dao.SVDAO;
import util.AuthUtil;
import util.GetFileNameUtil;

@MultipartConfig
/**
 * Servlet implementation class IndexController
 */
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserController() {
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
			int svid = Integer.parseInt(request.getParameter("svid"));
			SVDAO svdao = new SVDAO();
			SV objSV = (SV) svdao.getObj(svid);
			request.setAttribute("objSV", objSV);
			KhoaDAO khoaDAO = new KhoaDAO();
			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) khoaDAO.getItems();
			request.setAttribute("listKhoa", listKhoa);
			RequestDispatcher rd = request.getRequestDispatcher("/editsv.jsp");
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
			int idSV = Integer.parseInt(request.getParameter("svid"));
			int idlop = Integer.parseInt(request.getParameter("idlop"));
			String hovaten = request.getParameter("ho_va_ten");
			String matkhau = request.getParameter("matkhau");
			String email = request.getParameter("email");
			String diachi = request.getParameter("diachi");
			String sodt = request.getParameter("sodt");
			SVDAO svdao = new SVDAO();
			HttpSession ses = request.getSession();
			SV SVLogin = (SV) ses.getAttribute("userLogin");
			// đường dẫn lưu file
			final String path = request.getServletContext().getRealPath("/files");
			// Xử lý upload ảnh
			final Part part = request.getPart("hinhanh");
			System.out.println(part);
			// lấy tên file
			String filename = GetFileNameUtil.getFileName(part);
			if (!filename.isEmpty()) {
				if (!"".equals(svdao.getObj(idSV).getHinh_anh())) {
					// xoa hinh anh cu
					String urlFileDel = path + File.separator + svdao.getObj(idSV).getHinh_anh();
					File delFile = new File(urlFileDel);
					delFile.delete();
				}
				// ghi file

				File dirPath = new File(path);
				if (!dirPath.exists()) {
					dirPath.mkdir();
				}
				String filePath = path + File.separator + filename;
				System.out.println(filePath);
				part.write(filePath);
			} else {
				filename = svdao.getObj(idSV).getHinh_anh();
			}
			if ("".equals(matkhau)) {
				// lay lai pass cu
				matkhau = svdao.getObj(idSV).getMat_khau();
			}
			SV objSV = new SV(idSV, null, hovaten, email, matkhau, idlop, null, 0, null, filename, diachi, sodt);
			if (SVLogin.getId_sv() != idSV) {
				response.sendRedirect(request.getContextPath() + "/trang-ca-nhan?svid=" + idSV + "&msg=4");
			} else {
				if (svdao.editSV(objSV) > 0) {
					response.sendRedirect(request.getContextPath() + "/trang-ca-nhan?svid=" + idSV + "&msg=2");
				} else {
					response.sendRedirect(request.getContextPath() + "/trang-ca-nhan?svid=" + idSV + "&msg=3");
				}
			}
		}
	}
}
