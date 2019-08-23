function saveTemplateData(){
	$("input[type='text'][alt='mb']").each(function(){
		$(this).attr("value",$(this).val());
	});
	
	$("input:checked").each(function(){
		$(this).attr("checked","checked");
	});
}

var len = $("input[type='text'][alt='mb']").length;
var count = 0;
window.onkeydown= function(e){
	  e = e || window.event;
	  if(e.keyCode == 9){
		 $("input[type='text'][alt='mb']").eq(count).focus();
		 if(count++ == len-1){
			 count = 0;
		 }
		 // 执行保存
	  }
}