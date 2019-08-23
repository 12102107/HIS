package com.znyy.sm.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.znyy.bean.SmRemarkPoint;
import com.znyy.sm.service.AnesthesiaRecordService;

public class MachineSocket {
	
	private String ip;
	private Integer port;  
	private String operationId;
	private String hospitalCode;
	private String roomCode;
	private AnesthesiaRecordService anesthesiaRecordService;
	
	public static int[] wavesId = { 161, 101, 151, 171, 172, 170, 251, 201,800, 160 };
	
	/**
	 * @方法名称: MachineSocket
	 * @功能描述: 有参构造方法
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 */
	public MachineSocket(String ip ,Integer port,String operationId,String hospitalCode,String roomCode,AnesthesiaRecordService anesthesiaRecordService){
		this.ip = ip;
		this.port = port;
		this.operationId = operationId;
		this.hospitalCode = hospitalCode;
		this.roomCode = roomCode;
		this.anesthesiaRecordService = anesthesiaRecordService;
		init();
	}
	
	
	
	
	/**
	 * @方法名称: init
	 * @功能描述: 初始化连接
	 * @作者：崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 */
	private void init() {
		ReadThread r = new ReadThread();
		r.start();
		
	}
	
	/**
	 * @类名称: ReadThread
	 * @类描述: 多线程内部类
	 * @作者：崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 */
	public class ReadThread extends Thread {
		int i = 0;
		boolean flag = true;
		String s = "";

		int prNum = 0;
		int rrNum = 0;
		int hrNum = 0;
		int t1Num = 0;
		int t2Num = 0;
		int fiCO2Num = 0;
		int spO2Num = 0;

		double bp_sys = 0D;
		double bp_dia = 0D;
		double pr = 0d;
		double rr = 0d;
		double hr = 0d;
		double t1 = 0d;
		double t2 = 0d;
		double fiCO2 = 0d;
		double spO2 = 0d;

