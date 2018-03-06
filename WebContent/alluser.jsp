<%@page import="model.bean.Khoa"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        
        <div class="content">            
           
            <div class="decoration"></div>
             <div class="blog-posts">
            
            <div class="content-heading full-bottom">
                <h2>Tất cả các sinh viên</h2>
                <em>Trang hiển thị sinh viên</em>
                <i class="fa fa-user"></i>
            </div>
              <div class="decoration"></div>
            <select style="width: 150px; display: inline;" class="signup-password" onchange="showSV()" onclick="showLop(this)"  id="idkhoa"  name="id_khoa">
           		<option style="text-align:center;" value="0">------- Khoa ------</option>
            <%
					if(request.getAttribute("listKhoa") != null){
	          			ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("listKhoa");
						for(Khoa objKhoa: listKhoa){
						%>
					<option value="<%=objKhoa.getId_khoa()%>"><%=objKhoa.getTen_khoa() %></option>
					<% } } %>
				</select>
				<select style="width: 150px; display: inline;" class="signup-password" onchange="showSVLop()" id="idlop" name="id_lop">
					<option style="text-align:center;" value="0">------- Lớp ------</option>
				</select>
            <div class="decoration"></div>
            <div class="container">
               <div class="staff-slider" id="SV" data-snap-ignore="true">
                    <div >
                        <div class="owl-item" class="staff-item">
                        </div>
                    </div>
                </div>
            </div>  
            <div class="decoration"></div>
             <script language="javascript">
								function  showSV(){
									var idkhoa = document.getElementById("idkhoa").value;
									var idlop = document.getElementById("idlop").value;
									$.ajax({
										url: '<%=request.getContextPath()%>/showSV',
										type: 'POST',
										cache: false,
										data: {
												//Dữ liệu gửi đi
												iidkhoa : idkhoa,
												iidlop : idlop,
												},
										success: function(data){
											// Xử lý thành công
											$('#SV').html(data);
										},
										error: function (){
										// Xử lý nếu có lỗi
										alert('Loi');
										}
									});
								}
								function  showSVLop(){
									var idkhoa = document.getElementById("idkhoa").value;
									var idlop = document.getElementById("idlop").value;
									$.ajax({
										url: '<%=request.getContextPath()%>/showSV',
										type: 'POST',
										cache: false,
										data: {
												//Dữ liệu gửi đi
												iidkhoa : idkhoa,
												iidlop : idlop,
												},
										success: function(data){
											// Xử lý thành công
											$('#SV').html(data);
										},
										error: function (){
										// Xử lý nếu có lỗi
										alert('Loi');
										}
									});
								}
								function  showLop(obj){
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
											$('#idlop').html(data);
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