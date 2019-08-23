package com.znyy.sm.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmPortConfig;
import com.znyy.bean.SmWorkstation;
import com.znyy.sm.dao.WorkStationDao;
@SuppressWarnings("unchecked")
public class WorkStationDaoImpl extends GenericDaoImpl<SmWorkstation, String> implements
WorkStationDao {

	
	 /** 
	 * @方法名称: getWsList
	 * @功能描述:获取工作站信息
	 * @作者:付士山
	 * @创建时间:2016-7-12 上午10:26:41
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.WorkStationDao#getWsList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getWsList(String name, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page wss = new Page();
		String sql = " select * from sm_workstation";
		//paramMap.put("name", "%" + name.trim() + "%");
		wss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
				pageSize, SmWorkstation.class);
		return wss;
	}

	
	 /** 
	 * @方法名称: addStation
	 * @功能描述:添加工作站
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午1:25:56
	 * @param ws
	 * @see com.znyy.sm.dao.WorkStationDao#addStation(com.znyy.bean.SmWorkstation)
	 */
	 
	@Override
	public void addStation(SmWorkstation ws) {
		this.getHibernateTemplate().save(ws);
	}


	@Override
	public List<SmWorkstation> checkId(String gzzId) {
		String hql = " from SmWorkstation where id = ? ";

		List<SmWorkstation> list = this.getHibernateTemplate().find(hql, gzzId);
		return list;
	}


	@Override
	public SmWorkstation getWsById(String id) {
		return this.get(id);
	}


	@Override
	public void modWsList(SmWorkstation wss) {
		this.getHibernateTemplate().merge(wss);
		
	}


	@Override
	public void addPortConfig(SmPortConfig port) {
		this.getHibernateTemplate().save(port);
	}


	@Override
	public List<SmPortConfig> getPort() {
		String hql = " from SmPortConfig";

		List<SmPortConfig> list = this.getHibernateTemplate().find(hql);
		return list;
	}


	@Override
	public SmPortConfig getPortByM(String model) {
		String hql = "from SmPortConfig where model=?";
		List list = this.getHibernateTemplate().find(hql, model);
		if (!list.isEmpty()) {
			return (SmPortConfig) list.get(0);
		} else {
			return null;
		}
	}


	@Override
	public void modPortList(SmPortConfig ps) {
		this.getHibernateTemplate().merge(ps);
	}


	@Override
	public Page getPList( int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page wsss = new Page();
		String hql = "from SmPortConfig";
		wsss = this.findByHQLWithPage(hql, paramMap, parmpage,
				pageSize);
		return wsss;
	}

	@Override
	public SmPortConfig getPortById(Integer id) {
		return this.getHibernateTemplate().get(SmPortConfig.class, id);
	}

}