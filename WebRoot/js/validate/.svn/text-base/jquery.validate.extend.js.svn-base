/*
 * 扩展validate.js的验证。
 * 验证日期的大小和是否为字母
 */
$(function(){
	
	 	$.validator.addMethod("compareDate",function(value,element){
        		var beginDate = $("#beginDate").val();
        		var endDate = $("#endDate").val();
        		if(beginDate.length == 0 || endDate.length == 0){
        			return true;
        			 
	      		}else{
        		  	var da = beginDate.split("-");
        			var date1 = new Date(da[0],da[1]-1,da[2]);
        			var dat1 = date1.getTime();
				 	var d = endDate.split("-");
					var date2 = new Date(d[0],d[1]-1,d[2]);
					var dat2 = date2.getTime();
        			return dat1<dat2;
        		}
       			 },"后个日期必须大于前个日期");
	 
	 		jQuery.validator.addMethod("validateSpell", function(value, element) { 
  							var spell = /^([a-zA-Z]){0,30}$/;    
  							return this.optional(element) || (spell.test(value));    
						}, "拼音必须为字母形式"); 
	 		
	 		
	 		$.validator.addMethod("validateDate",function(value,element){
	 			var beginDate = $("#modifiedDateString").val();
	 			var endDate = $("#beginDate").val();
	 		 
	 			var da = beginDate.split("-");
        		var date1 = new Date(da[0],da[1]-1,da[2]);
        		var dat1 = date1.getTime();
			    var d = endDate.split("-");
				var date2 = new Date(d[0],d[1]-1,d[2]);
				var dat2 = date2.getTime();
				return dat1<dat2;
	 			},"本次入库时间必须大于上次修改时间");
	 		
	 		$.validator.addMethod("validateSysDate",function(value,element){
	 			var validateDate = $("#validDateString").val();
	 			var da = validateDate.split("-");
	 			var date1 = new Date(da[0],da[1]-1,da[2]);
	 			var sysDate = new Date();
	 			var dat = date1.getTime();
	 			var sysDate1 = sysDate.getTime();
	 			return sysDate1<dat
	 			
	 		},"有效时间必须大于当前时间");
	 		
	 		$.validator.addMethod("phoneNo",function(value,element,params){

			  if(value.length != 11){
			
			  	return false;
			
			  }
			
			 return true;
			
			},"手机号为11位数字");
			
			$.validator.addMethod("compare",function(value,element,params){
			 	var minThreshold = $("#minThreshold").val();
			 	// 如果上限值小于下限值则返回false
			 	if(Number(value) <= Number(minThreshold)){
			 		return false;
			 	}
			 return true;
			
			},"上限不能小于下限");
			
			// 验证时间各式各样为 HH:mm:ss
			$.validator.addMethod("informtime",function(value,element,params){
				var sReTime = /^(([0|1][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$/;
				if(sReTime.test(value))return true;
			 	return false;
			
			},"时间格式不正确");
			
			$.validator.addMethod("notNull",function(value,element,params){
				if(value == null || value == ''){
					
 					$(element).attr("style","border: 2px solid red;")
 					return false;
				}
				$(element).attr("style","")
				 return true;
			
			
		},"");
			
			$.validator.addMethod("min",function(value,element,params){
				if(value !=null && value.length < params){
					$(element).attr("style","border: 2px solid red;")
 					return false;
				}
				$(element).attr("style","")
				 return true;
			
			
		},"");
			
			$.validator.addMethod("max",function(value,element,params){
				if(value !=null && value.length > params){
					$(element).attr("style","border: 2px solid red;")
 					return false;
				}
				$(element).attr("style","")
				 return true;
			
			
		},"");
			
		$.validator.addMethod("Number",function(value,element,params){
				var res = /^[0-9]*$/;
				if(!res.test(value)){
					$(element).attr("style","border: 2px solid red;")
 					return false;
				}
				$(element).attr("style","")
				 return true;
			
			
		},"");
});