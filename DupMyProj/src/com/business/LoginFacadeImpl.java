package com.business;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.ast.tree.InLogicOperatorNode;

import com.action.User;
import com.dao.LoginDao;
import com.dao.LoginDaoImpl;

public class LoginFacadeImpl implements LoginFacade
{
   
    
    private LoginDao loginDao;
    
    @Override
    public boolean authenticateUser(String userName, String password)
    {
	loginDao=new LoginDaoImpl();
	return loginDao.authenticateUser(userName, password);
    }

}
