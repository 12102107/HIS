package com.znyy.bean;
 /** 
 * @类名称: SmAnaesWatch
 * @类描述:术后随访表
 * @作者:付士山
 * @创建时间:2016-3-9 上午10:09:57
 */
 
public class SmAnaesWatch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String docId;
	private String observetime;
	private String respratebate;
	private String intubattonagain;
	private String circlesteady;
	private String faucesache;
	private String feelsick;
	private String soundhoarseness;
	private String cruramyodynamiaresume;
	private String puncturepointache;
	private String spinalanalgesiaheadache;
	private String uroschesis;
	private String awarenessOperation;
	private String muscularSoreness;
	private String allsick;
	private String allvomit;
	private String lumbago;
	private String neuralsick;
	private String neuralvomit;
	private String legParesthesia;
	private String legParesthesiaDetails;
	private String legMovement;
	private String legMovementDetails;
	private String neuralObservepeople;
	private String neuralObservetime;
	private String nerveBlockedObservepeople;
	private String nerveBlockedObservetime;
	private String neuralRemark;
	private String nerveBlockedRemark;
	private String pulse;
	private String bloodPressure;
	private String bloodPreL;
	private String bloodPreH;
	private String observepeople;
	private String remark;
	private String analgesiaplan;
	private String observeaftertime;
	private String quietvas;
	private String exercisevas;
	private String lethargy;
	private String naupathia;
	private String vomit;
	private String pruritus;
	private String uroschesisafter;
	private String observepeopleafter;
	private String remarkafter;

	// Constructors

	/** default constructor */
	public SmAnaesWatch() {
	}

	/** full constructor */
	public SmAnaesWatch(String docId, String observetime, String respratebate,
			String intubattonagain, String circlesteady, String faucesache,
			String feelsick, String soundhoarseness,
			String cruramyodynamiaresume, String puncturepointache,
			String spinalanalgesiaheadache, String uroschesis,
			String awarenessOperation, String muscularSoreness, String allsick,
			String allvomit, String lumbago, String neuralsick,
			String neuralvomit, String legParesthesia,
			String legParesthesiaDetails, String legMovement,
			String legMovementDetails, String neuralObservepeople,
			String neuralObservetime, String nerveBlockedObservepeople,
			String nerveBlockedObservetime, String neuralRemark,
			String nerveBlockedRemark, String pulse, String bloodPressure,
			String bloodPreL, String bloodPreH, String observepeople,
			String remark, String analgesiaplan, String observeaftertime,
			String quietvas, String exercisevas, String lethargy,
			String naupathia, String vomit, String pruritus,
			String uroschesisafter, String observepeopleafter,
			String remarkafter) {
		this.docId = docId;
		this.observetime = observetime;
		this.respratebate = respratebate;
		this.intubattonagain = intubattonagain;
		this.circlesteady = circlesteady;
		this.faucesache = faucesache;
		this.feelsick = feelsick;
		this.soundhoarseness = soundhoarseness;
		this.cruramyodynamiaresume = cruramyodynamiaresume;
		this.puncturepointache = puncturepointache;
		this.spinalanalgesiaheadache = spinalanalgesiaheadache;
		this.uroschesis = uroschesis;
		this.awarenessOperation = awarenessOperation;
		this.muscularSoreness = muscularSoreness;
		this.allsick = allsick;
		this.allvomit = allvomit;
		this.lumbago = lumbago;
		this.neuralsick = neuralsick;
		this.neuralvomit = neuralvomit;
		this.legParesthesia = legParesthesia;
		this.legParesthesiaDetails = legParesthesiaDetails;
		this.legMovement = legMovement;
		this.legMovementDetails = legMovementDetails;
		this.neuralObservepeople = neuralObservepeople;
		this.neuralObservetime = neuralObservetime;
		this.nerveBlockedObservepeople = nerveBlockedObservepeople;
		this.nerveBlockedObservetime = nerveBlockedObservetime;
		this.neuralRemark = neuralRemark;
		this.nerveBlockedRemark = nerveBlockedRemark;
		this.pulse = pulse;
		this.bloodPressure = bloodPressure;
		this.bloodPreL = bloodPreL;
		this.bloodPreH = bloodPreH;
		this.observepeople = observepeople;
		this.remark = remark;
		this.analgesiaplan = analgesiaplan;
		this.observeaftertime = observeaftertime;
		this.quietvas = quietvas;
		this.exercisevas = exercisevas;
		this.lethargy = lethargy;
		this.naupathia = naupathia;
		this.vomit = vomit;
		this.pruritus = pruritus;
		this.uroschesisafter = uroschesisafter;
		this.observepeopleafter = observepeopleafter;
		this.remarkafter = remarkafter;
	}



	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getObservetime() {
		return this.observetime;
	}

	public void setObservetime(String observetime) {
		this.observetime = observetime;
	}

	public String getRespratebate() {
		return this.respratebate;
	}

	public void setRespratebate(String respratebate) {
		this.respratebate = respratebate;
	}

	public String getIntubattonagain() {
		return this.intubattonagain;
	}

	public void setIntubattonagain(String intubattonagain) {
		this.intubattonagain = intubattonagain;
	}

	public String getCirclesteady() {
		return this.circlesteady;
	}

	public void setCirclesteady(String circlesteady) {
		this.circlesteady = circlesteady;
	}

	public String getFaucesache() {
		return this.faucesache;
	}

	public void setFaucesache(String faucesache) {
		this.faucesache = faucesache;
	}

	public String getFeelsick() {
		return this.feelsick;
	}

	public void setFeelsick(String feelsick) {
		this.feelsick = feelsick;
	}

	public String getSoundhoarseness() {
		return this.soundhoarseness;
	}

	public void setSoundhoarseness(String soundhoarseness) {
		this.soundhoarseness = soundhoarseness;
	}

	public String getCruramyodynamiaresume() {
		return this.cruramyodynamiaresume;
	}

	public void setCruramyodynamiaresume(String cruramyodynamiaresume) {
		this.cruramyodynamiaresume = cruramyodynamiaresume;
	}

	public String getPuncturepointache() {
		return this.puncturepointache;
	}

	public void setPuncturepointache(String puncturepointache) {
		this.puncturepointache = puncturepointache;
	}

	public String getSpinalanalgesiaheadache() {
		return this.spinalanalgesiaheadache;
	}

	public void setSpinalanalgesiaheadache(String spinalanalgesiaheadache) {
		this.spinalanalgesiaheadache = spinalanalgesiaheadache;
	}

	public String getUroschesis() {
		return this.uroschesis;
	}

	public void setUroschesis(String uroschesis) {
		this.uroschesis = uroschesis;
	}

	public String getAwarenessOperation() {
		return this.awarenessOperation;
	}

	public void setAwarenessOperation(String awarenessOperation) {
		this.awarenessOperation = awarenessOperation;
	}

	public String getMuscularSoreness() {
		return this.muscularSoreness;
	}

	public void setMuscularSoreness(String muscularSoreness) {
		this.muscularSoreness = muscularSoreness;
	}

	public String getAllsick() {
		return this.allsick;
	}

	public void setAllsick(String allsick) {
		this.allsick = allsick;
	}

	public String getAllvomit() {
		return this.allvomit;
	}

	public void setAllvomit(String allvomit) {
		this.allvomit = allvomit;
	}

	public String getLumbago() {
		return this.lumbago;
	}

	public void setLumbago(String lumbago) {
		this.lumbago = lumbago;
	}

	public String getNeuralsick() {
		return this.neuralsick;
	}

	public void setNeuralsick(String neuralsick) {
		this.neuralsick = neuralsick;
	}

	public String getNeuralvomit() {
		return this.neuralvomit;
	}

	public void setNeuralvomit(String neuralvomit) {
		this.neuralvomit = neuralvomit;
	}

	public String getLegParesthesia() {
		return this.legParesthesia;
	}

	public void setLegParesthesia(String legParesthesia) {
		this.legParesthesia = legParesthesia;
	}

	public String getLegParesthesiaDetails() {
		return this.legParesthesiaDetails;
	}

	public void setLegParesthesiaDetails(String legParesthesiaDetails) {
		this.legParesthesiaDetails = legParesthesiaDetails;
	}

	public String getLegMovement() {
		return this.legMovement;
	}

	public void setLegMovement(String legMovement) {
		this.legMovement = legMovement;
	}

	public String getLegMovementDetails() {
		return this.legMovementDetails;
	}

	public void setLegMovementDetails(String legMovementDetails) {
		this.legMovementDetails = legMovementDetails;
	}

	public String getNeuralObservepeople() {
		return this.neuralObservepeople;
	}

	public void setNeuralObservepeople(String neuralObservepeople) {
		this.neuralObservepeople = neuralObservepeople;
	}

	public String getNeuralObservetime() {
		return this.neuralObservetime;
	}

	public void setNeuralObservetime(String neuralObservetime) {
		this.neuralObservetime = neuralObservetime;
	}

	public String getNerveBlockedObservepeople() {
		return this.nerveBlockedObservepeople;
	}

	public void setNerveBlockedObservepeople(String nerveBlockedObservepeople) {
		this.nerveBlockedObservepeople = nerveBlockedObservepeople;
	}

	public String getNerveBlockedObservetime() {
		return this.nerveBlockedObservetime;
	}

	public void setNerveBlockedObservetime(String nerveBlockedObservetime) {
		this.nerveBlockedObservetime = nerveBlockedObservetime;
	}

	public String getNeuralRemark() {
		return this.neuralRemark;
	}

	public void setNeuralRemark(String neuralRemark) {
		this.neuralRemark = neuralRemark;
	}

	public String getNerveBlockedRemark() {
		return this.nerveBlockedRemark;
	}

	public void setNerveBlockedRemark(String nerveBlockedRemark) {
		this.nerveBlockedRemark = nerveBlockedRemark;
	}

	public String getPulse() {
		return this.pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBloodPreL() {
		return this.bloodPreL;
	}

	public void setBloodPreL(String bloodPreL) {
		this.bloodPreL = bloodPreL;
	}

	public String getBloodPreH() {
		return this.bloodPreH;
	}

	public void setBloodPreH(String bloodPreH) {
		this.bloodPreH = bloodPreH;
	}

	public String getObservepeople() {
		return this.observepeople;
	}

	public void setObservepeople(String observepeople) {
		this.observepeople = observepeople;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnalgesiaplan() {
		return this.analgesiaplan;
	}

	public void setAnalgesiaplan(String analgesiaplan) {
		this.analgesiaplan = analgesiaplan;
	}

	public String getObserveaftertime() {
		return this.observeaftertime;
	}

	public void setObserveaftertime(String observeaftertime) {
		this.observeaftertime = observeaftertime;
	}

	public String getQuietvas() {
		return this.quietvas;
	}

	public void setQuietvas(String quietvas) {
		this.quietvas = quietvas;
	}

	public String getExercisevas() {
		return this.exercisevas;
	}

	public void setExercisevas(String exercisevas) {
		this.exercisevas = exercisevas;
	}

	public String getLethargy() {
		return this.lethargy;
	}

	public void setLethargy(String lethargy) {
		this.lethargy = lethargy;
	}

	public String getNaupathia() {
		return this.naupathia;
	}

	public void setNaupathia(String naupathia) {
		this.naupathia = naupathia;
	}

	public String getVomit() {
		return this.vomit;
	}

	public void setVomit(String vomit) {
		this.vomit = vomit;
	}

	public String getPruritus() {
		return this.pruritus;
	}

	public void setPruritus(String pruritus) {
		this.pruritus = pruritus;
	}

	public String getUroschesisafter() {
		return this.uroschesisafter;
	}

	public void setUroschesisafter(String uroschesisafter) {
		this.uroschesisafter = uroschesisafter;
	}

	public String getObservepeopleafter() {
		return this.observepeopleafter;
	}

	public void setObservepeopleafter(String observepeopleafter) {
		this.observepeopleafter = observepeopleafter;
	}

	public String getRemarkafter() {
		return this.remarkafter;
	}

	public void setRemarkafter(String remarkafter) {
		this.remarkafter = remarkafter;
	}

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
	
		this.id = id;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

}