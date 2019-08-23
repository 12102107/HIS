
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);  
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var realPath=localhostPaht+projectName;

  var anestheticMedicineId;
     var medicinesName;
        jQuery(document).ready(function($) {
            $('.theme-login').click(function(){         
                anestheticMedicineId =   $(this).attr("id");
                $('.theme-popover-mask').fadeIn(100);
                $('.theme-popover').slideDown(200);
            });
            $('.close').click(function(){
                $('.theme-popover-mask').fadeOut(100);
                $('.theme-popover').slideUp(200);
            });
            $(".close1").click(function(){
                $('.theme-popover-mask').fadeOut(100);
                $('.theme-popover').slideUp(200);
            });
            
            $("#medicineCharge02Id").click(function(){
                $("#medicineDiluentQuant").attr("disabled",false);
            });
            $("#medicineCharge01Id").click(function(){
                $("#medicineDiluentQuant").attr("disabled",true);
            });
            
            
            //麻醉人员弹出框 
            $('#anesthetistersTitleDivId').click(function(){         
                $('#anesthetistersPopupDivId').slideDown(100);
                $('.theme-popover-mask').slideDown(200);
                getAnesthetisters1();
            });
            $('.anesthetistersPopupClose').click(function(){
                $('#anesthetistersPopupDivId').slideUp(100);
                $('.theme-popover-mask').slideUp(200);
            });
            //点击选择麻醉人员
          $(".anesthetistersPopupLeftClass").live("click",function(){
        	    //alert($(this).text());
        	  $("#anesthetistersPopupHiddenId").val($(this).text());
        	  
           	    $(this).css('background-color','#72C5FD');
        	    $('.anesthetistersPopupLeftClass').not(this).css('background-color','#FFFFFF');
            });
          
          //点击选择手术人员
          $(".operatorNameCell").live("click",function(){
        	    //alert($(this).text());
        	  $("#operatersListDivTableIdHidden1").val($(this).text());
           	    $(this).css('background-color','#72C5FD');
        	    $('.operatorNameCell').not(this).css('background-color','#FFFFFF');
            });
          
          //删除手术人员
          $('.operatersPopupDeleteButtonDivClass').live("click",function(){
        	  var anesthetistersPopupHiddenId= $("#operatersListDivTableIdHidden1").val().split("(");
        	  var HiddenName=anesthetistersPopupHiddenId[0];
        	  var operationId = document.getElementById("id").value;
        	  var params = {HiddenName:HiddenName,operationId:operationId};
        	  if (HiddenName!="") {
        		  //alert(HiddenName+operationId);
        		  $.post( realPath+"/anesthesiaRecord/deleteAnesthetistersByoperationName1.action",params,     
                          	function operaters(data){        		   
        			  if (data!="") {
        				  getOperators();
        				  getOperators1();
        				  
        				}
                 });
			}		
          });
          
          //删除麻醉人员
          $('.anesthetistersPopupButton2Class').live("click",function(){
        	  var anesthetistersPopupHiddenId= $("#anesthetistersPopupHiddenId").val().split("(");
        	  var HiddenName=anesthetistersPopupHiddenId[0];
        	  var operationId = document.getElementById("id").value;
        	  var params = {HiddenName:HiddenName,operationId:operationId};
        	  if (HiddenName!="") {
        		 // alert(HiddenName);
        		  $.post( realPath+"/anesthesiaRecord/deleteAnesthetistersByoperationName.action",params,     
                          	function anesthetistersPopupLeftList(data){        		   
        			  if (data!="") {
        
                 			   getAnesthetisters1();
                			   getAnesthetisters();
        				}
                 });
			}		
          });
          //点击医师选择
          $(".yishi").live("click",function(){
        	  //alert($(this).val());
        	    var yishiRole=$(this).text();
        	    var params = {yishiRole:yishiRole};
        	    $.post( realPath+"/anesthesiaRecord/getAnesthetistersByRole.action", 
               		 params,     
               		function(data){
        	    	if(data!="x") {
        	    		$("#yishiSelect").html(data); 
        	    	}
        	    });
            });
          
          //点击手术医师选择
          $(".yishi3").live("click",function(){
        	  //alert($(this).val());
        	    var yishiRole=$(this).text();
        	    var params = {yishiRole:yishiRole};
        	    $.post( realPath+"/anesthesiaRecord/getAnesthetistersByRole1.action", 
               		 params,     
               		function(data){
        	    	if(data!="x") {
        	    		$("#yishiSelect3").html(data); 
        	    	}
        	    });
            });
          
          //点击护士选择
          $(".yishi2").live("click",function(){
        	  //alert($(this).val());
        	    var yishiRole=$(this).text();
        	    var params = {yishiRole:yishiRole};
        	    $.post( realPath+"/anesthesiaRecord/getAnesthetistersByRole2.action", 
               		 params,     
               		function(data){
        	    	if(data!="x") {
        	    		$("#yishiSelect2").html(data); 
        	    	}
        	    });
            });
          
          //添加麻醉人员
          $(".anesthetistersPopupButton1Class").live("click",function(){
        	  var yishiName=$(".xl:selected").text();
        	  var yishiRole=$(".yishi:selected").text();
        	  var operationId = document.getElementById("id").value;
        	  var params = {yishiRole:yishiRole,yishiName:yishiName,operationId:operationId};
        	   $.post( realPath+"/anesthesiaRecord/addAnesthetistersByRole.action", 
                 		 params,     
                 function(data){
        		   if (data!="") {
        			  
        			   getAnesthetisters1();
        			   getAnesthetisters();
				}
          	    });
            });
          
          
          //获取麻醉人员
            function getAnesthetisters1(){
            	$("#anesthetistersPopupLeftDivTableId tbody").empty();
                var operationId = document.getElementById("id").value;
                var params = {operationId:operationId};
                $.post( realPath+"/anesthesiaRecord/getAnesthetistersListByoperationId.action", 
                		 params,     
                         	function anesthetistersPopupLeftList(data){
                                var json = data;  
                                anesthetistersPopupLeftData = eval('(' + json + ')');  
                                anesthetistersPopupLeftTable(anesthetistersPopupLeftData);
                });
            }
            
          //麻醉人员动态创建表格     
            var anesthetistersPopupLeftTable = function(anesthetistersPopupLeftData){
            	var anesthetist1 = anesthetistersPopupLeftData.anesthetist;
            	var circuanesthetist1 = anesthetistersPopupLeftData.circuanesthetist;
            	var anaesassistant1 = anesthetistersPopupLeftData.anaesassistant; 
            	if(''!=anesthetist1){
            		var anesthetistRow1 = document.createElement("tr");
            		document.getElementById("anesthetistersPopupLeftDivTableTbodyId").appendChild(anesthetistRow1);
            		
     /*       		var anesthetistCodeCell1 = document.createElement("td");
            		anesthetistCodeCell1.style.width = "40px";
            		anesthetistCodeCell1.className = "anesthetistersPopupClass";
            		anesthetistRow1.appendChild(anesthetistCodeCell1); 
            		
            	    var operationEventIdInput = document.createElement("input");
                       operationEventIdInput.type="radio";
                       operationEventIdInput.className="operationEventId";
                       operationEventIdInput.value=id;
                       anesthetistCodeCell1.appendChild(operationEventIdInput);
            		*/
            		var anesthetistNameCell1 = document.createElement("td");
            		anesthetistNameCell1.style.width = "160px";
            		anesthetistNameCell1.className = "anesthetistersPopupLeftClass";
            		anesthetistNameCell1.innerText = anesthetist1+' (麻师)';
            		anesthetistRow1.appendChild(anesthetistNameCell1); 
            		
            	}
                   if(''!=circuanesthetist1){
                	   var circuanesthetistRow1 = document.createElement("tr");
                	   document.getElementById("anesthetistersPopupLeftDivTableTbodyId").appendChild(circuanesthetistRow1);
                	   var circuanesthetistNameCell1 = document.createElement("td");
                	   circuanesthetistNameCell1.style.width = "200px";
                	   circuanesthetistNameCell1.className = "anesthetistersPopupLeftClass";
                	   circuanesthetistNameCell1.innerText = circuanesthetist1+' (巡台)';
                	   circuanesthetistRow1.appendChild(circuanesthetistNameCell1);    
                   }     
                     if(''!=anaesassistant1){
                    	 var anaesassistantRow1 = document.createElement("tr");
                    	 document.getElementById("anesthetistersPopupLeftDivTableTbodyId").appendChild(anaesassistantRow1);
                    	 var anaesassistantNameCell1 = document.createElement("td");
                    	 anaesassistantNameCell1.style.width = "200px";
                    	 anaesassistantNameCell1.className = "anesthetistersPopupLeftClass";
                    	 anaesassistantNameCell1.innerText = anaesassistant1+' (灌注)';
                    	 anaesassistantRow1.appendChild(anaesassistantNameCell1);  	 
                     }       
                        
              };
            
            //手术人员弹出框 
            $('#operatersTitleDivId').click(function(){         
            	$('#operatersPopupDivId').slideDown(100);
            	$('.theme-popover-mask').slideDown(200);
            	getOperators1();
            });
            $('.operatersPopupCloseDivClass').click(function(){
            	$('#operatersPopupDivId').slideUp(100);
            	$('.theme-popover-mask').slideUp(200);
            });
            $('.operatersPopupCloseButtonDivClass').click(function(){
            	$('#operatersPopupDivId').slideUp(100);
            	$('.theme-popover-mask').slideUp(200);
            });
            
            //添加手术人员
            $(".operatersPopupAddButton01DivClass").live("click",function(){
          	  var yishiName=$(".sl:selected").text();
          	  var yishiRole=$(".yishi3:selected").text();
          	  var operationId = document.getElementById("id").value;
          	  var params = {yishiRole:yishiRole,yishiName:yishiName,operationId:operationId};
          	   $.post( realPath+"/anesthesiaRecord/addAnesthetistersByRole1.action", 
                   		 params,     
                   function(data){
          		   if (data!="") {
          			 getOperators();
   				    getOperators1();
  				}
            	    });
              });
              
              //添加手术护士
              $(".operatersPopupAddButton02DivClass").live("click",function(){
            	  var yishiName=$(".hs:selected").text();
            	  var yishiRole=$(".yishi2:selected").text();
            	  var operationId = document.getElementById("id").value;
            	  var params = {yishiRole:yishiRole,yishiName:yishiName,operationId:operationId};
            	   $.post( realPath+"/anesthesiaRecord/addAnesthetistersByRole2.action", 
                     		 params,     
                     function(data){
            		   if (data!="") {
            			 getOperators();
     				    getOperators1();
    				}
              	    });
                });
          //获取手术人员
            function getOperators1(){
            	$("#anesthetistersPopupLeftDivTableId1 tbody").empty();
                var operationId = document.getElementById("id").value;
                var params = {operationId:operationId};
                $.post( realPath+"/anesthesiaRecord/getOperatorsByoperationId.action", 
                		 params,     
                         	function operaters(data){
                                var json = data;  
                                operatersData = eval('(' + json + ')');  
                                operatersTable1(operatersData);
                });
            }                 
                             
          //手术人员动态创建表格     
          var operatersTable1 = function(operatersData){
            	var operatorName1= operatersData.operatorName1;
            	var operatorName2= operatersData.operatorName2;
            	var operatorName3= operatersData.operatorName3;
            	var operatorName4= operatersData.operatorName4;
            	var instrnurse1 = operatersData.instrnurse1;
            	var instrnurse2 = operatersData.instrnurse2;
            	var circunurse1 = operatersData.circunurse1;
            	var circunurse2 = operatersData.circunurse2;
            	  	if(undefined!=operatorName1&&''!=operatorName1){
            	        var operatorName1Row = document.createElement("tr");
            	  		document.getElementById("operatersDivTableTbodyId1").appendChild(operatorName1Row);
            	        var operatorName1Cell = document.createElement("td");
            	            operatorName1Cell.style.width = "200px";
            	            operatorName1Cell.className = 'operatorNameCell';
            	            operatorName1Cell.innerText = operatorName1+' (主刀)';
            	            operatorName1Row.appendChild(operatorName1Cell); 
            	  	  }
            	  	if(undefined!=operatorName2&&''!=operatorName2){
            	  		var operatorName2Row = document.createElement("tr");
            	  		document.getElementById("operatersDivTableTbodyId1").appendChild(operatorName2Row);
            	  		var operatorName2Cell = document.createElement("td");
            	  		    operatorName2Cell.style.width = "200px";
            	  		    operatorName2Cell.className = 'operatorNameCell';
            	  		    operatorName2Cell.innerText = operatorName2+' (一助)';
            	  		    operatorName2Row.appendChild(operatorName2Cell); 
            	  	  }
            	  	if(undefined!=operatorName3&&''!=operatorName3){
            	  		var operatorName3Row = document.createElement("tr");
            	  		document.getElementById("operatersDivTableTbodyId1").appendChild(operatorName3Row);
            	  		var operatorName3Cell = document.createElement("td");
            	  		    operatorName3Cell.style.width = "200px";
            	  		    operatorName3Cell.className = 'operatorNameCell';
            	  		    operatorName3Cell.innerText = operatorName3+' (二助)';
            	  		    operatorName3Row.appendChild(operatorName3Cell); 
            	  	  }
            	  	if(undefined!=operatorName3&&''!=operatorName4){
            	  		var operatorName4Row = document.createElement("tr");
            	  		document.getElementById("operatersDivTableTbodyId1").appendChild(operatorName4Row);
            	  		var operatorName4Cell = document.createElement("td");
            	  		    operatorName4Cell.style.width = "200px";
            	  		    operatorName4Cell.className = 'operatorNameCell';
            	  		    operatorName4Cell.innerText = operatorName4+' (三助)';
            	  		    operatorName4Row.appendChild(operatorName4Cell); 
            	  	  }
            	
            	   if(undefined!=instrnurse1&&''!=instrnurse1){
            		   var instrnurse1Row = document.createElement("tr");
            		   document.getElementById("operatersDivTableTbodyId1").appendChild(instrnurse1Row);
            		   var instrnurse1NameCell = document.createElement("td");
            		       instrnurse1NameCell.style.width = "200px";
            		       instrnurse1NameCell.className = "operatorNameCell";
            		       instrnurse1NameCell.innerText = instrnurse1+' (巡回)';
            		       instrnurse1Row.appendChild(instrnurse1NameCell); 
            	     }
                 if(undefined!=instrnurse2&&''!=instrnurse2){
                	   var instrnurse2Row = document.createElement("tr");
                	   document.getElementById("operatersDivTableTbodyId1").appendChild(instrnurse2Row);
                	   var instrnurse2NameCell = document.createElement("td");
                	       instrnurse2NameCell.style.width = "200px";
                	       instrnurse2NameCell.className = "operatorNameCell";
                	       instrnurse2NameCell.innerText = instrnurse2+' (巡回)';
                	       instrnurse2Row.appendChild(instrnurse2NameCell);    
                   }     
                 if(undefined!=circunurse1&&''!=circunurse1){
                    	var circunurse1Row = document.createElement("tr");
                    	document.getElementById("operatersDivTableTbodyId1").appendChild(circunurse1Row);
                    	var circunurse1NameCell = document.createElement("td");
                    	    circunurse1NameCell.style.width = "200px";
                    	    circunurse1NameCell.className = "operatorNameCell";
                    	    circunurse1NameCell.innerText = circunurse1+' (器械)';
                    	    circunurse1Row.appendChild(circunurse1NameCell);  	 
                     }       
                  if(undefined!=circunurse2&&''!=circunurse2){
                  	var circunurse2Row = document.createElement("tr");
                  	document.getElementById("operatersDivTableTbodyId1").appendChild(circunurse2Row);
                  	var circunurse2NameCell = document.createElement("td");
                  	    circunurse2NameCell.style.width = "200px";
                  	    circunurse2NameCell.className = "operatorNameCell";
                  	    circunurse2NameCell.innerText = circunurse2+' (器械)';
                  	    circunurse2Row.appendChild(circunurse2NameCell);  	 
                     }       
                        
              };             
            
            
            
            //液体入量
           $('.liquidsInDivClass').click(function(){         
                $('.liquidsIn').slideDown(200);
                $('.theme-popover-mask').slideDown(200);
                
                $("#liquidsInListTableId tbody").empty();
//                var url = realPath+"/anesthesiaRecord/getSmIoEventList.action";
//                var operationId = document.getElementById("id").value;
//                var params = {operationId:operationId,type:'1'};
//                $.post(url,params,function selectliquidsInList(data){ var json = data;  inData = eval('(' + json + ')');  addLiquidsInTable(inData);}); 
//                
                
            });
           
            $('.liquidsInClose').click(function(){
                $('.liquidsIn').slideUp(200);
                $('.theme-popover-mask').slideUp(200);
            });

            
            $("#charging02Id").click(function(){
                $("#liquidsInInputAmount").attr("disabled",false);
                $("#liquidsInInputPrice").attr("disabled",false);
            });
            $("#charging01Id").click(function(){
                $("#liquidsInInputAmount").attr("disabled",true);
                $("#liquidsInInputPrice").attr("disabled",true);
            });
            

            //液体出量
           $('.liquidsOutDivClass').click(function(){ 
        	  var top = $(this).css("top");
        	 $("#liquidsOutDivTop").val(top);
        	 var liquidsOutDivId = $(this).attr("id");
        	
             $('.liquidsOut').slideDown(200);
             $('.theme-popover-mask').slideDown(200);
             $("#liquidsOutsListTable tbody").empty();
             var url = realPath+"/anesthesiaRecord/getSmIoEventList.action";
             var operationId = document.getElementById("id").value;
             var params = {operationId:operationId,type:'0'};
             $.post(url,params,function selectliquidsOutList(data){ var json = data;  outData = eval('(' + json + ')');  addTable(outData);});        
            });
           
            $('.liquidsOutClose').click(function(){
                $('.liquidsOut').slideUp(200);
                $('.theme-popover-mask').slideUp(200);
                
            });
            //打开麻醉事件弹出框1
            $('.anesthesiaEventTextDivClass').click(function(){
                $("#anesthesiaEventNamesTableId tbody").empty();
                $.post( realPath+"/anesthesiaRecord/getSmAnaesEventItems.action", function anaesEventItemsList(data){
                var json = data;  anaesEventItemsData = eval('(' + json + ')');  anaesEventItemsTable(anaesEventItemsData);
                });
            	 $('.anesthesiaEventDivClass').slideDown(200);
            	 $('.theme-popover-mask').slideDown(200);
            });
            $('.anesthesiaEventDivClose').click(function(){ 
            	$('.anesthesiaEventDivClass').slideUp(200); 
            	$('.theme-popover-mask').slideUp(200);
            });
            $('.anesthesiaEventButtonClose').click(function(){ 
            	$('.anesthesiaEventDivClass').slideUp(200); 
            	$('.theme-popover-mask').slideUp(200);
            });
            //打开麻醉事件弹出框2
            $('#anesthesiaEvent2DivId').click(function(){
                $("#anesthesiaEventNamesTableId tbody").empty();
                $.post( realPath+"/anesthesiaRecord/getSmAnaesEventItems.action", function anaesEventItemsList(data){
                var json = data;  anaesEventItemsData = eval('(' + json + ')');  anaesEventItemsTable(anaesEventItemsData);
                });
            	 $('.anesthesiaEventDivClass').slideDown(200);
            	 $('.theme-popover-mask').slideDown(200);
            });
            $('.anesthesiaEventDivClose').click(function(){ 
            	$('.anesthesiaEventDivClass').slideUp(200); 
            	$('.theme-popover-mask').slideUp(200);
            });
            $('.anesthesiaEventButtonClose').click(function(){ 
            	$('.anesthesiaEventDivClass').slideUp(200); 
            	$('.theme-popover-mask').slideUp(200);
            });
            //手术事件
            $('#operationEventDivId').click(function(){
            	$("#operationEventId").val("");
            	$("#operationEventPopupDivTitleInputId").val("");
            	$("#operationEventPopupDivTextareaId").val("");
            	$("#operationEventPopupTimeId").val("");
            	 $('.operationEventPopupDivClass').slideDown(200);
            	 $('.theme-popover-mask').slideDown(200);
            });
            $('.operationEventPopupDivCloseClass').click(function(){ 
            	$('.operationEventPopupDivClass').slideUp(200);
            	 $('.theme-popover-mask').slideUp(200);
            	});
            $('.operationEventPopupDivButton2Class').click(function(){ 
            	$('.operationEventPopupDivClass').slideUp(200); 
            	 $('.theme-popover-mask').slideUp(200);
            });
            //添加手术事件
            $('.operationEventPopupDivButton1Class').click(function(){
            	$("#operationEventListDivTableId tbody").empty();
                $.post( realPath+"/anesthesiaRecord/addOperationEvent.action", 
                		$("#operationEventFormId").serialize(), 
                		function operationEventList(data){
                             var json = data;  
                             operationEventData = eval('(' + json + ')');  
                             addOperationEventInTable(operationEventData);
                });
            });
            //点击手术事件
            $(".operationEventText").live("click",function(){
           	    $(this).css('background-color','#72C5FD');
        	    $('.operationEventText').not(this).css('background-color','#FFFFFF');
            });
            //删除手术事件
            $(".operationEventDeleteButton").live("click",function(){
            	var operationEventId =$(this).find(".operationEventId").val();
            	$("#operationEventListDivTableId tbody").empty();
            	var params = {operationEventId:operationEventId};
                $.post( realPath+"/anesthesiaRecord/deleteOperationEvent.action", 
                		params, 
                		function operationEventList(data){
                             var json = data;  
                             operationEventData = eval('(' + json + ')');  
                             addOperationEventInTable(operationEventData);
                });
            	
            });
            //修改手术事件
            $(".operationEventUpdateButton").live("click",function(){

            	
            	var operationEventId1 =$(this).find(".operationEventId1").val();
            	var operationEventOperationId =$(this).find(".operationEventOperationId").val();
            	var operationEventTitle =$(this).find(".operationEventTitle").val();
            	var operationEventContent =$(this).find(".operationEventContent").val();
            	var operationEventTime =$(this).find(".operationEventTime").val();
            	
            	$("#operationEventId").val(operationEventId1);
//            	$("#operationEventOperationId").val(operationEventOperationId);
            	$("#operationEventPopupDivTitleInputId").val(operationEventTitle);
            	$("#operationEventPopupDivTextareaId").val(operationEventContent);
            	$("#operationEventPopupTimeId").val(operationEventTime);
            	
            	$('.operationEventPopupDivClass').slideDown(200);
            	$('.theme-popover-mask').slideDown(200);         	
            });
            
            
            //呼吸事件
            $('#respiratoryEventDivId').click(function(){
            	$('.respiratoryEventPopupDivClass').slideDown(200);
            	 $('.theme-popover-mask').slideDown(200);
            });
            $('.respiratoryEventPopupDivCloseClass').click(function(){ 
            	$('.respiratoryEventPopupDivClass').slideUp(200); 
            	$('.theme-popover-mask').slideUp(200);
            });
            $('.respiratoryEventPopupDivButton2Class').click(function(){ 
            	$('.respiratoryEventPopupDivClass').slideUp(200);
            	$('.theme-popover-mask').slideUp(200);
            });
            //添加呼吸事件
            $('.respiratoryEventPopupDivButton1Class').click(function(){
            	$("#respiratoryEventListDivTableId tbody").empty();
                $.post( realPath+"/anesthesiaRecord/saveBreathEvent.action", 
                		$("#respiratoryEventFormId").serialize(), 
                		function breathEventList(data){
                             var json = data;  
                             breathEventData = eval('(' + json + ')');  
                             addBreathEventInTable(breathEventData);
                });
            });
            //点击呼吸事件
            $(".breathEventText").live("click",function(){
           	    $(this).css('background-color','#72C5FD');
        	    $('.breathEventText').not(this).css('background-color','#FFFFFF');
            });
            //删除呼吸事件
            $(".breathEventDeleteButton").live("click",function(){
            	var breathEventId =$(this).find(".breathEventId").val();
            	$("#respiratoryEventListDivTableId tbody").empty();
            	var params = {breathEventId:breathEventId};
                $.post( realPath+"/anesthesiaRecord/deleteBreathEvent.action", 
                		params, 
                		function breathEventList(data){
                             var json = data;  
                             breathEventData = eval('(' + json + ')');  
                             addBreathEventInTable(breathEventData);
                });
            	
            });
            //动态给麻醉用药信息赋值
            //---
            $(".smdName").live("click",function(){ 
            	 $(this).css('background-color','#72C5FD');
            	 $('.smdName').not(this).css('background-color','#FFFFFF');
            medicinesName = $(this).text();
            var spec =$(this).find(".spec").val();
            var firm =$(this).find(".firm").val();
            var dosageUnit =$(this).find(".dosageUnit").val();
            var medicineCode =$(this).find(".medicineCode").val();
            
            $("#medicineName").val(medicinesName.replace(/(^\s*)|(\s*$)/g, ""));
            $("#medicineSpec").val(spec);
            $("#medicineFirm").val(firm);                        
            $("#medicineDoseUnit").val(dosageUnit);                        
            $("#medicineCodeId").val(medicineCode);                        
            });
            //动态给液体出量信息赋值
            $(".liquidsOutName").live("click",function(){ 
          	 $(this).css('background-color','#72C5FD');
        	 $('.liquidsOutName').not(this).css('background-color','#FFFFFF');
            var liquidsOutName = $(this).text();
            var liquidsOutId =$(this).find(".liquidsOutId").val();     
            $("#liquidsOutName").val(liquidsOutName.replace(/(^\s*)|(\s*$)/g, ""));                     
            $("#liquidsOutId").val(liquidsOutId);                      
            });
            //添加出量
            var outNum =0;
            $(".liquidsOutAdd").live("click",function(){ 
            	
            	var liquidsOutName =$("#liquidsOutName").val();
            	var liquidsOutSpeed =$("#liquidsOutSpeed").val();
            	var liquidsOutSpeedUnit =$("#liquidsOutSpeedUnit").val();
            	var liquidsOutId =$("#liquidsOutId").val();
            	var liquidsOutDateId =$("#liquidsOutDate").val();
            	
            	 document.getElementById("collectMainView").contentWindow.liquidsOutAdd(medicinesCount,liquidsOutName,liquidsOutSpeed,liquidsOutSpeedUnit,liquidsOutId,liquidsOutDateId,outNum);
            
            	 outNum++;
            });
          //添加入量
            var inNum = 0;
            $(".liquidsInStart").live("click",function(){
            	var liquidsInInputName =$("#liquidsInInputName").val();
            	var liquidsInInputItemId =$("#liquidsInInputItemId").val();
            	var liquidsInInputDosage =$("#liquidsInInputDosage").val();
            	var liquidsInInputDosageUnit =$("#liquidsInInputDosageUnit").val();
            	var liquidsInInputStartTime =$("#liquidsInInputStartTime").val();
            	var liquidsInInputPassageway =$("#liquidsInInputPassageway").val();
            	var liquidsInInputFirm =$("#liquidsInInputFirm").val();
            	var liquidsInInputSpec =$("#liquidsInInputSpec").val();
            	var liquidsInInputAmount =$("#liquidsInInputAmount").val();
            	var liquidsInInputMinPackageUnit =$("#liquidsInInputMinPackageUnit").val();
            	var liquidsInInputPrice =$("#liquidsInInputPrice").val();
            	var liquidsInInputCharge =$("#liquidsInInputCharge").val();
            	document.getElementById("collectMainView").contentWindow.liquidsInAdd(medicinesCount,liquidsInInputName,
            			liquidsInInputItemId,liquidsInInputDosage,liquidsInInputDosageUnit,liquidsInInputStartTime,
            			liquidsInInputPassageway,liquidsInInputFirm,liquidsInInputSpec,liquidsInInputAmount,liquidsInInputMinPackageUnit,liquidsInInputPrice,liquidsInInputCharge,inNum);
            	inNum++;
            });
            
         var medicalNameList= new Array();
         var medicalFirmList= new Array();
         var medicalDosageUnitList= new Array();
         var medicalPinyinList = new Array();
         var medicalSpecList= new Array();
         var medicalMedicineCodeList= new Array();
         var medicalNames = $(".smdName").text();
   
         $(".spec").each(function(){
             var spec = $(this).val();
             medicalSpecList.push(spec);
         });
         $(".firm").each(function(){
             var firm = $(this).val();
             medicalFirmList.push(firm);
         });
         $(".dosageUnit").each(function(){
             var dosageUnit = $(this).val();
             medicalDosageUnitList.push(dosageUnit);
         });
         $(".medicineCode").each(function(){
        	 var medicineCode = $(this).val();
        	 medicalMedicineCodeList.push(medicineCode);
         });
         var medicalPinyins = $(".smdPinyin").text().toLowerCase();
         medicalNameList = medicalNames.split("-"); 
         medicalPinyinList = medicalPinyins.split("-"); 
         
   
        $("#medicalPinyin").bind("input propertychange",function(){
         
       
            var nameA = $(this).val();
           $("#medicineTable tbody").empty();
            var _row;
            var _cell;
            var _cell1;
            var input;
            var input1;
            var input2;
            var input3;
            for(var i =0;i<medicalPinyinList.length-1;i++){
                if( medicalPinyinList[i].indexOf(nameA) == 0){
                var name = medicalNameList[i];
                var spec = medicalSpecList[i];
                var firm = medicalFirmList[i];
                var firm = medicalFirmList[i];
                var dosageUnit = medicalDosageUnitList[i];
                var medicineCode = medicalMedicineCodeList[i];
                var pinyin = medicalPinyinList[i];
                    _row = document.createElement("tr");
                    document.getElementById("medicineTableTbody").appendChild(_row);
                    for(var j = 0; j < 1; j++) {
                        _cell = document.createElement("td");
                        
                        input = document.createElement("input");
                        input.type="hidden";
                        input.className="spec";
                        input.value=spec;
                        
                        input1 = document.createElement("input");
                        input1.type="hidden";
                        input1.className="firm";
                        input1.value=firm;
                        
                        input3 = document.createElement("input");
                        input3.type="hidden";
                        input3.className="medicineCode";
                        input3.value=medicineCode;
                        
                        input2 = document.createElement("input");
                        input2.type="hidden";
                        input2.className="dosageUnit";
                        input2.value=dosageUnit;
                        
                        _cell.className = "smdName";
                        _cell.innerText = name.replace(/(^\s*)|(\s*$)/g, "");
                        _row.appendChild(_cell);
                        _cell.appendChild(input);
                        _cell.appendChild(input1);
                        _cell.appendChild(input2);
                        _cell.appendChild(input3);
                        
                        _cell1 = document.createElement("td");
                         _cell1.className = "smdPinyin";
                        _cell1.innerText = pinyin;
                        _row.appendChild(_cell1);
                       
                    }
                }

            }
         });
  });
        //点击人员查询角色事件
       $(".xl").live("click",function(){
        	var yishiName=$(".xl:selected").text();
      	  var params = {yishiName:yishiName};
      	   $.post( realPath+"/anesthesiaRecord/AnesthetistersByyishiName.action", 
               		 params,     
               function(data){
      		    if (data!="") {
      			   if ('手术麻醉医师'==data) {
    				   $(".yishi[value='"+data+"']").attr("selected", true);
				}
    			 if ('巡台麻醉医师'==data) {   
    				 $(".yishi[value='"+data+"']").attr("selected", true);
					}
    			  if ('灌注医师'==data) {  
    				  $(".yishi[value='"+data+"']").attr("selected", true);
					}
          				}
      			if (data=="") {
     	    		 $(".xl").text("");
     	    		$(".yishi[id='empty']").attr("selected", true);
     	    	} 
        	    });
        });
       
       //点击护士名查询角色事件
       $(".hs").live("click",function(){

       	var yishiName=$(".hs:selected").text();
    	  var params = {yishiName:yishiName};
    	   $.post( realPath+"/anesthesiaRecord/AnesthetistersByyishiName1.action", 
             		 params,     
             function(data){
    		    if (data!="") {
    			   if ('器械护士'==data) {
  				   $(".yishi2[value='"+data+"']").attr("selected", true);
				}
  			 if ('巡回护士'==data) {   
  				 $(".yishi2[value='"+data+"']").attr("selected", true);
					}
        				}
    			if (data=="") {
   	    		 $(".hs").text("");
   	    		$(".yishi2[id='empty2']").attr("selected", true);
   	    	} 
      	    });
      });

        //根据输入拼音查询麻醉人员
      	function searchRy(m){
      	   $.ajax({
      	      type:"post",
      	      url:realPath+"/anesthesiaRecord/getAnesthetistersByPy.action",
      	      data:"zimu="+m.value,
      	      async:false,
      	      success:function(data){
      	    	  if (data!="") {
      	    	$("#yishiSelect").html(""); 
      	    	$("#yishiSelect").html(data); 
      	    	var yishiName=$(".xl:selected").text();
      	    	var params = {yishiName:yishiName};
                	   $.post( realPath+"/anesthesiaRecord/AnesthetistersByyishiName.action", 
                         		 params,     
                         function(data){
                		   if (data!="") {
                			   if ('手术麻醉医师'==data) {
                				   $(".yishi[value='"+data+"']").attr("selected", true);
                				  //$(".yishi[text='手术麻醉医师']").attr("selected", true);
							}
                			 if ('巡台麻醉医师'==data) {   
                				 $(".yishi[value='"+data+"']").attr("selected", true);
   							}
                			  if ('灌注医师'==data) {  
                				  $(".yishi[value='"+data+"']").attr("selected", true);
   							}
          				}
                  	    });
			
      	    	  }
      	    	if (data=="") {
      	    		 $(".xl").text("");
      	    		$(".yishi[id='empty']").attr("selected", true);
      	    	} 
      	    	} 
      	   
      	    });
      	};
        //根据输入拼音查询手术护士
      	function searchHs(m){
      	   $.ajax({
      	      type:"post",
      	      url:realPath+"/anesthesiaRecord/getAnesthetistersByPy2.action",
      	      data:"zimu="+m.value,
      	      async:false,
      	      success:function(data){
      	    	  if (data!="") {
      	    		$("#yishiSelect2").html(""); 
          	    	$("#yishiSelect2").html(data); 
          	    	var yishiName=$(".hs:selected").text();
          	    	var params = {yishiName:yishiName};
                    	   $.post( realPath+"/anesthesiaRecord/AnesthetistersByyishiName1.action", 
                             		 params,     
                             function(data){
                    		   if (data!="") {
                    			   if ('器械护士'==data) {
                    				   $(".yishi2[value='"+data+"']").attr("selected", true);
                    				  //$(".yishi[text='手术麻醉医师']").attr("selected", true);
    							}
                    			 if ('巡回护士'==data) {   
                    				 $(".yishi2[value='"+data+"']").attr("selected", true);
       							}
              				}
                      	    });
      	    	  }
      	       	if (data=="") {
     	    		 $(".hs").text("");
     	    		$(".yishi2[id='empty2']").attr("selected", true);
     	    	} 
      	    	} 
      	   
      	    });
      	};
      	
        //根据输入拼音查询手术医生
      	function searchYs(m){
      	   $.ajax({
      	      type:"post",
      	      url:realPath+"/anesthesiaRecord/getAnesthetistersByPy1.action",
      	      data:"zimu="+m.value,
      	      async:false,
      	      success:function(data){
      	    	  if (data!="") {
      	    		$("#yishiSelect3").html(""); 
          	    	$("#yishiSelect3").html(data); 
          	    	var yishiName=$(".sl:selected").text();
          	    	
                    		   if (yishiName!="") {
                    				   $(".yishi3[value='手术医师']").attr("selected", true);
              				}
      	    	  }  	    	
      	    	  if (data=="") {
       	    		 $(".sl").text("");
       	    		$(".yishi3[id='empty3']").attr("selected", true);
       	    	} 
      	    	} 
      	   
      	    });
      	};
        //开始记录
