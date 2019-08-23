package com.znyy.bean;

/**
 * SmMedicalStandard entity. @author MyEclipse Persistence Tools
 */

public class SmMedicalStandard implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String summary;
	private Integer pid;

	// Constructors

	/** default constructor */
	public SmMedicalStandard() {
	}

	/** full constructor */
	public SmMedicalStandard(String name, String summary, Integer pid) {
		this.name = name;
		this.summary = summary;
		this.pid = pid;
	}

	// Property accessors

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

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}