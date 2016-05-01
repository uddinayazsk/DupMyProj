package com.form;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileForm extends ActionForm{	
	
	private FormFile file=null;
	
	public void setFile(FormFile file){ 
		this.file=file;
		System.out.println("SET file ="+this.file);
	}

	public FormFile getFile(){
		System.out.println("GET file ="+this.file);
		return this.file;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		String fileExtension = null;
		String fileName = getFile().getFileName();
		System.out.println("content="+getFile().getContentType());
		StringTokenizer st = new StringTokenizer(fileName, "."); 
		while(st.hasMoreTokens()) { 
			fileExtension = st.nextToken();
		}
		System.out.println("fileExtension : "+fileExtension);
		System.out.println("fileName : "+fileName);
		
		if(fileExtension != null && fileExtension.equals("bat")){ //To filter .bat file
			errors.add("common.file.err.ext.bat", new ActionMessage("error.common.file.bat.notallowed"));
			return errors;
		}else if(fileExtension != null && fileExtension.equals("exe")){ //To filter .exe file
			errors.add("common.file.err.ext.exe", new ActionMessage("error.common.file.exe.notallowed"));
			return errors;
		}/*else Mapping from JSP common.file.err.ext.bat to MODEL error.common.file.exe.notallowed to PROPERTIES 
		  		value=Batch file (.bat) cannot be uploaded for security purpose displayed in JSP
		{
		    fileExtension.equals("log");
		    errors.add("common.file.err.ext.log", new ActionMessage("error.common.file.log.notallowed"));
		    return errors;
		}*/
		return errors;
	}

}
