package com.znyy.sm.service.impl;

import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.sm.dao.AnaesMethodDao;
import com.znyy.sm.service.AnaesMethodService;

public class AnaesMethodServiceImpl implements AnaesMethodService {

	private AnaesMethodDao anaesMethodDao;

	/**
	 * @方法名称: getMzffList
	 * @功能描述:获取麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:39:29
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffList(java.lang.String,
	 *      int, java.lang.Integer)
	 */

	@Override
	public Page getMzffList(String code,String mname, String cy, String yx, int parmpage, Integer pageSize) {

		return anaesMethodDao.getMzffList(code,mname,cy,yx, parmpage, pageSize);

	}

	/**
	 * @方法名称: getMzffById
	 * @功能描述:修改麻醉方法跳转
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午11:48:06
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffById(java.lang.String)
	 */

	@Override
	public SmAnaesMethod getMzffById(String id) {

		SmAnaesMethod sa = anaesMethodDao.getMzffById(id);
		return sa;

	}

	/**
	 * @方法名称: modMzffList
	 * @功能描述:修改麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:31:56
	 * @param sam
	 * @see com.znyy.sm.service.AnaesMethodService#modMzffList(com.znyy.bean.SmAnaesMethod)
	 */

	@Override
	public void modMzffList(SmAnaesMethod sam) {

		anaesMethodDao.modMzffList(sam);

	}

	/**
	 * @方法名称: addMzff
	 * @功能描述:添加麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午2:18:29
	 * @param sa
	 * @see com.znyy.sm.service.AnaesMethodService#addMzff(com.znyy.bean.SmAnaesMethod)
	 */

	@Override
	public void addMzff(SmAnaesMethod sa) {

		anaesMethodDao.addMzff(sa);

	}

	/**
	 * @方法名称: getMzffByName
	 * @功能描述:ajax验证麻醉方法名称
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午3:21:20
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffByName(java.lang.String)
	 */

	@Override
	public List<SmAnaesMethod> getMzffByName(String name) {

		return anaesMethodDao.getMzffByName(name);

	}

	/**
	 * @方法名称: getMzffByCode
	 * @功能描述:ajax验证麻醉方法代码
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午5:03:01
	 * @param code
	 * @return
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffByCode(java.lang.String)
	 */

	@Override
	public List<SmAnaesMethod> getMzffByCode(String code) {

		return anaesMethodDao.getMzffByCode(code);

	}

	public AnaesMethodDao getAnaesMethodDao() {

		return anaesMethodDao;
	}

	public void setAnaesMethodDao(AnaesMethodDao anaesMethodDao) {

		this.anaesMethodDao = anaesMethodDao;
	}

	
	 /** 
	 * @方法名称: getMzffList2
	 * @功能描述:选择麻醉方法列表
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:15:17
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffList2(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getMzffList2(String name, int parmpage, Integer pageSize) {
		return anaesMethodDao.getMzffList2(name, parmpage, pageSize);
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnaesMethodService#getMzffList2(java.lang.String)
	 */
	@Override
	public List getMzffList2(String name) {
		return anaesMethodDao.getMzffList2("");
	}

}
