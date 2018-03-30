$(function() {
	$("#customer_manager").trigger("click");
	$("#customer_list >a").addClass("on");
	
	
	$(".page_go").click(function(){
		var page_index = $("#page_index_input").val();
		$("#current_pageNum").val(page_index);
		$("#condition_form").submit();
		
	});
	
	$("#but_next").click(function(){
		var pagenum = $("#current_pageNum").val();
		$("#current_pageNum").val( parseInt(pagenum) + 1);
		
		$("#condition_form").submit();
	});
	
	$("#but_prevent").click(function(){
		var pagenum = $("#current_pageNum").val();
		$("#current_pageNum").val( parseInt(pagenum) - 1);
		
		$("#condition_form").submit();
	});
	
});
    
  


