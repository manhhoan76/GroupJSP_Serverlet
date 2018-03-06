<%@page import="model.bean.SV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!-- Mirrored from enableds.com/products/tinybar/page-blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 14 Apr 2015 03:17:04 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/templates/images/splash/splash-icon.png">
<link rel="apple-touch-icon-precomposed" sizes="180x180" href="<%=request.getContextPath() %>/templates/images/splash/splash-icon-big.png">
<link rel="apple-touch-startup-image" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen.png" 	media="screen and (max-device-width: 320px)" />  
<link rel="apple-touch-startup-image" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen%402x.png" media="(max-device-width: 480px) and (-webkit-min-device-pixel-ratio: 2)" /> 
<link rel="apple-touch-startup-image" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-six.png" media="(device-width: 375px)">
<link rel="apple-touch-startup-image" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-six-plus.png" media="(device-width: 414px)">
<link rel="apple-touch-startup-image" sizes="640x1096" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen%403x.png" />
<link rel="apple-touch-startup-image" sizes="1024x748" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-ipad-landscape.html" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : landscape)" />
<link rel="apple-touch-startup-image" sizes="768x1004" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-ipad-portrait.png" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : portrait)" />
<link rel="apple-touch-startup-image" sizes="1536x2008" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-ipad-portrait-retina.png"   media="(device-width: 768px)	and (orientation: portrait)	and (-webkit-device-pixel-ratio: 2)"/>
<link rel="apple-touch-startup-image" sizes="1496x2048" href="<%=request.getContextPath() %>/templates/images/splash/splash-screen-ipad-landscape-retina.png"   media="(device-width: 768px)	and (orientation: landscape)	and (-webkit-device-pixel-ratio: 2)"/>
<title>Group -- Chia sẽ thông tin nhóm</title>
<link href="<%=request.getContextPath() %>/templates/styles/style.css"     		 rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/templates/styles/framework.css" 		 rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/templates/styles/owl.theme.css" 		 rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/templates/styles/swipebox.css"		 rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/templates/styles/font-awesome.css"	 rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/templates/styles/animate.css"			 rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/scripts/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/scripts/jqueryui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/scripts/framework.plugins.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/scripts/custom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/scripts/jquery-3.1.1.min.js"></script>
</head>
<body> 
<div id="preloader">
	<div id="status">
    	<p class="center-text">
			Đang tải dữ liệu
            <em>Bạn hãy chờ trong chốc lát!</em>
        </p>
    </div>
</div>
<div class="hide-content"></div>       
<div class="all-elements">
    <div class="snap-drawers">
        <!-- Left Sidebar -->
        <%
                	if(session.getAttribute("userLogin") != null){
                		SV objSV = (SV) session.getAttribute("userLogin");
                %>
        <div class="snap-drawer snap-drawer-left">
            <a href="<%=request.getContextPath() %>/trang-chu"><i class="fa fa-home"></i>Home</a>
            <a href="<%=request.getContextPath() %>/nhom"><i class="fa fa-cog"></i>Nhóm</a>
            <a href="<%=request.getContextPath() %>/sinh-vien"><i class="fa fa-envelope-o"></i>Sinh viên</a>
            <%
            	if(objSV.getId_sv() ==1){
            %>
             <a href="<%=request.getContextPath() %>/lop"><i class="fa fa-envelope-o"></i>Lớp</a>
              <a href="<%=request.getContextPath() %>/khoa"><i class="fa fa-envelope-o"></i>Khoa</a>
              <%} %>
            <a href="#" class="sidebar-close"><i class="fa fa-times"></i>Close</a>
        </div>
    </div>
     		
    <div class="header">
        <a href="<%=request.getContextPath() %>/trang-chu" class="main-logo"></a>
        <a href="<%=request.getContextPath() %>/trang-ca-nhan?svid=<%=objSV.getId_sv() %>"  class="open-call"><img style="margin-top: 18px; border-radius: 300px;"  width="40" height="40" src="<%=request.getContextPath() %>/files/<%=objSV.getHinh_anh() %>"  /></i></a>
        <a href="<%=request.getContextPath() %>/trang-ca-nhan?svid=<%=objSV.getId_sv() %>" class="open-call">Profile</a>
        <a href="<%=request.getContextPath() %>/logout" class="open-mail">Logout</a>
    </div> 
    <% } %>
    <a href="#" class="footer-ball"><i class="fa fa-navicon"></i></a>