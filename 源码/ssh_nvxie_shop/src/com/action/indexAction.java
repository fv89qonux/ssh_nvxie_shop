package com.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TOrderItemDAO;
import com.dao.TUserGoodsDAO;
import com.model.TGoods;
import com.model.TUser;
import com.model.TUserGoods;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TGoodsDAO goodsDAO;
	private TUserGoodsDAO tUserGoodsDAO;
	private TOrderItemDAO orderItemDAO;
	
	
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='yes' order by goodsId desc";
		List goodsYesTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsYesTejiaList.size()>5)
		{
			goodsYesTejiaList=goodsYesTejiaList.subList(0, 5);
		}
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		
		sql="from TGoods where goodsDel='no' and goodsIsnottejia='no' order by goodsId desc";
		List goodsNoTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsNoTejiaList.size()>5)
		{
			goodsNoTejiaList=goodsNoTejiaList.subList(0, 5);
		}
		request.put("goodsNoTejiaList", goodsNoTejiaList);
		
		
		//paihangbang
		List goodsList=new ArrayList();
		sql="select sum(goodsQuantity),goodsId from TOrderItem group by goodsId order by sum(goodsQuantity) desc";
		List list=orderItemDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<list.size();i++)
		{
			Object[] b=(Object[])list.get(i);
			int goodsId=Integer.parseInt(b[1].toString());
			System.out.println(goodsId+"&&");
			TGoods goods=goodsDAO.findById(goodsId);
			goodsList.add(goods);
		}
		if(goodsList.size()>5)
		{
			goodsList=goodsList.subList(0, 5);
		}
		request.put("goodsList", goodsList);
		//paihangbang
		
		
		Map session= ServletActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		if(user!=null){
			int uid = user.getId();
			sql="select ug.goods_id,count(id) from TUserGoods ug where ug.user_id=? group by ug.goods_id order by count(id) desc";
			
			List goodslist=tUserGoodsDAO.getHibernateTemplate().find(sql,uid);
			List goodsSendList=new ArrayList();
			for(int i=0;i<goodslist.size();i++)
			{
				Object[] b=(Object[])goodslist.get(i);
				int goodsId=Integer.parseInt(b[0].toString());
				TGoods goods=goodsDAO.findById(goodsId);
				goodsSendList.add(goods);
			}
			if(goodsSendList.size()>5)
				goodsSendList=goodsSendList.subList(0, 5);
			if(goodsSendList.size()==0)
				goodsSendList=null;

			request.put("goodsSendList", goodsSendList);
		}
		
		return ActionSupport.SUCCESS;
	}
	

	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}


	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}


	public TUserGoodsDAO gettUserGoodsDAO() {
		return tUserGoodsDAO;
	}


	public void settUserGoodsDAO(TUserGoodsDAO tUserGoodsDAO) {
		this.tUserGoodsDAO = tUserGoodsDAO;
	}


	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}
	
	
}
