
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var localhostPaht = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var realPath = localhostPaht + projectName;

var interval;
var operationStarttime;
var inPutSpeed;
var mediSpeed;
var falg ;

$(function() {

	loadMedicationEventsGrid();
	loadInPutEventsGrid();
	loadOutPutEventsGrid();
	loadTracingPointGrid();
	getOutRoomStatus();
    loadData();
	/** -----------------------------描点相关方法开始------------------------------------------ */
	document.oncontextmenu = function(e) {
		e.preventDefault();
	};
	monitoringSignCanvas = document.getElementById('canvasCollect');
	monitoringSignContext = monitoringSignCanvas.getContext('2d');

	monitoringSignCanvas.onmousedown = function(e) {
		if (e.button == 0) {
			var rect = this.getBoundingClientRect();
			var mouseX = e.clientX - rect.left;
			var mouseY = e.clientY - rect.top;
			for ( var i = 0; i < hollowCircles.length; i++) {
				var hollowCirclesX = hollowCircles[i].hollowCircleX;
				var hollowCirclesY = hollowCircles[i].hollowCircleY;
				if (Math.pow(mouseX - hollowCirclesX, 2)
						+ Math.pow(mouseY - hollowCirclesY, 2) < Math.pow(5, 2)) {
					selectedHollowCircle = i;
					break;
				}
			}
			for ( var i = 0; i < solidCircles.length; i++) {
				var solidCirclesX = solidCircles[i].solidCircleX;
				var solidCirclesY = solidCircles[i].solidCircleY;
				if (Math.pow(mouseX - solidCirclesX, 2)
						+ Math.pow(mouseY - solidCirclesY, 2) < Math.pow(5, 2)) {
					selectedSolidCircle = i;
					break;
				}
			}
			for ( var i = 0; i < vDownTriangles.length; i++) {
				var vDownTrianglesX = vDownTriangles[i].vDownTriangleX;
				var vDownTrianglesY = vDownTriangles[i].vDownTriangleY;
				if (mouseX >= vDownTrianglesX && mouseX <= vDownTrianglesX + 10
						&& mouseY >= vDownTrianglesY
						&& mouseY <= vDownTrianglesY + 10) {
					selectedVDownTriangle = i;
					break;
				}
			}
			for ( var i = 0; i < vUpTriangles.length; i++) {
				var vUpTrianglesX = vUpTriangles[i].vUpTriangleX;
				var vUpTrianglesY = vUpTriangles[i].vUpTriangleY;
				if (mouseX >= vUpTrianglesX && mouseX <= vUpTrianglesX + 10
						&& mouseY >= vUpTrianglesY
						&& mouseY <= vUpTrianglesY + 10) {
					selectedVUpTriangle = i;
					break;
				}
			}
		}
	};

	monitoringSignCanvas.onmousemove = function(e) {
		var e = window.event || e;
		var rect = this.getBoundingClientRect();
		var mouseX = e.clientX - rect.left;
		var mouseY = e.clientY - rect.top;

		if (selectedHollowCircle != undefined) {
			var x = hollowCircles[selectedHollowCircle].hollowCircleX;
			var hollowCirColor = hollowCircles[selectedHollowCircle].hollowCircleColor;
			hollowCircles[selectedHollowCircle] = new HollowCircle(x, mouseY,
					hollowCirColor);
		}
		if (selectedSolidCircle != undefined) {
			var x = solidCircles[selectedSolidCircle].solidCircleX;
			var solidCirColor = solidCircles[selectedSolidCircle].solidCircleColor;
			solidCircles[selectedSolidCircle] = new SolidCircle(x, mouseY,
					solidCirColor);
		}
		if (selectedVDownTriangle != undefined) {
			var x = vDownTriangles[selectedVDownTriangle].vDownTriangleX;
			var vDownTriColor = vDownTriangles[selectedVDownTriangle].vDownTriangleColor;
			vDownTriangles[selectedVDownTriangle] = new VDownTriangle(x,
					mouseY, vDownTriColor);
		}
		if (selectedVUpTriangle != undefined) {
			var x = vUpTriangles[selectedVUpTriangle].vUpTriangleX;
			var vUpTriColor = vUpTriangles[selectedVUpTriangle].vUpTriangleColor;
			vUpTriangles[selectedVUpTriangle] = new VUpTriangle(x, mouseY,
					vUpTriColor);
		}
	};
	// 鼠标抬起事件
	monitoringSignCanvas.onmouseup = function(e) {
		selectedHollowCircle = undefined;
		selectedSolidCircle = undefined;
		selectedVDownTriangle = undefined;
		selectedVUpTriangle = undefined;
	};
	setInterval(drawMonitoringSignGraph, 100);

	/** -----------------------------描点相关方法结束------------------------------------------ */

	/** -----------------------------出量相关方法开始------------------------------------------ */

	document.oncontextmenu = function(e) {
		e.preventDefault();
	};
	outPutCanvas = document.getElementById('canvasOutPut');
	outPutCtx = outPutCanvas.getContext('2d');
	outPutCanvas.onmousedown = function(e) {
		if (e.button == 0) {
			var rect = this.getBoundingClientRect();
			var mouseX = e.clientX - rect.left;
			var mouseY = e.clientY - rect.top;
			for ( var i = 0; i < outPutEvents.length; i++) {
				if (outPutEvents[i] != undefined) {
					var outPutEventX = outPutEvents[i].outPutX;
					var outPutEventY = outPutEvents[i].outPutY;
					var outPutEventH = outPutEvents[i].outPutHeight;
					if (mouseX >= outPutEventX - outPutEventH
							&& mouseX <= outPutEventX + outPutEventH
							&& mouseY >= outPutEventY - outPutEventH
							&& mouseY <= outPutEventY + outPutEventH) {
						outPutSelectedContinued = i;
						break;
					}
				}

			}
		}
	};
	outPutCanvas.onmousemove = function(e) {
		var e = window.event || e;
		var rect = this.getBoundingClientRect();
		var mouseX = e.clientX - rect.left;
		var mouseY = e.clientY - rect.top;

		if (outPutSelectedContinued != undefined) {
			var oOperationId = outPutEvents[outPutSelectedContinued].outPutOperationId;
			var oId = outPutEvents[outPutSelectedContinued].outPutId;
			var oName = outPutEvents[outPutSelectedContinued].outPutName;
			var oDosage = outPutEvents[outPutSelectedContinued].outPutDosage;
			var oDosageUnit = outPutEvents[outPutSelectedContinued].outPutDosageUnit;
			var oX = outPutEvents[outPutSelectedContinued].outPutX;
			var oY = outPutEvents[outPutSelectedContinued].outPutY;
			var oH = outPutEvents[outPutSelectedContinued].outPutHeight;
			var oP = outPutEvents[outPutSelectedContinued].outPutPoint;
			var oDId = outPutEvents[outPutSelectedContinued].outPutDataId;
			outPutEvents[outPutSelectedContinued] = new OutPutEvent(
					oOperationId, oId, oName, oDosage, oDosageUnit, mouseX, oY,
					oH, oP,oDId);
		}
	};
	// 鼠标抬起事件
	outPutCanvas.onmouseup = function(e) {
		outPutSelectedContinued = undefined;
	};
	setInterval(drawOutPutSpace, 100);
	/** -----------------------------出量相关方法结束------------------------------------------ */

	/** -----------------------------入量相关方法开始------------------------------------------ */

	document.oncontextmenu = function(e) {
		e.preventDefault();
	};
	inPutCanvas = document.getElementById('canvasInPut');
	inPutCtx = inPutCanvas.getContext('2d');
	inPutCanvas.onmousedown = function(e) {
		if (e.button == 0) {
			var rect = this.getBoundingClientRect();
			var mouseX = e.clientX - rect.left;
			var mouseY = e.clientY - rect.top;
			for ( var i = 0; i < inPutEvents.length; i++) {
				if (inPutEvents[i] != undefined) {
					var inPutEventStartX = inPutEvents[i].inPutStartX;
					var inPutEventStartY = inPutEvents[i].inPutStartY;
					var inPutEventEndX = inPutEvents[i].inPutEndX;
					var inPutEventEndY = inPutEvents[i].inPutEndY;
					var inPutEventH = inPutEvents[i].inPutHeight;
					if (mouseX >= inPutEventStartX - inPutEventH
							&& mouseX <= inPutEventStartX + inPutEventH
							&& mouseY >= inPutEventStartY - inPutEventH
							&& mouseY <= inPutEventStartY + inPutEventH) {
						inPutSelectedContinued = i;
						break;
					}
					if (mouseX >= inPutEventEndX - inPutEventH
							&& mouseX <= inPutEventEndX + inPutEventH
							&& mouseY >= inPutEventEndY - inPutEventH
							&& mouseY <= inPutEventEndY + inPutEventH) {
						inPutSelectedStopContinued = i;
						break;
					}
				}

			}
		}
	};
	inPutCanvas.onmousemove = function(e) {
		var e = window.event || e;
		var rect = this.getBoundingClientRect();
		var mouseX = e.clientX - rect.left;
		var mouseY = e.clientY - rect.top;

		if (inPutSelectedContinued != undefined) {
			var iOperationId = inPutEvents[inPutSelectedContinued].inPutOperationId;
			var iId = inPutEvents[inPutSelectedContinued].inPutId;
			var iName = inPutEvents[inPutSelectedContinued].inPutName;
			var iSpec = inPutEvents[inPutSelectedContinued].inPutSpec;
			var iFirm = inPutEvents[inPutSelectedContinued].inPutFirm;
			var iDosage = inPutEvents[inPutSelectedContinued].inPutDosage;
			var iDosageUnit = inPutEvents[inPutSelectedContinued].inPutDosageUnit;
			var iAmount = inPutEvents[inPutSelectedContinued].inPutAmount;
			var iPrice = inPutEvents[inPutSelectedContinued].inPutPrice;
			var iCharge = inPutEvents[inPutSelectedContinued].inPutCharge;
			var iSX = inPutEvents[inPutSelectedContinued].inPutStartX;
			var iSY = inPutEvents[inPutSelectedContinued].inPutStartY;
			var iEX = inPutEvents[inPutSelectedContinued].inPutEndX;
			var iEY = inPutEvents[inPutSelectedContinued].inPutEndY;
			var iH = inPutEvents[inPutSelectedContinued].inPutHeight;
			var inP = inPutEvents[inPutSelectedContinued].inPutPoint;
			var iEnd = inPutEvents[inPutSelectedContinued].inPutEnded;
			var iDId = inPutEvents[inPutSelectedContinued].inPutDataId;
			inPutEvents[inPutSelectedContinued] = new InPutEvent(iOperationId,
					iId, iName, iSpec, iFirm, iDosage, iDosageUnit, iAmount,
					iPrice, iCharge, mouseX, iSY, iEX, iEY, iH, inP, iEnd,iDId);
		}
		if (inPutSelectedStopContinued != undefined) {
			var iOperationId = inPutEvents[inPutSelectedStopContinued].inPutOperationId;
			var iId = inPutEvents[inPutSelectedStopContinued].inPutId;
			var iName = inPutEvents[inPutSelectedStopContinued].inPutName;
			var iSpec = inPutEvents[inPutSelectedStopContinued].inPutSpec;
			var iFirm = inPutEvents[inPutSelectedStopContinued].inPutFirm;
			var iDosage = inPutEvents[inPutSelectedStopContinued].inPutDosage;
			var iDosageUnit = inPutEvents[inPutSelectedStopContinued].inPutDosageUnit;
			var iAmount = inPutEvents[inPutSelectedStopContinued].inPutAmount;
			var iPrice = inPutEvents[inPutSelectedStopContinued].inPutPrice;
			var iCharge = inPutEvents[inPutSelectedStopContinued].inPutCharge;
			var iSX = inPutEvents[inPutSelectedStopContinued].inPutStartX;
			var iSY = inPutEvents[inPutSelectedStopContinued].inPutStartY;
			var iEX = inPutEvents[inPutSelectedStopContinued].inPutEndX;
			var iEY = inPutEvents[inPutSelectedStopContinued].inPutEndY;
			var iH = inPutEvents[inPutSelectedStopContinued].inPutHeight;
			var inP = inPutEvents[inPutSelectedStopContinued].inPutPoint;
			var iEnd = inPutEvents[inPutSelectedStopContinued].inPutEnded; 
			var iDId = inPutEvents[inPutSelectedStopContinued].inPutDataId;
			inPutEvents[inPutSelectedStopContinued] = new InPutEvent(
					iOperationId, iId, iName, iSpec, iFirm, iDosage,
					iDosageUnit, iAmount, iPrice, iCharge, iSX, iSY, mouseX,
					iEY, iH, inP, iEnd,iDId);
		}
	};

	// 鼠标抬起事件
	inPutCanvas.onmouseup = function(e) {
		inPutSelectedContinued = undefined;
		inPutSelectedStopContinued = undefined;
	};
	setInterval(drawInPutSpace, 100);

/** -----------------------------入量相关方法结束------------------------------------------ */
	
/** -----------------------------麻醉用药相关方法开始------------------------------------------ */
	document.oncontextmenu = function(e) {
		e.preventDefault();
	};
	medCanvas = document.getElementById('canvasMedication');
	medCtx = medCanvas.getContext('2d');
	medCanvas.onmousedown = function(e) {
		if (e.button == 0) {
			var rect = this.getBoundingClientRect();
			var mouseX = e.clientX - rect.left;
			var mouseY = e.clientY - rect.top;
			for ( var i = 0; i < medEvents.length; i++) {
				if (medEvents[i] != undefined) {
					var medEventStartX = medEvents[i].medStartX;
					var medEventStartY = medEvents[i].medStartY;
					var medEventEndX = medEvents[i].medEndX;
					var medEventEndY = medEvents[i].medEndY;
					var medEventH = medEvents[i].medHeight;
					if (mouseX >= medEventStartX - medEventH
							&& mouseX <= medEventStartX + medEventH
							&& mouseY >= medEventStartY - medEventH
							&& mouseY <= medEventStartY + medEventH) {
						medSelectedContinued = i;
						console.log('选中'+medSelectedContinued);
						break;
					}
					if (mouseX >= medEventEndX - medEventH
							&& mouseX <= medEventEndX + medEventH
							&& mouseY >= medEventEndY - medEventH
							&& mouseY <= medEventEndY + medEventH) {
						medSelectedStopContinued = i;
						break;
					}
				}

			}
		}else if(e.button ==2){
			var rect = this.getBoundingClientRect();
			var mouseX = e.clientX - rect.left;
			var mouseY = e.clientY - rect.top;
			for ( var i = 0; i < medEvents.length; i++) {
				if (medEvents[i] != undefined) {
					var medEventStartX = medEvents[i].medStartX;
					var medEventStartY = medEvents[i].medStartY;
					var medEventEndX = medEvents[i].medEndX;
					var medEventEndY = medEvents[i].medEndY;
					var medEventH = medEvents[i].medHeight;
					if (mouseX >= medEventStartX - medEventH
							&& mouseX <= medEventStartX + medEventH
							&& mouseY >= medEventStartY - medEventH
							&& mouseY <= medEventStartY + medEventH) {
						$("#medRightPopup").dialog("open");
						medSelectedContinued = i;
						
						break;
					}
				}

			}
		}
	};
	

		medCanvas.onmousemove = function(e) {
		var e = window.event || e;
		var rect = this.getBoundingClientRect();
		var mouseX = e.clientX - rect.left;
		var mouseY = e.clientY - rect.top;

		if (medSelectedContinued != undefined) {
			if (medEvents[medSelectedContinued] != undefined) {
				var meOperationId = medEvents[medSelectedContinued].medOperationId;
				var meId = medEvents[medSelectedContinued].medId;
				var meName = medEvents[medSelectedContinued].medName;
				var meSpec = medEvents[medSelectedContinued].medSpec;
				var meTakewayCode = medEvents[medSelectedContinued].medTakewayCode;
				var meIsContinued = medEvents[medSelectedContinued].medIsContinued;
				var meFirm = medEvents[medSelectedContinued].medFirm;
				var meDosage = medEvents[medSelectedContinued].medDosage;
				var meDosageUnit = medEvents[medSelectedContinued].medDosageUnit;
				var meAmount = medEvents[medSelectedContinued].medAmount;
				var meIsCharge = medEvents[medSelectedContinued].medIsCharge;
				var meThickness = medEvents[medSelectedContinued].medThickness;
				var meThicknessUnit = medEvents[medSelectedContinued].medThicknessUnit;
				var meSpeed = medEvents[medSelectedContinued].medSpeed;
				var meSpeedUnit = medEvents[medSelectedContinued].medSpeedUnit;
				var meReasonSelect = medEvents[medSelectedContinued].medReasonSelect;
				var meReason = medEvents[medSelectedContinued].medReason;
				var meStartX = medEvents[medSelectedContinued].medStartX;
				var meStartY = medEvents[medSelectedContinued].medStartY;
				var meEndX = medEvents[medSelectedContinued].medEndX;
				var meEndY = medEvents[medSelectedContinued].medEndY;
				var meHeight = medEvents[medSelectedContinued].medHeight;
				var mePoint = medEvents[medSelectedContinued].medPoint;
				var meIsEnded = medEvents[medSelectedContinued].medIsEnded;

				medEvents[medSelectedContinued] = new MedEvent(meOperationId,
						meId, meName, meSpec, meTakewayCode, meIsContinued,
						meFirm, meDosage, meDosageUnit, meAmount, meIsCharge,
						meThickness, meThicknessUnit, meSpeed, meSpeedUnit,
						meReasonSelect, meReason, mouseX, meStartY, meEndX,
						meEndY, meHeight, mePoint, meIsEnded);
			}
		}
		if (medSelectedStopContinued != undefined) {
			if (medEvents[medSelectedContinued] != undefined) {
				var meOperationId = medEvents[medSelectedStopContinued].medOperationId;
				var meId = medEvents[medSelectedStopContinued].medId;
				var meName = medEvents[medSelectedStopContinued].medName;
				var meSpec = medEvents[medSelectedStopContinued].medSpec;
				var meTakewayCode = medEvents[medSelectedStopContinued].medTakewayCode;
				var meIsContinued = medEvents[medSelectedStopContinued].medIsContinued;
				var meFirm = medEvents[medSelectedStopContinued].medFirm;
				var meDosage = medEvents[medSelectedStopContinued].medDosage;
				var meDosageUnit = medEvents[medSelectedStopContinued].medDosageUnit;
				var meAmount = medEvents[medSelectedStopContinued].medAmount;
				var meIsCharge = medEvents[medSelectedStopContinued].medIsCharge;
				var meThickness = medEvents[medSelectedStopContinued].medThickness;
				var meThicknessUnit = medEvents[medSelectedStopContinued].medThicknessUnit;
				var meSpeed = medEvents[medSelectedStopContinued].medSpeed;
				var meSpeedUnit = medEvents[medSelectedStopContinued].medSpeedUnit;
				var meReasonSelect = medEvents[medSelectedStopContinued].medReasonSelect;
				var meReason = medEvents[medSelectedStopContinued].medReason;
				var meStartX = medEvents[medSelectedStopContinued].medStartX;
				var meStartY = medEvents[medSelectedStopContinued].medStartY;
				var meEndX = medEvents[medSelectedStopContinued].medEndX;
				var meEndY = medEvents[medSelectedStopContinued].medEndY;
				var meHeight = medEvents[medSelectedStopContinued].medHeight;
				var mePoint = medEvents[medSelectedStopContinued].medPoint;
				var meIsEnded = medEvents[medSelectedStopContinued].medIsEnded;

				medEvents[medSelectedStopContinued] = new MedEvent(
						meOperationId, meId, meName, meSpec, meTakewayCode,
						meIsContinued, meFirm, meDosage, meDosageUnit,
						meAmount, meIsCharge, meThickness, meThicknessUnit,
						meSpeed, meSpeedUnit, meReasonSelect, meReason,
						meStartX, meStartY, mouseX, meEndY, meHeight, mePoint,
						meIsEnded);
			}
		}
	};
    
	// 鼠标抬起事件
	medCanvas.onmouseup = function(e) {
		medSelectedContinued = undefined;
		medSelectedStopContinued = undefined;
	};
	setInterval(drawMedSpace, 100);
	
	
	
	
	
	
	
	
	
	
	
/** -----------------------------麻醉用药相关方法结束------------------------------------------ */
	
/** -----------------------------麻醉事件相关方法结束------------------------------------------ */

	  document.oncontextmenu = function(e){
	      e.preventDefault();
	  };
	    anesthEventCanvas=document.getElementById("canvasOperationEvent");
	    anesthEventCtx=anesthEventCanvas.getContext("2d");
	    anesthEventCtx.lineWidth= 2;
	    anesthEventCtx.strokeStyle = bgColor;
	    anesthEventCtx.fillStyle = bgColor;
	    
	    anesthEventCanvas.onmousedown =function(e) {
	    	
	        if(e.button ==0){
	            var rect = this.getBoundingClientRect();
	            var mouseX =e.clientX - rect.left;
	            var mouseY =e.clientY - rect.top;
	            for (var i=0; i<anesthEventGraphs.length; i++) {
	            	if(anesthEventGraphs[i]!=undefined){
	            	var  anesthEventX = anesthEventGraphs[i].anesthEventX;
	            	var  anesthEventY = anesthEventGraphs[i].anesthEventY;
	            	var anesthEventName = anesthEventGraphs[i].eventName;
	                if (Math.pow(mouseX-anesthEventX,2) + Math.pow(mouseY-anesthEventY,2) < Math.pow(8,2)) {
	                    selectedAnesthEventGraph = i;
	                    break;
	                }
	            	}
	            }
	        }else if(e.button ==2){
	            //selectedAnesthEventGraph = undefined;
	            var rect = this.getBoundingClientRect();
	            var mouseX =e.clientX - rect.left;
	            var mouseY =e.clientY - rect.top;
	            for (var i=0; i<anesthEventGraphs.length; i++) {
	            	if(anesthEventGraphs[i]!=undefined){
	            	var anesthEventX = anesthEventGraphs[i].anesthEventX;
	            	var anesthEventY = anesthEventGraphs[i].anesthEventY;
	                if (Math.pow(mouseX-anesthEventX,2) + Math.pow(mouseY-anesthEventY,2) < Math.pow(8,2)) {
	                	$( "#anasRightPopup" ).dialog( "open" );
	                	selectedAnesthEventGraph = i;
	                	//selectedDeleteAnesthEventGraph = i;    
	                    break;
	                }
	            } 
	            }
	        }
	    };
	    //鼠标移动
	    anesthEventCanvas.onmousemove=function(e) {
	        var e = window.event || e;
	        var rect = this.getBoundingClientRect();
	        var mouseX =e.clientX - rect.left;
	        var mouseY =e.clientY - rect.top;

	        if (selectedAnesthEventGraph != undefined) {
	            var anesthEventX = anesthEventGraphs[selectedAnesthEventGraph].anesthEventX;
	            var anesthEventY = anesthEventGraphs[selectedAnesthEventGraph].anesthEventY;
	            var eventItemCode = anesthEventGraphs[selectedAnesthEventGraph].eventItemCode;
	            var graphElements = anesthEventGraphs[selectedAnesthEventGraph].graphElements;
	            var graphCode= anesthEventGraphs[selectedAnesthEventGraph].graphCode;
	            var eventText= anesthEventGraphs[selectedAnesthEventGraph].eventText;
	            var eventName= anesthEventGraphs[selectedAnesthEventGraph].eventName;
	            anesthEventGraphs[selectedAnesthEventGraph] = new AnesthEventGraph(mouseX,anesthEventY,eventItemCode,graphElements,graphCode,eventText,eventName);
	        }
	    };
	    //鼠标松开
	    anesthEventCanvas.onmouseup =function(e) {
	        selectedAnesthEventGraph = undefined;
	    };

	    setInterval(drawAnesthEventSpace, 100);
	
	
	
/** -----------------------------麻醉用药相关方法结束------------------------------------------ */

	// 开始按钮弹出框
	$("#startPopup").dialog({
		autoOpen : false,
		height : 320,
		width : 500,
		modal : true
	});
	$("#start").click(function() {
		$("#startPopup").dialog("open");
	});
	$("#startPopupStartButton")
			.click(
					function() {
						if ($('#operationStarttime').val()) {
							$("#startPopup").dialog("close");
							var ylwsId = $('#ylwsId').val();
							var operationId = $('#operationId').val();
							interval = $('#collectInterval').val();
							operationStarttime = $('#operationStarttime').val();
							$('#operationStartTimeTextId').val(operationStarttime);
							loadStartTime(operationId, interval,
									operationStarttime, '');
							loadTimeAxisTop(operationId, interval,
									operationStarttime, '');
							loadTimeAxisCenter(operationId, interval,
									operationStarttime, '');
							createAnaesRecord(ylwsId, operationId, interval,
									operationStarttime);
							inPutSpeed = (interval * 60 * 1000) / 15;
							setInterval(drawInPutLineMove, inPutSpeed);
							
							mediSpeed = (interval * 60 * 1000) / 15;
							setInterval(drawMedLineMove, mediSpeed);
							updateRegOptToStart() ;
							initAnesthEvent();
							startButtonNotUse(true,'LightSteelBlue');
							startRecordButtonNotUse(false,'#1CAAD1');
							falg = true;
							// alert(inPutSpeed);
							 //getVitalSign(ylwsId);
						} else {
							alert("请选择开始时间!");
						}
					});
	$("#startPopupCloseButton").click(function() {
		$("#startPopup").dialog("close");
	});

	// 结束按钮弹出框
	$("#endPopup").dialog({
		autoOpen : false,
		height : 280,
		width : 500,
		modal : true
	});
	$('#end').click(function() {
		$("#endPopup").dialog("open");
	});
	// 结束按钮弹出框返回按钮
	$("#endPopupCloseButton").click(function() {
		$("#endPopup").dialog("close");
	});

	// 麻醉人员弹出框
	$("#anesthesiaDoctorPopup").dialog({
		autoOpen : false,
		height : 460,
		width : 700,
		modal : true
	});
	$('#anesthesiaDoctor').dblclick(function() {
		if(falg){
			
		
		document.getElementById("anesthesiaDoctorNameList").innerHTML = '';
		$('#anesthesiaDoctorNameList').append("<option></option>");
		$("#anesthesiaDoctorPopup").dialog("open");
		getAnesthesiaDoctor();
		}
	});
	// 麻醉人员弹出框保存按钮
	$("#anesthesiaDoctorPopupAddButton").click(
			function() {
				var ylwsId = $('#ylwsId').val();
				var operationId = $('#operationId').val();
				if ($('#anesthesiaDoctorType').val() == 'anesthetist') {
					$('#anesthetist').text($('#anesthesiaDoctorNameList').find("option:selected").text());
					if ($('#anesthesiaDoctorNameList').find("option:selected").text()) {
						editAnesthesiaDoctor(ylwsId, 'anesthetist', $('#anesthesiaDoctorNameList').find("option:selected").text());
					} else {
						alert('请选择麻醉师');
					}

				}
				if ($('#anesthesiaDoctorType').val() == 'circuanesthetist') {
					$('#circuanesthetist').text($('#anesthesiaDoctorNameList').find("option:selected").text());
					editAnesthesiaDoctor(ylwsId, 'circuanesthetist', $('#anesthesiaDoctorNameList').find("option:selected").text());
				}
				if ($('#anesthesiaDoctorType').val() == 'anaesAssistant') {
					$('#anaesAssistant').text($('#anesthesiaDoctorNameList').find("option:selected").text());
					editAnesthesiaDoctor(ylwsId, 'anaesAssistant', $('#anesthesiaDoctorNameList').find("option:selected").text());
				}
				if ($('#anesthetist').text()) {
					$('#anesthesiaDoctor').val($('#anesthetist').text() + ' '+ $('#circuanesthetist').text() + ' '+ $('#anaesAssistant').text());
				}

			});
	// 麻醉人员弹出框返回按钮
	$("#anesthesiaDoctorPopupReturnButton").click(function() {
		$("#anesthesiaDoctorPopup").dialog("close");
		
	});

	// 手术人员弹出框
	$("#operationDoctorPopup").dialog({
		autoOpen : false,
		height : 400,
		width : 700,
		modal : true
	});
	$('#operationDoctor').dblclick(function() {
		if(falg){
			var oper = $('#operationDoctor').val();
			if(oper){
				var opers = oper.split(',');
				if(opers){
					if(opers.length==1){
						$('#operationDoctorMain').text(opers[0]);
					}
					if(opers.length==2){
						$('#operationDoctorMain').text(opers[0]);
						$('#operationDoctorOne').text(opers[1]);
					}
					if(opers.length==3){
						$('#operationDoctorMain').text(opers[0]);
						$('#operationDoctorOne').text(opers[1]);
						$('#operationDoctorTwo').text(opers[2]);
					}
				}
			}

			document.getElementById("operationDoctorList").innerHTML = '';
			$('#operationDoctorList').append("<option></option>");
			$("#operationDoctorPopup").dialog("open");
			getOperationDoctor();

		}
	});
	// 麻醉人员弹出框确定按钮
	$("#operationDoctorPopupSaveButton").click(function() {
		var ylwsId = $('#ylwsId').val();
		var operationId = $('#operationId').val();
		if ($('#operationDoctorType').val() == 'doctorMain') {
			$('#operationDoctorMain').text($('#operationDoctorList').find("option:selected").text());
			if ($('#operationDoctorList').find("option:selected").text()) {
				//editAnesthesiaDoctor(ylwsId, 'anesthetist', $('#anesthesiaDoctorNameList').find("option:selected").text());
			} else {
				alert('请选择手术医师');
			}
		}
		if ($('#operationDoctorType').val() == 'doctorOne') {
			if($('#operationDoctorList').find("option:selected").text()){
				$('#operationDoctorOne').text($('#operationDoctorList').find("option:selected").text());
			}else{
				if($('#operationDoctorTwo').text()){
					$('#operationDoctorOne').text($('#operationDoctorTwo').text());
					$('#operationDoctorTwo').text('');
				}else{
					$('#operationDoctorOne').text($('#operationDoctorList').find("option:selected").text());
				}
			}

		}
		if ($('#operationDoctorType').val() == 'doctorTwo') {
			if($('#operationDoctorOne').text()){
				$('#operationDoctorTwo').text($('#operationDoctorList').find("option:selected").text());
			}else{
				$('#operationDoctorOne').text($('#operationDoctorList').find("option:selected").text());
			}
			
		}
		
		if ($('#operationDoctorMain').text()) {
			var operDtor = $('#operationDoctorMain').text();
			if($('#operationDoctorOne').text()){
				operDtor+=','+$('#operationDoctorOne').text();
			}
			if($('#operationDoctorTwo').text()){
				operDtor+=','+$('#operationDoctorTwo').text();
			}
			$('#operationDoctor').val(operDtor);
			editOperationDoctor(ylwsId,operDtor);
		}
		

	});
	// 麻醉人员弹出框返回按钮
	$("#operationDoctorPopupReturnButton").click(function() {
		$("#operationDoctorPopup").dialog("close");

	});

	// 巡回护士弹出框
	$("#tourNursePopup").dialog({
		autoOpen : false,
		height : 340,
		width : 700,
		modal : true
	});
	$('#tourNurse').dblclick(function() {
		if(falg){
			document.getElementById("tourNurseList").innerHTML = '';
			$('#tourNurseList').append("<option></option>");
			$("#tourNursePopup").dialog("open");
			getTourNurse();
			
		}
	});
	// 巡回护士弹出框确定按钮
	$("#tourNursePopupAddButton").click(function() {
		var ylwsId = $('#ylwsId').val();
		var operationId = $('#operationId').val();
		if ($('#tourNurseType').val() == 'tourNurseO') {
			$('#tourNurseOne').text($('#tourNurseList').find("option:selected").text());
			if (!$('#tourNurseOne').text()) {
				if($('#tourNurseTwo').text()){
					$('#tourNurseOne').text($('#tourNurseTwo').text());
					$('#tourNurseTwo').text('');
				}else{
					alert('请选巡回护士');
				}
			}
			editTourNurse(ylwsId,'tourNurseO',$('#tourNurseOne').text());
		}
		if ($('#tourNurseType').val() == 'tourNurseT') {
			if($('#tourNurseOne').text()){
				$('#tourNurseTwo').text($('#tourNurseList').find("option:selected").text());
			}else{
				$('#tourNurseOne').text($('#tourNurseTwo').text());
			}
			editTourNurse(ylwsId,'tourNurseT',$('#tourNurseTwo').text());
		}
		if($('#tourNurseTwo').text()){
			$('#tourNurse').val($('#tourNurseOne').text()+' '+$('#tourNurseTwo').text());
		}
		
	});
	// 巡回护士弹出框返回按钮
	$("#tourNursePopupReturnButton").click(function() {
		$("#tourNursePopup").dialog("close");

	});

	// 器械护士弹出框
	$("#instrumentNursePopup").dialog({
		autoOpen : false,
		height : 340,
		width : 700,
		modal : true
	});
	$('#instrumentNurse').dblclick(function() {
		if(falg){
			document.getElementById("instrumentNurseList").innerHTML = '';
			$('#instrumentNurseList').append("<option></option>");
			$("#instrumentNursePopup").dialog("open");
			getInstrumentNurse();
			
		}
	});
	
	// 器械护士弹出框确定按钮
	$("#instrumentNursePopupAddButton").click(function() {
		var ylwsId = $('#ylwsId').val();
		var operationId = $('#operationId').val();
		if ($('#instrumentNurseType').val() == 'instrumentNurseO') {
			$('#instrumentNurseOne').text($('#instrumentNurseList').find("option:selected").text());
			if (!$('#instrumentNurseOne').text()) {
				if($('#instrumentNurseTwo').text()){
					$('#instrumentNurseOne').text($('#instrumentNurseTwo').text());
					$('#instrumentNurseTwo').text('');
				}else{
					alert('请选巡回护士');
				}
			}
			editInstrumentNurse(ylwsId,'instrumentNurseO',$('#instrumentNurseOne').text());
		}
		if ($('#instrumentNurseType').val() == 'instrumentNurseT') {
			if($('#instrumentNurseOne').text()){
				$('#instrumentNurseTwo').text($('#instrumentNurseList').find("option:selected").text());
			}else{
				$('#instrumentNurseOne').text($('#instrumentNurseTwo').text());
			}
			editInstrumentNurse(ylwsId,'instrumentNurseT',$('#instrumentNurseTwo').text());
		}
		if($('#instrumentNurseTwo').text()){
			$('#instrumentNurse').val($('#instrumentNurseOne').text()+' '+$('#instrumentNurseTwo').text());
		}
		
	});
	// 器械护士弹出框返回按钮
	$("#instrumentNursePopupReturnButton").click(function() {
		$("#instrumentNursePopup").dialog("close");

	});

	// 麻醉用药弹出框
	$("#anestheticAgentsPopup").dialog({
		autoOpen : false,
		height : 600,
		width : 1000,
		modal : true
	});
	$('.anestheticAgents').click(function() {
		if(falg){
			
			$("#anestheticAgentsPopup").dialog("open");
		}
	});
	// 麻醉用药弹出框返回按钮
	$("#anestheticAgentsPopupCloseButton").click(function() {
		$("#anestheticAgentsPopup").dialog("close");

	});

    $('#medicalIsContinued').click(function () {
        if ($(this).attr("checked")) {
            $('#medicineSpeed').attr("disabled",false);
            $('#medicineSpeedUnit').attr("disabled",false);
        }else{
        	 $('#medicineSpeed').attr("disabled",true);
             $('#medicineSpeedUnit').attr("disabled",true);
        }
    });
	
	
	
	$(".medicineNameClass").live("click", function() {
		var url = realPath + "/anesthesiaRecord/getMedicineById.action";
		var params = {
			medicineId : $(this).val()
		};
		$.post(url, params, function(data) {
			var json = data;
			var me = eval('(' + json + ')');
			$('#medicineID').val(me[0].id);
			$('#medicineName').val(me[0].name);
			$('#medicineSpec').val(me[0].spec);
			$('#medicineFirm').val(me[0].firm);
			$('#medicineDosage').val(me[0].dosage);
			$('#medicineDosageUnit').val(me[0].dosageUnit);
		});
	});

	
	
	
	// 手术事件弹出框
	$("#operationEventPopup").dialog({
		autoOpen : false,
		height : 600,
		width : 500,
		modal : true
	});
	  $('.operationEventTitleClass').live('click',function(event){
		  if(falg){
			  $("#operationEventPopupConfirmButton").show();
			  $("#operationEventPopup" ).dialog( "open" );
			  
		  }
	   });
	// 手术事件弹出框返回按钮
	$("#operationEventPopupCloseButton").click(function() {
		$("#operationEventTitle").val("");
			$("#operationEventContent").val("");
			$("#operationEventtime").val("");
		$("#operationEventPopup" ).dialog( "close" );
	});
	   $("#operationEventPopupConfirmButton").click(function(){
	   		if($("#operationEventTitle").val()=="") {
	   			alert("标题不能为空！");return false;
	   		}
	   		if($("#operationEventContent").val()=="") {
	   			alert("内容不能为空！");return false;
	   		}
	   		if($("#operationEventtime").val()=="") {
	   			alert("请选择时间！");return false;
	   		}
	   
	   		if($("#opEventId").val()) {
	   			$.post("modOperationEventItem.action",{
	   					title:$("#operationEventTitle").val(),
	   					content:$("#operationEventContent").val(),
	   					time:$("#operationEventtime").val(),
	   					id:$("#opEventId").val()
	   				},function(data){ 
	   					var d = ""+data[0].time.hours+":"+data[0].time.minutes;
		   				if(data[0].time.hours<10) {
		   					d = "0" + d;
		   				}
		   				var title = data[0].title;
	   					$("#operationEventItem tr").each(function(){
	   						if($(this).attr('lang')==$("#opEventId").val()) {
	   							$(this).find(".eventTitle").empty().html(title);
	   							$(this).find("td").eq(1).empty().html(d);
	   						}
	   					});
		
		   				$("#operationEventPopup" ).dialog( "close" );
		   				$("#operationEventTitle").val("");
	   					$("#operationEventContent").val("");
	   					$("#operationEventtime").val("");
	   					$("#opEventId").remove();
	   					alert("修改成功！");
		   		},'json'); 
	   		}
	   		else {
	   			$.post("addOperationEventItem.action",{
	   					title:$("#operationEventTitle").val(),
	   					content:$("#operationEventContent").val(),
	   					time:$("#operationEventtime").val(),
	   					operationId:$('#ylwsId').val()
	   				},function(data){ 
		   				var d = ""+data[0].time.hours+":"+data[0].time.minutes;
		   				if(data[0].time.hours<10) {
		   					d = "0" + d;
		   				}
		   		
		   				var str = "<tr lang=\""+data[0].id+"\">";
		   				str += "<td><a href=\"javascript:void(0)\" class=\"eventTitle\">"+data[0].title+"<a></td>";
		   				str += "<td>"+d+"</td>";
		   				str += "<td><a href=\"javascript:void(0)\" class=\"modTitle\">修改<a>&nbsp;&nbsp;";
		   				str += "<a href=\"javascript:void(0)\" class=\"delTitle\">删除<a></td>";
		   				str += "</tr>";
		   				$("#operationEventItem").append(str);
		   				$("#operationEventPopup" ).dialog( "close" );
		   				$("#operationEventTitle").val("");
	   					$("#operationEventContent").val("");
	   					$("#operationEventtime").val("");
	   					alert("添加成功！");
		   		},'json'); 
	   		}  		
	   });
	   
	   $(".eventTitle").live('click',function(event){
			var id = $(this).parent().parent().attr('lang');
	   		$.post("getOpEventById.action",{id:id},function(data){
	   			$("#operationEventTitle").val(data[0].title);
	   			$("#operationEventContent").val(data[0].content);
	   			$("#operationEventtime").val(data[0].time);
	   			
	   			$("#operationEventPopupConfirmButton").hide();
	   			$("#operationEventPopup").dialog( "open" );
	   		},'json');
	   		event.stopPropagation();
	   });
	   $(".modTitle").live('click',function(event){
	   		var id = $(this).parent().parent().attr('lang');
	   		$.post("getOpEventById.action",{id:id},function(data){
	   			$("#operationEventTitle").val(data[0].title);
	   			$("#operationEventContent").val(data[0].content);
	   			$("#operationEventtime").val(data[0].time);
	   			
	   			var str = "<input id=\"opEventId\" type=\"hidden\" value=\""+data[0].id+"\">";
	   			$("#operationEventPopup").append(str);
	   			$("#operationEventPopupConfirmButton").show();
	   			$("#operationEventPopup").dialog( "open" );
	   		},'json');
	   		event.stopPropagation();
	   });
	   $(".delTitle").live('click',function(event){
	   		var id = $(this).parent().parent().attr('lang');
	   		var tr = $(this).parent().parent();
	   		if(confirm("确定删除？")) {
	   			$.post("delOperationEventItem.action",{id:id},function(){
	   				alert("删除成功!");
	   				$(tr).remove();
	   			});
	   		}
	   		event.stopPropagation();
	   });
	// 呼吸事件弹出框
	$("#breathEventPopup").dialog({
		autoOpen : false,
		height : 410,
		width : 500,
		modal : true
	});
	$('.breathEventTitleClass').click(function() {
		if(falg){
			
			$("#breathEventPopup").dialog("open");
		}
	});
	// 呼吸事件弹出框返回按钮
	$("#breathEventPopupCloseButton").click(function() {
		$("#breathEventPopup").dialog("close");
	});
	
	   $("#breathEventPopupConfirmButton").click(function(){
	   			
	   		var breathFlag = "";
	   		$(".breathFlag").each(function(){
	   			if($(this).attr("checked")) {
	   				breathFlag = $(this).val();
	   			}
	   		}); 
	   		$.post("addBreathEvent.action",{
	   				operationId:$('#ylwsId').val(),
	   				breathFlag:breathFlag,
	   				time:$('#breathEventtime').val()
	   			},function(data){
	   			
	   				var d = ""+data[0].starttime.hours+":"+data[0].starttime.minutes;
		   			if(data[0].starttime.hours<10) {
		   				d = "0" + d;
		   			}
		   			var info = "";
		   			if(data[0].flag=="01") {
		   				info = "自主呼吸";
		   			}
		   			if(data[0].flag=="02") {
		   				info = "辅助呼吸";
		   			}
		   			if(data[0].flag=="03") {
		   				info = "控制呼吸";
		   			}
		   			
		   			var str = "<tr lang=\""+data[0].id+"\">";
		   			str += "<td>"+info+"</td>";
		   			str += "<td>"+d+"</td>";
		   			str += "<td><a href=\"javascript:void(0)\" class=\"delBreath\">删除<a></td>";
		   			str += "</tr>";
		   			$("#breathEventItem").append(str);
		   			$(".breathFlag").each(function(){
		   				$(this).attr("checked",false);
		   			});
	   				$("#breathEventtime").val("");
	   				alert("添加成功！");
	   			
	   		},'json'); 
	   });
	   $(".delBreath").live('click',function(event){
	   		var id = $(this).parent().parent().attr('lang');
	   		var tr = $(this).parent().parent();
	   		if(confirm("确定删除？")) {
	   			$.post("delBreathEventItem.action",{id:id},function(){
	   				alert("删除成功!");
	   				$(tr).remove();
	   			});
	   		}
	   		event.stopPropagation();
	   });
	   
	   
		//麻醉事件弹出框
	   $( "#anesthesiaEventPopup" ).dialog({ autoOpen: false,height:520,width:300,modal: true });
	   $('.anesEvent').click(function(){
		   if(falg){
		   $( "#anesthesiaEventPopup" ).dialog( "open" );
		   addAnesthEventTable();
		   }
	   });
	   

	   
	   
	// 液体出量弹出框
	$("#outputLiquidPopup").dialog({
		autoOpen : false,
		height : 600,
		width : 1000,
		modal : true
	});
	
		$('.outputLiquid').click(function() {
			if(falg){
			document.getElementById("outLiquid").innerHTML = '';
			getOutputLiquid();
			$("#outputLiquidPopup").dialog("open");
			addOutPutTable();
			}
		});



	// 液体出量弹出框返回按钮
	$("#outputLiquidPopupCloseButton").click(function() {
		$("#outputLiquidPopup").dialog("close");

	});
	// 点击出量名称动态赋值
	$(".output").live("click", function() {
		$('#outputLiquidName').val($(this).text());
		$('#outputLiquidID').val($(this).val());
	});

	// 液体入量弹出框
	$("#inputLiquidPopup").dialog({
		autoOpen : false,
		height : 650,
		width : 1000,
		modal : true
	});
	$('.inputLiquid').click(function() {
		if(falg){
		document.getElementById("inLiquid").innerHTML = '';
		$("#inputLiquidPopup").dialog("open");
		addInPutTable();
		}
	});
	// 液体入量弹出框返回按钮
	$("#inPutPopupCloseButton").click(function() {
		$("#inputLiquidPopup").dialog("close");

	});
	// 点击入量名称动态赋值 inputC
	$(".inputP").live("click", function() {
		document.getElementById("inLiquid").innerHTML = '';
		getInChildName($(this).val());

	});
	// 点击入量名称动态赋值 inputC
	$(".inputC").live("click", function() {
		var url = realPath + "/anesthesiaRecord/getInPutById.action";
		var params = {
			inPutId : $(this).val()
		};
		$.post(url, params, function(data) {
			var json = data;
			var inPu = eval('(' + json + ')');
			$('#inPutName').val(inPu[0].name);
			$('#inPutID').val(inPu[0].id);
			$('#inPutFirm').val(inPu[0].firm);
			$('#inPutSpec').val(inPu[0].spec);

		});
	});
	
	   //结束
   $( "#endPopupConfirmButton" ).click(function() {
	   var params = {operationId:$('#ylwsId').val(),operationEndtime:$('#operationEndtime').val()};
	   $.post( realPath+"/anesthesiaRecord/addStopTime.action", params);
	   updateRegOptToEnd();
	   setTimeout(saveRegOpt,200);
	   endButtonNotUse(true,'LightSteelBlue');
	   printButtonNotUse(false,'#1CAAD1');
	   
   });
	// 麻醉用药右键弹出框
	$("#medRightPopup").dialog({
		autoOpen : false,
		height : 200,
		width : 100,
		modal : true
	});


	$("#medPopupStopButton").click(function() {
		if(medSelectedContinued != undefined){
			stopMedEvent(medSelectedContinued);
			$("#medRightPopup").dialog("close");
			medSelectedContinued = undefined;
		}
		
	});
	$("#medPopupDeleteButton").click(function() {
		if(medSelectedContinued != undefined){
			deleteMedEvent(medSelectedContinued);
			deleteMedEvent1(medEvents[medSelectedContinued].medAmount);
			$("#medRightPopup").dialog("close");
			medSelectedContinued = undefined;
		}
	});
	
	//麻醉事件右键弹出框	
	$("#anasRightPopup").dialog({
		autoOpen : false,
		height : 200,
		width : 100,
		modal : true
	});
	$("#anasPopupDeleteButton").click(function() {
		if(selectedAnesthEventGraph != undefined){
			deleteAnesthEvent(selectedAnesthEventGraph);
			//deleteMedEvent1(medEvents[selectedAnesthEventGraph].medAmount);
			$("#anasRightPopup").dialog("close");
			selectedAnesthEventGraph = undefined;
		}
	});

});
// --------------------------------------------------------------------
/**
 * @Title: back 
 * @Description: 返回
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param 
 * @return void
 */	
