package com.znyy.bean;

/**
 * SysIcdCode entity. @author MyEclipse Persistence Tools
 */

public class SysIcdCode implements java.io.Serializable {

	// Fields

	private Long id;
	private String diseasecode;
	private String fjcode;
	private String diseasename;
	private Long lmid;
	private String startFlag;
	private String pycode;

	// Constructors

	/** default constructor */
	public SysIcdCode() {
	}

	/** full constructor */
	public SysIcdCode(String diseasecode, String fjcode, String diseasename,
			Long lmid, String startFlag, String pycode) {
		this.diseasecode = diseasecode;
		this.fjcode = fjcode;
		this.diseasename = diseasename;
		this.lmid = lmid;
		this.startFlag = startFlag;
		this.pycode = pycode;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiseasecode() {
		return this.diseasecode;
	}

	public void setDiseasecode(String diseasecode) {
		this.diseasecode = diseasecode;
	}

	public String getFjcode() {
		return this.fjcode;
	}

	public void setFjcode(String fjcode) {
		this.fjcode = fjcode;
	}

	public String getDiseasename() {
		return this.diseasename;
	}

	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}

	public Long getLmid() {
		return this.lmid;
	}

	public void setLmid(Long lmid) {
		this.lmid = lmid;
	}

	public String getStartFlag() {
		return this.startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}

	public String getPycode() {
		return this.pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

}