package com.znyy.bean;



 /** 
 * @类名称: SmOperdef
 * @类描述:手术名称表
 * @作者:付士山
 * @创建时间:2016-1-6 下午2:04:10
 */
 
public class SmOperdef implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String pinyin;
	private String enable;

	// Constructors

	/** default constructor */
	public SmOperdef() {
	}

	/** full constructor */
	public SmOperdef(String name, String pinyin, String enable) {
		this.name = name;
		this.pinyin = pinyin;
		this.enable = enable;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
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

}