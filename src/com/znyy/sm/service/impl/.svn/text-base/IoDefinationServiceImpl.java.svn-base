package com.znyy.sm.service.impl;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmIoDefination;
import com.znyy.sm.dao.IoDefinationDao;
import com.znyy.sm.service.IoDefinationService;

public class IoDefinationServiceImpl implements IoDefinationService {

	private IoDefinationDao ioDefinationDao;
	

	public IoDefinationDao getIoDefinationDao() {
	
		return ioDefinationDao;
	}

	public void setIoDefinationDao(IoDefinationDao ioDefinationDao) {
	
		this.ioDefinationDao = ioDefinationDao;
	}

	
	 /** 
	 * @方法名称: getIoList
	 * @功能描述:获取出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午3:20:49
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.IoDefinationService#getIoList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getIoList(String name, String dw, String yx, String lx,
			String zlx, String jc, int parmpage, Integer pageSize) {
		
		return ioDefinationDao.getIoList(name,dw,yx,lx,zlx,jc,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getIoByName
	 * @功能描述:ajax验证出入量名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:26:28
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.IoDefinationService#getIoByName(java.lang.String)
	 */
	 
	@Override
	public List<SmIoDefination> getIoByName(String name) {
		
		return ioDefinationDao.getIoByName(name);
		
	}

	
	 /** 
	 * @方法名称: addIo
	 * @功能描述:添加出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:35:58
	 * @param sio
	 * @see com.znyy.sm.service.IoDefinationService#addIo(com.znyy.bean.SmIoDefination)
	 */
	 
	@Override
	public void addIo(SmIoDefination sio) {
		
		ioDefinationDao.addIo(sio);
		
	}

	
	 /** 
	 * @方法名称: getIoById
	 * @功能描述:出入量修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午10:33:20
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.IoDefinationService#getIoById(java.lang.Integer)
	 */
	 
	@Override
	public SmIoDefination getIoById(Integer id) {
		SmIoDefination sio=ioDefinationDao.getIoById(id);
		return sio;
		
	}

	
	 /** 
	 * @方法名称: modIoList
	 * @功能描述:出入量修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午11:12:09
	 * @param sio
	 * @see com.znyy.sm.service.IoDefinationService#modIoList(com.znyy.bean.SmIoDefination)
	 */
	 
	@Override
	public void modIoList(SmIoDefination io) {
		
		ioDefinationDao.modIoList(io);
	}

	@Override
	public List<SmIoDefination> getLxList() {
		
		return ioDefinationDao. getLxList();
		
	}

	@Override
	public List<SmIoDefination> getZlxList() {
		
		return ioDefinationDao. getZlxList();
		
	}
	
}
