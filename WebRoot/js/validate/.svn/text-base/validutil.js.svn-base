(function($){
			$.fn.tp =  function(mess){
				var _this = this;
				// 触发失去焦点事件
				_this.live("blur",function(){
					var val = _this.val();
					if(typeof(val) =='undefind' || val == ''){
						var htmlStr = '<label generated="true" class="error">'+mess+'</label>'
						
						var errorCount = _this.parent().find("label.error").size();
						if(errorCount < 1)
						_this.parent().append(htmlStr);
						
					}
				
				});
				// 触发改变事件
				_this.live("change",function(){
					var val = _this.val();
					if(typeof(val) =='undefind' || val == ''){
						
					}else{
					
						_this.parent().find("label.error").remove();
					
					}
				
				});
				
			}
				
		
		
		})(jQuery)