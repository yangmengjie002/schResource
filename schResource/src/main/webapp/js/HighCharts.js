/**
 * 图表标题
 * @param titleText
 * @returns title
 */
function getTitle(titleText){
	var title = {
			text: titleText
	}
	return title;
}
/**
 * 副标题
 * @param subTitleText
 * @returns subtitle
 */
function getSubTitle(subTitleText){
	var sbuTitle = {
			text : subTitleText
	}
	return sbuTitle;
}
/**
 * 图表配置
 * @param charts [line:折线图,column:柱状图,pie:饼图,errorbar:误差图,spline:曲线图,scatter:散点图]
 * @returns chart
 */
function getChart(charts){
	var chart ={
			type : charts,
			events: {
				selection: function (event) {
					var text,
					label;
					if (event.xAxis) {
						text = 'min: ' + Highcharts.numberFormat(event.xAxis[0].min, 2) + ', max: ' + Highcharts.numberFormat(event.xAxis[0].max, 2);
					} else {
						text = 'Selection reset';
					}
					label = this.renderer.label(text, 100, 120)
					.attr({
						fill: Highcharts.getOptions().colors[0],
						padding: 10,
						r: 5,
						zIndex: 8
					})
					.css({
						color: '#FFFFFF'
					})
					.add();
					setTimeout(function () {
						label.fadeOut();
					}, 1000);
				}
			},
			zoomType: 'x'
	}
	return chart;
}
/**
 * 坐标轴x轴数据
 * @returns xAxis
 */
function getXaxis(){
	var xAxis ={
			crosshair: true,
			type : "category"
	}
	return xAxis;
}
/**
 * 坐标轴y轴信息
 * @param yTitleText y轴标题
 * @returns yAxis
 */
function getYaxis(yTitleText){
	var yAxis ={
			crosshair: true,
			title:{
				text:yTitleText
			}
	}
	return yAxis;
}
/**
 * 图例设置
 * @returns legend
 */
function getLegend(){
	var legend = {
			align: 'center',
			verticalAlign: 'bottom',
			borderWidth: 0
	}
	return legend;
}
var dataList = "";

/**
 * 数据列配置
 * @returns plotOptions
 */
function getPlotOptions(){
	var plotOptions = {
			series: {
				cursor:'pointer',
				events: {

					click: function () {
						//alert('您点击了数据列：' + this.name);
						var datas = [];
						//var i=0;
						$.each(dataList,function(index,value){
							var dat ={};
							dat.name = value.series.name;
							dat.y = value.y;
							datas[index] = dat;
							//i++;
						});


						if(this.type !='pie'){
							//alert("sdfasfd");
							$("#asd").dialog({
								title: '图表详情',    
								width: 600,    
								height: 350,
								closed: false,
								cache: false,    

								modal: true 
							});
							$('#sad').datagrid({    
								data:datas,
								pagination:true,
								rownumbers:true,
								striped:true,
								ctrlSelect:true,
								total:datas.length,
								pageSize:10,
								pageList:[5,10,15,20],
								onChangePageSize:function(pageSize){
									alert(pageSize);
								},
								columns:[[    
									{field:'name',title:'银行名称',width:100},    
									{field:'y',title:'不良记录数',width:100},    

									]]    
							});  
						}
					}
				},
				point: {
					events: {
						click: function() {
							//alert('您点击的点的值是：' + this.name + '\t' + this.y);
							$("#asdspan").text(this.name);
						}
					}
				},
				dataLabels : {
					enabled : true
				},
				showInLegend: true
			},
	        pie:{
	        	tooltip:{
	        		headerFormat:'<small>{point.key}</small><br/>',
	        		pointFormat:'{series.name}: <b>{point.y}</b><br/>'
	        	}
	        }
	}
	dataList = "";
	return plotOptions;
}
function getToolTip(){
	var tooltip = {
			followPointer: true,
			shared: true,
			//split: true,

			useHTML: true,
			formatter: function () {
				dataList = this.points;
				var s =  '<small>'+this.x+'</small><br/>'; 
				$.each(this.points, function () {
					s += '<br/>' + this.series.name + ': ' +
					this.y + '元';
				});
				return s;
			}


	}
	return tooltip;
}

/**
 * 组装所有数据并加载成图表
 * @param id 标签id
 * @param titleText 主标题信息
 * @param subTitleText 副标题信息
 * @param charts 图表类型参数
 * @param yTitleText y轴标题
 * @param series 核心数据块
 * @param drilldown 向下钻取的数据
 * @returns null
 */
function getHighCharts(id,titleText,subTitleText,charts,yTitleText,series,drilldown){
	var json = {}
	json.legend = getLegend();
	json.tooltip = getToolTip();
	json.plotOptions = getPlotOptions();

	if(!$.isEmptyObject($.trim(titleText))){
		json.title = getTitle(titleText);
	}
	if(!$.isEmptyObject($.trim(subTitleText))){
		json.subtitle = getSubTitle(subTitleText);
	}
	if(!$.isEmptyObject($.trim(charts))){
		json.chart = getChart(charts);
	}
	if(!$.isEmptyObject($.trim(yTitleText))){
		json.xAxis = getXaxis();
		json.yAxis = getYaxis(yTitleText);
	}
	json.series = series;
	if(!$.isEmptyObject($.trim(drilldown))){
		json.drilldown = drilldown;
	}
	json.exporting =  {
			buttons: {
				contextButton: {
					symbol: 'menu',
					symbolStrokeWidth: 1,
					symbolFill: '#bada55',
					symbolStroke: '#330033'
				}
			}
	};
	Highcharts.setOptions({
		lang:{
			printChart: '打印图表',
			downloadJPEG: '下载 JPEG 文件',
			downloadPDF: '下载 PDF   文件',
			downloadPNG: '下载 PNG  文件',
			downloadSVG: '下载 SVG  文件',
			downloadCSV: '下载 CSV  文件',
			downloadXLS: '下载 XLS   文件',
			drillUpText:"返回 {series.name}",
			loading:"加载中"
		},
		navigation: {
			menuItemStyle: {
				padding: '6px 14px'
			}
		},

		credits: {
			text: 'AAA 68 班 不 良 贷 款 管 理 系 统',
			url: 'http://localhost:9088/bankBadLoan/jsp/login.jsp'
		}
	});
	$("#"+id).highcharts(json);


}