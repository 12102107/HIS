package com.znyy.bean;


/**
 * SmBodyPosition entity. @author MyEclipse Persistence Tools
 */

public class SmBodyPosition implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String operationId;
	private String itemValue;
	private String enable;
	private String itemName;

	// Constructors

	/** default constructor */
	public SmBodyPosition() {
	}

	/** full constructor */
	public SmBodyPosition(String operationId, String itemValue, String enable,String itemName) {
		this.operationId = operationId;
		this.itemValue = itemValue;
		this.enable = enable;
		this.itemName = itemName;
	}

	// Property accessors



	public String getOperationId() {
		return this.operationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getItemValue() {
		return this.itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}