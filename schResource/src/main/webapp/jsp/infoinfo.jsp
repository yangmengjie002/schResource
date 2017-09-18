<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/startScore.js"></script>
	
<script type="text/javascript" src="http://localhost:9088/schResource/js/bootstrap/jquery.form.js"></script>
<script type="text/javascript" src="http://localhost:9088/schResource/js/flexpaper_flash.js"></script>  
<script type="text/javascript" src="http://localhost:9088/schResource/js/flexpaper_flash_debug.js"></script>
<script type="text/javascript" src="http://localhost:9088/schResource/ckplayer/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/fenye/jquery.pagination.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/fenye/jquery.pagination.css"
	type="text/css"></link>
<script src="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.css"></link>	


<title>某个资源详情</title>

<style type="text/css">
#body_div {
	width: 70%;
	margin-left: 15%;
}

#xibie_div {
	margin: 0px 0 20px 60px;
}

#context_div {
	margin: 20px 0px 20px 60px;
}

#total {
	font-size: 30px;
}

#jianjie_span {
	margin: 30px;
	font-size: 18px;
}

#comment_div {
	margin-bottom: 20px;
}

#comment_name {
	font-size: 20px;
	margin: 30px;
}

#comment_content {
	margin-left: 70px;
}

#textrow_div {
	width: 500px;
}

#textrow {
	width: 550px;
	height: 170px;
}



ul, li, ol {
	list-style: none;
}
/* 重置文本格式元素 */
a {
	text-decoration: none;
	cursor: pointer;
	color: #333333;
	font-size: 14px;
}

a:hover {
	text-decoration: none;
}

.clearfix::after {
	display: block;
	content: '';
	height: 0;
	overflow: hidden;
	clear: both;
}
/*星星样式*/
.content {
	width: 600px;
	margin: 0 auto;
}

.title {
	font-size: 14px;
	background: #dfdfdf;
	padding: 10px;
	margin-bottom: 10px;
}

.block {
	width: 100%;
	margin: 0 0 20px 0;
	padding-top: 10px;
	padding-left: 50px;
	line-height: 21px;
}

.block .star_score {
	float: left;
}

.star_list {
	height: 21px;
	margin: 50px;
	line-height: 21px;
}

.block p, .block .attitude {
	padding-left: 20px;
	line-height: 21px;
	display: inline-block;
}

.block p span {
	color: #C00;
	font-size: 16px;
	font-family: Georgia, "Times New Roman", Times, serif;
}

.star_score {
	background: url(/schResource/images/stark2.png);
	width: 160px;
	height: 21px;
	position: relative;
}

.star_score a {
	height: 21px;
	display: block;
	text-indent: -999em;
	position: absolute;
	left: 0;
}

.star_score a:hover {
	background: url(/schResource/images/stark2.png);
	left: 0;
}

.star_score a.clibg {
	background: url(/schResource/images/stark2.png);
	left: 0;
}

#starttwo .star_score {
	background: url(/schResource/images/starky.png);
}

#starttwo .star_score a:hover {
	background: url(/schResource/images/starsy.png);
	left: 0;
}

