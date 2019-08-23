
package com.znyy.sm.service;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.SmNotice;

public interface NoticeService {

	
	 /**
	 * @方法名称: getNocList
	 * @功能描述: 获取公告信息列表
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午1:46:20
	 * @return List<SmNotice>   
	 */
	Page getNotcList(String name, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getNoticeById
	 * @功能描述: 公告修改跳转
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:04:10
	 * @param id
	 * @return SmNotice   
	 */
	 
	SmNotice getNoticeById(Integer id);


	
	 /**
	 * @方法名称: modNoticeList
	 * @功能描述: 修改公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:20:09
	 * @param noti void   
	 */
	 
	void modNoticeList(SmNotice noti);


	
	 /**
	 * @方法名称: addNotice
	 * @功能描述: 添加公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午5:18:34
	 * @param notice void   
	 */
	 
	void addNotice(SmNotice notice);


	
	 /**
	 * @方法名称: delNotice
	 * @功能描述: 删除公告
	 * @作者:付士山
	 * @创建时间:2016-3-25 上午10:35:55
	 * @param notic void   
	 */
	 
	void delNotice(SmNotice notic);
	
	Map<String, Object> getOpterNameByUserId(String userId);

}

