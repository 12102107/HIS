/**  
 * @Title: InstrumentServiceImpl.java
 * @Package com.znyy.sm.service.impl
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
package com.znyy.sm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.SmInstrument;
import com.znyy.bean.SmInstrumentCheck;
import com.znyy.bean.SmInstrumentPackage;
import com.znyy.bean.SmInstrumentPackageItem;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.dao.InstrumentDao;
import com.znyy.sm.dao.QueryDao;
import com.znyy.sm.service.InstrumentService;

/**
 * ClassName: InstrumentServiceImpl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
public class InstrumentServiceImpl implements InstrumentService {
	
	private InstrumentDao instrumentDao;

	/**
	 * @return the instrumentDao
	 */
	public InstrumentDao getInstrumentDao() {
		return instrumentDao;
	}

	/**
	 * @param instrumentDao the instrumentDao to set
	 */
	public void setInstrumentDao(InstrumentDao instrumentDao) {
		this.instrumentDao = instrumentDao;
	}

	private QueryDao queryDao;

	/**
	 * @return the queryDao
	 */
	public QueryDao getQueryDao() {
		return queryDao;
	}

	/**
	 * @param queryDao the queryDao to set
	 */
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentList(java.lang.String, java.lang.String, int, java.lang.Integer)
	 */
	@Override
	public Page getInstrumentList(String name, String common, int parmpage,
			Integer pageSize) {
		return instrumentDao.getInstrumentList(name,common,parmpage,pageSize);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#addInstrument(com.znyy.bean.SmInstrument)
	 */
	@Override
	public void addInstrument(SmInstrument i) {
		i.setEnable("0");
		instrumentDao.saveInstrument(i);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentById(java.lang.String)
	 */
	@Override
	public SmInstrument getInstrumentById(String id) {
		return instrumentDao.getInstrumentById(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#modInstrument(com.znyy.bean.SmInstrument)
	 */
	@Override
	public void modInstrument(SmInstrument i) {
		SmInstrument instrument = instrumentDao.getInstrumentById(i.getId());
		instrument.setCommon(i.getCommon());
		instrument.setName(i.getName());
		instrument.setSpecifications(i.getSpecifications());
		instrument.setUnit(i.getUnit());
		instrumentDao.saveInstrument(instrument);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#delInstrument(java.lang.String)
	 */
	@Override
	public void delInstrument(String id) {
		SmInstrument i = instrumentDao.getInstrumentById(id);
		instrumentDao.delInstrument(i);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentPackageList(java.lang.String, java.lang.String, int, java.lang.Integer)
	 */
	@Override
	public Page getInstrumentPackageList(String name, String common,
			int parmpage, Integer pageSize) {
		return instrumentDao.getInstrumentPackageList(name,common,parmpage,pageSize);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentList()
	 */
	@Override
	public List<SmInstrument> getInstrumentList() {
		return instrumentDao.getInstrumentList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#addInstrumentPackage(com.znyy.bean.SmInstrumentPackage, java.util.List, java.util.List)
	 */
	@Override
	public void addInstrumentPackage(SmInstrumentPackage p, List<String> iid,
			List<String> inum) {
		p.setEnable("0");
		instrumentDao.saveInstrumentPackage(p);
		for(int i=0;i<iid.size();i++) {
			SmInstrument instrument = instrumentDao.getInstrumentById(iid.get(i));
			SmInstrumentPackageItem item = new SmInstrumentPackageItem();
			item.setEnable("0");
			item.setInstrumentId(instrument);
			item.setPackageId(p);
			item.setNum(Short.valueOf(inum.get(i)));
			instrumentDao.saveInstrumentPackageItem(item);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentPackageById(java.lang.String)
	 */
	@Override
	public SmInstrumentPackage getInstrumentPackageById(String id) {
		return instrumentDao.getInstrumentPackageById(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getPackageItemList(java.lang.String)
	 */
	@Override
	public List<SmInstrumentPackageItem> getPackageItemList(String id) {
		return instrumentDao.getPackageItemList(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#modInstrumentPackage(com.znyy.bean.SmInstrumentPackage, java.util.List, java.util.List)
	 */
	@Override
	public void modInstrumentPackage(SmInstrumentPackage p, List<String> iid,
			List<String> inum) {
		SmInstrumentPackage ip = instrumentDao.getInstrumentPackageById(p.getId());
		ip.setCommon(p.getCommon());
		ip.setName(p.getName());
		instrumentDao.saveInstrumentPackage(ip);
		
		List<SmInstrumentPackageItem> items = instrumentDao.getPackageItemList(ip.getId());
		for(SmInstrumentPackageItem item:items) {
			instrumentDao.delPackageItem(item);
		}
		
		for(int i=0;i<iid.size();i++) {
			SmInstrument instrument = instrumentDao.getInstrumentById(iid.get(i));
			SmInstrumentPackageItem item = new SmInstrumentPackageItem();
			item.setEnable("0");
			item.setInstrumentId(instrument);
			item.setPackageId(p);
			item.setNum(Short.valueOf(inum.get(i)));
			instrumentDao.saveInstrumentPackageItem(item);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#delInstrumentPackage(java.lang.String)
	 */
	@Override
	public void delInstrumentPackage(String id) {
		SmInstrumentPackage i = instrumentDao.getInstrumentPackageById(id);
		i.setEnable("1");
		instrumentDao.saveInstrumentPackage(i);
		
		List<SmInstrumentPackageItem> items = instrumentDao.getPackageItemList(id);
		for(SmInstrumentPackageItem item:items) {
			item.setEnable("1");
			instrumentDao.saveInstrumentPackageItem(item);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getSmRegOpt(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOpt(String id) {
		return queryDao.getSmRegOptById(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentPackage()
	 */
	@Override
	public List<Map<String, Object>> getInstrumentPackage() {
		List<Map<String, Object>> ip = instrumentDao.getInstrumentPackage();
		for(Map<String,Object> m:ip) {
			List<SmInstrumentPackageItem> items = instrumentDao.getPackageItemList(m.get("id").toString());
			List<Map<String, Object>> item = new ArrayList<Map<String, Object>>();
			for(SmInstrumentPackageItem i:items) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("name", i.getInstrumentId().getName());
				map.put("num", i.getNum());
				map.put("unit", i.getInstrumentId().getUnit());
				item.add(map);
			}
			m.put("instrument", item);
		}
		return ip;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentInfo(java.lang.String)
	 */
	@Override
	public Map<String, String> getInstrumentInfo(String id) {
		SmInstrument i =  instrumentDao.getInstrumentById(id);
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", i.getId());
		map.put("name", i.getName());
		map.put("specifications", i.getSpecifications());
		map.put("unit", i.getUnit());
		return map;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#saveOrUpdateInstrumentCheck(java.lang.String, java.util.List, java.util.List, java.util.List)
	 */
	@Override
	public void saveOrUpdateInstrumentCheck(String id, List<String> iid,
			List<String> itype, List<String> inum) {
		SmRegOpt sro = queryDao.getSmRegOptById(id);
		
		List<SmInstrumentCheck> c = instrumentDao.getInstrumentCheckList(id);
		for(SmInstrumentCheck check:c) {
			instrumentDao.delInstrumentCheck(check);
		}
		
		for(int i=0;i<iid.size();i++) {
			SmInstrumentCheck check = new SmInstrumentCheck();
			check.setOperationId(sro);
			check.setInstrumentId(iid.get(i));
			check.setType(itype.get(i));
			check.setOperationBefore(Short.valueOf(inum.get(i)));
			instrumentDao.saveInstrumentCheck(check);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentCheckPackage(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getInstrumentCheckPackage(String id) {
		return instrumentDao.getInstrumentCheckPackage(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getInstrumentCheckInstrument(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getInstrumentCheckInstrument(String id) {
		return instrumentDao.getInstrumentCheckInstrument(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getPrintInfo(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getPrintInfo(String id) {
		SmRegOpt sro = queryDao.getSmRegOptById(id);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", sro.getName());
		if(sro.getSex().equals("0")) {
			map.put("sex", "男");
		}
		if(sro.getSex().equals("1")) {
			map.put("sex", "女");
		}
		map.put("age", sro.getAge());
		map.put("dept", sro.getDept());
		map.put("bed", sro.getBed());
		map.put("hid", sro.getHid());
		map.put("optName", sro.getDesignedOptName());
		if("0".equals(sro.getType())) {
			map.put("optType", "急诊");
		}
		if("1".equals(sro.getType())) {
			map.put("optType", "择期");
		}
		list.add(map);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getPrintList(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getPrintList(String id) {
		List<Map<String, Object>> plist = instrumentDao.getInstrumentCheckPackage(id);
		List<Map<String, Object>> ilist =  instrumentDao.getInstrumentCheckInstrument(id);
		for(Map<String, Object> map:plist) {
			List<SmInstrumentPackageItem> items = instrumentDao.getPackageItemList(map.get("id").toString());
			for(SmInstrumentPackageItem i:items) {
				boolean ex = true;
				for(Map<String, Object> m:ilist) {
					if(m.get("id").equals(i.getInstrumentId().getId())) {
						m.put("num", Short.valueOf(m.get("num").toString())+i.getNum());
						ex = false;
					}
				}
				if(ex) {
					Map<String, Object> instrument = new HashMap<String,Object>();
					instrument.put("id", i.getInstrumentId().getId());
					instrument.put("num", i.getNum());
					instrument.put("name", i.getInstrumentId().getName());
					instrument.put("unit", i.getInstrumentId().getUnit());
					instrument.put("specifications", i.getInstrumentId().getSpecifications());
					ilist.add(instrument);
				}
			}
		}
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(ilist.size()>18) {
			for(int i=0;i<18;i++) {
				Map<String, Object> instrument = new HashMap<String,Object>();
				instrument.put("iname", ilist.get(i).get("name"));
				instrument.put("unit", ilist.get(i).get("unit"));
				instrument.put("operation_before", ilist.get(i).get("num"));
				result.add(instrument);
			}
			for(int i=18;i<ilist.size();i++) {
				Map<String, Object> instrument = new HashMap<String,Object>();
				instrument.put("iname1", ilist.get(i).get("name"));
				instrument.put("unit1", ilist.get(i).get("unit"));
				instrument.put("operation_before1", ilist.get(i).get("num"));
				result.add(instrument);
			}
			for(int i=result.size();i<36;i++) {
				Map<String, Object> instrument = new HashMap<String,Object>();
				instrument.put("iname", "");
				instrument.put("unit", "");
				instrument.put("operation_before", "");
				result.add(instrument);
			}
		} else {
			for(Map<String, Object> m:ilist) {	
				Map<String, Object> instrument = new HashMap<String,Object>();
				instrument.put("iname", m.get("name"));
				instrument.put("unit", m.get("unit"));
				instrument.put("operation_before", m.get("num"));
				result.add(instrument);
			}
			for(int i=result.size();i<18;i++) {
				Map<String, Object> instrument = new HashMap<String,Object>();
				instrument.put("iname", "");
				instrument.put("unit", "");
				instrument.put("operation_before", "");
				result.add(instrument);
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getCheckNameSpecifications(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean getCheckNameSpecifications(String name, String specifications) {
		SmInstrument r = instrumentDao.getSmInstrumentByNameSpecifications(name,specifications);
		if(r==null) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.InstrumentService#getCheckPackageName(java.lang.String)
	 */
	@Override
	public boolean getCheckPackageName(String name) {
		SmInstrumentPackage r = instrumentDao.getSmInstrumentPackageByName(name);
		if(r==null) {
			return false;
		}
		return true;
	}
}
