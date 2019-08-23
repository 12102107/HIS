package com.znyy.bean;

import java.util.Date;
import java.util.Set;


 /** 
 * @类名称: XtFunction
 * @类描述:模块表
 * @作者:慕金剑
 * @创建时间:2015-12-7 下午1:09:03
 */
 
public class XtFunction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String funLevel;
	private Integer pid;
	private String url;
	private Integer sort;
	private Date enterdate;
	private Integer enterOpera;
	private String systemid;
	private String flag;
	private Set<XtPermission> pers;
	private Long hospitalId;
	
	public XtFunction() {
	}
	
	public XtFunction(Integer id) {
		this.id = id;
	}
	
	public XtFunction(String name) {
		this.name = name;
	}
	public XtFunction(Integer id, String name, String funLevel) {
		this.id = id;
		this.name = name;
		this.funLevel = funLevel;
	}

	public XtFunction(Integer id, String name, String funLevel, Integer pid,
			Date enterdate, Integer enterOpera,String url,String systemid,Set<XtPermission> pers) {
		this.id = id;
		this.name = name;
		this.funLevel = funLevel;
		this.pid = pid;
		this.enterdate = enterdate;
		this.enterOpera = enterOpera;
		this.url = url;
		this.systemid = systemid;
		this.pers = pers;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunLevel() {
		return this.funLevel;
	}

	public void setFunLevel(String funLevel) {
		this.funLevel = funLevel;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Date getEnterdate() {
		return this.enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<XtPermission> getPers() {
	
		return pers;
	}

	public void setPers(Set<XtPermission> pers) {
	
		this.pers = pers;
	}

	public String getFlag() {
	
		return flag;
	}

	public void setFlag(String flag) {
	
		this.flag = flag;
	}

	public Integer getSort() {
	
		return sort;
	}

	public void setSort(Integer sort) {
	
		this.sort = sort;
	}

	public String getSystemid() {
	
		return systemid;
	}

	public void setSystemid(String systemid) {
	
		this.systemid = systemid;
	}

	public Integer getEnterOpera() {
	
		return enterOpera;
	}

	public void setEnterOpera(Integer enterOpera) {
	
		this.enterOpera = enterOpera;
	}

	public Long getHospitalId() {
	
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
	
		this.hospitalId = hospitalId;
	}
}