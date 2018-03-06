<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        
        <div class="content">            
            <div class="decoration"></div>
            	<%
	  	if (request.getParameter("msg") != null){
	  		int msg = Integer.parseInt(request.getParameter("msg"));
	  		switch (msg){
	  		case 1: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Không được xóa ADMIN!</p></div>");
	  		break;
	  		case 2: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Bạn đã xóa thành công!</p></div>");
	  		break;
	  		}
	  	}
	  %>
             <div class="blog-posts">
            
            <div class="content-heading full-bottom">
                <h2>Những thành viên của nhóm</h2>
                <em>Chào mừng các bạn đến với nhóm</em>
                <i class="fa fa-user"></i>
            </div>
            
            <div class="decoration"></div>
            <div class="container">
                <a href="#" class="next-staff"></a>
                <a href="#" class="prev-staff"></a>
                <div class="staff-slider" data-snap-ignore="true">
                    <%
    					if(request.getAttribute("listThanhVien") != null){
    						Nhom infoNhom = (Nhom) request.getAttribute("infoNhom");
    						ArrayList<SV> listThanhVien =(ArrayList<SV>) request.getAttribute("listThanhVien");
    						SV SVLogin = (SV) session.getAttribute("userLogin");
    						for(SV objTV : listThanhVien){
	                    %>
                    <div>
                        <div class="staff-item">
                           <a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objTV.getId_sv()%>">  <img src="<%=request.getContextPath() %>/files/<%=objTV.getHinh_anh() %>" alt="<%=objTV.getHo_va_ten()%>"></a>
                            <a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objTV.getId_sv()%>"><h4><%=objTV.getHo_va_ten() %></h4></a>
                            <em><%=objTV.getTen_lop() %></em>
                            <strong><%=objTV.getTen_khoa() %></strong>
                            <%
                            	if(SVLogin.getId_sv() == infoNhom.getId_admin())
                            	{
                            %>
                            <a onclick="return confirm('Bạn có muốn xóa không')" href="<%=request.getContextPath() %>/delTV?svid=<%=objTV.getId_sv() %>&idNhom=<%=infoNhom.getId_nhom() %>" class="button button-red center-button">Xóa khỏi nhóm</a>
                            <% } %>
                        </div>
                    </div>
                    <%}} %>
                </div>
            </div>  
            <div class="decoration"></div>
            
            </div>
              <%@include file="/templates/inc/right_bar.jsp" %>   
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  