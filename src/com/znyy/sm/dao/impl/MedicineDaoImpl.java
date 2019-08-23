package com.znyy.sm.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmMedicine;
import com.znyy.sm.dao.MedicineDao;

@SuppressWarnings("unchecked")
public class MedicineDaoImpl extends GenericDaoImpl<SmMedicine, String> implements
MedicineDao {

	
	 /** 
	 * @方法名称: getMedList
	 * @功能描述:获取药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午9:44:06
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.MedicineDao#getMedList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getMedList(String name, String code, String fl, String dw,
			String pinyin, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page meds = new Page();
		if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx  and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else	if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx  and dosage_unit=:dw and pinyin LIKE :pinyin order by id  ";
	
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where rough_type=:fl and enable=:yx  and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx  and dosage_unit=:dw and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and enable=:yx  and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where rough_type=:fl and enable=:yx  and dosage_unit=:dw and pinyin LIKE :pinyin order by id  ";
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx  and dosage_unit=:dw order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and enable=:yx  and dosage_unit=:dw and pinyin LIKE :pinyin order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx and pinyin LIKE :pinyin order by id  "; 
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and dosage_unit=:dw and pinyin LIKE :pinyin order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where " +
					"rough_type=:fl and enable=:yx  and dosage_unit=:dw and name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&pinyin != null && 
				!pinyin.equals("")&& dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					" enable=:yx  and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					" rough_type=:fl and enable=:yx   and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where   " +
					" rough_type=:fl and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim()); 
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&& dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and enable=:yx  and dosage_unit=:dw and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl  and dosage_unit=:dw and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and enable=:yx   and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");	 
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and dosage_unit=:dw and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl  and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					" rough_type=:fl and enable=:yx  and dosage_unit=:dw order by id  ";
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (pinyin != null && 
				!pinyin.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					"  enable=:yx  and dosage_unit=:dw   and pinyin LIKE :pinyin order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else  if ( pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					"  rough_type=:fl and enable=:yx   and pinyin LIKE :pinyin order by id  "; 
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where  " +
					" rough_type=:fl  and dosage_unit=:dw  and pinyin LIKE :pinyin order by id  "; 
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and enable=:yx  and dosage_unit=:dw   order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( code != null && !code.equals("") &&fl != null && !fl.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl and enable=:yx  order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl  and dosage_unit=:dw   order by id  ";	 
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and  enable=:yx  and pinyin LIKE :pinyin order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("") &&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and  dosage_unit=:dw  and pinyin LIKE :pinyin order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("") &&dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					"  enable=:yx  and dosage_unit=:dw and name like :name   order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			 
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&fl != null && !fl.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where " +
					" rough_type=:fl and enable=:yx  and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());
			
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				) {
			String sql = " select * from sm_medicine where  " +
					"and rough_type=:fl  and dosage_unit=:dw and name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and enable=:yx   and name like :name   order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());

			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("") &&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and  dosage_unit=:dw and name like :name   order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%"); 
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("") ) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and name like :name  rder by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");

			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&&pinyin != null && 
				!pinyin.equals("")) {
			String sql = " select * from sm_medicine where   " +
					" name like :name and pinyin LIKE :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("") &&fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medicine where " +
					" rough_type=:fl  and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", fl.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("")&& dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where " +
					" dosage_unit=:dw and name like :name  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (name != null && !name.equals("") &&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					" enable=:yx   and name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")&&pinyin != null && 
				!pinyin.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and pinyin LIKE :pinyin order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");	 
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( code != null && !code.equals("") &&fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					"and rough_type=:fl order by id  ";
			 
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", fl.trim());
			 
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( code != null && !code.equals("") &&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and dosage_unit=:dw  order by id  ";	 
			paramMap.put("code", "%" + code.trim() + "%"); 
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( code != null && !code.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where hismedicine_code like :code " +
					" and enable=:yx order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( pinyin != null && 
				!pinyin.equals("")&&fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medicine where   " +
					"  rough_type=:fl  and pinyin LIKE :pinyin order by id  ";	 
			paramMap.put("fl", fl.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( pinyin != null && 
				!pinyin.equals("") &&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where  " +
					" dosage_unit=:dw  and pinyin LIKE :pinyin order by id  ";
			 
			paramMap.put("dw", dw.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if ( pinyin != null && 
				!pinyin.equals("") 
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					" enable=:yx  and  pinyin LIKE :pinyin order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( dw != null && !dw.equals("")
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where " +
					" enable=:yx  and dosage_unit=:dw  order by id  "; 
			paramMap.put("yx", yx.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( fl != null && !fl.equals("")&&dw != null && !dw.equals("")
				 ) {
			String sql = " select * from sm_medicine where  " +
					" rough_type=:fl  and dosage_unit=:dw  order by id  ";	 
			paramMap.put("fl", fl.trim());
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if ( fl != null && !fl.equals("") 
				&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where  " +
					"  rough_type=:fl and enable=:yx order by id  "; 
			paramMap.put("fl", fl.trim());
			paramMap.put("yx", yx.trim());		 
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (name != null && !name.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (code != null && !code.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and hismedicine_code like :code order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}else if (pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and pinyin LIKE :pinyin order by id  ";
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (fl != null && !fl.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and rough_type=:fl order by id  ";
			paramMap.put("fl", fl.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (dw != null && !dw.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and dosage_unit=:dw order by id  ";
			paramMap.put("dw", dw.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_medicine where 1=1 and enable=:yx order by id  ";
			paramMap.put("yx", yx.trim());
			meds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicine.class);
		}
		else {
			String sql = "select * from sm_medicine where 1=1 order by id";
			meds = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmMedicine.class);
		}
		return meds;
	}

	
	 /** 
	 * @方法名称: getMedById
	 * @功能描述:药品库修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:45:17
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.MedicineDao#getMedById(java.lang.Integer)
	 */
	 
	@Override
	public SmMedicine getMedById(Integer id) {
		String hql = "from SmMedicine where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmMedicine) list.get(0);
		} else {
			return null;
	}
  }


	
	 /** 
	 * @方法名称: modMedList
	 * @功能描述:药品库修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:52:51
	 * @param smed
	 * @see com.znyy.sm.dao.MedicineDao#modMedList(com.znyy.bean.SmMedicine)
	 */
	 
	@Override
	public void modMedList(SmMedicine smed) {
		
		this.getHibernateTemplate().merge(smed);
		
	}


	
	 /** 
	 * @方法名称: getMedByName
	 * @功能描述:ajax验证药品库名称
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:14:32
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.MedicineDao#getMedByName(java.lang.String)
	 */
	 
	@Override
	public List<SmMedicine> getMedByName(String name) {
		String hql = " from SmMedicine where name = ? ";
		List<SmMedicine> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}


	
	 /** 
	 * @方法名称: addMed
	 * @功能描述:添加药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:29:25
	 * @param med
	 * @see com.znyy.sm.dao.MedicineDao#addMed(com.znyy.bean.SmMedicine)
	 */
	 
	@Override
	public void addMed(SmMedicine med) {
		
		this.getHibernateTemplate().save(med);
		
	}


	@Override
	public List<SmMedicine> getDwList() {
		
		String hql = "select distinct dosageUnit  from SmMedicine";
		return this.getHibernateTemplate().find(hql);
		
	}


	@Override
	public List<SmMedicine> getFlList() {
		

		String hql = "select distinct roughType  from SmMedicine";
		return this.getHibernateTemplate().find(hql);
		
	}
}
