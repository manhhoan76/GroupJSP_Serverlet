package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Nhan_Xet;
import model.dao.Nhan_XetDAO;
import util.AuthUtil;

/**
 * Servlet implementation class IndexController
 */
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (AuthUtil.checkUser(request) == false) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
		String binhluan = request.getParameter("binhluan");
		int idBD = Integer.parseInt(request.getParameter("idBD"));
		int  idSV = Integer.parseInt(request.getParameter("svid"));
		Nhan_Xet objNX = new Nhan_Xet(0, idBD, idSV, binhluan, null, null, null);
		Nhan_XetDAO nxDAO = new Nhan_XetDAO();
		nxDAO.addComment(objNX);
			response.sendRedirect(request.getContextPath() + "/bai-dang?idbd="+idBD);
	}
	}
}
