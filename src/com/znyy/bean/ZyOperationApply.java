package com.znyy.bean;

import java.math.BigDecimal;

/**
 * ZyOperationApply entity. @author MyEclipse Persistence Tools
 */

public class ZyOperationApply implements java.io.Serializable {

	// Fields

	private Long id;
	private Long patientId;
	private String name;
	private String age;
	private String birthday;
	private String sex;
	private String medicalType;
	private String identityNo;
	private String hid;
	private String cid;
	private String regionNo;
	private String regionName;
	private Short dept;
	private String bed;
	private String diagnosisCode;
	private String diagnosisName;
	private String designedoperationCode;
	private String designedoperationName;
	private String designedAnaesMethodCode;
	private String designedAnaesMethodName;
	private Integer operator;
	private String operationdate;
	private String operationtime;
	private BigDecimal room;
	private String operatingtable;
	private Integer anaesthetist;
	private Integer circuanesthetist;
	private Integer anaesAssistant;
	private Integer assistant1;
	private Integer assistant2;
	private Integer assistant3;
	private String assistantother;
	private String hypersusceptibility;
	private String optLevel;
	private String emergency;
	private Long chargesType;
	private String state;
	private Integer ownerId;
	private String ownerName;
	private String remarks;
	private BigDecimal operpositionid;
	private String monthage;
	private String dayage;
	private Integer expecttime;
	private String zdbak;
	private String operrequirements;
	private String reason;
	private String yxFlag;

	// Constructors

	/** default constructor */
	public ZyOperationApply() {
	}