function startRecord(){
      var optId = $("#id").val();
      console.log("---"+optId);
      document.getElementById("collectMainView").contentWindow.startRecord();
}
//结束记录
function stopRecord(){
      document.getElementById("collectMainView").contentWindow.stopRecord();
}  
   
//开始用药
var medicinesCount = 0;//用药次数
function startUsedMedicine(){
     var medicineDurabled = document.getElementById("durabled");
     var medicineCode = document.getElementById("medicineCodeId").value;
     var medicineName = document.getElementById("medicineName").value;
     var medicineSpec = document.getElementById("medicineSpec").value;
     var medicineFirm = document.getElementById("medicineFirm").value;
     var medicineDose = document.getElementById("medicineDose").value;
     var medicineDoseUnit = document.getElementById("medicineDoseUnit").value;
     var medicineDiluentQuant = document.getElementById("medicineDiluentQuant").value;
     var medicineCharge ='';
 	 var medicineCharge1=document.getElementsByName('sme.charge'); 
	 for(var i=0; i<medicineCharge1.length; i++){
	    if(medicineCharge1[i].checked){
	    	medicineCharge=medicineCharge1[i].value; 
	    } 
	 }
     var medicineThickness = document.getElementById("medicineConcentration").value;
     var medicineThicknessUnit = document.getElementById("medicineConcentrationUnit").value;
     var medicineStarttime = document.getElementById("medicineStarttime").value;
     var medicineFlow = document.getElementById("medicineSpeed").value;
     var medicineFlowUnit = document.getElementById("medicineSpeedUnit").value;
     var medicineReasonSelect = document.getElementById("medicineReasonSelect").value;
     var medicineReason = document.getElementById("medicineReason").value;
     var medicalTakeWay = document.getElementById("medicalTakeWay").value;
     var medReason  = medicineReasonSelect+','+medicineReason;
     
     document.getElementById("collectMainView").contentWindow.addMedicines(medicinesCount,medicineName,medicineSpec,medicineDose,medicineDoseUnit,medicineFirm,medicineCharge,
    		 medicineThickness,medicineThicknessUnit,medicineFlow,medicineFlowUnit,medicalTakeWay,medicineDiluentQuant,medicineDurabled,medicineStarttime,medReason,medicineCode);
     medicinesCount++;
};
           
      //出量动态创建表格     
