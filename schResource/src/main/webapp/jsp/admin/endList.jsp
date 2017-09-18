<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="http://localhost:9088/schResource/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="http://localhost:9088/schResource/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="http://localhost:9088/schResource/js/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="http://localhost:9088/schResource/js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/easyui-lang-zh_CN.js"></script>  
<title>资源结束下架操作</title>
</head>
<body>
	<!-- <input type="button" id="end" class="btn btn-warning" value="下架资源" />	 -->
	
	<table id="dg">
		
	</table>
</body>

	<script type="text/javascript">
	$('#dg').datagrid({    
	    url:'/schResource/wym/ResourceEnd.do',    
	    columns:[[ 
			{field:'RESOURCE_ID',title:'资源ID',checkbox:true},       
	        {field:'RESOURCE_NAME',title:'文件名称',width:60},    
	        {field:'USER_NAME',title:'上传人',width:60},    
	        {field:'MAJOR_NAME',title:'文件所属系',width:60},
	        {field:'INSTITUTE_NAME',title:'文件所属院',width:60},
	        {field:'UPLOAD_DATE',title:'上传时间',width:60},
	        {field:'CHECK_DATA',title:'审批时间',width:60},
	        {field:'RELEASE_DATE',title:'发布时间',width:60}
	    ]],
	    fitColumns:true,
		striped:true,
		pagination:true,
		rownumbers:true,
	//	fit:true,
		pageSize:3,
		pageList:[3,6,9],
		toolbar:[{
			text:"下架资源",
			iconCls:'icon-clear',
			handler:function(){
				var rowDatas = $("#dg").datagrid("getSelections");  //获取选中的对象数组
				if(rowDatas.length>0){
					var rowArr = new Array();      //创建一个数组用来存储对象数组的ID
					for(var i=0;i<rowDatas.length;i++){
						rowArr[i]=rowDatas[i].RESOURCE_ID;
					}
					$.ajax({
						url:"/schResource/wym/ResourceEndInsert.do",
						data:{
							'rowArr':rowArr.join(',')       //把数据拼接成一个字符串传给后台
						},
						success:function(data){
							if(data==1){
								for(var j=rowDatas.length-1;j>=0;j--){
									var index = $('#dg').datagrid('getRowIndex',rowDatas[j]);  //获取行的索引
									$('#dg').datagrid('deleteRow',index);        //按照索引删除改行
								}
							}
						},
						error:function(){
							alert(rowArr.join(','));
						}
					});
				}else{
					alert("请至少选中一行");
				}
			}
		}]
	}); 
	
 
	 
	 </script>
</html>