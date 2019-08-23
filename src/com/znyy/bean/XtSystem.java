package com.znyy.bean;

/**
 * XtSystem entity. @author MyEclipse Persistence Tools
 */

public class XtSystem implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String imgPath;
	private String type;
	private Long hospitalId;
	private String flag;
	private Integer sort;
	private String url;
	private String moreunit;

	// Constructors

	/** default constructor */
	public XtSystem() {
	}

	/** full constructor */
	public XtSystem(String name, String imgPath, String type,
			Long hospitalID, String flag,Integer sort,String url,String moreunit) {
		this.name = name;
		this.imgPath = imgPath;
		this.type = type;
		this.hospitalId = hospitalID;
		this.flag = flag;
		this.sort = sort;
		this.url = url;
		this.moreunit = moreunit;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSort() {
	
		return sort;
	}

	public void setSort(Integer sort) {
	
		this.sort = sort;
	}

	public String getUrl() {
	
		return url;
	}

	public void setUrl(String url) {
	
		this.url = url;
	}

	public String getMoreunit() {
	
		return moreunit;
	}

	public void setMoreunit(String moreunit) {
	
		this.moreunit = moreunit;
	}

	public Long getHospitalId() {
	
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
	
		this.hospitalId = hospitalId;
	}

}