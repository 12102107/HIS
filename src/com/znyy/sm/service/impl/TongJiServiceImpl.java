package com.znyy.sm.service.impl;
import java.text.ParseException;
import java.util.List;

import com.znyy.sm.dao.TongJiDao;
import com.znyy.sm.service.TongJiService;

public class TongJiServiceImpl implements TongJiService {

	private TongJiDao tongJiDao;

	public TongJiDao getTongJiDao() {
	
		return tongJiDao;
	}

	public void setTongJiDao(TongJiDao tongJiDao) {
	
		this.tongJiDao = tongJiDao;
	}

	
	 /** 
	 * @方法名称: getMzlsList
	 * @功能描述: 获取麻醉例数统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-14 上午10:54:22
	 * @return
	 * @see com.znyy.sm.service.TongJiService#getMzlsList()
	 */
	 
	@Override
	public List getMzlsList(String yishi,String dateFrom, String dateTo) {

		return tongJiDao.getMzlsList(yishi,dateFrom,dateTo);
		
	}

	@Override
	public List getMzlsListAll(String yishi, String dateFrom,
			String dateTo) {
		
		return tongJiDao.getMzlsListAll(yishi,dateFrom,dateTo);
		
	}

	
	 /** 
	 * @方法名称: getAsaList
	 * @功能描述:获取ASA统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-18 下午1:23:21
	 * @return
	 * @throws ParseException 
	 * @see com.znyy.sm.service.TongJiService#getAsaList()
	 */
	 
	@Override
	public List getAsaList(String asaDateFrom, String asaDateTo, String asake,
			String asayi, String asahu, String xuanze) throws ParseException {
		
		return tongJiDao.getAsaList(asaDateFrom,asaDateTo,asake,
				asayi, asahu,xuanze);
	}

	
	 /** 
	 * @方法名称: getSqshList
	 * @功能描述:获取术前术后诊断统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-22 下午2:41:09
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 * @see com.znyy.sm.service.TongJiService#getSqshList(java.lang.String, java.lang.String)
	 */
	 
	@Override
	public List getSqshList(String dateFrom, String dateTo, String xuanze) {
		
		return tongJiDao.getSqshList(dateFrom,dateTo,xuanze);
		
	}

}
