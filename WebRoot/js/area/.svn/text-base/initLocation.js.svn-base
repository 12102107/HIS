/*
 * 改程序封装了GlobalProvinces_extend.js、GlobalProvinces_main.js两个文件中的对象和数组
 * 
 * @作者：邸洋
 * @创建日期：2015-11-24
 * 
 * 
 */
function initLocation(option)
{
	option = jQuery.extend({
		province:"province",		//省的网页ID
		city:"city",			//市的网页ID
		county:"county",		//县的网页ID
		town:"town",		//乡的网页ID
		province_val:"北京",		//默认省份
		city_val:"朝阳",			//默认地区
		county_val:"朝阳",		//默认县
		town_val:"安贞街道"		//默认乡镇
	},option||{});
	
	
	if(option.province_val == ""){
		option.province_val == "-1";
	}
		
	var gpm = new GlobalProvincesModule;



	gpm.def_province = ["请选择", -1];

	gpm.initProvince(document.getElementById(option.province));
	
	gpm.initCity1(document.getElementById(option.city), option.province_val);

	gpm.initCity2(document.getElementById(option.county), option.province_val, option.city_val);

	gpm.initCity3(document.getElementById(option.town), option.province_val, option.city_val, option.county_val);


	gpm.selectProvincesItem(document.getElementById(option.province), option.province_val);

	gpm.selectCity2Item(document.getElementById(option.county), option.county_val);

	gpm.selectCity1Item(document.getElementById(option.city), option.city_val);

	
	
	if(document.getElementById(option.town).options.length > 1){
		gpm.selectCity2Item(document.getElementById(option.town), option.town_val);
		document.getElementById(option.town).style.display ="inline";
		document.getElementById(option.town).style.display = "inline";
	}

	



	var onchgProv = function()
	{	
		gpm.initCity1(document.getElementById(option.city), gpm.getSelValue(document.getElementById(option.province)));
		gpm.initCity2(document.getElementById(option.county), '', '');		/* clear city2 select options*/
		gpm.initCity3(document.getElementById(option.town), '', '', '');
		$("#"+option.town).hide();
		
	}
	var onchgCity1 = function()
	{
		gpm.initCity2(document.getElementById(option.county), gpm.getSelValue(document.getElementById(option.province)), gpm.getSelValue(document.getElementById(option.city)));
		gpm.initCity3(document.getElementById(option.town), '', '', '');
		$("#"+option.town).hide();
		
	}

	var onchgStreet1 = function(){
		
		gpm.initCity3(document.getElementById(option.town), gpm.getSelValue(document.getElementById(option.province)), gpm.getSelValue(document.getElementById(option.city)), gpm.getSelValue(document.getElementById(option.county)));

		if($("#"+option.town).children().length > 1) {
				$("#"+option.town).show();
		} else {
				$("#"+option.town).hide();
		}
	}


	if(option.town_val == "") 
		$("#"+option.town).hide();
	$("#"+option.province).change(onchgProv);
	$("#"+option.city).change(onchgCity1);
	$("#"+option.county).change(onchgStreet1);
	
	



}