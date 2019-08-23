package com.znyy.sm.service;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.bean.SmPortConfig;
import com.znyy.bean.SmWorkstation;

public interface WorkStationService {

	
	 /**
	 * @方法名称: getWsList
	 * @功能描述: 获取工作站信息
	 * @作者:付士山
	 * @创建时间:2016-7-12 上午10:26:30
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getWsList(String name, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: addStation
	 * @功能描述: 添加工作站
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午1:24:39
	 * @param ws void   
	 */
	 
	void addStation(SmWorkstation ws);


	List<SmWorkstation> checkId(String gzzId);


	SmWorkstation getWsById(String id);


	void modWsList(SmWorkstation wss);


	void addPortConfig(SmPortConfig port);


	List<SmPortConfig> getPort();


	SmPortConfig getPortByM(String model);


	void modPortList(SmPortConfig ps);


	Page getPList(int parmpage, Integer pageSize);


	SmPortConfig getPortById(Integer id);




}