<%@page import="model.bean.Nhan_Xet"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
         <%
            	if(request.getAttribute("objBD") != null){
            		SV objLogin = (SV) session.getAttribute("userLogin");
            		Bai_Dang objBD = (Bai_Dang) request.getAttribute("objBD");
            %>
		<a style="margin-left: 70px;"  class="button button-green" href="<%=request.getContextPath() %>/tao-bai-dang?idNhom=<%=objBD.getId_nhom() %>"  ><h3>Tạo Bài viết mới +</h3></a>
		<%
			if(objLogin.getId_sv() == objBD.getId_user()){ 
		%>
		<a style="margin-left: 20px;"  onclick="return confirm('Bạn có muốn xóa không')" class="button button-green" href="<%=request.getContextPath() %>/xoa-bai-dang?idbd=<%=objBD.getId_bai_dang() %>"  ><h3>Xóa bài viết</h3></a>
		<a style="margin-left: 20px;" class="button button-green" href="<%=request.getContextPath() %>/sua-bai-dang?idbd=<%=objBD.getId_bai_dang() %>"  ><h3>Sửa bài viết</h3></a>
		<%} %>
		<div class="decoration"></div>
        <div class="content">
            
            
            <div class="blog-posts">
                <div class="blog-post">
               
                    <h2 class="blog-post-title"><a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objBD.getId_user()%>"><%=objBD.getHo_va_ten() %></a> [>] <a href="<%=request.getContextPath()%>/chi-tiet-nhom?idNhom=<%=objBD.getId_nhom()%>"><%=objBD.getTen_nhom() %></a></h2>
					<h4 class="blog-post-title"><%=objBD.getTen_bai_dang() %></h4>
					<span class="blog-post-date"><i class="fa fa-calendar"></i><%=objBD.getNgay_tao() %></span> <br />
					
                    <p class="blog-post-text">
                    <%=objBD.getNoi_dung() %>
                    </p>
                    
                    <div class="decoration"></div>
                    <%
                    	if(request.getAttribute("listNX") != null){
                    	ArrayList<Nhan_Xet> listNX = (ArrayList<Nhan_Xet>) request.getAttribute("listNX");
                    		for(Nhan_Xet objNX: listNX){
                    %>
                    
                   <p class="notification-page-item" style="width:100%;">
                    <a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objNX.getId_user()%>"><img src="<%=request.getContextPath() %>/files/<%=objNX.getHinh_anh() %>" alt="<%=objNX.getHo_va_ten()%>"></a>
                   	<a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objNX.getId_user()%>"><%=objNX.getHo_va_ten() %></a>
                    <em>
                    <%=objNX.getNoi_dung() %>
                    </em>
                   
                </p>
                <%}} %>
                <div class="decoration"></div>
				<form action="<%=request.getContextPath() %>/binhluan?idBD=<%=objBD.getId_bai_dang() %>&svid=<%=objLogin.getId_sv() %>" method="post">
                     <input class="blog-search" name="binhluan" type="text" placeholder="Bình luận">
                </form>
				</div>
                <div class="decoration"></div>
                <%} %>
            </div>
           <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  