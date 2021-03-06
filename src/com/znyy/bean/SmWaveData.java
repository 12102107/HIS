package com.znyy.bean;

import java.util.Date;

/**
 * SmWaveData entity. @author MyEclipse Persistence Tools
 */

public class SmWaveData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String operationId;
	private Date time;
	private Integer remarkInterval;
	private Double resprate;
	private Double pulserate;
	private Double bpSys;
	private Double bpDias;
	private Double bpMean;
	private Double heartrate;
	private Double temp;
	private Double vtidalvol;
	private Double petco2;
	private Double ibpwCv;
	private Double bloodpres;
	private Double spo2;
	private String createuser;
	private Integer xpoint;
	

	// Constructors

	/** default constructor */
	public SmWaveData() {
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

	public Double getResprate() {
		return this.resprate;
	}

	public void setResprate(Double resprate) {
		this.resprate = resprate;
	}

	public Double getPulserate() {
		return this.pulserate;
	}

	public void setPulserate(Double pulserate) {
		this.pulserate = pulserate;
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

	public Double getBpMean() {
		return this.bpMean;
	}

	public void setBpMean(Double bpMean) {
		this.bpMean = bpMean;
	}

	public Double getHeartrate() {
		return this.heartrate;
	}

	public void setHeartrate(Double heartrate) {
		this.heartrate = heartrate;
	}

	public Double getTemp() {
		return this.temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getVtidalvol() {
		return this.vtidalvol;
	}

	public void setVtidalvol(Double vtidalvol) {
		this.vtidalvol = vtidalvol;
	}

	public Double getPetco2() {
		return this.petco2;
	}

	public void setPetco2(Double petco2) {
		this.petco2 = petco2;
	}

	public Double getIbpwCv() {
		return this.ibpwCv;
	}

	public void setIbpwCv(Double ibpwCv) {
		this.ibpwCv = ibpwCv;
	}

	public Double getBloodpres() {
		return this.bloodpres;
	}

	public void setBloodpres(Double bloodpres) {
		this.bloodpres = bloodpres;
	}

	public Double getSpo2() {
		return this.spo2;
	}

	public void setSpo2(Double spo2) {
		this.spo2 = spo2;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}


	public Integer getXpoint() {
		return xpoint;
	}


	public void setXpoint(Integer xpoint) {
		this.xpoint = xpoint;
	}
	

}