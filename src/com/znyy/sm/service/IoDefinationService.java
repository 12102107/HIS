package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmIoDefination;


 /** 
 * @类名称: IoDefinationService
 * @类描述:
 * @作者:付士山
 * @创建时间:2016-1-7 上午11:12:55
 */
 
public interface IoDefinationService {

	
	 /**
	 * @方法名称: getIoList
	 * @功能描述: 获取出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午3:20:26
	 * @param name
	 * @param jc 
	 * @param zlx 
	 * @param lx 
	 * @param yx 
	 * @param dw 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getIoList(String name, String dw, String yx, String lx, String zlx, String jc, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getIoByName
	 * @功能描述: ajax验证出入量名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:26:21
	 * @param name
	 * @return List<SmIoDefination>   
	 */
	 
	List<SmIoDefination> getIoByName(String name);


	
	 /**
	 * @方法名称: addIo
	 * @功能描述: 添加出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:36:17
	 * @param sio void   
	 */
	 
	void addIo(SmIoDefination sio);


	
	 /**
	 * @方法名称: getIoById
	 * @功能描述: 出入量修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午10:33:42
	 * @param id
	 * @return SmIoDefination   
	 */
	 
	SmIoDefination getIoById(Integer id);


	
	 /**
	 * @方法名称: modIoList
	 * @功能描述: 出入量修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午11:12:57
	 * @param sio void   
	 */
	 
	void modIoList(SmIoDefination io);


	List<SmIoDefination> getLxList();


	List<SmIoDefination> getZlxList();

	
}
