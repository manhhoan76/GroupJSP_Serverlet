<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
        <div class="content">
            
            <div class="blog-posts">
                <div class="blog-post">
                   
                    <h2 class="blog-post-title">Thêm bài đăng mới</h2>
					<%
					if(request.getAttribute("objBD") != null){
						Bai_Dang objBD = (Bai_Dang) request.getAttribute("objBD");
					%>
                <div class="decoration"></div>
				<form action="<%=request.getContextPath() %>/sua-bai-dang?idbd=<%=objBD.getId_bai_dang() %>" method="post">
					 <h5 class="blog-post-title">Tên bài đăng</h5>
                     <input class="blog-search" type="text" name="tenbd" value="<%=objBD.getTen_bai_dang() %>" placeholder="Tên bài đăng">
					 <div class="decoration"></div>
					  <h5 class="blog-post-title">Nội dung bài đăng</h5>
					 <textarea class="blog-search" style="height: 130px;" name="ndbd" type="text"  /><%=objBD.getNoi_dung() %></textarea>
					 <div class="decoration"></div>
					
					<input type="submit"  class="button button-green" style="width:100%;"  title="Sửa bài đăng" value="Sửa bài đăng">
                </form>
				</div>
                <div class="decoration"></div>
                <%} %>
            </div>
           <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  