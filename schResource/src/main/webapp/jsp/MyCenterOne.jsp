<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="head.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>个人中心</title>
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
	
	<style type="text/css">
		#biaoqian_div{
			width:80%;
			margin-left:10%;
		}
		.table{
			margin-top:20px;
		}
	</style>
	
	
</head>
<body>

<div id="biaoqian_div">
	<div>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist" id="tablist">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab">我的上传</a></li>
			<li role="presentation"><a href="#profile"
				aria-controls="profile" role="tab" data-toggle="tab">我的下载</a></li>
			<li role="presentation"><a href="#messages"
				aria-controls="messages" role="tab" data-toggle="tab">我的收藏</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="home">
				<table class="table table-striped">
					<thead>
						<th>序号</th>
						<th>资源名称</th>
						<th>上传时间</th>
						<th>资源状态</th>
						<th>审核</th>
					</thead>
					<tbody id="upload_div">
						<c:forEach var="upload" items="${upload}" varStatus="aa">
							<tr>
								<td>${aa.count}</td>
								<td>
									<c:if test="${upload.STATUS_ID==3}">
										<a href="/schResource/wym/infoInfo/lan.do?id=${upload.RESOURCE_ID}">${upload.RESOURCE_NAME}</a>
									</c:if>
									<c:if test="${upload.STATUS_ID!=3}">
										${upload.RESOURCE_NAME}
									</c:if>									
								</td>							
								<td>${upload.UPLOAD_DATE}</td>						
								<td class="statuId">
									<c:if test="${upload.STATUS_ID==2&&upload.CHECK_STATUID==1}">
										<span class="label label-default">待发布</span>
									</c:if>
									<c:if test="${upload.STATUS_ID==2&&upload.CHECK_STATUID==2}">
										<span class="label label-danger">未通过</span>
									</c:if>
									<c:if test="${upload.STATUS_ID==2&&upload.CHECK_STATUID!=1&&upload.CHECK_STATUID!=2}">
										<span class="label label-warning">待审核</span>
									</c:if>
									<c:if test="${upload.STATUS_ID==3}">
										<span class="label label-success">已发布</span>
									</c:if>
									<c:if test="${upload.STATUS_ID==4}">
										<span class="label label-warning">已下架</span>
									</c:if>
								</td>
								<td>${upload.CHECK_IDEA}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="box">
						<div id="pagination" class="page fl"></div>
						<div class="info fl">
							<p>
							<!-- 	当前页数：<span id="current">3</span> -->
							</p>
						</div>
					</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="profile">
				<table class="table table-striped">
					<thead>
						<th>序号</th>
						<th>资源名称</th>
						<th>资源类型</th>
						<th>所属专业</th>
						<th>下载时间</th>
						<th>资源状态</th>
					</thead>
					<tbody id="down_div">
						<c:forEach var="down" items="${down}" varStatus="aa">
							<tr>
								<td>${aa.count}</td>
								<td>
									<c:if test="${down.STATUS_ID==3}">
										<a href="/schResource/wym/infoInfo/lan.do?id=${down.RESOURCE_ID}">${down.RESOURCE_NAME}</a>
									</c:if>
									<c:if test="${down.STATUS_ID!=3}">
										${down.RESOURCE_NAME}
									</c:if>									
								</td>
								<td>${down.RESOURCE_TYPE_NAME}</td>
								<td>${down.MAJOR_NAME}</td>
								<td>${down.DOWNLOAD_DATE}</td>
								<td class="statuId">
									<c:if test="${down.STATUS_ID==3}">
										<span class="label label-success">已发布</span>
									</c:if>
									<c:if test="${down.STATUS_ID==4}">
										<span class="label label-warning">已下架</span>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="box">
						<div id="pagination2" class="page fl"></div>
						<div class="info fl">
							<p>
							<!-- 	当前页数：<span id="current2">3</span> -->
							</p>
						</div>
					</div>
				
			</div>
			<div role="tabpanel" class="tab-pane" id="messages">
				<table class="table table-striped">
					<thead>
						<th>序号</th>
						<th>资源名称</th>
						<th>资源类型</th>
						<th>所属专业</th>
						<th>下载时间</th>
						<th>资源状态</th>
					</thead>
					<tbody id="collect_div">
						<c:forEach var="collect" items="${collect}" varStatus="aa">
							<tr>
								<td>${aa.count}</td>
								<td>
									<c:if test="${collect.STATUS_ID==3}">
										<a href="/schResource/wym/infoInfo/lan.do?id=${collect.RESOURCE_ID}">${collect.RESOURCE_NAME}</a>
									</c:if>
									<c:if test="${collect.STATUS_ID!=3}">
										${collect.RESOURCE_NAME}
									</c:if>									
								</td>
								<td>${collect.RESOURCE_TYPE_NAME}</td>
								<td>${collect.MAJOR_NAME}</td>
								<td>${collect.ADDTIME}</td>
								<td class="statuId">
									<c:if test="${collect.STATUS_ID==3}">
										<span class="label label-success">已发布</span>
									</c:if>
									<c:if test="${collect.STATUS_ID==4}">
										<span class="label label-warning">已下架</span>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

					<div class="box">
						<div id="pagination3" class="page fl"></div>
						<div class="info fl">
							<p>
							<!-- 	当前页数：<span id="current3">3</span> -->
							</p>
						</div>
					</div>


				</div>
		</div>

	</div>

</div>
</body>

