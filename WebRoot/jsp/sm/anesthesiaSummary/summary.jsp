<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>麻醉总结</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
CreateReport("Report");
function printP() {
	Report.LoadFromURL("../jsp/sm/anesthesiaSummary/summary.grf");
	AjaxSyncLoadReportData(Report,"loadPrint.action?ylwsid="+$("#ylws").val());
	Report.PrintPreview(true);
}

function saveTemplateTo() {

	var w = screen.width;

	var h = screen.height;

	var arg = new Object();
	arg.win = window;
	window.showModalDialog("templateTo.action",arg,'help:no;dialogWidth=405px;dialogHeight=248px;dialogLeft='+w/3+';dialogTop='+h/2+';');

}

function saveTemplate(type,name) {
	$("#templateType").val(type);
	$("#templateName").val(name);
	$.post("saveSummaryTemplate.action",$("#summary").serialize(),function(){
			alert('保存成功！');
	});
}

function choseTemplate() {
	var w = screen.width;

	var h = screen.height;

	var arg = new Object();
	arg.win = window;
	window.showModalDialog("choseTemplateTo.action",arg,'help:no;dialogWidth=565px;dialogHeight=365px;dialogLeft='+w*1/5+';dialogTop='+h*1/3+';');
}

function setTemplateVal(id) {
	$.post("getTemplateVal.action",{templateId:id},function(data){
	
		if(data[0].intraspinal==1) {
			$('.intraspinal').attr('checked',true);
			$('#intraspinal').find(':input').attr("disabled",false);
		}
		$(".position[value='"+data[0].position+"']").attr('checked',true);
		$(".injectionResistance[value='"+data[0].injectionResistance+"']").attr('checked',true);
		$(".backflow[value='"+data[0].backflow+"']").attr('checked',true);
		$(".puncturePoint1Address").val(data[0].puncturePoint1Address);
		$(".puncturePoint1Location").val(data[0].puncturePoint1Location);
		$(".puncturePoint1Result[value='"+data[0].puncturePoint1Result+"']").attr('checked',true);
		$(".blood[value='"+data[0].blood+"']").attr('checked',true);
		$(".puncturePoint2Address").val(data[0].puncturePoint2Address);
		$(".puncturePoint2Location").val(data[0].puncturePoint2Location);
		$(".puncturePoint2Result[value='"+data[0].puncturePoint2Result+"']").attr('checked',true);
		$(".skinDepth").val(data[0].skinDepth);
		$(".catheterDepth").val(data[0].catheterDepth);
		$(".punctureMethod[value='"+data[0].punctureMethod+"']").attr('checked',true);
		$(".catheterizationSituation[value='"+data[0].catheterizationSituation+"']").attr('checked',true);
		$(".reason").val(data[0].reason);
		$(".ligamentaFlavaFeeli[value='"+data[0].ligamentaFlavaFeeli+"']").attr('checked',true);
		$(".anesthesiaLevelStartUp").val(data[0].anesthesiaLevelStartUp);
		$(".anesthesiaLevelStartDown").val(data[0].anesthesiaLevelStartDown);
		$(".vacuum[value='"+data[0].vacuum+"']").attr('checked',true);
		$(".pulsate[value='"+data[0].pulsate+"']").attr('checked',true);
		$(".anesthesiaLevelEndDown").val(data[0].anesthesiaLevelEndDown);
		
		if(data[0].generalAnesthesia==1) {
			$('.generalAnesthesia').attr('checked',true);
			$('#generalAnesthesia').find(':input').attr("disabled",false);
		}
		$(".orotracheal[value='"+data[0].orotracheal+"']").attr('checked',true);
		$(".nasalIntubation[value='"+data[0].nasalIntubation+"']").attr('checked',true);
		$(".nasalIntubationLr[value='"+data[0].nasalIntubationLr+"']").attr('checked',true);
		$(".catheterId").val(data[0].catheterId);
		$(".anesthesiaInducementPeriod").each(function(){
			if(data[0].anesthesiaInducementPeriod.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$(".fiberscope[value='"+data[0].fiberscope+"']").attr('checked',true);
		$(".doubleLumen[value='"+data[0].doubleLumen+"']").attr('checked',true);
		$(".doubleLumenLr[value='"+data[0].doubleLumenLr+"']").attr('checked',true);
		$(".doubleLumenSituation").each(function(){
			if(data[0].doubleLumenSituation.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$(".inducingMethod[value='"+data[0].inducingMethod+"']").attr('checked',true);
		
		if(data[0].laryngealMaskAirway==1) {
			$('#laryngealMaskAirway').attr('checked',true);
			$('.laryngealMaskAirway').attr("disabled",false);
		} else {
			$('.laryngealMaskAirway').attr("disabled",true);
		}
		$('.laryngealMaskAirway').val(data[0].laryngealMaskAirwayType);
		$(".auxiliary").each(function(){
			if(data[0].auxiliary.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$('.generalAnesthesiaOther').val(data[0].generalAnesthesiaOther);
		
		if(data[0].nerveBlock==1) {
			$('.nerveBlock').attr('checked',true);
			$('#nerveBlock').find(':input').attr("disabled",false);
		}	
		$(".cervicalPlexusBlockLr").each(function(){
			if(data[0].cervicalPlexusBlockLr.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$('.cervicalPlexus').val(data[0].cervicalPlexus);
		$(".brachialPlexusBlock[value='"+data[0].brachialPlexusBlock+"']").attr('checked',true);
		$(".brachialPlexusBlockLr[value='"+data[0].brachialPlexusBlockLr+"']").attr('checked',true);
		$(".brachialPlexusBlockMethod").each(function(){
			if(data[0].brachialPlexusBlockMethod.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$(".lumbarPlexusBlock[value='"+data[0].lumbarPlexusBlock+"']").attr('checked',true);
		$(".lumbarPlexusBlockLr[value='"+data[0].lumbarPlexusBlockLr+"']").attr('checked',true);
		$(".sciaticNerveBlock[value='"+data[0].sciaticNerveBlock+"']").attr('checked',true);
		$(".sciaticNerveBlockLr[value='"+data[0].sciaticNerveBlockLr+"']").attr('checked',true);
		$(".femoralNerveBlock[value='"+data[0].femoralNerveBlock+"']").attr('checked',true);
		$(".femoralNerveBlockLr[value='"+data[0].femoralNerveBlockLr+"']").attr('checked',true);
		$(".continuousFemoral[value='"+data[0].continuousFemoral+"']").attr('checked',true);
		$(".continuousFemoralLr[value='"+data[0].continuousFemoralLr+"']").attr('checked',true);
		
		if(data[0].invasive==1) {
			$('.invasive').attr('checked',true);
			$('#invasive').find(':input').attr("disabled",false);
		}	
		$(".invasiveName[value='"+data[0].invasiveName+"']").attr('checked',true);
		$('.invasiveNameElse').val(data[0].invasiveNameElse);
		
		if(data[0].complication==1) {
			$('.complication').attr('checked',true);
			$('#complication').find(':input').attr("disabled",false);
		}
		$(".complicationName").each(function(){
			if(data[0].complicationName.indexOf($(this).val())>=0) {
				$(this).attr('checked',true);
			}
		});
		$('.complicationNameElse').val(data[0].complicationNameElse);
		
		if(data[0].adverseEvents==1) {
			$('.adverseEvents').attr('checked',true);
			$('#laryngospasm').attr("disabled",false);
			$('#oxygen').attr("disabled",false);
			$('#anesMachineCircuit').attr("disabled",false);
			$('#medications').attr("disabled",false);
			$('#ventilationInvalid').attr("disabled",false);
			$('#circulationAnomaly').attr("disabled",false);
			$('#anesMachine').attr("disabled",false);
			$('#localAnesthesia').attr("disabled",false);
			$('#improperVentilation').attr("disabled",false);
			$('#venousChannel').attr("disabled",false);
			$('#otherMachine').attr("disabled",false);
			$('#other').attr("disabled",false);
		}	
		if(data[0].laryngospasm==1) {
			$('#laryngospasm').attr('checked',true);
			$('.laryngospasm').attr("disabled",false);
			$(".laryngospasm").each(function(){
				if(data[0].laryngospasmContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
		} else {
			$('.complication').attr("disabled",true);
		}
		if(data[0].oxygen==1) {
			$('#oxygen').attr('checked',true);
			$('.oxygen').attr("disabled",false);
			$(".oxygen").each(function(){
				if(data[0].oxygenContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#oxygenElse').val(data[0].oxygenElse);
		} else {
			$('.oxygen').attr("disabled",true);
		}
		if(data[0].anesMachineCircuit==1) {
			$('#anesMachineCircuit').attr('checked',true);
			$('.anesMachineCircuit').attr("disabled",false);
			$(".anesMachineCircuit").each(function(){
				if(data[0].anesMachineCircuitContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#anesMachineCircuitElse').val(data[0].anesMachineCircuitElse);
		} else {
			$('.anesMachineCircuit').attr("disabled",true);
		}
		if(data[0].medications==1) {
			$('#medications').attr('checked',true);
			$('.medications').attr("disabled",false);
			$(".medications").each(function(){
				if(data[0].medicationsContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#medicationsElse').val(data[0].medicationsElse);
		} else {
			$('.medications').attr("disabled",true);
		}
		if(data[0].ventilationInvalid==1) {
			$('#ventilationInvalid').attr('checked',true);
			$('.ventilationInvalid').attr("disabled",false);
			$(".ventilationInvalid").each(function(){
				if(data[0].ventilationInvalidContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#ventilationInvalidElse').val(data[0].ventilationInvalidElse);
		} else {
			$('.ventilationInvalid').attr("disabled",true);
		}
		if(data[0].circulationAnomaly==1) {
			$('#circulationAnomaly').attr('checked',true);
			$('.circulationAnomaly').attr("disabled",false);
			$(".circulationAnomaly").each(function(){
				if(data[0].circulationAnomalyContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#circulationAnomalyElse').val(data[0].circulationAnomalyElse);
		} else {
			$('.circulationAnomaly').attr("disabled",true);
		}
		if(data[0].anesMachine==1) {
			$('#anesMachine').attr('checked',true);
			$('.anesMachine').attr("disabled",false);
			$(".anesMachine").each(function(){
				if(data[0].anesMachineContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#anesMachineElse').val(data[0].anesMachineElse);
		} else {
			$('.anesMachine').attr("disabled",true);
		}
		if(data[0].localAnesthesia==1) {
			$('#localAnesthesia').attr('checked',true);
			$('.localAnesthesia').attr("disabled",false);
			$(".localAnesthesia").each(function(){
				if(data[0].localAnesthesiaContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#localAnesthesiaElse').val(data[0].localAnesthesiaElse);
		} else {
			$('.localAnesthesia').attr("disabled",true);
		}
		if(data[0].improperVentilation==1) {
			$('#improperVentilation').attr('checked',true);
			$('.improperVentilation').attr("disabled",false);
			$(".improperVentilation").each(function(){
				if(data[0].improperVentilationContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
		} else {
			$('.improperVentilation').attr("disabled",true);
		}
		if(data[0].venousChannel==1) {
			$('#venousChannel').attr('checked',true);
			$('.venousChannel').attr("disabled",false);
			$(".venousChannel").each(function(){
				if(data[0].venousChannelContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
			$('#venousChannelElse').val(data[0].venousChannelElse);
		} else {
			$('.venousChannel').attr("disabled",true);
		}
		if(data[0].otherMachine==1) {
			$('#otherMachine').attr('checked',true);
			$('.otherMachine').attr("disabled",false);
			$(".otherMachine").each(function(){
				if(data[0].otherMachineContent.indexOf($(this).val())>=0) {
					$(this).attr('checked',true);
				}
			});
		} else {
			$('.otherMachine').attr("disabled",true);
		} 
		if(data[0].other==1) {
			$('#other').attr('checked',true);
			$('.other').attr("disabled",false);
			$(".other").val(data[0].otherContent);
		} else {
			$('.other').attr("disabled",true);
		}
		
		$(".anaesthesiaMethod[value='"+data[0].anaesthesiaMethod+"']").attr('checked',true);
		$(".summary").val(data[0].summary);
		
	},'json');
}

function saveP() {
	$.post("saveSummary.action",$("#summary").serialize(),function(){
		alert('保存成功！');
	});
	
}

function back() {
	window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
}


$(function(){
	if($('.intraspinal').attr('checked')) {
		$('#intraspinal').find(':input').attr("disabled",false);
	} else {
		$('#intraspinal').find(':input').attr("disabled",true);
		$('.intraspinal').attr("disabled",false);
	}
	$('.intraspinal').click(function(){
		if($('.intraspinal').attr('checked')) {
			$('#intraspinal').find(':input').attr("disabled",false);
		} else {
			$('#intraspinal').find(':input').attr("disabled",true);
			$('.intraspinal').attr("disabled",false);
		}
	});

	if($('.generalAnesthesia').attr('checked')) {
		$('#generalAnesthesia').find(':input').attr("disabled",false);
		$('.laryngealMaskAirway').attr("disabled",true);
	} else {
		$('#generalAnesthesia').find(':input').attr("disabled",true);
		$('.generalAnesthesia').attr("disabled",false);
	}
	$('.generalAnesthesia').click(function(){
		if($('.generalAnesthesia').attr('checked')) {
			$('#generalAnesthesia').find(':input').attr("disabled",false);
		} else {
			$('#generalAnesthesia').find(':input').attr("disabled",true);
			$('.generalAnesthesia').attr("disabled",false);
		}
		$('.laryngealMaskAirway').attr("disabled",true);
	});
	
	if($('.nerveBlock').attr('checked')) {
		$('#nerveBlock').find(':input').attr("disabled",false);
	} else {
		$('#nerveBlock').find(':input').attr("disabled",true);
		$('.nerveBlock').attr("disabled",false);
	}
	$('.nerveBlock').click(function(){
		if($('.nerveBlock').attr('checked')) {
			$('#nerveBlock').find(':input').attr("disabled",false);
		} else {
			$('#nerveBlock').find(':input').attr("disabled",true);
			$('.nerveBlock').attr("disabled",false);
		}
	});
	
	if($('.invasive').attr('checked')) {
		$('#invasive').find(':input').attr("disabled",false);
	} else {
		$('#invasive').find(':input').attr("disabled",true);
		$('.invasive').attr("disabled",false);
	}
	$('.invasive').click(function(){
		if($('.invasive').attr('checked')) {
			$('#invasive').find(':input').attr("disabled",false);
		} else {
			$('#invasive').find(':input').attr("disabled",true);
			$('.invasive').attr("disabled",false);
		}
	});
	
	if($('.complication').attr('checked')) {
		$('#complication').find(':input').attr("disabled",false);
	} else {
		$('#complication').find(':input').attr("disabled",true);
		$('.complication').attr("disabled",false);
	}
	$('.complication').click(function(){
		if($('.complication').attr('checked')) {
			$('#complication').find(':input').attr("disabled",false);
		} else {
			$('#complication').find(':input').attr("disabled",true);
			$('.complication').attr("disabled",false);
		}
	});
	
	if($('.adverseEvents').attr('checked')) {
		$('#laryngospasm').attr("disabled",false);
		$('#oxygen').attr("disabled",false);
		$('#anesMachineCircuit').attr("disabled",false);
		$('#medications').attr("disabled",false);
		$('#ventilationInvalid').attr("disabled",false);
		$('#circulationAnomaly').attr("disabled",false);
		$('#anesMachine').attr("disabled",false);
		$('#localAnesthesia').attr("disabled",false);
		$('#improperVentilation').attr("disabled",false);
		$('#venousChannel').attr("disabled",false);
		$('#otherMachine').attr("disabled",false);
		$('#other').attr("disabled",false);
	} else {
		$('#laryngospasm').attr("disabled",true);
		$('#oxygen').attr("disabled",true);
		$('#anesMachineCircuit').attr("disabled",true);
		$('#medications').attr("disabled",true);
		$('#ventilationInvalid').attr("disabled",true);
		$('#circulationAnomaly').attr("disabled",true);
		$('#anesMachine').attr("disabled",true);
		$('#localAnesthesia').attr("disabled",true);
		$('#improperVentilation').attr("disabled",true);
		$('#venousChannel').attr("disabled",true);
		$('#otherMachine').attr("disabled",true);
		$('#other').attr("disabled",true);
	}
	$('.adverseEvents').click(function(){
		if($('.adverseEvents').attr('checked')) {
		$('#laryngospasm').attr("disabled",false);
		$('#oxygen').attr("disabled",false);
		$('#anesMachineCircuit').attr("disabled",false);
		$('#medications').attr("disabled",false);
		$('#ventilationInvalid').attr("disabled",false);
		$('#circulationAnomaly').attr("disabled",false);
		$('#anesMachine').attr("disabled",false);
		$('#localAnesthesia').attr("disabled",false);
		$('#improperVentilation').attr("disabled",false);
		$('#venousChannel').attr("disabled",false);
		$('#otherMachine').attr("disabled",false);
		$('#other').attr("disabled",false);
	} else {
		$('#laryngospasm').attr("disabled",true);
		$('#oxygen').attr("disabled",true);
		$('#anesMachineCircuit').attr("disabled",true);
		$('#medications').attr("disabled",true);
		$('#ventilationInvalid').attr("disabled",true);
		$('#circulationAnomaly').attr("disabled",true);
		$('#anesMachine').attr("disabled",true);
		$('#localAnesthesia').attr("disabled",true);
		$('#improperVentilation').attr("disabled",true);
		$('#venousChannel').attr("disabled",true);
		$('#otherMachine').attr("disabled",true);
		$('#other').attr("disabled",true);
	}
	});
	
	if($('#laryngospasm').attr('checked')) {
		$('.laryngospasm').attr("disabled",false);
	} else {
		$('.laryngospasm').attr("disabled",true);
	}
	$('#laryngospasm').click(function(){
		if($('#laryngospasm').attr('checked')) {
			$('.laryngospasm').attr("disabled",false);
		} else {
			$('.laryngospasm').attr("disabled",true);
		}
	});
	
	if($('#oxygen').attr('checked')) {
		$('.oxygen').attr("disabled",false);
	} else {
		$('.oxygen').attr("disabled",true);
	}
	$('#oxygen').click(function(){
		if($('#oxygen').attr('checked')) {
			$('.oxygen').attr("disabled",false);
		} else {
			$('.oxygen').attr("disabled",true);
		}
	});
	
	if($('#anesMachineCircuit').attr('checked')) {
		$('.anesMachineCircuit').attr("disabled",false);
	} else {
		$('.anesMachineCircuit').attr("disabled",true);
	}
	$('#anesMachineCircuit').click(function(){
		if($('#anesMachineCircuit').attr('checked')) {
			$('.anesMachineCircuit').attr("disabled",false);
		} else {
			$('.anesMachineCircuit').attr("disabled",true);
		}
	});
	
	if($('#medications').attr('checked')) {
		$('.medications').attr("disabled",false);
	} else {
		$('.medications').attr("disabled",true);
	}
	$('#medications').click(function(){
		if($('#medications').attr('checked')) {
			$('.medications').attr("disabled",false);
		} else {
			$('.medications').attr("disabled",true);
		}
	});
	
	if($('#ventilationInvalid').attr('checked')) {
		$('.ventilationInvalid').attr("disabled",false);
	} else {
		$('.ventilationInvalid').attr("disabled",true);
	}
	$('#ventilationInvalid').click(function(){
		if($('#ventilationInvalid').attr('checked')) {
			$('.ventilationInvalid').attr("disabled",false);
		} else {
			$('.ventilationInvalid').attr("disabled",true);
		}
	}); 
	
	if($('#circulationAnomaly').attr('checked')) {
		$('.circulationAnomaly').attr("disabled",false);
	} else {
		$('.circulationAnomaly').attr("disabled",true);
	}
	$('#circulationAnomaly').click(function(){
		if($('#circulationAnomaly').attr('checked')) {
			$('.circulationAnomaly').attr("disabled",false);
		} else {
			$('.circulationAnomaly').attr("disabled",true);
		}
	}); 
	
	if($('#anesMachine').attr('checked')) {
		$('.anesMachine').attr("disabled",false);
	} else {
		$('.anesMachine').attr("disabled",true);
	}
	$('#anesMachine').click(function(){
		if($('#anesMachine').attr('checked')) {
			$('.anesMachine').attr("disabled",false);
		} else {
			$('.anesMachine').attr("disabled",true);
		}
	});
	
	if($('#localAnesthesia').attr('checked')) {
		$('.localAnesthesia').attr("disabled",false);
	} else {
		$('.localAnesthesia').attr("disabled",true);
	}
	$('#localAnesthesia').click(function(){
		if($('#localAnesthesia').attr('checked')) {
			$('.localAnesthesia').attr("disabled",false);
		} else {
			$('.localAnesthesia').attr("disabled",true);
		}
	});
	
	if($('#improperVentilation').attr('checked')) {
		$('.improperVentilation').attr("disabled",false);
	} else {
		$('.improperVentilation').attr("disabled",true);
	}
	$('#improperVentilation').click(function(){
		if($('#improperVentilation').attr('checked')) {
			$('.improperVentilation').attr("disabled",false);
		} else {
			$('.improperVentilation').attr("disabled",true);
		}
	});
	
	if($('#venousChannel').attr('checked')) {
		$('.venousChannel').attr("disabled",false);
	} else {
		$('.venousChannel').attr("disabled",true);
	}
	$('#venousChannel').click(function(){
		if($('#venousChannel').attr('checked')) {
			$('.venousChannel').attr("disabled",false);
		} else {
			$('.venousChannel').attr("disabled",true);
		}
	});
	
	if($('#otherMachine').attr('checked')) {
		$('.otherMachine').attr("disabled",false);
	} else {
		$('.otherMachine').attr("disabled",true);
	}
	$('#otherMachine').click(function(){
		if($('#otherMachine').attr('checked')) {
			$('.otherMachine').attr("disabled",false);
		} else {
			$('.otherMachine').attr("disabled",true);
		}
	});
	
	if($('#other').attr('checked')) {
		$('.other').attr("disabled",false);
	} else {
		$('.other').attr("disabled",true);
	}
	$('#other').click(function(){
		if($('#other').attr('checked')) {
			$('.other').attr("disabled",false);
		} else {
			$('.other').attr("disabled",true);
		}
	});
	
	
	if($('#laryngealMaskAirway').attr('checked')) {
		$('.laryngealMaskAirway').attr("disabled",false);
	} else {
		$('.laryngealMaskAirway').attr("disabled",true);
	}
	$('#laryngealMaskAirway').click(function(){
		if($('#laryngealMaskAirway').attr('checked')) {
			$('.laryngealMaskAirway').attr("disabled",false);
		} else {
			$('.laryngealMaskAirway').attr("disabled",true);
		}
	});
	
});

function check() {

}

</script>
<style type="text/css">

</style>
</head>
<body class="page-header-fixed">
<input id="functionid" type="hidden" value="${functionid }">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉总结</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choseTemplate()">读取模板</button>
						<form id="summary">
						<input id="ylws" type="hidden" name="summary.operationId" value="${ylwsid }">
						<input type="hidden" name="summary.id" value="${summary.id }">
						
						<input type="hidden" name="templateType" id="templateType">
						<input type="hidden" name="templateName" id="templateName">
						
						<table id="intraspinal" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="intraspinal"  type="checkbox" <c:if test="${summary.intraspinal eq '1'  }">checked</c:if> name="summary.intraspinal" value="1">椎管内麻醉操作
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									穿刺时病人体位&nbsp;
									<input class="position" type="radio" name="summary.position" value="坐" <c:if test="${summary.position eq '坐'  }">checked</c:if>>坐 
									<input class="position" type="radio" name="summary.position" value="右侧卧" <c:if test="${summary.position eq '右侧卧' }">checked</c:if>>右侧卧
									<input class="position" type="radio" name="summary.position" value="左侧卧" <c:if test="${summary.position eq '右侧卧' }">checked</c:if>>左侧卧 
									<input class="position" type="radio" name="summary.position" value="俯卧" <c:if test="${summary.position eq '俯卧' }">checked</c:if>>俯卧
								</td>
								<td style="text-align: left;padding-left: 10px;">
									注射阻力&nbsp;
									<input class="injectionResistance" type="radio" name="summary.injectionResistance" value="很松" <c:if test="${summary.injectionResistance eq '很松'  }">checked</c:if>>很松
									<input class="injectionResistance" type="radio" name="summary.injectionResistance" value="尚松" <c:if test="${summary.injectionResistance eq '尚松' }">checked</c:if>>尚松
									<input class="injectionResistance" type="radio" name="summary.injectionResistance" value="不松" <c:if test="${summary.injectionResistance eq '不松' }">checked</c:if>>不松 
								</td>
								<td style="text-align: left;padding-left: 10px;">
									回流&nbsp;
									<input class="backflow" type="radio" name="summary.backflow" value="多" <c:if test="${summary.backflow eq '多'  }">checked</c:if>>多
									<input class="backflow" type="radio" name="summary.backflow" value="少" <c:if test="${summary.backflow eq '少' }">checked</c:if>>少
									<input class="backflow" type="radio" name="summary.backflow" value="无" <c:if test="${summary.backflow eq '无' }">checked</c:if>>无 
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									穿刺点：
									第一点&nbsp;
									<select class="puncturePoint1Address" name="summary.puncturePoint1Address" style="width: 150px;">
										<option <c:if test="${summary.puncturePoint1Address eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>&nbsp;
									<select class="puncturePoint1Location" name="summary.puncturePoint1Location" style="width: 100px;">
										<option <c:if test="${summary.puncturePoint1Location eq 'L1-2' }">selected</c:if> value="L1-2">L1-2</option>
									</select>&nbsp;
									<input class="puncturePoint1Result" type="radio" name="summary.puncturePoint1Result" value="0" <c:if test="${summary.puncturePoint1Result eq '0'  }">checked</c:if>>成功
									<input class="puncturePoint1Result"type="radio" name="summary.puncturePoint1Result" value="1" <c:if test="${summary.puncturePoint1Result eq '1' }">checked</c:if>>失败
									<input class="puncturePoint1Result" type="radio" name="summary.puncturePoint1Result" value="2" <c:if test="${summary.puncturePoint1Result eq '2' }">checked</c:if>>穿破 
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									沾血&nbsp;
									<input class="blood" type="radio" name="summary.blood" value="无" <c:if test="${summary.blood eq '无'  }">checked</c:if>>无
									<input class="blood" type="radio" name="summary.blood" value="有" <c:if test="${summary.blood eq '有' }">checked</c:if>>有
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									穿刺点：
									第二点&nbsp;
									<select class="puncturePoint2Address" name="summary.puncturePoint2Address" style="width: 150px;">
										<option <c:if test="${summary.puncturePoint2Address eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>&nbsp;
									<select class="puncturePoint2Location" name="summary.puncturePoint2Location" style="width: 100px;">
										<option <c:if test="${summary.puncturePoint2Location eq 'L1-2' }">selected</c:if> value="L1-2">L1-2</option>
									</select>&nbsp;
									<input class="puncturePoint2Result" type="radio" name="summary.puncturePoint2Result" value="0" <c:if test="${summary.puncturePoint2Result eq '0'  }">checked</c:if>>成功
									<input class="puncturePoint2Result" type="radio" name="summary.puncturePoint2Result" value="1" <c:if test="${summary.puncturePoint2Result eq '1' }">checked</c:if>>失败
									<input class="puncturePoint2Result" type="radio" name="summary.puncturePoint2Result" value="2" <c:if test="${summary.puncturePoint2Result eq '2' }">checked</c:if>>穿破 
								</td>
								<td style="text-align: left;padding-left: 10px;">
									皮肤至硬膜外腔深度&nbsp;
									<input class="skinDepth" type="text" name="summary.skinDepth" value="${summary.skinDepth }" style="width: 50px;" maxlength="10">cm
								</td>
								<td style="text-align: left;padding-left: 10px;">
									导管插入深度&nbsp;
									<input class="catheterDepth" type="text" name="summary.catheterDepth" value="${summary.catheterDepth }" style="width: 50px;" maxlength="10">cm
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									穿刺方法&nbsp;
									<input class="punctureMethod" type="radio" name="summary.punctureMethod" value="直入法" <c:if test="${summary.punctureMethod eq '直入法'  }">checked</c:if>>直入法
									<input class="punctureMethod" type="radio" name="summary.punctureMethod" value="侧入法" <c:if test="${summary.punctureMethod eq '侧入法' }">checked</c:if>>侧入法
									<input class="punctureMethod" type="radio" name="summary.punctureMethod" value="斜面" <c:if test="${summary.punctureMethod eq '斜面' }">checked</c:if>>斜面 
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									导管插入情况&nbsp;
									<input class="catheterizationSituation" type="radio" name="summary.catheterizationSituation" value="0" <c:if test="${summary.catheterizationSituation eq '0'  }">checked</c:if>>顺利
									<input class="catheterizationSituation" type="radio" name="summary.catheterizationSituation" value="1" <c:if test="${summary.catheterizationSituation eq '1' }">checked</c:if>>不顺利
							&nbsp;&nbsp;&nbsp;
									原因&nbsp;
									<input class="reason" type="text" name="summary.reason" value="${summary.reason }" style="width: 250px;" maxlength="100">
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									黄韧带感觉&nbsp;
									<input class="ligamentaFlavaFeeli" type="radio" name="summary.ligamentaFlavaFeeli" value="明显" <c:if test="${summary.ligamentaFlavaFeeli eq '明显'  }">checked</c:if>>明显
									<input class="ligamentaFlavaFeeli" type="radio" name="summary.ligamentaFlavaFeeli" value="尚明显" <c:if test="${summary.ligamentaFlavaFeeli eq '尚明显' }">checked</c:if>>尚明显
									<input class="ligamentaFlavaFeeli" type="radio" name="summary.ligamentaFlavaFeeli" value="不明显 " <c:if test="${summary.ligamentaFlavaFeeli eq '不明显' }">checked</c:if>>不明显 
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									麻醉平面：&nbsp;手术始：&nbsp;上达&nbsp;
									<select class="anesthesiaLevelStartUp" name="summary.anesthesiaLevelStartUp" style="width: 150px;">
										<option <c:if test="${summary.anesthesiaLevelStartUp eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>&nbsp;
							&nbsp;&nbsp;&nbsp;
									下达&nbsp;
									<select class="anesthesiaLevelStartDown" name="summary.anesthesiaLevelStartDown" style="width: 150px;">
										<option <c:if test="${summary.anesthesiaLevelStartDown eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									负压&nbsp;
									<input class="vacuum" type="radio" name="summary.vacuum" value="大" <c:if test="${summary.vacuum eq '大'  }">checked</c:if>>大
									<input class="vacuum" type="radio" name="summary.vacuum" value="小" <c:if test="${summary.vacuum eq '小' }">checked</c:if>>小
									<input class="vacuum" type="radio" name="summary.vacuum" value="无" <c:if test="${summary.vacuum eq '无' }">checked</c:if>>无
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									 搏动&nbsp;
									<input class="pulsate" type="radio" name="summary.pulsate" value="大" <c:if test="${summary.pulsate eq '大'  }">checked</c:if>>大
									<input class="pulsate" type="radio" name="summary.pulsate" value="小" <c:if test="${summary.pulsate eq '小' }">checked</c:if>>小
									<input class="pulsate" type="radio" name="summary.pulsate" value="无" <c:if test="${summary.pulsate eq '无' }">checked</c:if>>无
									
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									麻醉平面：&nbsp;手术毕：&nbsp;上达&nbsp;
									<select class="anesthesiaLevelEndUp" name="summary.anesthesiaLevelEndUp" style="width: 150px;">
										<option <c:if test="${summary.anesthesiaLevelEndUp eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>&nbsp;
							&nbsp;&nbsp;&nbsp;
									下达&nbsp;
									<select class="anesthesiaLevelEndDown" name="summary.anesthesiaLevelEndDown" style="width: 150px;">
										<option <c:if test="${summary.anesthesiaLevelEndDown eq '腰椎间隙' }">selected</c:if> value="腰椎间隙">腰椎间隙</option>
									</select>
								</td>
							</tr>
						</table>	
						<table id="generalAnesthesia" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="generalAnesthesia" type="checkbox" <c:if test="${summary.generalAnesthesia eq '1'  }">checked</c:if> name="summary.generalAnesthesia" value="1">全麻操作
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									<input class="orotracheal" type="checkbox" name="summary.orotracheal" value="1" <c:if test="${summary.orotracheal eq '1'}">checked</c:if>>
									口插管&nbsp;
									<input class="nasalIntubation" type="checkbox" name="summary.nasalIntubation" value="1" <c:if test="${summary.nasalIntubation eq '1'}">checked</c:if>>
									鼻插管&nbsp;
									（
									<input class="nasalIntubationLr" type="radio" name="summary.nasalIntubationLr" value="0" <c:if test="${summary.nasalIntubationLr eq '0'  }">checked</c:if>>左
									<input class="nasalIntubationLr" type="radio" name="summary.nasalIntubationLr" value="1" <c:if test="${summary.nasalIntubationLr eq '1' }">checked</c:if>>右	
									）&nbsp;&nbsp;&nbsp;
									导管ID&nbsp;
									<input class="catheterId" type="text" name="summary.catheterId" value="${summary.catheterId }" style="width: 50px;" maxlength="50">
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									麻醉诱导期&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="满意" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'满意')}">checked</c:if>>
									满意&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="呛咳" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'呛咳')}">checked</c:if>>
									呛咳&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="发绀" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'发绀')}">checked</c:if>>
									发绀&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="呕吐" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'呕吐')}">checked</c:if>>
									呕吐&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="喉痉挛" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'喉痉挛')}">checked</c:if>>
									喉痉挛&nbsp;
									<input class="anesthesiaInducementPeriod" type="checkbox" name="summary.anesthesiaInducementPeriod" value="激动" <c:if test="${fn:contains(summary.anesthesiaInducementPeriod,'激动')}">checked</c:if>>
									激动&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									<input class="fiberscope" type="checkbox" name="summary.fiberscope" value="1" <c:if test="${summary.fiberscope eq '1'}">checked</c:if>>
									纤维镜&nbsp;
									<input class="doubleLumen" type="checkbox" name="summary.doubleLumen" value="1" <c:if test="${summary.doubleLumen eq '1'}">checked</c:if>>
									双腔管&nbsp;
									（
									<input class="doubleLumenLr" type="radio" name="summary.doubleLumenLr" value="0" <c:if test="${summary.doubleLumenLr eq '0'  }">checked</c:if>>左
									<input class="doubleLumenLr" type="radio" name="summary.doubleLumenLr" value="1" <c:if test="${summary.doubleLumenLr eq '1' }">checked</c:if>>右	
									）&nbsp;&nbsp;&nbsp;
									<input class="doubleLumenSituation" type="checkbox" name="summary.doubleLumenSituation" value="盲插" <c:if test="${fn:contains(summary.doubleLumenSituation,'盲插')}">checked</c:if>>
									盲插&nbsp;
									<input class="doubleLumenSituation" type="checkbox" name="summary.doubleLumenSituation" value="带管芯插" <c:if test="${fn:contains(summary.doubleLumenSituation,'带管芯插')}">checked</c:if>>
									带管芯插&nbsp;
									<input class="doubleLumenSituation" type="checkbox" name="summary.doubleLumenSituation" value="插管困难" <c:if test="${fn:contains(summary.doubleLumenSituation,'插管困难')}">checked</c:if>>
									插管困难&nbsp;
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									诱导方法&nbsp;
									<input class="inducingMethod" type="radio" name="summary.inducingMethod" value="0" <c:if test="${summary.inducingMethod eq '0'  }">checked</c:if>>快诱导
									<input class="inducingMethod" type="radio" name="summary.inducingMethod" value="1" <c:if test="${summary.inducingMethod eq '1' }">checked</c:if>>慢诱导
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input id="laryngealMaskAirway" type="checkbox" name="summary.laryngealMaskAirway" value="1" <c:if test="${summary.laryngealMaskAirway eq '1' }">checked</c:if>>
									喉罩&nbsp;
									<input class="laryngealMaskAirway" type="text" name="summary.laryngealMaskAirwayType" value="${summary.laryngealMaskAirwayType }" style="width: 50px;" maxlength="10">
									号
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									辅助&nbsp;
									<input class="auxiliary" type="checkbox" name="summary.auxiliary" value="纤维支气管镜" <c:if test="${fn:contains(summary.auxiliary,'纤维支气管镜')}">checked</c:if>>
									纤维支气管镜&nbsp;
									<input class="auxiliary" type="checkbox" name="summary.auxiliary" value="气管切开" <c:if test="${fn:contains(summary.auxiliary,'气管切开')}">checked</c:if>>
									气管切开&nbsp;
									<input class="auxiliary" type="checkbox" name="summary.auxiliary" value="困难喉镜" <c:if test="${fn:contains(summary.auxiliary,'困难喉镜')}">checked</c:if>>
									困难喉镜&nbsp;
									<input class="auxiliary" type="checkbox" name="summary.auxiliary" value="可视喉镜" <c:if test="${fn:contains(summary.auxiliary,'可视喉镜')}">checked</c:if>>
									可视喉镜&nbsp;
									<input class="auxiliary" type="checkbox" name="summary.auxiliary" value="光棒" <c:if test="${fn:contains(summary.auxiliary,'光棒')}">checked</c:if>>
									光棒&nbsp;
								</td>
								<td style="text-align: left;padding-left: 10px;">
									其他&nbsp;
									<input class="generalAnesthesiaOther" type="text" name="summary.generalAnesthesiaOther" value="${summary.generalAnesthesiaOther }" style="width: 250px;" maxlength="100">
								</td>
							</tr>
						</table>
						<table id="nerveBlock" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="nerveBlock" type="checkbox" <c:if test="${summary.nerveBlock eq '1'  }">checked</c:if> name="summary.nerveBlock" value="1">神经阻滞
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									<input class="cervicalPlexusBlock" type="checkbox" name="summary.cervicalPlexusBlock" value="1" <c:if test="${summary.cervicalPlexusBlock eq '1'}">checked</c:if>>
									颈丛神经阻滞：
									<input class="cervicalPlexusBlockLr" type="checkbox" name="summary.cervicalPlexusBlockLr" value="浅丛左" <c:if test="${fn:contains(summary.cervicalPlexusBlockLr,'浅丛左')}">checked</c:if>>
									浅丛左&nbsp;
									<input class="cervicalPlexusBlockLr" type="checkbox" name="summary.cervicalPlexusBlockLr" value="浅丛右" <c:if test="${fn:contains(summary.cervicalPlexusBlockLr,'浅丛右')}">checked</c:if>>
									浅丛右&nbsp;
									<input class="cervicalPlexusBlockLr" type="checkbox" name="summary.cervicalPlexusBlockLr" value="深丛左" <c:if test="${fn:contains(summary.cervicalPlexusBlockLr,'深丛左')}">checked</c:if>>
									深丛左&nbsp;
									<input class="cervicalPlexusBlockLr" type="checkbox" name="summary.cervicalPlexusBlockLr" value="深丛右" <c:if test="${fn:contains(summary.cervicalPlexusBlockLr,'深丛右')}">checked</c:if>>
									深丛右&nbsp;
									<select class="cervicalPlexus" name="summary.cervicalPlexus" style="width: 150px;">
										<option <c:if test="${summary.cervicalPlexus eq 'C1' }">selected</c:if> value="C1">C1</option>
										<option <c:if test="${summary.cervicalPlexus eq 'C2' }">selected</c:if> value="C2">C2</option>
										<option <c:if test="${summary.cervicalPlexus eq 'C3' }">selected</c:if> value="C3">C3</option>
										<option <c:if test="${summary.cervicalPlexus eq 'C4' }">selected</c:if> value="C4 ">C4</option>
									</select>&nbsp;
								</td>
								<td style="text-align: left;padding-left: 10px;" colspan="2">
									<input class="brachialPlexusBlock" type="checkbox" name="summary.brachialPlexusBlock" value="1" <c:if test="${summary.brachialPlexusBlock eq '1'}">checked</c:if>>
									臂丛神经阻滞：
									<input class="brachialPlexusBlockLr" type="radio" name="summary.brachialPlexusBlockLr" value="0" <c:if test="${summary.brachialPlexusBlockLr eq '0'  }">checked</c:if>>左
									<input class="brachialPlexusBlockLr" type="radio" name="summary.brachialPlexusBlockLr" value="1" <c:if test="${summary.brachialPlexusBlockLr eq '1' }">checked</c:if>>右
										
									<input class="brachialPlexusBlockMethod" type="checkbox" name="summary.brachialPlexusBlockMethod" value="肌间沟法" <c:if test="${fn:contains(summary.brachialPlexusBlockMethod,'肌间沟法')}">checked</c:if>>
									肌间沟法&nbsp;
									<input class="brachialPlexusBlockMethod" type="checkbox" name="summary.brachialPlexusBlockMethod" value="腋路法" <c:if test="${fn:contains(summary.brachialPlexusBlockMethod,'腋路法')}">checked</c:if>>
									腋路法&nbsp;
									<input class="brachialPlexusBlockMethod" type="checkbox" name="summary.brachialPlexusBlockMethod" value="锁骨上法" <c:if test="${fn:contains(summary.brachialPlexusBlockMethod,'锁骨上法')}">checked</c:if>>
									锁骨上法&nbsp;
									
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input class="lumbarPlexusBlock" type="checkbox" name="summary.lumbarPlexusBlock" value="1" <c:if test="${summary.lumbarPlexusBlock eq '1'}">checked</c:if>>
									腰丛神经阻滞：
									<input class="lumbarPlexusBlockLr" type="radio" name="summary.lumbarPlexusBlockLr" value="0" <c:if test="${summary.lumbarPlexusBlockLr eq '0'  }">checked</c:if>>左
									<input class="lumbarPlexusBlockLr" type="radio" name="summary.lumbarPlexusBlockLr" value="1" <c:if test="${summary.lumbarPlexusBlockLr eq '1' }">checked</c:if>>右
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
									<input class="sciaticNerveBlock" type="checkbox" name="summary.sciaticNerveBlock" value="1" <c:if test="${summary.sciaticNerveBlock eq '1'}">checked</c:if>>
									坐骨神经阻滞：
									<input class="sciaticNerveBlockLr" type="radio" name="summary.sciaticNerveBlockLr" value="0" <c:if test="${summary.sciaticNerveBlockLr eq '0'  }">checked</c:if>>左
									<input class="sciaticNerveBlockLr" type="radio" name="summary.sciaticNerveBlockLr" value="1" <c:if test="${summary.sciaticNerveBlockLr eq '1' }">checked</c:if>>右
									
									
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input class="femoralNerveBlock" type="checkbox" name="summary.femoralNerveBlock" value="1" <c:if test="${summary.femoralNerveBlock eq '1'}">checked</c:if>>
									股神经阻滞：
									<input class="femoralNerveBlockLr" type="radio" name="summary.femoralNerveBlockLr" value="0" <c:if test="${summary.femoralNerveBlockLr eq '0'  }">checked</c:if>>左
									<input class="femoralNerveBlockLr" type="radio" name="summary.femoralNerveBlockLr" value="1" <c:if test="${summary.femoralNerveBlockLr eq '1' }">checked</c:if>>右
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
									<input class="continuousFemoral" type="checkbox" name="summary.continuousFemoral" value="1" <c:if test="${summary.continuousFemoral eq '1'}">checked</c:if>>
									股外侧神经阻滞：
									<input class="continuousFemoralLr" type="radio" name="summary.continuousFemoralLr" value="0" <c:if test="${summary.continuousFemoralLr eq '0'  }">checked</c:if>>左
									<input class="continuousFemoralLr" type="radio" name="summary.continuousFemoralLr" value="1" <c:if test="${summary.continuousFemoralLr eq '1' }">checked</c:if>>右
									
									
								</td>
							</tr>
						</table>
						<table id="invasive" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="invasive" type="checkbox" <c:if test="${summary.invasive eq '1'  }">checked</c:if> name="summary.invasive" value="1">有创操作
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input class="invasiveName" type="checkbox" name="summary.invasiveName" value="动脉穿刺置管" <c:if test="${fn:contains(summary.invasiveName,'动脉穿刺置管')}">checked</c:if>>
									动脉穿刺置管&nbsp;
									<input class="invasiveName" type="checkbox" name="summary.invasiveName" value="深静脉穿刺置管" <c:if test="${fn:contains(summary.invasiveName,'深静脉穿刺置管')}">checked</c:if>>
									深静脉穿刺置管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他&nbsp;
									<input class="invasiveNameElse" type="text" name="summary.invasiveNameElse" value="${summary.invasiveNameElse }" style="width: 400px;" maxlength="100">
								</td>
							</tr>
						</table>
						<table id="complication" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="complication" type="checkbox" <c:if test="${summary.complication eq '1'  }">checked</c:if> name="summary.complication" value="1">麻醉并发症
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="牙齿损伤" <c:if test="${fn:contains(summary.complicationName,'牙齿损伤')}">checked</c:if>>
									牙齿损伤&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="舌下坠" <c:if test="${fn:contains(summary.complicationName,'舌下坠')}">checked</c:if>>
									舌下坠&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="气胸" <c:if test="${fn:contains(summary.complicationName,'气胸')}">checked</c:if>>
									气胸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="高血压" <c:if test="${fn:contains(summary.complicationName,'高血压')}">checked</c:if>>
									高血压&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="心跳骤停" <c:if test="${fn:contains(summary.complicationName,'心跳骤停')}">checked</c:if>>
									心跳骤停&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="喉返N阻滞" <c:if test="${fn:contains(summary.complicationName,'喉返N阻滞')}">checked</c:if>>
									喉返N阻滞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="全脊麻" <c:if test="${fn:contains(summary.complicationName,'全脊麻')}">checked</c:if>>
									全脊麻&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="黏膜损伤" <c:if test="${fn:contains(summary.complicationName,'黏膜损伤')}">checked</c:if>>
									黏膜损伤&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="支气管痉挛" <c:if test="${fn:contains(summary.complicationName,'支气管痉挛')}">checked</c:if>>
									支气管痉挛&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="缺氧" <c:if test="${fn:contains(summary.complicationName,'缺氧')}">checked</c:if>>
									缺氧&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="低血压" <c:if test="${fn:contains(summary.complicationName,'低血压')}">checked</c:if>>
									低血压&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="局麻药过敏" <c:if test="${fn:contains(summary.complicationName,'局麻药过敏')}">checked</c:if>>
									局麻药过敏&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="霍纳氏症" <c:if test="${fn:contains(summary.complicationName,'霍纳氏症')}">checked</c:if>>
									霍纳氏症&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="硬膜穿破" <c:if test="${fn:contains(summary.complicationName,'硬膜穿破')}">checked</c:if>>
									硬膜穿破&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="误吸" <c:if test="${fn:contains(summary.complicationName,'误吸')}">checked</c:if>>
									误吸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="急性肺水肿" <c:if test="${fn:contains(summary.complicationName,'急性肺水肿')}">checked</c:if>>
									急性水肿&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="CO2蓄积" <c:if test="${fn:contains(summary.complicationName,'CO2蓄积')}">checked</c:if>>
									CO2蓄积&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="心律失常" <c:if test="${fn:contains(summary.complicationName,'心律失常')}">checked</c:if>>
									心律失常&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="局麻药中毒" <c:if test="${fn:contains(summary.complicationName,'局麻药中毒')}">checked</c:if>>
									局麻药中毒&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="脊N广泛阻滞" <c:if test="${fn:contains(summary.complicationName,'脊N广泛阻滞')}">checked</c:if>>
									脊N广泛阻滞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="呕吐" <c:if test="${fn:contains(summary.complicationName,'呕吐')}">checked</c:if>>
									呕吐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="肺栓塞" <c:if test="${fn:contains(summary.complicationName,'肺栓塞')}">checked</c:if>>
									肺栓塞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="呼吸停止" <c:if test="${fn:contains(summary.complicationName,'呼吸停止')}">checked</c:if>>
									呼吸停止&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="心衰" <c:if test="${fn:contains(summary.complicationName,'心衰')}">checked</c:if>>
									心衰&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="膈N阻滞" <c:if test="${fn:contains(summary.complicationName,'膈N阻滞')}">checked</c:if>>
									膈N阻滞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="complicationName" type="checkbox" name="summary.complicationName" value="硬膜外导管折断" <c:if test="${fn:contains(summary.complicationName,'硬膜外导管折断')}">checked</c:if>>
									硬膜外导管折断&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他&nbsp;
									<input class="complicationNameElse" type="text" name="summary.complicationNameElse" value="${summary.complicationNameElse }" style="width: 400px;" maxlength="200">
								</td>
							</tr>
						</table>
						<table id="adverseEvents" class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input class="adverseEvents" type="checkbox" <c:if test="${summary.adverseEvents eq '1'  }">checked</c:if> name="summary.adverseEvents" value="1">手术不良事件
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input id="laryngospasm" type="checkbox" name="summary.laryngospasm" value="1" <c:if test="${summary.laryngospasm eq '1'  }">checked</c:if>>
									喉&nbsp;痉&nbsp;挛<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="laryngospasm" type="checkbox" name="summary.laryngospasmContent" value="正常气道" <c:if test="${fn:contains(summary.laryngospasmContent,'正常气道')}">checked</c:if>>
									正常气道<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="laryngospasm" type="checkbox" name="summary.laryngospasmContent" value="喉罩" <c:if test="${fn:contains(summary.laryngospasmContent,'喉罩')}">checked</c:if>>
									喉罩<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="laryngospasm" type="checkbox" name="summary.laryngospasmContent" value="气管内导管" <c:if test="${fn:contains(summary.laryngospasmContent,'气管内导管')}">checked</c:if>>
									气管内导管
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="oxygen" type="checkbox" name="summary.oxygen" value="1" <c:if test="${summary.oxygen eq '1'  }">checked</c:if>>
									氧&nbsp;合&nbsp;不&nbsp;当<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="oxygen" type="checkbox" name="summary.oxygenContent" value="前述的任何原因" <c:if test="${fn:contains(summary.oxygenContent,'前述的任何原因')}">checked</c:if>>
									前述的任何原因<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="oxygen" type="checkbox" name="summary.oxygenContent" value="支气管内插管" <c:if test="${fn:contains(summary.oxygenContent,'支气管内插管')}">checked</c:if>>
									支气管内插管<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="oxygen" type="checkbox" name="summary.oxygenContent" value="误吸" <c:if test="${fn:contains(summary.oxygenContent,'误吸')}">checked</c:if>>
									误吸<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="oxygen" type="checkbox" name="summary.oxygenContent" value="气胸" <c:if test="${fn:contains(summary.oxygenContent,'气胸')}">checked</c:if>>
									气胸<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他：
									<input class="oxygen" id="oxygenElse" type="text" name="summary.oxygenElse" value="${summary.oxygenElse }" style="width: 120px;" maxlength="100">
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="anesMachineCircuit" type="checkbox" name="summary.anesMachineCircuit" value="1" <c:if test="${summary.anesMachineCircuit eq '1'  }">checked</c:if>>
									麻&nbsp;醉&nbsp;机&nbsp;回&nbsp;路&nbsp;故&nbsp;障<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachineCircuit" type="checkbox" name="summary.anesMachineCircuitContent" value="CO2吸收" <c:if test="${fn:contains(summary.anesMachineCircuitContent,'CO2吸收')}">checked</c:if>>
									CO2吸收<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachineCircuit" type="checkbox" name="summary.anesMachineCircuitContent" value="单向活瓣" <c:if test="${fn:contains(summary.anesMachineCircuitContent,'单向活瓣')}">checked</c:if>>
									单向活瓣<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachineCircuit" type="checkbox" name="summary.anesMachineCircuitContent" value="T型管回路" <c:if test="${fn:contains(summary.anesMachineCircuitContent,'T型管回路')}">checked</c:if>>
									T型管回路<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									其他：
									<input class="anesMachineCircuit" id="anesMachineCircuitElse" type="text" name="summary.anesMachineCircuitElse" value="${summary.anesMachineCircuitElse }" style="width: 120px;" maxlength="100">
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="medications" type="checkbox" name="summary.medications" value="1" <c:if test="${summary.medications eq '1'  }">checked</c:if>>
									用&nbsp;药<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="medications" type="checkbox" name="summary.medicationsContent" value="用药错误" <c:if test="${fn:contains(summary.medicationsContent,'用药错误')}">checked</c:if>>
									用药错误<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="medications" type="checkbox" name="summary.medicationsContent" value="剂量错误" <c:if test="${fn:contains(summary.medicationsContent,'剂量错误')}">checked</c:if>>
									剂量错误<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="medications" type="checkbox" name="summary.medicationsContent" value="途经错误" <c:if test="${fn:contains(summary.medicationsContent,'途经错误')}">checked</c:if>>
									途经错误<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									其他：
									<input class="medications" id="medicationsElse" type="text" name="summary.medicationsElse" value="${summary.medicationsElse }" style="width: 120px;" maxlength="100">
									
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="ventilationInvalid" type="checkbox" name="summary.ventilationInvalid" value="1" <c:if test="${summary.ventilationInvalid eq '1'  }">checked</c:if>>
									通&nbsp;气&nbsp;无&nbsp;效<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="气管导管脱落" <c:if test="${fn:contains(summary.ventilationInvalidContent,'气管导管脱落')}">checked</c:if>>
									气管导管脱落<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="连接异常脱落" <c:if test="${fn:contains(summary.ventilationInvalidContent,'连接异常脱落')}">checked</c:if>>
									连接异常脱落<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="不当拔管" <c:if test="${fn:contains(summary.ventilationInvalidContent,'不当拔管')}">checked</c:if>>
									不当拔管<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="呼吸机故障" <c:if test="${fn:contains(summary.ventilationInvalidContent,'呼吸机故障')}">checked</c:if>>
									呼吸机故障<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="气管内导管阻塞" <c:if test="${fn:contains(summary.ventilationInvalidContent,'气管内导管阻塞')}">checked</c:if>>
									气管内导管阻塞<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<input class="ventilationInvalid" type="checkbox" name="summary.ventilationInvalidContent" value="食道插管" <c:if test="${fn:contains(summary.ventilationInvalidContent,'食道插管')}">checked</c:if>>
									食道插管<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									其他：
									<input class="ventilationInvalid" id="ventilationInvalidElse" type="text" name="summary.ventilationInvalidElse" value="${summary.ventilationInvalidElse }" style="width: 120px;" maxlength="100">
									
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="circulationAnomaly" type="checkbox" name="summary.circulationAnomaly" value="1" <c:if test="${summary.circulationAnomaly eq '1'  }">checked</c:if>>
									循&nbsp;环&nbsp;异&nbsp;常<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="circulationAnomaly" type="checkbox" name="summary.circulationAnomalyContent" value="心律失常" <c:if test="${fn:contains(summary.circulationAnomalyContent,'心律失常')}">checked</c:if>>
									心律失常<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="circulationAnomaly" type="checkbox" name="summary.circulationAnomalyContent" value="血压异常" <c:if test="${fn:contains(summary.circulationAnomalyContent,'血压异常')}">checked</c:if>>
									血压异常<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="circulationAnomaly" type="checkbox" name="summary.circulationAnomalyContent" value="心跳骤停" <c:if test="${fn:contains(summary.circulationAnomalyContent,'心跳骤停')}">checked</c:if>>
									心跳骤停<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									其他：
									<input class="circulationAnomaly" id="circulationAnomalyElse" type="text" name="summary.circulationAnomalyElse" value="${summary.circulationAnomalyElse }" style="width: 120px;" maxlength="100">
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<input id="anesMachine" type="checkbox" name="summary.anesMachine" value="1" <c:if test="${summary.anesMachine eq '1'  }">checked</c:if>>
									麻&nbsp;醉&nbsp;机<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachine" type="checkbox" name="summary.anesMachineContent" value="挥发罐" <c:if test="${fn:contains(summary.anesMachineContent,'挥发罐')}">checked</c:if>>
									挥发罐<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachine" type="checkbox" name="summary.anesMachineContent" value="监测部分" <c:if test="${fn:contains(summary.anesMachineContent,'监测部分')}">checked</c:if>>
									监测部分<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachine" type="checkbox" name="summary.anesMachineContent" value="供氧故障" <c:if test="${fn:contains(summary.anesMachineContent,'供氧故障')}">checked</c:if>>
									供氧故障<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="anesMachine" type="checkbox" name="summary.anesMachineContent" value="流量计" <c:if test="${fn:contains(summary.anesMachineContent,'流量计')}">checked</c:if>>
									流量计<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									其他：
									<input class="anesMachine" id="anesMachineElse" type="text" name="summary.anesMachineElse" value="${summary.anesMachineElse }" style="width: 120px;" maxlength="100">
								
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="localAnesthesia" type="checkbox" name="summary.localAnesthesia" value="1" <c:if test="${summary.localAnesthesia eq '1'  }">checked</c:if>>
									局&nbsp;麻&nbsp;技&nbsp;术<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="localAnesthesia" type="checkbox" name="summary.localAnesthesiaContent" value="周围神经阻滞" <c:if test="${fn:contains(summary.localAnesthesiaContent,'周围神经阻滞')}">checked</c:if>>
									周围神经阻滞<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="localAnesthesia" type="checkbox" name="summary.localAnesthesiaContent" value="骶管阻滞" <c:if test="${fn:contains(summary.localAnesthesiaContent,'骶管阻滞')}">checked</c:if>>
									骶管阻滞<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="localAnesthesia" type="checkbox" name="summary.localAnesthesiaContent" value="硬膜外阻滞" <c:if test="${fn:contains(summary.localAnesthesiaContent,'硬膜外阻滞')}">checked</c:if>>
									硬膜外阻滞<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他：
									<input class="localAnesthesia" id="localAnesthesiaElse" type="text" name="summary.localAnesthesiaElse" value="${summary.localAnesthesiaElse }" style="width: 120px;" maxlength="100">
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="improperVentilation" type="checkbox" name="summary.improperVentilation" value="1" <c:if test="${summary.improperVentilation eq '1'  }">checked</c:if>>
									不&nbsp;当&nbsp;通&nbsp;气<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="improperVentilation" type="checkbox" name="summary.improperVentilationContent" value="部分气道梗阻" <c:if test="${fn:contains(summary.improperVentilationContent,'部分气道梗阻')}">checked</c:if>>
									部分气道梗阻<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="improperVentilation" type="checkbox" name="summary.improperVentilationContent" value="麻醉药/其他药物所致" <c:if test="${fn:contains(summary.improperVentilationContent,'麻醉药/其他药物所致')}">checked</c:if>>
									麻醉药/其他药物所致<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="improperVentilation" type="checkbox" name="summary.improperVentilationContent" value="支气管痉挛" <c:if test="${fn:contains(summary.improperVentilationContent,'支气管痉挛')}">checked</c:if>>
									支气管痉挛
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="venousChannel" type="checkbox" name="summary.venousChannel" value="1" <c:if test="${summary.venousChannel eq '1'  }">checked</c:if>>
									静&nbsp;脉&nbsp;通&nbsp;路<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="venousChannel" type="checkbox" name="summary.venousChannelContent" value="周围神经阻滞" <c:if test="${fn:contains(summary.venousChannelContent,'周围神经阻滞')}">checked</c:if>>
									连接异常脱落<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他：
									<input class="venousChannel" id="venousChannelElse" type="text" name="summary.venousChannelElse" value="${summary.venousChannelElse }" style="width: 120px;" maxlength="100">
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="otherMachine" type="checkbox" name="summary.otherMachine" value="1" <c:if test="${summary.otherMachine eq '1'  }">checked</c:if>>
									其&nbsp;他&nbsp;设&nbsp;备<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="otherMachine" type="checkbox" name="summary.otherMachineContent" value="输液泵" <c:if test="${fn:contains(summary.otherMachineContent,'输液泵')}">checked</c:if>>
									输液泵<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="otherMachine" type="checkbox" name="summary.otherMachineContent" value="喉镜" <c:if test="${fn:contains(summary.otherMachineContent,'喉镜')}">checked</c:if>>
									喉镜<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="otherMachine" type="checkbox" name="summary.otherMachineContent" value="保暖措施" <c:if test="${fn:contains(summary.otherMachineContent,'保暖措施')}">checked</c:if>>
									保暖措施
								</td>
								<td style="text-align: left;padding-left: 10px;" >
									<input id="other" type="checkbox" name="summary.other" value="1" <c:if test="${summary.other eq '1'  }">checked</c:if>>
									其&nbsp;他<br>
									<textarea class="other" name="summary.otherContent" maxlength="200" style="width: 220px;height: 100px;resize: none;">${summary.otherContent }</textarea>
									
								</td>
							</tr>
						</table>
						<table class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								麻醉小结
								</td>
							</tr>
							</thead>
							<tr>
								<td style="text-align: left;padding-left: 10px;" >
									麻醉方法：
									<input class="anaesthesiaMethod" type="radio" name="summary.anaesthesiaMethod" value="全麻" <c:if test="${summary.anaesthesiaMethod eq '全麻'  }">checked</c:if>>全麻
									<input class="anaesthesiaMethod" type="radio" name="summary.anaesthesiaMethod" value="椎管内" <c:if test="${summary.anaesthesiaMethod eq '椎管内' }">checked</c:if>>椎管内
									<input class="anaesthesiaMethod" type="radio" name="summary.anaesthesiaMethod" value="神经丛" <c:if test="${summary.anaesthesiaMethod eq '神经丛' }">checked</c:if>>神经丛
									<input class="anaesthesiaMethod" type="radio" name="summary.anaesthesiaMethod" value="麻醉监测" <c:if test="${summary.anaesthesiaMethod eq '麻醉监测' }">checked</c:if>>麻醉监测
								</td>
							</tr>	
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;" >
									<textarea class="summary" name="summary.summary" maxlength="200" style="width: 1588px;height: 130px;resize: none;">${summary.summary }</textarea>
								</td>
							</tr>
						</table>
						</form>
						<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveTemplateTo()">存为模板</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveP()">保存</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printP()">打印</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
						</div>
					</div>
				</div>
			</div>
<br><br>
</body>
</html>
