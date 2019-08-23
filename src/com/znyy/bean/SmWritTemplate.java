package com.znyy.bean;

/**
 * SmWritTemplate entity. @author MyEclipse Persistence Tools
 */

public class SmWritTemplate implements java.io.Serializable {

	// Fields

	private String id;
	private String wirtType;
	private String type;
	private String userid;
	private String wirtId;
	private String name;
	private String enable;

	// Constructors

	/** default constructor */
	public SmWritTemplate() {
	}

	/** full constructor */
	public SmWritTemplate(String wirtType, String type, String userid,
			String wirtId, String name) {
		this.wirtType = wirtType;
		this.type = type;
		this.userid = userid;
		this.wirtId = wirtId;
		this.name = name;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWirtType() {
		return this.wirtType;
	}

	public void setWirtType(String wirtType) {
		this.wirtType = wirtType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getWirtId() {
		return this.wirtId;
	}

	public void setWirtId(String wirtId) {
		this.wirtId = wirtId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enable
	 */
	public String getEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}

}