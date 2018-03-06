package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Lop;
import model.dao.LopDAO;

/**
 * Servlet implementation class AdminIndexController
 */
public class ShowLopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowLopController() {
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
		int  id = Integer.parseInt(request.getParameter("lid"));
		System.out.println(id);
		PrintWriter out = response.getWriter();
		LopDAO lopDAO = new LopDAO();
		ArrayList<Lop> listLop = lopDAO.getItemsByIDKHoa(id);
		if (listLop.size() != 0) {
			out.println(" <option style=\"text-align:center;\" value=\"0\">------- Lớp ------</option>");
			for (Lop objLop : listLop) {
				out.println(" <option value='"+objLop.getId_lop()+"'>"+objLop.getTen_lop()+"</option>");
			}
		}
		else {
			out.println(" <option value='0'>--Chưa có lớp--</option>");
		}
	}
}
