package com.znyy.bean;

/**
 * SmInstrument entity. @author MyEclipse Persistence Tools
 */

public class SmInstrument implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String specifications;
	private String unit;
	private String common;
	private String enable;

	// Constructors

	/** default constructor */
	public SmInstrument() {
	}

	/** full constructor */
	public SmInstrument(String name, String specifications, String unit,
			String common, String enable) {
		this.name = name;
		this.specifications = specifications;
		this.unit = unit;
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

	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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