package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
public interface OperationPeopleService {

	

 /**
 * @方法名称: getSpList
 * @功能描述: 获取手术人员列表
 * @作者:付士山
 * @创建时间:2015-12-28 上午10:13:16
 * @param name
 * @param yx 
 * @param lx 
 * @param lb 
 * @param parmpage
 * @param pageSize
 * @return Page   
 */
 
public Page getSpList(String code,String lb, String lx, String yx, int parmpage, Integer pageSize);



 /**
 * @方法名称: getSpById
 * @功能描述: 修改手术人员信息跳转
 * @作者:付士山
 * @创建时间:2015-12-28 下午1:18:53
 * @param id
 * @return SmOperationPeople   
 */
public SmOperationPeople getSpById(Integer id);


 /**
 * @方法名称: modSpList
 * @功能描述: 修改手术人员信息
 * @作者:付士山
 * @创建时间:2015-12-28 下午1:56:59
 * @param sp void   
 */
 
public void modSpList(SmOperationPeople sp);


 /**
 * @方法名称: addSp
 * @功能描述: 添加手术人员信息
 * @作者:付士山
 * @创建时间:2015-12-28 下午2:46:08
 * @param sp void   
 */


public void addSp(SmOperationPeople sp);


 /**
 * @方法名称: getSpByName
 * @功能描述: ajax验证手术人员名称
 * @作者:付士山
 * @创建时间:2015-12-28 下午3:13:21
 * @param name
 * @return List<SmOperationPeople>   
 */


public List<SmOperationPeople> getSpByName(String name);


 /**
 * @方法名称: getSpByCode
 * @功能描述: ajax验证手术人员代码
 * @作者:付士山
 * @创建时间:2015-12-28 下午3:44:49
 * @param code
 * @return List<SmOperationPeople>   
 */

public List<SmOperationPeople> getSpByCode(int code);



public List<SmOperationPeople> getSops(String string, String string2);




 /**
 * @方法名称: getSopsByZimu
 * @功能描述: AJAX联动查询手术人员
 * @作者:付士山
 * @创建时间:2016-1-18 下午3:16:35
 * @param zimu
 * @return List<SmOperationPeople>   
 */
 
public List<SmOperationPeople> getSopsByZimu(String zimu);

/**
* @方法名称: getSqzdNameByZimu
* @功能描述: AJAX联动查询术前诊断
* @作者:崔连瑞
* @创建时间:2016-4-28 下午3:16:35
* @param zimu
* @return List<SmDiagnosedef>   
*/

public List<SmDiagnosedef> getSqzdNameByZimu(String zimu);

/**
 * @方法名称: getSqzdNameByZimu
 * @功能描述: AJAX联动查询拟施手术
 * @作者:崔连瑞
 * @创建时间:2016-4-28 下午3:16:35
 * @param zimu
 * @return List<SmDiagnosedef>   
 */

public List<SmOperdef> getNsssNameByZimu(String zimu);




 /**
 * @方法名称: getOpList
 * @功能描述: 查询麻醉医师列表
 * @作者:付士山
 * @创建时间:2016-2-24 上午11:36:34
 * @param string
 * @return List<SmOperationPeople>   
 */
 
public List<SmOperationPeople> getOpList(String string);



/**
 * @Title: getOperatorNameById 
 * @Description: 查询手术人员名字
 * @author 白东旭
 * @date 2016-2-19 下午4:21:08
 * @param @param operatorId
 * @param @return
 * @return String
 * @throws 
 *
 */ 

public String getOperatorNameById(String operatorId);



public List<SmOperationPeople> getLxList();



public List<SmOperationPeople> getAnesthetistersByRole(String yishiRole);



public List<SmOperationPeople> getAnesthetistersByPy(String zimu);



public List<SmOperationPeople> AnesthetistersByyishiName(String yishiName);



public List<SmOperationPeople> getAnesthetistersByPy1(String zimu);



public List<SmOperationPeople> getAnesthetistersByPy2(String zimu);






}