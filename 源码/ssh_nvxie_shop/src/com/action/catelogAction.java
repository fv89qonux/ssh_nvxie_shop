package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;

public class catelogAction extends ActionSupport
{
	private int id;
	private String name;
	private String miaoshu;
	private String del;
	
	private String message;
	private String path;
	
	private TCatelogDAO catelogDAO;
	private TGoodsDAO goodsDAO;
	
	
	public String catelogMana()
	{
		String sql="from TCatelog where del='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String catelogAll()
	{
		String sql="from TCatelog where del='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	public String catelogAdd()
	{
		TCatelog catelog=new TCatelog();
		catelog.setName(name);
		catelog.setMiaoshu(miaoshu);
		catelog.setDel("no");
		catelogDAO.save(catelog);
		this.setMessage("操作成功");
		this.setPath("catelogMana.action");
		return "succeed";
	}
	
	public String catelogDel()
	{
		String sql="from TGoods where goodsDel='no' and goodsCatelogId="+id;
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsList.size()>0)
		{
			this.setMessage("请先删除此类别下的商品");
			this.setPath("catelogMana.action");
		}
		else
		{
			TCatelog catelog=catelogDAO.findById(id);
			catelog.setDel("yes");
			catelogDAO.attachDirty(catelog);
			this.setMessage("操作成功");
			this.setPath("catelogMana.action");
		}
		return "succeed";
	}
	
	
	public String catelogEditPre()
	{
			TCatelog catelog=catelogDAO.findById(id);
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("catelog", catelog);
			return ActionSupport.SUCCESS;
	}
	
	public String catelogEdit()
	{
		TCatelog catelog=catelogDAO.findById(id);
		catelog.setName(name);
		catelog.setMiaoshu(miaoshu);
		catelog.setDel("no");
		catelogDAO.attachDirty(catelog);
		this.setMessage("操作成功");
		this.setPath("catelogMana.action");
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



	public TCatelogDAO getCatelogDAO() {
		return catelogDAO;
	}



	public void setCatelogDAO(TCatelogDAO catelogDAO) {
		this.catelogDAO = catelogDAO;
	}



	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	


	

}