		Socket socket;
		OutputStream outstream;
		@Override
		public void run() {
			final byte[] out = createHL7News(wavesId).getBytes();
			try {
				socket = new Socket(ip, port);
				outstream = socket.getOutputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
			s = this.getName();

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {

				public void run() {
					/*System.out
							.println("------------------------START-------------------------------"
									+ s);*/
					prNum = 0;
					rrNum = 0;
					hrNum = 0;
					t1Num = 0;
					t2Num = 0;
					fiCO2Num = 0;
					spO2Num = 0;
					
					//以下为手麻对解析之后的数据进行数据库保存
					List<SmRemarkPoint> l = new ArrayList<SmRemarkPoint>();
					Date d = new Date();
					if(bp_sys!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("BPSYS");
						srp.setValue(bp_sys);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(bp_dia!=0){ 
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("BPDIA");
						srp.setValue(bp_dia);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(pr!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("PR");
						srp.setValue(pr);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(rr!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("RR");
						srp.setValue(rr);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(hr!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("HR");
						srp.setValue(hr);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(t1!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("T1");
						srp.setValue(t1);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(t2!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("T2");
						srp.setValue(t2);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(fiCO2!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("FICO2");
						srp.setValue(fiCO2);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					if(spO2!=0){
						SmRemarkPoint srp = new SmRemarkPoint();
						srp.setItemCode("SPO2");
						srp.setValue(spO2);
						srp.setOperationId(operationId);
						srp.setHospitalCode(hospitalCode);
						srp.setRoomCode(roomCode);
						srp.setTime(d);
						l.add(srp);
					}
					try{
						if(!l.isEmpty()){
							for(int i =0;i<l.size();i++){
								SmRemarkPoint rp = l.get(i);
								anesthesiaRecordService.createVitalSign(rp);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					//OutputStream outstream;
					try {
						//outstream = socket.getOutputStream();
						outstream.write(out);
						outstream.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}, 0, 10000);

			try {
				InputStream in = socket.getInputStream();
				InputStreamReader inputs = new InputStreamReader(in);
				BufferedReader bu = new BufferedReader(inputs);
				//以下为对监护仪返回数据拆分解析
				if (bu != null) {
					while (true) {
						String line = bu.readLine();
					//	System.out.println(line);
						if (line != null) {
							String obxnm = "OBX||NM";
							if (line.indexOf(obxnm) == 0) {
								String[] nms = line.split("\\|");
								if (nms[3].split("\\^").length > 1) {
									if (nms[3].equals("161^PR")) {
										if (prNum == 7) 
											pr = strToDouble(nms[5]);
										prNum++;
									}
									if (nms[3].equals("151^RR")) {
										if (rrNum == 7) 
											rr = strToDouble(nms[5]);
										rrNum++;
									}
									if (nms[3].equals("101^HR")) {
										if (hrNum == 7)
											hr = strToDouble(nms[5]);
										hrNum++;
									}
									if (nms[3].equals("200^T1")) {
										if (t1Num == 7)
											t1 = strToDouble(nms[5]);
										t1Num++;
									}
									if (nms[3].equals("201^T2")) {
										if (t2Num == 7)
											t2 = strToDouble(nms[5]);
										t2Num++;
									}
									if (nms[3].equals("160^SpO2")) {
										if (spO2Num == 7)
											spO2 = strToDouble(nms[5]);
										spO2Num++;
									}
									if (nms[3].equals("251^FiCO2")) {
										if (fiCO2Num == 7)
											fiCO2 = strToDouble(nms[5]);
										fiCO2Num++;
									}
									if (nms[3].equals("170^Sys")) {
										bp_sys = strToDouble(nms[5]);
									}
									if (nms[3].equals("171^Dia")) {
										bp_dia = strToDouble(nms[5]);

									}
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	
	/**
	 * @方法名称: createHL7News
	 * @功能描述: 创建hl7消息
	 * @返回值: String
	 * @参数:nowTime wavesId
	 */
	public static String createHL7News( int[] wavesId) {
		String hl7Str1 = "";
		String hl7Str2 = "";
		String hl7Str3 = "";
		int i = 0;
		String time = "";

		// 波形消息MSH段
		hl7Str1 = toStringHex("0B") + "MSH";
		hl7Str1 += "|" + "^~\\&";
		for (i = 2; i < 8; i++) {
			hl7Str1 += "|";
		}
		hl7Str1 += "|" + "QRY^R02";
		hl7Str1 += "|" + "1203";
		hl7Str1 += "|" + "P";
		hl7Str1 += "|" + "2.3.1";
		hl7Str1 += toStringHex("0D");

		// 波形消息QRD段
		hl7Str2 = "QRD";
		time = dateFormatString(new Date(),"yyyyMMddhhmmss");
		hl7Str2 += "|" + time;
		hl7Str2 += "|" + "R";
		hl7Str2 += "|" + "I";
		hl7Str2 += "|" + "Q895211";
		for (i = 5; i < 9; i++) {
			hl7Str2 += "|";
		}
		hl7Str2 += "|" + "RES";
		hl7Str2 += toStringHex("0D");

		// 波形消息QRF段
		hl7Str3 = "QRF";
		hl7Str3 += "|" + "MON";
		for (i = 2; i <= 5; i++) {
			hl7Str3 += "|";
		}
		hl7Str3 += "0&0";
		hl7Str3 += "^" + "1";
		hl7Str3 += "^" + "1";
		hl7Str3 += "^" + "1";
		hl7Str3 += "^";
		hl7Str3 += wavesId[0];

		for (i = 1; i < wavesId.length; i++) {
			hl7Str3 += "&" + wavesId[i];
		}

		hl7Str3 += toStringHex("0D") + toStringHex("1C") + toStringHex("0D");

		return hl7Str1 + hl7Str2 + hl7Str3;

	}
	
	/**
	 * @方法名称: toStringHex
	 * @功能描述: 十六进制转字符串
	 * @返回值: String
	 * @参数:
	 */
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}
	
	
	
	/**
	 * @方法名称: getDateFormatString
	 * @功能描述: 字符串转Date
	 * @作者:
	 * @创建时间:2016-06-15 下午4:16:58
	 * @param millisecond
	 * @param mode
	 * @return int
	 */
	public static String dateFormatString(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}


	
	/**
	 * @方法名称: getStrToDouble
	 * @功能描述: 字符串转Double
	 * @返回值: Double
	 * @参数:
	 */
	public static double strToDouble(String s){
		double d = 0d;
		try {
			d = Double.valueOf(s).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