var addTable = function(liquidsOutData){
            for(var j = 0; j < liquidsOutData.length; j++) {
               var id = liquidsOutData[j].id;
               var operationId = liquidsOutData[j].operationId;
               var name = liquidsOutData[j].name;
               var dosage = liquidsOutData[j].dosage;
               var dosageUnit = liquidsOutData[j].dosageUnit;
               var starttime = liquidsOutData[j].starttime;
               
               var year = starttime.year+1900;
               var month = (starttime.month+1>10)?(starttime.month+1):"0"+(starttime.month+1);
               var today = (starttime.date>10)?starttime.date:"0"+starttime.date;
               var hours = (starttime.hours>10)?starttime.hours:"0"+starttime.hours;
               var minutes = (starttime.minutes>10)?starttime.minutes:"0"+starttime.minutes;
               var seconds = (starttime.seconds>10)?starttime.seconds:"0"+starttime.seconds;
               var starttime1 = year+"-"+month+"-"+today+" "+hours+":"+minutes+":"+seconds;  

               var liquidsOutRow = document.createElement("tr");
               document.getElementById("liquidsOutsListTableTbody").appendChild(liquidsOutRow);
                    var liquidsOutIdInput = document.createElement("input");
                        liquidsOutIdInput.style.width = "30px";
                        liquidsOutIdInput.type="checkbox";//checkbox
                        liquidsOutIdInput.className="liquidsOutId";
                        liquidsOutIdInput.value=id;
                        liquidsOutRow.appendChild(liquidsOutIdInput);
                        
                    var liquidsOutNameCell = document.createElement("td");
                        liquidsOutNameCell.style.width = "280px";
                        liquidsOutNameCell.className = "liquidsOutName";
                        liquidsOutNameCell.innerText = name;
                        liquidsOutRow.appendChild(liquidsOutNameCell);
                        
                    var liquidsOutSpeedCell = document.createElement("td");
                        liquidsOutSpeedCell.style.width = "80px";
                        liquidsOutSpeedCell.className = "liquidsOutSpeed";
                        liquidsOutSpeedCell.innerText = dosage;
                        liquidsOutRow.appendChild(liquidsOutSpeedCell);
                        
                    var liquidsOutSpeedUnitCell = document.createElement("td");
                        liquidsOutSpeedUnitCell.style.width = "80px";
                        liquidsOutSpeedUnitCell.className = "liquidsOutSpeedUnit";
                        liquidsOutSpeedUnitCell.innerText = dosageUnit;
                        liquidsOutRow.appendChild(liquidsOutSpeedUnitCell);
                        
                    var liquidsOutDateCell = document.createElement("td");
                        liquidsOutDateCell.style.width = "200px";
                        liquidsOutDateCell.className = "liquidsOutDate";
                        liquidsOutDateCell.innerText = starttime1;
                        liquidsOutRow.appendChild(liquidsOutDateCell);
               }
           };


