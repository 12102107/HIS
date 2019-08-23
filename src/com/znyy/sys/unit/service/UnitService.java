package com.znyy.sys.unit.service;

import java.util.List;
import java.util.Map;

public interface UnitService {

	
	 /**
	 * @方法名称: getMoreUnitSel
	 * @功能描述: 登录系统选择多科室
	 * @作者:慕金剑
	 * @创建时间:2016-4-5 下午5:45:36
	 * @param userid 当前登录用户id（xt_user.id）
	 * @param hospitalcode 当前登录医院code
	 * @param moreunitflag 当前登录系统的多科室标示
	 * @return List<Map<String,Object>>   
	 */
	
	public List<Map<String, Object>> getMoreUnitSel(Integer userid,String hospitalcode,String moreunitflag);

}
