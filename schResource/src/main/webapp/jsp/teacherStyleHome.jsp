<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<jsp:include page="head.jsp"></jsp:include>
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
<style type="text/css">
	#tsStyle{
		width:80%;
	}
	#info{
		margin:50px auto;
	}
	#pages{
		margin-left: 40%;
	}
	
</style>
</head>
<body>
	<div class="container" id="tsStyle">
	</div>
	<div id="pages">
		<ul class="pagination pagination-lg">
		<li><a href="#">&laquo;</a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
		</ul><br>
	</div>
</body>

<script type="text/javascript">

	$.ajax({
		url:"/schResource/teacherStyle/findTeacher.do",
		dataType:'json',
		success:function(data){
			var imageUrl = "";
			var imageUrlss = "";
			var str = "";
				str += "<h2><em style='color: green;'>名师风采</em><hr></h2>";
			for(var i=0;i<data.length;i++){
				imageUrl = data[i].TEACHER_IMAGE;
				imageUrlss = imageUrl.substring(76, 45); //截取路径字符串
				str += "<div class='row'>";
				str += "<div class='col-md-4'><img src=${pageContext.request.contextPath}"+imageUrlss+" alt='教师照片' class='img-thumbnail'></div>";
				str += "<div class='col-md-8'><dl class='dl-horizontal'><p>姓名：&nbsp;&nbsp;"+data[i].TEACHER_NAME+"</p>";
				str += "<p>名师年龄：&nbsp;&nbsp;"+data[i].TEACHER_AGE+"</p>";
				str += "<p>性别：&nbsp;&nbsp;"+data[i].TEACHER_SIX+"</p>";
				str += "<p>名师简介：&nbsp;&nbsp;"+data[i].TEACHER_INFO+"</p>";
				str += "&nbsp;&nbsp;&nbsp;&nbsp;</dl></div></div>";
			}
			
			$(".container").append(str);
		}
	});
</script>
</html>
