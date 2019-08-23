	
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var realPath=localhostPaht+projectName;
	  
window.onload = function(){

	LoadTracingPointGrid();
	loadMedicineGrid();    
    document.oncontextmenu = function(e){
        e.preventDefault();
    };
    monitoringSignCanvas = document.getElementById('canvas_collect');
    monitoringSignContext = monitoringSignCanvas.getContext('2d');

    monitoringSignCanvas.onmousedown =function(e) {
    	if(e.button ==0){	
            var rect = this.getBoundingClientRect();
            var mouseX =e.clientX - rect.left;
            var mouseY =e.clientY - rect.top;
            for (var i=0; i<hollowCircles.length; i++) {
                var hollowCirclesX = hollowCircles[i].hollowCircleX;
                var hollowCirclesY = hollowCircles[i].hollowCircleY;
                if (Math.pow(mouseX-hollowCirclesX,2) + Math.pow(mouseY-hollowCirclesY,2) < Math.pow(5,2)) {
                	selectedHollowCircle = i;
                    break;
                }
            }
            for (var i=0; i<solidCircles.length; i++) {
            	var solidCirclesX = solidCircles[i].solidCircleX;
            	var solidCirclesY = solidCircles[i].solidCircleY;
            	if (Math.pow(mouseX-solidCirclesX,2) + Math.pow(mouseY-solidCirclesY,2) < Math.pow(5,2)) {
            		selectedSolidCircle = i;
            		break;
            	}
            }
            for (var i=0; i<vDownTriangles.length; i++) {
            	var vDownTrianglesX = vDownTriangles[i].vDownTriangleX;
            	var vDownTrianglesY = vDownTriangles[i].vDownTriangleY;
            	if (mouseX >=vDownTrianglesX&&mouseX<=vDownTrianglesX+10&&mouseY>=vDownTrianglesY&&mouseY<=vDownTrianglesY+10) {
            		selectedVDownTriangle = i;
            		break;
            	}
            }
            for (var i=0; i<vUpTriangles.length; i++) {
            	var vUpTrianglesX = vUpTriangles[i].vUpTriangleX;
            	var vUpTrianglesY = vUpTriangles[i].vUpTriangleY;
            	if (mouseX >=vUpTrianglesX&&mouseX<=vUpTrianglesX+10&&mouseY>=vUpTrianglesY&&mouseY<=vUpTrianglesY+10) {
            		selectedVUpTriangle = i;
            		break;
            	}
            }
    	}else if(e.button ==2){
    		
    	}
    };

    monitoringSignCanvas.onmousemove=function(e) {
        var e = window.event || e;
        var rect = this.getBoundingClientRect();
        var mouseX =e.clientX - rect.left;
        var mouseY =e.clientY - rect.top;

        if (selectedHollowCircle != undefined) {
        	var x = hollowCircles[selectedHollowCircle].hollowCircleX;
        	var hollowCirColor = hollowCircles[selectedHollowCircle].hollowCircleColor;
        	hollowCircles[selectedHollowCircle] = new HollowCircle(x, mouseY,hollowCirColor);
        }
        if (selectedSolidCircle != undefined) {
        	var x = solidCircles[selectedSolidCircle].solidCircleX;
        	var solidCirColor = solidCircles[selectedSolidCircle].solidCircleColor;
        	solidCircles[selectedSolidCircle] = new SolidCircle(x, mouseY,solidCirColor);
        }
        if (selectedVDownTriangle != undefined) {
        	var x = vDownTriangles[selectedVDownTriangle].vDownTriangleX;
        	var vDownTriColor = vDownTriangles[selectedVDownTriangle].vDownTriangleColor;
        	vDownTriangles[selectedVDownTriangle] = new VDownTriangle(x, mouseY,vDownTriColor);
        }
        if (selectedVUpTriangle != undefined) {
        	var x = vUpTriangles[selectedVUpTriangle].vUpTriangleX;
        	var vUpTriColor = vUpTriangles[selectedVUpTriangle].vUpTriangleColor;
        	vUpTriangles[selectedVUpTriangle] = new VUpTriangle(x, mouseY,vUpTriColor);
        }
    };
    //鼠标抬起事件
    monitoringSignCanvas.onmouseup =function(e) {
    	 selectedHollowCircle = undefined;
    	 selectedSolidCircle = undefined;
    	 selectedVDownTriangle = undefined;
    	 selectedVUpTriangle = undefined;
       };
    setInterval(drawMonitoringSignGraph, 100);
    
    

    document.oncontextmenu = function(e){
        e.preventDefault();
    };

    
    triangleCanvas = document.getElementById("canvas-medication");
    triangleCtx = triangleCanvas.getContext("2d");
//鼠标点击事件
 triangleCanvas.onmousedown =function(e) {
        if(e.button ==0){
            var rect = this.getBoundingClientRect();
            var mouseX =e.clientX - rect.left;
            var mouseY =e.clientY - rect.top;
            for (var i=0; i<trianglesContinued.length; i++) {
                if(trianglesContinued[i]!=undefined){
                var triangleX = trianglesContinued[i].x;
                var triangleY = trianglesContinued[i].y;
                var triangleH = trianglesContinued[i].height;
                if (mouseX >=triangleX-triangleH&&mouseX<=triangleX+triangleH&&mouseY>=triangleY-triangleH&&mouseY<=triangleY+triangleH) {
                    selectedTriangleContinued = i;
                    break;
                }
                }
            }

            for (var i=0; i<stopTriangle.length; i++) {
                if(stopTriangle[i]!=undefined){
                var triangleX = stopTriangle[i].x;
                var triangleY = stopTriangle[i].y;
                var triangleH = stopTriangle[i].height;
                if (mouseX >=triangleX-triangleH&&mouseX<=triangleX+triangleH&&mouseY>=triangleY-triangleH&&mouseY<=triangleY+triangleH) {
                    selectedStopTriangle = i;
                    console.log('点击结束三角形'+selectedStopTriangle);
                    break;
                }
                }
            }
        }else if(e.button ==2){
            //selectedTriangle = undefined;
           // selectedTriangleContinued = undefined;
            selectedStopTriangle = undefined;
            var rect = this.getBoundingClientRect();
            var mouseX =e.clientX - rect.left;
            var mouseY =e.clientY - rect.top;
            

            
            
            for (var i=0; i<trianglesContinued.length; i++) {
            	if(trianglesContinued[i]!=undefined){
            		
            		
                    var triangleX = trianglesContinued[i].x;
                    var triangleY = trianglesContinued[i].y;
                    var triangleH = trianglesContinued[i].height;
                    if (mouseX >=triangleX-triangleH&&mouseX<=triangleX+triangleH&&mouseY>=triangleY-triangleH&&mouseY<=triangleY+triangleH) {
                        $('.usedMedicineStopAndDeleted').css("top",triangleY+40);
                        $('.usedMedicineStopAndDeleted').css("left",triangleX+10);
                        $('.usedMedicineStopAndDeleted').slideDown(200);
                        selectedTriangleContinued = i;
                        selectedArrow=i;
                        break;
                    }
            		
            		
            		
            		
//                var triangleX = lines[j].end_x;
//                var triangleY = lines[j].end_y;
//                if (mouseX >=triangleX-10&&mouseX<=triangleX&&mouseY>=triangleY-5&&mouseY<=triangleY+5) {
//
//                    $('.usedMedicineStopAndDeleted').css("top",triangleY+40);
//                    $('.usedMedicineStopAndDeleted').css("left",triangleX+10);
//                    $('.usedMedicineStopAndDeleted').slideDown(200);
//                    selectedArrow = j;
//                    break;
//                }
            }
            }
        }
    };
    //鼠标移动
  triangleCanvas.onmousemove=function(e) {
        var e = window.event || e;
        var rect = this.getBoundingClientRect();
        var mouseX =e.clientX - rect.left;
        var mouseY =e.clientY - rect.top;

      for (var i=0; i<stopTriangle.length; i++) {
          if(stopTriangle[i]!=undefined){
          var triangleX = stopTriangle[i].x;
          var triangleY = stopTriangle[i].y;
          var triangleH = stopTriangle[i].height;
          if (mouseX >=triangleX&&mouseX<=triangleX+triangleH&&mouseY>=triangleY&&mouseY<=triangleY+triangleH) {
              hoveredStopTriangle = i;
              break;
          }
          }
      }
        for (var i=0; i<trianglesContinued.length; i++) {
            if(trianglesContinued[i]!=undefined){
            var triangleX = trianglesContinued[i].x;
            var triangleY = trianglesContinued[i].y;
            var triangleH = trianglesContinued[i].height;
            if (mouseX >=triangleX&&mouseX<=triangleX+triangleH&&mouseY>=triangleY&&mouseY<=triangleY+triangleH) {
                hoveredTriangleContinued = i;
                break;
            }
            }
        }

      if(selectedStopTriangle != undefined){
          var y = stopTriangle[selectedStopTriangle].y;
          var medicineText = stopTriangle[selectedStopTriangle].medicineText;
          var eventCode = stopTriangle[selectedStopTriangle].eventCode;
          var eventSign = stopTriangle[selectedStopTriangle].eventSign;
          stopTriangle[selectedStopTriangle] = new Triangle(mouseX, y,10,medicineText,eventCode,eventSign);
          if(trianglesContinued[selectedStopTriangle]!=undefined){
          	if(trianglesContinued[selectedStopTriangle].eventSign=='ME'){
              	for(var i = 0;i<mEvents.length;i++){
              		if(mEvents[i]!=undefined){
              			if(mEvents[i].m_point==selectedStopTriangle){
              				mEvents[i].m_endtime = Math.floor(mouseX);
              			}
              		}
              	}
          	}
          	
          	if(trianglesContinued[selectedStopTriangle].eventSign=='IE'){
              	for(var i = 0;i<ioEvents.length;i++){
              		if(ioEvents[i]!=undefined){
              			if(ioEvents[i].ioe_point==selectedStopTriangle){
              				ioEvents[i].ioe_endtime = Math.floor(mouseX);
              			}
              		}
              	}
          	}
          	
          	if(trianglesContinued[selectedStopTriangle].eventSign=='OE'){
              	for(var i = 0;i<ioEvents.length;i++){
              		if(ioEvents[i]!=undefined){
              			if(ioEvents[i].ioe_point==selectedStopTriangle){
              				ioEvents[i].ioe_endtime = Math.floor(mouseX);
              			}
              		}
              	}
          	}
          }
      }

      if(selectedTriangleContinued != undefined){
          var y2 = trianglesContinued[selectedTriangleContinued].y;
          var medicineText2 = trianglesContinued[selectedTriangleContinued].medicineText;
          var eventCode2 = trianglesContinued[selectedTriangleContinued].eventCode;
          var eventSign2 = trianglesContinued[selectedTriangleContinued].eventSign;
          trianglesContinued[selectedTriangleContinued] = new Triangle(mouseX, y2,10,medicineText2,eventCode2,eventSign2);
          if(trianglesContinued[selectedTriangleContinued]!=undefined){
            	if(trianglesContinued[selectedTriangleContinued].eventSign=='ME'){
                	for(var i = 0;i<mEvents.length;i++){
                		if(mEvents[i]!=undefined){
                			if(mEvents[i].m_point==selectedTriangleContinued){
                				mEvents[i].m_starttime = Math.floor(mouseX);
                			}
                		}
                	}
            	}
            	if(trianglesContinued[selectedTriangleContinued].eventSign=='IE'){
            		for(var i = 0;i<ioEvents.length;i++){
            			if(ioEvents[i]!=undefined){
            				if(ioEvents[i].ioe_point==selectedTriangleContinued){
            					ioEvents[i].ioe_starttime = Math.floor(mouseX);
            				}
            			}
            		}
            	}
            	if(trianglesContinued[selectedTriangleContinued].eventSign=='OE'){
            		for(var i = 0;i<ioEvents.length;i++){
            			if(ioEvents[i]!=undefined){
            				if(ioEvents[i].ioe_point==selectedTriangleContinued){
            					ioEvents[i].ioe_starttime = Math.floor(mouseX);
            				}
            			}
            		}
            	}
            }
      }

      hoveredTriangle = undefined;
      hoveredTriangleContinued = undefined;
      hoveredStopTriangle = undefined;

    };
    //鼠标抬起事件
 triangleCanvas.onmouseup =function(e) {
        selectedTriangle = undefined;
        selectedTriangleContinued = undefined;
       selectedStopTriangle =  undefined;

    };

    setInterval(drawTriSpace, 100);
    
    $('#canvas-medication').click(function(){
        $('.usedMedicineStopAndDeleted').slideUp(200);
    });
    
    /**
     * 麻醉事件
     * 
     * */
    document.oncontextmenu = function(e){
      e.preventDefault();
  };
    anesthEventCanvas=document.getElementById("canvas_anesthesia_event");
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
                    //drawAnesthText(anesthEventCtx,anesthEventX+8,anesthEventY,'1231313');
                    break;
                }
            	}
            }
        }else if(e.button ==2){
            selectedAnesthEventGraph = undefined;
            var rect = this.getBoundingClientRect();
            var mouseX =e.clientX - rect.left;
            var mouseY =e.clientY - rect.top;
            for (var i=0; i<anesthEventGraphs.length; i++) {
            	if(anesthEventGraphs[i]!=undefined){
            	var anesthEventX = anesthEventGraphs[i].anesthEventX;
            	var anesthEventY = anesthEventGraphs[i].anesthEventY;
                if (Math.pow(mouseX-anesthEventX,2) + Math.pow(mouseY-anesthEventY,2) < Math.pow(8,2)) {
                	
                	selectedDeleteAnesthEventGraph = i;    
                	$('.anesthesiaEventDeleteDivClass').css("top",e.clientY);
                    $('.anesthesiaEventDeleteDivClass').css("left",e.clientX+10);
                    $('.anesthesiaEventDeleteDivClass').slideDown(200);
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
            var graphCode= anesthEventGraphs[selectedAnesthEventGraph].graphCode;
            var eventText= anesthEventGraphs[selectedAnesthEventGraph].eventText;
            var eventName= anesthEventGraphs[selectedAnesthEventGraph].eventName;
            anesthEventGraphs[selectedAnesthEventGraph] = new AnesthEventGraph(mouseX,anesthEventY,eventItemCode,graphCode,eventText,eventName);
           // drawAnesthText(anesthEventCtx,anesthEventX+8,anesthEventY,'1231313');
        }

        hoveredAnesthEventGraph = undefined;
        for (var i=0; i<anesthEventGraphs.length; i++) {
        	if(anesthEventGraphs[i]!=undefined){
            var anesthEventX = anesthEventGraphs[i].anesthEventX;
            var anesthEventY = anesthEventGraphs[i].anesthEventY;
            if (Math.pow(mouseX-anesthEventX,2) + Math.pow(mouseY-anesthEventY,2) < Math.pow(8,2)) {
                hoveredAnesthEventGraph = i;
                break;
            }
        	}
        }
    };
    //鼠标松开
    anesthEventCanvas.onmouseup =function(e) {
        selectedAnesthEventGraph = undefined;
    };

    setInterval(drawAnesthEventSpace, 30);
    $('.canvasMainViewDivClass').click(function(){
        $('.anesthesiaEventDeleteDivClass').slideUp(200);
    });
    
    

};


//采集间隔全局变量
var collectIntervals = null;
//采集项编号------数据库中存放相应手术间的采集项，采集项可在页面设置并存入后台数据库中
//根据手术间编号，到数据库查出将要采集的项目，

//开始时间
var startTime = null;
var operationId = null;
var userId = null;
//开始
function startCollect(collectInterval,operationId,userId,operationStarttime){
	operationStarttime =  operationStarttime.replace(/-/g,"/");
    startTime = new Date(operationStarttime);
	collectIntervals= collectInterval;
	operationId = operationId;
	userId = userId;
	passNowDate(operationId,'03',operationStarttime);
	drawCollectInterval(collectInterval,operationStarttime);
	drawCenterCanvasTimes(collectInterval,operationStarttime);
	setStartButtonNotUse();
	var url = realPath+"/anesthesiaRecord/addSmAnaesRecord.action";
	var params ={operationId:operationId,startTime:operationStarttime,userId:userId,collectIntervals:collectIntervals};
    $.post( url, params, 
    		function addSmAnaesRecord(data){
    			if(data!=undefined){
    				alert(data);
    				 console.log("病人手术信息更新完成");
    			}
    });
    setTimeout(initAnesthEvent,2000);
	
}
//设置开始按钮不可使用
function setStartButtonNotUse(){
	  parent.document.getElementById("start").disabled=true;
	  parent.document.getElementById("start").style.background="LightSteelBlue";
}

//设置开始记录按钮不可使用
function setStartRecordButtonNotUse(){
	parent.document.getElementById("startRecord").disabled=true;
	parent.document.getElementById("startRecord").style.background="LightSteelBlue";
}
//设置打印按钮不可用
function setPrintButtonNotUse(){
	parent.document.getElementById("printAnesthesiaRecord").disabled=true;
	parent.document.getElementById("printAnesthesiaRecord").style.background="LightSteelBlue";
}
//开始记录
//参数：手术间，采集间隔
var timeInterval;
function startRecord(){
	alert("开始记录------"+collectIntervals);
    timeInterval = collectIntervals*60*1000; //时间间隔
    
    drawLineAndGraph(timeInterval); 

    setStartRecordButtonNotUse();

    
    recordInterval = setInterval(
                   function(){  
                	   drawLineAndGraph(timeInterval);  
                	   },
                	   timeInterval
                	   );
	
}

function addStartTimeToRegOpt(operationId,startTime){
	var url = realPath+"/anesthesiaRecord/updateSmRegOpt.action";
	var params ={operationId:operationId,startTime:startTime};
    $.post( url, params, 
    		function updateRegOptInfo(data){
    			if(data!=undefined){
    				 console.log("病人手术信息更新完成");
    			}
    });
}
//初始化麻醉事件
function initAnesthEvent(){
	var px = [10,30,1000,1020];
	var eventItemCodes = ['ANAES_START_EVENT','OPERATION_START_EVENT','OPERATION_END_EVENT','ANAES_END_EVENT'];
	var graphCodes = ['oneStartX','concentricCircles','xInCircle','oneEndX'];
	var eventNames = ['麻醉开始','手术开始','手术结束','麻醉结束'];
	for(var i = 0 ;i < eventItemCodes.length; i++){
//	    if(graphCodes.toString().indexOf(graphCodes[i])>-1){
//	      
//	    }else{
	    anesthEventGraphs.push(new AnesthEventGraph(px[i],12,eventItemCodes[i],graphCodes[i],'',eventNames[i]));
	    graphCodes.push(graphCodes[i]);

//	        }
	}
      
}
//结束记录
var stopTime=null;
function stopRecord(){
       clearInterval(recordInterval);
       stopTime = new Date();   //结束记录时间
       
}
//开始画
var j=0;
function drawLineAndGraph(timeInterval){

	
	
    var url = realPath+"/anesthesiaRecord/getCollectItems.action";
    var startRecordTime = new Date();
    j++;
    var params ={startTime:startTime.getTime(),startRecordTime:startRecordTime.getTime()+timeInterval,timeInterval:timeInterval,j:j};
    $.post(
    url,
    params,
    function startDraw(data){   
         var json = data;
         data1 = eval('(' + json + ')');
         if(data1.RESPRATE){
        	 hollowCircles.push(new HollowCircle(data1.RESPRATE.startX-15,data1.RESPRATE.startY,'blue'));
         }
         if(data1.PULSERATE){
        	 solidCircles.push(new SolidCircle(data1.PULSERATE.startX-15,data1.PULSERATE.startY,'blue'));
         }
         if(data1.BP_SYS){
        	 vDownTriangles.push(new VDownTriangle(data1.BP_SYS.startX-19,data1.BP_SYS.startY-4,'green')); 
         }
         if(data1.BP_DIAS){
        	 vUpTriangles.push(new VUpTriangle(data1.BP_DIAS.startX-19,data1.BP_DIAS.startY-4,'green'));    
         }
                    
    });
	
}


//向父页面传递当前日期
var passNowDate =function(operationId,state,operationStartTime){
	//获取当前日期  格式为YYYY-MM-DD
	var optStartTime =  operationStartTime.replace(/-/g,"/");
    var optStartTimes = new Date(optStartTime);
    var  nowYear = optStartTimes.getFullYear();
    var  nowMonth = optStartTimes.getMonth()+1;
    var  nowDay = optStartTimes.getDate();
    var  nowHour = optStartTimes.getHours();
    var  nowMin = optStartTimes.getMinutes()+1;
    var  nowSecond = optStartTimes.getSeconds()+1;
    $(window.parent.$("#nowDate").html(nowYear+"-"+nowMonth+"-"+nowDay)); 
    var times = nowYear+"/"+nowMonth+"/"+nowDay+","+nowHour+":"+nowMin+":"+nowSecond;
    if('03'==state){
    	addStartTimeToRegOpt(operationId,times);
    }
    if('04'==state||'05'==state){
    	startTime = optStartTimes;
    }
    
};
//画出采集界面上边的时间间隔以及写出数值
function drawCollectInterval(collectInterval,operationStartTime){
	collectInterval= Number(collectInterval);
	recordInterval= Number(collectInterval);
	collectIntervals= collectInterval;
	var optStartTime =  operationStartTime.replace(/-/g,"/");
    var optStartTimes = new Date(optStartTime);
    var div_canvasTop=document.getElementById("canvas_timeTopDiv");
    var context_timeTop = div_canvasTop.getContext("2d");
    var wg_colsTop =div_canvasTop.width/15;
    var cell_width = 90;
    
    for(var col = 0;col <= wg_colsTop; col++){
        var x = col * cell_width;
        context_timeTop.beginPath();
        context_timeTop.lineWidth=2;
        context_timeTop.strokeStyle="lightgoldenrodyellow";
        context_timeTop.moveTo(x,0);
        context_timeTop.lineTo(x,div_canvasTop.height);
        context_timeTop.fillText(optStartTimes.getHours()+":"+optStartTimes.getMinutes(),x+2,div_canvasTop.height-8);
        optStartTimes.setMinutes(optStartTimes.getMinutes() + collectInterval*6, optStartTimes.getSeconds(), 0);
        context_timeTop.stroke();      
        context_timeTop.closePath();

    }
}
function drawCenterCanvasTimes(collectInterval,operationStartTime){
	collectInterval= Number(collectInterval);
	var optStartTime =  operationStartTime.replace(/-/g,"/");
    var optStartTimes = new Date(optStartTime);
    var div_canvas=document.getElementById("canvas_timeCenterDiv");
    var context_time = div_canvas.getContext("2d");
    var wg_cols =div_canvas.width/15;
    var cell_width = 90;
    for(var col = 0;col <= wg_cols; col++){

        var x = col * cell_width;
        context_time.beginPath();
        context_time.lineWidth=2;
        context_time.strokeStyle="lightgoldenrodyellow";
        context_time.moveTo(x,0);
        context_time.lineTo(x,div_canvas.height);
        context_time.fillText(optStartTimes.getHours()+":"+optStartTimes.getMinutes(),x+2,div_canvas.height-2);
        optStartTimes.setMinutes(optStartTimes.getMinutes() + collectInterval*6, optStartTimes.getSeconds(), 0);
        context_time.stroke();
        context_time.closePath();

    }
}

var monitoringSignCanvas,monitoringSignContext;
var hollowCircles = []; //空心圆数组
var solidCircles = [];  //实心圆数组
var vDownTriangles = []; //V下数组
var vUpTriangles = [];  //V上数组
var monitoringSignGraphs = [];
var selectedHollowCircle;
var selectedSolidCircle;
var selectedVDownTriangle;
var selectedVUpTriangle;


function MonitoringSignSpace(monitoringSignItemCode,monitoringSignGraphCode,monitoringSignGraphColor){
    this.monitoringSignItemCode = monitoringSignItemCode;
    this.monitoringSignGraphCode = monitoringSignGraphCode;
    this.monitoringSignGraphColor = monitoringSignGraphColor;
}

//空心圆对象
function HollowCircle(hollowCircleX,hollowCircleY,hollowCircleColor){
	 this.hollowCircleX =hollowCircleX;
	 this.hollowCircleY =hollowCircleY;
	 this.hollowCircleColor =hollowCircleColor;
}
//实心圆对象
function SolidCircle(solidCircleX,solidCircleY,solidCircleColor){
	this.solidCircleX =solidCircleX;
	this.solidCircleY =solidCircleY;
	this.solidCircleColor =solidCircleColor;
}
//V下 对象
function VDownTriangle(vDownTriangleX, vDownTriangleY,vDownTriangleColor){
	this.vDownTriangleX =vDownTriangleX;
	this.vDownTriangleY =vDownTriangleY;
	this.vDownTriangleColor =vDownTriangleColor;
}
//V上 对象
function VUpTriangle(vUpTriangleX, vUpTriangleY,vUpTriangleColor){
	this.vUpTriangleX =vUpTriangleX;
	this.vUpTriangleY =vUpTriangleY;
	this.vUpTriangleColor =vUpTriangleColor;
}

//清除画板
function monitoringSignClear() {
    monitoringSignContext.clearRect(0, 0, monitoringSignContext.canvas.width, monitoringSignContext.canvas.height);
    LoadTracingPointGrid();
}

//空心圆  呼吸
function monitoringSignHollowCircles(monitoringSignContext,hollowCircleX,hollowCircleY,hollowCircleColor){
    monitoringSignContext.beginPath();
    monitoringSignContext.arc(hollowCircleX,hollowCircleY,5,0,360,false);
    monitoringSignContext.strokeStyle =hollowCircleColor;
    monitoringSignContext.stroke();
    monitoringSignContext.closePath();
}
//实心圆 脉搏
function monitoringSignSolidCircles(monitoringSignContext,solidCircleX,solidCircleY,solidCircleColor){
    monitoringSignContext.beginPath();
    monitoringSignContext.arc(solidCircleX,solidCircleY,6,0,360,false);
    monitoringSignContext.fillStyle=solidCircleColor;
    monitoringSignContext.fill();
    monitoringSignContext.closePath();
}
//V下 收缩压
function monitoringSignVDownTriangle(monitoringSignContext, vDownTriangleX, vDownTriangleY,vDownTriangleColor) {
    monitoringSignContext.beginPath();
    monitoringSignContext.moveTo(vDownTriangleX,vDownTriangleY);
    monitoringSignContext.lineTo(vDownTriangleX+Math.floor(Math.sqrt(400/3)/2),vDownTriangleY+10);
    monitoringSignContext.moveTo(vDownTriangleX+Math.floor(Math.sqrt(400/3)/2),vDownTriangleY+10);
    monitoringSignContext.lineTo(vDownTriangleX+Math.floor(Math.sqrt(400/3)),vDownTriangleY);
    monitoringSignContext.closePath();
    monitoringSignContext.strokeStyle = vDownTriangleColor;
    monitoringSignContext.stroke();
}

//   V上  舒张压
function monitoringSignVUpTriangle(monitoringSignVUpContext, vUpTriangleX, vUpTriangleY,vUpTriangleColor) {
    monitoringSignVUpContext.beginPath();
    monitoringSignVUpContext.moveTo(vUpTriangleX,vUpTriangleY);
    monitoringSignVUpContext.lineTo(vUpTriangleX-Math.floor(Math.sqrt(400/3)/2),vUpTriangleY+10);
    monitoringSignVUpContext.moveTo(vUpTriangleX,vUpTriangleY);
    monitoringSignVUpContext.lineTo(vUpTriangleX+Math.floor(Math.sqrt(400/3)/2),vUpTriangleY+10);
    monitoringSignVUpContext.closePath();
    monitoringSignVUpContext.strokeStyle = vUpTriangleColor;
    monitoringSignVUpContext.stroke();
}
function drawMonitoringSignGraph(){
	monitoringSignClear();
	drawMonitoringSignHollowCircleGraph();
	drawMonitoringSignSolidCircleGraph();
	drawMonitoringSignVDownTriangleGraph();
	drawMonitoringSignVUpTriangleGraph();
}
//空心圆  ○
function drawMonitoringSignHollowCircleGraph(){
	monitoringSignContext.beginPath();
    for (var i=0; i<hollowCircles.length; i++) {
        if(i>0){
        	monitoringSignContext.moveTo(hollowCircles[i-1].hollowCircleX, hollowCircles[i-1].hollowCircleY);
        	monitoringSignContext.lineTo(hollowCircles[i].hollowCircleX, hollowCircles[i].hollowCircleY);
        	//console.log(hollowCircles[i].hollowCircleX);
        }
    }
    monitoringSignContext.closePath();
    monitoringSignContext.lineWidth = 2;
    monitoringSignContext.strokeStyle =hollowCircles[0]?hollowCircles[0].hollowCircleColor:'blue';
    monitoringSignContext.stroke();
    for (var i=0; i<hollowCircles.length; i++) {
    	monitoringSignHollowCircles(monitoringSignContext,hollowCircles[i].hollowCircleX,hollowCircles[i].hollowCircleY,hollowCircles[i].hollowCircleColor);
    } 
}
//实心圆  ●
function drawMonitoringSignSolidCircleGraph(){
	monitoringSignContext.beginPath();
    for (var i=0; i<solidCircles.length; i++) {
        if(i>0){
        	monitoringSignContext.moveTo(solidCircles[i-1].solidCircleX, solidCircles[i-1].solidCircleY);
        	monitoringSignContext.lineTo(solidCircles[i].solidCircleX, solidCircles[i].solidCircleY);
        }
    }
    monitoringSignContext.closePath();
    monitoringSignContext.lineWidth = 2;
    monitoringSignContext.strokeStyle =solidCircles[0]?solidCircles[0].solidCircleColor:'#000000';
    monitoringSignContext.stroke();
    for (var i=0; i<solidCircles.length; i++) {
    	monitoringSignSolidCircles(monitoringSignContext,solidCircles[i].solidCircleX,solidCircles[i].solidCircleY,solidCircles[i].solidCircleColor);
    }
}
//  ∨
function drawMonitoringSignVDownTriangleGraph(){
	monitoringSignContext.beginPath();
    for (var i=0; i<vDownTriangles.length; i++) {
        if(i>0){
        	monitoringSignContext.moveTo(vDownTriangles[i-1].vDownTriangleX+4, vDownTriangles[i-1].vDownTriangleY+10);
        	monitoringSignContext.lineTo(vDownTriangles[i].vDownTriangleX+4, vDownTriangles[i].vDownTriangleY+10);
        }
    }
    monitoringSignContext.closePath();
    monitoringSignContext.lineWidth = 2;
    monitoringSignContext.strokeStyle =vDownTriangles[0]?vDownTriangles[0].vDownTriangleColor:'blue';
    monitoringSignContext.stroke();
    for (var i=0; i<vDownTriangles.length; i++) {
    	monitoringSignVDownTriangle(monitoringSignContext,vDownTriangles[i].vDownTriangleX,vDownTriangles[i].vDownTriangleY,vDownTriangles[i].vDownTriangleColor);
    }
}
//  ∧
function drawMonitoringSignVUpTriangleGraph(){
	monitoringSignContext.beginPath();
    for (var i=0; i<vUpTriangles.length; i++) {
        if(i>0){
        	monitoringSignContext.moveTo(vUpTriangles[i-1].vUpTriangleX+4, vUpTriangles[i-1].vUpTriangleY);
        	monitoringSignContext.lineTo(vUpTriangles[i].vUpTriangleX+4, vUpTriangles[i].vUpTriangleY);
        }
    }
    monitoringSignContext.closePath();
    monitoringSignContext.lineWidth = 2;
    monitoringSignContext.strokeStyle =vUpTriangles[0]?vUpTriangles[0].vUpTriangleColor:'blue';
    monitoringSignContext.stroke();
    for (var i=0; i<vUpTriangles.length; i++) {
    	monitoringSignVUpTriangle(monitoringSignContext,vUpTriangles[i].vUpTriangleX+4,vUpTriangles[i].vUpTriangleY,vUpTriangles[i].vUpTriangleColor);
    }
}

//保存描点
function saveMonitoringSign(operationId,userId){
	alert('222222');
	var hollowCircle = [];
	var solidCircle = [];
	var downTriangle = [];
	var upTriangle = [];
	for (var i=0; i<hollowCircles.length; i++){
		hollowCircle.push(hollowCircles[i].hollowCircleX+'--'+hollowCircles[i].hollowCircleY);
	}
	for (var i=0; i<solidCircles.length; i++){
		solidCircle.push(solidCircles[i].solidCircleX+'--'+solidCircles[i].solidCircleY);
	}
	for (var i=0; i<vDownTriangles.length; i++){
		downTriangle.push(vDownTriangles[i].vDownTriangleX+'--'+vDownTriangles[i].vDownTriangleY);
	}
	for (var i=0; i<vUpTriangles.length; i++){
		upTriangle.push(vUpTriangles[i].vUpTriangleX+'--'+vUpTriangles[i].vUpTriangleY);
	}
	 var params ={operationId:operationId,userId:userId,hollowCircles:hollowCircle.join(","),
			 solidCircles:solidCircle.join(","),downTriangles:downTriangle.join(","),upTriangles:upTriangle.join(",")};
	 $.post( 
		realPath+"/anesthesiaRecord/saveMonitoSign.action", 
		params, 
		function ioEventData(data){
			if(data!=undefined){
			}
        });
	
	
}
//获取描点
function getSmWaveData(operationId){
	var params ={operationId:operationId};
	
	 $.post( 
	    		realPath+"/anesthesiaRecord/getSmWaveDataList.action", 
	    		params, 
	    		function ioEventData(data){
	    			if(data!=undefined){
	    			      var json = data;
	    			      smWaveData = eval('(' + json + ')');
	    			      for(var i=0; i<smWaveData.length;i++){
	    			          if(smWaveData[i].Resprate)
	    			         	 hollowCircles.push(new HollowCircle((smWaveData[i].moniSignX*1),smWaveData[i].Resprate*1,'blue'));
	    			          if(smWaveData[i].Pulserate)
	    			         	 solidCircles.push(new SolidCircle((smWaveData[i].moniSignX*1),smWaveData[i].Pulserate*1,'blue'));
	    			          if(smWaveData[i].BpSys)
	    			         	 vDownTriangles.push(new VDownTriangle((smWaveData[i].moniSignX*1)-4,(smWaveData[i].BpSys*1)-4,'green')); 
	    			          if(smWaveData[i].BpDias)
	    			         	 vUpTriangles.push(new VUpTriangle((smWaveData[i].moniSignX*1)-4,(smWaveData[i].BpDias*1)-4,'green'));    
	    			      }
	    			}
	    });
}

function LoadTracingPointGrid(){

    var a_canvas = document.getElementById("canvas_collect");
    var context  = a_canvas.getContext("2d");
    //动态传
    var wg_cols =a_canvas.width/15;
    var wg_rows = 30;
    var cell_heigth = 30;
    var cell_width = 90;




    //画 列
    for(var col = 0;col <= wg_cols; col++){
        var x = col * cell_width;
        context.beginPath();
        context.lineWidth=2;
        context.strokeStyle = "#000000";
        context.moveTo(x,0);
        context.lineTo(x,a_canvas.height);
        context.stroke();
        context.closePath();

    }
    //画 行
    for(var row = 0;row <= wg_rows; row++){
        var y = row*cell_heigth;
        context.beginPath();
        context.lineWidth=2;
        context.strokeStyle = "#000000";
        context.moveTo(0,y);
        context.lineTo(a_canvas.width,y);
        context.stroke();
        context.closePath();
    }

    //画 列
    for(var col = 0;col <= wg_cols; col++){
        var x = col * cell_width/6;
        context.beginPath();
        context.lineWidth=0.5;
        context.strokeStyle="#808080";
        context.moveTo(x,0);
        context.lineTo(x,a_canvas.height);
        context.stroke();
        context.closePath();

    }
    //画 行
    for(var row = 0;row <= wg_rows; row++){
        var y = row*cell_heigth/2;
        context.beginPath();
        context.lineWidth=0.5;
        context.strokeStyle="#808080";
        context.moveTo(0,y);
        context.lineTo(a_canvas.width,y);
        context.stroke();
        context.closePath();
    }

}


var triangleCanvas,triangleCtx;
var triangles = [];//三角形数组
var trianglesContinued = [];//三角形数组
var selectedTriangleContinued; //被选中
var hoveredTriangleContinued;
var selectedTriangle; //被选中
var hoveredTriangle;
var selectedArrow;
var selectedStopTriangle; //被选中
var hoveredStopTriangle;
var lines = [];
var arrows = [];
var lineX = [];
var stopTriangle = [];
var ioEvents = [];
var mEvents = [];
//三角形对象
function Triangle(x, y, height,medicineText,eventCode,eventSign){
    this.x = x;
    this.y = y;
    this.height = height;
    this.medicineText = medicineText;
    this.eventCode = eventCode;
    this.eventSign = eventSign;

}
//出入量对象
function IOEvent(ioe_operationId,ioe_itemId,ioe_name,ioe_dosage,ioe_dosageUnit,ioe_passageWay,ioe_starttime,ioe_endtime,
		ioe_spec,ioe_firm,ioe_minPackageUnit,ioe_amount,ioe_price,ioe_charge,ioe_x,ioe_y,ioe_sign,ioe_point,ioe_ended){
	this.ioe_operationId = ioe_operationId;
	this.ioe_itemId = ioe_itemId;
	this.ioe_name = ioe_name;
	this.ioe_dosage = ioe_dosage;
	this.ioe_dosageUnit = ioe_dosageUnit;
	this.ioe_passageWay = ioe_passageWay;
	this.ioe_starttime = ioe_starttime;
	this.ioe_endtime = ioe_endtime;
	this.ioe_spec = ioe_spec;
	this.ioe_firm = ioe_firm;
	this.ioe_minPackageUnit = ioe_minPackageUnit;
	this.ioe_amount = ioe_amount;
	this.ioe_price = ioe_price;
	this.ioe_charge = ioe_charge;
	this.ioe_x = ioe_x;
	this.ioe_y = ioe_y;
	this.ioe_sign = ioe_sign;
	this.ioe_point = ioe_point;
	this.ioe_ended = ioe_ended;
}
//麻醉用药对象
function AnesMedicine(m_operationId,m_cardinalEventId,m_spec,m_dosage,
		m_dosageUnit,m_thickness,m_thicknessUnit,m_flow,m_flowUnit,m_takewayCode,
		m_diluent,m_diluentQuant,m_durable,m_starttime,m_endtime,m_ended,m_isContinued,
		m_type,m_phase,m_purpose,m_abduction,m_maintain,m_times,m_showOption,
		m_roughType,m_reason,m_usemedicineEventId,m_x,m_y,m_sign,m_point,m_medicineCode,m_name,m_firm){
	this.m_operationId = m_operationId;
	this.m_cardinalEventId = m_cardinalEventId;
	this.m_spec = m_spec;
	this.m_dosage = m_dosage;
	this.m_dosageUnit = m_dosageUnit;
	this.m_thickness = m_thickness;
	this.m_thicknessUnit = m_thicknessUnit;
	this.m_flow = m_flow;
	this.m_flowUnit = m_flowUnit;
	this.m_takewayCode = m_takewayCode;
	this.m_diluent = m_diluent;
	this.m_diluentQuant = m_diluentQuant;
	this.m_durable = m_durable;
	this.m_starttime = m_starttime;
	this.m_endtime = m_endtime;
	this.m_ended = m_ended;
	this.m_isContinued = m_isContinued;
	this.m_type = m_type;
	this.m_phase = m_phase;
	this.m_purpose = m_purpose;
	this.m_abduction = m_abduction;
	this.m_maintain = m_maintain;
	this.m_times = m_times;
	this.m_showOption = m_showOption;
	this.m_roughType = m_roughType;
	this.m_reason = m_reason;
	this.m_usemedicineEventId = m_usemedicineEventId;
	this.m_x = m_x;
	this.m_y = m_y;
	this.m_sign = m_sign;
	this.m_point = m_point;
	this.m_medicineCode = m_medicineCode;
	this.m_name = m_name;
	this.m_firm = m_firm;
	
}
//线对象
function Line(start_x,start_y,end_x,end_y){
    this.start_x = start_x;
    this.start_y = start_y;
    this.end_x = end_x;
    this.end_y = end_y;
}
//箭头对象
function Arrow(startX,startY){
    this.startX = startX;
    this.startY = startY;
}
//清屏
function triangleClear() {
    triangleCtx.clearRect(0, 0, triangleCtx.canvas.width, triangleCtx.canvas.height);
}
//画三角形
function drawTriangle(triangleCtx, x, y, height,medicineText) {
    triangleCtx.beginPath();
    triangleCtx.moveTo(x,y);
    triangleCtx.lineTo(x-height,y+height);
    triangleCtx.lineTo(x+height,y+height);
    triangleCtx.closePath();
    triangleCtx.fill();
    triangleCtx.font="10px Arial";
    triangleCtx.fillText(medicineText,x+(height*3/4),y+(height*3/4));
}
//划线
function drawLine(triangleCtx,startX,startY,endX,endY){
    triangleCtx.beginPath();
    triangleCtx.fillStyle="#000000";
    triangleCtx.moveTo(startX,startY);
    triangleCtx.lineTo(endX,endY);
    triangleCtx.closePath();
    triangleCtx.stroke();
}
//画箭头
function drawArrow(triangleCtx,startX,startY){
    triangleCtx.beginPath();
    triangleCtx.fillStyle="#000000";
    triangleCtx.moveTo(startX-10,startY-5);
    triangleCtx.lineTo(startX,startY);
    triangleCtx.moveTo(startX-10,startY+5);
    triangleCtx.lineTo(startX,startY);
    triangleCtx.closePath();
    triangleCtx.stroke();
}
var medicinesCount = 1;
var totalLong =[];
//var oneLong = 15/(medicinesCount*600);
function drawTriSpace(){
    triangleClear();
    loadMedicineGrid();
    var medAllNum =0;
    var inNums = 170;
    var outNums = 200;
    for (var i=0; i<trianglesContinued.length; i++) {
        if(trianglesContinued[i]!=undefined&&lines[i]!=undefined){
        	if(trianglesContinued[i].eventSign=='ME'){
        		var medNums = 5;
        		for(var j = 0;j<mEvents.length;j++){
        			if(mEvents[j]!=undefined){
        				if(mEvents[j].m_sign=='ME'&&mEvents[j].m_point==i){
        			       if(mEvents[j].m_durable=='1'){
        				      if(mEvents[j].m_ended=='1'){
        				    	  lines[i].end_y=medNums;
        				    	  lines[i].start_x=mEvents[j].m_starttime;
        				    	  lines[i].start_y=medNums;
        				    	  trianglesContinued[i].y = medNums;
        				    	  stopTriangle[i].y = medNums;
        					    drawTriangle(triangleCtx, mEvents[j].m_starttime, medNums, 10,trianglesContinued[i].medicineText);
        					    drawLine(triangleCtx,mEvents[j].m_starttime, medNums,mEvents[j].m_endtime,medNums);
        					    drawTriangle(triangleCtx,mEvents[j].m_endtime, medNums, 10,''); 	
        				      }else{
        				    	  lines[i].end_y=medNums;
        				    	  lines[i].start_x=mEvents[j].m_starttime;
        				    	  lines[i].start_y=medNums;
        				    	  trianglesContinued[i].y = medNums;
        					      drawTriangle(triangleCtx, mEvents[j].m_starttime, medNums, 10,trianglesContinued[i].medicineText);
        		                  drawLine(triangleCtx,mEvents[j].m_starttime, medNums,lines[i].end_x,medNums);
        		                  drawArrow(triangleCtx,lines[i].end_x,medNums);
        		                    if(lines[i].end_x<totalLong[i]+trianglesContinued[i].x){
        		                         lines[i].end_x+=oneLong;
        		                      }
        				}
        				 
        			}
        			if('0'==mEvents[j].m_durable){
        			   trianglesContinued[i].y = medNums;
        			   drawTriangle(triangleCtx, mEvents[j].m_starttime, medNums, 10,trianglesContinued[i].medicineText);
        			}
        		}
        				medNums+=15;
        			}
        		}
        		
        	}
        	
        	var inEventSpeed=1/(40*medicinesCount);
        	if(trianglesContinued[i].eventSign=='IE'){
        		for(var j = 0;j<ioEvents.length;j++){
        			if(ioEvents[j]!=undefined){
        				if(ioEvents[j].ioe_sign=='IE'&&ioEvents[j].ioe_point==i){
        					if(inNums<=185){
        						if(ioEvents[j].ioe_ended=='1'){
        							lines[i].end_y=inNums;
        							lines[i].start_x=ioEvents[j].ioe_starttime;
        							lines[i].start_y=inNums;
        							trianglesContinued[i].y = inNums;
        							stopTriangle[i].y = inNums;
        							drawTriangle(triangleCtx, ioEvents[j].ioe_starttime, inNums, 10,inNums);
        							drawTriangle(triangleCtx,ioEvents[j].ioe_endtime, inNums, 10,''); 	
        							drawLine(triangleCtx,ioEvents[j].ioe_starttime, inNums,ioEvents[j].ioe_endtime,inNums);
        							inNums+=15;
        						}else{
        							lines[i].end_y=inNums;
        							lines[i].start_x=ioEvents[j].ioe_starttime;
        							lines[i].start_y=inNums;
        							trianglesContinued[i].y = inNums;
        							drawTriangle(triangleCtx, ioEvents[j].ioe_starttime, inNums, 10,trianglesContinued[i].medicineText);
        							drawLine(triangleCtx,ioEvents[j].ioe_starttime, inNums,lines[i].end_x,inNums);
        							drawArrow(triangleCtx,lines[i].end_x,inNums);
        							
        					        if(lines[i].end_x<totalLong[i]+ioEvents[j].ioe_starttime){
        					            lines[i].end_x+=inEventSpeed;
        					        }
        					        inNums+=15;
        						}
        						
        					}else{
        						//console.log('备注---------------多了');
        					}
        				 
        			
        		}
//        				if(inNums<185){
//        					
//        					inNums+=15;
//        				}else{
//        					//console.log('备注');
//        				}
        			}
        		}
        		
        	}
        	if(trianglesContinued[i].eventSign=='OE'){
        		for(var j = 0;j<ioEvents.length;j++){
        			if(ioEvents[j]!=undefined){
        				if(ioEvents[j].ioe_sign=='OE'&&ioEvents[j].ioe_point==i){
        					if(outNums<=215){
        						if(ioEvents[j].ioe_ended=='1'){
        							lines[i].end_y=outNums;
        							lines[i].start_x=ioEvents[j].ioe_starttime;
        							lines[i].start_y=outNums;
        							trianglesContinued[i].y = outNums;
        							stopTriangle[i].y = outNums;
        							drawTriangle(triangleCtx, ioEvents[j].ioe_starttime, outNums, 10,trianglesContinued[i].medicineText);
        							drawTriangle(triangleCtx,ioEvents[j].ioe_endtime, outNums, 10,''); 	
        							drawLine(triangleCtx,ioEvents[j].ioe_starttime, outNums,ioEvents[j].ioe_endtime,outNums);
        							outNums+=15;
        						}else{
        							lines[i].end_y=outNums;
        							lines[i].start_x=ioEvents[j].ioe_starttime;
        							lines[i].start_y=outNums;
        							trianglesContinued[i].y = outNums;
        							drawTriangle(triangleCtx, ioEvents[j].ioe_starttime, outNums, 10,trianglesContinued[i].medicineText);
        							drawLine(triangleCtx,ioEvents[j].ioe_starttime, outNums,lines[i].end_x,outNums);
        							drawArrow(triangleCtx,lines[i].end_x,outNums);
        					        if(lines[i].end_x<totalLong[i]+trianglesContinued[i].x){
        				                lines[i].end_x+=oneLong;
        				              }
        					        outNums+=15;
        						}
        						
        					}else{
        						//console.log('备注---------------多了');
        					}
        				 
        				}
        				
        		
//        				if(outNums<215){
//        					
//        					outNums+=15;
//        				}else{
//        					//console.log('备注');
//        				}
        				
        			}
        		}
        		
        	}
        	

//        if(lines[i].end_x<totalLong[i]+trianglesContinued[i].x){
//            lines[i].end_x+=oneLong;
//        }
        }
    }
}



//加载用药网格
function loadMedicineGrid(){
	var b_canvas = document.getElementById("canvas-medication");
    var ctx  = b_canvas.getContext("2d");
    //动态传
    var wg_cols = b_canvas.width/15;
    var wg_rows = 30;
    var cell_heigth = 30;
    var cell_width = 90;



    //画 列
    for(var col = 0;col <= wg_cols; col++){
        var x = col * cell_width;
        ctx.beginPath();
        ctx.lineWidth=2;
        ctx.fillStyle = "#000000";
        ctx.moveTo(x,0);
        ctx.lineTo(x,b_canvas.height);
        ctx.stroke();
        ctx.closePath();

    }
    //画 行
    for(var row = 0;row <= wg_rows; row++){
        var y = row*cell_heigth;
        ctx.beginPath();
        ctx.lineWidth=2;
        ctx.fillStyle = "#000000";
        ctx.moveTo(0,y);
        ctx.lineTo(b_canvas.width,y);
        ctx.stroke();
        ctx.closePath();
    }

    //画 列
    for(var col = 0;col <= wg_cols; col++){
        var x = col * cell_width/6;
        ctx.beginPath();
        ctx.lineWidth=0.5;
        ctx.strokeStyle="#000000";
        ctx.moveTo(x,0);
        ctx.lineTo(x,b_canvas.height);
        ctx.stroke();
        ctx.closePath();

    }
    //画 行
    for(var row = 0;row <= wg_rows; row++){
        var y = row*cell_heigth/2;
        ctx.beginPath();
        ctx.lineWidth=0.5;
        ctx.strokeStyle="#000000";
        ctx.moveTo(0,y);
        ctx.lineTo(b_canvas.width,y);
        ctx.stroke();
        ctx.closePath();
    }

}



//添加麻醉用药
var totalLong =[];
var oneLong = ((15/(medicinesCount*60))/1000)*100;
var totals = [];
var speeds = [];
function addMedicines(medicinesCount,medicineName,medicineSpec,medicineDose,medicineDoseUnit,medicineFirm,medicineCharge,
		 medicineThickness,medicineThicknessUnit,medicineFlow,medicineFlowUnit,medicalTakeWay,medicineDiluentQuant,medicineDurabled,medicineStarttime,medReason,medicineCode){
	var nowTimes = new Date();
	var optId = parent.document.getElementById("id").value;
	    medicineStarttime = medicineStarttime.replace(/-/g,'/');
	var medStarttime = new Date(medicineStarttime)-startTime;
	var xp = Math.floor((15*medStarttime)/(collectIntervals*60*1000));
	var startY = medicinesCount*15+5;
	var texts = medicineDose+medicineDoseUnit;
	var meventNum = 0;
	 if(medicineDurabled.checked){
	        if(!medicineDose){
	            totals.push("");
	            speeds.push(Number(medicineSpeed));
	            totalLong.push(100000);

	            lines.push(new Line(xp,startY,xp,startY));
	            trianglesContinued.push(new Triangle(xp,startY,10,texts,medicineCode,'ME'));
		        arrows.push(new Arrow(xp,startY));
		        stopTriangle.push(undefined);
	            mEvents.push(new AnesMedicine(optId,'',medicineSpec,medicineDose,medicineDoseUnit,medicineThickness,medicineThicknessUnit,medicineFlow,medicineFlowUnit,medicalTakeWay,
	            		'',medicineDiluentQuant,'1',xp,'','','','','','','','','','','','','',xp,startY,'ME',trianglesContinued.length-1,medicineCode,medicineName,medicineFirm));
	          }else {
	            totals.push(Number(medicineDose));
	            speeds.push(Number(medicineFlow));
	            totalLong.push((Number(medicineDose)/Number(medicineFlow))*(15/(medicinesCount*60)));
	            lines.push(new Line(xp,startY,xp,startY));
		        arrows.push(new Arrow(xp,startY));
		        stopTriangle.push(undefined);
	            trianglesContinued.push(new Triangle(xp,startY,10,texts,medicineCode,'ME'));
	            mEvents.push(new AnesMedicine(optId,'',medicineSpec,medicineDose,medicineDoseUnit,medicineThickness,medicineThicknessUnit,medicineFlow,medicineFlowUnit,medicalTakeWay,
	            		'',medicineDiluentQuant,'1',xp,'','','','','','','','','','','','','',xp,startY,'ME',trianglesContinued.length-1,medicineCode,medicineName,medicineFirm));
	            }


	   }else {
	            lines.push(new Line(0,0,0,0));
		        arrows.push(new Arrow(0,0));
		        stopTriangle.push(undefined);
		        trianglesContinued.push(new Triangle(xp,startY,10,texts,medicineCode,'ME'));
                mEvents.push(new AnesMedicine(optId,'',medicineSpec,medicineDose,medicineDoseUnit,medicineThickness,medicineThicknessUnit,medicineFlow,medicineFlowUnit,medicalTakeWay,
            		    '',medicineDiluentQuant,'0',xp,'','','','','','','','','','','','','',xp,startY,'ME',trianglesContinued.length-1,medicineCode,medicineName,medicineFirm));
	    } 
	 for(var i = 0;i<mEvents.length;i++){
		 if(mEvents[i]!=undefined){
			 if(mEvents[i]){
				 var mEventName = mEvents[i].m_name;
				 var medEventName = mEventName.replace(/(^\s*)|(\s*$)/g, "");
				 var mEventDosage  = mEvents[i].m_dosage;
				 var mEventDosageUnit = mEvents[i].m_dosageUnit;
				 var mEventDivId = 'anestheticMedicine'+meventNum;
				 var mEventDivTotalId = 'anestheticMedicineTotal'+meventNum;
				 if(meventNum<11){
				    parent.document.getElementById(mEventDivId).innerHTML=medEventName.substring(0,medEventName.length-1);
				    parent.document.getElementById(mEventDivTotalId).innerHTML=mEventDosage+" "+mEventDosageUnit;
				 }else{
					 alert(mEventName+"-----"+mEventDosage+mEventDosageUnit);
				 }
				    meventNum++;
			 }
		 }
	 }
	 
	 
	 
}


//停止用药
function stopMedicine(){
	var stopSelectedArrowPoint = selectedArrow;
    var startX =  lines[stopSelectedArrowPoint].end_x;
    var startY =  lines[stopSelectedArrowPoint].end_y;
    var eventCode =  trianglesContinued[stopSelectedArrowPoint].eventCode;
    if(trianglesContinued[stopSelectedArrowPoint]!=undefined){
    	if(trianglesContinued[stopSelectedArrowPoint].eventSign=='ME'){
        	for(var i = 0;i<mEvents.length;i++){
        		if(mEvents[i]!=undefined){
        			if(mEvents[i].m_durable=='1'&&mEvents[i].m_point==stopSelectedArrowPoint){
        				mEvents[i].m_ended = '1';
        				mEvents[i].m_endtime = Math.floor(startX);
        				totalLong[stopSelectedArrowPoint] = Math.floor(lines[stopSelectedArrowPoint].end_x - trianglesContinued[stopSelectedArrowPoint].x);
        				arrows.splice(stopSelectedArrowPoint,1,undefined);
        				stopTriangle[stopSelectedArrowPoint] = new Triangle(startX, startY,10,"",eventCode,'ME');
        			}
        		}
        	}
        	$('.usedMedicineStopAndDeleted').slideUp(200);
    	}
    	if(trianglesContinued[stopSelectedArrowPoint].eventSign=='IE'){
    		for(var i = 0;i<ioEvents.length;i++){
    			if(ioEvents[i]!=undefined){
    				if(ioEvents[i].ioe_point==stopSelectedArrowPoint){
    					ioEvents[i].ioe_ended = '1';
    					ioEvents[i].ioe_endtime = Math.floor(startX);
    					totalLong[stopSelectedArrowPoint] = Math.floor(lines[stopSelectedArrowPoint].end_x - trianglesContinued[stopSelectedArrowPoint].x);
    					arrows.splice(stopSelectedArrowPoint,1,undefined);
    					stopTriangle[stopSelectedArrowPoint] = new Triangle(startX, startY,10,"",eventCode,'IE');
    				}
    			}
    		}
    		$('.usedMedicineStopAndDeleted').slideUp(200);
    	}
    	if(trianglesContinued[stopSelectedArrowPoint].eventSign=='OE'){
    		for(var i = 0;i<ioEvents.length;i++){
    			if(ioEvents[i]!=undefined){
    				if(ioEvents[i].ioe_point==stopSelectedArrowPoint){
    					ioEvents[i].ioe_ended = '1';
    					ioEvents[i].ioe_endtime = Math.floor(startX);
    					totalLong[stopSelectedArrowPoint] = Math.floor(lines[stopSelectedArrowPoint].end_x - trianglesContinued[stopSelectedArrowPoint].x);
    					arrows.splice(stopSelectedArrowPoint,1,undefined);
    					stopTriangle[stopSelectedArrowPoint] = new Triangle(startX, startY,10,"",eventCode,'ME');
    				}
    			}
    		}
    		$('.usedMedicineStopAndDeleted').slideUp(200);
    	}
    }
}
//删除
function deletedMedicine(){
	var selectedArrowPoint = selectedArrow;
    stopTriangle.splice(selectedArrowPoint,1,undefined);
    totalLong.splice(selectedArrowPoint,1,undefined);
    lines.splice(selectedArrowPoint,1,undefined);
    //删除麻醉用药
  if(trianglesContinued[selectedArrowPoint]!=undefined){
    if(trianglesContinued[selectedArrowPoint].eventSign=='ME'){	
    	for(var i = 0;i<mEvents.length;i++){
    		if(mEvents[i]!=undefined){
    			if(mEvents[i].m_durable=='1'&&mEvents[i].m_point==selectedArrowPoint){
    				trianglesContinued.splice(selectedArrowPoint,1,undefined);
    				mEvents.splice(i,1,undefined);
    				
    			}
    		}
    	}
    	var deleteMEventNumW = 0;
    	var deleteMEventNumN = 0;
    	for(var i = 0;i<mEvents.length;i++){
    		var mEventDivIdw = 'anestheticMedicine'+deleteMEventNumW;
    		var mEventDivTotalIdw = 'anestheticMedicineTotal'+deleteMEventNumW;
    		parent.document.getElementById(mEventDivIdw).innerHTML='';
    		parent.document.getElementById(mEventDivTotalIdw).innerHTML='';
    		if(mEvents[i]!=undefined){
    			var mEventName = mEvents[i].m_name;
    			var medEventName = mEventName.replace(/(^\s*)|(\s*$)/g, "");
    			var mEventDosage  = mEvents[i].m_dosage;
    			var mEventDosageUnit = mEvents[i].m_dosageUnit;
    			var mEventDivId = 'anestheticMedicine'+deleteMEventNumN;
    			var mEventDivTotalId = 'anestheticMedicineTotal'+deleteMEventNumN;
    			if(deleteMEventNumN<11){
    				parent.document.getElementById(mEventDivId).innerHTML=medEventName.substring(0,medEventName.length-1);
    				parent.document.getElementById(mEventDivTotalId).innerHTML=mEventDosage+" "+mEventDosageUnit;
    			}else{
    				alert(mEventName+"-----"+mEventDosage+mEventDosageUnit);
    			}
    			deleteMEventNumN++;
    		}
    		deleteMEventNumW++;
    		
    	}
    	$('.usedMedicineStopAndDeleted').slideUp(200);
      }
    }
    //删除入量
  if(trianglesContinued[selectedArrowPoint]!=undefined){
    if(trianglesContinued[selectedArrowPoint].eventSign=='IE'){
    	for(var i = 0;i<ioEvents.length;i++){
    		if(ioEvents[i]!=undefined){
    			if(ioEvents[i].ioe_point==selectedArrowPoint&&ioEvents[i].ioe_sign=='IE'){
    				trianglesContinued.splice(selectedArrowPoint,1,undefined);
    				ioEvents.splice(i,1,undefined);
    				
    			}
    		}
    	}
    	var deleteIEventNumW = 0;
    	var deleteIEventNumN = 0;
    	for(var i = 0;i<ioEvents.length;i++){
    		if(deleteIEventNumW<2){
    			var iEventDivIdw = 'liquidsInDivId'+deleteIEventNumW;
    			var iEventDivTotalIdw = 'liquidsInDivTotal'+deleteIEventNumW;
    			parent.document.getElementById(iEventDivIdw).innerHTML='';
    			parent.document.getElementById(iEventDivTotalIdw).innerHTML='';			
    			deleteIEventNumW++;
    		}
    		if(ioEvents[i]!=undefined){
    			if(ioEvents[i].ioe_sign=='IE'){
    			var iEventName = ioEvents[i].ioe_name;
			    var iEventDosage = ioEvents[i].ioe_dosage;
			    var iEventDosageUnit = ioEvents[i].ioe_dosageUnit;
    			var iEventDivId = 'liquidsInDivId'+deleteIEventNumN;
    			var iEventDivTotalId = 'liquidsInDivTotal'+deleteIEventNumN;
    			if(deleteIEventNumN<2){
    				parent.document.getElementById(iEventDivId).innerHTML=iEventName;
    				parent.document.getElementById(iEventDivTotalId).innerHTML=iEventDosage+" "+iEventDosageUnit;
    			}else{
    				alert(iEventName+"-----"+iEventDosage+iEventDosageUnit);
    			}
    			deleteIEventNumN++;
    		 }
    		}
    		
    	}
    	$('.usedMedicineStopAndDeleted').slideUp(200);
    }
  }
    //删除出量
  if(trianglesContinued[selectedArrowPoint]!=undefined){
    if(trianglesContinued[selectedArrowPoint].eventSign=='OE'){
    	for(var i = 0;i<ioEvents.length;i++){
    		if(ioEvents[i]!=undefined){
    			if(ioEvents[i].ioe_point==selectedArrowPoint&&ioEvents[i].ioe_sign=='OE'){
    				trianglesContinued.splice(selectedArrowPoint,1,undefined);
    				ioEvents.splice(i,1,undefined);
    				
    			}
    		}
    	}
    	var deleteOEventNumW = 0;
    	var deleteOEventNumN = 0;
    	for(var i = 0;i<ioEvents.length;i++){
    		if(deleteOEventNumW<2){
    			var oEventDivIdw = 'liquidsOutDivId'+deleteOEventNumW;
    			var oEventDivTotalIdw = 'liquidsOutDivTotal'+deleteOEventNumW;
    			parent.document.getElementById(oEventDivIdw).innerHTML='';
    			parent.document.getElementById(oEventDivTotalIdw).innerHTML='';
    			deleteOEventNumW++;
    		}
    		if(ioEvents[i]!=undefined){
    			if(ioEvents[i].ioe_sign=='OE'){
    			var oEventName = ioEvents[i].ioe_name;
			    var oEventDosage = ioEvents[i].ioe_dosage;
			    var oEventDosageUnit = ioEvents[i].ioe_dosageUnit;
    			var oEventDivId = 'liquidsOutDivId'+deleteOEventNumN;
    			var oEventDivTotalId = 'liquidsOutDivTotal'+deleteOEventNumN;
    			if(deleteOEventNumN<2){
    				parent.document.getElementById(oEventDivId).innerHTML=oEventName;
    				parent.document.getElementById(oEventDivTotalId).innerHTML=oEventDosage+" "+oEventDosageUnit;
    			}else{
    				alert(oEventName+"-----"+oEventDosage+oEventDosageUnit);
    			}
    			deleteOEventNumN++;
    		}
    		}
    		
    	}
    	$('.usedMedicineStopAndDeleted').slideUp(200);
    }
  }
}

//刷新


//添加出量
var liquidsOutAdd = function(medicinesCount,liquidsOutName,liquidsOutSpeed,liquidsOutSpeedUnit,liquidsOutId,liquidsOutDateId,outNum){
	var optId = parent.document.getElementById("id").value;
	
	liquidsOutDateId = liquidsOutDateId.replace(/-/g,'/');
	var outStarttime = new Date(liquidsOutDateId)-startTime;
	var outXp = Math.floor((15*outStarttime)/(collectIntervals*60*1000));

	var startY = 200+15*outNum;
	var texts = liquidsOutSpeed+liquidsOutSpeedUnit;
	var anestheticMedicineTotals = "anestheticMedicineTotal"+medicinesCount;
	 if(true){
	            totals.push(Number(liquidsOutSpeed));
	            speeds.push(1);
	            totalLong.push((Number(liquidsOutSpeed)/1)*(15/(medicinesCount*60)));
	            lines.push(new Line(outXp,startY,outXp,startY));
	            trianglesContinued.push(new Triangle(outXp,startY,10,texts,liquidsOutId,'OE'));
	      
	            ioEvents.push(new IOEvent(optId,liquidsOutId,liquidsOutName,liquidsOutSpeed,liquidsOutSpeedUnit,'',outXp,'','','','','','','',outXp,startY,'OE',trianglesContinued.length-1,'0'));          
	            arrows.push(new Arrow(outXp,startY));
	            stopTriangle.push(undefined);
	    }
	 var outNum = 0;
	 for(var i = 0;i<ioEvents.length;i++){
		 if(ioEvents[i]!=undefined){
		    if('OE'==ioEvents[i].ioe_sign){
			    var oeventName = ioEvents[i].ioe_name;
			    var oeventDosage = ioEvents[i].ioe_dosage;
			    var oeventDosageUnit = ioEvents[i].ioe_dosageUnit;
			    var outDivId = 'liquidsOutDivId'+outNum;
			    var outDivTotalId = 'liquidsOutDivTotal'+outNum;
			    if(outNum<2){
				    parent.document.getElementById(outDivId).innerHTML=oeventName;
				    parent.document.getElementById(outDivTotalId).innerHTML=oeventDosage+" "+oeventDosageUnit;
			    }else{
				    alert(oeventName+"-----"+oeventDosage+oeventDosageUnit);
			      }
			    outNum++;
			 
		   }
		 }
	 }
};
//添加入量
/** 	 
 * @param {Object} chosenArray	 
 * @memberOf {TypeName} 	 
 * @return {TypeName} 	
 */
var liquidsInAdd = function(medicinesCount,liquidsInInputName,
		liquidsInInputItemId,liquidsInInputDosage,liquidsInInputDosageUnit,liquidsInInputStartTime,
		liquidsInInputPassageway,liquidsInInputFirm,liquidsInInputSpec,liquidsInInputAmount,liquidsInInputMinPackageUnit,liquidsInInputPrice,liquidsInInputCharge,inNum){
	
	var optId = parent.document.getElementById("id").value;
	
	liquidsInInputStartTime = liquidsInInputStartTime.replace(/-/g,'/');
	var inStarttime = new Date(liquidsInInputStartTime)-startTime;
	var inXp = Math.floor((15*inStarttime)/(collectIntervals*60*1000));
	
	var startY = 170+15*inNum;
	var texts = liquidsInInputDosage+liquidsInInputDosageUnit;
	//var anestheticMedicineTotals = "anestheticMedicineTotal"+medicinesCount;
	 if(true){
         totals.push(Number(liquidsInInputDosage));
         speeds.push(1);
         //totalLong.push((Number(liquidsInInputDosage)/1)*(15/(medicinesCount*60)));
         totalLong.push((15*Number(liquidsInInputDosage))/collectIntervals);
         
         lines.push(new Line(inXp,startY,inXp,startY));
         trianglesContinued.push(new Triangle(inXp,startY,10,texts,liquidsInInputItemId,'IE'));
   
         ioEvents.push(new IOEvent(optId,liquidsInInputItemId,liquidsInInputName,liquidsInInputDosage,
        		 liquidsInInputDosageUnit,liquidsInInputPassageway,inXp,'',
        		 liquidsInInputSpec,liquidsInInputFirm,liquidsInInputMinPackageUnit,liquidsInInputAmount,liquidsInInputPrice,liquidsInInputCharge,inXp,startY,'IE',trianglesContinued.length-1,'0'));
         
         arrows.push(new Arrow(inXp,startY));
         stopTriangle.push(undefined);
 }
	 var inNum1 = 0;
	 for(var i = 0;i<ioEvents.length;i++){
		 if(ioEvents[i]!=undefined){
		    if('IE'==ioEvents[i].ioe_sign){
			    var oeventName = ioEvents[i].ioe_name;
			    var oeventDosage = ioEvents[i].ioe_dosage;
			    var oeventDosageUnit = ioEvents[i].ioe_dosageUnit;
			    var inDivId = 'liquidsInDivId'+inNum1;
			    var inDivTotalId = 'liquidsInDivTotal'+inNum1;
			    if(inNum1<2){
				    parent.document.getElementById(inDivId).innerHTML=oeventName;
				    parent.document.getElementById(inDivTotalId).innerHTML=oeventDosage+" "+oeventDosageUnit;
			    }else{
				    alert(oeventName+"-----"+oeventDosage+oeventDosageUnit);
			      }
			    inNum1++;
			 
		    }
		 }
	 }
};

   /**
    *   麻醉事件
    * 
    */


var anesthEventCanvas,anesthEventCtx;
var bgColor = '#3CB371';
var anesthEventGraphs = [];
var graphCodes = [];//麻醉事件图形Code数组
var selectedAnesthEventGraph;
var hoveredAnesthEventGraph;
var selectedDeleteAnesthEventGraph;

//清除麻醉事件画板
function anesthEventClear() {
    anesthEventCtx.clearRect(0, 0, anesthEventCtx.canvas.width, anesthEventCtx.canvas.height);
}

//根据图形编号graphCode选择将要画的图形
function drawAnesthEventGraph(anesthEventCtx,anesthEventX,anesthEventY,eventItemCode,graphCode){
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
        circleAndNumber(anesthEventCtx,anesthEventX,anesthEventY,eventText);
    }
}

