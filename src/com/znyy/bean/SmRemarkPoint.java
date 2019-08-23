package com.znyy.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * SmRemarkPoint entity. @author MyEclipse Persistence Tools
 */

public class SmRemarkPoint implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String operationId;
	private Date time;
	private String itemCode;
	private Double value;
	private Date refTime;
	private String isUpdated;
	private String concept;
	private String hospitalCode;
	private String roomCode;
	// Constructors

	/** default constructor */
	public SmRemarkPoint() {
	}
	
	

	public String getOperationId() {
		return this.operationId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}



	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getRefTime() {
		return refTime;
	}

	public void setRefTime(Date refTime) {
		this.refTime = refTime;
	}

	public String getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(String isUpdated) {
		this.isUpdated = isUpdated;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	
	
	
	
	

}