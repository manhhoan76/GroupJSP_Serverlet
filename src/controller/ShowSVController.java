package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Lop;
import model.bean.SV;
import model.dao.LopDAO;
import model.dao.SVDAO;

/**
 * Servlet implementation class AdminIndexController
 */
public class ShowSVController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowSVController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int idkhoa = Integer.parseInt(request.getParameter("iidkhoa"));
		int idlop = Integer.parseInt(request.getParameter("iidlop"));
		System.out.println(idkhoa + "--" + idlop);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		SV SVLogin = (SV) session.getAttribute("userLogin");
		SVDAO svDAO = new SVDAO();
		if (idlop == 0) {
			ArrayList<SV> listSV = svDAO.getSVByIdKhoa(idkhoa);
			if (listSV.size() != 0) {
				for (SV objSV : listSV) {

					String s = "<div class=\"owl-item\" style=\"width: 280px;\">\r\n" + "                        <div class=\"staff-item\">\r\n"
							+ "                           <a href=\"" + request.getContextPath()
							+ "/trang-ca-nhan?svid=" + objSV.getId_sv() + "\">  <img src=\"" + request.getContextPath()
							+ "/files/" + objSV.getHinh_anh() + "\" alt=\"" + objSV.getHo_va_ten() + "\"></a>\r\n"
							+ "                            <a href=\"" + request.getContextPath()
							+ "/trang-ca-nhan?svid=" + objSV.getId_sv() + "\"><h4>" + objSV.getHo_va_ten()
							+ "</h4></a>\r\n" + "                            <em>" + objSV.getTen_lop() + "</em>\r\n"
							+ "                            <strong>" + objSV.getTen_khoa() + "</strong>\r\n";
					String del = "   <a onclick=\"return confirm('Bạn có muốn xóa không')\" href=\""
							+ request.getContextPath()
							+ "/delSV?svid="+objSV.getId_sv()+"\" class=\"button button-red center-button\">Xóa SV</a>\r\n";
					String end = "                        </div>\r\n" + "                    </div>";
					if (SVLogin.getId_sv() == 1) {
						out.println(s+del+end);
					} else {
						out.println(s+end);
					}
				}
			} else {
				out.println("<div>\r\n" + 
						"                        <div class=\"staff-item\">\r\n" + 
						"                        </div>\r\n" + 
						"                    </div>");
			}
		} else {
			ArrayList<SV> listSV = svDAO.getSVByIdLop(idlop);
			if (listSV.size() != 0) {
				for (SV objSV : listSV) {
					String s = "<div class=\"owl-item\" style=\"width: 280px;\">\r\n" + "                        <div class=\"staff-item\">\r\n"
							+ "                           <a href=\"" + request.getContextPath()
							+ "/trang-ca-nhan?svid=" + objSV.getId_sv() + "\">  <img src=\"" + request.getContextPath()
							+ "/files/" + objSV.getHinh_anh() + "\" alt=\"" + objSV.getHo_va_ten() + "\"></a>\r\n"
							+ "                            <a href=\"" + request.getContextPath()
							+ "/trang-ca-nhan?svid=" + objSV.getId_sv() + "\"><h4>" + objSV.getHo_va_ten()
							+ "</h4></a>\r\n" + "                            <em>" + objSV.getTen_lop() + "</em>\r\n"
							+ "                            <strong>" + objSV.getTen_khoa() + "</strong>\r\n";
					String del = "   <a onclick=\"return confirm('Bạn có muốn xóa không')\" href=\""
							+ request.getContextPath()
							+ "/delSV?svid="+objSV.getId_sv()+"\" class=\"button button-red center-button\">Xóa SV</a>\r\n";
					String end = "                        </div>\r\n" + "                    </div>";
					if (SVLogin.getId_sv() == 1) {
						out.println(s+del+end);
					} else {
						out.println(s+end);
					}
				}
			} else {
				out.println("<div>\r\n" + 
						"                        <div class=\"staff-item\">\r\n" + 
						"                        </div>\r\n" + 
						"                    </div>");
			}
		}
	}
}