function back() {
	window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
}

/**
 * @Title: start
 * @Description: 开始
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function start(interval, startTime) {

}

/**
 * @Title: loadStartTime
 * @Description: 加载开始时间
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadStartTime(operationId, interval, startTime, state) {
	var optStartTime = startTime.replace(/-/g, '/');
	var optStartTimes = new Date(optStartTime);
	var nowYear = optStartTimes.getFullYear();
	var nowMonth = optStartTimes.getMonth() + 1;
	var nowDay = optStartTimes.getDate();
	var nowHour = optStartTimes.getHours();
	var nowMin = optStartTimes.getMinutes() + 1;
	var nowSecond = optStartTimes.getSeconds() + 1;
	$('#nowDate').text(nowYear + '年 ' + nowMonth + '月 ' + nowDay + '日 ');
	$('#nowDate1').text(nowYear + '年 ' + nowMonth + '月 ' + nowDay + '日 ');

}

/**
 * @Title: loadStartTime
 * @Description: 加载顶部时间轴
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadTimeAxisTop(operationId, interval, startTime, state) {
	var optStartTime = startTime.replace(/-/g, "/");
	var optStartTimes = new Date(optStartTime);

	var div_canvasTop = document.getElementById("canvasTimeTop");
	var context_timeTop = div_canvasTop.getContext("2d");
	var wg_colsTop = div_canvasTop.width / 15;
	var cell_width = 90;

	for ( var col = 0; col <= wg_colsTop; col++) {
		var x = col * cell_width;
		context_timeTop.beginPath();
		context_timeTop.lineWidth = 0;
		context_timeTop.strokeStyle = "White";
		context_timeTop.moveTo(x, 0);
		context_timeTop.lineTo(x, div_canvasTop.height);
		context_timeTop.fillText(optStartTimes.getHours() + ":"
				+ optStartTimes.getMinutes(), x + 2, div_canvasTop.height - 8);
		optStartTimes.setMinutes(optStartTimes.getMinutes() + Number(interval)
				* 6, optStartTimes.getSeconds(), 0);
		context_timeTop.stroke();
		context_timeTop.closePath();
	}

}

/**
 * @Title: loadTimeAxisCenter
 * @Description: 加载中部时间轴
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadTimeAxisCenter(operationId, interval, startTime, state) {
	var optStartTime = startTime.replace(/-/g, "/");
	var optStartTimes = new Date(optStartTime);
	var div_canvas = document.getElementById("canvasTimeCenter");
	var context_time = div_canvas.getContext("2d");
	var wg_cols = div_canvas.width / 15;
	var cell_width = 90;
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width;
		context_time.beginPath();
		context_time.lineWidth = 0;
		context_time.strokeStyle = "White";
		context_time.moveTo(x, 0);
		context_time.lineTo(x, div_canvas.height);
		context_time.fillText(optStartTimes.getHours() + ":"
				+ optStartTimes.getMinutes(), x + 2, div_canvas.height - 2);
		optStartTimes.setMinutes(optStartTimes.getMinutes() + Number(interval)
				* 6, optStartTimes.getSeconds(), 0);
		context_time.stroke();
		context_time.closePath();


	}
}
/**
 * @功能描述:加载时间轴
 * @参数:
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function loadTimeAxis(docId) {
	var params = {
		operationId : docId
	};
	$.post(realPath + "/anesthesiaRecord/getOptStartTime.action", params,
			function(data) {
				if (data != undefined) {
					var json = data;
					var t = eval('(' + json + ')');
					if(t){
						interval = t.interval;
						operationStarttime = t.opt_start_time;
						loadTimeAxisTop($('#ylwsId').val(), interval, operationStarttime, '') ;
						loadTimeAxisCenter($('#ylwsId').val(), interval, operationStarttime, '');
						
						getOutPutEvents();
						getInPutEvents();
						getMedEvent();
						getAnesthEvent();
						getSmWaveData(docId);
						
						$('#operationStartTimeTextId').val(operationStarttime);
						
						inPutSpeed = (interval * 60 * 1000) / 15;
						setInterval(drawInPutLineMove, inPutSpeed);
						
						mediSpeed = (interval * 60 * 1000) / 15;
						setInterval(drawMedLineMove, mediSpeed);
					}

					
				}
			});
	


}












/**
 * @功能描述:
 * @参数:
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function loadData(){
	var docId = $('#ylwsId').val();
	var optId = $('#operationId').val();
	var state = $('#state').val();
	if(state=='03'){
		falg = false;
		startRecordButtonNotUse(true,'LightSteelBlue');
		stopRecordButtonNotUse(true,'LightSteelBlue');
		endButtonNotUse(true,'LightSteelBlue');
		printButtonNotUse(true,'LightSteelBlue');
		
	}
	if(state=='04'){
		falg = true;
		
		startButtonNotUse(true,'LightSteelBlue');
		printButtonNotUse(true,'LightSteelBlue');
		loadTimeAxis(docId);
		
		
	}
	if(state=='05'){
		startButtonNotUse(true,'LightSteelBlue');
		startRecordButtonNotUse(true,'LightSteelBlue');
		stopRecordButtonNotUse(true,'LightSteelBlue');
		endButtonNotUse(true,'LightSteelBlue');
		printButtonNotUse(false,'#1CAAD1');
		loadTimeAxis(docId);
		
	}
}
/**
 * @Title: startCreateVitalSigns
 * @Description: 开始创建体征信息
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function startCreateVitalSigns(roomCode) {
	simuVSInterval = setInterval(createVitalSigns(roomCode), timeInterval);
}

/**
 * @Title: createVitalSigns
 * @Description: 创建体征信息
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function createVitalSigns(roomCode) {
	var url = realPath + "/recovery/createVitalSign.action";
	var params = {
		roomCode : roomCode
	};
	$.post(url, params);
}

/**
 * @Title: createAnaesRecord
 * @Description: 创建医疗文书
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function createAnaesRecord(ylwsId, operationId, interval, startTime) {
	var url = realPath + "/anesthesiaRecord/createAnaesRecord.action";
	var params = {
		ylwsid : ylwsId,
		operationId : operationId,
		startTime : startTime,
		userId : $('#userId').val(),
		collectIntervals : interval
	};
	$.post(url, params);
}

/**
 * @Title: startRecord
 * @Description: 开始记录
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function startRecord() {
	//var millisecond = interval * 60 * 1000;
	var millisecond = interval * 3000;
	addStartRecordTime();
	startRecordButtonNotUse(true,'LightSteelBlue');
	stopRecordButtonNotUse(false,'#1CAAD1');
	drawLineAndGraph();
	recordInterval = setInterval(function() {
		drawLineAndGraph();
	}, millisecond);

}
/**
 * @Title: addStartRecordTime
 * @Description: 开始记录
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function addStartRecordTime() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	$.post(realPath + "/anesthesiaRecord/addStartRecordTime.action", params);
}

/**
 * @Title: stopStartRecord
 * @Description: 结束描点
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function stopRecord() {
	clearInterval(recordInterval);
	stopRecordButtonNotUse(true,'LightSteelBlue');
	endButtonNotUse(false,'#1CAAD1');
	var params = {
		operationId : $('#ylwsId').val()
	};
	$.post(realPath + "/anesthesiaRecord/updateStopRecord.action", params);

}

/**
 * @Title: updateRegOptToStart
 * @Description: 更新手术状态到术中
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function updateRegOptToStart() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	$.post(realPath + "/anesthesiaRecord/updateRegOptToStart.action", params);
}

/**
 * @Title: updateRegOptToEnd
 * @Description: 更新手术状态到已结束
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function updateRegOptToEnd() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	$.post(realPath + "/anesthesiaRecord/updateRegOptToEnd.action", params);
	
	
}

/**
 * @Title: drawLineAndGraph
 * @Description: 开始描点
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function drawLineAndGraph1() {
	var url = realPath + "/anesthesiaRecord/getCollectItems.action";
	var params = {
		hospitalCode : $('#hospitalcode').val(),
		roomCode : $('#roomCode').val(),
		operationId : $('#ylwsId').val()
	};
	$.post(url, params, function(data) {
		 console.log(data);
		var json = data;
		wave = eval('(' + json + ')');
		if (wave.RR)
			hollowCircles.push(new HollowCircle(wave.RR.startX - 15,
					wave.RR.startY, 'blue'));
		if (wave.HR)
			solidCircles.push(new SolidCircle(wave.HR.startX - 15,
					wave.HR.startY, 'blue'));
		if (wave.BPSYS)
			vDownTriangles.push(new VDownTriangle(wave.BPSYS.startX - 19,
					wave.BPSYS.startY - 10, 'green'));
		if (wave.BPDIA)
			vUpTriangles.push(new VUpTriangle(wave.BPDIA.startX - 19,
					wave.BPDIA.startY, 'green'));
	});
};
var i = 0;
function drawLineAndGraph(){
   	 hollowCircles.push(new HollowCircle(i,random(100,150),'blue'));
   	 solidCircles.push(new SolidCircle(i,random(200,250),'blue'));
   	 vDownTriangles.push(new VDownTriangle(i,random(300,350),'green')); 
   	 vUpTriangles.push(new VUpTriangle(i,random(400,450),'green')); 

   	 i+=15;
     if(i % 1005 ==0){
         document.getElementById('div1').scrollLeft=i-300;
         console.log(i);
     }
}

//保存描点
function saveMonitoringSign(operationId, userId) {
	var hollowCircle = [];
	var solidCircle = [];
	var downTriangle = [];
	var upTriangle = [];
	var url = realPath + "/anesthesiaRecord/saveMonitoSign.action" ;
	for ( var i = 0; i < hollowCircles.length; i++) {
		if (hollowCircles[i] != undefined)
			hollowCircle.push(hollowCircles[i].hollowCircleX + ':'
					+ hollowCircles[i].hollowCircleY);
	}
	for ( var i = 0; i < solidCircles.length; i++) {
		if (solidCircles[i] != undefined)
			solidCircle.push(solidCircles[i].solidCircleX + ':'
					+ solidCircles[i].solidCircleY);
	}
	for ( var i = 0; i < vDownTriangles.length; i++) {
		if (vDownTriangles[i] != undefined)
			downTriangle.push(vDownTriangles[i].vDownTriangleX + ':'
					+ vDownTriangles[i].vDownTriangleY);
	}
	for ( var i = 0; i < vUpTriangles.length; i++) {
		if (vUpTriangles[i] != undefined)
			upTriangle.push(vUpTriangles[i].vUpTriangleX + ':'
					+ vUpTriangles[i].vUpTriangleY);
	}
	var params = {
		operationId : operationId,
		userId : userId,
		hollowCircles : hollowCircle.join(","),
		solidCircles : solidCircle.join(","),
		downTriangles : downTriangle.join(","),
		upTriangles : upTriangle.join(",")
	};
	
	$.post( url, params );

}


//获取描点
function getSmWaveData(operationId) {
	var url = realPath + "/anesthesiaRecord/getSmWaveDataList.action";
	var params = {
		operationId : $('#ylwsId').val()
	};
	$.post(url, params, function(data) {
		var json = data;
		var smWaveData = eval('(' + json + ')');
		for ( var i = 0; i < smWaveData.length; i++) {
			
			 if(smWaveData[i].Resprate)
	         	 hollowCircles.push(new HollowCircle(smWaveData[i].moniSignX*1,smWaveData[i].Resprate*1,'blue'));
	          if(smWaveData[i].Pulserate)
	         	 solidCircles.push(new SolidCircle(smWaveData[i].moniSignX*1,smWaveData[i].Pulserate*1,'blue'));
	          if(smWaveData[i].BpSys)
	         	 vDownTriangles.push(new VDownTriangle(smWaveData[i].moniSignX*1,smWaveData[i].BpSys*1,'green')); 
	          if(smWaveData[i].BpDias)
	         	 vUpTriangles.push(new VUpTriangle(smWaveData[i].moniSignX*1,smWaveData[i].BpDias*1,'green'));    
		}
	});
}

function random(min,max){

	return Math.floor(min+Math.random()*(max-min));

	}
/**
 * @Title: getOutputLiquid
 * @Description: 加载出量
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getOutputLiquid() {
	var url = realPath + "/anesthesiaRecord/getOutputLiquid.action";
	var params = {};
	$.post(url, params, function(data) {
		var json = data;
		var output = eval('(' + json + ')');
		for ( var i = 0; i < output.length; i++) {
			$("#outLiquid").append(
					"<option class=\"output\" value=\"" + output[i].ID + "\">"
							+ output[i].NAME + "</option>");
		}
	});
}

/**
 * @Title: getInChildName
 * @Description: 获取入量
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getInChildName(inLiquidsCode) {
	var url = realPath + "/anesthesiaRecord/getInChildNamesList.action";
	var params = {
		liquidsInSubType : inLiquidsCode
	};
	$.post(url, params, function(data) {
		// console.log(data);
		var json = data;
		var d = eval('(' + json + ')');
		for ( var i = 0; i < d.length; i++) {
			$("#inLiquid").append(
					"<option class=\"inputC\" value=\"" + d[i].id + "\">"
							+ d[i].name + "</option>");
		}
	});
}

/**
 * @Title: getAnesthesiaDoctor
 * @Description: 获取麻醉医师
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getAnesthesiaDoctor() {
	var url = realPath + "/anesthesiaRecord/getAnesthesiaDoctor.action";
	var params = {
		yishiRole : '手术麻醉医师'
	};
	$.post(url, params, function(data) {
		var json = data;
		var anesthetisters = eval('(' + json + ')');
		for ( var i = 0; i < anesthetisters.length; i++) {
			$('#anesthesiaDoctorNameList').append(
					"<option class=\"anesthetisters\" value=\""
							+ anesthetisters[i].code + "\">"
							+ anesthetisters[i].name + "</option>");
		}
	});

}

/**
 * @Title: editAnesthesiaDoctor
 * @Description: 获取麻醉医师
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function editAnesthesiaDoctor(operationId, anesthesiaDoctorType,
		anesthesiaDoctorName) {
	var url = realPath + "/anesthesiaRecord/editAnesthesiaDoctor.action";
	var params = {
		operationId : operationId,
		anesthesiaDoctorType : anesthesiaDoctorType,
		anesthesiaDoctorName : anesthesiaDoctorName
	};
	$.post(url, params);
}


/**
 * @Title: getOperationDoctor
 * @Description: 获取手术医师
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getOperationDoctor() {
	var url = realPath + "/anesthesiaRecord/getAnesthesiaDoctor.action";
	var params = {
		yishiRole : '手术医师'
	};
	$.post(url, params, function(data) {
		var json = data;
		var anesthetisters = eval('(' + json + ')');
		for ( var i = 0; i < anesthetisters.length; i++) {
			$('#operationDoctorList').append(
					"<option class=\"operationDoctors\" value=\""
							+ anesthetisters[i].code + "\">"
							+ anesthetisters[i].name + "</option>");
		}
	});

}



/**
 * @Title: editOperationDoctor
 * @Description: 修改手术医师
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function editOperationDoctor(operationId,operationDoctorName) {
	var url = realPath + "/anesthesiaRecord/editOperationDoctor.action";
	var params = {
		operationId : operationId,
		operationDoctorName : operationDoctorName
	};
	$.post(url, params);
}



/**
 * @Title: getTourNurse
 * @Description: 获取巡回护士
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getTourNurse() {
	var url = realPath + "/anesthesiaRecord/getAnesthesiaDoctor.action";
	var params = {
		yishiRole : '巡回护士'
	};
	$.post(url, params, function(data) {
		var json = data;
		var anesthetisters = eval('(' + json + ')');
		for ( var i = 0; i < anesthetisters.length; i++) {
			$('#tourNurseList').append(
					"<option class=\"tourNurses\" value=\""
							+ anesthetisters[i].code + "\">"
							+ anesthetisters[i].name + "</option>");
		}
	});

}

/**
 * @Title: editTourNurse
 * @Description: 修改巡回护士
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function editTourNurse(operationId,tourNurseType,tourNurseName) {
	var url = realPath + "/anesthesiaRecord/editTourNurse.action";
	var params = {
		operationId : operationId,
		tourNurseType : tourNurseType,
		tourNurseName:tourNurseName
	};
	$.post(url, params);
}

/**
 * @Title: getInstrumentNurse
 * @Description: 获取器械护士
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getInstrumentNurse() {
	var url = realPath + "/anesthesiaRecord/getAnesthesiaDoctor.action";
	var params = {
		yishiRole : '器械护士'
	};
	$.post(url, params, function(data) {
		var json = data;
		var anesthetisters = eval('(' + json + ')');
		for ( var i = 0; i < anesthetisters.length; i++) {
			$('#instrumentNurseList').append(
					"<option class=\"instrNurse\" value=\""
							+ anesthetisters[i].code + "\">"
							+ anesthetisters[i].name + "</option>");
		}
	});

}

/**
 * @Title: editgetInstrumentNurse
 * @Description: 修改器械护士
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function editInstrumentNurse(operationId,instrumentNurseType,instrumentNurseName) {
	var url = realPath + "/anesthesiaRecord/editInstrumentNurse.action";
	var params = {
		operationId : operationId,
		instrumentNurseType : instrumentNurseType,
		instrumentNurseName:instrumentNurseName
	};
	$.post(url, params);
}

/**
 * @Title: drawLineAndGraph
 * @Description: 开始描点
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function getVitalSign(operationId) {
	console.log("---------开始描点---------");
	var params = {
		operationId : operationId
	};
	$.post(realPath + "/anesthesiaRecord/getVitalSignFromMachine.action",
			params);
};



/** 	 
 * @功能描述:开始按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("start").disabled=trueOrfalse;
     document.getElementById("start").style.background=buttonColor;        
}
/** 	 
 * @功能描述:开始采集按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startRecordButtonNotUse(trueOrfalse,buttonColor){
	document.getElementById("startRecord").disabled=trueOrfalse;
	document.getElementById("startRecord").style.background=buttonColor;        
}
/** 
 * @方法名称:	 stopRecordButtonNotUse
 * @功能描述:结束采集按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function stopRecordButtonNotUse(trueOrfalse,buttonColor){
	document.getElementById("stopRecord").disabled=trueOrfalse;
	document.getElementById("stopRecord").style.background=buttonColor;        
}
/** 	 
 * @功能描述:结束按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function endButtonNotUse(trueOrfalse,buttonColor){
	document.getElementById("end").disabled=trueOrfalse;
	document.getElementById("end").style.background=buttonColor;        
}
/** 	 
 * @功能描述:打印按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function printButtonNotUse(trueOrfalse,buttonColor){
	document.getElementById("print").disabled=trueOrfalse;
	document.getElementById("print").style.background=buttonColor;        
}

/** 	 
 * @功能描述:加载开始时间及时间间隔
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function getOptTimeAndInterval(){
	var params = {
			operationId : $('#ylwsId').val()
		};
		$.post(realPath + "/anesthesiaRecord/getOptTimeAndInterval.action", params,function(data){
			var json = data;
			var t = eval('(' + json + ')');
		});
}


// 保存
var saveRegOpt = function() {
	updateSmRegOpt();
	addZhenTong();
	addOutRoomStatus();
	saveMonitoringSign($('#ylwsId').val(),$('#userId').val());
	saveOutPutEvent();
	saveInPutEvent();
	saveMedEvent();
	saveAnesthEvent();
	alert('保存成功');
};
// 更新基本信息
function updateSmRegOpt() {
	var operationId = document.getElementById("ylwsId").value;
	var regOptHeight = document.getElementById("regOptHeightId").value;
	var regOptWeight = document.getElementById("regOptWeightId").value;
	var regOptBloodType = document.getElementById("regOptBloodTypeId").value;
	var regOptAsa01 = document.getElementById("regOptAsa01Id").value;
	var params = {
		operationId : operationId,
		regOptHeight : regOptHeight,
		regOptWeight : regOptWeight,
		regOptBloodType : regOptBloodType,
		regOptAsa01 : regOptAsa01
	};
	$.post(realPath + "/anesthesiaRecord/updateSmRegOptSomething.action",
			params, function regOpt01(data) {
				var json = data;
				regOptData = eval('(' + json + ')');
			});

}
// 保存镇痛等
function addZhenTong() {
	var operationId = document.getElementById("ylwsId").value;
	var analgesia = $("input[name='analgesia']:checked").val();
	var cpr = $("input[name='cpr']:checked").val();
	var incisionCleanliness = $("#incisionCleanliness option:selected").val();
	var params = {
		operationId : operationId,
		analgesia : analgesia,
		cpr : cpr,
		incisionCleanliness : incisionCleanliness
	};
	$.post(realPath + "/anesthesiaRecord/saveZhenTong.action", params,
			function(data) {

			});

}

// 保存出室情况
function addOutRoomStatus() {

	$.post(realPath + "/anesthesiaRecord/addOutRoomStatus.action", $(
			"#outRoomStatusFormId").serialize(), function outRoomList(data) {
		var json = data;
		outRoomData = eval('(' + json + ')');

	});

}
// 获取出室情况
function getOutRoomStatus() {
	var operationId = document.getElementById("ylwsId").value;
	var params = {
		operationId : operationId
	};
	$.post(realPath + "/anesthesiaRecord/getOutRoomStatus.action", params,
			function outRoom(data) {
				// console.log(data);
				var json = data;
				outRoomData = eval('(' + json + ')');
				if (outRoomData != null) {
					$(
							":radio[name='sors.easePainManner'][value="
									+ outRoomData.easePainManner + "]").attr(
							"checked", "true");
					$(
							":radio[name='sors.mentalState'][value="
									+ outRoomData.mentalState + "]").attr(
							"checked", "true");
					$(
							":radio[name='sors.coughReflact'][value="
									+ outRoomData.coughReflact + "]").attr(
							"checked", "true");
					$(
							":radio[name='sors.direPower'][value="
									+ outRoomData.direPower + "]").attr(
							"checked", "true");
					$(
							":radio[name='sors.muscleRecover'][value="
									+ outRoomData.muscleRecover + "]").attr(
							"checked", "true");
					$(
							":radio[name='sors.leaveTo'][value="
									+ outRoomData.leaveTo + "]").attr(
							"checked", "true");
				}
			});
}

/**
 * @Title: loadEventsGrid
 * @Description: 加载麻醉用药,出入量网格
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadMedicationEventsGrid() {
	var m_canvas = document.getElementById("canvasMedication");
	var m_context = m_canvas.getContext("2d");
	var wg_cols = m_canvas.width / 15; // 所画列数
	var wg_rows = m_canvas.height / 15; // 所画行数
	var cell_heigth = 30;// 每个大行高度 单位为像素(px)
	var cell_width = 90; // 每个大列宽度 单位为像素(px)

	// 画 大列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width;
		m_context.beginPath();
		m_context.lineWidth = 2;
		m_context.strokeStyle = "#000000";
		m_context.moveTo(x, 0);
		m_context.lineTo(x, m_canvas.height);
		m_context.stroke();
		m_context.closePath();
	}
	// 画 大行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth;
		m_context.beginPath();
		m_context.lineWidth = 2;
		m_context.strokeStyle = "#000000";
		m_context.moveTo(0, y);
		m_context.lineTo(m_canvas.width, y);
		m_context.stroke();
		m_context.closePath();
	}
	// 画 小列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width / 6;
		m_context.beginPath();
		m_context.lineWidth = 1;
		m_context.strokeStyle = "#000000";
		m_context.moveTo(x, 0);
		m_context.lineTo(x, m_canvas.height);
		m_context.stroke();
		m_context.closePath();
	}
	// 画 小行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth / 2;
		m_context.beginPath();
		m_context.lineWidth = 1;
		m_context.strokeStyle = "#000000";
		m_context.moveTo(0, y);
		m_context.lineTo(m_canvas.width, y);
		m_context.stroke();
		m_context.closePath();
	}
}
/**
 * @Title: loadInPutEventsGrid
 * @Description: 加載入量网格
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadInPutEventsGrid() {
	var i_canvas = document.getElementById("canvasInPut");
	var i_context = i_canvas.getContext("2d");
	var wg_cols = i_canvas.width / 15; // 所画列数
	var wg_rows = i_canvas.height / 15;
	; // 所画行数
	var cell_heigth = 30;// 每个大行高度 单位为像素(px)
	var cell_width = 90; // 每个大列宽度 单位为像素(px)

	// 画 大列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width;
		i_context.beginPath();
		i_context.lineWidth = 2;
		i_context.strokeStyle = "#000000";
		i_context.moveTo(x, 0);
		i_context.lineTo(x, i_canvas.height);
		i_context.stroke();
		i_context.closePath();
	}
	// 画 大行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth;
		i_context.beginPath();
		i_context.lineWidth = 2;
		i_context.strokeStyle = "#000000";
		i_context.moveTo(0, y);
		i_context.lineTo(i_canvas.width, y);
		i_context.stroke();
		i_context.closePath();
	}
	// 画 小列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width / 6;
		i_context.beginPath();
		i_context.lineWidth = 1;
		i_context.strokeStyle = "#000000";
		i_context.moveTo(x, 0);
		i_context.lineTo(x, i_canvas.height);
		i_context.stroke();
		i_context.closePath();
	}
	// 画 小行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth / 2;
		i_context.beginPath();
		i_context.lineWidth = 1;
		i_context.strokeStyle = "#000000";
		i_context.moveTo(0, y);
		i_context.lineTo(i_canvas.width, y);
		i_context.stroke();
		i_context.closePath();
	}
}
/**
 * @Title: loadInPutEventsGrid
 * @Description: 加載入量网格
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadOutPutEventsGrid() {
	var o_canvas = document.getElementById("canvasOutPut");
	var o_context = o_canvas.getContext("2d");
	var wg_cols = o_canvas.width / 15; // 所画列数
	var wg_rows = o_canvas.height / 15; // 所画行数
	var cell_heigth = 30;// 每个大行高度 单位为像素(px)
	var cell_width = 90; // 每个大列宽度 单位为像素(px)

	// 画 大列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width;
		o_context.beginPath();
		o_context.lineWidth = 2;
		o_context.strokeStyle = "#000000";
		o_context.moveTo(x, 0);
		o_context.lineTo(x, o_canvas.height);
		o_context.stroke();
		o_context.closePath();
	}
	// 画 大行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth;
		o_context.beginPath();
		o_context.lineWidth = 2;
		o_context.strokeStyle = "#000000";
		o_context.moveTo(0, y);
		o_context.lineTo(o_canvas.width, y);
		o_context.stroke();
		o_context.closePath();
	}
	// 画 小列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width / 6;
		o_context.beginPath();
		o_context.lineWidth = 1;
		o_context.strokeStyle = "#000000";
		o_context.moveTo(x, 0);
		o_context.lineTo(x, o_canvas.height);
		o_context.stroke();
		o_context.closePath();
	}
	// 画 小行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth / 2;
		o_context.beginPath();
		o_context.lineWidth = 1;
		o_context.strokeStyle = "#000000";
		o_context.moveTo(0, y);
		o_context.lineTo(o_canvas.width, y);
		o_context.stroke();
		o_context.closePath();
	}
}
/**
 * @Title: loadTracingPointGrid
 * @Description: 加载生命体征处描点网格
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function loadTracingPointGrid() {
	var a_canvas = document.getElementById("canvasCollect");
	var context = a_canvas.getContext("2d");
	var wg_cols = a_canvas.width / 15; // 所画列数
	var wg_rows = a_canvas.height / 15; // 所画行数
	var cell_heigth = 30;// 每个大行高度 单位为像素(px)
	var cell_width = 90; // 每个大列宽度 单位为像素(px)

	// 画 大列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width;
		context.beginPath();
		context.lineWidth = 2;
		context.strokeStyle = "#000000";
		context.moveTo(x, 0);
		context.lineTo(x, a_canvas.height);
		context.stroke();
		context.closePath();
	}
	// 画 大行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth;
		context.beginPath();
		context.lineWidth = 2;
		context.strokeStyle = "#000000";
		context.moveTo(0, y);
		context.lineTo(a_canvas.width, y);
		context.stroke();
		context.closePath();
	}
	// 画 小列
	for ( var col = 0; col <= wg_cols; col++) {
		var x = col * cell_width / 6;
		context.beginPath();
		context.lineWidth = 1;
		context.strokeStyle = "#000000";
		context.moveTo(x, 0);
		context.lineTo(x, a_canvas.height);
		context.stroke();
		context.closePath();
	}
	// 画 小行
	for ( var row = 0; row <= wg_rows; row++) {
		var y = row * cell_heigth / 2;
		context.beginPath();
		context.lineWidth = 1;
		context.strokeStyle = "#000000";
		context.moveTo(0, y);
		context.lineTo(a_canvas.width, y);
		context.stroke();
		context.closePath();
	}
}

/** -----------------------------描点相关方法开始------------------------------------------ */
var monitoringSignCanvas, monitoringSignContext;
var hollowCircles = []; // 空心圆数组
var solidCircles = []; // 实心圆数组
var vDownTriangles = []; // V下数组
var vUpTriangles = []; // V上数组
var monitoringSignGraphs = [];
var selectedHollowCircle;
var selectedSolidCircle;
var selectedVDownTriangle;
var selectedVUpTriangle;

