package com.znyy.bean;


import java.util.Date;

/**
 * SmAnaesRecord entity. @author MyEclipse Persistence Tools
 */

public class SmAnaesRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date createTime;
	private String ownerId;
	private String state;
	private Date anaesStartTime;
	private Date anaesEndTime;
	private Date optStartTime;
	private Date optEndTime;
	private Integer remarkInterval;
	private String preMedicalEffect;
	private String inMedicalEffect;
	private String otherCondition;
	private String abductionCourse;
	private String anaesCourse;
	private String anaesRecover;
	private String anaesFeedback;
	private String anaesEffect;
	private String syndrome;
	private String sequela;
	private String death;
	private String deathCause;
	private Date finishTime;
	private String specialStatus;
	private String docId;
	private String operationId;
	private String bodySurfaceArea;
	private String generalGrade;
	private String enable;
	private String asaLevel;
	private String analgesia;
	private String cpr;
	private String incisionCleanliness;
	private Date recordStartTime;
	private Date recordEndTime;

	// Constructors

	/** default constructor */
	public SmAnaesRecord() {
	}


	// Property accessors



	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}




	public String getPreMedicalEffect() {
		return this.preMedicalEffect;
	}

	public void setPreMedicalEffect(String preMedicalEffect) {
		this.preMedicalEffect = preMedicalEffect;
	}

	public String getInMedicalEffect() {
		return this.inMedicalEffect;
	}

	public void setInMedicalEffect(String inMedicalEffect) {
		this.inMedicalEffect = inMedicalEffect;
	}

	public String getOtherCondition() {
		return this.otherCondition;
	}

	public void setOtherCondition(String otherCondition) {
		this.otherCondition = otherCondition;
	}

	public String getAbductionCourse() {
		return this.abductionCourse;
	}

	public void setAbductionCourse(String abductionCourse) {
		this.abductionCourse = abductionCourse;
	}

	public String getAnaesCourse() {
		return this.anaesCourse;
	}

	public void setAnaesCourse(String anaesCourse) {
		this.anaesCourse = anaesCourse;
	}

	public String getAnaesRecover() {
		return this.anaesRecover;
	}

	public void setAnaesRecover(String anaesRecover) {
		this.anaesRecover = anaesRecover;
	}

	public String getAnaesFeedback() {
		return this.anaesFeedback;
	}

	public void setAnaesFeedback(String anaesFeedback) {
		this.anaesFeedback = anaesFeedback;
	}

	public String getAnaesEffect() {
		return this.anaesEffect;
	}

	public void setAnaesEffect(String anaesEffect) {
		this.anaesEffect = anaesEffect;
	}

	public String getSyndrome() {
		return this.syndrome;
	}

	public void setSyndrome(String syndrome) {
		this.syndrome = syndrome;
	}

	public String getSequela() {
		return this.sequela;
	}

	public void setSequela(String sequela) {
		this.sequela = sequela;
	}

	public String getDeath() {
		return this.death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public String getDeathCause() {
		return this.deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getSpecialStatus() {
		return this.specialStatus;
	}

	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}

	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getOperationId() {
		return this.operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getBodySurfaceArea() {
		return this.bodySurfaceArea;
	}

	public void setBodySurfaceArea(String bodySurfaceArea) {
		this.bodySurfaceArea = bodySurfaceArea;
	}

	public String getGeneralGrade() {
		return this.generalGrade;
	}

	public void setGeneralGrade(String generalGrade) {
		this.generalGrade = generalGrade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAnaesStartTime() {
		return anaesStartTime;
	}

	public void setAnaesStartTime(Date anaesStartTime) {
		this.anaesStartTime = anaesStartTime;
	}

	public Date getAnaesEndTime() {
		return anaesEndTime;
	}

	public void setAnaesEndTime(Date anaesEndTime) {
		this.anaesEndTime = anaesEndTime;
	}

	public Date getOptStartTime() {
		return optStartTime;
	}

	public void setOptStartTime(Date optStartTime) {
		this.optStartTime = optStartTime;
	}

	public Date getOptEndTime() {
		return optEndTime;
	}

	public void setOptEndTime(Date optEndTime) {
		this.optEndTime = optEndTime;
	}

	public Integer getRemarkInterval() {
		return remarkInterval;
	}

	public void setRemarkInterval(Integer remarkInterval) {
		this.remarkInterval = remarkInterval;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getAsaLevel() {
		return asaLevel;
	}

	public void setAsaLevel(String asaLevel) {
		this.asaLevel = asaLevel;
	}

	public String getAnalgesia() {
		return analgesia;
	}

	public void setAnalgesia(String analgesia) {
		this.analgesia = analgesia;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getIncisionCleanliness() {
		return incisionCleanliness;
	}

	public void setIncisionCleanliness(String incisionCleanliness) {
		this.incisionCleanliness = incisionCleanliness;
	}

	public Date getRecordStartTime() {
		return recordStartTime;
	}

	public void setRecordStartTime(Date recordStartTime) {
		this.recordStartTime = recordStartTime;
	}


	public Date getRecordEndTime() {
		return recordEndTime;
	}


	public void setRecordEndTime(Date recordEndTime) {
		this.recordEndTime = recordEndTime;
	}

}