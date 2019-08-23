package com.znyy.sm.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.sm.service.AnaesMethodService;
import com.znyy.sys.user.service.PermissionService;

/**
 * @类名称: AnaesMethodAction
 * @类描述:麻醉方法Action
 * @作者:付士山
 * @创建时间:2015-12-31 上午10:23:13
 */

public class AnaesMethodAction extends AbstractAction {
	private AnaesMethodService anaesMethodService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String code;
	private String mname;
	private String yx;
	private String cy;
	private String info;
	private String id;
	private SmAnaesMethod sa;

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
	 * @方法名称: getMzffList
	 * @功能描述: 获取麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:40:11
	 * @return String
	 */

	public String getMzffList() {
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
		Page pageSpList = anaesMethodService.getMzffList(code, mname, cy, yx,
				parmpage, pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		request.setAttribute("mzffList", pageSpList.getData());
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
	 * @方法名称: modMzffListTo
	 * @功能描述: 修改麻醉方法跳转
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午12:00:39
	 * @return String
	 */

	public String modMzffListTo() {
		sa = anaesMethodService.getMzffById(id);
		return "success";
	}

	/**
	 * @方法名称: modMzffList
	 * @功能描述:修改麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:28:06
	 * @return String
	 */

	public String modMzffList() {
		SmAnaesMethod sam = anaesMethodService.getMzffById(id);
		sam.setName(sa.getName());
		sam.setCate1(sa.getCate1());
		sam.setCate2(sa.getCate2());
		sam.setCate3(sa.getCate3());
		sam.setIsUsually(sa.getIsUsually());
		sam.setIsValid(sa.getIsValid());
		try {
			anaesMethodService.modMzffList(sam);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}

	/**
	 * @方法名称: addMzffGo
	 * @功能描述: 跳转到麻醉方法添加页
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:52:57
	 * @return String
	 */

	public String addMzffGo() {
		return SUCCESS;
	}

	/**
	 * @方法名称: addMzff
	 * @功能描述: 添加麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午2:15:35
	 * @return String
	 */

	public String addMzff() {
		String result = "success";
		try {
			anaesMethodService.addMzff(sa);
			info = "添加成功";
		} catch (Exception e) {
			info = "添加失败";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @方法名称: getMzffByName
	 * @功能描述: ajax验证麻醉方法名称
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午3:17:42
	 * @return String
	 */

	public String getMzffByName() {
		String responseInfo = "";

		try {
			String name = request.getParameter("name");
			List<SmAnaesMethod> list = anaesMethodService.getMzffByName(name);

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
	 * @方法名称: getMzffByCode
	 * @功能描述: ajax验证麻醉方法代码
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午5:03:19
	 * @return String
	 */

	public String getMzffByCode() {
		String responseInfo = "";

		try {
			String code = request.getParameter("code");
			List<SmAnaesMethod> list = anaesMethodService.getMzffByCode(code);

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

	public String getRows() {

		return rows;
	}

	public void setRows(String rows) {

		this.rows = rows;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	public AnaesMethodService getAnaesMethodService() {

		return anaesMethodService;

	}

	public void setAnaesMethodService(AnaesMethodService anaesMethodService) {

		this.anaesMethodService = anaesMethodService;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public SmAnaesMethod getSa() {

		return sa;
	}

	public void setSa(SmAnaesMethod sa) {

		this.sa = sa;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public String getMname() {

		return mname;
	}

	public void setMname(String mname) {

		this.mname = mname;
	}

	public String getYx() {

		return yx;
	}

	public void setYx(String yx) {

		this.yx = yx;
	}

	public String getCy() {

		return cy;
	}

	public void setCy(String cy) {

		this.cy = cy;
	}

	/**
	 * @return the permissionService
	 */
	public PermissionService getPermissionService() {
		return permissionService;
	}

	/**
	 * @param permissionService
	 *            the permissionService to set
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	/**
	 * @return the updateRole
	 */
	public boolean isUpdateRole() {
		return updateRole;
	}

	/**
	 * @param updateRole
	 *            the updateRole to set
	 */
	public void setUpdateRole(boolean updateRole) {
		this.updateRole = updateRole;
	}

	/**
	 * @return the addRole
	 */
	public boolean isAddRole() {
		return addRole;
	}

	/**
	 * @param addRole
	 *            the addRole to set
	 */
	public void setAddRole(boolean addRole) {
		this.addRole = addRole;
	}

	/**
	 * @return the selectRole
	 */
	public boolean isSelectRole() {
		return selectRole;
	}

	/**
	 * @param selectRole
	 *            the selectRole to set
	 */
	public void setSelectRole(boolean selectRole) {
		this.selectRole = selectRole;
	}

	/**
	 * @return the functionid
	 */
	public String getFunctionid() {
		return functionid;
	}

	/**
	 * @param functionid
	 *            the functionid to set
	 */
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
