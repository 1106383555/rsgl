<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改</title>
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
<script src="<%=path%>/js/jquery.validate.min.js"></script>
<script src="<%=path%>/js/jquery.validate.extend.js"></script>
<script src="<%=path%>/js/jquery.validate.method.js"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">
			<div class="panel-heading">电子档案</div>
			<div class="panel-body">
				<form action="<%=path%>/yuangong_updateInfo.action" method="post" id="addForm">
					<input name="id" type="hidden" value="${sessionScope.cuser.id}" />
					 
					<div class="container-fluid">
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										<font color="red">*</font>
										电子档案
									</label>
									<div class="col-sm-9 form-inline">
										      <input id="fujian" readonly="readonly" name="fujian" size="35" value="${sessionScope.cuser.fujian}" class="form-control"   type="text"   tip="请上传文件" />
                                                <input type="button" value="上传" onclick="up('fujian',0)"/>
                                                
                                                <c:if test="${not empty sessionScope.cuser.fujian}">
                                                  <a href="<%=path%>/admin/yuangong/down.jsp?path=${sessionScope.cuser.fujian}">下载</a>
                                                </c:if>
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
		$("#rebackBtn").click(function() {
			window.history.go(-1);
		});
		$("#addForm").validate({
			submitHandler : function(form) {//验证通过后的执行方法
				form.submit();
			},
			rules : {
				 
				 
			},
			messages : {
				 
				 
			}
		});
	});
	
	var pop;
    function up(fname,type)
    {
        pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
        pop.setContent("contentUrl","<%=path %>/upload/upload.jsp?fname="+fname + "&pt=" + type);
        pop.setContent("title","文件上传");
        pop.build();
        pop.show();
    }
    function popupClose(){
        pop.close();
    }
</script>
</html>