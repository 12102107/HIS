package com.znyy.sm.action;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmNotice;
import com.znyy.sm.service.NoticeService;
import com.znyy.sys.user.service.PermissionService;
 /** 
 * @类名称: NoticeAction
 * @类描述:公告定义Action
 * @作者:付士山
 * @创建时间:2016-3-24 下午1:19:59
 */
 
public class NoticeAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private List<SmNotice> nocList;
	private NoticeService noticeService;
	private SmNotice notice;
	private Integer pageSize;
	private String page;
	private String rows;
	private String name;
	private String info;
	private String userId;
	private String userNameResult;
	private Integer id;
	
	private PermissionService permissionService;
	private boolean addRole; 
	private boolean updateRole; 
	private boolean delRole; 
	private String functionid; 
	
	
	 /**
	 * @方法名称: getNotcList
	 * @功能描述: 获取公告信息列表
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午1:45:45
	 * @return String   
	 */
	 
	public String getNotcList() {
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
		Page pageSpList = noticeService.getNotcList(name, parmpage, pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		session.put("nocList", pageSpList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		addRole = btnCodes.contains("add");
		updateRole = btnCodes.contains("update");
		delRole = btnCodes.contains("del");
		
		return result;
	}

	
	 /**
	 * @方法名称: modNoticeListTo
	 * @功能描述: 公告修改跳转
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:03:54
	 * @return String   
	 */
	 
	public String modNoticeListTo() {
		
		notice = noticeService.getNoticeById(id);
		return "success";
	}
	
	
	
	 /**
	 * @方法名称: modNoticeList
	 * @功能描述: 修改公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:19:51
	 * @return String   
	 */
	 
	public String modNoticeList() {
		SmNotice noti= noticeService.getNoticeById(id);
		noti.setContent(notice.getContent());
		noti.setTitle(notice.getTitle());
		noti.setUpdateTime(new Date());
		noti.setAuthor(notice.getAuthor());
		
		try {
			noticeService.modNoticeList(noti);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	
	 /**
	 * @方法名称: addNoticeGo
	 * @功能描述: 跳转到添加公告的页面
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午5:08:08
	 * @return String   
	 */
	 
	public String addNoticeGo(){
		return SUCCESS;
	
	}
	
	 /**
	 * @方法名称: addNotice
	 * @功能描述: 添加公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午5:15:45
	 * @return String   
	 */
	 
	public String addNotice(){
		String result="success";
		notice.setUpdateTime(new Date());
		try {
			noticeService.addNotice(notice);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	 /**
	 * @方法名称: delNotice
	 * @功能描述: 删除公告
	 * @作者:付士山
	 * @创建时间:2016-3-25 上午10:32:57
	 * @return String   
	 */
	 
	public String delNotice() {
		SmNotice notic= noticeService.getNoticeById(id);
		try {
			noticeService.delNotice(notic);
			info = "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "删除失败";
		}
		return "success";
	}
	
	public String getOpterName(){
		Map<String, Object> map = noticeService.getOpterNameByUserId(userId);
		JSONObject jsonObject = JSONObject.fromObject(map); 
		this.userNameResult=jsonObject.toString();	
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<SmNotice> getNoticeList() {
	
		return nocList;
	}


	public void setNoticeList(List<SmNotice> nocList) {
	
		this.nocList = nocList;
	}


	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}


	public NoticeService getNoticeService() {
	
		return noticeService;
	}


	public void setNoticeService(NoticeService noticeService) {
	
		this.noticeService = noticeService;
	}


	public SmNotice getNotice() {
	
		return notice;
	}


	public void setNotice(SmNotice notice) {
	
		this.notice = notice;
	}


	public List<SmNotice> getNocList() {
	
		return nocList;
	}


	public void setNocList(List<SmNotice> nocList) {
	
		this.nocList = nocList;
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


	public String getName() {
	
		return name;
	}


	public void setName(String name) {
	
		this.name = name;
	}


	public String getInfo() {
	
		return info;
	}


	public void setInfo(String info) {
	
		this.info = info;
	}

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
	
		this.id = id;
	}


	/**
	 * @return the permissionService
	 */
	public PermissionService getPermissionService() {
		return permissionService;
	}


	/**
	 * @param permissionService the permissionService to set
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}


	/**
	 * @return the addRole
	 */
	public boolean isAddRole() {
		return addRole;
	}


	/**
	 * @param addRole the addRole to set
	 */
	public void setAddRole(boolean addRole) {
		this.addRole = addRole;
	}


	/**
	 * @return the updateRole
	 */
	public boolean isUpdateRole() {
		return updateRole;
	}


	/**
	 * @param updateRole the updateRole to set
	 */
	public void setUpdateRole(boolean updateRole) {
		this.updateRole = updateRole;
	}


	/**
	 * @return the delRole
	 */
	public boolean isDelRole() {
		return delRole;
	}


	/**
	 * @param delRole the delRole to set
	 */
	public void setDelRole(boolean delRole) {
		this.delRole = delRole;
	}


	/**
	 * @return the functionid
	 */
	public String getFunctionid() {
		return functionid;
	}


	/**
	 * @param functionid the functionid to set
	 */
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserNameResult() {
		return userNameResult;
	}


	public void setUserNameResult(String userNameResult) {
		this.userNameResult = userNameResult;
	}

}
