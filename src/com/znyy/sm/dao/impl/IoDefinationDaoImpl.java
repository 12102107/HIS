package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmIoDefination;
import com.znyy.sm.dao.IoDefinationDao;

@SuppressWarnings("unchecked")
public class IoDefinationDaoImpl extends GenericDaoImpl<SmIoDefination, String>
		implements IoDefinationDao {

	/**
	 * @方法名称: getIoList
	 * @功能描述:获取出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午3:22:07
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.IoDefinationDao#getIoList(java.lang.String, int,
	 *      java.lang.Integer)
	 */

	@Override
	public Page getIoList(String name, String dw, String yx, String lx,
			String zlx, String jc, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page ios = new Page();
		if (name != null && !name.equals("") && dw != null && !dw.equals("")
				&& yx != null && !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and type = :lx and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && yx != null
				&& !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and enable = :yx "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and type = :lx  and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& lx != null && !lx.equals("") && zlx != null
				&& !zlx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and type = :lx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && yx != null
				&& !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name  and enable = :yx "
					+ "and type = :lx and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());

			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name  and enable = :yx "
					+ "and type = :lx  and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")
				&& jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name  and enable = :yx "
					+ "and type = :lx  and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			;
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")
				&& jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw   "
					+ "and type = :lx and sub_type = :zlx  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && lx != null && !lx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw  "
					+ "and type = :lx  and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && zlx != null && !zlx.equals("")
				&& jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw  "
					+ " and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and brief_name like :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")
				&& jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and dosage_unit like :dw and enable = :yx "
					+ "and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& lx != null && !lx.equals("") && zlx != null
				&& !zlx.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx "
					+ "and type = :lx and sub_type = :zlx  order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& lx != null && !lx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx "
					+ "and type = :lx and brief_name like :jc order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx "
					+ "and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx "
					+ "and type = :lx and sub_type = :zlx and brief_name like :jc order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and  dosage_unit like :dw and enable = :yx "
					+ "  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& lx != null && !lx.equals("")) {
			String sql = " select * from sm_io_defination where  dosage_unit like :dw and enable = :yx "
					+ "and type = :lx   order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && yx != null
				&& !yx.equals("") && lx != null && !lx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and enable = :yx "
					+ "and type = :lx  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && yx != null && !yx.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")
				&& jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and  dosage_unit like :dw   "
					+ "and type = :lx  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")
				&& zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx "
					+ " and sub_type = :zlx order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && yx != null
				&& !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and enable = :yx "
					+ " and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("") && zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and  dosage_unit like :dw  "
					+ " and sub_type = :zlx  order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where  dosage_unit like :dw  "
					+ "and type = :lx and sub_type = :zlx order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && lx != null
				&& !lx.equals("") && zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name "
					+ "and type = :lx and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("") && lx != null && !lx.equals("")
				&& zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx "
					+ "and type = :lx and sub_type = :zlx order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && dw != null
				&& !dw.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and  dosage_unit like :dw order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && yx != null
				&& !yx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and enable = :yx "
					+ " order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());

			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && lx != null
				&& !lx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name "
					+ "and type = :lx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && zlx != null
				&& !zlx.equals("")) {
			String sql = " select * from sm_io_defination where name like :name  "
					+ "and sub_type = :zlx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where name like :name and brief_name like  :jc order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && yx != null && !yx.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and enable = :yx order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && lx != null && !lx.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw "
					+ "and type = :lx order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && zlx != null
				&& !zlx.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw  "
					+ " and sub_type = :zlx order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw and brief_name like  :jc order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("") && lx != null && !lx.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx "
					+ "and type = :lx order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("") && zlx != null
				&& !zlx.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx "
					+ " and sub_type = :zlx order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx "
					+ " and brief_name like  :jc order by id  ";
			paramMap.put("yx", yx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (lx != null && !lx.equals("") && zlx != null
				&& !zlx.equals("")) {
			String sql = " select * from sm_io_defination where "
					+ " type = :lx and sub_type = :zlx order by id  ";

			paramMap.put("lx", lx.trim());
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (lx != null && !lx.equals("") && jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where "
					+ "  type = :lx and brief_name like  :jc order by id  ";
			paramMap.put("lx", lx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (zlx != null && !zlx.equals("") && jc != null
				&& !jc.equals("")) {
			String sql = " select * from sm_io_defination where sub_type = :zlx and brief_name like  :jc order by id  ";
			paramMap.put("zlx", zlx.trim());
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (name != null && !name.equals("")) {
			String sql = " select * from sm_io_defination where name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (dw != null && !dw.equals("")) {
			String sql = " select * from sm_io_defination where dosage_unit like :dw order by id  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_io_defination where enable = :yx order by id  ";
			paramMap.put("yx", yx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (lx != null && !lx.equals("")) {
			String sql = " select * from sm_io_defination where type = :lx order by id  ";
			paramMap.put("lx", lx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (zlx != null && !zlx.equals("")) {
			String sql = " select * from sm_io_defination where sub_type = :zlx order by id  ";
			paramMap.put("zlx", zlx.trim());
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else if (jc != null && !jc.equals("")) {
			String sql = " select * from sm_io_defination where brief_name like :jc order by id  ";
			paramMap.put("jc", "%" + jc.trim() + "%");
			ios = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmIoDefination.class);
		} else {
			String sql = "select * from sm_io_defination order by id";
			ios = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmIoDefination.class);
		}
		return ios;
	}

	/**
	 * @方法名称: getIoByName
	 * @功能描述:ajax验证出入量名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:26:47
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.IoDefinationDao#getIoByName(java.lang.String)
	 */

	@Override
	public List<SmIoDefination> getIoByName(String name) {
		String hql = " from SmIoDefination where name = ? ";

		List<SmIoDefination> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}

	/**
	 * @方法名称: addIo
	 * @功能描述:添加出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:36:02
	 * @param sio
	 * @see com.znyy.sm.dao.IoDefinationDao#addIo(com.znyy.bean.SmIoDefination)
	 */

	@Override
	public void addIo(SmIoDefination sio) {

		this.getHibernateTemplate().save(sio);

	}

	/**
	 * @方法名称: getIoById
	 * @功能描述:出入量修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午10:33:28
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.IoDefinationDao#getIoById(java.lang.Integer)
	 */

	@Override
	public SmIoDefination getIoById(Integer id) {
		String hql = "from SmIoDefination where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmIoDefination) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @方法名称: modIoList
	 * @功能描述:出入量修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午11:12:16
	 * @param sio
	 * @see com.znyy.sm.dao.IoDefinationDao#modIoList(com.znyy.bean.SmIoDefination)
	 */

	@Override
	public void modIoList(SmIoDefination io) {

		this.getHibernateTemplate().merge(io);
	}

	@Override
	public List<SmIoDefination> getLxList() {

		String hql = "select distinct type  from SmIoDefination";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<SmIoDefination> getZlxList() {

		String hql = "select distinct subType  from SmIoDefination";
		return this.getHibernateTemplate().find(hql);
	}

}
