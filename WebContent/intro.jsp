<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/inc/header.jsp" %>  
    
    <!-- Page Content-->
    <div id="content" class="snap-content">        
        
        <div class="coverpage-slider" data-snap-ignore="true">                     
            <div>
                <div class="overlay dark-overlay"></div>
                <div class="coverpage-image bg1 coverpage-style-1">
                    <p style="top:50%; margin-top:-50px;">
                        Chào mừng bạn đến với trang học tập nhóm
                    </p>
                    <a href="<%=request.getContextPath() %>/login" style="top:50%; margin-top:50px; left:50%; margin-left:-50px;" class="coverpage-button">Đăng nhập</a>
                </div>
            </div>

            <div>
                <div class="overlay dark-overlay"></div>
                <div class="coverpage-image bg2 coverpage-style-3">
                    <i class="fa fa-clock-o" style="left:50%; top:50%; margin-top:-120px;"></i>
                    <p style="left:50%; margin-left:-140px; top:50%; margin-top:-20px;">
                       Chào mừng bạn đến với trang học tập nhóm
                    </p>
                    <a href="<%=request.getContextPath() %>/login" style="top:50%; margin-top:100px; left:50%; margin-left:-50px;" class="coverpage-button">Đăng nhập</a>
                </div>
            </div>

            <div>
                <div class="overlay dark-overlay"></div>
                <div class="coverpage-image bg3 coverpage-style-2">
                    <h3 style="height:180px; top:50%; margin-top:-180px;">
                        FIND<br>
                        THE<br>
                        PERFECT<br>
                        DESIGN<br>
                    </h3>
                    <p style="height:100px; top:50%; margin-top:20px;">
                        Play along with the coverpage and 
                        you'll find the perfect combination 
                        that fits your needs.
                    </p>
                    <a style="top:50%; margin-top:140px; margin-left:25px;" href="<%=request.getContextPath() %>/login" class="coverpage-button">Đăng nhập</a>
                </div>
            </div>            
        </div>  
        
        <!-- Page Footer-->
        <%@include file="/templates/inc/footer.jsp" %>  