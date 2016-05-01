 <%-- <%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %> --%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<html:html>
	<html:form action="/LoadAction.do" method="post" enctype="multipart/form-data">  
		 <html:submit>Click to redirect input page</html:submit>	
		<br><br>
	</html:form>
</html:html>  
