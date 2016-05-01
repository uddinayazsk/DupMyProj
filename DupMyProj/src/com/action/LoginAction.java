package com.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.business.LoginFacade;
import com.business.LoginFacadeImpl;
import com.form.LoginForm;

public class LoginAction extends Action{
	
      private LoginFacade loginFacade;
    
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	    HttpSession session = request.getSession();
		String token = generateToken(request);
		if (token != null) {
			
			session.setAttribute(Globals.TRANSACTION_TOKEN_KEY, token);
		}
		saveToken(request);

		LoginForm loginForm = (LoginForm)form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		System.out.println("---username = "+userName);
		System.out.println("---password = "+password);
		boolean flag = false;
		try{
		    loginFacade=new LoginFacadeImpl();
		    flag=loginFacade.authenticateUser(userName, password);
			
		}catch(Exception e){
			System.out.println("Exception in Action = "+e.getMessage());
		}
        if(flag){
    		return mapping.findForward("success");        	
        } else {
        	return mapping.findForward("failure");        	
        }


	}

}
