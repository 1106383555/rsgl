<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/top.css" rel="stylesheet" type="text/css">
<title>菜单栏</title>

</head>
<body>

	<header id="header">
	<div id="menu">
		<div id="logo">
			<div>
				  
			</div>
			<div id="system_title">小区物业人事管理系统</div>
		</div>
		<div id="rinfo">
			当前用户：
			<c:if test="${sessionScope.utype==0}">
			<span>${sessionScope.cuser.uname}【管理员】</span>
			</c:if>
	 
			<c:if test="${sessionScope.utype==2}">
			<span>${sessionScope.cuser.name}【${sessionScope.cuser.bumenVO.name}员工】</span>
			</c:if>
			<c:if test="${sessionScope.utype==3}">
			<span>${sessionScope.cuser.name}【${sessionScope.cuser.bumenVO.name}领导】</span>
			</c:if>
			<span id="exit">
				<a href="#" onclick="exit();">退出</a>
			</span>
		</div>
	</div>
	</header>

</body>
<script type="text/javascript">
   function exit(){
	   window.top.location.href = '<%=path%>/loginOut.action';
   }
   
</script>
</html>

