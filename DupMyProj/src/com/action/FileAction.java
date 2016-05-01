package com.action;

// import MyModel;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.form.FileForm;

public class FileAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FileForm myModel = (FileForm) form;
		if (isTokenValid(request)) {

			FormFile myFile = myModel.getFile();

			// Get the upload directory real path name
			String filePath = "E://j2ee//correct code//navid//DupMyProj//upload";
			System.out.println("FilePath to upload : " + filePath);

			// create the upload folder if not exists
			File folder = new File(filePath);
			if (!folder.exists()) {
				folder.mkdir();
			}
			String contentType = myFile.getContentType();
			System.out.println("contentType ="+contentType);
			String fileName = myFile.getFileName();
			int fileSize = myFile.getFileSize();
			byte[] fileData = myFile.getFileData();

			if (fileName != null && (!fileName.equals(""))) {
				File newFile = new File(filePath, fileName);

				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(fileData);
					fos.flush();
					fos.close();
				}

				request.setAttribute("uploadedFilePath",
						newFile.getAbsoluteFile());
				request.setAttribute("uploadedFileName", newFile.getName());

				resetToken(request);
				return mapping.findForward("success");
			} else {
				request.setAttribute("uploadedFileName", fileName);
				return mapping.findForward("failure");
			}
		} else {
			// This is Duplicate Submission of the form
			// Return to the JSP to display the error message ( This is
			// Duplicate
			// Submission);
			System.out.println("Duplicate submission by malicious user");
			return mapping.findForward("fail");

		}

	}//execute

}//FileAction

