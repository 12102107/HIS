/**
 * 去除字符之间的空格
 * @param str 要去除空格的字符串
 * @returns
 */
function zsyz_trim(str){
	for(var i=0;i<str.length;i++){
		if(str.charAt(i)===" "){
			continue;
		}else{
			str =str.substring(i,str.length);
			break;
		}
	}
	for(var i=str.length-1;i>=0;i--){
		if(str.charAt(i)===" "){
			continue;
		}else{
			str =str.substring(0,i+1);
			break;
		}
	}
	return str;
}

/**
 * 比较两个日期时间之间的大小(格式：1212-12-12 12:12:12)
 * @param startStr 开始日期时间
 * @param endStr 结束日期时间
 * @returns {Boolean} false，开始时间大于结束时间  true，开始时间小于结束时间
 */
function comptime(startStr, endStr) {
	var d1, d2, s, arr, arr1, arr2;
	if(startStr.length > 10){
		arr = startStr.split(" ");
		arr1 = arr[0].split("-");
		arr2 = arr[1].split(":");
		d1 = new Date(arr1[0], arr1[1] - 1, arr1[2], arr2[0], arr2[1], arr2[2]);
	} else{
		arr = startStr.split("-");
		d1 = new Date(arr[0], arr[1], arr[2]);
	}
	
	if(endStr.length > 10){
		arr = endStr.split(" ");
		arr1 = arr[0].split("-");
		arr2 = arr[1].split(":");
		d2 = new Date(arr1[0], arr1[1] - 1, arr1[2], arr2[0], arr2[1], arr2[2]);
	}else{
		arr = endStr.split("-");
		d2 = new Date(arr[0], arr[1], arr[2]);
	}
	 
	s = d2 - d1 ;
	if(s < 0){
		return false;
	}
	return true;
}

/**
 * 比较两个日期之间的大小(格式：12-12-12)
 * @param startTime 开始日期
 * @param endTime 结束日期
 * @returns 0，开始日期大于结束日期  1，开始日期小于结束日期  2，开始日期等于结束日期
 */
function validTime(startTime,endTime){
   var arr1 = startTime.split("-");
   var arr2 = endTime.split("-");
   var date1=new Date(parseInt(arr1[0]),parseInt(arr1[1])-1,parseInt(arr1[2]),0,0,0); 
   var date2=new Date(parseInt(arr2[0]),parseInt(arr2[1])-1,parseInt(arr2[2]),0,0,0);
     if(date1.getTime()>date2.getTime()) {                                
         return 0;
     }else if(date1.getTime()==date2.getTime()){
    	 return 2;
     }
     return 1;
}

/**
 * 比较两时间大小
 * @param startTime 开始时间
 * @param endTime 结束时间
 * @returns 0，开始时间大于结束时间  1，开始时间小于结束时间  2，开始时间等于结束时间
 */
function countTheTime(startTime, endTime){
	var leaveHourStart = startTime.split(":")[0]%(24*3600*1000);
	var leaveMinStart = startTime.split(":")[1]%(3600*1000);
	var leaveHourEnd = endTime.split(":")[0]%(24*3600*1000);
	var leaveMinEnd = endTime.split(":")[1]%(3600*1000);
	if(leaveHourStart > leaveHourEnd){
		return 0;
	}else if(leaveHourStart == leaveHourEnd){
		if(leaveMinStart > leaveMinEnd){
			return 0;
		}else if(leaveMinStart == leaveMinEnd){
			return 2;
		}
	}
	return 1;
}

/**
 * 计算指定日期为星期几
 * @param year 年份
 * @param month 月份
 * @param date 日子
 * @returns 
 */
function fngetday(year, month, date){
	var numberArray = ["日","一","二","三","四","五","六"];
	var keystr = "622503514624";
	var deltmonth = parseInt(keystr.substr(month - 1, 1));   
	var deltyear = (year - 2000) + Math.ceil((year - 2000) / 4);   
	deltyear += (year - Math.floor( year / 4) * 4 == 0 && month >2 ? 1:0);   
	var deltdate = date - 1;
	var weekDate = (deltmonth + deltyear + deltdate) - Math.floor((deltmonth + deltyear + deltdate) / 7) * 7;
	return numberArray[weekDate];
}

/**
 * 获取指定年的某月的天数
 * @param year 年份
 * @param month 月份
 * @returns 
 */
function monthsNumberDaysSpecifiedYear(year, month){
	var numberOfDays = new Date(year, month, 0).getDate();
	if(month == "2"){
		numberOfDays = numberOfDays + (year - Math.floor( year / 4) * 4 == 0 && month >2 ? 1:0);
	}
	return numberOfDays;
}

/**
 * 格式化日期：yyyy-MM-dd
 * @param date 要格式化的日期
 * @returns 
 */
function formatDate(date,monthNum){ 
	var myyear = date.getFullYear(); 
	var mymonth = date.getMonth() + monthNum; 
	var myweekday = date.getDate(); 
	if(mymonth < 10){ 
		mymonth = "0" + mymonth; 
	} 
	if(myweekday < 10){ 
		myweekday = "0" + myweekday; 
	} 
	return (myyear + "-" + mymonth + "-" + myweekday); 
}

function formatDateTime(date, format){
	Date.prototype.format = function(format){ 
		var o = { 
			"M+" : this.getMonth()+1, //month 
			"d+" : this.getDate(), //day 
			"h+" : this.getHours(), //hour 
			"m+" : this.getMinutes(), //minute 
			"s+" : this.getSeconds(), //second 
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
			"S" : this.getMilliseconds() //millisecond 
		} 

		if(/(y+)/.test(format)) { 
			format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		} 

		for(var k in o) { 
			if(new RegExp("("+ k +")").test(format)) { 
				format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
			} 
		} 
		return format; 
	} 
	date = new Date(date);
	var newDate = date.format(format);
	return newDate;
}