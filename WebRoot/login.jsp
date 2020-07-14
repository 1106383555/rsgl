<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
 <style type="text/css">
    .login-page{background: #fff url("<%=path%>/images/login-bg.jpg");}
    .login-box, .register-box{width:360px;}
    .login-logo a{color:#ffffff;font-weight: bold;text-shadow:5px 2px 6px #666666;}
     html { overflow-x: hidden; overflow-y: hidden; }
    </style>
<title>小区物业人事管理系统</title>
</head>
<body class="hold-transition login-page" style="">
  <div class="login-box">
    <div class="login-logo">
      <a href="#">小区物业人事管理系统</a>
       
    </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">管理后台</p>
    <form action="#" method="post" id="loginForm" class="form-horizontal">
    <div class="box-body">
      <div class="form-group has-feedback">
          <input type="text" name="uname" id="uname" class="form-control" placeholder="用户名">
          <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" name="upwd" id="upwd" class="form-control" placeholder="密码">
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
           <select class="form-control" name="utype" id="utype" >
              <option value="">请选择登录身份</option>
              <option value="1">员工</option>
          
              <option value="0">管理员</option>
           </select>
         
      </div>
      
      <div class="row">
       
        <div class="tc">
          <button type="button" class="btn btn-primary btn-block btn-flat" id="login">登录</button>
        </div>
         
      </div>
      </div>
    </form>

  </div>
   
</div>
	
 
<script type="text/javascript">
$(document).ready(function(){
    $("#login").click(function(){	
    	 var uname = $("#uname").val();
    	 var upwd = $("#upwd").val();
    	 var utype = $("#utype").val();
  	     if(!uname){
  	    	 alert("用户名不能为空");
  	    	 return;
  	     }
  	     if(!upwd){
	    	 alert("密码不能为空");
	    	 return;
	     }
 	     if(!utype){
	    	 alert("请选择登录身份");
	    	 return;
	     }
 	     
 	    $.post('<%=path%>/login.action', {uname:uname,upwd:upwd,utype:utype},
 	    	function(data){
 	    	     if(data=="true"){
 	    	    	 
 	    	    	 window.location.href = "<%=path%>/admin/index.jsp";
 	    	    	 
 	    	     }else{
 	    	    	alert("用户名密码错误");
 	    	     }
 	    	     
 	        }
 	    );
 	     
	});			 	 
    
});
</script>

</body>
</html>