function MonitoringSignSpace(monitoringSignItemCode, monitoringSignGraphCode,
		monitoringSignGraphColor) {
	this.monitoringSignItemCode = monitoringSignItemCode;
	this.monitoringSignGraphCode = monitoringSignGraphCode;
	this.monitoringSignGraphColor = monitoringSignGraphColor;
}

// 空心圆对象
function HollowCircle(hollowCircleX, hollowCircleY, hollowCircleColor) {
	this.hollowCircleX = hollowCircleX;
	this.hollowCircleY = hollowCircleY;
	this.hollowCircleColor = hollowCircleColor;
}
// 实心圆对象
function SolidCircle(solidCircleX, solidCircleY, solidCircleColor) {
	this.solidCircleX = solidCircleX;
	this.solidCircleY = solidCircleY;
	this.solidCircleColor = solidCircleColor;
}
// V下 对象
function VDownTriangle(vDownTriangleX, vDownTriangleY, vDownTriangleColor) {
	this.vDownTriangleX = vDownTriangleX;
	this.vDownTriangleY = vDownTriangleY;
	this.vDownTriangleColor = vDownTriangleColor;
}
// V上 对象
function VUpTriangle(vUpTriangleX, vUpTriangleY, vUpTriangleColor) {
	this.vUpTriangleX = vUpTriangleX;
	this.vUpTriangleY = vUpTriangleY;
	this.vUpTriangleColor = vUpTriangleColor;
}

