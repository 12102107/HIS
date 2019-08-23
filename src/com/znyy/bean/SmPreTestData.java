package com.znyy.bean;

import java.util.Date;

/**
 * SmPreTestData entity. @author MyEclipse Persistence Tools
 */

public class SmPreTestData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String operationId;
	private Double hb;
	private Double hct;
	private Double wbc;
	private Double plt;
	private Double KPlus;
	private Double naPlus;
	private Double clReduce;
	private Double glu;
	private Double sgpt;
	private Double bun;
	private Double cr;
	private Double pt;
	private Double aptt;
	private Double pao2;
	private Date time;

	// Constructors

	/** default constructor */
	public SmPreTestData() {
	}

	/** full constructor */
	public SmPreTestData(String operationId, Double hb, Double hct, Double wbc,
			Double plt, Double KPlus, Double naPlus, Double clReduce,
			Double glu, Double sgpt, Double bun, Double cr, Double pt,
			Double aptt, Double pao2, Date time) {
		this.operationId = operationId;
		this.hb = hb;
		this.hct = hct;
		this.wbc = wbc;
		this.plt = plt;
		this.KPlus = KPlus;
		this.naPlus = naPlus;
		this.clReduce = clReduce;
		this.glu = glu;
		this.sgpt = sgpt;
		this.bun = bun;
		this.cr = cr;
		this.pt = pt;
		this.aptt = aptt;
		this.pao2 = pao2;
		this.time = time;
	}

	// Property accessors



	public String getOperationId() {
		return this.operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public Double getHb() {
		return this.hb;
	}

	public void setHb(Double hb) {
		this.hb = hb;
	}

	public Double getHct() {
		return this.hct;
	}

	public void setHct(Double hct) {
		this.hct = hct;
	}

	public Double getWbc() {
		return this.wbc;
	}

	public void setWbc(Double wbc) {
		this.wbc = wbc;
	}

	public Double getPlt() {
		return this.plt;
	}

	public void setPlt(Double plt) {
		this.plt = plt;
	}

	public Double getKPlus() {
		return this.KPlus;
	}

	public void setKPlus(Double KPlus) {
		this.KPlus = KPlus;
	}

	public Double getNaPlus() {
		return this.naPlus;
	}

	public void setNaPlus(Double naPlus) {
		this.naPlus = naPlus;
	}

	public Double getClReduce() {
		return this.clReduce;
	}

	public void setClReduce(Double clReduce) {
		this.clReduce = clReduce;
	}

	public Double getGlu() {
		return this.glu;
	}

	public void setGlu(Double glu) {
		this.glu = glu;
	}

	public Double getSgpt() {
		return this.sgpt;
	}

	public void setSgpt(Double sgpt) {
		this.sgpt = sgpt;
	}

	public Double getBun() {
		return this.bun;
	}

	public void setBun(Double bun) {
		this.bun = bun;
	}

	public Double getCr() {
		return this.cr;
	}

	public void setCr(Double cr) {
		this.cr = cr;
	}

	public Double getPt() {
		return this.pt;
	}

	public void setPt(Double pt) {
		this.pt = pt;
	}

	public Double getAptt() {
		return this.aptt;
	}

	public void setAptt(Double aptt) {
		this.aptt = aptt;
	}

	public Double getPao2() {
		return this.pao2;
	}

	public void setPao2(Double pao2) {
		this.pao2 = pao2;
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



}