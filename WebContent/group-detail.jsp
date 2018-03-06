<%@page import="model.bean.Bai_Dang"%>
<%@page import="java.util.ArrayList"%>
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
	  		case 1: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>ADMIN không được thoát khỏi nhóm!</p></div>");
	  		break;
	  		case 2: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Sửa thành công!</p></div>");
	  		break;
	  		case 3: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Sửa thất bại!</p></div>");
	  		break;
	  		case 4: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Bạn không có quyền sửa nhóm này!</p></div>");
	  		break;
	  		case 5: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Thêm bài viết thành công!</p></div>");
	  		break;
	  		case 6: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Thêm thất bại!</p></div>");
	  		break;
	  		case 7: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Xóa thành công!</p></div>");
	  		break;
	  		}
	  	}
	  %>
        <%
        if(request.getAttribute("listBDNhom") != null ){
    		int idNhom = (Integer) request.getAttribute("idNhom");
    		SV SVLogin = (SV) session.getAttribute("userLogin");
    		Nhom InfoNhom = (Nhom) request.getAttribute("infoNhom");
        %>
        <a style="margin-left: 70px;" class="button button-green" href="<%=request.getContextPath() %>/tao-bai-dang?idNhom=<%=InfoNhom.getId_nhom() %>"  ><h3>Tạo Bài viết mới +</h3></a>
		<a style="margin-left: 20px;" class="button button-green" href="<%=request.getContextPath()%>/thanh-vien-nhom?idNhom=<%=idNhom %>"  ><h3>Thành viên nhóm</h3></a>
		<%
			if(SVLogin.getId_sv() == 1 || SVLogin.getId_sv() == InfoNhom.getId_admin()){
		%>
		<a style="margin-left: 20px;" class="button button-green" href="<%=request.getContextPath()%>/sua-nhom?idNhom=<%=idNhom %>"  ><h3>Sửa thông tin</h3></a>
		<a style="margin-left: 20px;" onclick="return confirm('Bạn có chắc chắn không!')" class="button button-green" href="<%=request.getContextPath()%>/delNhom?idNhom=<%=idNhom %>"  ><h3>Xóa Nhóm</h3></a>
		<%} %>
		<a style="margin-left: 20px;" onclick="return confirm('Bạn có chắc chắn không!')" class="button button-green" href="<%=request.getContextPath()%>/thoatNhom?idNhom=<%=idNhom %>&svid=<%=SVLogin.getId_sv() %>"  ><h3>Thoát khỏi nhóm</h3></a>
		<div class="decoration"></div>
        <div class="content">
            
            <div class="blog-posts">
            <%
            	
            		ArrayList<Bai_Dang> listBD = (ArrayList<Bai_Dang>) request.getAttribute("listBDNhom");
            		for(Bai_Dang objBD : listBD){
            %>
                <div class="blog-post">
                    <h2 class="blog-post-title"><a href="<%=request.getContextPath()%>/trang-ca-nhan?svid=<%=objBD.getId_user()%>"><%=objBD.getHo_va_ten() %></a> [>] <a href="<%=request.getContextPath()%>/chi-tiet-nhom?idNhom=<%=objBD.getId_nhom()%>"><%=objBD.getTen_nhom() %></a></h2>
                    <h3 class="blog-post-title"><a href="<%=request.getContextPath()%>/bai-dang?idbd=<%=objBD.getId_bai_dang()%>" style="color: black;"><%=objBD.getTen_bai_dang() %></a></h3>
                    <p class="blog-post-text">
                    <%=objBD.getNoi_dung() %>
                    </p>
                    <p class="blog-post-date"><i class="fa fa-calendar"></i><%=objBD.getNgay_tao() %></p>
                    <p class="blog-post-more"><a href="<%=request.getContextPath()%>/bai-dang?idbd=<%=objBD.getId_bai_dang()%>" style="color: black;">Chi tiết<i class="fa fa-angle-right"></i></a></p>
                </div>
                <div class="decoration"></div>
              <%} %>
            	<div class="pagination" style="margin-left: 23px;   margin-top: -31px;">  
                <div class="numbers">
			<%
				if (request.getAttribute("sumPage")!= null){
				int current_page = (Integer) request.getAttribute("current_page");
				int sumPage = (Integer) request.getAttribute("sumPage");
				String active="";
				int pre = current_page-1;
				int next = current_page+1;
				String urlSEOFirst = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page=1";
				String urlSEOLast = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+sumPage;
				String urlSEOPre = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+pre;
				String urlSEONext = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+next;
				%>
				<% if (pre <=0) {%>
				<p><a href="<%=urlSEOFirst%>">[<]</a>
				<% }else { %>
				<p><a href="<%=urlSEOPre%>">[<]</a>
				<%} %>
				<%
				if (sumPage <4) {
					for (int i=1; i<=sumPage;i++){
						if (current_page == i){
							active = "class='active'";
						}else {
							active ="";
						}
						String urlSEO = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+i;
						if (i==1){
							%>	
								<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>"><%=i %></a>
								<%} else {%>
								<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>">|<%=i %></a>
								<%
								}}} else {
				if (current_page <(sumPage-3) && sumPage>3){
				for (int i=current_page; i<=current_page+3;i++){
					if (current_page == i){
						active = "class='active'";
					}else {
						active ="";
					}
					String urlSEO = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+i;if (i==1){
						%>	
						<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>"><%=i %></a>
						<%} else {%>
						<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>">|<%=i %></a>
						<%
						}}}} 
				if (current_page>=(sumPage-3) && sumPage >3) { 
				   for (int i=sumPage-3; i<=sumPage;i++){
					if (current_page == i){
						active = "class='active btn btn-success btn-xs'";
					}else {
						active ="";
					}
					String urlSEO = request.getContextPath()+"/chi-tiet-nhom?idNhom="+idNhom+"&page="+i;
					if (i==1){
						%>	
							<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>"><%=i %></a>
							<%} else {%>
							<a <%=active %> style=" text-align: center;" href="<%=urlSEO%>">|<%=i %></a>
							<%
							}} }%>
				<% if (next >= sumPage) {%>
				<a href="<%=urlSEOLast%>">[>]</a></p>
				<% }else { %>
				<a href="<%=urlSEONext%>">[>]</a></p>
				<%} %>
				<%} %>
				  <% 	
            	} %>
			</div> 
			</div>
            </div>
<%@include file="/templates/inc/right_bar.jsp" %>              
        </div>
        <!-- Page Footer-->
<%@include file="/templates/inc/footer.jsp" %>  