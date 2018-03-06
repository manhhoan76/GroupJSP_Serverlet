<%@page import="model.dao.NhomDAO"%>
<%@page import="model.bean.Nhom"%>
<%@page import="model.dao.Bai_DangDAO"%>
<%@page import="model.dao.SVDAO"%>
<%@page import="model.bean.Bai_Dang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.SV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="blog-sidebar">
                <div class="decoration hide-if-responsive"></div>
                <div class="widget container">
                    <h4>Tìm kiếm</h4>
                    <form action="<%=request.getContextPath() %>/tim-kiem" method="post">
                    <input class="blog-search" name="key" type="text" placeholder="Tìm kiếm...">
               		</form>
                </div>
                <div class="decoration"></div>
                <div class="widget container">
                    <h3>Bài đăng gần đây của bạn</h3>
                    <%
                    	SV objSVLogin = (SV) session.getAttribute("userLogin");
                    	Bai_DangDAO bdDAO = new Bai_DangDAO();
                    	ArrayList<Bai_Dang> listBDMakeUser = (ArrayList<Bai_Dang>) bdDAO.getItemsMakeByUser(objSVLogin.getId_sv());
                    	if(listBDMakeUser.size() >0 ){
                    		for(Bai_Dang objBD : listBDMakeUser){
                    %>
					<div>
						<a href="<%=request.getContextPath()%>/chi-tiet-nhom?idNhom=<%=objBD.getId_nhom()%>"><h5><%=objBD.getTen_nhom() %></h5></a>
						<a href="<%=request.getContextPath()%>/bai-dang?idbd=<%=objBD.getId_bai_dang()%>"><p>
                        <%=objBD.getTen_bai_dang() %>
                    </p></a>
					</div>
					<% 	}
                    	} %>
                </div>
                <div class="widget container">
                    <h3>Nhóm của bạn</h3>
                    <p>
                        Bạn đã tham gia các nhóm
                    </p>
                    <div class="one-half">
                        <ul class="blog-category">
                        <%
                        NhomDAO nhomDAO = new NhomDAO();
                        ArrayList<Nhom> listNhomByUser = (ArrayList<Nhom>) nhomDAO.getItemsBySV(objSVLogin.getId_sv());
                        if(listNhomByUser.size() >0 ){
                    		for(Nhom objNhom : listNhomByUser){
                        %>
                            <li><a href="<%=request.getContextPath() %>/chi-tiet-nhom?idNhom=<%=objNhom.getId_nhom()%>"><i class="fa fa-angle-right"></i><%=objNhom.getTen_nhom() %></a></li>
                            <% }} %>
                        </ul>
                    </div>
                    
                    <div class="clear"></div>
                </div>
            </div>
            <div class="decoration"></div>