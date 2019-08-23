/** 作者:于文涛
 *  版本:1.0
 *  日期:2015年11月12日  
 * 使用说明 : 在使用页面  声明 _settings对象 在里面声明 sure 和 active 注册自己的响应事件  sure active 可选
 * var _settings = {
		
			回车 或者 双击 响应事件  自己跟据需求改写  $(".success") 目标对象 里面包含选中的信息
		
			sure : function (){
				var obj = $(".success") ; 
				$("#name").val($.trim(obj.attr("name")));
				$("#rename").val($.trim(obj.attr("rename")));
				$("#price").val($.trim(obj.attr("price")));
				$("#typeName").val($.trim(obj.attr("typeName")));
				$("#typeCode").val($.trim(obj.attr("typeCode")));
			},
			// 额外添加自己的动作
			active:function(nextId){
				console.log("自定义active");
			}
		}
 * 
 */

$(function(){	
	
	$("#table tr:eq(1)").addClass("success");
	//setValBysearch($("#table tr:eq(1)"));
	$("#table tr:gt(0)").live("mousemove",function(e){
		var curId  = parseInt($.trim($(".success").attr("index"))) ;
		var nextId = parseInt($.trim($(this).attr("index")));
		if(nextId!=curId){
			active(nextId);
		}
	}).live("dblclick",function(e){
		if((typeof _settings) != "undefined"&&(typeof _settings.sure) != "undefined"&&(typeof _settings.click) == "undefined"){
			_settings.sure();
		}
		
	}).live("click",function(e){//单击  双击 只能选取一个
		if((typeof _settings) != "undefined"&&(typeof _settings.click) != "undefined"&&(typeof _settings.sure) == "undefined"){
			_settings.click();
		}
	});
	$(document).keydown(function(event){
		switch (event.keyCode) {
		case 38:
			upTr();
			break;
		case 40:
			downTr();
			break;
		case 38:
			upTr();
			break;
		case 13:
			if((typeof _settings) != "undefined"&&(typeof _settings.sure) != "undefined"){
				_settings.sure();
			}
			break;
		case 67:
			if(event.ctrlKey&&(typeof _settings) != "undefined"&&(typeof _settings.save) != "undefined"){
				_settings.save();
			}
			break;	
		default:
			break;
		}
	});
});

function upTr(){
	var firstTr = parseInt($.trim($("#table tr:eq(1)").attr("index")));
	var curId = parseInt($.trim($(".success").attr("index"))) ;
	var nextId = curId -1;
	if(nextId>=firstTr){
		active(nextId);
	}
}
function downTr(){
	var lastTr = parseInt($.trim($("#table tr:last").attr("index")));
	var curId =parseInt($.trim($(".success").attr("index"))) ;
	var nextId = curId+1;
	if(nextId<=lastTr){
		active(nextId);
	}
}

function active(nextId){
	$(".success").removeClass("success");
	$("#t"+nextId).addClass("success");
	if((typeof _settings) != "undefined"&&(typeof _settings.active) != "undefined"){
		_settings.active(nextId);
	}
}

document.oncontextmenu =function(){
	return false;
}
