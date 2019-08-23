package com.znyy.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * SmPreVisit entity. @author MyEclipse Persistence Tools
 */

public class SmPreVisit  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String docId;
     private String operationId;
     private String weight;
     private String height;
     private String spacialMonitoring;
     private String spacialMonitoringOther;
     private String disposal;
     private String bloodType;
     private String bloodTypeRh;
     private String anaesplan;
     private String nxjc;
     private String aneasdoctor;
     private String visitdate;
     private String visittime;
     private String state;
     private Date finishTime;
     private String complaint;
     private String operator;
     private String operateTime;
     private String ASA;
     private String fullStomach;

    // Constructors

    /** default constructor */
    public SmPreVisit() {
    }

    
    /** full constructor */
    public SmPreVisit(String docId, String operationId, String weight, String height, String spacialMonitoring, String spacialMonitoringOther, String disposal, String bloodType, String bloodTypeRh, String anaesplan, String nxjc, String aneasdoctor, String visitdate, String visittime, String state, Date finishTime, String complaint, String operator, String operateTime) {
        this.docId = docId;
        this.operationId = operationId;
        this.weight = weight;
        this.height = height;
        this.spacialMonitoring = spacialMonitoring;
        this.spacialMonitoringOther = spacialMonitoringOther;
        this.disposal = disposal;
        this.bloodType = bloodType;
        this.bloodTypeRh = bloodTypeRh;
        this.anaesplan = anaesplan;
        this.nxjc = nxjc;
        this.aneasdoctor = aneasdoctor;
        this.visitdate = visitdate;
        this.visittime = visittime;
        this.state = state;
        this.finishTime = finishTime;
        this.complaint = complaint;
        this.operator = operator;
        this.operateTime = operateTime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
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

    public String getWeight() {
        return this.weight;
    }
    
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpacialMonitoring() {
        return this.spacialMonitoring;
    }
    
    public void setSpacialMonitoring(String spacialMonitoring) {
        this.spacialMonitoring = spacialMonitoring;
    }

    public String getSpacialMonitoringOther() {
        return this.spacialMonitoringOther;
    }
    
    public void setSpacialMonitoringOther(String spacialMonitoringOther) {
        this.spacialMonitoringOther = spacialMonitoringOther;
    }

    public String getDisposal() {
        return this.disposal;
    }
    
    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }

    public String getBloodType() {
        return this.bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodTypeRh() {
        return this.bloodTypeRh;
    }
    
    public void setBloodTypeRh(String bloodTypeRh) {
        this.bloodTypeRh = bloodTypeRh;
    }

    public String getAnaesplan() {
        return this.anaesplan;
    }
    
    public void setAnaesplan(String anaesplan) {
        this.anaesplan = anaesplan;
    }

    public String getNxjc() {
        return this.nxjc;
    }
    
    public void setNxjc(String nxjc) {
        this.nxjc = nxjc;
    }

    public String getAneasdoctor() {
        return this.aneasdoctor;
    }
    
    public void setAneasdoctor(String aneasdoctor) {
        this.aneasdoctor = aneasdoctor;
    }

    public String getVisitdate() {
        return this.visitdate;
    }
    
    public void setVisitdate(String visitdate) {
        this.visitdate = visitdate;
    }

    public String getVisittime() {
        return this.visittime;
    }
    
    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public Date getFinishTime() {
        return this.finishTime;
    }
    
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getComplaint() {
        return this.complaint;
    }
    
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateTime() {
        return this.operateTime;
    }
    
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }


	/**
	 * @return the aSA
	 */
	public String getASA() {
		return ASA;
	}


	/**
	 * @param aSA the aSA to set
	 */
	public void setASA(String aSA) {
		ASA = aSA;
	}


	/**
	 * @return the fullStomach
	 */
	public String getFullStomach() {
		return fullStomach;
	}


	/**
	 * @param fullStomach the fullStomach to set
	 */
	public void setFullStomach(String fullStomach) {
		this.fullStomach = fullStomach;
	}
   








}