<%@page import="model.bean.Khoa"%>
<%@page import="model.bean.Lop"%>
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
	 	  		case 4: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Bạn không có quyền sửa nhóm này!</p></div>");
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
		<a href="<%=request.getContextPath() %>/tao-lop"  ><h3>Thêm Lớp +</h3></a>
		<div class="decoration"></div>
		 <div class="blog-posts">
            <div class="portfolio-one">
            <% if(request.getAttribute("listLop") != null){
            	ArrayList<Lop> listlop = (ArrayList<Lop>) request.getAttribute("listLop");
            	ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("listKhoa");
            	for(Lop objlop : listlop){
            %>
                <div class="portfolio-one-item full-bottom">
                  
                    <div style="width: 100%;" class="portfolio-one-text">
                       <h3 class="title"><%=objlop.getTen_lop() %></h3>
                        <div class="portfolio-one-details">
                        <%
                        	for(Khoa objKhoa : listKhoa){
                       			if(objlop.getId_khoa() == objKhoa.getId_khoa()){
                        		%>
                            <p><%=objKhoa.getTen_khoa()%></p>
                            <%} }%>
                        </div>
                        <div class="portfolio-one-links">
                            <a href="<%=request.getContextPath()%>/sua-lop?idlop=<%=objlop.getId_lop()%>">Sửa Lớp<i class="fa fa-link"></i></a>
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
				String urlSEOFirst = request.getContextPath()+"/lop?page=1";
				String urlSEOLast = request.getContextPath()+"/lop?page="+sumPage;
				String urlSEOPre = request.getContextPath()+"/lop?page="+pre;
				String urlSEONext = request.getContextPath()+"/lop?page="+next;
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
						String urlSEO = request.getContextPath()+"/lop?page="+i;
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
					String urlSEO = request.getContextPath()+"/lop?page="+i;if (i==1){
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
					String urlSEO = request.getContextPath()+"/lop?page="+i;
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