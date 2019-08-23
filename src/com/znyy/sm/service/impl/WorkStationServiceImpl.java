package com.znyy.sm.service.impl;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.bean.SmPortConfig;
import com.znyy.bean.SmWorkstation;
import com.znyy.sm.dao.WorkStationDao;
import com.znyy.sm.service.WorkStationService;

public class WorkStationServiceImpl implements WorkStationService {

	private WorkStationDao workStationDao;

	
	 /** 
	 * @方法名称: getWsList
	 * @功能描述:获取工作站信息
	 * @作者:付士山
	 * @创建时间:2016-7-12 上午10:26:21
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.WorkStationService#getWsList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getWsList(String name, int parmpage, Integer pageSize) {
		return workStationDao.getWsList(name,parmpage,pageSize);
	}

	public WorkStationDao getWorkStationDao() {
		return workStationDao;
	}

	public void setWorkStationDao(WorkStationDao workStationDao) {
		this.workStationDao = workStationDao;
	}

	
	 /** 
	 * @方法名称: addStation
	 * @功能描述:添加工作站
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午1:25:06
	 * @param ws
	 * @see com.znyy.sm.service.WorkStationService#addStation(com.znyy.bean.SmWorkstation)
	 */
	 
	@Override
	public void addStation(SmWorkstation ws) {
		workStationDao.addStation(ws);
	}

	@Override
	public List<SmWorkstation> checkId(String gzzId) {
		return workStationDao.checkId(gzzId);
	}

	@Override
	public SmWorkstation getWsById(String id) {

		return workStationDao.getWsById(id);
	}

	@Override
	public void modWsList(SmWorkstation wss) {
		workStationDao.modWsList(wss);
		
	}

	@Override
	public void addPortConfig(SmPortConfig port) {
		workStationDao.addPortConfig(port);
	}

	@Override
	public List<SmPortConfig> getPort() {
		return workStationDao.getPort();
	}

	@Override
	public SmPortConfig getPortByM(String model) {

		return workStationDao.getPortByM(model);
	}

	@Override
	public void modPortList(SmPortConfig ps) {
		workStationDao. modPortList(ps);
		
	}

	@Override
	public Page getPList(int parmpage, Integer pageSize) {
		return workStationDao.getPList(parmpage,pageSize);
	}

	@Override
	public SmPortConfig getPortById(Integer id) {
		return workStationDao.getPortById(id);
	}

	

}
