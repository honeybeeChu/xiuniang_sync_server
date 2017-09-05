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