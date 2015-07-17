package edu.neu.webtoolFinal.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.ui.Model;

public class fildDAO {
	
	public ArrayList insertPicture(Model model, HttpServletRequest request){
		   ArrayList fileNames=new ArrayList<String>();
		   
		   File file ;
		   int maxFileSize = 5000 * 1024;
		   int maxMemSize = 5000 * 1024;
		 //  ServletContext context = pageContext.getServletContext();
		   String filePath = "/Users/huangxingyang/Documents/workspace-sts-3.6.4.RELEASE/WebToolsFinal/src/main/webapp/resources/imgs/";

		   // 验证上传内容了类型
		   String contentType = request.getContentType();
		   if ((contentType.indexOf("multipart/form-data") >= 0)) {

			      DiskFileItemFactory factory = new DiskFileItemFactory();
			      // 设置内存中存储文件的最大值
			      factory.setSizeThreshold(maxMemSize);
			      // 本地存储的数据大于 maxMemSize.
			      factory.setRepository(new File("c:\\temp"));

			      // 创建一个新的文件上传处理程序
			      ServletFileUpload upload = new ServletFileUpload(factory);
			      // 设置最大上传的文件大小
			      upload.setSizeMax( maxFileSize );
			      try{ 
			         // 解析获取的文件
			         List fileItems = upload.parseRequest(request);

			         // 处理上传的文件
			         Iterator i = fileItems.iterator();

			         while ( i.hasNext () ) 
			         {
			            FileItem fi = (FileItem)i.next();
			            if ( !fi.isFormField () )	
			            {
			    
			            String fieldName = fi.getFieldName();
			            String fileName = fi.getName();
			            fileNames.add(fileName);
			            boolean isInMemory = fi.isInMemory();
			            long sizeInBytes = fi.getSize();
			            // 写入文件
			            if( fileName.lastIndexOf("\\") >= 0 ){
			            file = new File( filePath , 
			            fileName.substring( fileName.lastIndexOf("\\"))) ;
			            }else{
			            file = new File( filePath ,
			            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			            }
			            fi.write( file ) ;
	;
			            }
			         }
			   
			
			      }catch(Exception ex) {
			         System.out.println(ex);
			        
			      }
		
		
		   }
		   return fileNames;
		   
	}

     }
