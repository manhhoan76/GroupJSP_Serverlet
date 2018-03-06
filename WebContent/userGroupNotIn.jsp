<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        <%
			if(request.getAttribute("listThanhVien") != null){
				Nhom InfoNhom = (Nhom) request.getAttribute("infoNhom");
			ArrayList<SV> listThanhVien = (ArrayList<SV>) request.getAttribute("listThanhVien");
			SV SVLogin = (SV) session.getAttribute("userLogin");
        %>
        <div class="content">            
           <a  class="button button-green" href="<%=request.getContextPath() %>/thamgiaNhom?idNhom=<%=InfoNhom.getId_nhom() %>&svid=<%=SVLogin.getId_sv() %>"  ><h3>Tham gia nhóm</h3></a>
            <div class="decoration"></div>
            <%
            int msg = (Integer) request.getAttribute("msg");
	  		switch (msg){
	  		case 1: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Bạn chưa tham gia nhóm!</p></div>");
	  		break;
	  	}
	  %>
             <div class="blog-posts">
            
            <div class="content-heading full-bottom">
                <h2>Các thành viên của nhóm</h2>
                <em>Hãy tham gia cùng chúng tôi</em>
                <i class="fa fa-user"></i>
            </div>
            
            <div class="decoration"></div>
            <div class="container">
                <a href="#" class="next-staff"></a>
                <a href="#" class="prev-staff"></a>
                <div class="staff-slider" data-snap-ignore="true">
                <%
                	for(SV objTV : listThanhVien){
                %>
                    <div>
                        <div class="staff-item">
                         <a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objTV.getId_sv()%>">  <img src="<%=request.getContextPath() %>/files/<%=objTV.getHinh_anh() %>" alt="<%=objTV.getHo_va_ten()%>"></a>
                            <a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objTV.getId_sv()%>"><h4><%=objTV.getHo_va_ten() %></h4></a>
                            <em><%=objTV.getTen_lop() %></em>
                            <strong><%=objTV.getTen_khoa() %></strong>
                        </div>
                    </div>
                    <%} %>
                </div>
            </div>  
            <div class="decoration"></div>
            <%} %>
            </div>
              <%@include file="/templates/inc/right_bar.jsp" %>   
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  