package com.znyy.bean;

/**
 * SysDiseaseArea entity. @author MyEclipse Persistence Tools
 */

public class SysDiseaseArea implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String place;
	private String flag;
	private String code;
	private String pycode;

	// Constructors

	/** default constructor */
	public SysDiseaseArea() {
	}

	/** full constructor */
	public SysDiseaseArea(String name, String place, String flag, String code,
			String pycode) {
		this.name = name;
		this.place = place;
		this.flag = flag;
		this.code = code;
		this.pycode = pycode;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPycode() {
		return this.pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

}