package com.znyy.bean;
 /** 
 * @类名称: SmRegion
 * @类描述:病区表
 * @作者:付士山
 * @创建时间:2016-1-6 下午2:02:53
 */
 
public class SmRegion implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String enable;

	// Constructors

	/** default constructor */
	public SmRegion() {
	}

	/** full constructor */
	public SmRegion(String name, String enable) {
		this.name = name;
		this.enable = enable;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}