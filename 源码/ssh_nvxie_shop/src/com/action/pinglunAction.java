package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TPinglunDAO;
import com.model.TUser;
import com.model.TPinglun;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class pinglunAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String shijian;
	private Integer xinwenId;
	
	private Integer uid;
	
	
	private TPinglunDAO pinglunDAO;
	
	
	public String pinglunAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TPinglun pinglun=new TPinglun();
		
		//pinglun.setId(id);
		pinglun.setNeirong(neirong);
		pinglun.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		pinglun.setXinwenId(xinwenId);
		
		pinglun.setUid(user.getId());
		
		pinglunDAO.save(pinglun);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "发布评论完毕");
		return "msg";
	}
	
	public String pinglunMana()
	{
		String sql="from TPinglun where xinwenId="+xinwenId;
		List pinglunList=pinglunDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String pinglunDel()
	{
		
		TPinglun pinglun=pinglunDAO.findById(id);
		pinglunDAO.delete(pinglun);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "评论信息删除完毕");
		return "msg";
	}

	
	


	public Integer getXinwenId() {
		return xinwenId;
	}

	public void setXinwenId(Integer xinwenId) {
		this.xinwenId = xinwenId;
	}




	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public TPinglunDAO getPinglunDAO()
	{
		return pinglunDAO;
	}

	public void setPinglunDAO(TPinglunDAO pinglunDAO)
	{
		this.pinglunDAO = pinglunDAO;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

}
