<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增</title>
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
        <div class="panel-heading">新增</div>
        <div class="panel-body">
            <form action="<%=path%>/yuangong_add.action" method="post" id="addForm">
                <div class="container-fluid">
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label"><font color="red">*</font>员工编号 </label>
								<div class="col-sm-9 form-inline"  >
                                                    <input id="yno" name="yno" size="35" class="form-control"   type="text" value=""  tip="请输入员工编号" />
								</div>
							</div>
						</div>
					</div>
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label"><font color="red">*</font>姓名 </label>
								<div class="col-sm-9 form-inline"  >
                                                    <input id="name" name="name" size="35" class="form-control"   type="text" value=""  tip="请输入姓名" />
								</div>
							</div>
						</div>
					</div>
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label">出生日期 </label>
								<div class="col-sm-9 form-inline"  >
                            <input id="csrq" name="csrq" size="35" class="form-control" readonly="readonly" onClick="WdatePicker()"  type="text" value=""  tip="请输入出生日期" />
								</div>
							</div>
						</div>
					</div>
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label"><font color="red">*</font>联系电话 </label>
								<div class="col-sm-9 form-inline"  >
                                                    <input id="tel" name="tel" size="35" class="form-control"   type="text" value=""  tip="请输入联系电话" />
								</div>
							</div>
						</div>
					</div>
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label"><font color="red">*</font>密码 </label>
								<div class="col-sm-9 form-inline"  >
                                                    <input id="pwd" name="pwd" size="35" class="form-control"   type="text" value=""  tip="请输入密码" />
								</div>
							</div>
						</div>
					</div>
               <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label">部门 </label>
								<div class="col-sm-9 form-inline"  >
                                                            <select id="bid" name="bid" class="form-control">
                                    <c:forEach items="${bumenList}" var="info">
                                        <option value="${info.id}">${info.name}</option>
                                    </c:forEach>
                                </select>
								</div>
							</div>
						</div>
					</div>
					
					 <div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
                                                                            <label class="col-sm-3 control-label">职位 </label>
								<div class="col-sm-9 form-inline"  >
                                 <select id="roles" name="roles" class="form-control">
                                   
                                        <option value="员工">员工</option>
                                        <option value="领导">领导</option>
                                </select>
								</div>
							</div>
						</div>
					</div>
					
					
                    <div class="row">
                      <div class="col-sm-2">
						</div>
                       <div class="col-sm-4" style="margin-left: 20px;">
                         <button type="submit" class="btn btn-primary" style="margin-top: 40px;">提交</button>
                         <button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px;margin-left: 20px;">返回</button>
						</div>
					</div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    	 $("#rebackBtn").click(function(){
	     window.history.go(-1); 
	 });
    $("#addForm").validate({
        submitHandler:function(form){//验证通过后的执行方法
                        form.submit();
        },
        rules: {
                                                    yno:{
                                                                    required:true,
                                                                    remote: {
                                        url: "<%=path%>/yuangong_ynoExist.action",
                                                type: "post",
                                                dataType: "json",
                                                data: {
                                           yno: function (){ return $("#yno").val();}
                                        },
                                        dataFilter: function (data) {
                                            return data;
                                        }
                                }
                                                    },
                                                                    name:{
                                                                    required:true,
                                                    },
                                                                                                tel:{
                                                                    required:true,
                                                    },
                                                                    pwd:{
                                                                    required:true,
                                                    },
                                                                },
        messages:{
                                                yno:{
                                                                        required:'员工编号不能为空',
                                                                        remote:'员工编号已存在',
                                    },
                                                                name:{
                                                                        required:'姓名不能为空',
                                    },
                                                                                            tel:{
                                                                        required:'联系电话不能为空',
                                    },
                                                                pwd:{
                                                                        required:'密码不能为空',
                                    },
        }
    });
});
</script>
</html>