var liquidsOutDelete = function(){
	var outIdList = [];
	if ($(".liquidsOutId:checked").val() != null) {
		for ( var i = 0; i < $(".liquidsOutId:checked").length; i++) {
			outIdList.push($(".liquidsOutId:checked")[i].value);
		}
		outIdList.join(",");
		$("#liquidsOutsListTable tbody").empty();
		var url = realPath+"/anesthesiaRecord/removeSmIoEventById.action";
        var liquidsId = outIdList.join(",");
        var operationId = document.getElementById("id").value;
        var params = {operationId:operationId,liquidsId:liquidsId,type:'0'};
		 $.post( 
				 url, 
				 params, 
				 function liquidsOutList(data){
                 var json = data;  
                 liquidsOutData = eval('(' + json + ')');  
                 addTable(liquidsOutData);
             });
		
	}
};
//入量

$(".inNameParentClass").live("click",function(){
	$(this).css('background-color','#72C5FD');
	$('.inNameParentClass').not(this).css('background-color','#FFFFFF');
	$("#liquidsInNamesChildTableId tbody").empty();
    var liquidsInNameTableLeft = $(this).text();
    var liquidsInCode =$(this).find(".inNameParentHiddenClass").val();    
    var url = realPath+"/anesthesiaRecord/getInChildNamesList.action";
    var params = {liquidsInSubType:liquidsInCode};
	 $.post( 
			 url, 
			 params, 
			 function liquidsInNamesChildList(data){
             var json = data;  
             liquidsInNamesChildData = eval('(' + json + ')');  
             createInParentNameTd(liquidsInNamesChildData);
         });
    });
