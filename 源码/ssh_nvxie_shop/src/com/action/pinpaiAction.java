package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TPinpaiDAO;
import com.dao.TGoodsDAO;
import com.model.TPinpai;
import com.opensymphony.xwork2.ActionSupport;

public class pinpaiAction extends ActionSupport
{
	private int id;
	private String name;
	private String miaoshu;
	private String del;
	
	private String message;
	private String path;
	
	private TPinpaiDAO pinpaiDAO;
	private TGoodsDAO goodsDAO;
	
	
	public String pinpaiMana()
	{
		String sql="from TPinpai where del='no'";
		List pinpaiList=pinpaiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinpaiList", pinpaiList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String pinpaiAll()
	{
		String sql="from TPinpai where del='no'";
		List pinpaiList=pinpaiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinpaiList", pinpaiList);
		return ActionSupport.SUCCESS;
	}
	
	public String pinpaiAdd()
	{
		TPinpai pinpai=new TPinpai();
		pinpai.setName(name);
		pinpai.setMiaoshu(miaoshu);
		pinpai.setDel("no");
		pinpaiDAO.save(pinpai);
		this.setMessage("操作成功");
		this.setPath("pinpaiMana.action");
		return "succeed";
	}
	
	public String pinpaiDel()
	{
		String sql="from TGoods where goodsDel='no' and goodsPinpaiId="+id;
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsList.size()>0)
		{
			this.setMessage("请先删除此类别下的商品");
			this.setPath("pinpaiMana.action");
		}
		else
		{
			TPinpai pinpai=pinpaiDAO.findById(id);
			pinpai.setDel("yes");
			pinpaiDAO.attachDirty(pinpai);
			this.setMessage("操作成功");
			this.setPath("pinpaiMana.action");
		}
		return "succeed";
	}
	
	
	public String pinpaiEditPre()
	{
			TPinpai pinpai=pinpaiDAO.findById(id);
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("pinpai", pinpai);
			return ActionSupport.SUCCESS;
	}
	
	public String pinpaiEdit()
	{
		TPinpai pinpai=pinpaiDAO.findById(id);
		pinpai.setName(name);
		pinpai.setMiaoshu(miaoshu);
		pinpai.setDel("no");
		pinpaiDAO.attachDirty(pinpai);
		this.setMessage("操作成功");
		this.setPath("pinpaiMana.action");
		return "succeed";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMiaoshu() {
		return miaoshu;
	}



	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}



	public String getDel() {
		return del;
	}



	public void setDel(String del) {
		this.del = del;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public TPinpaiDAO getPinpaiDAO() {
		return pinpaiDAO;
	}



	public void setPinpaiDAO(TPinpaiDAO pinpaiDAO) {
		this.pinpaiDAO = pinpaiDAO;
	}



	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	

	

}
