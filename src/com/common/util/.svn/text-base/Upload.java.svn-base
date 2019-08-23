
package com.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


 /** 
 * @类名称: Upload
 * @类描述:
 * @作者:杨云博
 * @创建时间:2015-12-7 下午1:07:46
 */
 
public class Upload{
   
 /**
 * @方法名称: upload
 * @功能描述: 上传工具类
 * @作者:杨云博
 * @创建时间:2015-12-7 下午1:07:54
 * @param file
 * @param fileFileName
 * @param savePath
 * @return int   
 */
public static int upload(File file,String fileFileName,String savePath){
   int a = 1;
   try {
	if(null!=file){
			InputStream is = new FileInputStream(file);
			String str = ServletActionContext.getServletContext().getRealPath(savePath);
			File dirFile = new File(str);
			System.out.println(dirFile.exists());
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			File f = new File(str, fileFileName);

			OutputStream os = new FileOutputStream(f);
			int size=(int) file.length();
			byte[] b = new byte[10000000];
			while (is.read(b) != -1) {
				os.write(b, 0, size);
			}
			is.close();
			os.close();
		
	 }
	} catch (Exception e) {
		e.printStackTrace();
		a = 2;
	}
   return a;
}
   
}

