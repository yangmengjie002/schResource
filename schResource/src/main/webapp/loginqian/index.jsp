<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="/schResource/loginqian/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/schResource/loginqian/css/demo.css" />
<!--å¿è¦æ ·å¼-->
<link rel="stylesheet" type="text/css" href="/schResource/loginqian/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>校园资源共享平台</h3>
						<form action="/schResource/user/login.do" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>${msg}
								<input name="userName" class="text" style="color: #FFFFFF !important" type="text" placeholder="用户名">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="userPwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"  type="password" placeholder="密码">
							</div>
							<div class="mb2"><input type="submit" class="act-but submit"  style="color: #FFFFFF" value="登录"/></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="/schResource/loginqian/js/TweenLite.min.js"></script>
		<script src="/schResource/loginqian/js/EasePack.min.js"></script>
		<script src="/schResource/loginqian/js/rAF.js"></script>
		<script src="/schResource/loginqian/js/demo-1.js"></script>
		<div style="text-align:center;">

</div>
	</body>
</html>