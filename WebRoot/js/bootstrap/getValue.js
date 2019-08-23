/**
	获取值
*/

function getValue(id,flag){
	var value;
	switch (flag) {
	case 'no':
		value = "";
		break;
	case 'select':
		value = $("#"+id+" option:selected").val();
		break;
	case 'input':
		value = $("#"+id).val();
		break;
	case 'search':
		value = $("#"+id).val();
		break;
	default:
		value = "";
		break;
	}
	return value;
}
