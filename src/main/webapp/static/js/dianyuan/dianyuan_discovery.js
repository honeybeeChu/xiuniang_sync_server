$(function() {
	$("#dianyuan_02").addClass("on");
	// 绘制店铺占比
	initDianpuChart();
	// 绘制员工男女比例
	initDianyuanGender();
});

// 绘制店铺占比
function initDianpuChart() {
	var myChart = echarts.init(document.getElementById("chart1"));
	option = {
		title : {
			text : '店铺员工数量占比',
			subtext : '店铺显示代码',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			show : false,
			orient : 'vertical',
			left : 'left',
			data : [ 11, 22, 33 ]
		},
		series : [ {
			name : '员工数量',
			type : 'pie',
			radius : '65%',
			center : [ '50%', '55%' ],
			data : [ 11, 22, 33 ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	myChart.setOption(option);
}

// 绘制员工男女比例
function initDianyuanGender() {
	var myChart = echarts.init(document.getElementById("chart2"));
	var genderArray = [ 21, 22, 33, 44 ];
	option = {
		title : {
			text : '店铺员工性别占比',
			subtext : '男女店员数量',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			show : false,
			orient : 'vertical',
			left : 'left',
			data : [ "男", "女" ]
		},
		series : [ {
			name : '员工数量',
			type : 'pie',
			radius : '65%',
			center : [ '50%', '55%' ],
			data : [ {
				name : "男",
				value : 44,
				itemStyle : {
					normal : {
						color : 'blue',
					},
					emphasis : {
						color : 'blue'
					}
				}
			}, {
				name : "女",
				value : 55
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	myChart.setOption(option);
}