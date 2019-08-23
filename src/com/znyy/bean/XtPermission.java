package com.znyy.bean;

import java.util.Date;


 /** 
 * @类名称: XtPermission
 * @类描述:权限表
 * @作者:慕金剑
 * @创建时间:2015-12-7 下午1:08:40
 */
 
public class XtPermission implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private XtFunction function;
	private String flag;
	private Date enterdate;
	private Integer enterOpera;
	private XtFunButton btn;
	private Long hospitalId;
	
	public XtPermission() {
	}

	public XtPermission(String name, XtFunction function,XtFunButton btn,
	String flag, Date enterdate,Integer enterOpera) {
		this.name = name;
		this.function = function;
		this.btn = btn;
		this.flag = flag;
		this.enterdate = enterdate;
		this.enterOpera = enterOpera;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	public Date getEnterdate() {
	
		return enterdate;
	}

	public void setEnterdate(Date enterdate) {
	
		this.enterdate = enterdate;
	}

	 /** 
	 * @方法名称: equals
	 * @功能描述:如果对象类型是XtPermission 的话 则返回true 去比较hashCode值
	 * @作者:杨云博
	 * @创建时间:2015-12-10 下午4:37:20
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 
	@Override
   public boolean equals(Object obj) {
       if(obj == null) return false;
       if(this == obj) return true;
       if(obj instanceof XtPermission){ 
       	XtPermission per =(XtPermission)obj;
//         if(role.id = this.id) return true; // 只比较id
           // 比较id 一致时才返回true 之后再去比较 hashCode
           if(per.id.equals(this.id)) return true;
           }
       return false;
   }

    /** 
    * @方法名称: hashCode
    * @功能描述:重写hashcode 方法，返回的hashCode 不一样才认定为不同的对象
    * @作者:杨云博
    * @创建时间:2015-12-10 下午4:37:05
    * @return
    * @see java.lang.Object#hashCode()
    */
    
	@Override
   	public int hashCode() {
       return id.hashCode(); // 只比较id，id一样就不添加进集合
   }
	public XtFunButton getBtn() {
	
		return btn;
	}
	public void setBtn(XtFunButton btn) {
	
		this.btn = btn;
	}

	public XtFunction getFunction() {
	
		return function;
	}

	public void setFunction(XtFunction function) {
	
		this.function = function;
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