#starttwo .star_score a.clibg {
	background: url(/schResource/images/starsy.png);
	left: 0;
}
#pingfen{
	margin-left:40px;
}
#pingfen_span{
	margin-left:7%;
	font-size:20px;
}
#down_span{
	margin-left:7%;
	font-size:20px;
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
#imgShow{
	margin-top:20px;
	margin-left:300px;
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
				<li><a href="/schResource/jsp/resourceInfo.jsp">下载专区</a></li>
				<li><a href="/schResource/jsp/teacherStyleHome.jsp">名师风采</a></li>
				<li><a href="/schResource/jsp/admin/fileupload.jsp">资源上传</a></li>
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
	

	
	<div id="body_div">
		<c:forEach var="info" items="${info.info}">	 
		<div id="xibie_div">
				<a class="btn btn-info" href="/schResource/jsp/majorQuery.jsp" role="button">${info.INSTITUTE_NAME}</a>
				<span class="glyphicon glyphicon-chevron-right"></span>
				<a class="btn btn-info" href="/schResource/wym/MajorInfo.do?id=${info.MAJOR_ID}" role="button">${info.MAJOR_NAME}</a>
				<span class="glyphicon glyphicon-chevron-right"></span>
				<a class="btn btn-info" role="button">${info.RESOURCE_NAME}</a>
			</div>
		</c:forEach>	 
		<c:forEach var="info" items="${info.info}">	 
		<div class="well">
			<div id="context_div">
				<span class="glyphicon glyphicon-folder-open" id="total">&nbsp;${info.RESOURCE_NAME}</span>
				<button type="button" name="${info.RESOURCE_ID}" id="typename" class="btn btn-warning btn-xs">${info.RESOURCE_TYPE_NAME}</button>
						
				<span id="pingfen_span">
					<c:if test="${info.ave!=null}">平均评分:${info.ave}分</c:if>
					<c:if test="${info.ave==null}">还未有人评分</c:if>
				</span>
				<span id="down_span">下载量:${info.count}</span>
				<div id="jianjie_span">
					<span>简介:${info.RESOURCE_INFO}</span>
				</div>
				<p>
					<a class="btn btn-primary btn-lg" id="download" role="button"><span class="glyphicon glyphicon-download-alt"></span>下载</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn btn-primary btn-lg" id="shoucang" role="button"><span class='glyphicon glyphicon-heart'></span>收藏</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn btn-primary btn-lg" id="show" role="button"><span class='glyphicon glyphicon-search'></span>预览</a>
				</p>
				</div>				
		</div>
		</c:forEach>
		
		<!-- 星星 -->
		<div class="content">
			<p class="title">让你的评分帮助更多同学</p>
			<div id="starttwo" class="block clearfix">
				<div class="star_score"></div>
				<p style="float: left;">
					您的评分：<span class="fenshu"></span> 分
					<a class="btn btn-info" id="pingfen" role="button">评分</a>
				</p>
			</div>
		</div>
		
		
			<button class="btn btn-primary" type="button" data-toggle="collapse"
				data-target="#collapseExample" aria-expanded="false"
				aria-controls="collapseExample" id="pinglun">评论专区</button>
			<div class="collapse" id="collapseExample">
				<div class="well">
					<div id="well">
						<c:forEach var="comment" items="${info.comment}">
							<div id="comment_div">
								<span id="comment_name">${comment.USER_NAME}</span><span>${comment.EVALUATIONTIME}</span><br>
								<span class="glyphicon glyphicon-volume-down"></span><span
									id="comment_content">${comment.EVALUATIONCONTENT}<br></span>
							</div>
						</c:forEach>
					</div>
					
					<div class="box">
						<div id="pagination" class="page fl"></div>
							<div class="info fl">
								<p>
								<!-- 	当前页数：<span id="current">3</span> -->
								</p>
							</div>
						</div>
					</div>
					
					<!-- 第二个手风琴 -->
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapseExample1"
						aria-expanded="false" aria-controls="collapseExample">
						<span class="glyphicon glyphicon-edit"></span>发表评论
					</button>
					<div class="collapse" id="collapseExample1">
						<div class="well">
							<textarea cols="10" rows="10" id="textrow"></textarea>
						</div>
						<button type="button" class="btn btn-success" id="comment_sub">发表</button>
					</div>
				</div>
			</div>
		</div>
			<div id="imgShow">                 
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
		location.href="/schResource/wym/infoInfo.do?id="+m;
	});
});

		//星星评分
		scoreFun($("#startone"))
		scoreFun($("#starttwo"),{
		      fen_d:22,//每一个a的宽度
		      ScoreGrade:5//a的个数 10或者
		})
	/* $('#pinglun').click(function(){
		$.ajax({
			url:"/schResource/wym/commentQuery.do",
			data:{
				"id":$("#typename").prop("name")
			},
			success:function(data){
				var str = "";
				for(var i=0;i<data.length;i++){
					str += "<div id='comment_div'><span id='comment_name'>"+data[i].USER_NAME+"</span><span>"+data[i].EVALUATIONTIME+"</span><br><span class='glyphicon glyphicon-volume-down'></span><span id='comment_content'>"+data[i].EVALUATIONCONTENT+"<br></span></div>";
				}
				$("#well").html(str);
			}
		});
	}); */
	
	//点击提交评论信息
	$("#comment_sub").click(function(){
		var text = $("#textrow").val();
		if(text.length==0){
			alert("请输入评论内容");
		}else{
			$.ajax({
				url:"/schResource/wym/CommentInsert.do",
				data:{
					"id":$("#typename").prop("name"),
					"text":text			
				},
				success:function(data){				
					$.ajax({
						url:"/schResource/wym/commentQuery.do",
						data:{
							"id":$("#typename").prop("name")
						},
						success:function(data){
							var str = "";
							for(var i=0;i<data.length;i++){
								str += "<div id='comment_div'><span id='comment_name'>"+data[i].USER_NAME+"</span><span>"+data[i].EVALUATIONTIME+"</span><br><span class='glyphicon glyphicon-volume-down'></span><span id='comment_content'>"+data[i].EVALUATIONCONTENT+"<br></span></div>";
							}
							$("#well").html(str);
						}
					});
				}
			});
		}
	});
	//查询用户是否评分过和收藏过
	window.onload=function(){
		$.ajax({
			url:"/schResource/wym/IsCommentQuery.do",
			data:{
				"id":$("#typename").prop("name")
			},
			success:function(data){			
				if(data.comment.length>0){
				//	$(".content").hide();
					$("#pingfen").html("您的评分是"+data.comment[0].SCORE+"分");
					$("#pingfen").attr("disabled","disabled");
				}
				if(data.collect.length>0){
					$("#shoucang").html("<span class='glyphicon glyphicon-heart'></span>取消收藏");
				}
			}
		})
	}
	
	//插入收藏和取消收藏
	$("#shoucang").click(function(){
		var ne = $("#shoucang").text();
		if(ne=='取消收藏'){
			//取消收藏ajax
			$.ajax({
				url:"/schResource/wym/RemoveCollectDelete.do",
				data:{
					"id":$("#typename").prop("name")
				},
				success:function(data){
					$("#shoucang").text('收藏');
				}
			});
		}else if(ne=='收藏'){
			//收藏ajax
			$.ajax({
				url:"/schResource/wym/CollectInsert.do",
				data:{
					"id":$("#typename").prop("name")
				},
				success:function(data){
					$("#shoucang").text('取消收藏');
				}
			});
		}
	});
	//插入评分
	$("#pingfen").click(function(){
		$.ajax({
			url:"/schResource/wym/ScoreInsert.do",
			data:{
				"id":$("#typename").prop("name"),
				"score":$(".fenshu").html()
			},
			success:function(data){
				alert("评论"+$(".fenshu").html()+"分成功");
				$("#pingfen").html("您的评分是"+$(".fenshu").html()+"分");
				$("#pingfen").attr("disabled","disabled");
			}
		});
	});
	$(function(){
		//下载
		$('#download').click(function(){
			$.ajax({
				url:"/schResource/file/selectDown.do",
				type:"post",
				data:{id:$("#typename").prop("name")},
				dataType:"text",
				success:function(data){
					alert(data);
					if(data=="success"){						
						if(confirm("你下载过此资源，是否重新下载")){
							downloaddo();
							return;
						}else{
							location.href = "/schResource/wym/myCenterQuery.do";
							return;
						}
					}else{
						downloaddo();
					}
				}
			});
		});
		
		function downloaddo(){
			location.href = "/schResource/file/download.do?id="+$("#typename").prop("name");
		}
		
		
		//预览
		$("#show").click(function(){
			$.ajax({
				url:"/schResource/file/showDown.do",
				type:"post",
				data:{id:$("#typename").prop("name")},
				dataType:"json",
				success:function(data){
					console.info(data);
					if(data.RESOURCE_TYPE_NAME == "图片"){
						var str = "<img src='"+data.url+"'/>";
						alert(str);
						$("#imgShow").append(str);
					}else if(data.RESOURCE_TYPE_NAME == "视频"){
						var flashvars={
								f:data.url,
								c:0,
								b:1,
								i:'/upload/1.jpg',
								g:'0'
								};
							var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent'};
							CKobject.embedSWF('ckplayer/ckplayer/ckplayer.swf','imgShow','ckplayer_imgShow','600','400',flashvars,params);	
							function closelights(){//关灯
								alert(' 本演示不支持开关灯');
							}
							function openlights(){//开灯
								alert(' 本演示不支持开关灯');
							}
					}else if(data.RESOURCE_TYPE_NAME == "压缩文件"){
						
					}else{
						//---------------------------------------
						var dd = data.swfpath;
						var str = "<a id='viewerPlaceHolder' style='width:650px;height:400px;display:block'></a> ";
						alert(str);
						$("#imgShow").append(str);
						alert(dd);
						var fp = new FlexPaperViewer(
		                         '/schResource/FlexPaperViewer',  
		                         'viewerPlaceHolder', { config : {  
		                         SwfFile : escape(dd),  
		                         Scale : 0.6,   
		                         ZoomTransition : 'easeOut',  
		                         ZoomTime : 0.5,  
		                         ZoomInterval : 0.2,  
		                         FitPageOnLoad : true,  
		                         FitWidthOnLoad : true,  
		                         FullScreenAsMaxWindow : false,  
		                         ProgressiveLoading : false,  
		                         MinZoomSize : 0.2,  
		                         MaxZoomSize : 5,  
		                         SearchMatchAll : false,  
		                         InitViewMode : 'SinglePage',  
		                           
		                         ViewModeToolsVisible : true,  
		                         ZoomToolsVisible : true,  
		                         NavToolsVisible : true,  
		                         CursorToolsVisible : true,  
		                         SearchToolsVisible : true,  
		                          
		                         localeChain: 'en_US'  
		                         }});  
						//----------------------------------------------------
					}
				}
			});
		});
	})
	
	
	//ajax完成时回调函数
	$(document).ajaxComplete(function(event, xhr, settings) {
	    //从http头信息取出 在filter定义的sessionstatus，判断是否是 timeout
	    if(xhr.getResponseHeader("sessionstatus")=="timeout"){ 
	        //从http头信息取出登录的url ＝ loginPath
	        if(xhr.getResponseHeader("loginPath")){
	            alert("会话过期，请重新登陆!");
	            //打会到登录页面
	            window.location.replace(xhr.getResponseHeader("loginPath"));  
	        }else{  
	            alert("请求超时请重新登陆 !");  
	        }  
	    }  
	});
	
	
	
	//获取评论总数
	var count = 1;   //评论总数
	$.ajax({
		async:false,
		url:"/schResource/wym/CommentCountQuery.do",
		dataType:"JSON",
		data:{
			"resourceid":$("#typename").prop("name")
		},
		success:function(data){
			$(".badge").html(data.count);
			count = data.totalPage;
		}
	});
	
	
	//我的上传分页
	$("#pagination").pagination({
		currentPage: 1,
		totalPage: count,
		isShow: false,
		count: 6,
		prevPageText: "< 上一页",
		nextPageText: "下一页 >",
		callback: function(current) {
			$.ajax({
				url:"/schResource/wym/commentQuery.do",
				data:{
					"id":$("#typename").prop("name"),
					"currPage":current
				},
				dataType:"JSON",
				success:function(data){
					var str = "";
					var resource_name = "";
					var status_name = "";
					for(var i=0;i<data.length;i++){
						str += "<div id='comment_div'><span id='comment_name'>"+data[i].USER_NAME+"</span><span>"+data[i].EVALUATIONTIME+"</span><br><span class='glyphicon glyphicon-volume-down'></span><spanid='comment_content'>"+data[i].EVALUATIONCONTENT+"<br></span></div>";
					}
					$("#well").html(str);
				}
			});
		}
	});

	

	
</script>
</html>

<jsp:include page="buttom.jsp"></jsp:include>






