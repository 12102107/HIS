package com.znyy.bean;

import java.util.Date;

/**
 * SmNurseAnaes entity. @author MyEclipse Persistence Tools
 */

public class SmNurseAnaes implements java.io.Serializable {

	// Fields

	private String id;
	private String diastolicPressure;
	private String systolicPressure;
	private String r;
	private String p;
	private String spo2;
	private Date time;
	private String optNurseId;
	private String type;

	// Constructors

	/** default constructor */
	public SmNurseAnaes() {
	}

	/** full constructor */
	public SmNurseAnaes(String diastolicPressure, String systolicPressure,
			String r, String p, String spo2, Date time, String optNurseId) {
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.r = r;
		this.p = p;
		this.spo2 = spo2;
		this.time = time;
		this.optNurseId = optNurseId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(String diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public String getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(String systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public String getR() {
		return this.r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getP() {
		return this.p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getSpo2() {
		return this.spo2;
	}

	public void setSpo2(String spo2) {
		this.spo2 = spo2;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getOptNurseId() {
		return this.optNurseId;
	}

	public void setOptNurseId(String optNurseId) {
		this.optNurseId = optNurseId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}