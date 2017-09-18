<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/easyui/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/easyui/themes/icon.css"
	type="text/css"></link>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		textarea{
			width:220px;
			height:160px;
		}
		#infoCs{
			margin-left: 16%;
		}
	</style>

</head>
<body>
	<div>
		<!-- 获取资讯表数据 -->
		<table id="dg"></table>
		<!-- 添加一条资讯 -->
		<form action=${pageContext.request.contextPath}/insertInfo.do id="addInfo" method="post"></form>
		<!-- 修改 -->
		<table id="updateInfo" ></table>
	</div>
</body>
</html>
<script>
$(function(){
	$('#dg').datagrid({
		url : '${pageContext.request.contextPath}/informationManage.do',
		fitColumns : true,
		striped : true, //奇偶行是否使用不同的颜色
		loadMsg : '数据正在努力加载，请稍后...', //加载数据时显示提示信息
		pagination : true,//如果表格需要支持分页，必须设置该选项为true
		pageSize : 10, //表格中每页显示的行数
		rownumbers : true, //是否显示行号
		singleSelect : true, //选择一行
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$('#addInfo').dialog({
					 	title: '添加资讯',   
					 	iconCls : 'icon-add',
					    width: 500,    
					    height: 300,    
					    closed: false,    
					    cache: false,    
					    modal: true,
					    onOpen : function(){
					    	var str = "";
					    	str += "<table id='infoCs'>";
					    	str += "<tr><td><font size=3>资讯标题：</font><input name='informationTitles' id='informationTitles' type='text'/></td></tr>";
					    	str += "<tr><td><font size=3>资讯内容：</font><textarea name='informationContents' id='informationContents'/></td></tr>";
					    	str += "</table>";
					    	$('#addInfo').html(str);
					    	
					    } ,
					    buttons:[{
					    	text:'保存',
					    	iconCls:"icon-save",
					    	handler:function(){
					    		$("#addInfo").submit();
					    	}
					    } ,{
					    	text:'关闭',
					    	iconCls:"icon-no",
					    	handler:function(){
					    		$('#addInfo').dialog('close');
					    	}
					    }]

				});
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-cut',
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert("提示信息","请选择一行进行删除!","info");
				}else{
					$.messager.confirm('确认','您确认想要删除吗？',function(r){    
					    if (r){    
					        alert(row.informationID); 
					        $.ajax({
					        	url:'${pageContext.request.contextPath}/deleteInfo.do',
					        	data:{"informationID":row.informationID,},
					        	success:function(data){
					        		$('#dg').datagrid('reload'); // 重新载入当前页面数据
					        	}
					        })
					    }    
					});
				}
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-save',
			handler : function() {
				var titStr = "";
				var conStr = "";
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert("提示信息","请选择一行进行修改!","info");
				}else{
					$("#updateInfo").dialog({
						title:"修改资讯信息",
						width:380,
						height:400,
						modal:true,
						onOpen:function(data){
							var str = "";
							str += "<tr><td><font size=4 color='green'>资讯标题：</font><input type='text' id='upTitle' value="+row.informationTitle+"><hr style='height:1px;border:none;border-top:1px dashed #0066CC;' /></td></tr>";
							str += "<tr><td><font size=4 color='green'>资讯内容：</font><textarea id='upContent'>"+row.informationContent+"</textarea><hr style='height:1px;border:none;border-top:1px dashed #0066CC;' /></td></tr>";
							$("#updateInfo").html(str);
						},
						buttons:[
						         {
						        	 text:'修改',
						        	 handler:function(){
						        		 $.ajax({
						        			 url:'${pageContext.request.contextPath}/updateInfo.do',
						        			 data:{"informationTitle":$('#upTitle').val(),"informationContent":$("#upContent").val(),"informationId":row.informationID},
						        			 success:function(){
						        				 if(true){
						        					 $("#updateInfo").dialog("close");
						        					 $('#dg').datagrid("reload");
						        					 $.messager.show({
						        							title:'恭喜修改成功！',
						        							msg:'消息将在5秒后关闭。',
						        							timeout:5000,
						        							showType:'slide'
						        						});

						        				 }else{
						        					 alert("修改失败！");
						        				 }
						        			 }
						        		 })
						        	 }
						         },{
						        	 text:'关闭',
									 handler:function(){
						        		 
						        	 }
						         }
						]
					})
				}
			}
		} ],
		columns : [ [ {
			field : 'informationID',
			title : '资讯编号',
			width : 100,
			align : 'center'
		}, {
			field : 'informationTitle',
			title : '资讯标题',
			width : 100,
			align : 'center'
		}, {
			field : 'informationContent',
			title : '资讯内容',
			width : 100,
			align : 'center'
		}/* , {
			field : 'user_id',
			title : '撰写人',
			width : 100,
			align : 'center'
		} */ ] ]
	});
	//解决分页组件的中文乱码
	var p = $('#dg').datagrid('getPager'); 
	$(p).pagination({  
                pageSize: 10,//每页显示的记录条数，默认为10    
                pageList: [5, 10, 15],//可以设置每页记录条数的列表    
                beforePageText: '第',//页数文本框前显示的汉字    
                afterPageText: '页    共 {pages} 页',  
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
    }); 
	 
	
	//添加资讯信息

	$('#dg').datagrid('reload'); // 重新载入当前页面数据
});
</script>