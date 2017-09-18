<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
	src="http://localhost:9088/schResource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="http://localhost:9088/schResource/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	type="text/css"></link>
	<script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
	<script src="https://img.hcharts.cn/highcharts/modules/data.js"></script>
	<script src="https://img.hcharts.cn/highcharts/modules/drilldown.js"></script>
	<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
</head>
<body>
	<div class="col-md-1" style="margin-top:20px;">
		<select id="select"><option checked="true" value="1">最近一月</option><option value="2">最近一季度</option><option value="3">总体情况</option></select>
	</div>
	<div class="col-md-11"  style="margin-top:14px;"><button id="btn" type="button" class="btn btn-default">详细情况</button></div>
	
	<div id="container" style="width:800px;height:600px"></div>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				location.href="/schResource/jsp/admin/upCount.jsp";
			});
			function changeUp(idd){
			$.ajax({
				 url:'/schResource/query/upPicture.do',
				 data:{id:idd},
				 dataType:"json",
				 success:function(data){
					 console.info(data);
					 
					 Highcharts.chart('container', {
					        chart: {
					            type: 'column'
					        },
					        title: {
					            text: '学校各学院资源上传情况'
					        },
					        subtitle: {
					            text: '点击可查看具体的版本数据，数据来源: <a href="https://netmarketshare.com">netmarketshare.com</a>.'
					        },
					        xAxis: {
					            type: 'category'
					        },
					        yAxis: {
					            title: {
					                text: '总的上传份额'
					            }
					        },
					        legend: {
					            enabled: false
					        },
					        plotOptions: {
					            series: {
					                borderWidth: 0,
					                dataLabels: {
					                    enabled: true,
					                    format: '{point.y:.1f}%'
					                }
					            }
					        },
					        tooltip: {
					            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
					            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
					        },
					        series: [{
					            name: '学院资源上传',
					            colorByPoint: true,
					            data:data.institute
					  		}],
					        drilldown: {
					            series: data.major
					        }
					    });
				 }		 
			});
		  }
			
			$("#select").change(function(){
				var idd = $("#select").val();
				changeUp(idd);
			});
			changeUp($("#select").val());
		});
	</script>
</body>
</html>