//创建入量名字子菜单
var createInParentNameTd = function(liquidsInNamesChildData){
    for(var i = 0; i < liquidsInNamesChildData.length; i++) {
        var id = liquidsInNamesChildData[i].id;
        var name = liquidsInNamesChildData[i].name;
        var dosageUnit = liquidsInNamesChildData[i].dosageUnit;
        var spec = liquidsInNamesChildData[i].spec;
        var firm = liquidsInNamesChildData[i].firm;
        var minPackageUnit = liquidsInNamesChildData[i].minPackageUnit;
        
        var liquidsInNamesChildRow = document.createElement("tr");
        document.getElementById("liquidsInNamesChildTableToboy").appendChild(liquidsInNamesChildRow);
             var liquidsliquidsInNamesChildNameCell = document.createElement("td");
                 liquidsliquidsInNamesChildNameCell.style.width = "280px";
                 liquidsliquidsInNamesChildNameCell.className = "liquidsliquidsInNamesChildName";
                 liquidsliquidsInNamesChildNameCell.innerText = name;
                 liquidsInNamesChildRow.appendChild(liquidsliquidsInNamesChildNameCell);
                 
             var liquidsInNamesChildIdInput = document.createElement("input");
                 liquidsInNamesChildIdInput.type="hidden";
                 liquidsInNamesChildIdInput.className="liquidsInNamesChildId";
                 liquidsInNamesChildIdInput.value=id;
                 liquidsliquidsInNamesChildNameCell.appendChild(liquidsInNamesChildIdInput);          
                 
             var liquidsInNamesChildUnitInput = document.createElement("input");
                 liquidsInNamesChildUnitInput.type="hidden";
                 liquidsInNamesChildUnitInput.className="liquidsInNamesChildUnit";
                 liquidsInNamesChildUnitInput.value=dosageUnit;
                 liquidsliquidsInNamesChildNameCell.appendChild(liquidsInNamesChildUnitInput);
                 
             var liquidsInNamesChildSpecInput = document.createElement("input");
                 liquidsInNamesChildSpecInput.type="hidden";
                 liquidsInNamesChildSpecInput.className="liquidsInNamesChildSpec";
                 liquidsInNamesChildSpecInput.value=spec;
                 liquidsliquidsInNamesChildNameCell.appendChild(liquidsInNamesChildSpecInput); 
                 
             var liquidsInNamesChildFirmInput = document.createElement("input");
                 liquidsInNamesChildFirmInput.type="hidden";
                 liquidsInNamesChildFirmInput.className="liquidsInNamesChildFirm";
                 liquidsInNamesChildFirmInput.value=firm;
                 liquidsliquidsInNamesChildNameCell.appendChild(liquidsInNamesChildFirmInput); 
                 
             var liquidsInNamesChildMinPackageUnitInput = document.createElement("input");
                 liquidsInNamesChildMinPackageUnitInput.type="hidden";
                 liquidsInNamesChildMinPackageUnitInput.className="liquidsInNamesChildMinPackageUnit";
                 liquidsInNamesChildMinPackageUnitInput.value=minPackageUnit;
                 liquidsliquidsInNamesChildNameCell.appendChild(liquidsInNamesChildMinPackageUnitInput); 
                 
        }
};


//动态给液体入量信息赋值
$(".liquidsliquidsInNamesChildName").live("click",function(){     
	  $(this).css('background-color','#72C5FD');
	  $('.liquidsliquidsInNamesChildName').not(this).css('background-color','#FFFFFF');//其他的全部设置为红色
var liquidsliquidsInNamesChildName = $(this).text();
var liquidsInNamesChildId =$(this).find(".liquidsInNamesChildId").val();     
var liquidsInNamesChildUnit =$(this).find(".liquidsInNamesChildUnit").val();     
var liquidsInNamesChildSpec =$(this).find(".liquidsInNamesChildSpec").val();     
var liquidsInNamesChildFirm =$(this).find(".liquidsInNamesChildFirm").val();     
var liquidsInNamesChildMinPackageUnit =$(this).find(".liquidsInNamesChildMinPackageUnit").val();     
$("#liquidsInInputName").val(liquidsliquidsInNamesChildName.replace(/(^\s*)|(\s*$)/g, ""));                     
$("#liquidsInInputItemId").val(liquidsInNamesChildId);                      
$("#liquidsInInputDosageUnit").val(liquidsInNamesChildUnit);                      
$("#liquidsInInputSpec").val(liquidsInNamesChildSpec);                      
$("#liquidsInInputFirm").val(liquidsInNamesChildFirm);                      
$("#liquidsInInputMinPackageUnit").val(liquidsInNamesChildMinPackageUnit);                      
});

//开始输液liquidsInStart

//$(".liquidsInStart").live("click",function(){  
//    $("#liquidsInListTableId tbody").empty();
//       $.post( realPath+"/anesthesiaRecord/smIoEventSaveAndUpdate.action", $("#liquidsInInputFormId").serialize(), function liquidsInList(data){
//       var json = data;  liquidsInData = eval('(' + json + ')');  addLiquidsInTable(liquidsInData);
//       });
//       
//    });


