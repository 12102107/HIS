package com.znyy.bean;

import java.util.Set;
 /** 
 * @类名称: XtFunButton
 * @类描述:模块按钮表
 * @作者:慕金剑
 * @创建时间:2015-12-21 下午3:35:06
 */
public class XtFunButton implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String flag;
	private String code;
	private Long hospitalId;
	
	//模块按钮关系表一对多
	private Set<XtPermission> pers;

	public XtFunButton() {
	}

	public XtFunButton(String name, String flag,String code) {
		this.name = name;
		this.flag = flag;
		this.code=code;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Set<XtPermission> getPers() {
	
		return pers;
	}

	public void setPers(Set<XtPermission> pers) {
	
		this.pers = pers;
	}

	public String getCode() {
	
		return code;
	}

	public void setCode(String code) {
	
		this.code = code;
	}

	public Long getHospitalId() {
	
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
	
		this.hospitalId = hospitalId;
	}

}