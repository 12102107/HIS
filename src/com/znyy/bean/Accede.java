package com.znyy.bean;
 /** 
 * @类名称: Accede
 * @类描述:麻醉同意书表
 * @作者:付士山
 * @创建时间:2016-2-23 下午1:24:04
 */
 
public class Accede implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String docId;
	private String operationId;
	private String state;
	private String specialIllness;
	private String notice;
	private String noticeOther;
	private String visitDate;
	private String propositionalMethod;
	private String specialRisk;
	private String otherRisk;
	private String type;
	private String choosePain;
	private String transfusionYn;
	private String chooseAirtube;
	private String otherAnesthesia;
	private String transfusionMerit;
	private String otherPuncture;
	private String accidentConcurrency;
	private String airtubeDate;
	private String airtubeDateDay;
	private String punctureDate;
	private String transfusionDate;

	// Constructors

	/** default constructor */
	public Accede() {
	}

	/** full constructor */
	public Accede(String docId, String operationId, String state,
			String specialIllness, String notice, String noticeOther,
			String visitDate, String propositionalMethod, String specialRisk,
			String otherRisk, String type, String choosePain,
			String transfusionYn, String chooseAirtube, String otherAnesthesia,
			String transfusionMerit, String otherPuncture,
			String accidentConcurrency, String airtubeDate,
			String airtubeDateDay, String punctureDate, String transfusionDate) {
		this.docId = docId;
		this.operationId = operationId;
		this.state = state;
		this.specialIllness = specialIllness;
		this.notice = notice;
		this.noticeOther = noticeOther;
		this.visitDate = visitDate;
		this.propositionalMethod = propositionalMethod;
		this.specialRisk = specialRisk;
		this.otherRisk = otherRisk;
		this.type = type;
		this.choosePain = choosePain;
		this.transfusionYn = transfusionYn;
		this.chooseAirtube = chooseAirtube;
		this.otherAnesthesia = otherAnesthesia;
		this.transfusionMerit = transfusionMerit;
		this.otherPuncture = otherPuncture;
		this.accidentConcurrency = accidentConcurrency;
		this.airtubeDate = airtubeDate;
		this.airtubeDateDay = airtubeDateDay;
		this.punctureDate = punctureDate;
		this.transfusionDate = transfusionDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpecialIllness() {
		return this.specialIllness;
	}

	public void setSpecialIllness(String specialIllness) {
		this.specialIllness = specialIllness;
	}

	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getNoticeOther() {
		return this.noticeOther;
	}

	public void setNoticeOther(String noticeOther) {
		this.noticeOther = noticeOther;
	}

	public String getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getPropositionalMethod() {
		return this.propositionalMethod;
	}

	public void setPropositionalMethod(String propositionalMethod) {
		this.propositionalMethod = propositionalMethod;
	}

	public String getSpecialRisk() {
		return this.specialRisk;
	}

	public void setSpecialRisk(String specialRisk) {
		this.specialRisk = specialRisk;
	}

	public String getOtherRisk() {
		return this.otherRisk;
	}

	public void setOtherRisk(String otherRisk) {
		this.otherRisk = otherRisk;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChoosePain() {
		return this.choosePain;
	}

	public void setChoosePain(String choosePain) {
		this.choosePain = choosePain;
	}

	public String getTransfusionYn() {
		return this.transfusionYn;
	}

	public void setTransfusionYn(String transfusionYn) {
		this.transfusionYn = transfusionYn;
	}

	public String getChooseAirtube() {
		return this.chooseAirtube;
	}

	public void setChooseAirtube(String chooseAirtube) {
		this.chooseAirtube = chooseAirtube;
	}

	public String getOtherAnesthesia() {
		return this.otherAnesthesia;
	}

	public void setOtherAnesthesia(String otherAnesthesia) {
		this.otherAnesthesia = otherAnesthesia;
	}

	public String getTransfusionMerit() {
		return this.transfusionMerit;
	}

	public void setTransfusionMerit(String transfusionMerit) {
		this.transfusionMerit = transfusionMerit;
	}

	public String getOtherPuncture() {
		return this.otherPuncture;
	}

	public void setOtherPuncture(String otherPuncture) {
		this.otherPuncture = otherPuncture;
	}

	public String getAccidentConcurrency() {
		return this.accidentConcurrency;
	}

	public void setAccidentConcurrency(String accidentConcurrency) {
		this.accidentConcurrency = accidentConcurrency;
	}

	public String getAirtubeDate() {
		return this.airtubeDate;
	}

	public void setAirtubeDate(String airtubeDate) {
		this.airtubeDate = airtubeDate;
	}

	public String getAirtubeDateDay() {
		return this.airtubeDateDay;
	}

	public void setAirtubeDateDay(String airtubeDateDay) {
		this.airtubeDateDay = airtubeDateDay;
	}

	public String getPunctureDate() {
		return this.punctureDate;
	}

	public void setPunctureDate(String punctureDate) {
		this.punctureDate = punctureDate;
	}

	public String getTransfusionDate() {
		return this.transfusionDate;
	}

	public void setTransfusionDate(String transfusionDate) {
		this.transfusionDate = transfusionDate;
	}

}