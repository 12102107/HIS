package com.znyy.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * XtUser entity. @author MyEclipse Persistence Tools
 */

public class XtUser implements java.io.Serializable {

	// Fields
    private Integer id;
	private String name;
	private String sex;
	private String tel;
	private String address;
	//private XtRole role;
	private Date enterdate;
	private Integer enterOpera;
	private String present;
	private String flag;
	private Set<XtRole> roles = new HashSet<XtRole>();//角色
	private String imgPath;
	private String idcard;
	private String status;
	private Integer trialdays;
	private String rzdate;
	private String mail;
	private Integer mzid;
	private String hystatus;
	private String nativeplace;
	private String health;
	private String birth;
	private Set<XtUnit> units = new HashSet<XtUnit>();
	private Integer doczc;//医生职称（从医生职称xt_doczc表中关联数据）
	private String type;
	private String issuper;
	private String bankid;
	private String bankno;
	private Long hospitalId;

	// Constructors


	/** default constructor */
	public XtUser() {
	}

	/** minimal constructor */
	public XtUser(String name, XtRole role,
			Date enterdate, String flag) {
		this.name = name;
		this.enterdate = enterdate;
		this.flag = flag;
	}

	/** full constructor */
	public XtUser(String name, String sex, String tel,
			String address, XtUnit unit, XtRole role, Date enterdate,
			Integer enterOpera,String flag) {
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.enterdate = enterdate;
		this.enterOpera = enterOpera;
		this.flag = flag;
	}

	// Property accessors
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public Set<XtRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<XtRole> roles) {
		this.roles = roles;
	}
	public String getImgPath() {
	
		return imgPath;
	}

	public void setImgPath(String imgPath) {
	
		this.imgPath = imgPath;
	}

	public String getStatus() {
	
		return status;
	}

	public void setStatus(String status) {
	
		this.status = status;
	}

	public String getHystatus() {
	
		return hystatus;
	}

	public void setHystatus(String hystatus) {
	
		this.hystatus = hystatus;
	}

	public String getNativeplace() {
	
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
	
		this.nativeplace = nativeplace;
	}

	public String getHealth() {
	
		return health;
	}

	public void setHealth(String health) {
	
		this.health = health;
	}

	public Set<XtUnit> getUnits() {
	
		return units;
	}

	public void setUnits(Set<XtUnit> units) {
	
		this.units = units;
	}
	
	public String getType() {
	
		return type;
	}

	public void setType(String type) {
	
		this.type = type;
	}

	public String getIssuper() {
	
		return issuper;
	}

	public void setIssuper(String issuper) {
	
		this.issuper = issuper;
	}

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
	
		this.id = id;
	}

	public String getBankid() {
	
		return bankid;
	}

	public void setBankid(String bankid) {
	
		this.bankid = bankid;
	}

	public String getBankno() {
	
		return bankno;
	}

	public void setBankno(String bankno) {
	
		this.bankno = bankno;
	}

	public String getIdcard() {
	
		return idcard;
	}

	public void setIdcard(String idcard) {
	
		this.idcard = idcard;
	}

	public String getMail() {
	
		return mail;
	}

	public void setMail(String mail) {
	
		this.mail = mail;
	}

	public Integer getMzid() {
	
		return mzid;
	}

	public void setMzid(Integer mzid) {
	
		this.mzid = mzid;
	}
	
	public String getBirth() {
	
		return birth;
	}

	public void setBirth(String birth) {
	
		this.birth = birth;
	}

	public String getRzdate() {
	
		return rzdate;
	}

	public void setRzdate(String rzdate) {
	
		this.rzdate = rzdate;
	}

	public Integer getTrialdays() {
	
		return trialdays;
	}

	public void setTrialdays(Integer trialdays) {
	
		this.trialdays = trialdays;
	}

	public Integer getDoczc() {
	
		return doczc;
	}

	public void setDoczc(Integer doczc) {
	
		this.doczc = doczc;
	}

	public Integer getEnterOpera() {
	
		return enterOpera;
	}

	public void setEnterOpera(Integer enterOpera) {
	
		this.enterOpera = enterOpera;
	}

	public Long getHospitalId() {
	
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
	
		this.hospitalId = hospitalId;
	}

}