	/** full constructor */
	public ZyOperationApply(Long patientId, String name, String age,
			String birthday, String sex, String medicalType, String identityNo,
			String hid, String cid, String regionNo, String regionName,
			Short dept, String bed, String diagnosisCode, String diagnosisName,
			String designedoperationCode, String designedoperationName,
			String designedAnaesMethodCode, String designedAnaesMethodName,
			Integer operator, String operationdate, String operationtime,
			BigDecimal room, String operatingtable, Integer anaesthetist,
			Integer circuanesthetist, Integer anaesAssistant,
			Integer assistant1, Integer assistant2, Integer assistant3,
			String assistantother, String hypersusceptibility, String optLevel,
			String emergency, Long chargesType, String state, Integer ownerId,
			String ownerName, String remarks, BigDecimal operpositionid,
			String monthage, String dayage, Integer expecttime, String zdbak,
			String operrequirements, String reason, String yxFlag) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.medicalType = medicalType;
		this.identityNo = identityNo;
		this.hid = hid;
		this.cid = cid;
		this.regionNo = regionNo;
		this.regionName = regionName;
		this.dept = dept;
		this.bed = bed;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisName = diagnosisName;
		this.designedoperationCode = designedoperationCode;
		this.designedoperationName = designedoperationName;
		this.designedAnaesMethodCode = designedAnaesMethodCode;
		this.designedAnaesMethodName = designedAnaesMethodName;
		this.operator = operator;
		this.operationdate = operationdate;
		this.operationtime = operationtime;
		this.room = room;
		this.operatingtable = operatingtable;
		this.anaesthetist = anaesthetist;
		this.circuanesthetist = circuanesthetist;
		this.anaesAssistant = anaesAssistant;
		this.assistant1 = assistant1;
		this.assistant2 = assistant2;
		this.assistant3 = assistant3;
		this.assistantother = assistantother;
		this.hypersusceptibility = hypersusceptibility;
		this.optLevel = optLevel;
		this.emergency = emergency;
		this.chargesType = chargesType;
		this.state = state;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.remarks = remarks;
		this.operpositionid = operpositionid;
		this.monthage = monthage;
		this.dayage = dayage;
		this.expecttime = expecttime;
		this.zdbak = zdbak;
		this.operrequirements = operrequirements;
		this.reason = reason;
		this.yxFlag = yxFlag;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMedicalType() {
		return this.medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getIdentityNo() {
		return this.identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegionNo() {
		return this.regionNo;
	}

	public void setRegionNo(String regionNo) {
		this.regionNo = regionNo;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Short getDept() {
		return this.dept;
	}

	public void setDept(Short dept) {
		this.dept = dept;
	}

	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getDiagnosisCode() {
		return this.diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getDesignedoperationCode() {
		return this.designedoperationCode;
	}

	public void setDesignedoperationCode(String designedoperationCode) {
		this.designedoperationCode = designedoperationCode;
	}

	public String getDesignedoperationName() {
		return this.designedoperationName;
	}

	public void setDesignedoperationName(String designedoperationName) {
		this.designedoperationName = designedoperationName;
	}

	public String getDesignedAnaesMethodCode() {
		return this.designedAnaesMethodCode;
	}

	public void setDesignedAnaesMethodCode(String designedAnaesMethodCode) {
		this.designedAnaesMethodCode = designedAnaesMethodCode;
	}

	public String getDesignedAnaesMethodName() {
		return this.designedAnaesMethodName;
	}

	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}

	public Integer getOperator() {
		return this.operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getOperationdate() {
		return this.operationdate;
	}

	public void setOperationdate(String operationdate) {
		this.operationdate = operationdate;
	}

	public String getOperationtime() {
		return this.operationtime;
	}

	public void setOperationtime(String operationtime) {
		this.operationtime = operationtime;
	}

	public BigDecimal getRoom() {
		return this.room;
	}

	public void setRoom(BigDecimal room) {
		this.room = room;
	}

	public String getOperatingtable() {
		return this.operatingtable;
	}

	public void setOperatingtable(String operatingtable) {
		this.operatingtable = operatingtable;
	}

	public Integer getAnaesthetist() {
		return this.anaesthetist;
	}

	public void setAnaesthetist(Integer anaesthetist) {
		this.anaesthetist = anaesthetist;
	}

	public Integer getCircuanesthetist() {
		return this.circuanesthetist;
	}

	public void setCircuanesthetist(Integer circuanesthetist) {
		this.circuanesthetist = circuanesthetist;
	}

	public Integer getAnaesAssistant() {
		return this.anaesAssistant;
	}

	public void setAnaesAssistant(Integer anaesAssistant) {
		this.anaesAssistant = anaesAssistant;
	}

	public Integer getAssistant1() {
		return this.assistant1;
	}

	public void setAssistant1(Integer assistant1) {
		this.assistant1 = assistant1;
	}

	public Integer getAssistant2() {
		return this.assistant2;
	}

	public void setAssistant2(Integer assistant2) {
		this.assistant2 = assistant2;
	}

	public Integer getAssistant3() {
		return this.assistant3;
	}

	public void setAssistant3(Integer assistant3) {
		this.assistant3 = assistant3;
	}

	public String getAssistantother() {
		return this.assistantother;
	}

	public void setAssistantother(String assistantother) {
		this.assistantother = assistantother;
	}

	public String getHypersusceptibility() {
		return this.hypersusceptibility;
	}

	public void setHypersusceptibility(String hypersusceptibility) {
		this.hypersusceptibility = hypersusceptibility;
	}

	public String getOptLevel() {
		return this.optLevel;
	}

	public void setOptLevel(String optLevel) {
		this.optLevel = optLevel;
	}

	public String getEmergency() {
		return this.emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public Long getChargesType() {
		return this.chargesType;
	}

	public void setChargesType(Long chargesType) {
		this.chargesType = chargesType;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getOperpositionid() {
		return this.operpositionid;
	}

	public void setOperpositionid(BigDecimal operpositionid) {
		this.operpositionid = operpositionid;
	}

	public String getMonthage() {
		return this.monthage;
	}

	public void setMonthage(String monthage) {
		this.monthage = monthage;
	}

	public String getDayage() {
		return this.dayage;
	}

	public void setDayage(String dayage) {
		this.dayage = dayage;
	}

	public Integer getExpecttime() {
		return this.expecttime;
	}

	public void setExpecttime(Integer expecttime) {
		this.expecttime = expecttime;
	}

	public String getZdbak() {
		return this.zdbak;
	}

	public void setZdbak(String zdbak) {
		this.zdbak = zdbak;
	}

	public String getOperrequirements() {
		return this.operrequirements;
	}

	public void setOperrequirements(String operrequirements) {
		this.operrequirements = operrequirements;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getYxFlag() {
		return this.yxFlag;
	}

	public void setYxFlag(String yxFlag) {
		this.yxFlag = yxFlag;
	}

}