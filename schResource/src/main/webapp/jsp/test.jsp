<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" mrc="text/html; charset=utf-8" />
<title>css排行榜</title>
<style type="text/css"> 


li a { 
	color: #3083C7;
	white-space: nowrap;
}

.rank_list { 
	line-height: 14px;
	margin: auto;
	padding-top: 5px;
}

.rank_list li {
	height: 14px;
	margin-bottom: 8px; 
	padding-left: 20px;
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
	font-size: 10px; 
	font-family: Arial;
	background: #E6F0FD;
	text-align: center; 
	line-height: 12px;
	overflow: hidden;
}


</style>
</head>
<body>
	
		<ul class="rank_list">
			<li class="top3"><em>1</em><a href="#">艾恩An-Upload 无组件上传类</a><span>21</span></li>
			<li class="top3"><em>2</em><a href="#">EasySlide jQuery图片轮显</a><span>528</span></li>
			<li class="top3"><em>3</em><a href="#">通用Ajax无刷新表彰验证类</a><span>232</span></li>
			<li><em>4</em><a href="#">支持中文的鼠标取词VB源码</a><span>74</span></li>
			<li><em>5</em><a href="#">通用Ajax无刷新表彰验证类</a><span>56</span></li>
			<li><em>6</em><a href="#">EasySlide jQuery图片轮显</a><span>85</span></li>
			<li><em>7</em><a href="#">支持中文的鼠标取词VB源码</a><span>25</span></li>
			<li><em>8</em><a href="#">多样式链接提示框组件</a><span>85</span></li>
			<li><em>9</em><a href="#">类似lightbox的无刷新图片显示插件</a><span>41</span></li>
			<li><em>10</em><a href="#">通用Ajax无刷新表彰验证类</a><span>62</span></li>
		</ul>
</body>
</html>