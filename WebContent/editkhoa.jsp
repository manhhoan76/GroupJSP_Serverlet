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
                   
					<%
						if(request.getAttribute("objKhoa") != null){
							Khoa objKhoa = (Khoa) request.getAttribute("objKhoa");
					%>
                <div class="decoration"></div>
				<form action="<%=request.getContextPath() %>/sua-khoa?idkhoa=<%=objKhoa.getId_khoa() %>" method="post">
					 <h5 class="blog-post-title">Tên Khoa</h5>
                     <input class="blog-search" type="text" value="<%=objKhoa.getTen_khoa() %>" name="tenkhoa"  placeholder="Tên Khoa">
					 <div class="decoration"></div>
					<input type="submit"  class="button button-green" style="width:100%;"  title="Sửa khoa" value="Sửa khoa">
                </form>
                <%} %>
				</div>
                <div class="decoration"></div>
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  