// 清除画板
function monitoringSignClear() {
	monitoringSignContext.clearRect(0, 0, monitoringSignContext.canvas.width,
			monitoringSignContext.canvas.height);
	loadTracingPointGrid();
}

// 空心圆 呼吸
function monitoringSignHollowCircles(monitoringSignContext, hollowCircleX,
		hollowCircleY, hollowCircleColor) {
	monitoringSignContext.beginPath();
	monitoringSignContext.arc(hollowCircleX, hollowCircleY, 5, 0, 360, false);
	monitoringSignContext.strokeStyle = hollowCircleColor;
	monitoringSignContext.stroke();
	monitoringSignContext.closePath();
}
// 实心圆 脉搏
function monitoringSignSolidCircles(monitoringSignContext, solidCircleX,
		solidCircleY, solidCircleColor) {
	monitoringSignContext.beginPath();
	monitoringSignContext.arc(solidCircleX, solidCircleY, 6, 0, 360, false);
	monitoringSignContext.fillStyle = solidCircleColor;
	monitoringSignContext.fill();
	monitoringSignContext.closePath();
}
// V下 收缩压
function monitoringSignVDownTriangle(monitoringSignContext, vDownTriangleX,
		vDownTriangleY, vDownTriangleColor) {
	monitoringSignContext.beginPath();
	monitoringSignContext.moveTo(vDownTriangleX-4, vDownTriangleY);
	monitoringSignContext.lineTo(vDownTriangleX + Math.floor(Math.sqrt(400 / 3) / 2)-4, vDownTriangleY + 10);
	monitoringSignContext.moveTo(vDownTriangleX + Math.floor(Math.sqrt(400 / 3) / 2)-4, vDownTriangleY + 10);
	monitoringSignContext.lineTo(vDownTriangleX + Math.floor(Math.sqrt(400 / 3))-4, vDownTriangleY);
	monitoringSignContext.closePath();
	monitoringSignContext.strokeStyle = vDownTriangleColor;
	monitoringSignContext.stroke();
}

