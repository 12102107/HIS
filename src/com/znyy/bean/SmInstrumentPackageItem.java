package com.znyy.bean;

/**
 * SmInstrumentPackageItem entity. @author MyEclipse Persistence Tools
 */

public class SmInstrumentPackageItem implements java.io.Serializable {

	// Fields

	private String id;
	private SmInstrumentPackage packageId;
	private SmInstrument instrumentId;
	private Short num;
	private String enable;

	// Constructors

	/** default constructor */
	public SmInstrumentPackageItem() {
	}

	/** full constructor */
	public SmInstrumentPackageItem(SmInstrumentPackage packageId, SmInstrument instrumentId,
			Short num, String enable) {
		this.packageId = packageId;
		this.instrumentId = instrumentId;
		this.num = num;
		this.enable = enable;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SmInstrumentPackage getPackageId() {
		return this.packageId;
	}

	public void setPackageId(SmInstrumentPackage packageId) {
		this.packageId = packageId;
	}

	public SmInstrument getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(SmInstrument instrumentId) {
		this.instrumentId = instrumentId;
	}

	public Short getNum() {
		return this.num;
	}

	public void setNum(Short num) {
		this.num = num;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}