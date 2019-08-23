package com.znyy.sm.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.znyy.bean.SmMedicalStandard;
import com.znyy.sm.service.MedicalStandardService;

/**
 * @类名称: MedicalStandard
 * @类描述:知识库Action
 * @作者:付士山
 * @创建时间:2016-7-11 上午11:47:28
 */

public class MedicalStandardAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private SmMedicalStandard ms;
	private MedicalStandardService medicalStandardService;
	private List<SmMedicalStandard> msList;
	private String zskName;
	private String knowId;
	private String info;

	/**
	 * @方法名称: zskListTo
	 * @功能描述: 初始化界面
	 * @作者:付士山
	 * @创建时间:2016-7-29 下午5:00:50
	 * @return String
	 */

	public String zskListTo() {
		msList = medicalStandardService.getCatalogList();
		return "success";
	}

	
	 /**
	 * @方法名称: addCatalog
	 * @功能描述: 添加目录
	 * @作者:付士山
	 * @创建时间:2016-8-10 下午2:15:55
	 * @return String   
	 */
	 
	public String addCatalog() {
		ms.setPid(0);

		try {
			medicalStandardService.addFile(ms);
			info = "添加成功";
		} catch (Exception e) {
			info = "添加失败";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * @方法名称: getZskList
	 * @功能描述: 获取菜单信息
	 * @作者:付士山
	 * @创建时间:2016-7-29 下午5:01:03
	 * @throws IOException
	 *             void
	 */

	public void getZskList() throws IOException {

		msList = medicalStandardService.getMs();
		List<String> lstTree = new ArrayList<String>();
		for (int i = 0; i < msList.size(); i++) {
			SmMedicalStandard sm = msList.get(i);
			String s = "";
			s = "{id:" + sm.getId() + ", pId:" + sm.getPid() + ", name:\""+ sm.getName() + "\" }";
			lstTree.add(s);
		}

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(JSONArray.fromObject(lstTree).toString());

	}

	/**
	 * @方法名称: queryZskSummaryById
	 * @功能描述: 根据id查询简介
	 * @作者:付士山
	 * @创建时间:2016-7-29 下午5:00:28
	 * @throws IOException
	 *             void
	 */

	public void queryZskSummaryById() throws IOException {

		ms = medicalStandardService.queryZskSummaryById(knowId);
		response.setContentType("text/html;charset=utf-8");
		if (ms == null) {
			response.getWriter().print("1");
		}
		if (ms != null) {
			response.getWriter().print(ms.getSummary());
		}

	}

	
	 /**
	 * @方法名称: zskDel
	 * @功能描述: 文档删除
	 * @作者:付士山
	 * @创建时间:2016-8-10 下午2:15:36
	 * @return String   
	 */
	 
	public String zskDel() {

		ms = medicalStandardService.queryZskById(knowId);
		String realpath = ServletActionContext.getServletContext().getRealPath("/data");
		// 路径为文件且不为空则进行删除
		File savefile = new File(new File(realpath), ms.getName());
		if (savefile.isFile() && savefile.exists()) {
			savefile.delete();
		}
		medicalStandardService.zskDel(ms);
		return SUCCESS;
	}

	// 文件读取
	public String readFile() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/data");
			PrintWriter out = response.getWriter();
			msList = medicalStandardService.getMs();
			for (int i = 0; i < msList.size(); i++) {
				if (!msList.get(i).getName().equals(zskName)) {
					out.println();
				}
			}
			// String path = "e:/up";// 路径 ，比如d: 标示D盘
			FileReader fr = new FileReader(realpath + "\\" + zskName); // 建立FileReader对象,并设定由fr对象变量引用
			BufferedReader br = new BufferedReader(fr); // 建立BufferedReader对象,并设定由br对象变量引

			while (br.readLine() != null) {
				String Line = br.readLine(); // 读取一行数据
				out.println(Line + "<BR>");
			} // 输出读取得的数据
			br.close(); // 关闭BufferedReader对象
			fr.close(); // 关闭文件
			out.flush();
			out.close();

		} catch (Exception e) {

		}

		return null;
	}

	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 标记上传文件的结果：成功/失败
	private String result;

	// 文件上传
	public String fileUpload() throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			if (request.getContentLength() > 297) {

				String realpath = ServletActionContext.getServletContext()
						.getRealPath("/data");

				if (upload != null) {
					File savefile = new File(new File(realpath), uploadFileName);
					if (!savefile.getParentFile().exists())
						savefile.getParentFile().mkdirs();
					FileUtils.copyFile(upload, savefile);
					ms.setName(uploadFileName);
					// System.out.println(ms.getName());
					medicalStandardService.addFile(ms);
					// ActionContext.getContext().put("message", "文件上传成功");
				}

				// 提示：上传成功
				result = "文件上传成功！";
				out.print(result);

			} else {
				out.print("请选择文件!");
			}
		} catch (Exception e) {
			// 提示：上传失败
			String result = "文件上传失败！";
			out.print(result);
		}

		return SUCCESS;
	}

	// 文件下载
	public String fileDownload() throws InterruptedException, IOException {

		ms = medicalStandardService.queryZskSummaryById(knowId);

		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/data")
				+ "\\";
		String path = "";
		if (ms != null) {
			path = realpath + ms.getName();
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			// String ext = filename.substring(filename.lastIndexOf(".") + 1)
			// .toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			String filenameString = new String(filename.getBytes("UTF-8"),
					"iso-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filenameString);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public MedicalStandardService getMedicalStandardService() {
		return medicalStandardService;
	}

	public void setMedicalStandardService(
			MedicalStandardService medicalStandardService) {
		this.medicalStandardService = medicalStandardService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SmMedicalStandard getMs() {
		return ms;
	}

	public void setMs(SmMedicalStandard ms) {
		this.ms = ms;
	}

	public List<SmMedicalStandard> getMsList() {
		return msList;
	}

	public void setMsList(List<SmMedicalStandard> msList) {
		this.msList = msList;
	}

	public String getZskName() {
		return zskName;
	}

	public void setZskName(String zskName) {
		this.zskName = zskName;
	}

	public String getKnowId() {
		return knowId;
	}

	public void setKnowId(String knowId) {
		this.knowId = knowId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