<script type="text/javascript">
window.onload=function(){
	var uploadCount = 1;
	var downCont = 1;
	var collectCount = 1;
	//总条数
	$.ajax({
		async:false,
		url:"/schResource/wym/MyCountQuery.do",
		dataType:"JSON",
		success:function(data){
			uploadCount = parseInt(data.upload);
			downCount = parseInt(data.down);
			collectCount = parseInt(data.collect);
		}
	});
	
	//我的上传分页
	$("#pagination").pagination({
		currentPage: 1,
		totalPage: uploadCount,
		isShow: false,
		count: 6,
		prevPageText: "< 上一页",
		nextPageText: "下一页 >",
		callback: function(current) {
		//	$("#current").text(current)
			$.ajax({
				url:"/schResource/wym/myUploadQuery.do",
				data:{
					"currPage":current
				},
				dataType:"JSON",
				success:function(data){
					var str = "";
					var resource_name = "";
					var status_name = "";
					for(var i=0;i<data.length;i++){
						if(data[i].STATUS_ID==3){
							status_name = "<span class='label label-success'>已发布</span>";
							resource_name = "<a href='/schResource/wym/infoInfo/lan.do?id="+data[i].RESOURCE_ID+"'>"+data[i].RESOURCE_NAME+"</a>";
						}else if(data[i].STATUS_ID==4){
							status_name = "<span class='label label-warning'>已下架</span>";
							resource_name = data[i].RESOURCE_NAME;
						}else if(data[i].STATUS_ID==2&&data[i].CHECK_STATUID==1){
							status_name = "<span class='label label-default'>待发布</span>";
							resource_name = data[i].RESOURCE_NAME;
						}else if(data[i].STATUS_ID==2&&data[i].CHECK_STATUID==2){
							status_name = "<span class='label label-default'>审核未通过</span>";
							resource_name = data[i].RESOURCE_NAME;
						}else{
							status_name = "<span class='label label-default'>待审核</span>";
							resource_name = data[i].RESOURCE_NAME;
						}
						str +="<tr><td>"+(i+1)+"</td>";
						str +="<td>"+resource_name+"</td>";
						str +="<td>"+data[i].UPLOAD_DATE+"</td>";						
						str +="<td>"+status_name+"</td>";
						str +="<td>"+data[i].CHECK_IDEA+"</td></tr>";						
					}
					$("#upload_div").html(str);
				}
			});
		}
	});

	//我的下载分页
	$("#pagination2").pagination({
		currentPage: 1,
		totalPage: downCount,
		isShow: false,
		count: 6,
		prevPageText: "< 上一页",
		nextPageText: "下一页 >",
		callback: function(current) {
		//	$("#current2").text(current)
			$.ajax({
				url:"/schResource/wym/myDownQuery.do",
				data:{
					"currPage":current
				},
				dataType:"JSON",
				success:function(data){
					var str = "";
					var resource_name = "";
					var status_name = "";
					for(var i=0;i<data.length;i++){
						if(data[i].STATUS_ID==3){
							status_name = "<span class='label label-success'>已发布</span>";
							resource_name = "<a href='/schResource/wym/infoInfo/lan.do?id="+data[i].RESOURCE_ID+"'>"+data[i].RESOURCE_NAME+"</a>";
						}else if(data[i].STATUS_ID==4){
							status_name = "<span class='label label-warning'>已下架</span>";
							resource_name = data[i].RESOURCE_NAME;
						}
						str +="<tr><td>"+(i+1)+"</td>";
						str +="<td>"+resource_name+"</td>";
						str +="<td>"+data[i].RESOURCE_TYPE_NAME+"</td>";
						str +="<td>"+data[i].MAJOR_NAME+"</td>";
						str +="<td>"+data[i].DOWNLOAD_DATE+"</td>";
						str +="<td>"+status_name+"</td></tr>";
					}
					$("#down_div").html(str);
				}
			});
		}
	});
	
	//我的收藏分页
	$("#pagination3").pagination({
		currentPage: 1,
		totalPage: collectCount,
		isShow: false,
		count: 6,
		prevPageText: "< 上一页",
		nextPageText: "下一页 >",
		callback: function(current) {
		//	$("#current3").text(current)
			$.ajax({
				url:"/schResource/wym/myCollectQuery.do",
				data:{
					"currPage":current
				},
				dataType:"JSON",
				success:function(data){
					var str = "";
					var resource_name = "";
					var status_name = "";
					for(var i=0;i<data.length;i++){
						if(data[i].STATUS_ID==3){
							status_name = "<span class='label label-success'>已发布</span>";
							resource_name = "<a href='/schResource/wym/infoInfo/lan.do?id="+data[i].RESOURCE_ID+"'>"+data[i].RESOURCE_NAME+"</a>";
						}else if(data[i].STATUS_ID==4){
							status_name = "<span class='label label-warning'>已下架</span>";
							resource_name = data[i].RESOURCE_NAME;
						}
						str +="<tr><td>"+(i+1)+"</td>";
						str +="<td>"+resource_name+"</td>";
						str +="<td>"+data[i].RESOURCE_TYPE_NAME+"</td>";
						str +="<td>"+data[i].MAJOR_NAME+"</td>";
						str +="<td>"+data[i].ADDTIME+"</td>";
						str +="<td>"+status_name+"</td></tr>";
					}
					$("#collect_div").html(str);
				}
			});
		}
	});
	
}

</script>


</html>















