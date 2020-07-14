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
		<title>菜单栏</title>
	</head>
	<body>
		<div class="page-content">
			<form action="<%=path%>/yuangong_list.action" class="form-inline"
				method="post">
				<div class="panel panel-default">
					<div class="panel-heading">
						用户信息列表
					</div>
					<div class="panel-body">
						<div class="pull-left">
							<div class="form-group qinfo">
								<label>
									员工编号：
								</label>
								<input name="yno" value="${yno}" class="form-control">
							</div>
							<div class="form-group qinfo">
								<label>
									姓名：
								</label>
								<input name="name" value="${name}" class="form-control">
							</div>
<c:if test="${sessionScope.utype==0}">
							<label>
								部门：
							</label>
							<select id="bid" name="bid" class="form-control">
								<option value="0">
									全部
								</option>
								<c:forEach items="${bumenList}" var="info">
									<option <c:if test="${bid==info.id}">selected</c:if>
										value="${info.id}">
										${info.name}
									</option>
								</c:forEach>
							</select>
							</c:if>
							<button type="submit" class="btn btn-default">
								查询
							</button>
						</div>
					</div>
					<pg:pager url="yuangong_list.action" items="${itemSize}"
						maxPageItems="${pageItem}" maxIndexPages="${pageItem}"
						isOffset="${true}" export="offset,currentPageNumber=pageNumber"
						scope="request">
						<pg:param name="yno" value="${yno}" />
						<pg:param name="name" value="${name}" />

						<pg:param name="bid" value="${bid}" />
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
										
										<c:if test="${sessionScope.utype!=2}">
										<th width="22%">
											操作
										</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="info">
										<tr>
											<td>
												<a style="color: #000000"
													href="<%=path%>/yuangong_toView.action?id=${info.id}">${info.yno}</a>
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
											
											<c:if test="${sessionScope.utype==0}">
											<td>
											
											    <a href="<%=path%>/yuangong_lizhi.action?id=${info.id}"
													class="btn btn-success btn-xs"><span
													class="glyphicon glyphicon-edit"></span>离职</a>
													
													
											    <a href="<%=path%>/yuangong_tuixiu.action?id=${info.id}"
													class="btn btn-warning btn-xs"><span
													class="glyphicon glyphicon-edit"></span>退休</a>
													
													
												<a href="<%=path%>/yuangong_toUpdate.action?id=${info.id}"
													class="btn btn-info btn-xs"><span
													class="glyphicon glyphicon-edit"></span>编辑</a>
												<a href="javascript:void();"
													onclick="delInfo('${info.id}');"
													class="btn btn-danger btn-xs"><span
													class="glyphicon glyphicon-trash"></span>删除</a>
													<a href="<%=path%>/admin/yuangong/down.jsp?path=${info.fujian}">下载</a>
												<!--a href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-eye-open"></span> 查看</a-->
											</td>
											</c:if>
											
											<c:if test="${sessionScope.utype==3}">
											<td>
											    <a href="<%=path%>/btuixius.action?id=${info.id}"
													class="btn btn-warning btn-xs"><span
													class="glyphicon glyphicon-edit"></span>退休申请</a>
													
												<a href="<%=path%>/blizhis.action?id=${info.id}"
													class="btn btn-success btn-xs"><span
													class="glyphicon glyphicon-edit"></span>离职申请</a>
													
												<!-- 
													<a href="<%=path%>/bohuil.action?id=${info.id}"
													class="btn btn-success btn-xs"><span
													class="glyphicon glyphicon-edit"></span>取消申请</a>
												 -->
												<a href="<%=path%>/admin/yuangong/down.jsp?path=${info.fujian}">下载</a>
												<!--a href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-eye-open"></span> 查看</a-->
											</td>
											</c:if>
											
											
											
											
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="panel-footer clearfix">
								<div class="pull-left">
									<c:if test="${sessionScope.utype!=2}">
									<button type="button" id="addBtn" class="btn btn-info">
										新增
									</button>
									</c:if>
								</div>
								<nav class="pull-right">
								<pg:index>
									<jsp:include page="/common/pagination_tag.jsp" flush="true" />
								</pg:index>
								</nav>
							</div>
						</div>
					</pg:pager>
				</div>
			</form>
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