<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="head.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下载总列表</title>

<style type="text/css">
    #institute_body_div {
      width:70%;
      margin-left:15%;
      border:1px solid #EDEDE0;
      height:auto;
      float:left;
    }
    #major_body_div{
    	width:100%;
    	float:left;
    	border-bottom:3px solid #EDEDF0;
    }
    #institute_body_div li{
    	list-style:none;
    	float:left;
    	width:27%;
    	height:50px;
    	line-height:50px;
    	color:#0053A5;
    }
    #institute_body_div li span{
    	padding:7px;
    	width:100%;
    	border-bottom:1px solid #EDEDF0;
    	font-size:16px;
    }
    #institute_body_div li span:hover{
    	background:#96D97B;
    }
    #major_total_div{
    	font-size:18px;
    	font-weight:600;
    	float:left;
    	width:160px;
    	height:200%;
    	margin:3px 0px 0px 13px;  
    	font-family:"宋体";
    }
    #major_total_div li{
    	width:100%;
    	height:100%; 
    	color:#000000;     	
    }
</style>

</head>
<body>
	<div id="institute_body_div">
		<div id="major_body_div">
			
		</div>
	</div>
</body>
<script type="text/javascript">
window.onload=function(){
	var institute_id = 0;
	var str = "";
	var major_id = 0;
	$.ajax({
		url:"/schResource/wym/instituteAllQuery.do",			
		dataType:"JSON",
		success:function(data){
			for(var i=0;i<data.length;i++){
				institute_id=data[i].instituteId;
				str +="<div id='major_body_div'><ul id='major_total_div'><li>"+data[i].instituteName+"</li></ul><ul>";
				
				$.ajax({
				 	async:false,
			 		url:"/schResource/wym/TbMajorQuery.do",
					dataType:"JSON",
					data:{
						"institute_id":institute_id
					},
					success:function(data){
						for(var i=0;i<data.length;i++){
							major_id = data[i].MAJOR_ID;
							$.ajax({
								async:false,
								url:"/schResource/wym/queryTbResourceUploadId.do",
								dataType:"JSON",
								data:{
									"major_id":major_id
								},
								success:function(data1){
									if(data1==0){
										str += "<li><span>"+data[i].MAJOR_NAME+"("+data1+")</span></li>";
									}else{
										str += "<li><a style='text-decoration:none;' href='/schResource/wym/MajorInfo.do?id="+data[i].MAJOR_ID+"'><span>"+data[i].MAJOR_NAME+"("+data1+")</span></a></li>";
									}
								}
							})
						}
						str +="</ul></div>";
					}
				});
				
			}
			$("#institute_body_div").html(str);
		}
	});	
	
	
}
</script>

</html>