//出量动态创建表格     
var addLiquidsInTable = function(liquidsInData){
            for(var j = 0; j < liquidsInData.length; j++) {
               var id = liquidsInData[j].id;
               var operationId = liquidsInData[j].operationId;
               var name = liquidsInData[j].name;
               var spec = liquidsInData[j].spec;
               var firm = liquidsInData[j].firm;
               var dosage = liquidsInData[j].dosage;
               var dosageUnit = liquidsInData[j].dosageUnit;
               var amount = liquidsInData[j].amount;
               var charge = liquidsInData[j].charge;
               var endtime = liquidsInData[j].endtime;
               
               var liquidsInRow = document.createElement("tr");
               document.getElementById("liquidsInListTableTbody").appendChild(liquidsInRow);
                    var liquidsInIdInput = document.createElement("input");
                        liquidsInIdInput.style.width = "30px";
                        liquidsInIdInput.type="checkbox";
                        liquidsInIdInput.className="liquidsInId";
                        liquidsInIdInput.value=id;
                        liquidsInRow.appendChild(liquidsInIdInput);
                        
                    var liquidsInNameCell = document.createElement("td");
                        liquidsInNameCell.style.width = "280px";
                        liquidsInNameCell.className = "liquidsInName";
                        liquidsInNameCell.innerText = name;
                        liquidsInRow.appendChild(liquidsInNameCell);
                        
                    var liquidsInSpecCell = document.createElement("td");
                        liquidsInSpecCell.style.width = "40px";
                        liquidsInSpecCell.className = "liquidsInSpec";
                        liquidsInSpecCell.innerText = spec;
                        liquidsInRow.appendChild(liquidsInSpecCell);
                        
                    var liquidsInFirmCell = document.createElement("td");
                        liquidsInFirmCell.style.width = "140px";
                        liquidsInFirmCell.className = "liquidsInFirm";
                        liquidsInFirmCell.innerText = firm;
                        liquidsInRow.appendChild(liquidsInFirmCell);
                        
                    var liquidsInDosageCell = document.createElement("td");
                        liquidsInDosageCell.style.width = "40px";
                        liquidsInDosageCell.className = "liquidsInDosage";
                        liquidsInDosageCell.innerText = dosage;
                        liquidsInRow.appendChild(liquidsInDosageCell);
                        
                    var liquidsInDosageUnitCell = document.createElement("td");
                        liquidsInDosageUnitCell.style.width = "40px";
                        liquidsInDosageUnitCell.className = "liquidsInDosageUnit";
                        liquidsInDosageUnitCell.innerText = dosageUnit;
                        liquidsInRow.appendChild(liquidsInDosageUnitCell);
                        
                    var liquidsInAmountCell = document.createElement("td");
                        liquidsInAmountCell.style.width = "100px";
                        liquidsInAmountCell.className = "liquidsInAmount";
                        liquidsInAmountCell.innerText = amount;
                        liquidsInRow.appendChild(liquidsInAmountCell);
                        
                    var liquidsInChargeCell = document.createElement("td");
                        liquidsInChargeCell.style.width = "40px";
                        liquidsInChargeCell.className = "liquidsInCharge";
                        liquidsInChargeCell.innerText = charge;
                        liquidsInRow.appendChild(liquidsInChargeCell);
                        
                    var liquidsInEndCell = document.createElement("td");
                        liquidsInEndCell.style.width = "40px";
                        liquidsInEndCell.className = "liquidsInEnd";
                        liquidsInEndCell.innerText = 0;//endtime;
                        liquidsInRow.appendChild(liquidsInAmountCell);
                        
                   
               }
           };

   //手术事件动态创建表格     
   var addOperationEventInTable = function(operationEventData){
                       for(var j = 0; j < operationEventData.length; j++) {
                    	  var num = operationEventData[j].num;
                          var id = operationEventData[j].id;
                          var operationId = operationEventData[j].operationId;
                          var title = operationEventData[j].title;
                          var content = operationEventData[j].content;
                          var time = operationEventData[j].time;
                          
                          var operationEventRow = document.createElement("tr");
                          document.getElementById("operationEventDivTableTbodyId").appendChild(operationEventRow);
                               var operationEventTextCell = document.createElement("td");
                                   operationEventTextCell.style.width = "300px";
                                   operationEventTextCell.className = "operationEventText";
                                   operationEventTextCell.innerText = num+'.'+title+'('+time+')';
                                   operationEventRow.appendChild(operationEventTextCell);
                                   
                               var operationEventDeleteInput = document.createElement("input");
                                   operationEventDeleteInput.type="button";
                                   operationEventDeleteInput.className="operationEventDeleteButton";
                                   operationEventDeleteInput.value='✖';
                                   operationEventRow.appendChild(operationEventDeleteInput);
                                   
                               var operationEventIdInput = document.createElement("input");
                                   operationEventIdInput.type="hidden";
                                   operationEventIdInput.className="operationEventId";
                                   operationEventIdInput.value=id;
                                   operationEventDeleteInput.appendChild(operationEventIdInput);
                                   
                               var operationEventUpdateInput = document.createElement("input");
                                   operationEventUpdateInput.type="button";
                                   operationEventUpdateInput.className="operationEventUpdateButton";
                                   operationEventUpdateInput.value='❂';
                                   operationEventRow.appendChild(operationEventUpdateInput);
         	                       
         	                   var operationEventIdInput1 = document.createElement("input");
         	                       operationEventIdInput1.type="hidden";
         	                       operationEventIdInput1.className="operationEventId1";
         	                       operationEventIdInput1.value=id;
         	                       operationEventUpdateInput.appendChild(operationEventIdInput1);
         	                       
         	                   var operationEventOperationIdInput = document.createElement("input");
         	                       operationEventOperationIdInput.type="hidden";
         	                       operationEventOperationIdInput.className="operationEventOperationId";
         	                       operationEventOperationIdInput.value=operationId;
         	                       operationEventUpdateInput.appendChild(operationEventOperationIdInput);
         	                       
         	                   var operationEventTitleInput = document.createElement("input");
         	                       operationEventTitleInput.type="hidden";
         	                       operationEventTitleInput.className="operationEventTitle";
         	                       operationEventTitleInput.value=title;
         	                       operationEventUpdateInput.appendChild(operationEventTitleInput);
         	                       
         	                   var operationEventContentInput = document.createElement("input");
         	                       operationEventContentInput.type="hidden";
         	                       operationEventContentInput.className="operationEventContent";
         	                       operationEventContentInput.value=content;
         	                       operationEventUpdateInput.appendChild(operationEventContentInput);
         	                       
         	                   var operationEventTimeInput = document.createElement("input");
         	                       operationEventTimeInput.type="hidden";
         	                       operationEventTimeInput.className="operationEventTime";
         	                       operationEventTimeInput.value=time;
         	                      operationEventUpdateInput.appendChild(operationEventTimeInput);
         	                       
                                   
                              
                          }
                      };

//呼吸事件动态创建表格     
var addBreathEventInTable = function(breathEventData){
           for(var j = 0; j < breathEventData.length; j++) {
               var breathEventNum = breathEventData[j].breathEventNum;
               var id = breathEventData[j].id;
               var operationId = breathEventData[j].operationId;
               var flagText = breathEventData[j].flagText;
               var flag = breathEventData[j].flag;
               var starttime = breathEventData[j].starttime;
               var breathEventRow = document.createElement("tr");
               document.getElementById("breathEventDivTableTbodyId").appendChild(breathEventRow);
               var breathEventTextCell = document.createElement("td");
                   breathEventTextCell.style.width = "327px";
                   breathEventTextCell.className = "breathEventText";
                   breathEventTextCell.innerText = breathEventNum+'.'+flagText+'('+starttime+')';
                   breathEventRow.appendChild(breathEventTextCell);
                                                      

                    
                var breathEventOperationIdInput = document.createElement("input");
                    breathEventOperationIdInput.type="hidden";
                    breathEventOperationIdInput.className="breathEventOperationId";
                    breathEventOperationIdInput.value=operationId;
                    breathEventTextCell.appendChild(breathEventOperationIdInput);
                    
                var breathEventFlagInput = document.createElement("input");
                    breathEventFlagInput.type="hidden";
                    breathEventFlagInput.className="breathEventFlag";
                    breathEventFlagInput.value=flag;
                    breathEventTextCell.appendChild(breathEventFlagInput);
                    
                var breathEventStarttimeInput = document.createElement("input");
                    breathEventStarttimeInput.type="hidden";
                    breathEventStarttimeInput.className="breathEventStarttime";
                    breathEventStarttimeInput.value=starttime;
                    breathEventTextCell.appendChild(breathEventStarttimeInput);
                            	                       
	            var breathEventDeleteInput = document.createElement("input");
	                breathEventDeleteInput.type="button";
	                breathEventDeleteInput.className="breathEventDeleteButton";
	                breathEventDeleteInput.value='✖';
	                breathEventRow.appendChild(breathEventDeleteInput);
	                
	            var breathEventIdInput = document.createElement("input");
                    breathEventIdInput.type="hidden";
                    breathEventIdInput.className="breathEventId";
                    breathEventIdInput.value=id;
                    breathEventDeleteInput.appendChild(breathEventIdInput);         	                  
                                                 
                                             }
                                         };


var liquidsInDelete = function(){
        		var inIdList = [];
        		if ($(".liquidsInId:checked").val() != null) {
        			for ( var i = 0; i < $(".liquidsInId:checked").length; i++) {
        				inIdList.push($(".liquidsInId:checked")[i].value);
        			}
        			inIdList.join(",");
        			 $("#liquidsInListTableId tbody").empty();
        			var url = realPath+"/anesthesiaRecord/removeSmIoEventById.action";
        	        var liquidsId = inIdList.join(",");
        	        var operationId = document.getElementById("id").value;
        	        var params = {operationId:operationId,liquidsId:liquidsId,type:'1'};
        			 $.post( 
        					 url, 
        					 params, 
        					 function liquidsInList(data){
        	                 var json = data;  
        	                 liquidsInNewData = eval('(' + json + ')');  
        	                 addLiquidsInTable(liquidsInNewData);
        	             });
        			
        		}
        	};

        	//画麻醉事件界面表格
        	function anaesEventItemsTable(anaesEventItemsData){
        	    for(var j = 0; j < anaesEventItemsData.length; j++) {
        	        var id = anaesEventItemsData[j].id;
        	        var name = anaesEventItemsData[j].name;
        	        var code = anaesEventItemsData[j].code;
        	        var graphElements = anaesEventItemsData[j].graphElements;
        	        var graphCode = anaesEventItemsData[j].graphCode;

        	        
        	        var anaesEventItemsRow = document.createElement("tr");
        	        document.getElementById("anesthesiaEventNamesTableTbodyId").appendChild(anaesEventItemsRow);
        	                 
        	             var anaesEventItemsNameCell = document.createElement("td");
        	                 anaesEventItemsNameCell.style.width = "280px";
        	                 anaesEventItemsNameCell.className = "anaesEventItemsName";
        	                 anaesEventItemsNameCell.innerText = name;
        	                 anaesEventItemsRow.appendChild(anaesEventItemsNameCell); 
        	                 
        	             var anaesEventItemsIdInput = document.createElement("input");
        	                 anaesEventItemsIdInput.type="hidden";
        	                 anaesEventItemsIdInput.className="anaesEventItemsId";
        	                 anaesEventItemsIdInput.value=id;
        	                 anaesEventItemsNameCell.appendChild(anaesEventItemsIdInput);
        	                 
        	             var anaesEventItemsCodeInput = document.createElement("input");
        	                 anaesEventItemsCodeInput.type="hidden";
        	                 anaesEventItemsCodeInput.className="anaesEventItemsCode";
        	                 anaesEventItemsCodeInput.value=code;
        	                 anaesEventItemsNameCell.appendChild(anaesEventItemsCodeInput);
        	                 
        	             var anaesEventItemsGraphElementsInput = document.createElement("input");
        	                 anaesEventItemsGraphElementsInput.type="hidden";
        	                 anaesEventItemsGraphElementsInput.className="anaesEventItemsGraphElements";
        	                 anaesEventItemsGraphElementsInput.value=graphElements;
        	                 anaesEventItemsNameCell.appendChild(anaesEventItemsGraphElementsInput);
        	                 
        	             var anaesEventItemsGraphCodeInput = document.createElement("input");
        	                 anaesEventItemsGraphCodeInput.type="hidden";
        	                 anaesEventItemsGraphCodeInput.className="anaesEventItemsGraphCode";
        	                 anaesEventItemsGraphCodeInput.value=graphCode;
        	                 anaesEventItemsNameCell.appendChild(anaesEventItemsGraphCodeInput);
        	        }
        	}
        	
