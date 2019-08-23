package com.znyy.bean;
/**
 * SmWorkstation entity. @author MyEclipse Persistence Tools
 */

public class SmWorkstation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String type;
	private String room;
	private String ip;
	private String port;
	private String controlIp;
	private String controlPort;
	private String enable;
	private String netPort;
	private String portId;
	// Constructors

	/** default constructor */
	public SmWorkstation() {
	}

	/** full constructor */
	public SmWorkstation(String type, String room, String ip, String port,
			String controlIp, String controlPort, String enable, String netPort) {
		this.type = type;
		this.room = room;
		this.ip = ip;
		this.port = port;
		this.controlIp = controlIp;
		this.controlPort = controlPort;
		this.enable = enable;
		this.netPort = netPort;
	}

	// Property accessors


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getControlIp() {
		return this.controlIp;
	}

	public void setControlIp(String controlIp) {
		this.controlIp = controlIp;
	}

	public String getControlPort() {
		return this.controlPort;
	}

	public void setControlPort(String controlPort) {
		this.controlPort = controlPort;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getNetPort() {
		return this.netPort;
	}

	public void setNetPort(String netPort) {
		this.netPort = netPort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}


}