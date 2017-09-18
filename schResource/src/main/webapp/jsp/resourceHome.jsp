<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="http://localhost:9088/schResource/js/bootstrap/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="http://localhost:9088/schResource/js/bootstrap/bootstrap.min.js"></script>
<link href="http://localhost:9088/schResource/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="http://localhost:9088/schResource/js/bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">

<script src="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://localhost:9088/schResource/sousuo/js/jquery.autocompleter.css">	

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
		

		
		$.ajax({
			url:'/schResource/queryInformation.do',
			dataType:'json',
			success:function(data){
				var informs = {};
				var str = "";
				var strss = "";
				informs = data;
				console.info(informs);
				for(var i=0;i<informs.length;i++){
					str += "<tr><td><a>"+informs[i].informationTitle+"</a></td></tr>";
					str += "<tr><td><h5>&nbsp;&nbsp;"+informs[i].informationContent+"</h5><hr></td></tr>";
				}
					$("#informTb").append(str);				
			}
		})
		//----------------------------排行榜
		$.ajax({
			url:"/schResource/resourceType/order.do",
			dataType:"json",
			success:function(data){
				console.info(data);
				var str1 = "";
				var str2 = "";
				var m1 = 10;
				var m2 = 10;
				if(data.down.length<=10){
					m1 = data.down.length;
				}
				
				if(data.score.length<=10){
					m2 = data.score.length;
				}
				for(var i=0;i<m1;i++){ 
					if(i<3){
						
						str1 +="<li class='top3'><em>"+(i+1)+"</em><a href='/schResource/wym/infoInfo/lan.do?id="+data.down[i].RESOURCE_ID+"'>";
						str1 +="<span><font size=4px>"+data.down[i].RESOURCE_NAME+"</font></span></a>"; 
						str1 +="<span style='float:right;'>"+data.down[i].DOWNSUM+"次</span>";
						str1 +="<p><font size=1px>"+data.down[i].RESOURCE_INFO+"</font></p>";  
						str1 +="</li>";   
					}else if (i>3) {
						str1 +="<li><em>"+(i+1)+"</em><a href='/schResource/wym/infoInfo/lan.do?id="+data.down[i].RESOURCE_ID+"'>";
						str1 +="<span><font size=4px>"+data.down[i].RESOURCE_NAME+"</font></span></a>"; 
						str1 +="<span style='float:right;'>"+data.down[i].DOWNSUM+"次</span>";
						str1 +="<p><font size=1px>"+data.down[i].RESOURCE_INFO+"</font></p>";  
						str1 +="</li>"; 
					}
					
				} 
				$("#down").append(str1);
				for(var i=0;i<m2;i++){
					if(i<3){
						str2 +="<li class='top3'><em>"+(i+1)+"</em><a href='/schResource/wym/infoInfo/lan.do?id="+data.score[i].RESOURCE_ID+"'>";
						str2 +="<span><font size=4px>"+data.score[i].RESOURCE_NAME+"</font></span></a>";
						str2 +="<span style='float:right;'>"+data.score[i].SCOREORDER+"分</span>";
						str2 +="</li>";
					}else if(i>3){
						str2 +="<li><em>"+(i+1)+"</em><a href='/schResource/wym/infoInfo/lan.do?id="+data.score[i].RESOURCE_ID+"'>";
						str2 +="<span><font size=4px>"+data.score[i].RESOURCE_NAME+"</font></span></a>";
						str2 +="<span style='float:right;'>"+data.score[i].SCOREORDER+"分</span>";
						str2 +="</li>";
					}
					
				}
				$("#score").append(str2);
			}
			
			
		});
		
		
		
	});
	
	//校验修改密码
	function validate() {
		var pswd1 = $("#pswd1").val();
		var pswd2 = $("#pswd2").val();
		var str = "";
		if(pswd1.length<6){
				str += "<font color='red'>密码不能少于6位数</font>";
				$("#tishi").html(str); 
				$("#submit1").attr("disabled", true);
		}else{
			if (pswd1 == pswd2) {
				str += "<font color='green'>密码设置成功！</font>";
				$("#tishi").html(str);
				$("#submit1").attr("disabled", false);
			} else {
				str += "<font color='red'>两次密码不一致,请重新输入</font>";
				$("#tishi").html(str);
				$("#submit1").attr("disabled", true);
			}
		} 
		
	}
</script>

</head>
<style type="text/css">
body {
	width: 80%;
	margin-left: 10%;
}

