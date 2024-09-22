package com.action;

import com.dao.TLeibieDAO;
import com.dao.TPinglunDAO;
import com.dao.TTupianDAO;
import com.dao.TXinwenDAO;
import com.model.TUser;
import com.model.TXinwen;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class xinwenAction extends ActionSupport
{
	private Integer id;
	private Integer leibieId;
	private String biaoti;
	private String neirong;
	private String fujian;
	
	private String shijian;
	private String uid;
	private String fenlei;
	private String shenhe;
	private String type;
	private String typename;
	private String beizhu;
	private TXinwenDAO xinwenDAO;
	private TTupianDAO tupianDAO;
	private TLeibieDAO leibieDAO;
	private TPinglunDAO pinglunDAO;
	
	
	public String xinwenAdd()
	{
		TXinwen xinwen=new TXinwen();
		
		//xinwen.setId(id);
		xinwen.setLeibieId(leibieId);
		xinwen.setBiaoti(biaoti);
		xinwen.setNeirong(neirong);
		xinwen.setFujian((fujian.equals("")?"/img/zanwu.jpg":fujian));
		xinwen.setShijian(shijian);
		xinwen.setUid(uid);
		xinwen.setFenlei(fenlei);
		xinwen.setShenhe("否");
		xinwen.setType(type);
		if(type.endsWith("0"))
		{
			typename="文字";
		}
		if(type.endsWith("1"))
		{
			typename="图片";
		}
		if(type.endsWith("2"))
		{
			typename="视频";
		}
		if(type.endsWith("3"))
		{
			typename="音乐";
		}
		if(type.endsWith("4"))
		{
			typename="附件";
		}
		xinwen.setTypename(typename);
		xinwen.setBeizhu(beizhu);
		xinwenDAO.save(xinwen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String xinwenMana()
	{
		String sql = "from TXinwen";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
	
	public String xinwenManaQian()
	{
		String sql = "from TXinwen where shenhe='是'";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
	
	public String xinwenManaMy()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String uid = user.getId()+"";
		String sql = "from TXinwen where uid='" + uid + "'";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request2=(Map)ServletActionContext.getContext().get("request");
		request2.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}

	public String xinwenManaHei()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String uid = user.getId()+"";
		String sql = "from TXinwen where beizhu='" + "是" + "'";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request2=(Map)ServletActionContext.getContext().get("request");
		request2.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}

	public String xinwenDel()
	{
		TXinwen xinwen=xinwenDAO.findById(id);
		xinwenDAO.delete(xinwen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息操作成功");
		return "msg";
	}
	
	public String xinwenShenhe()
	{
		TXinwen xinwen=xinwenDAO.findById(id);
		xinwen.setShenhe("是");
		xinwenDAO.attachDirty(xinwen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息操作成功");
		return "msg";
	}
	
	public String xinwenByLeibie()
	{
		String sql = "from TXinwen where shenhe='是' and leibieId="+leibieId  ;
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
/*	String s2="from TZhuti where title like '%"+title+ "%' and shifouding='是'";*/
	public String xinwenBySearch()
	{
		String sql = "from TXinwen where biaoti like '%"+biaoti+ "%' and shenhe='是' " ;
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xinwenList.size();i++)
		{
			TXinwen xinwen=(TXinwen)xinwenList.get(i);
			xinwen.setLeibie(leibieDAO.findById(xinwen.getLeibieId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
	
	public String xinwenDetailQian()
	{
		TXinwen xinwen=xinwenDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TTupian where xinwenId="+id;
		List tupianList =tupianDAO.getHibernateTemplate().find(sql);
		
		request.put("xinwen", xinwen);
		request.put("tupianList", tupianList);
		
		sql="from TPinglun where xinwenId="+id;
		List pinglunList =pinglunDAO.getHibernateTemplate().find(sql);
		request.put("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getBiaoti()
	{
		return biaoti;
	}

	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public TPinglunDAO getPinglunDAO() {
		return pinglunDAO;
	}

	public void setPinglunDAO(TPinglunDAO pinglunDAO) {
		this.pinglunDAO = pinglunDAO;
	}

	public Integer getLeibieId() {
		return leibieId;
	}

	public void setLeibieId(Integer leibieId) {
		this.leibieId = leibieId;
	}

	public TLeibieDAO getLeibieDAO() {
		return leibieDAO;
	}

	public void setLeibieDAO(TLeibieDAO leibieDAO) {
		this.leibieDAO = leibieDAO;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public TXinwenDAO getXinwenDAO()
	{
		return xinwenDAO;
	}

	public void setXinwenDAO(TXinwenDAO xinwenDAO)
	{
		this.xinwenDAO = xinwenDAO;
	}

	public TTupianDAO getTupianDAO() {
		return tupianDAO;
	}

	public void setTupianDAO(TTupianDAO tupianDAO) {
		this.tupianDAO = tupianDAO;
	}

	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}

	public String getShenhe() {
		return shenhe;
	}

	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	
}
