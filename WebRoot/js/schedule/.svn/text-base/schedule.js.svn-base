/**
 * 打开遮罩层显示加载图片
 * 
 * @param callback
 */
function fnshowMsMaskLoading(callback) {
	$ms_maskDiv = jQuery("<div class=\"ms_mask_loading\" ></div>").appendTo(
			"body").css({
		position : 'fixed',
		display : 'none',
		top : 0,
		left : 0,
		width : '100%',
		height : '100%',
		'z-index' : 99999999999,
		background : 'rgba(0, 0, 0, 0.44)',
		opacity : 0.44

	});
	$ms_maskShowDiv = $(
			"<div class=\"ms_mask_show_loading\" >"
					+ "<table align=\"center\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse: collapse; height: 100px; min-height: 100px;\" bgcolor=\"#1CAAD1\">"
					+ "<tr><td style=\"font-size: 12px;height:30px;\">正在加载，请稍后......</td></tr>"
					+ "<tr><td align=\"center\" bgcolor=\"#ffffff\" style=\"height:70px;vertical-align:middle;\"><img style=\"display:inline\" src=\"../images/schedule/loading.gif\"></img></td></tr>"
					+ "</table>" + "</div>").appendTo("body").css({
		position : 'fixed',
		display : 'none',
		top : '50%',
		left : '50%',
		'z-index' : 9999999999999,
		width : '300px',
		height : '100px',
		'margin-left' : '-150px',
		'margin-top' : '-150px',
		background : '#127386',
		border : '1px solid #127386'
	});
	
	$ms_maskDiv.show(function() {
		$ms_maskShowDiv.show();
		callback();
	});

}
/**
 * 关闭遮罩层
 */
function fnchoseMsMaskLoading() {
	jQuery(".ms_mask_loading").remove();
	jQuery(".ms_mask_show_loading").remove();
}