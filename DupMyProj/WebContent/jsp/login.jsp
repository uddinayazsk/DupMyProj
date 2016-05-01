<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
    </head>
    <body>
        <div style="color:red">
             <html:errors /> 
        </div>
        
         <html:form action="/Login" focus="userName" >
         	<table align="center" width="50%" height="50%" background="green" cellpadding="1" border="1">
				<tr><td colspan="2" align="center">User Login Screen</td></tr>
				<tr>
					<td width="50%">User Name </td>
					<td width="50%"><html:text property="userName" /></td>
				</tr>
				<tr>
					<td width="50%">Password</td>
					<td width="50%"><html:password property="password" /></td>
				</tr>
				<tr><td colspan="2"><html:submit value="Login" /></td></tr>
			</table>
        </html:form>
    </body>
</html:html>
