package com.znyy.bean;


 /** 
 * @类名称: SmOperationPeople
 * @类描述:手术人员表
 * @作者:付士山
 * @创建时间:2016-1-6 下午2:04:33
 */
 
public class SmOperationPeople implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String name;
	private String pinyin;
	private String enable;
	private Integer region;
	private String role;

	// Constructors

	/** default constructor */
	public SmOperationPeople() {
	}

	/** full constructor */
	public SmOperationPeople(String name, String pinyin, String enable,
			Integer region, String role) {
		this.name = name;
		this.pinyin = pinyin;
		this.enable = enable;
		this.region = region;
		this.role = role;
	}

	// Property accessors

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Integer getRegion() {
		return this.region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}