#informTb{
	font-size: 17px; 
	font-weight: bold;
	margin-bottom: 3px; 
	color: #444;
}
#tails{
	color: #1eb97b;
}
#divider{
	padding: 0 22px;
	color: #ccc;
}
#formWapper {
	margin-top: 5%;
	margin-left: 15%;
}
.load-more{
	display: block;
	width: 90%;
	height: 40px;
	background-color: #f3f3f3;
	text-align: center;
	line-height: 40px;
	text-decoration: none;
	color: #666;
	margin: 20px auto;
}
.load-more-i:after{
	content: '';
    display: inline-block;
    width: 21px;
    height: 21px;
    vertical-align: -5px;
    margin-left: 5px;
    background-image: url(http://mat1.gtimg.com/www/mobi/image/icon.png);
    background-repeat: no-repeat;
	background-position: -42px 0;
    -webkit-background-size: 119px 21px;
    -moz-background-size: 119px 21px;
    -o-background-size: 119px 21px;
    background-size: 119px 21px;
}
.no-unline {
			text-decoration: none;
			text-decoration: none !important;
}
/* 排行榜 Styles*/
.rank_list { 
	line-height: 24px;  
	margin: auto;
	padding-top: 5px;
}

.rank_list li {   
	height: 55px; 
	margin-bottom: 8px;     
	padding-left: 35px; 
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.rank_list li.top3 em {
	background: #FFE4B7;
	border: 1px solid #FFBB8B;
	color: #FF6800;
}

.rank_list em {
	position: absolute;	
	left: 0;  
	top: 0;
	width: 22px;
	height: 22px;
	border: 1px solid #B1E0F4; 
	color: #6298CC;
	font-style: normal; 
	font-size: 15px; 
	font-family: Arial; 
	background: #E6F0FD;
	text-align: center; 
	line-height: 22px;   
	overflow: hidden;  
}
  /* 排行榜END。。。。。*/



/* Custom Styles */
ul.nav-tabs {
	width: 160px;
	margin-top: 20px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}

ul.nav-tabs li {
	margin: 0;
	border-top: 1px solid #ddd;
}

ul.nav-tabs li:first-child {
	border-top: none;
}

ul.nav-tabs li a {
	margin: 0;
	padding: 8px 16px;
	border-radius: 0;
}

ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}

ul.nav-tabs li:first-child a {
	border-radius: 4px 4px 0 0;
}

ul.nav-tabs li:last-child a {
	border-radius: 0 0 4px 4px;
}
#myTab{
	width:100%;
	float:right;
} 

ul.nav-tabs.affix {
	top: 25%;
}
</style>

<body>
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
			<a class="navbar-brand" href="/schResource/jsp/resourceHome.jsp">校园资源共享平台</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/schResource/jsp/majorQuery.jsp">下载专区 <span class="sr-only">(current)</span></a></li>
				<li><a href="/schResource/jsp/teacherStyleHome.jsp">名师风采</a></li>
				<li class="资源分享"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">资源 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/schResource/jsp/majorQuery.jsp">资源下载</a></li>
						<li><a href="/schResource/jsp/fileupload.jsp">资源上传</a></li>
						<li><a href="#">资源排行</a></li>
					</ul></li>
			</ul> 
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" id="btnSelect" class="form-control" placeholder="资源">
				</div>
				<button type="button" id="selectClick"  class="btn btn-default">搜索</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${user!=null}">
					<li><a>欢迎${user.userName}</a></li>
					<li><a href="" data-toggle="modal"
						data-target=".bs-example-modal-sm">更改密码</a>
						<div class="modal fade bs-example-modal-sm" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog" style="width: 520px;">
								<div class="modal-content" style="height: 300px">
									<div class="form-group">
										<div class="col-sm-12">
											<h3>更改密码</h3>
											<hr>
										</div>
									</div>
									<form action="/schResource/userCheckPwd/checkPwd.do"
										id="formWapper" method="post" class="form-horizontal">

										<div class="form-group">
											<label class="col-sm-3 control-label">新密码：</label>
											<div class="col-sm-7">
												<input type="password" name="pswd" class="form-control"
													id="pswd1" placeholder="请输入新密码">
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">确认密码：</label>
											<div class="col-sm-7">
												<input type="password" class="form-control" id="pswd2"
													onkeyup="validate()" placeholder="再次确认新密码"><span
													id="tishi"></span>
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-11">
												<input type="submit" id="submit1" class="btn btn-primary"
													value="修改密码" />
											</div>
										</div>
									</form>
								</div>
							</div>
						</div></li>
				</c:if>

				<c:if test="${user==null}">
					<li><a href="/schResource/loginqian/index.jsp">您好,请登录</a></li>
				</c:if>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">我的<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/schResource/jsp/MyCenter.jsp">个人中心</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/schResource/user/logoutQian.do">退出</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- 图片滚动效果 -->
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="http://localhost:9088/schResource/images/jdt01b.jpg" alt="...">
				<div class="carousel-caption">1</div>
			</div>
			<div class="item">
				<img src="http://localhost:9088/schResource/images/jdt01b.jpg" alt="...">
				<div class="carousel-caption">2</div>
			</div>
			<div class="item">
				<img src="http://localhost:9088/schResource/images/jdt01b.jpg" alt="...">
				<div class="carousel-caption">3</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#carousel-example-generic"
			data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
			href="#carousel-example-generic" data-slide="next">&rsaquo;</a>

	</div>
	<div class="row">
		<!-- 排行榜。。。。 -->
		<div class="col-xs-6" style="margin-top:0px;font-size:16px;">
		<h3>资源排行</h3> 
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">下载排行
				</a></li>
				<li><a href="#ios" data-toggle="tab">评分排行</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<span>资源名</span><span style='float:right;'>下载次数</span>
					<ol id="down" class="rank_list"></ol>
				</div>  
				<div class="tab-pane fade" id="ios">
				<span>资源名</span><span style='float:right;'>评分</span>
					<ol id="score" class="rank_list"></ol>
				</div>
			</div>
			
		</div>
		<!-- 排行榜end。。。。 -->
		<div class="col-xs-1">
		</div>
		<div class="col-xs-5">
			<h3>
				<span class="glyphicon-envelope">校园新闻</span><hr style="height:6px;border:none;border-top:6px groove skyblue;"/>
			</h3>
			<div>
				<table id="informTb" >
				</table>
				<c:if test=""></c:if>
				<span><a class="load-more load-more-i" href="javascript:void(0);" onclick="javascript:this.innerHTML=(this.innerHTML=='已显示全部内容'?'已显示全部内容':'已显示全部内容')">点击查看更多</a></span>
			</div>
			<hr>
		</div>
		
		
	</div>
	</div>
</body>
</html>
<script>


	/* 附加导航（随屏幕滚动）
	  $(document).ready(function() {
		$("#myNav").affix({
			offset : {
				top : 125
			}
		});
	}); */
</script>