$(function() {
	$(".page_go").click(function(){
		var page_index = $("#page_index_input").val();
		var total_page_num = $("#page_index_input").attr("page-total");
		if(page_index <= parseInt(total_page_num)){
			window.location.href=project.ctxPath + "/customer/index.do?pageIndex=" + page_index;
		}else{
			window.location.href=project.ctxPath + "/customer/index.do?pageIndex=" + total_page_num;
		}
	});
});
    
  


