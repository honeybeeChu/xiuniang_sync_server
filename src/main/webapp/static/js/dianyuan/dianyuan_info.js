$(function() {
	$("#dianyuan_01").addClass("on");
	
	//同步店员信息接口
	$("#sync_dianyuans").click(function(){
		$.ajax({
			type : 'get',
			url : project.ctxPath+"/dianyuan/sync_dianyuans.do",
			dataType : 'json',
			success : function(data) {
				if("success" == data){
					window.location.reload();
				}else{
					alert("更新失败请重试");
				}
			}
		});
	});
	
	
	$(".page_go").click(function(){
		var page_index = $("#page_index_input").val();
		var total_page_num = $("#page_index_input").attr("page-total");
		var search_name = $("#DYMC").val();
		if(page_index <= parseInt(total_page_num)){
			window.location.href=project.ctxPath + "/dianyuan/info.do?pageIndex=" + page_index + "&dymc=" + search_name;
		}else{
			window.location.href=project.ctxPath + "/dianyuan/info.do?pageIndex=" + total_page_num+ "&dymc=" + search_name;
		}
	});
	
	
});







