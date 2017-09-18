 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="http://localhost:9088/schResource/js/easyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/easyui/themes/icon.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="http://localhost:9088/schResource/js/easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript">
  	$(function(){
  		//------------查询统计-----------
  		$('#dg').datagrid({    
  		    url:'${pageContext.request.contextPath}/query/downcount.do',
  		  	fitColumns:true,
  		  	fit:true,
  		  	pagination:true,
  		  	pageSize:'5',
  		  	pageList:'[5,10,15,20,25,30]',
  		    columns:[[    
  		        {field:'DOWNLOAD_ID',title:'下载编号',width:100,checkbox:true},    
  		        {field:'RESOURCE_NAME',title:'资源名',width:100},    
  		        {field:'DOWNLOAD_DATE',title:'上传时间',width:100},
  		      	{field:'DOWNUSER',title:'下载人',width:100},
  		      	{field:'RESOURCE_TYPE_NAME',title:'资源类型',width:100},
  		      	{field:'DOWNCOUNT',title:'下载次数',width:100}
  		    ]]
  		}); 
		
		$("#instituteId").combobox({    
		    url:'${pageContext.request.contextPath}/school/getInstitute.do',
		    panelHeight:'auto',
		    valueField:'INSTITUTE_ID',    
		    textField:'INSTITUTE_NAME',
		    onSelect:function(record){
		    	console.info(record);
		    	var url = '${pageContext.request.contextPath}/school/getMajor.do?instituteId='+record.INSTITUTE_ID;
		    	$("#majorId").combobox('reload',url);
		    }
		}); 
		
		$("#majorId").combobox({    
		    panelHeight:'auto',
	    	valueField:'MAJOR_ID',    
		    textField:'MAJOR_NAME'   
		});
		
		$("#typeId").combobox({
			url:'${pageContext.request.contextPath}/resourceType/typeInfo.do',
		    panelHeight:'auto',
	    	valueField:'RESOURCE_TYPE_ID',    
		    textField:'RESOURCE_TYPE_NAME'   
		});
		
		 //分页查询搜索
		$("#selectBtn").click(function(){
			var data={};
	     	data["username"] = $("#userId").val()
	     	data["resourceName"] = $("#resourceId").val()
	     	data["startDate"] = $("#start").val();
	     	data["endDate"] = $("#end").val();
	     	data["minCount"] = $("#minCount").val();
	     	data["maxCount"] = $("#maxCount").val();
	     	if($("#typeId").val() == '请选择类型'){
	     		data["typeId"] = null;
	     	}else{
	     		data["typeId"] = $("#typeId").val();
	     	}	
	     	console.info(data);
	     	$('#dg').datagrid('load',data);
	     }) 
	      $("#clearBtn").click(function(){
	    	 $('#dg').datagrid('load',{});
	    	 $('#dform').form().find('#userId').val('');
	    	 $('#dform').form().find('#resourceId').val('');
	    	 $('#dform').form().find('#startDate').val('');
	    	 $('#dform').form().find('#endDate').val('');
	    	 $('#dform').form().find('#minCount').val('');
	    	 $('#dform').form().find('#maxCount').val('');
	    	 $('#dform').form().find('#majorId').val('请选择专业');
	     })
	     
  	});
  </script>
  <style type="text/css">
  	th{
  		width:70px;
  		margin-left:10px;
  	}
  </style>
</head>

<body class="easyui-layout" border="false">   
    <div data-options="region:'north',title:'过滤',split:true" border="false" style="height:200px;">
    	<form id="dform" method="post">
    		<h3 style="margin-left:180px;">查询条件</h3>
    		<table style="margin-left:200px;">
    		
    			<tr>
    				<th>资源名</th><td><input class="easyui-validatebox"  name="resouceName" id="resourceId"></td>
    				<th>用户名</th><td><input class="easyui-validatebox"  name="username" id="userId"></td>
    			</tr>
    			<tr>
    				<th>开始时间</th><td><input id="start" name="starDate" type="text" class="easyui-datebox"/></td>
    				<th>结束时间</th><td><input id="end" name="endDate" type="text" class="easyui-datebox" /></td>
    			</tr>
    			<tr>
    				<th>最小下载量</th><td><input id="minCount" name="minCount" type="text" class="easyui-numberbox"/></td>
    				<th>最大下载量</th><td><input id="maxCount" name="maxCount" type="text" class="easyui-numberbox" /></td>
    			</tr> 
    			<tr>
    				<th>类型</th><td><input id="typeId" name="typeId" value="请选择类型" data-options="editable:false"></td>
    				<th></th>
    				<td>
    					<a  href="javascript:void(0)" id="selectBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查找</a>
    		        	<a  href="javascript:void(0)" id="clearBtn" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">清空</a> 
    				</td>
    			</tr> 
    					        
    		</table>
    	</form>
    </div>     
    <div data-options="region:'center',title:'',border:'false'" style="padding:0px;background:#eee;">
    	<table id="dg"></table>
    </div>   
</body>  
	


</html>