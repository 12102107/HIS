package com.znyy.sm.dao.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.sm.dao.RegOptDao;

@SuppressWarnings("unchecked")
public class RegOptDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements
RegOptDao {

	
	 /** 
	 * @方法名称: addSsdj
	 * @功能描述:添加手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-18 上午9:48:09
	 * @param sro
	 * @see com.znyy.sm.dao.RegOptDao#addSsdj(com.znyy.bean.SmRegOpt)
	 */
	 
	@Override
	public void addSsdj(SmRegOpt sro) {
		
		this.getHibernateTemplate().save(sro);
		
	}

	
	 /** 
	 * @方法名称: getRoList
	 * @功能描述:查询手术登记列表
	 * @作者:付士山
	 * @创建时间:2016-1-20 下午1:57:33
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.RegOptDao#getRoList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public List getRoList(String hospitalId) {
		String hql=" from SmRegOpt where state='01' and hospitalId=? order by id";
		return this.getHibernateTemplate().find(hql,hospitalId);
		
	}


	
	 /** 
	 * @方法名称: modSsdjListTo
	 * @功能描述:根据id查询手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午2:14:36
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.RegOptDao#modSsdjListTo(java.lang.String)
	 */
	 
	@Override
	public SmRegOpt modSsdjListTo(String id) {
		String hql = "from SmRegOpt where id=?";	
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmRegOpt) list.get(0);
		} else {
			return null;
		
	}

	}


	
	 /** 
	 * @方法名称: modSsdjList
	 * @功能描述:修改手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午5:05:26
	 * @param sros
	 * @see com.znyy.sm.dao.RegOptDao#modSsdjList(com.znyy.bean.SmRegOpt)
	 */
	 
	@Override
	public void modSsdjList(SmRegOpt sros) {
		
	      this.getHibernateTemplate().merge(sros);
		
	}


	@Override
	public void modSsdjList1(SmRegOpt sros) {
		
		 this.getHibernateTemplate().merge(sros);
		
	}


	@Override
	public List<SmRegOpt> getRoYuYueList() {
		String hql=" from SmRegOpt where state='02' order by id";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public List<SmRegOpt> getMzysapList() {
		String hql=" from SmRegOpt where state='03' order by id";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public List<SmRegOpt> getMzysList(String hospitalId) {
		String hql=" from SmRegOpt where state='02' and hospitalId=? order by id";
		return this.getHibernateTemplate().find(hql,hospitalId);
	}


	@Override
	public SmRegOpt getSro(String sroid) {
		return this.get(sroid);
	}


	@Override
	public void saveSro(SmRegOpt sro) {
		this.save(sro);
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RegOptDao#getSmOperroomById(java.lang.Integer)
	 */
	@Override
	public SmOperroom getSmOperroomById(Integer valueOf) {
		return this.getHibernateTemplate().get(SmOperroom.class, valueOf);
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RegOptDao#getSroYuYueList()
	 */
	@Override
	public List<Map<String, Object>> getSroYuYueList(String hospitalId) {
		String sql = "select sro.name s,sro.sex,sro.age,sro.region,sro.dept,sro.diagnosis_name,sro.designed_opt_name,sro.operator_name,room.name r," +
					 " sro.operdate,sro.starttime,sro.circunurse1,sro.circunurse2 ,sro.instrnurse1,sro.instrnurse2,sro.id" +
					 " from SM_REG_OPT sro left join SM_OPERROOM room on room.id=sro.room  where sro.state='02' and sro.hospital_id=:h order by sro.id";
		Map m = new HashMap();
		m.put("h", hospitalId);
		List l = this.findBySql(sql,m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", objStr(o[0]));
			if(o[1].equals("1")) {
				map.put("sex", "女");
			}
			if(o[1].equals("0")) {
				map.put("sex", "男");
			}
			map.put("age", objStr(o[2]));
			map.put("region", objStr(o[3]));
			map.put("dept", objStr(o[4]));
			map.put("diagnosisName", objStr(o[5]));
			map.put("designedOptName", objStr(o[6]));
			map.put("operatorName", objStr(o[7]));
			map.put("room", objStr(o[8]));
			if(o[9]!=null) {
				DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				map.put("operdate", f.format((Date)o[9]));
			} else {
				map.put("operdate", "");
			}
			map.put("starttime", objStr(o[10]));
			map.put("circunurse1", objStr(o[11]));
			map.put("circunurse2", objStr(o[12]));
			map.put("instrnurse1", objStr(o[13]));
			map.put("instrnurse2", objStr(o[14]));
			map.put("id", o[15]);
			result.add(map);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RegOptDao#getSroMzysList()
	 */
	@Override
	public List<Map<String, Object>> getSroMzysList(String hospitalId) {
		String sql = "select sro.name s,sro.sex,sro.age,sro.region,sro.dept,sro.diagnosis_name,sro.designed_opt_name,sro.operator_name,room.name r," +
				 " sro.operdate,sro.starttime,sro.circunurse1,sro.circunurse2 ,sro.instrnurse1,sro.instrnurse2,sro.id," +
				 " sro.anesthetist,sro.circuanesthetist,sro.anaes_Assistant" +
				 " from SM_REG_OPT sro left join SM_OPERROOM room on room.id=sro.room  where sro.state='03' and sro.hospital_id=:h and sro.anesthetist is not null order by sro.id";
		Map m = new HashMap();
		m.put("h", hospitalId);
		List l = this.findBySql(sql,m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", objStr(o[0]));
			if(o[1].equals("1")) {
				map.put("sex", "女");
			}
			if(o[1].equals("0")) {
				map.put("sex", "男");
			}
			map.put("age", objStr(o[2]));
			map.put("region", objStr(o[3]));
			map.put("dept", objStr(o[4]));
			map.put("diagnosisName", objStr(o[5]));
			map.put("designedOptName", objStr(o[6]));
			map.put("operatorName", objStr(o[7]));
			map.put("room", objStr(o[8]));
//		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		map.put("operdate", f.format((Date)o[9]));
			if(o[9]!=null) {
				DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				map.put("operdate", f.format((Date)o[9]));
			} else {
				map.put("operdate", "");
			}
			map.put("starttime", objStr(o[10]));
			map.put("circunurse1", objStr(o[11]));
			map.put("circunurse2", objStr(o[12]));
			map.put("instrnurse1", objStr(o[13]));
			map.put("instrnurse2", objStr(o[14]));
			map.put("id", objStr(o[15]));
			map.put("anesthetist", objStr(o[16]));
			map.put("circuanesthetist", objStr(o[17]));
			map.put("anaesAssistant", objStr(o[18]));
			result.add(map);
		}
		return result;
	}

	private Object objStr(Object o) {
		if(o==null) {
			return "";
		} else {
			return o;
		}
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RegOptDao#getSysCvFyzflbList()
	 */
	@Override
	public List<SysCvFyzflb> getSysCvFyzflbList() {
		return this.getHibernateTemplate().find("from SysCvFyzflb where 1=1");
	}
	
}