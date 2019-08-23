package com.znyy.sm.service.impl;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.SmNotice;
import com.znyy.sm.dao.NoticeDao;
import com.znyy.sm.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;

	public NoticeDao getNoticeDao() {
	
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
	
		this.noticeDao = noticeDao;
	}

	
	 /** 
	 * @方法名称: getNocList
	 * @功能描述:获取公告信息列表
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午1:46:33
	 * @return
	 * @see com.znyy.sm.service.NoticeService#getNocList()
	 */

	@Override
	public Page getNotcList(String name, int parmpage, Integer pageSize) {
	
		return noticeDao.getNocList(name,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getNoticeById
	 * @功能描述:公告修改跳转
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:04:28
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.NoticeService#getNoticeById(java.lang.Integer)
	 */
	 
	@Override
	public SmNotice getNoticeById(Integer id) {
		
		SmNotice nocs =  noticeDao.getNoticeById(id);
		return nocs;
		
	}

	
	 /** 
	 * @方法名称: modNoticeList
	 * @功能描述:修改公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:20:22
	 * @param noti
	 * @see com.znyy.sm.service.NoticeService#modNoticeList(com.znyy.bean.SmNotice)
	 */
	 
	@Override
	public void modNoticeList(SmNotice noti) {
		
		noticeDao.modNoticeList(noti);
		
	}

	
	 /** 
	 * @方法名称: addNotice
	 * @功能描述:添加公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午5:18:47
	 * @param notice
	 * @see com.znyy.sm.service.NoticeService#addNotice(com.znyy.bean.SmNotice)
	 */
	 
	@Override
	public void addNotice(SmNotice notice) {
		
		noticeDao.addNotice(notice);
		
	}

	
	 /** 
	 * @方法名称: delNotice
	 * @功能描述:删除公告
	 * @作者:付士山
	 * @创建时间:2016-3-25 上午10:36:52
	 * @param id
	 * @see com.znyy.sm.service.NoticeService#delNotice(java.lang.Integer)
	 */
	 
	@Override
	public void delNotice(SmNotice notic) {
		
		noticeDao.delNotice(notic);
		
	}

	@Override
	public Map<String, Object> getOpterNameByUserId(String userId) {
		return noticeDao.getOpterNameById(userId);
	}


}