//给麻醉事件弹出框隐藏域元素赋值
$(".anaesEventItemsName").live("click",function(){
	  $(this).css('background-color','#72C5FD');
	  $('.anaesEventItemsName').not(this).css('background-color','#FFFFFF');//其他的全部设置为红色
      $("#anaesEventItemsId").val($(this).find(".anaesEventItemsId").val());   
      $("#anaesEventItemsName").val($(this).text());   
      $("#anaesEventItemsCode").val($(this).find(".anaesEventItemsCode").val());   
      $("#anaesEventItemsGraphElements").val($(this).find(".anaesEventItemsGraphElements").val());   
      $("#anaesEventItemsGraphCode").val($(this).find(".anaesEventItemsGraphCode").val());   
      
});        	
/**
 * 添加麻醉事件
 *
 *
 * **/

function addAnesthEventParent(){
	
    var graphCode = document.getElementById("anaesEventItemsGraphCode").value;
    var anesthesiaEventInputDate = document.getElementById("anesthesiaEventInputDate").value;
    var anaesEventItemsGraphElements = document.getElementById("anaesEventItemsGraphElements").value;
    var anaesEventCreateuser = document.getElementById("anaesEventCreateuser").value; 
    var anaesEventItemsCode = document.getElementById("anaesEventItemsCode").value; 
    var anaesEventItemsName = $('.anaesEventItemsName').text();
    var anesthEventY = 12;
    var eventItemCode = anaesEventItemsCode;
    document.getElementById("collectMainView").contentWindow.addAnesthEvent(anesthesiaEventInputDate,anesthEventY,eventItemCode,graphCode,anaesEventItemsGraphElements,anaesEventItemsName);
    
}

//保存
function save(){
	setTimeout(saveAE,50);
	setTimeout(saveME,300);
	setTimeout(saveIOE,500);
	setTimeout(saveMS,700);
	setTimeout(updateSmRegOpt,900);
	setTimeout(saveBodyPosition,1100);
	setTimeout(addOutRoomStatus,1300);
	setTimeout(anesthSummaryToValue,1500);
	addZhenTong();
}
function addZhenTong() {
	var operationId = document.getElementById("id").value;
	var analgesia = $("input[name='analgesia']:checked").val();
	var cpr =$("input[name='cpr']:checked").val();
	var incisionCleanliness = $("#incisionCleanliness option:selected").val();
	var params = {operationId:operationId,analgesia:analgesia,cpr:cpr,incisionCleanliness:incisionCleanliness};
	    $.post( 
		    	realPath+"/anesthesiaRecord/saveZhenTong.action", 
		    	params, 
		    	function(data){
		    		
		 }); 
}

//保存麻醉事件
function saveAE(){
	var operationId = document.getElementById("id").value;
	var userId = document.getElementById("userId").value;
	document.getElementById("collectMainView").contentWindow.saveAnesthEvent(operationId,userId);
}
//保存麻醉用药
function saveME(operationId,userId){
	var operationId = document.getElementById("id").value;
	var userId = document.getElementById("userId").value;
	document.getElementById("collectMainView").contentWindow.saveMedEvent(operationId,userId);
}

/** 	 
 * @功能描述:保存出入量事件
 * @参数: operationId,userId 
 * @日期:2016-3-31 上午9:36:04
 * @作者:崔连瑞
 */
function saveIOE(operationId,userId){
	var operationId = document.getElementById("id").value;
	var userId = document.getElementById("userId").value;
	document.getElementById("collectMainView").contentWindow.saveIOEvent(operationId,userId);
}
//保存生命体征
function saveMS(){
	var operationId = document.getElementById("id").value;
	var userId = document.getElementById("userId").value;
	document.getElementById("collectMainView").contentWindow.saveMonitoringSign(operationId,userId);
}


window.onload = function(){
	
	var operationId = document.getElementById("id").value;
	var state = document.getElementById("state").value;
	getAnesthetisters();
	getOperators();
	//document.getElementById("collectMainView").contentWindow.setPrintButtonNotUse();
	if('04'==state){
		var operdate = document.getElementById("operdate").value;
		var operStartTime = document.getElementById("operStartTime").value;
		var remarkInterval = document.getElementById("remarkInterval").value;
        document.getElementById("collectMainView").contentWindow.drawCollectInterval(remarkInterval,operdate.split(' ')[0]+' '+operStartTime);
        document.getElementById("collectMainView").contentWindow.drawCenterCanvasTimes(remarkInterval,operdate.split(' ')[0]+' '+operStartTime);
        document.getElementById("collectMainView").contentWindow.passNowDate(operationId,state,operdate.split(' ')[0]+' '+operStartTime);
        
        document.getElementById("collectMainView").contentWindow.setStartButtonNotUse();
        //document.getElementById("collectMainView").contentWindow.setPrintButtonNotUse();
        document.getElementById("collectMainView").contentWindow.getMedEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getIOEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getAnesthEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getSmWaveData(operationId);
        getOperationEvent();
        getBreathEvent();
        getOutRoomStatus();
        setTimeout(anesthSummaryToValue,2000);
        setTimeout(getBodyPosition,4000);
	}
	if('05'==state){
		var operdate = document.getElementById("operdate").value;
		var operStartTime = document.getElementById("operStartTime").value;
        document.getElementById("collectMainView").contentWindow.drawCollectInterval(1,operdate.split(' ')[0]+' '+operStartTime);
        document.getElementById("collectMainView").contentWindow.drawCenterCanvasTimes(1,operdate.split(' ')[0]+' '+operStartTime);
        document.getElementById("collectMainView").contentWindow.passNowDate(operationId,state,operdate.split(' ')[0]+' '+operStartTime);
        
        document.getElementById("collectMainView").contentWindow.setStartButtonNotUse();
        document.getElementById("collectMainView").contentWindow.getMedEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getIOEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getAnesthEvent(operationId);
        document.getElementById("collectMainView").contentWindow.getSmWaveData(operationId);
        getOperationEvent();
        getBreathEvent();
        getOutRoomStatus();
        setTimeout(anesthSummaryToValue,2000);
        setTimeout(getBodyPosition,4000);
	}
	
};


//结束按钮
var stopOPT =function(){
	var operationId = document.getElementById("id").value;
    var params = {operationId:operationId};
    $.post( realPath+"/anesthesiaRecord/stopOperation.action", 
    		 params,
     		function operationEventList(data){
                 var json = data;  
                 operationEventData = eval('(' + json + ')');  
    });
	save();
};
//获取手术事件List
function getOperationEvent(){
	$("#operationEventListDivTableId tbody").empty();
    var operationId = document.getElementById("id").value;
    var params = {operationId:operationId};
    $.post( realPath+"/anesthesiaRecord/getOperationEventListByoperationId.action", 
    		 params,
     		function operationEventList(data){
                 var json = data;  
                 operationEventData = eval('(' + json + ')');  
                 addOperationEventInTable(operationEventData);
    });
}
//获取呼吸事件List
function getBreathEvent(){
	$("#respiratoryEventListDivTableId tbody").empty();
    var operationId = document.getElementById("id").value;
    var params = {operationId:operationId};
    $.post( realPath+"/anesthesiaRecord/getBreathEventListByoperationId.action", 
    		 params,     
             	function breathEventList(data){
                    var json = data;  
                    breathEventData = eval('(' + json + ')');  
                    addBreathEventInTable(breathEventData);
    });
}
//获取麻醉人员
function getAnesthetisters(){
	
	$("#anesthetistersListDivTableId tbody").empty();
    var operationId = document.getElementById("id").value;
    var params = {operationId:operationId};
    $.post( realPath+"/anesthesiaRecord/getAnesthetistersListByoperationId.action", 
    		 params,     
             	function anesthetistersList(data){
                    var json = data;  
                    anesthetisterData = eval('(' + json + ')');  
                    anesthetistersTable(anesthetisterData);
    });
}
//麻醉人员动态创建表格     
var anesthetistersTable = function(anesthetisterData){
	var anesthetist = anesthetisterData.anesthetist;
	var circuanesthetist = anesthetisterData.circuanesthetist;
	var anaesassistant = anesthetisterData.anaesassistant; 
	if(''!=anesthetist){
		var anesthetistRow = document.createElement("tr");
		document.getElementById("anesthetistersDivTableTbodyId").appendChild(anesthetistRow);
		var anesthetistNameCell = document.createElement("td");
		anesthetistNameCell.style.width = "90px";
		anesthetistNameCell.className = "anesthetistNameCell";
		anesthetistNameCell.innerText = anesthetist+' (麻师)';
		anesthetistRow.appendChild(anesthetistNameCell); 
	}
       if(''!=circuanesthetist){
    	   var circuanesthetistRow = document.createElement("tr");
    	   document.getElementById("anesthetistersDivTableTbodyId").appendChild(circuanesthetistRow);
    	   var circuanesthetistNameCell = document.createElement("td");
    	   circuanesthetistNameCell.style.width = "90px";
    	   circuanesthetistNameCell.className = "circuanesthetistNameCell";
    	   circuanesthetistNameCell.innerText = circuanesthetist+' (巡台)';
    	   circuanesthetistRow.appendChild(circuanesthetistNameCell);    
       }     
         if(''!=anaesassistant){
        	 var anaesassistantRow = document.createElement("tr");
        	 document.getElementById("anesthetistersDivTableTbodyId").appendChild(anaesassistantRow);
        	 var anaesassistantNameCell = document.createElement("td");
        	 anaesassistantNameCell.style.width = "90px";
        	 anaesassistantNameCell.className = "anaesassistantNameCell";
        	 anaesassistantNameCell.innerText = anaesassistant+' (灌注)';
        	 anaesassistantRow.appendChild(anaesassistantNameCell);  	 
         }       
            
  };

//获取手术人员
  function getOperators(){
  	$("#operatersListDivTableId tbody").empty();
      var operationId = document.getElementById("id").value;
      var params = {operationId:operationId};
      $.post( realPath+"/anesthesiaRecord/getOperatorsByoperationId.action", 
      		 params,     
               	function operaters(data){
                      var json = data;  
                      operatersData = eval('(' + json + ')');  
                      operatersTable(operatersData);
      });
  }                 
                   