// V上 舒张压
function monitoringSignVUpTriangle(monitoringSignVUpContext, vUpTriangleX,
		vUpTriangleY, vUpTriangleColor) {
	monitoringSignVUpContext.beginPath();
	monitoringSignVUpContext.moveTo(vUpTriangleX-4, vUpTriangleY);
	monitoringSignVUpContext.lineTo(vUpTriangleX - Math.floor(Math.sqrt(400 / 3) / 2)-4, vUpTriangleY + 10);
	monitoringSignVUpContext.moveTo(vUpTriangleX-4, vUpTriangleY);
	monitoringSignVUpContext.lineTo(vUpTriangleX + Math.floor(Math.sqrt(400 / 3) / 2)-4, vUpTriangleY + 10);
	monitoringSignVUpContext.closePath();
	monitoringSignVUpContext.strokeStyle = vUpTriangleColor;
	monitoringSignVUpContext.stroke();
}
function drawMonitoringSignGraph() {
	monitoringSignClear();
	drawMonitoringSignHollowCircleGraph();
	drawMonitoringSignSolidCircleGraph();
	drawMonitoringSignVDownTriangleGraph();
	drawMonitoringSignVUpTriangleGraph();
}
// 空心圆 ○
function drawMonitoringSignHollowCircleGraph() {
	monitoringSignContext.beginPath();
	for ( var i = 0; i < hollowCircles.length; i++) {
		if (i > 0) {
			monitoringSignContext.moveTo(hollowCircles[i - 1].hollowCircleX,
					hollowCircles[i - 1].hollowCircleY);
			monitoringSignContext.lineTo(hollowCircles[i].hollowCircleX,
					hollowCircles[i].hollowCircleY);
		}
	}
	monitoringSignContext.closePath();
	monitoringSignContext.lineWidth = 2;
	monitoringSignContext.strokeStyle = hollowCircles[0] ? hollowCircles[0].hollowCircleColor
			: 'blue';
	monitoringSignContext.stroke();
	for ( var i = 0; i < hollowCircles.length; i++) {
		monitoringSignHollowCircles(monitoringSignContext,
				hollowCircles[i].hollowCircleX, hollowCircles[i].hollowCircleY,
				hollowCircles[i].hollowCircleColor);
	}
}
// 实心圆 ●
function drawMonitoringSignSolidCircleGraph() {
	monitoringSignContext.beginPath();
	for ( var i = 0; i < solidCircles.length; i++) {
		if (i > 0) {
			monitoringSignContext.moveTo(solidCircles[i - 1].solidCircleX,
					solidCircles[i - 1].solidCircleY);
			monitoringSignContext.lineTo(solidCircles[i].solidCircleX,
					solidCircles[i].solidCircleY);
		}
	}
	monitoringSignContext.closePath();
	monitoringSignContext.lineWidth = 2;
	monitoringSignContext.strokeStyle = solidCircles[0] ? solidCircles[0].solidCircleColor
			: '#000000';
	monitoringSignContext.stroke();
	for ( var i = 0; i < solidCircles.length; i++) {
		monitoringSignSolidCircles(monitoringSignContext,
				solidCircles[i].solidCircleX, solidCircles[i].solidCircleY,
				solidCircles[i].solidCircleColor);
	}
}
// ∨
function drawMonitoringSignVDownTriangleGraph() {
	monitoringSignContext.beginPath();
	for ( var i = 0; i < vDownTriangles.length; i++) {
		if (i > 0) {
			monitoringSignContext.moveTo(
					vDownTriangles[i - 1].vDownTriangleX ,
					vDownTriangles[i - 1].vDownTriangleY + 10);
			monitoringSignContext.lineTo(vDownTriangles[i].vDownTriangleX,
					vDownTriangles[i].vDownTriangleY + 10);
		}
	}
	monitoringSignContext.closePath();
	monitoringSignContext.lineWidth = 2;
	monitoringSignContext.strokeStyle = vDownTriangles[0] ? vDownTriangles[0].vDownTriangleColor
			: 'blue';
	monitoringSignContext.stroke();
	for ( var i = 0; i < vDownTriangles.length; i++) {
		monitoringSignVDownTriangle(monitoringSignContext,
				vDownTriangles[i].vDownTriangleX,
				vDownTriangles[i].vDownTriangleY,
				vDownTriangles[i].vDownTriangleColor);
	}
}
// ∧
function drawMonitoringSignVUpTriangleGraph() {
	monitoringSignContext.beginPath();
	for ( var i = 0; i < vUpTriangles.length; i++) {
		if (i > 0) {
			monitoringSignContext.moveTo(vUpTriangles[i - 1].vUpTriangleX ,
					vUpTriangles[i - 1].vUpTriangleY);
			monitoringSignContext.lineTo(vUpTriangles[i].vUpTriangleX ,
					vUpTriangles[i].vUpTriangleY);
		}
	}
	monitoringSignContext.closePath();
	monitoringSignContext.lineWidth = 2;
	monitoringSignContext.strokeStyle = vUpTriangles[0] ? vUpTriangles[0].vUpTriangleColor
			: 'blue';
	monitoringSignContext.stroke();
	for ( var i = 0; i < vUpTriangles.length; i++) {
		monitoringSignVUpTriangle(monitoringSignContext,
				vUpTriangles[i].vUpTriangleX + 4, vUpTriangles[i].vUpTriangleY,
				vUpTriangles[i].vUpTriangleColor);
	}
}
/** -----------------------------描点相关方法结束------------------------------------------ */

