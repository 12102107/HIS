package com.znyy.bean;

/**
 * SmInstrumentPackage entity. @author MyEclipse Persistence Tools
 */

public class SmInstrumentPackage implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String common;
	private String enable;

	// Constructors

	/** default constructor */
	public SmInstrumentPackage() {
	}

	/** full constructor */
	public SmInstrumentPackage(String name, String common, String enable) {
		this.name = name;
		this.common = common;
		this.enable = enable;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommon() {
		return this.common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}