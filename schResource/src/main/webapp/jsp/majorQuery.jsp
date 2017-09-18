<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	type="text/css"></link>
<script src="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.css">	

<title>Insert title here</title>

<style type="text/css">
	#div{
		margin-left:200px;
		margin-right:200px;
	}
	#accordion2 input{
		margin:20px;
	}
	
	
	
	#headDiv {
	width: 80%;
	margin-left: 10%;
}
#er_div a:hover {
	background: #339900;
}
#er_div a{
	font-size:16px;
	line-height:50px;
}
#total_a{
	font-size:20px;
}
.navbar-header{
	padding:15px;	
}
#input_div{
	margin-top:15px;
}
#info_maj{
	margin-left:20px;
}
	
	
</style>
</head>
<body>
	
	
	
	
	
	
	<div id="headDiv">
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/schResource/jsp/resourceHome.jsp" id="total_a">校园资源共享平台</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" id="er_div">
				<li><a href="/schResource/jsp/majorQuery.jsp">文库专区</a></li>
				<li><a href="/schResource/jsp/teacherStyleHome.jsp">名师风采</a></li>
				<li><a href="/schResource/jsp/fileupload.jsp">资源分享</a></li>
			</ul>
			<form class="navbar-form navbar-left">
			<div id="input_div">
				<div class="form-group">
					<input id="btnSelect" type="text" class="form-control" placeholder="资源">
				</div>
				<button type="button" id="selectClick" class="btn btn-default">搜索</button>
			</div>
			</form>
			<ul class="nav navbar-nav navbar-right" id="input_div">
				<c:if test="${user!=null}">
					<li><a>欢迎${user.userName}</a></li>
				</c:if>
				<c:if test="${user==null}">
					<li><a href="/schResource/loginqian/index.jsp">您好,请登录</a></li>
				</c:if>
				<li><a href="/schResource/wym/myCenterQuery.do">个人中心</a></li>
			</ul>
		</div>
	</div>
</nav>
</div>
	
	
	
	

	<div id="div">
		<div class="container-fluid">
			<div class="accordion" id="accordion2">
				
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
</body>

<script type="text/javascript">
$(function(){
	var resData = {};
	//自动补全
	$.ajax({
		url:"/schResource/resourceType/resourceInfo.do",
		type:'post',
		dataType:'json',
		success:function(data){
			console.info(data);
			rosData = data;
			$('#btnSelect').autocompleter({source: data});
		}
	});
	$("#selectClick").click(function(){
		var m = 0;
		for(var i=0;i<rosData.length;i++){
			if($('#btnSelect').val() == rosData[i].value){
				m = rosData[i].id;
				break;
			}
		}
		location.href="/schResource/wym/infoInfo/lan.do?id="+m;
	});
});
	
	window.onload=function(){
		major();		
	}
	var str="";
	var institute_id = 0;
	var major_id = 0; 
	function major(){
		$.ajax({			  
			url:"/schResource/wym/instituteAllQuery.do",			
			dataType:"JSON",	
			success:function(data){
			 	for(var i=0;i<data.length;i++){
			 		institute_id=data[i].instituteId;
				//	str ="<div class='accordion-group'><div class='accordion-heading'><a class='accordion-toggle' data-toggle='collapse' data-parent='#accordion2' href='#collapseOne"+i+"'><h3>"+data[i].institute_name+"</h3></a></div><div id='collapseOne"+i+"' class='accordion-body collapse' style='height: 0px; '><div class='accordion-inner' id='context"+i+"'>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div></div></div>";
					str ="<a class='btn btn-info btn-lg' style='display:block;width:250px;' role='button' data-toggle='collapse' href='#collapseExample"+i+"' aria-expanded='false' aria-controls='collapseExample'>"+data[i].instituteName+"</a><div class='collapse' id='collapseExample"+i+"'><div class='well'  id='context"+i+"'>...</div></div>";

					$("#accordion2").append(str);
					 $.ajax({
						 	async:false,
					 		url:"/schResource/wym/TbMajorQuery.do",
							dataType:"JSON",
							data:{
								"institute_id":institute_id
							},
							success:function(data){
								var maj = "";								
								for(var j=0;j<data.length;j++){
									major_id = data[j].MAJOR_ID;
									$.ajax({
										async:false,
										url:"/schResource/wym/queryTbResourceUploadId.do",
										dataType:"JSON",
										data:{
											"major_id":major_id
										},
										success:function(data1){
											if(data1==0){
												return;
											}
											maj += "<a class='btn btn-success' id='info_maj' role='button' href='/schResource/wym/MajorInfo.do?id="+data[j].MAJOR_ID+"'><span class='glyphicon glyphicon-heart'></span>"+data[j].MAJOR_NAME+"("+data1+")"+"</a>";								
										}
									});	 
								}
								$("#context"+i).html(maj);
							}
						});
			 	
			 	} 
			    	 
			}
		})
	} 
	
</script>
</html>

<jsp:include page="buttom.jsp"></jsp:include>