/** -----------------------------出量方法开始------------------------------------------ */

var outPutCanvas, outPutCtx;
var outPutSelectedContinued; // 被选中
var outPutEvents = [];

// 出入量对象
function OutPutEvent(outPutOperationId, outPutId, outPutName, outPutDosage,
		outPutDosageUnit, outPutX, outPutY, outPutHeight, outPutPoint,outPutDataId) {
	this.outPutOperationId = outPutOperationId;
	this.outPutId = outPutId;
	this.outPutName = outPutName;
	this.outPutDosage = outPutDosage;
	this.outPutDosageUnit = outPutDosageUnit;
	this.outPutX = outPutX;
	this.outPutY = outPutY;
	this.outPutHeight = outPutHeight;
	this.outPutPoint = outPutPoint;
	this.outPutDataId = outPutDataId;
}

// 清屏
function outPutClear() {
	outPutCtx.clearRect(0, 0, outPutCtx.canvas.width, outPutCtx.canvas.height);
}
// 画三角形 h 10
function drawOutPutTriangle(outPutCtx, x, y, height, outPutText) {
	outPutCtx.beginPath();
	outPutCtx.moveTo(x, y);
	outPutCtx.lineTo(x - height, y + height);
	outPutCtx.lineTo(x + height, y + height);
	outPutCtx.closePath();
	outPutCtx.fill();
	outPutCtx.font = "10px Arial";
	outPutCtx.fillText(outPutText, x + (height * 3 / 4), y + (height * 3 / 4));
}
function drawOutPutSpace() {
	outPutClear();
	loadOutPutEventsGrid();
	var ouNum = 0;
	for ( var i = 0; i < outPutEvents.length; i++) {
		if (outPutEvents[i] != undefined) {
			drawOutPutTriangle(outPutCtx, outPutEvents[i].outPutX,
					ouNum * 15 + 5, outPutEvents[i].outPutHeight,
					outPutEvents[i].outPutDosage
							+ outPutEvents[i].outPutDosageUnit);
			ouNum++;
		}
	}
}

/**
 * @Title: addOutPutEvent
 * @Description: 添加出量
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param
 * @return void
 */
function addOutPutEvent() {
	var docId = $('#ylwsId').val();
	var outPId = $('#outputLiquidID').val();
	var outPName = $('#outputLiquidName').val();
	var outPDosage = $('#outPutDosage').val();
	var outPDosageUnit = $('#outPutDosageUnit').val();
	var outPTime = $('#outPutTime').val();
	var outPutT = new Date(outPTime.replace(/-/g, '/'))
			- new Date(operationStarttime.replace(/-/g, '/'));
	var OPX = Math.floor((15 * outPutT) / (interval * 60 * 1000));
	var OPY = outPutEvents.length * 15 + 5;
	outPutEvents.push(new OutPutEvent(docId, outPId, outPName, outPDosage,
			outPDosageUnit, OPX, OPY, 10, outPutEvents.length, 0));
	addOutPutTable();
	setOutPutNameAnTotal();
}
//删除
function deleteOutPutEvent() {
	var radios = document.getElementsByName("outputPoint");
	for ( var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			for ( var j = 0; j < outPutEvents.length; j++) {
				if (outPutEvents[j] != undefined) {
					if (radios[i].value == outPutEvents[j].outPutPoint) {
						var outDateId = outPutEvents[j].outPutDataId;
						outPutEvents.splice(outPutEvents[j].outPutPoint, 1,
								undefined);
						addOutPutTable();
						setOutPutNameAnTotal();
						deleteOutEvent(outDateId);
						break;
					}
				}
			}
		}
	}
}

function getLocalTime(nS) {
	return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/,
			' ');
}
// 出量动态创建表格
function addOutPutTable() {
	$("#outputList tbody").empty();
	for ( var j = 0; j < outPutEvents.length; j++) {
		if (outPutEvents[j] != undefined) {
			var id = outPutEvents[j].outPutId;
			var name = outPutEvents[j].outPutName;
			var dosage = outPutEvents[j].outPutDosage;
			var dosageUnit = outPutEvents[j].outPutDosageUnit;
			var outX = outPutEvents[j].outPutX;
			var outL = (((interval * 60 * 1000) / 15) * outX)
					+ (new Date(operationStarttime.replace(/-/g, '/')) / 1000);
			var point = outPutEvents[j].outPutPoint;
			var liquidsOutRow = document.createElement("tr");
			liquidsOutRow.style.height = "30px";
			document.getElementById("outputListTableTbody").appendChild(
					liquidsOutRow);

			var liquidsOutCell1 = document.createElement("td");
			liquidsOutCell1.style.width = "30px";
			liquidsOutRow.appendChild(liquidsOutCell1);

			var liquidsOutIdInput = document.createElement("input");
			liquidsOutIdInput.type = "hidden";
			liquidsOutIdInput.className = "outputId";
			liquidsOutIdInput.value = id;
			liquidsOutCell1.appendChild(liquidsOutIdInput);

			var liquidsOutPointInput = document.createElement("input");
			liquidsOutPointInput.style.width = "30px";
			liquidsOutPointInput.type = "radio";
			liquidsOutPointInput.name = "outputPoint";
			liquidsOutPointInput.value = point;
			liquidsOutCell1.appendChild(liquidsOutPointInput);

			var liquidsOutNameCell = document.createElement("td");
			liquidsOutNameCell.style.width = "280px";
			liquidsOutNameCell.className = "outputName";
			liquidsOutNameCell.innerText = name;
			liquidsOutRow.appendChild(liquidsOutNameCell);

			var liquidsOutSpeedCell = document.createElement("td");
			liquidsOutSpeedCell.style.width = "80px";
			liquidsOutSpeedCell.className = "outputDosage";
			liquidsOutSpeedCell.innerText = dosage;
			liquidsOutRow.appendChild(liquidsOutSpeedCell);

			var liquidsOutSpeedUnitCell = document.createElement("td");
			liquidsOutSpeedUnitCell.style.width = "80px";
			liquidsOutSpeedUnitCell.className = "outputDosageUnit";
			liquidsOutSpeedUnitCell.innerText = dosageUnit;
			liquidsOutRow.appendChild(liquidsOutSpeedUnitCell);

			var liquidsOutDateCell = document.createElement("td");
			liquidsOutDateCell.style.width = "200px";
			liquidsOutDateCell.className = "outputTime";
			liquidsOutDateCell.innerText = getLocalTime(outL);
			liquidsOutRow.appendChild(liquidsOutDateCell);
		}
	}
};


function setOutPutNameAnTotal(){
	var ouN = 0;
	$('.outputLiquid').text('');
	$('.outputLiquidTotal').text('');
	 for(var i = 0;i<outPutEvents.length;i++){
		 if(outPutEvents[i]!=undefined){
				 var ouName = outPutEvents[i].outPutName;
				 var ouDosage  = outPutEvents[i].outPutDosage;
				 var ouDosageUnit = outPutEvents[i].outPutDosageUnit;
				 var ouEventDivId = 'liquidsOutDivId'+ouN;
				 var ouEventDivTotalId = 'liquidsOutDivIdTotal'+ouN;
				 if(ouN<4){
				   document.getElementById(ouEventDivId).innerHTML=ouName;
				   document.getElementById(ouEventDivTotalId).innerHTML=ouDosage+" "+ouDosageUnit;
				 }else{
					 alert();
				 }
				 ouN++;
		 }
	 }
}
// 出量保存 
function saveOutPutEvent() {
	for ( var i = 0; i < outPutEvents.length; i++) {
		if (outPutEvents[i] != undefined) {
			var params = {
				outPutOperationId : outPutEvents[i].outPutOperationId,
				outPutId : outPutEvents[i].outPutId,
				outPutName : outPutEvents[i].outPutName,
				outPutDosage : outPutEvents[i].outPutDosage,
				outPutDosageUnit : outPutEvents[i].outPutDosageUnit,
				outPutX : outPutEvents[i].outPutX,
				outPutY : outPutEvents[i].outPutY,
				outPutDataId : outPutEvents[i].outPutDataId
			};
			var url = realPath + "/anesthesiaRecord/saveOutPutEvent.action";
			console.log(params);
			$.post(url, params, function(data) {
				console.log(data);
				var json = data;
				var t = eval('(' + json + ')');
				if(t){
					for ( var j = 0; j < outPutEvents.length; j++){
						if (outPutEvents[j] != undefined){
							if(t.OY == outPutEvents[j].outPutY){
								outPutEvents[j].outPutDataId = t.OID;
							}
						}
					}
					
				}
				
			});
		}
	}
}


//出量加载
function getOutPutEvents() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	var url = realPath + "/anesthesiaRecord/getOutPutEvents.action";
	$.post(url, params, function(data) {
		console.log(data);
		var json = data;
		var t = eval('(' + json + ')');
		for ( var i = 0; i < t.length; i++) {
				outPutEvents.push(new OutPutEvent(t[i].operationId, t[i].itemId,
						t[i].name, t[i].dosage, t[i].dosageUnit, t[i].startXpoint,
						t[i].ypoint, 10, outPutEvents.length, t[i].id));
		}
		addOutPutTable();
		setOutPutNameAnTotal();
	});
}

//删除出量
function deleteOutEvent(outPutDataId){
	var params = {
			outPutDataId : outPutDataId
		};
	var url = realPath + "/anesthesiaRecord/deleteOutPutEvent.action";
	$.post(url, params);
}














/** -----------------------------出量方法结束------------------------------------------ */

/** -----------------------------入量方法开始------------------------------------------ */

var inPutCanvas;
var inPutCtx;
var inPutSelectedContinued; // 被选中
var inPutSelectedStopContinued; // 被选中
var inPutEvents = [];
var inPutStopTriangle = [];

// 入量对象
function InPutEvent(inPutOperationId, inPutId, inPutName, inPutSpec, inPutFirm,
		inPutDosage, inPutDosageUnit, inPutAmount, inPutPrice, inPutCharge,
		inPutStartX, inPutStartY, inPutEndX, inPutEndY, inPutHeight,
		inPutPoint, inPutEnded,inPutDataId) {
	this.inPutOperationId = inPutOperationId;
	this.inPutId = inPutId;
	this.inPutName = inPutName;
	this.inPutSpec = inPutSpec;
	this.inPutFirm = inPutFirm;
	this.inPutDosage = inPutDosage;
	this.inPutDosageUnit = inPutDosageUnit;
	this.inPutAmount = inPutAmount;
	this.inPutPrice = inPutPrice;
	this.inPutCharge = inPutCharge;
	this.inPutStartX = inPutStartX;
	this.inPutStartY = inPutStartY;
	this.inPutEndX = inPutEndX;
	this.inPutEndY = inPutEndY;
	this.inPutHeight = inPutHeight;
	this.inPutPoint = inPutPoint;
	this.inPutEnded = inPutEnded;
	this.inPutDataId = inPutDataId;
}

// 清屏
function inPutClear() {
	inPutCtx.clearRect(0, 0, inPutCtx.canvas.width, inPutCtx.canvas.height);
}
// 画三角形 h 10
function drawInPutTriangle(inPutCtx, x, y, height, inPutText) {
	inPutCtx.beginPath();
	inPutCtx.moveTo(x, y);
	inPutCtx.lineTo(x - height, y + height);
	inPutCtx.lineTo(x + height, y + height);
	inPutCtx.closePath();
	inPutCtx.fill();
	inPutCtx.font = "10px Arial";
	inPutCtx.fillText(inPutText, x + (height * 3 / 4), y + (height * 3 / 4));
}

// 划线
function drawInPutLine(inPutCtx, startX, startY, endX, endY) {
	inPutCtx.beginPath();
	inPutCtx.fillStyle = "#000000";
	inPutCtx.moveTo(startX, startY);
	inPutCtx.lineTo(endX, endY);
	inPutCtx.closePath();
	inPutCtx.stroke();

}
// 画箭头
function drawInPutArrow(inPutCtx, startX, startY) {
	inPutCtx.beginPath();
	inPutCtx.fillStyle = "#000000";
	inPutCtx.moveTo(startX - 10, startY - 5);
	inPutCtx.lineTo(startX, startY);
	inPutCtx.moveTo(startX - 10, startY + 5);
	inPutCtx.lineTo(startX, startY);
	inPutCtx.closePath();
	inPutCtx.stroke();
}

function drawInPutSpace() {
	inPutClear();
	loadInPutEventsGrid();
	var iuNum = 0;
	for ( var i = 0; i < inPutEvents.length; i++) {
		if (inPutEvents[i] != undefined) {
			if (inPutEvents[i].inPutEnded == '1') {
				drawInPutTriangle(inPutCtx, inPutEvents[i].inPutStartX,
						iuNum * 15 + 5, inPutEvents[i].inPutHeight,
						inPutEvents[i].inPutDosage
								+ inPutEvents[i].inPutDosageUnit);
				drawInPutLine(inPutCtx, inPutEvents[i].inPutStartX,
						iuNum * 15 + 5, inPutEvents[i].inPutEndX,
						iuNum * 15 + 5);
				drawInPutTriangle(inPutCtx, inPutEvents[i].inPutEndX,
						iuNum * 15 + 5, inPutEvents[i].inPutHeight, '');
			} else {
				drawInPutTriangle(inPutCtx, inPutEvents[i].inPutStartX,
						iuNum * 15 + 5, inPutEvents[i].inPutHeight,
						inPutEvents[i].inPutDosage
								+ inPutEvents[i].inPutDosageUnit);
				drawInPutLine(inPutCtx, inPutEvents[i].inPutStartX,
						iuNum * 15 + 5, inPutEvents[i].inPutEndX,
						iuNum * 15 + 5);
				drawInPutArrow(inPutCtx, inPutEvents[i].inPutEndX,
						iuNum * 15 + 5);

			}
			iuNum++;
		}

	}
}

