package com.znyy.bean;

/**
 * SmInstrumentCheck entity. @author MyEclipse Persistence Tools
 */

public class SmInstrumentCheck implements java.io.Serializable {

	// Fields

	private String id;
	private SmRegOpt operationId;
	private String instrumentId;
	private String type;
	private Short operationBefore;
	private Short operationAfter;
	private Short closeBefore;
	private Short closeAfter;

	// Constructors

	/** default constructor */
	public SmInstrumentCheck() {
	}

	/** full constructor */
	public SmInstrumentCheck(SmRegOpt operationId, String instrumentId,
			String type, Short operationBefore, Short operationAfter,
			Short closeBefore, Short closeAfter) {
		this.operationId = operationId;
		this.instrumentId = instrumentId;
		this.type = type;
		this.operationBefore = operationBefore;
		this.operationAfter = operationAfter;
		this.closeBefore = closeBefore;
		this.closeAfter = closeAfter;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SmRegOpt getOperationId() {
		return this.operationId;
	}

	public void setOperationId(SmRegOpt operationId) {
		this.operationId = operationId;
	}

	public String getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Short getOperationBefore() {
		return this.operationBefore;
	}

	public void setOperationBefore(Short operationBefore) {
		this.operationBefore = operationBefore;
	}

	public Short getOperationAfter() {
		return this.operationAfter;
	}

	public void setOperationAfter(Short operationAfter) {
		this.operationAfter = operationAfter;
	}

	public Short getCloseBefore() {
		return this.closeBefore;
	}

	public void setCloseBefore(Short closeBefore) {
		this.closeBefore = closeBefore;
	}

	public Short getCloseAfter() {
		return this.closeAfter;
	}

	public void setCloseAfter(Short closeAfter) {
		this.closeAfter = closeAfter;
	}

}