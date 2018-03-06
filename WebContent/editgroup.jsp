<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
 
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
        <div class="content">
            
            <div class="blog-posts">
                <div class="blog-post">
                   
                    <h2 class="blog-post-title">Thêm nhóm mới</h2>
					
                <div class="decoration"></div>
                <%
                	if(request.getAttribute("objNhom") != null){
                		Nhom objNhom = (Nhom) request.getAttribute("objNhom");
                %>
				<form action="<%=request.getContextPath() %>/sua-nhom?idNhom=<%=objNhom.getId_nhom() %>" method="post">
					 <h5 class="blog-post-title">Tên nhóm</h5>
                     <input class="blog-search" type="text" value="<%=objNhom.getTen_nhom() %>" name="tennhom" placeholder="Tên nhóm">
					 <div class="decoration"></div>
					  <h5 class="blog-post-title">Mô tả nhóm</h5>
					 <textarea class="blog-search" style="height: 130px;"  name="mota" type="text" /><%=objNhom.getMo_ta() %></textarea>
					 <div class="decoration"></div>
					  <h5 class="blog-post-title">Tình trạng</h5>
					 <select class="signup-password" name="congkhai">
						<option value="1">Nhóm Công khai</option>
						<option value="0">Nhóm Kín</option>
					</select>
					<div class="decoration"></div>
					<input type="submit"  class="button button-green" style="width:100%;"  title="Sửa nhóm" value="Sửa thông tin nhóm">
                </form>
				</div>
                <div class="decoration"></div>
                <%} %>
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  