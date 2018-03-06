<%@page import="model.bean.Lop"%>
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
                   
                    <h2 class="blog-post-title">Sửa Lớp</h2>
					
                <div class="decoration"></div>
				<%
					if(request.getAttribute("objLop") != null){
						Lop objLop = (Lop) request.getAttribute("objLop");
				%>
				<form action="<%=request.getContextPath() %>/sua-lop?idlop=<%=objLop.getId_lop() %>" method="post">
					 <h5 class="blog-post-title">Tên Lớp</h5>
                     <input class="blog-search" type="text" value="<%=objLop.getTen_lop() %>" name="tenlop" placeholder="Tên Khoa">
					 <div class="decoration"></div>
					 <select style="text-align:center;" class="signup-password" name="idkhoa">
					<option value="0">---------------------- Khoa ------------------------</option>
					<%
					if(request.getAttribute("listKhoa") != null){
						String select="";
	          			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("listKhoa");
						for(Khoa objKhoa: listKhoa){
							if(objLop.getId_khoa() == objKhoa.getId_khoa()){
								select = "selected ='selected'";
							}else 
							{
								select="";
							}
						%>
					<option <%=select %> value="<%=objKhoa.getId_khoa()%>"><%=objKhoa.getTen_khoa() %></option>
					<% } } %>
				</select>
				<div class="decoration"></div>
					<input type="submit"  class="button button-green" style="width:100%;"  title="Thêm khoa" value="Thêm khoa">
                </form>
				</div>
                <div class="decoration"></div>
                <%} %>
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  