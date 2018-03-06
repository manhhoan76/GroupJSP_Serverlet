<%@page import="model.bean.Khoa"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
 
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
        <div class="content">
            
            <div class="blog-posts">
                <div class="blog-post">
                   
                    <h2 class="blog-post-title">Thêm Lớp</h2>
					
                <div class="decoration"></div>
				<form action="<%=request.getContextPath() %>/tao-lop" method="post">
					 <h5 class="blog-post-title">Tên Lớp</h5>
                     <input class="blog-search" type="text" name="tenlop" placeholder="Tên lớp">
					 <div class="decoration"></div>
					 <select style="text-align:center;" class="signup-password" name="idkhoa">
					<option value="0">---------------------- Khoa ------------------------</option>
					<%
					if(request.getAttribute("listKhoa") != null){
	          			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("listKhoa");
						for(Khoa objKhoa: listKhoa){
						%>
					<option value="<%=objKhoa.getId_khoa()%>"><%=objKhoa.getTen_khoa() %></option>
					<% } } %>
				</select>
				<div class="decoration"></div>
					<input type="submit"  class="button button-green" style="width:100%;"  title="Thêm khoa" value="Thêm khoa">
                </form>
				</div>
                <div class="decoration"></div>
                
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  