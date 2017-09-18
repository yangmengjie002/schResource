<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="head.jsp"></jsp:include>
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

<script type="text/javascript"
	src="http://localhost:9088/schResource/js/fenye/jquery.pagination.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/fenye/jquery.pagination.css"
	type="text/css"></link>

<title>某个专业下面的资源</title>

<style type="text/css">
	#total{
		font-size: 25px;
		margin-left:10px;
	}
	#body_div {
		width: 80%;
		margin-left: 10%;
	}
	#for_div{
		margin:20px;
	}
	#jianjie_span {
		margin: 5px;
		font-size: 18px;
	}
	#pingfen_span{
		margin-left:7%;
		font-size:20px;
	}
	#down_span{
		margin-left:7%;
		font-size:20px;
	}
	#xiazai_a{
		margin-left:70%;
		margin-bottom:-10px;
	}
	.box{
		margin-left:20%;
	}
</style>
</head>
<body>
	<div id="body_div">
		<c:forEach var="info" items="${info.info}">
			<span id="${info.MAJOR_ID}" class="brbr"></span>
			<div id="xibie_div">
					<a class="btn btn-info" href="/schResource/jsp/majorQuery.jsp" role="button">${info.INSTITUTE_NAME}</a>
					<span class="glyphicon glyphicon-chevron-right"></span>
					<button type="button" class="btn btn-info">${info.MAJOR_NAME}</button>
				</div>
			<div id="for_div" class="well">
				<span class="glyphicon glyphicon-folder-open" id="total">&nbsp;${info.RESOURCE_NAME}</span>
				<button type="button" name="${info.RESOURCE_ID}" id="typename" class="btn btn-warning btn-xs">${info.RESOURCE_TYPE_NAME}</button>
				<span id="pingfen_span">
					<c:if test="${info.ave==null}">
						平均评分:暂无评分
					</c:if>
					<c:if test="${info.ave!=null}">
						平均评分:${info.ave}分
					</c:if>
				</span>
				<span id="down_span">下载量:${info.count}</span>
				<br>
				<div id="jianjie_span">
					<span>简介:${info.RESOURCE_INFO}</span>
				</div>
				<a class="btn btn-primary" id="xiazai_a" href='/schResource/wym/infoInfo/lan.do?id=${info.RESOURCE_ID}' role="button"><span class="glyphicon glyphicon-download-alt"></span>下载</a>
			</div>
		</c:forEach>
			
		<div class="box" id="${info.total}">
			<div id="pagination" class="page fl"></div>
			<div class="info fl">
				<p>
					<!-- 	当前页数：<span id="current">3</span> -->
				</p>
			</div>
		</div>	
	</div>
</body>

<script type="text/javascript">

	window.onload=function(){
		var total = $(".box").prop("id");
		//我的上传分页
		$("#pagination").pagination({
			currentPage: 1,
			totalPage: total,
			isShow: false,
			count: 6,
			prevPageText: "< 上一页",
			nextPageText: "下一页 >",
			callback: function(current) {
				$.ajax({
					url:"/schResource/wym/MajorInfoAjax.do",
					data:{
						"currPage":current,
						"id":$(".brbr").prop("id")
					},
					dataType:"JSON",
					success:function(data){
						var str = "";
						var score = "";
						
						for(var i=0;i<data.info.length;i++){
							if(data.info[i].ave==null){
								score="暂无评分";
							}else{
								score = data.info[i].ave;
							}
							str +="<span class='glyphicon glyphicon-folder-open' id='total'>&nbsp;"+data.info[i].RESOURCE_NAME+"</span><button type='button' name="+data.info[i].RESOURCE_ID+" id='typename' class='btn btn-warning btn-xs'>"+data.info[i].RESOURCE_TYPE_NAME+"</button><span id='pingfen_span'>平均评分:"+score+"</span><span id='down_span'>下载量:"+data.info[i].count+"</span><br><div id='jianjie_span'><span>简介:"+data.info[i].RESOURCE_INFO+"</span></div><a class='btn btn-primary' id='xiazai_a' href='/schResource/wym/infoInfo.do?id="+data.info[i].RESOURCE_ID+"' role='button'><span class='glyphicon glyphicon-download-alt'></span>下载</a>";
						}
						$(".well").html(str);
					}
				});
			}
		});
	}
	
</script>
</html>

<jsp:include page="buttom.jsp"></jsp:include>