//麻醉事件图形对象
function AnesthEventGraph(anesthEventX,anesthEventY,eventItemCode,graphCode,eventText,eventName){
    this.anesthEventX = anesthEventX;
    this.anesthEventY = anesthEventY;
    this.eventItemCode = eventItemCode;
    this.graphCode = graphCode;
    this.eventText = eventText;
    this.eventName = eventName;
}

//在麻醉事件画板上绘制所有的麻醉事件图形
function drawAnesthEventSpace() {
    anesthEventClear();
    for (var i=0; i<anesthEventGraphs.length; i++) {
    	if(anesthEventGraphs[i]!=undefined){	
        graphCodes.push(anesthEventGraphs[i].graphCode);
        drawAnesthEventGraph(anesthEventCtx, anesthEventGraphs[i].anesthEventX, anesthEventGraphs[i].anesthEventY,
        		anesthEventGraphs[i].eventItemCode, anesthEventGraphs[i].graphCode, anesthEventGraphs[i].eventText);
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


//添加麻醉事件
function addAnesthEvent(anesthesiaEventInputDate,anesthEventY,eventItemCode,graphCode,anaesEventItemsGraphElements,anaesEventItemsName){
    anesthesiaEventInputDate = anesthesiaEventInputDate.replace(/-/g,"/");
    var anesthesiaEventInputTime = new Date(anesthesiaEventInputDate);
    var x = Math.floor( (15/(collectIntervals*60*1000))*(anesthesiaEventInputTime - startTime) );
    if(graphCodes.toString().indexOf(graphCode)>-1){
        alert("已经存在，请重新添加！");
    }else{
    anesthEventGraphs.push(new AnesthEventGraph(x,anesthEventY,eventItemCode,graphCode,'',anaesEventItemsName));
    graphCodes.push(graphCode);

        }

}

//加载麻醉事件
function getAnesthEvent(operationId){
	var params = {operationId:operationId};
    $.post(  realPath+"/anesthesiaRecord/getSmAnesthesiaEventsList.action", 
		params, 
		function anesEventDate(data){
			if(data!=undefined){
		         var json = data;
		         aneEventsListData = eval('(' + json + ')');
		         for(var i = 0;i < aneEventsListData.length; i++){
		    	        anesthEventGraphs.push(new AnesthEventGraph(Number(aneEventsListData[i].xPoint),12,aneEventsListData[i].code,aneEventsListData[i].graphCode,'',''));
		    	        graphCodes.push(aneEventsListData[i].graphCode);
		         }
			}
        });	
}

// 删除麻醉事件
function deleteAnesthesiaEvent(){
	 var optId = parent.document.getElementById("id").value;
     var params ={operationId:optId,anaesEventItemsCode:anesthEventGraphs[selectedDeleteAnesthEventGraph].eventItemCode};
	 $.post(realPath+"/anesthesiaRecord/deleteSmAnesEvent.action", 
	    	params, 
	    	function anesthesiaEventFormList(data){
	    		if(data!=undefined){
	    			alert(data);
	    		}
	   });
	   anesthEventGraphs.splice(selectedDeleteAnesthEventGraph,1,undefined);
	   graphCodes.splice(selectedDeleteAnesthEventGraph,1,undefined);
	   $('.anesthesiaEventDeleteDivClass').slideUp(200);
}

//保存麻醉事件
function saveAnesthEvent(operationId,userId){
	for(var i = 0;i<anesthEventGraphs.length;i++){
		if(anesthEventGraphs[i]!=undefined){
			var params = {collectIntervals:collectIntervals,startTime:startTime.getTime(),operationId:operationId,userId:userId,
					     anaesEventItemsCode:anesthEventGraphs[i].eventItemCode,anaesEventItemsX:anesthEventGraphs[i].anesthEventX};
			 $.post( 
			    	realPath+"/anesthesiaRecord/anesthesiaEventSave.action", 
			    	params, 
			    	function anesthesiaEventFormList(data){
			    		if(data!=undefined){
			    		}
			 }); 
		}
	}
	setTimeout(updateAnaesRecordSomething,3000);
}
//修改麻醉记录单
function updateAnaesRecordSomething(){
	var optId = parent.document.getElementById("id").value;
	var params = {operationId:optId};
	    $.post( 
		    	realPath+"/anesthesiaRecord/updateAnaesRecordSomething.action", 
		    	params, 
		    	function formList(data){
		    		if(data!=undefined){
		    		}
		 }); 
}





//麻醉事件添加到表格
function addAnesthEventToTable(){
	for(var i = 0;i<anesthEventGraphs.length;i++){
		
	}
}


//保存麻醉用药
function saveMedEvent(operationId,userId){
	for(var i = 0;i<mEvents.length;i++){
		if(mEvents[i]!=undefined){
			var params ={collectIntervals:collectIntervals,operationId:operationId,userId:userId,
					m_cardinalEventId:mEvents[i].m_cardinalEventId,m_spec:mEvents[i].m_spec,
					m_dosage:mEvents[i].m_dosage,m_dosageUnit:mEvents[i].m_dosageUnit,
					m_thickness:mEvents[i].m_thickness,m_thicknessUnit:mEvents[i].m_thicknessUnit,
					m_flow:mEvents[i].m_flow,m_flowUnit:mEvents[i].m_flowUnit,
					m_takewayCode:mEvents[i].m_takewayCode,m_diluent:mEvents[i].m_diluent,
					m_diluentQuant:mEvents[i].m_diluentQuant,m_durable:mEvents[i].m_durable,
					m_starttime:mEvents[i].m_starttime,m_endtime:mEvents[i].m_endtime,
					m_ended:mEvents[i].m_ended,m_isContinued:mEvents[i].m_isContinued,
					m_type:mEvents[i].m_type,m_phase:mEvents[i].m_phase,
					m_purpose:mEvents[i].m_purpose,m_abduction:mEvents[i].m_abduction,
					m_maintain:mEvents[i].m_maintain,m_times:mEvents[i].m_times,
					m_showOption:mEvents[i].m_showOption,m_roughType:mEvents[i].m_roughType,
					m_reason:mEvents[i].m_reason,m_usemedicineEventId:mEvents[i].m_usemedicineEventId,
					m_medicineCode:mEvents[i].m_medicineCode ,m_medicineName:mEvents[i].m_name,m_medicineFirm:mEvents[i].m_firm};
			 $.post( 
			    		realPath+"/anesthesiaRecord/saveMedicalEvent.action", 
			    		params, 
			    		function anesthesiaEventFormList(data){
//			    			if(data!=undefined){
//			    			}
			    });
		}
	}
}

//加载麻醉用药
function getMedEvent(operationId){
	     var params ={operationId:operationId};
	     $.post( 
	    		realPath+"/anesthesiaRecord/getMedicalEventList.action", 
	    		params, 
	    		function ioEventData(data){
	    			if(data!=undefined){
	    		    console.log(data);//..............
	   		         var json = data;
	   		         medEventListData = eval('(' + json + ')');
	   		         for(var i=0; i<medEventListData.length;i++){
	   		        	 if('1'==medEventListData[i].medDurable){
	   		        		 if('1'==medEventListData[i].medEnded){
	   		        			 totals.push(Number(medEventListData[i].medDosage));
	   		        			 speeds.push(Number(medEventListData[i].medFlow));
	   		        			 totalLong.push((Number(medEventListData[i].medDosage)/1)*(15/(medicinesCount*60)));
  		        			 
	   		        			 lines.push(new Line(Number(medEventListData[i].medStartTime),0,Number(medEventListData[i].medEndTime),0));
	   		        			 trianglesContinued.push(new Triangle(Number(medEventListData[i].medStartTime),0,
	   		        					 10,medEventListData[i].medDosage+medEventListData[i].medDosageUnit,medEventListData[i].medMedicineCode,'ME'));
	   		        			 arrows.push(undefined);
	   		        			 stopTriangle.push(new Triangle(Number(medEventListData[i].medEndTime), 0,10,'',medEventListData[i].medMedicineCode,'ME'));
	   		        			 mEvents.push(new AnesMedicine(operationId,'',medEventListData[i].medSpec,medEventListData[i].medDosage,medEventListData[i].medDosageUnit,
	   		        					medEventListData[i].medThickness,medEventListData[i].medThicknessUnit,
	   		        					medEventListData[i].medFlow,medEventListData[i].medFlowUnit,medEventListData[i].medTakewayCode,
	   		        					 '',medEventListData[i].medDiluentQuant,'1',Number(medEventListData[i].medStartTime),Number(medEventListData[i].medEndTime),'1',
	   		        					 '','','','','','','','','','','',Number(medEventListData[i].medStartTime),0,'ME',trianglesContinued.length-1,
	   		        					medEventListData[i].medMedicineCode,medEventListData[i].medMedicineName,medEventListData[i].medMedicineFirm));   		        			
	   		        		 }else{
	   		        			 totals.push(Number(medEventListData[i].medDosage));
	   		        			 speeds.push(Number(medEventListData[i].medFlow));
	   		        			 totalLong.push((Number(medEventListData[i].medDosage)/1)*(15/(medicinesCount*60)));
	   		        			 
	   		        			 lines.push(new Line(Number(medEventListData[i].medStartTime),0,Number(medEventListData[i].medEndTime),0));
	   		        			 trianglesContinued.push(new Triangle(Number(medEventListData[i].medStartTime),0,
	   		        					 10,medEventListData[i].medDosage+medEventListData[i].medDosageUnit,medEventListData[i].medMedicineCode,'ME'));
	   		        			 arrows.push(new Arrow(Number(medEventListData[i].medEndTime),0));
	   		        			 stopTriangle.push(undefined);
	   		        			 mEvents.push(new AnesMedicine(operationId,'',medEventListData[i].medSpec,medEventListData[i].medDosage,medEventListData[i].medDosageUnit,
	   		        					medEventListData[i].medThickness,medEventListData[i].medThicknessUnit,
	   		        					medEventListData[i].medFlow,medEventListData[i].medFlowUnit,medEventListData[i].medTakewayCode,
	   		        					 '',medEventListData[i].medDiluentQuant,'1',Number(medEventListData[i].medStartTime),
	   		        					'','0','','','','','','','','','','','',Number(medEventListData[i].medStartTime),
	   		        					 0,'ME',trianglesContinued.length-1,
	   		        					medEventListData[i].medMedicineCode,medEventListData[i].medMedicineName,medEventListData[i].medMedicineFirm));
	   		        		 }
	   		        	 }else{


   		        			 totals.push(undefined);
   		        			 speeds.push(undefined);
   		        			 totalLong.push(undefined);
		        			 
   		        			 
   		        			 
   		  	                 lines.push(new Line(0,0,0,0));
   				             arrows.push(new Arrow(0,0));
   				             stopTriangle.push(undefined);
   		        			 trianglesContinued.push(new Triangle(Number(medEventListData[i].medStartTime),0,
   		        					 10,medEventListData[i].medDosage+medEventListData[i].medDosageUnit,medEventListData[i].medMedicineCode,'ME'));
   		        			 mEvents.push(new AnesMedicine(operationId,'',medEventListData[i].medSpec,medEventListData[i].medDosage,medEventListData[i].medDosageUnit,
   		        					medEventListData[i].medThickness,medEventListData[i].medThicknessUnit,
   		        					medEventListData[i].medFlow,medEventListData[i].medFlowUnit,medEventListData[i].medTakewayCode,
   		        					 '',medEventListData[i].medDiluentQuant,'0',Number(medEventListData[i].medStartTime),'','0',
   		        					 '','','','','','','','','','','',Number(medEventListData[i].medStartTime),0,'ME',trianglesContinued.length-1,
   		        					medEventListData[i].medMedicineCode,medEventListData[i].medMedicineName,medEventListData[i].medMedicineFirm)); 
	   		        	 } 
	   		         }
	   		         
	   		         
	   		      var meventNum = 0;
	   		 	 for(var i = 0;i<mEvents.length;i++){
	   				 if(mEvents[i]!=undefined){
	   					 if(mEvents[i]){
	   						 var mEventName = mEvents[i].m_name;
	   						// var medEventName = mEventName.replace(/(^\s*)|(\s*$)/g, "");
	   						 var mEventDosage  = mEvents[i].m_dosage;
	   						 var mEventDosageUnit = mEvents[i].m_dosageUnit;
	   						 var mEventDivId = 'anestheticMedicine'+meventNum;
	   						 var mEventDivTotalId = 'anestheticMedicineTotal'+meventNum;
	   						 if(meventNum<11){
	   						    parent.document.getElementById(mEventDivId).innerHTML=mEventName;
	   						    parent.document.getElementById(mEventDivTotalId).innerHTML=mEventDosage+" "+mEventDosageUnit;
	   						 }else{
	   							 alert(mEventName+"-----"+mEventDosage+mEventDosageUnit);
	   						 }
	   						    meventNum++;
	   					 }
	   				 }
	   			 }
	   		         
	    			}
	    });
}

//保存麻醉用药
/** 	 
 * @param {Object} chosenArray	 
 * @memberOf {TypeName} 	 
 * @return {TypeName} 	
 */
function saveIOEvent(operationId,userId){
	for(var i = 0;i<ioEvents.length;i++){
		if(ioEvents[i]!=undefined){
			var params ={collectIntervals:collectIntervals,operationId:operationId,userId:userId,
					ioe_itemId:ioEvents[i].ioe_itemId,ioe_name:ioEvents[i].ioe_name,ioe_dosage:ioEvents[i].ioe_dosage,
					ioe_dosageUnit:ioEvents[i].ioe_dosageUnit,ioe_passageWay:ioEvents[i].ioe_passageWay,ioe_starttime:ioEvents[i].ioe_starttime,ioe_endtime:ioEvents[i].ioe_endtime,
					ioe_spec:ioEvents[i].ioe_spec,ioe_firm:ioEvents[i].ioe_firm,ioe_minPackageUnit:ioEvents[i].ioe_minPackageUnit,
					ioe_amount:ioEvents[i].ioe_amount,ioe_price:ioEvents[i].ioe_price,ioe_charge:ioEvents[i].ioe_charge,
					ioe_ended:ioEvents[i].ioe_ended ,ioe_sign:ioEvents[i].ioe_sign};
			 $.post( 
			    		realPath+"/anesthesiaRecord/smIoEventSaveAndUpdate.action", 
			    		params, 
			    		function ioEventData(data){
			    			if(data!=undefined){
			    			}
			    });
		}
	}
}

//加载出入量
function getIOEvent(operationId){
	    var params ={operationId:operationId};
	    $.post( 
	    	realPath+"/anesthesiaRecord/getSmIoEventList.action", 
	    	params, 
	    	function ioEventData(data){
	    		if(data!=undefined){
	    		//console.log(data);//..............
		   		      var json = data;
		   		      ioEventListData = eval('(' + json + ')');
		   		         
		   		      var inNumG = 0;
		   		      var outNum = 0;
		   		      for(var i=0; i<ioEventListData.length;i++){
		   		    	  if(ioEventListData[i].ioeSign=='IE'){
		   		    		  if(ioEventListData[i].ioeEnded=='1'){
		   		    			  totals.push(Number(ioEventListData[i].ioeDosage));
		   		    			  speeds.push(1);
		   		    			  totalLong.push((Number(ioEventListData[i].ioeDosage)/1)*(15/(medicinesCount*60)));
		   		    			  lines.push(new Line(Number(ioEventListData[i].ioeStartTime),0,Number(ioEventListData[i].ioeEndTime),0));
		   		    			  trianglesContinued.push(new Triangle(Number(ioEventListData[i].ioeStartTime),0,10,ioEventListData[i].ioeDosage+ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioeItemId,'IE'));
		   		    			  ioEvents.push(new IOEvent(operationId,ioEventListData[i].ioeItemId,ioEventListData[i].ioeName,ioEventListData[i].ioeDosage,
		   		    					                    ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioePassageWay,Number(ioEventListData[i].ioeStartTime),Number(ioEventListData[i].ioeEndTime),
		   		    					                    ioEventListData[i].ioeSpec,ioEventListData[i].ioeFirm,ioEventListData[i].ioeMinPackageUnit,
		   		    					                    ioEventListData[i].ioeAmount,ioEventListData[i].ioePrice,ioEventListData[i].ioeCharge,Number(ioEventListData[i].ioeStartTime),Number(ioEventListData[i].ioeEndTime),
		   		    					                    'IE',trianglesContinued.length-1,'1'));
		   		    			  arrows.push(undefined);
		   		    			  stopTriangle.push(new Triangle(Number(ioEventListData[i].ioeEndTime), 0,10,ioEventListData[i].ioeDosage+ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioeItemId,'IE'));
		   		    			  
		   					      var inDivId = 'liquidsInDivId'+inNumG;
		   					      var inDivTotalId = 'liquidsInDivTotal'+inNumG;
		   					      if(inNumG<2){
		   						     parent.document.getElementById(inDivId).innerHTML=ioEventListData[i].ioeName;
		   						     parent.document.getElementById(inDivTotalId).innerHTML=ioEventListData[i].ioeDosage+' '+ioEventListData[i].ioeDosageUnit;
		   					     }else{
		   						     alert(ioEventListData[i].ioeName+"-----"+ioEventListData[i].ioeDosage+' '+ioEventListData[i].ioeDosageUnit);
		   					       }
		   					      inNumG++;
		   		    		 }
		   		    	}
		   		    	  if(ioEventListData[i].ioeSign=='OE'){
		   		    		  if(ioEventListData[i].ioeEnded=='1'){
		   		    			  totals.push(Number(ioEventListData[i].ioeDosage));
		   		    			  speeds.push(1);
		   		    			  totalLong.push((Number(ioEventListData[i].ioeDosage)/1)*(15/(medicinesCount*60)));
		   		    			  lines.push(new Line(Number(ioEventListData[i].ioeStartTime),0,Number(ioEventListData[i].ioeEndTime),0));
		   		    			  trianglesContinued.push(new Triangle(Number(ioEventListData[i].ioeStartTime),0,10,ioEventListData[i].ioeDosage+ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioeItemId,'OE'));
		   		    			  ioEvents.push(new IOEvent(operationId,ioEventListData[i].ioeItemId,ioEventListData[i].ioeName,ioEventListData[i].ioeDosage,
		   		    					  ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioePassageWay,Number(ioEventListData[i].ioeStartTime),Number(ioEventListData[i].ioeEndTime),
		   		    					  ioEventListData[i].ioeSpec,ioEventListData[i].ioeFirm,ioEventListData[i].ioeMinPackageUnit,
		   		    					  ioEventListData[i].ioeAmount,ioEventListData[i].ioePrice,ioEventListData[i].ioeCharge,Number(ioEventListData[i].ioeStartTime),Number(ioEventListData[i].ioeEndTime),
		   		    					  'OE',trianglesContinued.length-1,'1'));
		   		    			  arrows.push(undefined);
		   		    			  stopTriangle.push(new Triangle(Number(ioEventListData[i].ioeEndTime), 0,10,ioEventListData[i].ioeDosage+ioEventListData[i].ioeDosageUnit,ioEventListData[i].ioeItemId,'OE'));
		   		    			  
		   					      var outDivId = 'liquidsOutDivId'+outNum;
		   					      var outDivTotalId = 'liquidsOutDivTotal'+outNum;
		   		    			  if(outNum<2){
		   		    				  parent.document.getElementById(outDivId).innerHTML=ioEventListData[i].ioeName;
		   		    				  parent.document.getElementById(outDivTotalId).innerHTML=ioEventListData[i].ioeDosage+' '+ioEventListData[i].ioeDosageUnit;
		   		    			  }else{
		   		    				  alert(ioEventListData[i].ioeName+"-----"+ioEventListData[i].ioeDosage+' '+ioEventListData[i].ioeDosageUnit);
		   		    			  }
		   		    			outNum++;
		   		    		  }
		   		    	  }
		   		    	  
		   		    	  
		   		    	  
		   		  }     
	    	}
	   });
}