function drawInPutLineMove() {
	if (inPutEvents.length > 0) {
		for ( var i = 0; i < inPutEvents.length; i++) {
			if (inPutEvents[i] != undefined) {
				if (inPutEvents[i].inPutEnded == '0') {
					var inPutLong = (inPutEvents[i].inPutDosage / interval) * 15;
					if (inPutEvents[i].inPutEndX - inPutEvents[i].inPutStartX < inPutLong) {
						inPutEvents[i].inPutEndX++;
					}
					if (inPutEvents[i].inPutEndX - inPutEvents[i].inPutStartX >= inPutLong) {
						inPutEvents[i].inPutEndX = inPutEvents[i].inPutStartX
								+ inPutLong;
						inPutEvents[i].inPutEnded = '1';
					}
				}
			}
		}
	}

}

function addInPutEvent() {
	var docId = $('#ylwsId').val();
	var inPId = $('#inPutID').val();
	var inPName = $('#inPutName').val();
	var inPSpec = $('#inPutSpec').val();
	var inPFirm = $('#inPutFirm').val();
	var inPDosage = $('#inPutDosage').val();
	var inPDosageUnit = $('#inPutDosageUnit').val();
	var inPTime = $('#inPutTime').val();
	var inPutT = new Date(inPTime.replace(/-/g, '/'))
			- new Date(operationStarttime.replace(/-/g, '/'));
	var iPX = Math.floor((15 * inPutT) / (interval * 60 * 1000));
	var iPY = inPutEvents.length * 15 + 5;
	inPutEvents.push(new InPutEvent(docId, inPId, inPName, inPSpec, inPFirm,
			inPDosage, inPDosageUnit, '', '', '', iPX, iPY, iPX, iPY, 10,
			inPutEvents.length, '0',0));
	addInPutTable();
	setInPutNameAndTotal();
}

function deleteInPutEvent() {
	var inRadios = document.getElementsByName("inputPoint");
	for ( var i = 0; i < inRadios.length; i++) {
		if (inRadios[i].checked) {
			for ( var j = 0; j < inPutEvents.length; j++) {
				if (inPutEvents[j] != undefined) {
					if (inRadios[i].value == inPutEvents[j].inPutPoint) {
						var inPutDataId = inPutEvents[j].inPutDataId;
						inPutEvents.splice(inPutEvents[j].inPutPoint, 1,
								undefined);
						addInPutTable();
						setInPutNameAndTotal();
						 deleteInEvent(inPutDataId);
						break;
					}
				}
			}
		}
	}
}

// 入量动态创建表格
function addInPutTable() {
	$("#inputList tbody").empty();
	for ( var j = 0; j < inPutEvents.length; j++) {
		if (inPutEvents[j] != undefined) {
			var id = inPutEvents[j].inPutId;
			var name = inPutEvents[j].inPutName;
			var spec = inPutEvents[j].inPutSpec;
			var firm = inPutEvents[j].inPutFirm;
			var dosage = inPutEvents[j].inPutDosage;
			var dosageUnit = inPutEvents[j].inPutDosageUnit;
			var ended = inPutEvents[j].inPutEnded;
			if (ended == '1') {
				ended = '是';
			} else {
				ended = '否';
			}
			var inX = inPutEvents[j].inPutStartY;
			var inL = (((interval * 60 * 1000) / 15) * inX)
					+ (new Date(operationStarttime.replace(/-/g, '/')) / 1000);
			var point = inPutEvents[j].inPutPoint;
			var liquidsInRow = document.createElement("tr");
			liquidsInRow.style.height = "30px";
			document.getElementById("inputListTableTbody").appendChild(
					liquidsInRow);

			var liquidsInCell1 = document.createElement("td");
			liquidsInCell1.style.width = "30px";
			liquidsInRow.appendChild(liquidsInCell1);

			var liquidsInIdInput = document.createElement("input");
			liquidsInIdInput.type = "hidden";
			liquidsInIdInput.className = "inputId";
			liquidsInIdInput.value = id;
			liquidsInCell1.appendChild(liquidsInIdInput);

			var liquidsInPointInput = document.createElement("input");
			liquidsInIdInput.style.width = "30px";
			liquidsInPointInput.type = "radio";
			liquidsInPointInput.name = "inputPoint";
			liquidsInPointInput.value = point;
			liquidsInCell1.appendChild(liquidsInPointInput);

			var liquidsInNameCell = document.createElement("td");
			liquidsInNameCell.style.width = "280px";
			liquidsInNameCell.className = "inputName";
			liquidsInNameCell.innerText = name;
			liquidsInRow.appendChild(liquidsInNameCell);

			var liquidsInSpecCell = document.createElement("td");
			liquidsInSpecCell.style.width = "80px";
			liquidsInSpecCell.className = "inputSpec";
			liquidsInSpecCell.innerText = spec;
			liquidsInRow.appendChild(liquidsInSpecCell);

			var liquidsInFirmCell = document.createElement("td");
			liquidsInFirmCell.style.width = "160px";
			liquidsInFirmCell.className = "inputFirm";
			liquidsInFirmCell.innerText = firm;
			liquidsInRow.appendChild(liquidsInFirmCell);

			var liquidsInEndCell = document.createElement("td");
			liquidsInEndCell.style.width = "80px";
			liquidsInEndCell.className = "inputEnd";
			liquidsInEndCell.innerText = ended;
			liquidsInRow.appendChild(liquidsInEndCell);

			var liquidsInDosageCell = document.createElement("td");
			liquidsInDosageCell.style.width = "80px";
			liquidsInDosageCell.className = "inputDosage";
			liquidsInDosageCell.innerText = dosage;
			liquidsInRow.appendChild(liquidsInDosageCell);

			var liquidsInDosageUnitCell = document.createElement("td");
			liquidsInDosageUnitCell.style.width = "80px";
			liquidsInDosageUnitCell.className = "inputDosageUnit";
			liquidsInDosageUnitCell.innerText = dosageUnit;
			liquidsInRow.appendChild(liquidsInDosageUnitCell);

			var liquidsInTimeCell = document.createElement("td");
			liquidsInTimeCell.style.width = "200px";
			liquidsInTimeCell.className = "inputTime";
			liquidsInTimeCell.innerText = getLocalTime(inL);
			liquidsInRow.appendChild(liquidsInTimeCell);
		}
	}
};

function setInPutNameAndTotal(){
	var iuN = 0;
	$('.inputLiquid').text('');
	$('.inputLiquidTotal').text('');
	 for(var i = 0;i<inPutEvents.length;i++){
		 if(inPutEvents[i]!=undefined){
				 var iuName = inPutEvents[i].inPutName;
				 var iuDosage  = inPutEvents[i].inPutDosage;
				 var iuDosageUnit = inPutEvents[i].inPutDosageUnit;
				 var iuEventDivId = 'liquidsInDivId'+iuN;
				 var iuEventDivTotalId = 'liquidsInDivIdTotal'+iuN;
				 if(iuN<4){
				   document.getElementById(iuEventDivId).innerHTML=iuName;
				   document.getElementById(iuEventDivTotalId).innerHTML=iuDosage+" "+iuDosageUnit;
				 }else{
					 alert();
				 }
				 iuN++;
		 }
	 }
}



function saveInPutEvent() {
	for ( var i = 0; i < inPutEvents.length; i++) {
		if (inPutEvents[i] != undefined) {
			var params = {
				inPutOperationId : inPutEvents[i].inPutOperationId,
				inPutId : inPutEvents[i].inPutId,
				inPutName : inPutEvents[i].inPutName,
				inPutSpec : inPutEvents[i].inPutSpec,
				inPutFirm : inPutEvents[i].inPutFirm,
				inPutDosage : inPutEvents[i].inPutDosage,
				inPutDosageUnit : inPutEvents[i].inPutDosageUnit,
				inPutAmount : inPutEvents[i].inPutAmount,
				inPutPrice : inPutEvents[i].inPutPrice,
				inPutCharge : inPutEvents[i].inPutCharge,
				inPutStartX : inPutEvents[i].inPutStartX,
				inPutStartY : inPutEvents[i].inPutStartY,
				inPutEndX : inPutEvents[i].inPutEndX,
				inPutEndY : inPutEvents[i].inPutEndY,
				inPutEnded : inPutEvents[i].inPutEnded,
				inPutDataId : inPutEvents[i].inPutDataId
			};
			var url = realPath + "/anesthesiaRecord/saveInPutEvent.action";
			$.post(url, params, function(data) {
				var json = data;
				var t = eval('(' + json + ')');
				if(t){
					for ( var j = 0; j < inPutEvents.length; j++){
						if (inPutEvents[j] != undefined){
							if(t.IY == inPutEvents[j].inPutStartY){
								inPutEvents[j].inPutDataId = t.IID;
							}
						}
					}
					
				}
			});
		}
	}
}



//入量加载
function getInPutEvents() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	var url = realPath + "/anesthesiaRecord/getInPutEvents.action";
	$.post(url, params, function(data) {
		console.log(data);
		var json = data;
		var t = eval('(' + json + ')');
		for ( var i = 0; i < t.length; i++) {
				inPutEvents.push(new InPutEvent(t[i].operationId, t[i].itemId, t[i].name, t[i].spec, t[i].firm,
						t[i].dosage, t[i].dosageUnit, '', '', '', t[i].startXpoint, t[i].ypoint, t[i].endXpoint, t[i].ypoint, 10,
						inPutEvents.length, '1',t[i].id));
		}
		addInPutTable();
		setInPutNameAndTotal();
	});
}


//删除入量
function deleteInEvent(inPutDataId){
	var params = {
			inPutDataId : inPutDataId
		};
	var url = realPath + "/anesthesiaRecord/deleteInPutEvent.action";
	$.post(url, params);
}
























/** -----------------------------入量方法结束------------------------------------------ */

/** -----------------------------麻醉用药方法结束------------------------------------------ */

var medCanvas;
var medCtx;
var medSelectedContinued; // 被选中
var medSelectedStopContinued; // 被选中
var medEvents = [];
var medStopTriangle = [];

// 入量对象
function MedEvent(medOperationId, medId, medName, medSpec, medTakewayCode,
		medIsContinued, medFirm, medDosage, medDosageUnit, medAmount,
		medIsCharge, medThickness, medThicknessUnit, medSpeed, medSpeedUnit,
		medReasonSelect, medReason,medStartX,medStartY,medEndX,medEndY,medHeight,medPoint,medIsEnded) {
	this.medOperationId = medOperationId;//患者HID
	this.medId = medId;//药品Id
	this.medName = medName;//药品名称
	this.medSpec = medSpec;//规格
	this.medTakewayCode = medTakewayCode; //给药途径
	this.medIsContinued = medIsContinued;//是否持续
	this.medFirm = medFirm;//厂家
	this.medDosage = medDosage;//用量
	this.medDosageUnit = medDosageUnit;//用量单位
	this.medAmount = medAmount;//计价用量
	this.medIsCharge = medIsCharge;//是否收费
	this.medThickness = medThickness;//浓度
	this.medThicknessUnit = medThicknessUnit;//浓度单位
	this.medSpeed = medSpeed;//流速
	this.medSpeedUnit = medSpeedUnit;//流速单位
	this.medReasonSelect = medReasonSelect;//选择用药理由
	this.medReason = medReason;//用药理由
	this.medStartX = medStartX;
	this.medStartY = medStartY;
	this.medEndX = medEndX;
	this.medEndY = medEndY;
	this.medHeight = medHeight;
	this.medPoint = medPoint;
	this.medIsEnded = medIsEnded;//是否结束
}

// 清屏
function medClear() {
	medCtx.clearRect(0, 0, medCtx.canvas.width, medCtx.canvas.height);
}
// 画三角形 h 10
function drawMedTriangle(medCtx, x, y, height, medText) {
	medCtx.beginPath();
	medCtx.moveTo(x, y);
	medCtx.lineTo(x - height, y + height);
	medCtx.lineTo(x + height, y + height);
	medCtx.closePath();
	medCtx.fill();
	medCtx.font = "10px Arial";
	medCtx.fillText(medText, x + (height * 3 / 4), y + (height * 3 / 4));
}

// 划线
function drawMedLine(medCtx, startX, startY, endX, endY) {
	medCtx.beginPath();
	medCtx.fillStyle = "#000000";
	medCtx.moveTo(startX, startY);
	medCtx.lineTo(endX, endY);
	medCtx.closePath();
	medCtx.stroke();

}
// 画箭头
function drawMedArrow(medCtx, startX, startY) {
	medCtx.beginPath();
	medCtx.fillStyle = "#000000";
	medCtx.moveTo(startX - 10, startY - 5);
	medCtx.lineTo(startX, startY);
	medCtx.moveTo(startX - 10, startY + 5);
	medCtx.lineTo(startX, startY);
	medCtx.closePath();
	medCtx.stroke();
}
//画麻醉用药图
function drawMedSpace() {
	medClear();
	loadMedicationEventsGrid();
	var medNum = 0;
	for ( var i = 0; i < medEvents.length; i++) {
		if (medEvents[i] != undefined) {
			if(medEvents[i].medIsContinued == '1'){
				if (medEvents[i].medIsEnded == '1') {
					drawMedTriangle(medCtx, medEvents[i].medStartX,medNum * 15 + 5, medEvents[i].medHeight,medEvents[i].medDosage + medEvents[i].medDosageUnit);
					drawMedLine(medCtx, medEvents[i].medStartX,medNum * 15 + 5, medEvents[i].medEndX,medNum * 15 + 5);
					drawMedTriangle(medCtx, medEvents[i].medEndX,medNum * 15 + 5, medEvents[i].medHeight,'');
				} else {
					drawMedTriangle(medCtx, medEvents[i].medStartX,medNum * 15 + 5, medEvents[i].medHeight,medEvents[i].medDosage + medEvents[i].medDosageUnit);
					drawMedLine(medCtx, medEvents[i].medStartX,medNum * 15 + 5, medEvents[i].medEndX,medNum * 15 + 5);
					drawMedArrow(medCtx, medEvents[i].medEndX,medNum * 15 + 5);
				}
			}else{
				drawMedTriangle(medCtx, medEvents[i].medStartX,medNum * 15 + 5, medEvents[i].medHeight,medEvents[i].medDosage + medEvents[i].medDosageUnit);
			}
			medNum++;
		}

	}
}
//麻醉用药划线
function drawMedLineMove() {
	if (medEvents.length > 0) {
		for ( var i = 0; i < medEvents.length; i++) {
			if (medEvents[i] != undefined) {
				if (medEvents[i].medIsContinued == '1') {
					if (medEvents[i].medIsEnded == '0') {
						var medLong = (medEvents[i].medDosage / medEvents[i].medSpeed)*15;
						if (medEvents[i].medEndX - medEvents[i].medStartX < medLong) {
							medEvents[i].medEndX++;
						}
						if (medEvents[i].medEndX - medEvents[i].medStartX == medLong) {
							medEvents[i].medEndX = medEvents[i].medStartX + medLong;
							medEvents[i].medIsEnded = '1';
						}
					}
				}

			}
		}
	}

}
//添加麻醉用药   
function addMedEvent() {
	var docId = $('#ylwsId').val();
	var meId = $('#medicineID').val();
	var meName = $('#medicineName').val();
	var meSpec = $('#medicineSpec').val();
	var meTakeWay = $('#medicalTakeWay').val();
	var meIsContinued = document.getElementById("medicalIsContinued");
	var meFirm = $('#medicineFirm').val();
	var meDosage = $('#medicineDosage').val();
	var meDosageUnit = $('#medicineDosageUnit').val();
	var meAmount = $('#medicineAmount').val();
	var meIsCharge = $('#medicineIsCharge').val();
	var meThickness = $('#medicineThickness').val();
	var meThicknessUnit = $('#medicineThicknessUnit').val();
	var meStartTime = $('#medicineStartTime').val();
	var meSpeed = $('#medicineSpeed').val();
	var meSpeedUnit = $('#medicineSpeedUnit').val();
	var meReasonSelect = $('#medicineReasonSelect').val();
	var meReason = $('#medicineReason').val();
	var meT = new Date(meStartTime.replace(/-/g, '/')) - new Date(operationStarttime.replace(/-/g, '/'));
	var meX = Math.floor((15 * meT) / (interval * 60 * 1000));
	var meY = medEvents.length * 15 + 5;
	if(meIsContinued.checked){
		medEvents.push(new MedEvent(docId, meId, meName, meSpec, meTakeWay,'1',meFirm,
				meDosage, meDosageUnit,meAmount,meIsCharge,meThickness, meThicknessUnit, meSpeed, meSpeedUnit, meReasonSelect, meReason,
				meX,meY,meX,meY,10,medEvents.length, '0'));
	}else{
		medEvents.push(new MedEvent(docId, meId, meName, meSpec, meTakeWay,'0',meFirm,
				meDosage, meDosageUnit,meAmount,meIsCharge,meThickness, meThicknessUnit, meSpeed, meSpeedUnit, meReasonSelect, meReason,
				meX,meY,meX,meY,10,medEvents.length, '0'));
	}
	setMedNameAndTotal();
}

