$(function() {
	$("#point_rules_set").click();
	$("#point_rules_01").addClass("on");
	$(".page_go").click(function(){
		var page_index = $("#page_index_input").val();
		var total_page_num = $("#page_index_input").attr("page-total");
		var search_name = $("#DYMC").val();
		if(page_index <= parseInt(total_page_num)){
			window.location.href=project.ctxPath + "/point_rules/init.do?pageIndex=" + page_index + "&dymc=" + search_name;
		}else{
			window.location.href=project.ctxPath + "/point_rules/init.do?pageIndex=" + total_page_num+ "&dymc=" + search_name;
		}
	});
	
    $('.edit').click(function(){
    	var id = $(this).parent().parent().find(".id").html();
    	window.location.href=project.ctxPath + "/point_rules/editInit.do?id=" + id;
    });
    
    $("#returnBtn").click(function(){
    	window.location.href=project.ctxPath + "/point_rules/init";
    });
});

function checksubmit()
{
	var name = $("#name").val();
	var rate = $("#rate").val();
	var discount = $("#discount").val();
	if($.trim(name) == '') {
		alert("等级名称输入不合法！")
		return false;
	}
	
	if (onceConsumption < 0 || onceConsumption > 99999999 || !isNaN(onceConsumption)) {
		alert("单次消费金额输入不合法！")
		return false;
	}
	
	if (tradeNum < 0 || tradeNum > 99999 || isNaN(tradeNumsss)) {
		alert("消费笔数输入不合法！")
		return false;
	}

	if (rate < 0 || isNaN(rate)) {
		alert("折扣比率输入不合法！")
		return false;
	}
	
	if (discount < 0 || discount > 1 || !isNaN(discount)) {
		alert("打折率输入不合法！")
		return false;
	}
	
	
	return true;
}
