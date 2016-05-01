package com.dao;

public interface LoginDao
{

    boolean authenticateUser(String userName,String password);
    
}
