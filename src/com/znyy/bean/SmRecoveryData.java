package com.znyy.bean;


import java.util.Date;

/**
 * SmRecoveryData entity. @author MyEclipse Persistence Tools
 */

public class SmRecoveryData implements java.io.Serializable {

	// Fields

	private Integer id;
	private String operationId;
	private Date time;
	private Integer remarkInterval;
	private Double bpSys;
	private Double bpDias;
	private Double heartrate;
	private Double resprate;
	private Double spo2;
	private String createuser;

	// Constructors

	/** default constructor */
	public SmRecoveryData() {
	}

	/** full constructor */
	public SmRecoveryData(String operationId, Date time,
			Integer remarkInterval, Double bpSys, Double bpDias, Double heartrate,
			Double resprate, Double spo2, String createuser) {
		this.operationId = operationId;
		this.time = time;
		this.remarkInterval = remarkInterval;
		this.bpSys = bpSys;
		this.bpDias = bpDias;
		this.heartrate = heartrate;
		this.resprate = resprate;
		this.spo2 = spo2;
		this.createuser = createuser;
	}

	// Property accessors



	public String getOperationId() {
		return this.operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}



	public Double getBpSys() {
		return this.bpSys;
	}

	public void setBpSys(Double bpSys) {
		this.bpSys = bpSys;
	}

	public Double getBpDias() {
		return this.bpDias;
	}

	public void setBpDias(Double bpDias) {
		this.bpDias = bpDias;
	}

	public Double getHeartrate() {
		return this.heartrate;
	}

	public void setHeartrate(Double heartrate) {
		this.heartrate = heartrate;
	}

	public Double getResprate() {
		return this.resprate;
	}

	public void setResprate(Double resprate) {
		this.resprate = resprate;
	}

	public Double getSpo2() {
		return this.spo2;
	}

	public void setSpo2(Double spo2) {
		this.spo2 = spo2;
	}

	public String getCreateuser() {
		return this.createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getRemarkInterval() {
		return remarkInterval;
	}

	public void setRemarkInterval(Integer remarkInterval) {
		this.remarkInterval = remarkInterval;
	}

}