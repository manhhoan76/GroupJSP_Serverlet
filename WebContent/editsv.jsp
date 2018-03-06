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
                   
                    <h2 class="blog-post-title">Thêm nhóm mới</h2>
					
                <div class="decoration"></div>
                <%
                if(request.getAttribute("objSV") != null){
          			SV objSV = (SV) request.getAttribute("objSV");
                %>
				<form enctype="multipart/form-data"  action="<%=request.getContextPath() %>/sua-thong-tin-ca-nhan?svid=<%=objSV.getId_sv() %>" method="post">
				 <h5 class="blog-post-title">Họ và tên</h5>
				<input  type="text" class="blog-search" name="ho_va_ten" value="<%=objSV.getHo_va_ten() %>" placeholder="Họ và tên" />
				 <div class="decoration"></div>
				 <h5 class="blog-post-title">Khoa</h5>
				<select style="text-align:center;" class="signup-password" onchange="showlop(this)" name="khoa">
					<option value="0">---------------------- Khoa ------------------------</option>
					<%
					if(request.getAttribute("listKhoa") != null){
	          			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("listKhoa");
						for(Khoa objKhoa: listKhoa){
						%>
					<option value="<%=objKhoa.getId_khoa()%>"><%=objKhoa.getTen_khoa() %></option>
					<% } } %>
				</select>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Lớp</h5>
				<select class="blog-search" id="showLop"  name="idlop">
					<option style="text-align:center;" value="0">----------------------- Lớp -----------------------</option>
				</select>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Email</h5>
				<input type="text" class="blog-search"  value="<%=objSV.getEmail() %>" name="email" placeholder="Email"/>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Mật khẩu mới</h5>
				<input type="password" class="blog-search"  name="matkhau" placeholder="Mật khẩu mới"/>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Địa chỉ</h5>
				<input type="text" class="blog-search" value="<%=objSV.getDia_chi() %>" name="diachi" placeholder="Địa chỉ"/>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Số điện thoại</h5>
				<input type="text" class="blog-search" value="<%=objSV.getSo_dt() %>" name="sodt" placeholder="Số Điện thoại"/>
				 <div class="decoration"></div>
				<h5 class="blog-post-title">Ảnh đại diện</h5>
				<input type="file" class="blog-search"  name="hinhanh" />
				 <div class="decoration"></div>
				<input type="submit" class="button-green" style="width:100%; height: 40px;"  title="Sửa thông tin" value="Sửa thông tin">
				</form>
				</div>
				<%} %>
                <div class="decoration"></div>
                 <script language="javascript">
								function  showlop(obj){
									var id = obj.value;
									$.ajax({
										url: '<%=request.getContextPath()%>/showLop',
										type: 'POST',
										cache: false,
										data: {
												//Dữ liệu gửi đi
												lid : id,
												},
										success: function(data){
											// Xử lý thành công
											$('#showLop').html(data);
										},
										error: function (){
										// Xử lý nếu có lỗi
										alert('Loi');
										}
									});
								}
							</script>
               
            </div>
            <%@include file="/templates/inc/right_bar.jsp" %>   
            
        </div>
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  