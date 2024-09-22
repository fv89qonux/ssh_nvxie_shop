package com.service;

import java.util.List;

import com.dao.TPinpaiDAO;

public class pinpaiService
{
    private TPinpaiDAO pinpaiDAO;
    
    
    public List findAllPinpai()
    {
    	try
		{
			Thread.sleep(0);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String sql="from TPinpai where del='no'";
		List cateLogList=pinpaiDAO.getHibernateTemplate().find(sql);
		return cateLogList;
    }

	public TPinpaiDAO getPinpaiDAO()
	{
		return pinpaiDAO;
	}

	public void setPinpaiDAO(TPinpaiDAO pinpaiDAO)
	{
		this.pinpaiDAO = pinpaiDAO;
	}
    
}