//手术人员动态创建表格     
var operatersTable = function(operatersData){
  	var operatorName1= operatersData.operatorName1;
  	var operatorName2= operatersData.operatorName2;
  	var operatorName3= operatersData.operatorName3;
  	var operatorName4= operatersData.operatorName4;
  	var instrnurse1 = operatersData.instrnurse1;
  	var instrnurse2 = operatersData.instrnurse2;
  	var circunurse1 = operatersData.circunurse1;
  	var circunurse2 = operatersData.circunurse2;
  	  	if(undefined!=operatorName1&&''!=operatorName1){
  	        var operatorName1Row = document.createElement("tr");
  	  		document.getElementById("operatersDivTableTbodyId").appendChild(operatorName1Row);
  	        var operatorName1Cell = document.createElement("td");
  	            operatorName1Cell.style.width = "90px";
  	            operatorName1Cell.className = 'operatorName1Cell';
  	            operatorName1Cell.innerText = operatorName1+' (主刀)';
  	            operatorName1Row.appendChild(operatorName1Cell); 
  	  	  }
  	  	if(undefined!=operatorName2&&''!=operatorName2){
  	  		var operatorName2Row = document.createElement("tr");
  	  		document.getElementById("operatersDivTableTbodyId").appendChild(operatorName2Row);
  	  		var operatorName2Cell = document.createElement("td");
  	  		    operatorName2Cell.style.width = "90px";
  	  		    operatorName2Cell.className = 'operatorName2Cell';
  	  		    operatorName2Cell.innerText = operatorName2+' (一助)';
  	  		    operatorName2Row.appendChild(operatorName2Cell); 
  	  	  }
  	  	if(undefined!=operatorName3&&''!=operatorName3){
  	  		var operatorName3Row = document.createElement("tr");
  	  		document.getElementById("operatersDivTableTbodyId").appendChild(operatorName3Row);
  	  		var operatorName3Cell = document.createElement("td");
  	  		    operatorName3Cell.style.width = "90px";
  	  		    operatorName3Cell.className = 'operatorName3Cell';
  	  		    operatorName3Cell.innerText = operatorName3+' (二助)';
  	  		    operatorName3Row.appendChild(operatorName3Cell); 
  	  	  }
  	  	if(undefined!=operatorName3&&''!=operatorName4){
  	  		var operatorName4Row = document.createElement("tr");
  	  		document.getElementById("operatersDivTableTbodyId").appendChild(operatorName4Row);
  	  		var operatorName4Cell = document.createElement("td");
  	  		    operatorName4Cell.style.width = "90px";
  	  		    operatorName4Cell.className = 'operatorName4Cell';
  	  		    operatorName4Cell.innerText = operatorName4+' (三助)';
  	  		    operatorName4Row.appendChild(operatorName4Cell); 
  	  	  }
  	
  	   if(undefined!=instrnurse1&&''!=instrnurse1){
  		   var instrnurse1Row = document.createElement("tr");
  		   document.getElementById("operatersDivTableTbodyId").appendChild(instrnurse1Row);
  		   var instrnurse1NameCell = document.createElement("td");
  		       instrnurse1NameCell.style.width = "90px";
  		       instrnurse1NameCell.className = "instrnurse1NameCell";
  		       instrnurse1NameCell.innerText = instrnurse1+' (巡回)';
  		       instrnurse1Row.appendChild(instrnurse1NameCell); 
  	     }
       if(undefined!=instrnurse2&&''!=instrnurse2){
      	   var instrnurse2Row = document.createElement("tr");
      	   document.getElementById("operatersDivTableTbodyId").appendChild(instrnurse2Row);
      	   var instrnurse2NameCell = document.createElement("td");
      	       instrnurse2NameCell.style.width = "90px";
      	       instrnurse2NameCell.className = "instrnurse2NameCell";
      	       instrnurse2NameCell.innerText = instrnurse2+' (巡回)';
      	       instrnurse2Row.appendChild(instrnurse2NameCell);    
         }     
       if(undefined!=circunurse1&&''!=circunurse1){
          	var circunurse1Row = document.createElement("tr");
          	document.getElementById("operatersDivTableTbodyId").appendChild(circunurse1Row);
          	var circunurse1NameCell = document.createElement("td");
          	    circunurse1NameCell.style.width = "90px";
          	    circunurse1NameCell.className = "circunurse1NameCell";
          	    circunurse1NameCell.innerText = circunurse1+' (器械)';
          	    circunurse1Row.appendChild(circunurse1NameCell);  	 
           }       
        if(undefined!=circunurse2&&''!=circunurse2){
        	var circunurse2Row = document.createElement("tr");
        	document.getElementById("operatersDivTableTbodyId").appendChild(circunurse2Row);
        	var circunurse2NameCell = document.createElement("td");
        	    circunurse2NameCell.style.width = "90px";
        	    circunurse2NameCell.className = "circunurse2NameCell";
        	    circunurse2NameCell.innerText = circunurse2+' (器械)';
        	    circunurse2Row.appendChild(circunurse2NameCell);  	 
           }       
              
    };             
          
    
    
    
//保存体位信息
function saveBodyPosition(){
	var operationId = document.getElementById("id").value;
	var bodyPosition=document.getElementsByName('operativePosition'); 
	var bodyPositionValues='';
	 for(var i=0; i<bodyPosition.length; i++){
	    if(bodyPosition[i].checked){
		   bodyPositionValues+=bodyPosition[i].value+','; 
	    } 
	 }
	 bodyPositionValues = bodyPositionValues.substring(0, bodyPositionValues.length-1);
	 var params = {operationId:operationId,bodyPositionValues:bodyPositionValues};
	 $.post( realPath+"/anesthesiaRecord/saveBodyPosition.action", 
      		 params,     
               	function operaters(data){
                      var json = data;  
                      bodyPositionData = eval('(' + json + ')');  
                      
      });
}
//获取体位信息
function getBodyPosition(){
	var operationId = document.getElementById("id").value;
	 var params = {operationId:operationId};
	 $.post( realPath+"/anesthesiaRecord/getBodyPosition.action", 
      		 params,     
               	function operaters(data){
                      var json = data;  
                      positionData = eval('(' + json + ')'); 
                         if(positionData!=null){
                        	 var positions = positionData.bodyPosition;
                        	 var position = positions.split(',');
                        	 for(var i=0;i<position.length;i++){
                        		 $(":checkbox[name='operativePosition'][value="+position[i]+"]").attr("checked","true");
                        	 }
                         }
                      
      });
}
                   
                   
//测试保存-------------------------------------------------------------------------------------------------------------------------------
function testSave(){
	alert('111111');
/*	var operationId = document.getElementById("id").value;
	var userId = document.getElementById("userId").value;
	document.getElementById("collectMainView").contentWindow.saveMonitoringSign(operationId,userId);*/
	//anesthSummaryToValue();
	//addOutRoomStatus();
//	getOutRoomStatus();
	getBodyPosition();
}                
       
//给麻醉小结赋值
function anesthSummaryToValue(){
	var operationId = document.getElementById("id").value;
	 var params = {operationId:operationId};
	 $.post( realPath+"/anesthesiaRecord/getAnesthSummary.action", 
      		 params,     
               	function summarys(data){
                      var json = data;  
                      summaryData = eval('(' + json + ')');
                      if(summaryData!=null){
                    	  $("#operationStartTimeTextId").val(summaryData.optStartTime);  
                    	  $("#operationEndTimeTextId").val(summaryData.optEndTime);  
                    	  $("#operationUseTimeTextid").val(summaryData.optCha);  
                    	  $("#anaesthesiaStartTimeTextId").val(summaryData.anaesStartTime);  
                    	  $("#anaesthesiaEndTimeTextId").val(summaryData.anaesEndTime);  
                    	  $("#anaesthesiaUseTimeTextId").val(summaryData.anasCha);  
                    	  $("#regOptAsa01Id").val(summaryData.asalevel);  
                    	  
                      }
                      
      });
}
//保存出室情况
function addOutRoomStatus(){
  $.post( realPath+"/anesthesiaRecord/addOutRoomStatus.action", 
		  $("#outRoomStatusFormId").serialize(), 
		  function outRoomList(data){
                   var json = data;  
                   outRoomData = eval('(' + json + ')');  
                  
  });
}
//获取出室情况
function getOutRoomStatus(){
	 var operationId = document.getElementById("id").value;
	 var params = {operationId:operationId};
	 $.post( 
			 realPath+"/anesthesiaRecord/getOutRoomStatus.action", 
      		 params,     
             function outRoom(data){
				 console.log(data);
                 var json = data;  
                 outRoomData = eval('(' + json + ')');
                 if(outRoomData!=null){
                	 $(":radio[name='sors.easePainManner'][value="+outRoomData.easePainManner+"]").attr("checked","true");
                	 $(":radio[name='sors.mentalState'][value="+outRoomData.mentalState+"]").attr("checked","true");
                	 $(":radio[name='sors.coughReflact'][value="+outRoomData.coughReflact+"]").attr("checked","true");
                	 $(":radio[name='sors.direPower'][value="+outRoomData.direPower+"]").attr("checked","true");
                	 $(":radio[name='sors.muscleRecover'][value="+outRoomData.muscleRecover+"]").attr("checked","true");
                	 $(":radio[name='sors.leaveTo'][value="+outRoomData.leaveTo+"]").attr("checked","true");
                 }
      });
}
       
//更新基本信息
function updateSmRegOpt(){
	var operationId = document.getElementById("id").value;
	var regOptHeight = document.getElementById("regOptHeightId").value;
	var regOptWeight = document.getElementById("regOptWeightId").value;
	var regOptBloodType = document.getElementById("regOptBloodTypeId").value;
	var regOptAsa01 = document.getElementById("regOptAsa01Id").value;
	var params = {operationId:operationId,regOptHeight:regOptHeight,regOptWeight:regOptWeight,regOptBloodType:regOptBloodType,regOptAsa01:regOptAsa01};
	 $.post( 
			 realPath+"/anesthesiaRecord/updateSmRegOptSomething.action", 
      		 params,     
             function regOpt01(data){
                 var json = data;  
                 regOptData = eval('(' + json + ')');
      });
}
                   
                   
                   
                   
                   
