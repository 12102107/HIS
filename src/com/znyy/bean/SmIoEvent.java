package com.znyy.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * SmIoEvent entity. @author MyEclipse Persistence Tools
 */

public class SmIoEvent implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String operationId;
	private String itemId;
	private String type;
	private String name;
	private String dosage;
	private String dosageUnit;
	private Date starttime;
	private Date endtime;
	private String enable;
	private String spec;
	private String firm;
	private String minPackageUnit;
	private String amount;
	private String price;
	private String charge;
	private String passageWay;
	private Double startXpoint;
	private Double endXpoint;
	private Integer ypoint;

	// Constructors

	/** default constructor */
	public SmIoEvent() {
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

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}



	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getMinPackageUnit() {
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit) {
		this.minPackageUnit = minPackageUnit;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getPassageWay() {
		return passageWay;
	}

	public void setPassageWay(String passageWay) {
		this.passageWay = passageWay;
	}


	public Double getStartXpoint() {
		return startXpoint;
	}


	public void setStartXpoint(Double startXpoint) {
		this.startXpoint = startXpoint;
	}


	public Double getEndXpoint() {
		return endXpoint;
	}


	public void setEndXpoint(Double endXpoint) {
		this.endXpoint = endXpoint;
	}


	public Integer getYpoint() {
		return ypoint;
	}


	public void setYpoint(Integer ypoint) {
		this.ypoint = ypoint;
	}




	

}