<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
         <%
	  	if (request.getParameter("msg") != null){
	  		int msg = Integer.parseInt(request.getParameter("msg"));
	  		switch (msg){
	  		case 1: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Bạn đã thêm lop thành công!</p></div>");
	  		break;
	  		case 0: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Thêm nhóm thất bại!</p></div>");
	  		break;
	 	  		case 2: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Sửa thành công!</p></div>");
	 	  		break;
	 	  		case 3: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Sửa thất bại!</p></div>");
	 	  		break;
	 	  		case 4: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Bạn không có quyền sửa!</p></div>");
	 	  		break;
	 	  		case 5: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Thêm bài viết thành công!</p></div>");
	 	  		break;
	 	  		case 6: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Thêm thất bại!</p></div>");
	 	  		break;
	 	  		case 7: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Lớp đã tồn tại!</p></div>");
	 	  		break;
	 	  		}
	 	  	}
	 	  %>
        <div class="content">
            
            <div class="blog-posts">
                <div class="blog-post">
                   <%
                   	if(request.getAttribute("objSV") != null){
                   		SV objSV = (SV) request.getAttribute("objSV");
                   %>
                    <h2 class="blog-post-title">Trang cá nhân: <%=objSV.getHo_va_ten() %></h2>
					
                <div class="decoration"></div>
				
				<img style="margin-top: 18px; border-radius: 300px; margin-bottom: 40px;"  width="200" height="200" src="<%=request.getContextPath()%>/files/<%=objSV.getHinh_anh() %>"  />
				<h4 class="blog-post-title">Ảnh đại diện</h4>
				 <div class="decoration"></div>
					 <h4 class="blog-post-title">Lớp: <%=objSV.getTen_lop() %></h4>
					 <div class="decoration"></div>
					 <h4 class="blog-post-title">Khoa: <%=objSV.getTen_khoa() %></h4>
					 <div class="decoration"></div>
					 <h4 class="blog-post-title">Email: <%=objSV.getEmail() %></h4>
					 <div class="decoration"></div>
					 <h4 class="blog-post-title">Địa chỉ: <%=objSV.getDia_chi() %></h4>
					 <div class="decoration"></div>
					  <h4 class="blog-post-title">Số ĐT: <%=objSV.getSo_dt() %></h4>
					 <div class="decoration"></div>
					 <%
					 SV SVLogin = (SV) session.getAttribute("userLogin");
					 	if(SVLogin.getId_sv() == objSV.getId_sv()){
					 %>
					<a href="<%=request.getContextPath()%>/sua-thong-tin-ca-nhan?svid=<%=objSV.getId_sv()%>"><input type="submit"  class="button button-green" style="width:100%;"  title="Sửa thông tin" value="Sửa thông tin"></a>
                	<div class="decoration"></div>
                	<%}} %>
				</div>
                
                
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>              
        </div>
        <!-- Page Footer-->
<%@include file="/templates/inc/footer.jsp" %>  