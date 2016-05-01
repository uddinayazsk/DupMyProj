<%@ page import="org.apache.struts.Globals"%>
<%@ page import="org.apache.struts.action.Action"%>
<%@ page import="org.apache.struts.taglib.html.Constants"%>
<%-- <%@ taglib uri="/tags/struts-html" prefix="html" %>                                                                                                                                        
<%@ taglib uri="/tags/struts-bean" prefix="bean" %> --%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html locale="true">
	<html:form action="/myActionForm.do" method="post" enctype="multipart/form-data">
		<p> This is index page</p>
		<html:text property="name" size="30" maxlength="30"/>	

 <input type="hidden" 
name="<%=org.apache.struts.taglib.html.Constants.TOKEN_KEY%>" 
value="<bean:write name="<%=Globals.TRANSACTION_TOKEN_KEY%>"/>">  
		
		<html:submit>Save</html:submit>	
		<br><br>
		
	</html:form>
</html:html>