// 删除麻醉用药
function deleteMedEvent(medSContinued) {
	if (medEvents[medSContinued] != undefined) {
		medEvents.splice(medEvents[medSContinued].medPoint, 1, undefined);
		setMedNameAndTotal();
	}
}
// 停止麻醉用药
function stopMedEvent(medSContinued) {
	if (medEvents[medSContinued] != undefined) {
		if (medEvents[medSContinued].medIsContinued == '1') {
			medEvents[medSContinued].medIsEnded = '1';
		}
	}
}
function setMedNameAndTotal(){
	var meN = 0;
	$('.anestheticAgents').text('');
	$('.anestheticAgentsTotal').text('');
	 for(var i = 0;i<medEvents.length;i++){
		 if(medEvents[i]!=undefined){
				 var meName = medEvents[i].medName;
				 var meDosage  = medEvents[i].medDosage;
				 var meDosageUnit = medEvents[i].medDosageUnit;
				 var meEventDivId = 'anestheticMedicine'+meN;
				 var meEventDivTotalId = 'anestheticMedicineTotal'+meN;
				 if(meN<15){
				   document.getElementById(meEventDivId).innerHTML=meName;
				   document.getElementById(meEventDivTotalId).innerHTML = meDosage +" "+ meDosageUnit;
				 }else{
					 alert();
				 }
				 meN++;
		 }
	 }
}

//保存麻醉用药

function saveMedEvent() {
	for ( var i = 0; i < medEvents.length; i++) {
		if (medEvents[i] != undefined) {
			var params = {
				medOperationId : medEvents[i].medOperationId,
				medId : medEvents[i].medId,
				medName : medEvents[i].medName,
				medSpec : medEvents[i].medSpec,
				medTakewayCode : medEvents[i].medTakewayCode,
				medFirm : medEvents[i].medFirm,
				medDosage : medEvents[i].medDosage,
				medDosageUnit : medEvents[i].medDosageUnit,
				medAmount : medEvents[i].medAmount,
				medIsCharge : medEvents[i].medIsCharge,
				medThickness : medEvents[i].medThickness,
				medThicknessUnit : medEvents[i].medThicknessUnit,
				medSpeed : medEvents[i].medSpeed,
				medSpeedUnit : medEvents[i].medSpeedUnit,
				medReasonSelect : medEvents[i].medReasonSelect,
				medReason : medEvents[i].medReason,
				medStartX : medEvents[i].medStartX,
				medSY : medEvents[i].medStartY,
				medEndX : medEvents[i].medEndX,
				medIsContinued : medEvents[i].medIsContinued,
				medIsEnded : medEvents[i].medIsEnded
			};
			console.log(params);
			
			var url = realPath + "/anesthesiaRecord/saveMedEvent.action";
		   console.log(url);
			$.post(url, params);
		}
	}
}

//麻醉用药加载

function getMedEvent() {
	var params = {
		operationId : $('#ylwsId').val()
	};
	var url = realPath + "/anesthesiaRecord/getMedEvents.action";
	$.post(url, params, function(data) {
		var json = data;
		var t = eval('(' + json + ')');
		for ( var i = 0; i < t.length; i++) {
			medEvents.push(new MedEvent(t[i].operationId, t[i].medicineCode, t[i].medicineName, t[i].spec, t[i].takewayCode,t[i].durable,t[i].medicineFirm,
					t[i].dosage, t[i].dosageUnit,t[i].id,'',t[i].thickness, t[i].thicknessUnit, t[i].flow, t[i].flowUnit, t[i].usemedicineEventId, t[i].reason,
					t[i].startXpoint,t[i].ypoint,t[i].endXpoint,t[i].ypoint,10,medEvents.length, t[i].ended));
		}
		setMedNameAndTotal();
	});
	
}


//删除麻醉用药
function deleteMedEvent1(id){
	var params = {
			medId : id
		};
	var url = realPath + "/anesthesiaRecord/deleteMedEventa.action";
	$.post(url, params);
}















/** -----------------------------麻醉用药方法结束------------------------------------------ */

/** -----------------------------麻醉事件方法开始------------------------------------------ */

var anesthEventCanvas;
var anesthEventCtx;
var bgColor = '#3CB371';
var anesthEventGraphs = [];
var graphCodes = [];//麻醉事件图形Code数组
var selectedAnesthEventGraph;
var selectedDeleteAnesthEventGraph;

//清除麻醉事件画板
function anesthEventClear() {
    anesthEventCtx.clearRect(0, 0, anesthEventCtx.canvas.width, anesthEventCtx.canvas.height);
}

//根据图形编号graphCode选择将要画的图形
function drawAnesthEventGraph(anesthEventCtx,anesthEventX,anesthEventY,eventItemCode,graphCode,graphElements){
    if(graphCode=='concentricCircles'){
        concentricCircles(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='xInCircle'){
        xInCircle(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='rightArrowInCircle'){
        rightArrowInCircle(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='downArrowInCircle'){
        downArrowInCircle(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='oneStartX'){
        oneStartX(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='oneEndX'){
        oneEndX(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='doublePositiveSlash'){
        doublePositiveSlash(anesthEventCtx,anesthEventX,anesthEventY);
    }
    if(graphCode=='circleAndNumber'){
    	if(graphElements){
    		var n = graphElements.split(',')[1].split(':')[1];
    		circleAndNumber(anesthEventCtx,anesthEventX,anesthEventY,n);
    	}
        
    }
}

// 麻醉事件图形对象
function AnesthEventGraph(anesthEventX, anesthEventY, eventItemCode,
		graphElements, graphCode, eventText, eventName) {
	this.anesthEventX = anesthEventX;
	this.anesthEventY = anesthEventY;
	this.eventItemCode = eventItemCode;
	this.graphElements = graphElements;
	this.graphCode = graphCode;
	this.eventText = eventText;
	this.eventName = eventName;
}

// 在麻醉事件画板上绘制所有的麻醉事件图形   anesthEventCtx,anesthEventX,anesthEventY,eventItemCode,graphCode,graphElements
function drawAnesthEventSpace() {
	anesthEventClear();
	for ( var i = 0; i < anesthEventGraphs.length; i++) {
		if (anesthEventGraphs[i] != undefined) {
			//graphCodes.push(anesthEventGraphs[i].eventItemCode);
			drawAnesthEventGraph(anesthEventCtx,
					anesthEventGraphs[i].anesthEventX,
					anesthEventGraphs[i].anesthEventY,
					anesthEventGraphs[i].eventItemCode,
					anesthEventGraphs[i].graphCode,
					anesthEventGraphs[i].graphElements);
		}
	}
}

//同心圆(空心圆里有一个小的实心圆)
function concentricCircles(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,8,0,360,false);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,4,0,360,false);
    anesthEventCtx.fill();
    anesthEventCtx.closePath();
}
//空心圆里有一个X
function xInCircle(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,8,0,360,false);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(32)),anesthEventY-Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(32)),anesthEventY+Math.floor( Math.sqrt(32)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(32)),anesthEventY+Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(32)),anesthEventY-Math.floor( Math.sqrt(32)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}
//空心圆里向右箭头
function  rightArrowInCircle(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,8,0,360,false);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-8,anesthEventY);
    anesthEventCtx.lineTo(anesthEventX+8,anesthEventY);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(32)),anesthEventY-Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX+8,anesthEventY);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(32)),anesthEventY+Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX+8,anesthEventY);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}
//空心圆向下箭头
function  downArrowInCircle(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,8,0,360,false);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX,anesthEventY-8);
    anesthEventCtx.lineTo(anesthEventX,anesthEventY+8);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(32)),anesthEventY-Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX,anesthEventY+8);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX+Math.floor( Math.sqrt(32)),anesthEventY-Math.floor( Math.sqrt(32)));
    anesthEventCtx.lineTo(anesthEventX,anesthEventY+8);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}
//X开始图形
function oneStartX(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(40)),anesthEventY-Math.floor( Math.sqrt(40)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(40)),anesthEventY+Math.floor( Math.sqrt(40)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(40)),anesthEventY+Math.floor( Math.sqrt(40)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(40)),anesthEventY-Math.floor( Math.sqrt(40)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}
//X结束图形
function oneEndX(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(40)),anesthEventY-Math.floor( Math.sqrt(40)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(40)),anesthEventY+Math.floor( Math.sqrt(40)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(40)),anesthEventY+Math.floor( Math.sqrt(40)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(40)),anesthEventY-Math.floor( Math.sqrt(40)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}

//双斜线   如注释的双斜线
function doublePositiveSlash(anesthEventCtx,anesthEventX,anesthEventY){
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-Math.floor( Math.sqrt(55))-3,anesthEventY+Math.floor( Math.sqrt(55)));
    anesthEventCtx.lineTo(anesthEventX+3,anesthEventY-Math.floor( Math.sqrt(55)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    anesthEventCtx.beginPath();
    anesthEventCtx.moveTo(anesthEventX-3,anesthEventY+Math.floor( Math.sqrt(55)));
    anesthEventCtx.lineTo(anesthEventX+Math.floor( Math.sqrt(55))+3,anesthEventY-Math.floor( Math.sqrt(55)));
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
}
//空心圆有数字
function circleAndNumber(anesthEventCtx,anesthEventX,anesthEventY,eventText){
    anesthEventCtx.beginPath();
    anesthEventCtx.arc(anesthEventX,anesthEventY,8,0,360,false);
    anesthEventCtx.stroke();
    anesthEventCtx.closePath();
    if(Number(eventText)>9){
       anesthEventCtx.fillText(eventText,anesthEventX-5,anesthEventY+4);
       anesthEventCtx.fillStyle="#000000";
    }else{
        anesthEventCtx.fillText(eventText,anesthEventX-3,anesthEventY+4);
        anesthEventCtx.fillStyle="#000000";
    }

}
//麻醉事件文字
function drawAnesthText(anesthEventCtx,anesthEventX,anesthEventY,anesthEventName){
	anesthEventCtx.font="12px Arial";
	anesthEventCtx.fillText(anesthEventName,anesthEventX,anesthEventY);
}


//添加麻醉事件表格
function addAnesthEventTable(){
	var url = realPath + "/anesthesiaRecord/getSmAnaesEventItems.action";
	$.post(url , function(data) {
		var json = data;
		var ae = eval('(' + json + ')');
		for ( var i = 0; i < ae.length; i++) {
			$('#anesthesiaEventSelect').append(
					"<option class=\"anesEventItem\" value=\""
							+ ae[i].code + "\">"
							+ ae[i].name + "</option>");
		}
	});
}

//添加麻醉事件  
function addAnesthEvent(){
	console.log(1);
	var anesE = $('#anesthesiaEventSelect option:selected') .val();
	var anesT = $('#anesthesiaEventTime').val();
	if(anesE ){
		if(anesT){
			var anesEventT = new Date(anesT.replace(/-/g, '/')) - new Date(operationStarttime.replace(/-/g, '/'));
		    var x = Math.floor((15 * anesEventT) / (interval * 60 * 1000));
		    var url = realPath + "/anesthesiaRecord/getAnaeEventItem.action";
			var params = { anaesCode : anesE };
				console.log(22);
			    if(graphCodes.toString().indexOf(anesE)>-1){
			        alert("已经存在，请重新添加！");
			    }else{
					$.post( url , params , function(data) {
						console.log(data+'111');
							var json = data;
							var ae = eval('(' + json + ')');
							anesthEventGraphs.push(new AnesthEventGraph(x,12,ae.code,ae.graphElements,ae.graphCode,'',ae.name));
							graphCodes.push(ae.code);
							addAnesthEventRecordTable();
						});
			        }
		}else{
			 alert("请选择时间");
		}
	}else{
		 alert("请选择麻醉事件");
	}



}

//删除麻醉事件
function deleteAnesthEvent(anesSContinued) {
	var url = realPath + "/anesthesiaRecord/deleteSmAnesEvent.action";
	if (anesthEventGraphs[selectedAnesthEventGraph] != undefined) {
		var params = {
				operationId : $('#ylwsId').val(),
				eventItemCode : anesthEventGraphs[selectedAnesthEventGraph].eventItemCode,
			};
		$.post(url, params);
		
		anesthEventGraphs.splice(selectedAnesthEventGraph, 1, undefined);
		graphCodes.splice(selectedAnesthEventGraph, 1, undefined);
		addAnesthEventRecordTable();
	}
}

//保存麻醉事件
function saveAnesthEvent(){
	var url = realPath + "/anesthesiaRecord/saveAnesthEvent.action";
	for(var i = 0 ;i < anesthEventGraphs.length; i++){
		if(anesthEventGraphs[i] != undefined){
			var params = {
				operationId : $('#ylwsId').val(),
				anesthEventX : anesthEventGraphs[i].anesthEventX,
				eventItemCode : anesthEventGraphs[i].eventItemCode,
			};
			$.post(url, params);
		}
	}
}

//获取麻醉事件
function getAnesthEvent(){
	var url = realPath + "/anesthesiaRecord/getSmAnesthesiaEventsList.action";
	var params = { operationId : $('#ylwsId').val() };
	$.post( url , params , function(data) {
			var json = data;
			var aes = eval('(' + json + ')');
			for(var i = 0 ;i < aes.length; i++){
				anesthEventGraphs.push(new AnesthEventGraph(Math.floor(aes[i].anesthEventX),12,aes[i].eventItemCode,aes[i].graphElements,aes[i].graphCode,'',aes[i].eventName));
				graphCodes.push(aes[i].eventItemCode);
				addAnesthEventRecordTable();
				console.log(anesthEventGraphs);
			}

		});
	
}


//添加记录表格
function addAnesthEventRecordTable() {
	$("#anesEventItem tbody").empty();
	var date = new Date(operationStarttime.replace(/-/g, '/')).getTime();
	for ( var i = 0; i < anesthEventGraphs.length; i++) {
		if (anesthEventGraphs[i] != undefined) {
			var aEventX = anesthEventGraphs[i].anesthEventX;
			var aEventTime = Math
					.floor((anesthEventGraphs[i].anesthEventX / 15) * interval
							* 60 * 1000);

			var aEventRow = document.createElement("tr");
			aEventRow.style.height = "25px";
			document.getElementById("anesEventItemTableTbody").appendChild(
					aEventRow);

			var aEventCell1 = document.createElement("td");
			aEventCell1.className = "aEventCellName";
			aEventCell1.innerText = anesthEventGraphs[i].eventName;
			aEventRow.appendChild(aEventCell1);

			var aEventCell2 = document.createElement("td");
			aEventCell2.className = "aEventCellTime";
			aEventCell2.innerText = millisecondToString(date + aEventTime);
			aEventRow.appendChild(aEventCell2);

		}
	}
}

//时间戳转 yyyy-MM-dd hh:mm:ss
function millisecondToString(millisecond){
	var date = new Date(millisecond);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds(); 
	return Y+M+D+h+m+s; //呀麻碟
}

function initAnesthEvent(){
	var px = [10,30,500,520];
	var eventItemCodes = ['ANAES_START_EVENT','OPERATION_START_EVENT','OPERATION_END_EVENT','ANAES_END_EVENT'];
	var graphCodes = ['oneStartX','concentricCircles','xInCircle','oneEndX'];
	var eventNames = ['麻醉开始','手术开始','手术结束','麻醉结束'];
	for(var i = 0 ;i < eventItemCodes.length; i++){
	    anesthEventGraphs.push(new AnesthEventGraph(px[i],12,eventItemCodes[i],'',graphCodes[i],'',eventNames[i]));
	    graphCodes.push(graphCodes[i]);  
	}
}




/** -----------------------------麻醉事件方法结束------------------------------------------ */

