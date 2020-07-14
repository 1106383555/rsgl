<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
<title>菜单栏</title>
</head>
<body>


	<!--main-->
	<div class="container-fluid mybody">
		<div class="main-wapper">
			<!--菜单-->
			<div id="siderbar" class="siderbar-wapper">

				<div class="panel-group menu" id="accordion" role="tablist" aria-multiselectable="true">

                  <c:if test="${sessionScope.utype==0}">
					   <div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									系统管理
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
							    <a href="<%=path%>/toUpwd.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>
								<a href="<%=path%>/tadmin_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									管理员管理
								</a>
								 

							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingSeven">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
									<span class="glyphicon glyphicon-user"></span>
									部门管理
								</a>
							</h4>
						</div>
						<div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
							<div class="list-group list-group-self">
								<a href="<%=path%>/bumen_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									部门管理
								</a>
							 
							</div>
						</div>
					</div>
					
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading11">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse11" aria-expanded="false" aria-controls="collapse11">
									<span class="glyphicon glyphicon-user"></span>
									消息通知
								</a>
							</h4>
						</div>
						<div id="collapse11" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading11">
							<div class="list-group list-group-self">
								<a href="<%=path%>/newsinfo_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									消息通知
								</a>
							 
							</div>
						</div>
					</div>
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading12">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse12" aria-expanded="false" aria-controls="collapse12">
									<span class="glyphicon glyphicon-th-large"></span>
									招聘管理
								</a>
							</h4>
						</div>
						<div id="collapse12" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading12">
							<div class="list-group list-group-self">
							    <a href="<%=path%>/zhaopin_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									招聘管理
								</a>
							 
							</div>
						</div>
					</div>
					
					
					
						<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
									<span class="glyphicon glyphicon-th-large"></span>
									员工管理
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
							<div class="list-group list-group-self">
							    <a href="<%=path%>/yuangong_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									员工管理
								</a>
								<a href="<%=path%>/yuangongLists.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									员工通信录
								</a>
								 <a href="<%=path%>/yuangong_txlist.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									退休员工管理
								</a>
								 <a href="<%=path%>/yuangong_lzlist.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									离职员工管理
								</a>
								
								<a href="<%=path%>/selecttuishen.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									退休申请
								</a>
								<a href="<%=path%>/selectlishen.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									离职申请
								</a>
								
								
								
								
							</div>
						</div>
					</div>
					
					

				 
			</c:if>		

					 

 
			
			 <!-- 员工菜单 -->
              <c:if test="${sessionScope.utype==2 || sessionScope.utype==3}">
					   <div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									个人资料
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/myinfo.action"  target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									个人信息
								</a>
						        <a href="<%=path%>/admin/yuangong/yuangong_info.jsp"  target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									电子档案
								</a>
							    <a href="<%=path%>/toUpwd.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>

							</div>
						</div>
					</div>
 
 
 
 
 <div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading11">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse11" aria-expanded="false" aria-controls="collapse11">
									<span class="glyphicon glyphicon-user"></span>
									消息通知
								</a>
							</h4>
						</div>
						<div id="collapse11" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading11">
							<div class="list-group list-group-self">
								<a href="<%=path%>/newsinfo_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									消息通知
								</a>
							 
							</div>
						</div>
					</div>
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading12">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse12" aria-expanded="false" aria-controls="collapse12">
									<span class="glyphicon glyphicon-th-large"></span>
									招聘管理
								</a>
							</h4>
						</div>
						<div id="collapse12" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading12">
							<div class="list-group list-group-self">
							    <a href="<%=path%>/zhaopin_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									招聘管理
								</a>
							 
							</div>
						</div>
					</div>
					
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
									<span class="glyphicon glyphicon-th-large"></span>
									员工管理
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
							<div class="list-group list-group-self">
							    <a href="<%=path%>/yuangong_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									员工管理
								</a>
								<a href="<%=path%>/yuangongLists.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									员工通信录
								</a>
								<c:if test="${sessionScope.utype==3}">
									<a href="<%=path%>/selecttuishenbybid.action" target="appiframe" class="list-group-item">
										<span class="glyphicon glyphicon-menu-right"></span>
										退休申请列表
									</a>
									<a href="<%=path%>/selectlishenbybid.action" target="appiframe" class="list-group-item">
										<span class="glyphicon glyphicon-menu-right"></span>
										离职申请列表
								</a>
								</c:if>
								
							</div>
						</div>
					</div>

				 
					
			</c:if>	
			



				</div>

			</div>
			<!--菜单-->
			<!--内容-->
			<div id="content" class="main-content">
			
			   <c:if test="${sessionScope.utype==0}">
				<iframe src="<%=path%>/tadmin_list.action" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
				</c:if>
				
				 
				<c:if test="${sessionScope.utype==2 || sessionScope.utype==3}">
				<iframe src="<%=path%>/yuangong_list.action" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
				</c:if>
			</div>
			<!--内容-->
		</div>

	</div>

	<!--main-->

</body>
</html>