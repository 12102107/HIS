package com.znyy.bean;

import java.util.Date;

/**
 * SmRecoveryroomRecord entity. @author MyEclipse Persistence Tools
 */

public class SmRecoveryroomRecord implements java.io.Serializable {

	// Fields

	private String id;
	private String docId;
	private String operationId;
	private Date enterTime;
	private Date exitTime;
	private String portablePipe;
	private String portablePipeOther;
	private String soberScore;
	private String breathingScore;
	private String physicalActivityScore;
	private String totalScore;
	private String destination;
	private Date creatTime;
	private String creatOperation;
	
	private String state;
	private Date monitorStartTime;
	private Date monitorEndTime;
	private Integer remarkInterval;
	private String wsid;
	private String monitoringItem;
	private String monitorState;

	// Constructors

	/** default constructor */
	public SmRecoveryroomRecord() {
	}

	/** full constructor */
	public SmRecoveryroomRecord(String docId, String operationId,
			Date enterTime, Date exitTime, String portablePipe,
			String portablePipeOther, String soberScore, String breathingScore,
			String physicalActivityScore, String totalScore,
			String destination, Date creatTime, String creatOperation,
			String state,Date monitorStartTime,Date monitorEndTime,
			Integer remarkInterval,String wsid,String monitoringItem,String monitorState) {
		this.docId = docId;
		this.operationId = operationId;
		this.enterTime = enterTime;
		this.exitTime = exitTime;
		this.portablePipe = portablePipe;
		this.portablePipeOther = portablePipeOther;
		this.soberScore = soberScore;
		this.breathingScore = breathingScore;
		this.physicalActivityScore = physicalActivityScore;
		this.totalScore = totalScore;
		this.destination = destination;
		this.creatTime = creatTime;
		this.creatOperation = creatOperation;
		this.state = state;
		this.monitorStartTime = monitorStartTime;
		this.monitorEndTime = monitorEndTime;
		this.remarkInterval = remarkInterval;
		this.wsid = wsid;
		this.monitoringItem = monitoringItem;
		this.monitorState = monitorState;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getEnterTime() {
		return this.enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	public Date getExitTime() {
		return this.exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}

	public String getPortablePipe() {
		return this.portablePipe;
	}

	public void setPortablePipe(String portablePipe) {
		this.portablePipe = portablePipe;
	}

	public String getPortablePipeOther() {
		return this.portablePipeOther;
	}

	public void setPortablePipeOther(String portablePipeOther) {
		this.portablePipeOther = portablePipeOther;
	}

	public String getSoberScore() {
		return this.soberScore;
	}

	public void setSoberScore(String soberScore) {
		this.soberScore = soberScore;
	}

	public String getBreathingScore() {
		return this.breathingScore;
	}

	public void setBreathingScore(String breathingScore) {
		this.breathingScore = breathingScore;
	}

	public String getPhysicalActivityScore() {
		return this.physicalActivityScore;
	}

	public void setPhysicalActivityScore(String physicalActivityScore) {
		this.physicalActivityScore = physicalActivityScore;
	}

	public String getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getCreatOperation() {
		return this.creatOperation;
	}

	public void setCreatOperation(String creatOperation) {
		this.creatOperation = creatOperation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getMonitorStartTime() {
		return monitorStartTime;
	}

	public void setMonitorStartTime(Date monitorStartTime) {
		this.monitorStartTime = monitorStartTime;
	}

	public Date getMonitorEndTime() {
		return monitorEndTime;
	}

	public void setMonitorEndTime(Date monitorEndTime) {
		this.monitorEndTime = monitorEndTime;
	}

	public Integer getRemarkInterval() {
		return remarkInterval;
	}

	public void setRemarkInterval(Integer remarkInterval) {
		this.remarkInterval = remarkInterval;
	}

	public String getWsid() {
		return wsid;
	}

	public void setWsid(String wsid) {
		this.wsid = wsid;
	}

	public String getMonitoringItem() {
		return monitoringItem;
	}

	public void setMonitoringItem(String monitoringItem) {
		this.monitoringItem = monitoringItem;
	}

	public String getMonitorState() {
		return monitorState;
	}

	public void setMonitorState(String monitorState) {
		this.monitorState = monitorState;
	}

	
	
}