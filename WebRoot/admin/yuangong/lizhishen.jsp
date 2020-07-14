<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<%=path%>/css/bootstrap/css/bootstrap.css"
			rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
		<title>离职申请</title>
	</head>
	<body>
		<div class="page-content">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						用户离职申请列表
					</div>
						<div class="table-responsive">
							<table class="table table-striped table-hover"
								style="text-align: center;">
								<thead>
									<tr>
										<td>
											员工编号
										</td>
										<td>
											姓名
										</td>
										<td>
											出生日期
										</td>
										<td>
											联系电话
										</td>

										<td>
											部门
										</td>
										<td>
											职位
										</td>
										<td>
											状态
										</td>
										
										<c:if test="${sessionScope.utype!=2}">
										<th width="22%">
											操作
										</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${yuangongs}" var="info">
										<tr>
											<td>
												${info.yno}
											</td>
											<td>
												${info.name}
											</td>
											<td>
												${info.csrq}
											</td>
											<td>
												${info.tel}
											</td>

											<td>
												${info.bumenVO.name}
											</td>
											<td>
												${info.roles}
											</td>
											<td>
												${info.state}
											</td>
											
												<c:if test="${sessionScope.utype!=2}">
											<td>
											
											    <a href="<%=path%>/yuangong_lizhi.action?id=${info.id}"
													class="btn btn-success btn-xs"><span
													class="glyphicon glyphicon-edit"></span>同意</a>
													
													
											    <a href="<%=path%>/bohuil.action?id=${info.id}"
													class="btn btn-warning btn-xs"><span
													class="glyphicon glyphicon-edit"></span>驳回</a>
											</td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
						</div>
					
				</div>
			
		</div>
	</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
   $("#addBtn").click(function(){
        window.location.href = '<%=path%>/yuangong_toAdd.action';
   });
});
function delInfo(id){
	 if(confirm("是否确认删除？")){
	 window.location.href = '<%=path%>/yuangong_delete.action?id=' + id;
    }
}
</script>