package com.znyy.sm.service.impl;

import java.util.List;
import java.util.Map;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.sm.dao.RegOptDao;
import com.znyy.sm.service.RegOptService;

public class RegOptServiceImpl implements RegOptService {

	private RegOptDao regOptDao;

	public RegOptDao getRegOptDao() {
	
		return regOptDao;
	}

	public void setRegOptDao(RegOptDao regOptDao) {
	
		this.regOptDao = regOptDao;
	}

	
	 /** 
	 * @方法名称: addSsdj
	 * @功能描述:添加手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-18 上午9:47:18
	 * @param sro
	 * @see com.znyy.sm.service.RegOptService#addSsdj(com.znyy.bean.SmRegOpt)
	 */
	 
	@Override
	public void addSsdj(SmRegOpt sro) {
		
		regOptDao.addSsdj(sro);
		
	}

	
	 /** 
	 * @方法名称: getRoList
	 * @功能描述:查询手术登记列表
	 * @作者:付士山
	 * @创建时间:2016-1-20 下午1:56:05
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.RegOptService#getRoList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public List getRoList(String hospitalId) {
		
		return regOptDao.getRoList(hospitalId);
		
	}

	
	 /** 
	 * @方法名称: modSsdjListTo
	 * @功能描述:根据id查询手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午2:12:06
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.RegOptService#modSsdjListTo(java.lang.String)
	 */
	 
	@Override
	public SmRegOpt modSsdjListTo(String id) {
		SmRegOpt sro=regOptDao.modSsdjListTo(id);
		return sro;
		
	}

	
	 /** 
	 * @方法名称: modSsdjList
	 * @功能描述:修改手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午5:04:28
	 * @param sros
	 * @see com.znyy.sm.service.RegOptService#modSsdjList(com.znyy.bean.SmRegOpt)
	 */
	 
	@Override
	public void modSsdjList(SmRegOpt sros) {
		
		regOptDao.modSsdjList(sros);
		
	}

	@Override
	public void modSsapList1(SmRegOpt sros) {
		
		regOptDao.modSsdjList1(sros);
		
	}

	@Override
	public List<SmRegOpt> getRoYuYueList() {
		List<SmRegOpt> sros = regOptDao.getRoYuYueList();
		for(SmRegOpt sro:sros) {
			String roomid = sro.getRoom();
			SmOperroom room = regOptDao.getSmOperroomById(Integer.valueOf(roomid));
			sro.setRoom(room.getName());
		}
		return sros;
	}

	@Override
	public List<SmRegOpt> getMzysapList() {
		
		return regOptDao.getMzysapList();
	}

	@Override
	public List<SmRegOpt> getMzysList(String hospitalId) {
		List<SmRegOpt> sros = regOptDao.getMzysList(hospitalId);
		for(SmRegOpt sro:sros) {
			String roomid = sro.getRoom();
			SmOperroom room = regOptDao.getSmOperroomById(Integer.valueOf(roomid));
			sro.setRoom(room.getName());
		}
		return sros;
	}

	@Override
	public void modOSroReservation(String sroid, String roomid, String circunurse1,
			String circunurse2, String instrnurse1, String instrnurse2) {
		
		SmRegOpt sro = regOptDao.getSro(sroid);
		
		sro.setRoom(roomid);
		sro.setCircunurse1(circunurse1);
		sro.setCircunurse2(circunurse2);
		sro.setInstrnurse1(instrnurse1);
		sro.setInstrnurse2(instrnurse2);
		sro.setState("02");
		
		regOptDao.saveSro(sro);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RegOptService#getSroYuYueList()
	 */
	@Override
	public List<Map<String, Object>> getSroYuYueList(String hospitalId) {
		return regOptDao.getSroYuYueList(hospitalId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RegOptService#modMzysReservation(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void modMzysReservation(String sroid, String anesthetist,
			String circuanesthetist, String anaesAssistant) {
		
		SmRegOpt sro = regOptDao.getSro(sroid);
		
		sro.setAnesthetist(anesthetist);
		sro.setCircuanesthetist(circuanesthetist);
		sro.setAnaesAssistant(anaesAssistant);
		sro.setState("03");
		sro.setArchstate("00");
		
		regOptDao.saveSro(sro);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RegOptService#getSroMzysList()
	 */
	@Override
	public List<Map<String, Object>> getSroMzysList(String hospitalId) {
		return regOptDao.getSroMzysList(hospitalId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RegOptService#getSysCvFyzflbList()
	 */
	@Override
	public List<SysCvFyzflb> getSysCvFyzflbList() {
		return regOptDao.getSysCvFyzflbList();
	}

}
