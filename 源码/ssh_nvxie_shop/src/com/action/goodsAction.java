package com.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.TPinglunsDAO;
//Pinpai
import com.dao.TPinpaiDAO;
import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TUserGoodsDAO;
import com.model.TPinpai;
import com.model.TCatelog;
import com.model.TGoods;
import com.model.TUser;
import com.model.TUserGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private int goodsId;
	private int goodsCatelogId;
	private int goodsPinpaiId;


	private String goodsName;
	private String chubanshe;
	private String zuozhe;
	private String bianhao;
	private String goodsMiaoshu;
	private String fujian;
	private String fujian2;
	private String goodsYanse;
	private int goodsShichangjia;
	private int goodsTejia;
	
	private int catelogId;
	private int pinpaiId;
	private int goodsKucun;
	
	private String message;
	private String path;
	
	private TGoodsDAO goodsDAO;
	private TUserGoodsDAO userGoodsDAO;
	private TCatelogDAO catelogDAO;
	private TPinpaiDAO pinpaiDAO;
	private int rukushuliang;
	private TPinglunsDAO pinglunsDAO;
	private int uid;
	private String shenhe;
	
	public String goodsNoTejiaAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TGoods goods=new TGoods();
		goods.setUid(user.getId());
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsPinpaiId(goodsPinpaiId);
		goods.setGoodsName(goodsName);
		goods.setChubanshe(chubanshe);
		goods.setZuozhe(zuozhe);
		goods.setBianhao(bianhao);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		if(goodsTejia==0)//
		{
			goods.setGoodsTejia(goodsShichangjia);//
			goods.setGoodsIsnottejia("no");
		}
		else
		{
			goods.setGoodsTejia(goodsTejia);
			goods.setGoodsIsnottejia("yes");
		}
		//goods.setGoodsYanse(goodsYanse);
		goods.setGoodsYanse(fujian2);
		//goods.setShenhe("否");
		goods.setGoodsKucun(goodsKucun);
		goods.setGoodsDel("no");
		
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
		
	}
	

	public String goodsNoTejiaEdit()
	{

		//TGoods goods=new TGoods();
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsPinpaiId(goodsPinpaiId);
		goods.setGoodsName(goodsName);
		goods.setChubanshe(chubanshe);
		goods.setZuozhe(zuozhe);
		goods.setBianhao(bianhao);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		//goods.setGoodsShichangjia(goodsShichangjia);
		if (goods.getGoodsIsnottejia().endsWith("yes"))
		{
			//特价商品，修改特价，市场价不变
			goods.setGoodsTejia(goodsShichangjia);
		}
		else
		{
			//市场价商品，修改市场价，特价为0
			goods.setGoodsShichangjia(goodsShichangjia);
			goods.setGoodsTejia(0);
		}
		/*if(goodsTejia==0)//
		{
			goods.setGoodsTejia(goodsTejia);//
			goods.setGoodsIsnottejia("no");
		}
		else
		{
			goods.setGoodsTejia(goodsTejia);
			goods.setGoodsIsnottejia("no");
		}*/
		//goods.setGoodsYanse(goodsYanse);
		goods.setGoodsYanse(fujian2);
		goods.setGoodsKucun(goodsKucun);
		goods.setGoodsDel("no");

		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
		
	}

	public String goodsNoTejiaDel()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		//goods.setGoodsDel("yes");
		//goodsDAO.attachDirty(goods);
		goodsDAO.delete(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
	}
	
	public String goodsManaNoTejia()
	{
		String sql="from TGoods where goodsDel='no' order by goodsIsnottejia";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			System.out.println(goods.getGoodsCatelogId());
			goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getName());
			goods.setGoodsPinpaiName(pinpaiDAO.findById(goods.getGoodsPinpaiId()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsManaNoTejiaMy()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String sql="from TGoods where uid=" +user.getId()+"  and goodsDel='no'  order by goodsIsnottejia";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			System.out.println(goods.getGoodsCatelogId());
			goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getName());
			goods.setGoodsPinpaiName(pinpaiDAO.findById(goods.getGoodsPinpaiId()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsShezhiTejia()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsIsnottejia("yes");
		goods.setGoodsTejia(goodsTejia);
		goodsDAO.attachDirty(goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsKucun()
	{
		String sql="from TGoods where goodsDel='no' order by goodsIsnottejia";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsRuku()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsKucun(goods.getGoodsKucun()+rukushuliang);
		goods.setGoodsTejia(goodsTejia);
		goodsDAO.attachDirty(goods);
		return ActionSupport.SUCCESS;
	}
	
	/*public String goodsYesTejiaAdd()
	{
		TGoods goods=new TGoods();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsTejia);
		goods.setGoodsIsnottejia("yes");
		goods.setGoodsDel("no");
		goodsDAO.save(goods);
		this.setMessage("锟斤拷锟斤拷锟缴癸拷");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
		
	}
	
	public String goodsYesTejiaDel()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("锟斤拷锟斤拷锟缴癸拷");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
	}
	
	
	public String goodsManaYesTejia()
	{
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}*/
	
	public String goodsDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsNoTejiaEditPre()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDetail()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		if(user!=null){
			int goods_id = goodsId;
			int uid = user.getId();
			TUserGoods tUserGoods = new TUserGoods();
			tUserGoods.setUser_id(uid);
			tUserGoods.setGoods_id(goods_id);
			tUserGoods.toString();
			userGoodsDAO.save(tUserGoods);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsPinpaiName(pinpaiDAO.findById(goods.getGoodsPinpaiId()).getName());
		request.put("goods", goods);
		
		String sql="from TPingluns where mid="+goodsId;
		List pinglunsList =pinglunsDAO.getHibernateTemplate().find(sql);
		request.put("pinglunsList", pinglunsList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsAllYesTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsYesTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsAllNoTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottejia='no' order by goodsCatelogId";
		List goodsYesTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsByCatelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' and goodsCatelogId=? order by goodsCatelogId";
		Object[] con={catelogId};
		List goodsByCatelogList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsByCatelogList", goodsByCatelogList);
		
		System.out.println(goodsByCatelogList.size()+"^^^"+goodsCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsByPinpai()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' and goodsPinpaiId=? order by goodsPinpaiId";
		Object[] con={pinpaiId};
		List goodsByCatelogList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsByCatelogList", goodsByCatelogList);
		
		System.out.println(goodsByCatelogList.size()+"^^^"+goodsCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	public String goodSearch()
	{
        Map<String, List<TGoods>> request=(Map)ServletActionContext.getContext().get("request");
		String sql="";
		String sql2="";
		if(catelogId==0)
		{
			sql="from TGoods where goodsDel='no' and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
			sql2="select goodsId from TGoods where goodsDel='no' and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}
		else
		{
			sql="from TGoods where goodsDel='no' and goodsCatelogId="+catelogId+" and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
			sql2="select goodsId from TGoods where goodsDel='no' and goodsCatelogId="+catelogId+" and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}
		
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		List goodsIdList=goodsDAO.getHibernateTemplate().find(sql2);
		
		
		//
		Map session= ServletActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		if(user!=null){
			String ids = StringUtils.join(goodsIdList.toArray(),",");
			System.out.print(ids);
			String sql3 = "select * from (select goods_id from t_user_goods where user_id="+user.getId()+" and goods_id in ("+ids+") group by goods_id order by count(id) desc) temp left join t_goods g on temp.goods_id=g.goods_id";
			Session session1 = goodsDAO.getSessionFactory().openSession();
			
			List<TGoods> userGoodsList= session1.createSQLQuery(sql3).addEntity(TGoods.class).list();
			if(userGoodsList.size()==0)userGoodsList=null;
			request.put("userGoodsList",userGoodsList);
			session1.close();
		}
		
		request.put("goodsList",goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public int getCatelogId()
	{
		return catelogId;
	}

	public void setCatelogId(int catelogId)
	{
		this.catelogId = catelogId;
	}

	public int getGoodsCatelogId()
	{
		return goodsCatelogId;
	}
	public void setGoodsCatelogId(int goodsCatelogId)
	{
		this.goodsCatelogId = goodsCatelogId;
	}
	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}
	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	
	public int getRukushuliang()
	{
		return rukushuliang;
	}

	public TUserGoodsDAO getUserGoodsDAO() {
		return userGoodsDAO;
	}

	public void setUserGoodsDAO(TUserGoodsDAO userGoodsDAO) {
		this.userGoodsDAO = userGoodsDAO;
	}

	public void setRukushuliang(int rukushuliang)
	{
		this.rukushuliang = rukushuliang;
	}

	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public String getGoodsMiaoshu()
	{
		return goodsMiaoshu;
	}
	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	
	public String getFujian()
	{
		return fujian;
	}

	public int getGoodsKucun()
	{
		return goodsKucun;
	}

	public void setGoodsKucun(int goodsKucun)
	{
		this.goodsKucun = goodsKucun;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
	
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public int getGoodsShichangjia()
	{
		return goodsShichangjia;
	}
	public void setGoodsShichangjia(int goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}
	public int getGoodsTejia()
	{
		return goodsTejia;
	}
	public void setGoodsTejia(int goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}
	public String getGoodsYanse()
	{
		return goodsYanse;
	}
	public String getChubanshe() {
		return chubanshe;
	}


	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}


	public String getZuozhe() {
		return zuozhe;
	}


	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}


	public String getBianhao() {
		return bianhao;
	}


	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}


	public void setGoodsYanse(String goodsYanse)
	{
		this.goodsYanse = goodsYanse;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public int getPinpaiId() {
		return pinpaiId;
	}

	public void setPinpaiId(int pinpaiId) {
		this.pinpaiId = pinpaiId;
	}

	public TPinpaiDAO getPinpaiDAO() {
		return pinpaiDAO;
	}

	public void setPinpaiDAO(TPinpaiDAO pinpaiDAO) {
		this.pinpaiDAO = pinpaiDAO;
	}
	
	public int getGoodsPinpaiId() {
		return goodsPinpaiId;
	}



	public void setGoodsPinpaiId(int goodsPinpaiId) {
		this.goodsPinpaiId = goodsPinpaiId;
	}



	public TPinglunsDAO getPinglunsDAO() {
		return pinglunsDAO;
	}



	public void setPinglunsDAO(TPinglunsDAO pinglunsDAO) {
		this.pinglunsDAO = pinglunsDAO;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getShenhe() {
		return shenhe;
	}


	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	public String getFujian2() {
		return fujian2;
	}

	public void setFujian2(String fujian2) {
		this.fujian2 = fujian2;
	}
}
