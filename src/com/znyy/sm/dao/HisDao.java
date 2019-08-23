package com.znyy.sm.dao;

import java.util.List;
import com.znyy.bean.ZyOperationApply;

public interface HisDao {

    /**
     * @方法名称: getSmRegOpt
     * @功能描述: 获取预约病人
     * @作者:崔连瑞
     * @创建时间:2016-5-18 上午10:41:21
     * @param 
     * @return    
     */
     public List<ZyOperationApply> getOperationApply();

	
	 /**
	 * @方法名称: getHisById
	 * @功能描述: 修改His跳转
	 * @作者:付士山
	 * @创建时间:2016-5-18 下午6:00:35
	 * @param id
	 * @return ZyOperationApply   
	 */
	 
	public ZyOperationApply getHisById(long id);


	public void modHisList(ZyOperationApply hiss);
}
