//$(function() {
//	$("#member_ship_set").click();
//	$("#member_ship_01").addClass("on");
//	$(".page_go").click(function(){
//		var page_index = $("#page_index_input").val();
//		var total_page_num = $("#page_index_input").attr("page-total");
//		var search_name = $("#DYMC").val();
//		if(page_index <= parseInt(total_page_num)){
//			window.location.href=project.ctxPath + "/member_ship/init.do?pageIndex=" + page_index + "&dymc=" + search_name;
//		}else{
//			window.location.href=project.ctxPath + "/member_ship/init.do?pageIndex=" + total_page_num+ "&dymc=" + search_name;
//		}
//	});
//});


$(function() {
	
	var beginTimeTake;
    $('#trade-date-begin').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true,
        autoUpdateInput: false,
        timePicker24Hour : false,
        timePicker : false,
        "locale": {
            format: 'YYYY-MM-DD HH:mm',
            applyLabel: "应用",
            cancelLabel: "取消",
            resetLabel: "重置",
        }
    }, 
    function(start, end, label) {
        beginTimeTake = start;
        if(!this.startDate){
            this.element.val('');
        }else{
            this.element.val(this.startDate.format(this.locale.format));
        }
    });
    
    
//    
//	var beginTimeStore = '';
//    var endTimeStore = '';
//    $('#trade-date-begin').daterangepicker({
//        "timePicker": true,
//        "timePicker24Hour": true,
//        "linkedCalendars": false,
//        "autoUpdateInput": false,
//        "locale": {
//            format: 'YYYY-MM-DD',
//            separator: ' ~ ',
//            applyLabel: "应用",
//            cancelLabel: "取消",
//            resetLabel: "重置",
//        }
//    }, function(start, end, label) {
//        beginTimeStore = start;
//        endTimeStore = end;
//        console.log(this.startDate.format(this.locale.format));
//        console.log(this.endDate.format(this.locale.format));
//        if(!this.startDate){
//            this.element.val('');
//        }else{
//            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
//        }
//    });
	
	
	
});

    
  


