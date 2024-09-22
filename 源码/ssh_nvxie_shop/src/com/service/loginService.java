package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.dao.TLeibieDAO;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;


import com.dao.TUserDAO;

import com.model.TUser;

public class loginService
{
	
	private TUserDAO userDAO;
	private TLeibieDAO leibieDAO;

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public TLeibieDAO getLeibieDAO() {
		return leibieDAO;
	}

	public void setLeibieDAO(TLeibieDAO leibieDAO) {
		this.leibieDAO = leibieDAO;
	}

	public String login(String loginname, String loginpw, int userType)
	{
		
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		String sql="from TUser where loginname=? and loginpw=? and shenhe='yes'";
		Object[] con={loginname,loginpw};
		List userList=userDAO.getHibernateTemplate().find(sql,con);
		if(userList.size()==0)
		{
			 result="no";
		}
		else
		{
			 WebContext ctx = WebContextFactory.get(); 
			 HttpSession session=ctx.getSession(); 
			 TUser user=(TUser)userList.get(0);
			 session.setAttribute("userType", user.getType());
             session.setAttribute("user", user);
             System.out.println("userType"+user.getType());
             result="yes";
		}
		
		/*if(userType==1)//老师登陆
		{
			
		}
		if(userType==2)//学生登陆
		{
			
		}*/
		return result;
	}

	public String login2(String loginname,String loginpw,int userType,String rand)
	{

		String result="no";
		System.out.println(userType+"YYY");

		WebContext ctx = WebContextFactory.get();
		HttpSession session=ctx.getSession();

		String xitongyanzhengma=(String)session.getAttribute("rand");
		System.out.println(rand+"RAND");
		System.out.println(xitongyanzhengma+"YZM");
		if(xitongyanzhengma.equals(rand.trim())==false)
		{
			result="yanzhenmacuowu";
			return result;
		}

		//String result="no";
		String sql="from TUser where loginname=? and loginpw=? and shenhe='yes'";
		Object[] con={loginname,loginpw};
		List userList=userDAO.getHibernateTemplate().find(sql,con);
		if(userList.size()==0)
		{
			result="no";
		}
		else
		{
			//WebContext ctx = WebContextFactory.get();
			//HttpSession session=ctx.getSession();
			TUser user=(TUser)userList.get(0);
			session.setAttribute("userType", user.getType());
			session.setAttribute("user", user);
			System.out.println("userType"+user.getType());
			result="yes";
		}

		/*if(userType==1)//老师登陆
		{

		}
		if(userType==2)//学生登陆
		{

		}*/
		return result;
	}

    public String userPwEdit(String loginpw)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TUser user=(TUser)session.getAttribute("user");
		user.setLoginpw(loginpw);
		
		userDAO.getHibernateTemplate().update(user);
		session.setAttribute("user", user);
		
		return "yes";
    }
	
    public String jiance(String loginpw)
    {
    	System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="from TUser where loginpw='"+loginpw+"'";
		List list=userDAO.getHibernateTemplate().find(sql);
		if(list.size()>0)
		{
			return "no";
		}
		else
		{
			return "yes";
		}
    }

	public List leibieSelect()
	{
		String sql="from TLeibie where Del='no'";
		List leibieList=leibieDAO.getHibernateTemplate().find(sql);
		return leibieList;
	}
}
