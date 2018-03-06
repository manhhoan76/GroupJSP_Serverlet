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
	  		case 1: out.print("  <div class='static-notification-green'><p class='center-text uppercase'>Bạn đã tạo nhóm thành công!</p></div>");
	  		break;
	  		case 0: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Tạo nhóm thất bại!</p></div>");
	  		break;
	  		}
	  	}
	  %>
        <div class="content">
		<a href="<%=request.getContextPath() %>/tao-nhom"  ><h3>Tạo nhóm mới +</h3></a>
		<div class="decoration"></div>
		 <div class="blog-posts">
            <div class="portfolio-one">
            <% if(request.getAttribute("listNhomCK") != null){
            	ArrayList<Nhom> listNhomCK = (ArrayList<Nhom>) request.getAttribute("listNhomCK");
            	for(Nhom objNhomck : listNhomCK){
            %>
                <div class="portfolio-one-item full-bottom">
                  
                    <div style="width: 100%;" class="portfolio-one-text">
                        <a href="<%=request.getContextPath()%>/chi-tiet-nhom?idNhom=<%=objNhomck.getId_nhom()%>"><h3 class="title"><%=objNhomck.getTen_nhom() %></h3></a>
                        <div class="portfolio-one-details">
                            <p><%=objNhomck.getNgay_tao() %></p>
                        </div>
                        <p class="half-bottom">
                        <%=objNhomck.getMo_ta() %>
                        </p>            
                        <div class="portfolio-one-links">
                            <a onclick="return confirm('Bạn có muốn xóa không')" href="<%=request.getContextPath()%>/delNhom?idNhom=<%=objNhomck.getId_nhom()%>"><i class="fa fa-arrow-right"></i> Xóa</a>
                            <a href="<%=request.getContextPath()%>/chi-tiet-nhom?idNhom=<%=objNhomck.getId_nhom()%>">Chi tiết<i class="fa fa-link"></i></a>
                        </div> 
                    </div>       
                </div>
                <div class="decoration"></div>
                <% }} %>
            </div>
            <div class="pagination" style="margin-left: 23px;   margin-top: -31px;">  
                <div class="numbers">
			<%
				if (request.getAttribute("sumPage")!= null){
				int current_page = (Integer) request.getAttribute("current_page");
				int sumPage = (Integer) request.getAttribute("sumPage");
				String active="";
				int pre = current_page-1;
				int next = current_page+1;
				String urlSEOFirst = request.getContextPath()+"/nhom?page=1";
				String urlSEOLast = request.getContextPath()+"/nhom?page="+sumPage;
				String urlSEOPre = request.getContextPath()+"/nhom?page="+pre;
				String urlSEONext = request.getContextPath()+"/nhom?page="+next;
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
						String urlSEO = request.getContextPath()+"/nhom?page="+i;
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
					String urlSEO = request.getContextPath()+"/nhom?page="+i;if (i==1){
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
					String urlSEO = request.getContextPath()+"/nhom?page="+i;
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
			</div> 
			</div>
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  