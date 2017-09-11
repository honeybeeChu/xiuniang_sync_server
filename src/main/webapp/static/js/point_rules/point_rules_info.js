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
    
    setConditions();
    
    $('#conditions').change(function(){ 
    	setConditions();
	});
});

function setConditions() {
	var conditions=$('#conditions').children('option:selected').val();
	if (conditions == '0') {
		$('#tr_1').removeClass('display_none');
		$('#tr_2').addClass('display_none');
		$('#tr_3').addClass('display_none');
	} else if (conditions == '1') {
		$('#tr_1').addClass('display_none');
		$('#tr_2').addClass('display_none');
		$('#tr_3').removeClass('display_none');
	} else if (conditions == '2' || conditions == '3') {
		$('#tr_1').removeClass('display_none');
		$('#tr_2').addClass('display_none');
		$('#tr_3').removeClass('display_none');
	} else if (conditions == '4') {
		$('#tr_1').addClass('display_none');
		$('#tr_2').removeClass('display_none');
		$('#tr_3').addClass('display_none');
	}
}

function checksubmit()
{
	var name = $("#name").val();
	var rate = $("#rate").val();
	var discount = $("#discount").val();
	var onceConsumption = $("#onceConsumption").val();
	var consumption = $("#consumption").val();
	var tradeNum = $("#tradeNum").val();
	if($.trim(name) == '') {
		alert("等级名称输入不合法！")
		return false;
	}
	
	if (consumption < 0 || consumption > 9999999999) {
		alert("消费累计金额输入不合法！")
		return false;
	} else if (isNaN(consumption)) {
		alert("消费累计金额输入不合法，请输入整数！")
		return false;
	}
	
	if (onceConsumption < 0 || onceConsumption > 99999999999) {
		alert("单次消费金额输入不合法！")
		return false;
	} else if (isNaN(onceConsumption)) {
		alert("单次消费金额输入不合法，请输入整数！")
		return false;
	}
	
	if (tradeNum < 0 || tradeNum > 99999) {
		alert("消费笔数输入不合法！")
		return false;
	} else if (isNaN(tradeNum)) {
		alert("消费笔数输入不合法，请输入整数！")
		return false;
	}

	if (!chkNum(rate) || rate < 0) {
		alert("积分兑换比例输入不合法！")
		return false;
	}
	
	if (!chkNum(discount) || discount < 0 || discount > 1) {
		alert("打折率输入不合法！")
		return false;
	}
	
	return true;
}


function chkNum(value) {
    var patrn = /^\d+(\.\d+)?$/;
    var result = true;
    if (!patrn.exec(value)) {
        result = false;
    }
    return result;
}
