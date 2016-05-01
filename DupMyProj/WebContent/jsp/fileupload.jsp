<%@ page import="org.apache.struts.Globals"%>
<%@ page import="org.apache.struts.action.Action"%>
<%@ page import="org.apache.struts.taglib.html.Constants"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="org.apache.struts.Globals"%>
<%@ page import="org.apache.struts.action.Action"%>
<%@ page import="org.apache.struts.taglib.html.Constants"%>
<!-- /*
Mapping from JSP common.file.err.ext.bat to MODEL error.common.file.exe.notallowed (i.e. key in properties) 
 to PROPERTIES value=Batch file (.bat) cannot be uploaded for security purpose displayed in JSP
		  		
		  		*/
 -->
 <html:html>
	<body>
		<div style="color:red">
				<html:errors property="common.file.err.ext.bat" />
		</div>		
		<div style="color:red">
				<html:errors property="common.file.err.ext.exe" />	
		</div>	
		
	<html:form action="/FileAction" method="post" enctype="multipart/form-data">
	<input type="hidden" 
         name="<%=org.apache.struts.taglib.html.Constants.TOKEN_KEY%>" 
          value="<bean:write name="<%=Globals.TRANSACTION_TOKEN_KEY%>"/>">  
			Choose the File to UPLOAD
			<html:file property="file"/><br>                         
			<html:submit>Save</html:submit>	
			
			 
		
		<br><br>
			<br><br>
	</html:form>
	<body>	
</html:html>
