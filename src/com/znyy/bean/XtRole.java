package com.znyy.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @类名称: XtRole
 * @类描述: 角色类
 * @作者:秦向红
 * @创建时间:2015-12-7 下午12:56:10
*/
 
public class XtRole implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String ename;
	private String flag;
	private String code;
	private String description;
	private Date enterdate;
	private Integer enteropera;
	private Set<XtUser> users = new HashSet<XtUser>();  
	private Set<XtPermission> rolepers;
	private String type;
	private String systemid;
	private Long hospitalId;

	// Constructors

	/** default constructor */
	public XtRole() {
	}
	
	public XtRole(Short id) {
	}

	/** full constructor */
	public XtRole(String name, String ename, String flag, String code,
			String description, Date enterdate, Integer enteropera, Set users,
			Set<XtPermission> rolepers,String systemid) {
		super();
		this.name = name;
		this.ename = ename;
		this.flag = flag;
		this.code = code;
		this.description = description;
		this.enterdate = enterdate;
		this.enteropera = enteropera;
		this.users = users;
		this.rolepers = rolepers;
		this.systemid = systemid;
	}

	// Property accessors


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Set<XtUser> getUsers() {
		return users;
	}

	public void setUsers(Set<XtUser> users) {
		this.users = users;
	}

	public String getCode() {
	
		return code;
	}

	public void setCode(String code) {
	
		this.code = code;
	}

	public String getDescription() {
	
		return description;
	}

	public void setDescription(String description) {
	
		this.description = description;
	}

	public Date getEnterdate() {
	
		return enterdate;
	}

	public void setEnterdate(Date enterdate) {
	
		this.enterdate = enterdate;
	}


	public Set<XtPermission> getRolepers() {
	
		return rolepers;
	}

	public void setRolepers(Set<XtPermission> rolepers) {
	
		this.rolepers = rolepers;
	}

	public String getType() {
	
		return type;
	}

	public void setType(String type) {
	
		this.type = type;
	}

	public String getSystemid() {
	
		return systemid;
	}

	public void setSystemid(String systemid) {
	
		this.systemid = systemid;
	}

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
	
		this.id = id;
	}

	public Integer getEnteropera() {
	
		return enteropera;
	}

	public void setEnteropera(Integer enteropera) {
	
		this.enteropera = enteropera;
	}

	public Long getHospitalId() {
	
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
	
		this.hospitalId = hospitalId;
	}

}