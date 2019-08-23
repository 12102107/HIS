package com.znyy.sm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.common.action.AbstractAction;
import com.common.util.DateUtil;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmPortConfig;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWorkstation;
import com.znyy.sm.service.OperroomService;
import com.znyy.sm.service.WorkStationService;
import com.znyy.sys.user.service.PermissionService;

/**
 * @类名称: WorkStationAction
 * @类描述:工作站Action
 * @作者:付士山
 * @创建时间:2015-12-31 上午10:23:13
 */

public class WorkStationAction extends AbstractAction {
	private WorkStationService workStationService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String name;
	private String info;
	private String id;
	private OperroomService operroomService;
	private String type;
	private SmWorkstation ws;
	private String data = "";
	private SmPortConfig port;

	public String getInfo() {

		return info;
	}

	public void setInfo(String info) {

		this.info = info;
	}

	private PermissionService permissionService;
	private boolean updateRole;
	private boolean addRole;
	private boolean selectRole;
	private String functionid;

	/**
	 * @方法名称: getWsList
	 * @功能描述: 获取工作站信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:40:11
	 * @return String
	 */

	public String getWsList() {
		String result = "success";

		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		int newPage = Integer.parseInt(page);
		int xh = (newPage - 1) * pageSize + 1;
		Page pageSpList = workStationService
				.getWsList(name, parmpage, pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		request.setAttribute("wsList", pageSpList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);

		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,
				(String) this.session.get("sysid"));
		updateRole = btnCodes.contains("update");
		addRole = btnCodes.contains("add");
		selectRole = btnCodes.contains("select");
		
		return result;
	}

	
	/**
	 * @方法名称: getPortList
	 * @功能描述: 获取端口配置信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:40:11
	 * @return String
	 */

	public String getPortList() {
		String result = "success";

		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		int newPage = Integer.parseInt(page);
		int xh = (newPage - 1) * pageSize + 1;
		Page pageSpList = workStationService
				.getPList( parmpage, pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		request.setAttribute("portList", pageSpList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);
		if (id != null) {
			request.setAttribute("workid", id);
			ws = workStationService.getWsById(id);
			
		}
		
		return result;
	}
	/**
	 * @方法名称: addStationGo
	 * @功能描述: 跳转到工作站添加页
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:52:57
	 * @return String
	 */

	public String addStationGo() {

		return SUCCESS;
	}

	/**
	 * @方法名称: addStationGo
	 * @功能描述: 跳转到工作站修改页
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:52:57
	 * @return String
	 */

	public String modStationGo() {
		
		String workid = request.getParameter("workid");
		if (workid!=null) {
			ws = workStationService.getWsById(workid);
		}
		String portid = request.getParameter("portid");
		if (portid!=null) {
			int portid1 = Integer.parseInt(portid);
			port = workStationService.getPortById(portid1);
		}
		
		return SUCCESS;
	}

	
	/**
	 * @方法名称: modWsListTo
	 * @功能描述: 修改端口配置跳转
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午5:32:39
	 * @return String
	 */

	public String modPListTo() {
		  int portid = Integer.parseInt(id);
		port = workStationService.getPortById(portid);

		return "success";
	}

	/**
	 * @方法名称: addPortGo
	 * @功能描述: 跳转到端口配置添加页
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:52:57
	 * @return String
	 */

	public String addPortGo() {
		return SUCCESS;
	}


	/**
	 * @方法名称: addStation
	 * @功能描述: 添加工作站
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午1:24:23
	 * @return String
	 */

	public String addStation() {
		String result = "success";
		if (id != null && id.trim().length() > 0) {
			SmWorkstation wss = workStationService.getWsById(id);
			wss.setControlIp(ws.getControlIp());
			wss.setControlPort(ws.getControlPort());
			wss.setEnable(ws.getEnable());
			wss.setIp(ws.getIp());
			wss.setNetPort(ws.getNetPort());
			wss.setPort(ws.getPort());
			wss.setRoom(ws.getRoom());
			wss.setType(ws.getType());
			wss.setPortId(ws.getPortId());
			try {
				workStationService.modWsList(wss);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {
			try {
				workStationService.addStation(ws);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * @方法名称: addPortConfig
	 * @功能描述: 添加端口配置
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午1:24:23
	 * @return String
	 */

	public String addPortConfig() {
		String result = "success";
		if(id!=null  && id.trim().length()>0){ 
			int portid = Integer.parseInt(id);
			SmPortConfig ports = workStationService.getPortById(portid);
			ports.setSerial(port.getSerial());
			ports.setBaudrate(port.getBaudrate());
			ports.setChoice(port.getChoice());
			ports.setEdition(port.getEdition());
			ports.setModel(port.getModel());
			
			try {
				workStationService.modPortList(ports);
				info = "修改成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "修改失败";
			}
		}
		else{
		
		try {
			workStationService.addPortConfig(port);
			info = "保存成功";
		} catch (Exception e) {
			info = "保存失败";
			e.printStackTrace();
		}
		}

		return result;
	}

	/**
	 * @方法名称: getRoom
	 * @功能描述: 获取手术室
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午2:05:58
	 * @return String
	 */

	public String getRoom() {

		List<SmOperroom> list = operroomService.getRoomList("0", type);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperroom p = (SmOperroom) list.get(i);
				data += "<option value=\"" + p.getName() + "\">" + p.getName()
						+ "</option>";
			}
		}

		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @方法名称: checkId
	 * @功能描述: 查询工作站ID是否存在
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午3:09:47
	 * @return String
	 */

	public String checkId() {
		String responseInfo = "";

		try {
			String gzzId = request.getParameter("gzzId");
			List<SmWorkstation> list = workStationService.checkId(gzzId);

			if (list.size() > 0) {
				responseInfo = "1";
			} else {
				responseInfo = "0";
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(responseInfo);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @方法名称: modWsListTo
	 * @功能描述: 修改工作站跳转
	 * @作者:付士山
	 * @创建时间:2016-7-12 下午5:32:39
	 * @return String
	 */

	public String modWsListTo() {
		ws = workStationService.getWsById(id);
		return "success";
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public SmWorkstation getWs() {
		return ws;
	}

	public void setWs(SmWorkstation ws) {
		this.ws = ws;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public WorkStationService getWorkStationService() {
		return workStationService;
	}

	public void setWorkStationService(WorkStationService workStationService) {
		this.workStationService = workStationService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public boolean isUpdateRole() {
		return updateRole;
	}

	public void setUpdateRole(boolean updateRole) {
		this.updateRole = updateRole;
	}

	public boolean isAddRole() {
		return addRole;
	}

	public void setAddRole(boolean addRole) {
		this.addRole = addRole;
	}

	public boolean isSelectRole() {
		return selectRole;
	}

	public void setSelectRole(boolean selectRole) {
		this.selectRole = selectRole;
	}

	public String getFunctionid() {
		return functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public OperroomService getOperroomService() {
		return operroomService;
	}

	public void setOperroomService(OperroomService operroomService) {
		this.operroomService = operroomService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SmPortConfig getPort() {
		return port;
	}

	public void setPort(SmPortConfig port) {
		this.port = port;
	}

}
