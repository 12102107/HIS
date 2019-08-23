package com.znyy.sm.dao;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;


public interface AnaesMethodDao {

	
	 /**
	 * @方法名称: getMzffList
	 * @功能描述: 获取麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:40:58
	 * @param name
	 * @param yx 
	 * @param cy 
	 * @param mname 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	public Page getMzffList(String code,String mname, String cy, String yx, int parmpage, Integer pageSize);


	
	 /**
	 * @方法名称: getMzffById
	 * @功能描述: 修改麻醉方法跳转
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午11:49:01
	 * @param id
	 * @return SmAnaesMethod   
	 */
	 
	public SmAnaesMethod getMzffById(String id);


	 /**
	 * @方法名称: modMzffList
	 * @功能描述: 修改麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:34:46
	 * @param sam void   
	 */


	public void modMzffList(SmAnaesMethod sam);

	
	 /**
	 * @方法名称: addMzff
	 * @功能描述: 添加麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午2:18:07
	 * @param sa void   
	 */
	 
	public void addMzff(SmAnaesMethod sa);

	
	 /**
	 * @方法名称: getMzffByName
	 * @功能描述: ajax验证麻醉方法名称
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午3:21:13
	 * @param name
	 * @return List<SmAnaesMethod>   
	 */
	 
	public List<SmAnaesMethod> getMzffByName(String name);

	 /**
	 * @方法名称: getMzffByCode
	 * @功能描述:ajax验证麻醉方法代码 
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午5:02:51
	 * @param code
	 * @return List<SmAnaesMethod>   
	 */
	 
	public List<SmAnaesMethod> getMzffByCode(String code);



	
	 /**
	 * @方法名称: getMzffList2
	 * @功能描述: 选择麻醉方法列表
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:15:24
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	public Page getMzffList2(String name, int parmpage, Integer pageSize);



	/**
	 * @Description: 获取麻醉方法列表
	 * @param @param name
	 * @param @return   
	 * @return List  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-13
	 */
	public List getMzffList2(String name);

}