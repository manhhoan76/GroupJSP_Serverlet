<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <div class="header-clear"></div>
         
        <div class="login-page bg1">
       
            <div class="login-page-overlay"></div>
              <%
	  	if (request.getParameter("msg") != null){
	  		int msg = Integer.parseInt(request.getParameter("msg"));
	  		switch (msg){
	  		case 1: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Bạn đã tạo tài khoản thành công!</p></div>");
	  		break;
	  		case 2: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Bạn đã tạo tài khoản thành công!</p></div>");
	  		break;
	  		}
	  	}
	  %>
            <div class="login-page-wrapper">
                <a href="#" class="login-logo"></a>
                <p>
                   Nhập tên đăng nhập và mật khẩu của bạn 
                </p>
                <form action="<%=request.getContextPath() %>/login" method="post">
                <input type="text"  name="tendangnhap"   class="login-username" placeholder="Tên đăng nhập">
                <input type="password" class="login-password" name="matkhau" placeholder="Mật khẩu">
                
                <div class="one-half">
                    <input type="submit" class="button button-green" value="Login"/>
                </div>
                <div class="one-half last-column">
                    <a href="<%=request.getContextPath() %>/signup" class="button button-blue">Signup</a>
                </div>
                </form>
                <div class="clear"></div>
            </div>            
        </div>
        
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  