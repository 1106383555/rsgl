<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/jquery.validate.min.js"></script>
<script src="<%=path%>/js/jquery.validate.extend.js"></script>
<script src="<%=path%>/js/jquery.validate.method.js"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">
			<div class="panel-heading">修改密码</div>
			<div class="panel-body">
				<form action="#" method="post" id="addForm">
					<div class="container-fluid">
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										<font color="red">*</font>
										原密码
									</label>
									<div class="col-sm-9 form-inline">
										<input id="opwd" name="opwd" size="35" class="form-control" type="password" value="" />
									</div>
								</div>
							</div>
						</div>
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										<font color="red">*</font>
										新密码
									</label>
									<div class="col-sm-9 form-inline">
										<input id="upwd" name="upwd" size="35" class="form-control" type="password" value="" />
									</div>
								</div>
							</div>
						</div>
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										<font color="red">*</font>
										确认密码
									</label>
									<div class="col-sm-9 form-inline">
										<input id="upwd1" name="upwd1" size="35" class="form-control" type="password" value="" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4" style="margin-left: 20px;">
								<button type="submit" class="btn btn-primary" style="margin-top: 40px;">提交</button>

							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
 
		$("#addForm").validate({
			submitHandler : function(form) {//验证通过后的执行方法
				 var upwd = $('#upwd').val();
			     $.post('<%=path%>/modifyPwd.action', {upwd:upwd},
				 	    	function(data){
				 	    	     if(data=="true"){
				 	    	    	alert("修改成功");
				 	    	    	window.location.href = '<%=path%>/toUpwd.action';
				 	    	     }else{
				 	    	    	alert("修改失败");
				 	    	     }
				 	    	     
				 	        }
						 );
				 
			},
			rules : {
				opwd : {
					required : true,
					remote: {
                        url: "<%=path%>/validateOpwd.action",
						type : "post",
						dataType : "json",
						data : {
							opwd : function() {
								return $("#opwd").val();
							}
						},
						dataFilter : function(data) {
							return data;
						}
					}
				},
				upwd : {
					required : true,
				},
				upwd1 : {
					required : true,
					equalTo : "#upwd"
				},
			},
			messages : {
				opwd : {
					required : '原密码不能为空',
					remote:'原密码错误'
				},
				upwd : {
					required : '新密码不能为空',
				},
				upwd1 : {
					required : '确认密码不能为空',
					equalTo : '两次密码输入不一致'
				},
			}
		});
	});
</script>
</html>