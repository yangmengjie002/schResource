<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>已下架资源恢复操作</title>
</head>
<body>
	
	输入资源名称：<input id="resourceName" class="easyui-validatebox"/>  
	输入下架日期：<input type="text" id=uploadDate class="easyui-datebox"/>  
	<a id="huiFuSeach" class="easyui-linkbutton" data-options="iconCls : 'icon-search'">搜索</a> 
	
	
	<table id="dg">
		
	</table>
	
	
</body>

	<script type="text/javascript">
	$('#dg').datagrid({    
	    url:'/schResource/wym/HuiFu.do',    
	    columns:[[ 
			{field:'RESOURCE_ID',title:'资源ID',checkbox:true},       
	        {field:'RESOURCE_NAME',title:'文件名称',width:60},    
	        {field:'USER_NAME',title:'上传人',width:60},    
	        {field:'MAJOR_NAME',title:'文件所属系',width:60},
	        {field:'INSTITUTE_NAME',title:'文件所属院',width:60},
	        {field:'UPLOAD_DATE',title:'上传时间',width:60},
	        {field:'CHECK_DATA',title:'审批时间',width:60},
	        {field:'RELEASE_DATE',title:'发布时间',width:60},
	        {field:'SOLDOUT_DATE',title:'下架时间',width:60}
	    ]],
	    fitColumns:true,
	    pagination:true,
		rownumbers:true,
		pageSize:3,
		pageList:[3,6,9],
		toolbar:[{
			text:"恢复资源",
			iconCls:'icon-reload',
			handler:function(){
				var rowDatas = $("#dg").datagrid("getSelections");
				if(rowDatas.length>0){
					var rowArr = new Array();
					for(var i=0;i<rowDatas.length;i++){
						rowArr[i]=rowDatas[i].RESOURCE_ID;
					}
					$.ajax({
						url:"/schResource/wym/HuiFuUpdate.do",
						data:{
							'rowArr':rowArr.join(',')
						},
						success:function(data){
							if(data==1){
								for(var j=rowDatas.length-1;j>=0;j--){
									var index = $('#dg').datagrid('getRowIndex',rowDatas[j]);
									$('#dg').datagrid('deleteRow',index);
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
	
	
	//搜索按钮点击事件
	$("#huiFuSeach").click(function(){
		var data = {};
		data["resourceName"] = $("#resourceName").val();       //封装资源名称
		data["uploadDate"] = $("#uploadDate").val();           //封装下架时间
		$("#dg").datagrid('load',data);                       //传入后台并更新数据
	});
 
	 
	 </script>
</html>