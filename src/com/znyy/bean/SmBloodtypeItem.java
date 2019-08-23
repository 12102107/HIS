package com.znyy.bean;



/**
 * SmBloodtypeItem entity. @author MyEclipse Persistence Tools
 */

public class SmBloodtypeItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bloodCode;
	private String bloodValue;
	private String ownerId;
	private String enable;

	// Constructors

	/** default constructor */
	public SmBloodtypeItem() {
	}

	/** full constructor */
	public SmBloodtypeItem(String bloodCode, String bloodValue, String ownerId,
			String enable) {
		this.bloodCode = bloodCode;
		this.bloodValue = bloodValue;
		this.ownerId = ownerId;
		this.enable = enable;
	}

	// Property accessors




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getBloodCode() {
		return bloodCode;
	}

	public void setBloodCode(String bloodCode) {
		this.bloodCode = bloodCode;
	}

	public String getBloodValue() {
		return bloodValue;
	}

	public void setBloodValue(String bloodValue) {
		this.bloodValue = bloodValue;
	}

}