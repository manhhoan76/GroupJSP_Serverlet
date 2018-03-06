<%@page import="java.io.UncheckedIOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Khoa"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
       
        
        <div class="signup-page bg2">
            <div class="signup-page-overlay">
			</div>
			<%
	  	if (request.getParameter("msg") != null){
	  		int msg = Integer.parseInt(request.getParameter("msg"));
	  		switch (msg){
	  		case 1: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Có lỗi xảy ra!</p></div>");
	  		break;
	  		case 2: out.print("  <div class='static-notification-red'><p class='center-text uppercase'>Bạn đã tạo trùng tên tài khoản!</p></div>");
	  		break;
	  		}
	  	}
	  %>
            <div class="signup-page-wrapper">
                <a href="#" class="signup-logo"></a>
                <p>
                    Hãy nhập các thông tin
                </p>
				<form enctype="multipart/form-data"  action="<%=request.getContextPath() %>/signup" method="post">
				<input  type="text" class="signup-password" name="ho_va_ten" placeholder="Họ và tên" />
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
				<select class="signup-password" id="showLop"  name="id_lop">
					<option style="text-align:center;" value="0">----------------------- Lớp -----------------------</option>
				</select>
				<input type="text" class="signup-password"  name="tendangnhap" placeholder="Tên đăng nhập"/>
				<input type="password" class="signup-password"  name="mat_khau" placeholder="Mật khẩu"/>
				<input type="file" class="signup-password"  name="hinhanh" />
				<input type="submit" class="button-green" style="width:100%;"  title="Thêm sinh viên" value="Thêm">
				</form>
                <div class="clear"></div>
              
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
         
        </div>
        
        <!-- Page Footer-->
      
        
    </div>
    
    
    
</div>

</body>

