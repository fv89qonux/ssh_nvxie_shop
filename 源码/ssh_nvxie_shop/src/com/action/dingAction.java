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
import com.dao.TDingDAO;
import com.dao.TUserGoodsDAO;
import com.model.TPinpai;
import com.model.TCatelog;
import com.model.TDing;
import com.model.TUser;
import com.model.TUserGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class dingAction extends ActionSupport
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
	private String goodsYanse;
	private int goodsShichangjia;
	private int goodsTejia;
	
	private int catelogId;
	private int pinpaiId;
	private int goodsKucun;
	
	private String message;
	private String path;
	
	private TDingDAO dingDAO;
	private TUserGoodsDAO userGoodsDAO;
	private TCatelogDAO catelogDAO;
	private TPinpaiDAO pinpaiDAO;
	private int rukushuliang;
	private TPinglunsDAO pinglunsDAO;
	private int uid;//ÓÃ»§id
	private String shenhe;
	
	public String dingNoTejiaAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TDing ding=new TDing();
		ding.setUid(user.getId());
		       
		ding.setGoodsCatelogId(goodsCatelogId);
		ding.setGoodsPinpaiId(goodsPinpaiId);
		ding.setGoodsName(goodsName);
		ding.setChubanshe(chubanshe);
		ding.setZuozhe(zuozhe);
		ding.setBianhao(bianhao);
		ding.setGoodsMiaoshu(goodsMiaoshu);
		ding.setGoodsPic(fujian);
		ding.setGoodsShichangjia(goodsShichangjia);
		if(goodsTejia==0)//
		{
			ding.setGoodsTejia(goodsShichangjia);//
			ding.setGoodsIsnottejia("no");
		}
		else
		{
			ding.setGoodsTejia(goodsTejia);
			ding.setGoodsIsnottejia("yes");
		}
		ding.setGoodsYanse(goodsYanse);
		//ding.setShenhe("·ñ");
		ding.setGoodsKucun(goodsKucun);
		ding.setGoodsDel("no");
		
		dingDAO.save(ding);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("dingManaNoTejiaMyQian.action");
		return "succeed";
		
	}
	

	public String dingNoTejiaEdit()
	{
		
	 
		//TDing ding=new TDing();
	 
		TDing ding=dingDAO.findById(goodsId);
		ding.setGoodsCatelogId(goodsCatelogId);
		ding.setGoodsPinpaiId(goodsPinpaiId);
		ding.setGoodsName(goodsName);
		ding.setChubanshe(chubanshe);
		ding.setZuozhe(zuozhe);
		ding.setBianhao(bianhao);
		ding.setGoodsMiaoshu(goodsMiaoshu);
		ding.setGoodsPic(fujian);
		ding.setGoodsShichangjia(goodsShichangjia);
		if(goodsTejia==0)//
		{
			ding.setGoodsTejia(goodsShichangjia);//
			ding.setGoodsIsnottejia("no");
		}
		else
		{
			ding.setGoodsTejia(goodsTejia);
			ding.setGoodsIsnottejia("yes");
		}
		ding.setGoodsYanse(goodsYanse);
		ding.setGoodsKucun(goodsKucun);
		ding.setGoodsDel("no");
		
		dingDAO.attachDirty(ding);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
		
	}

	public String dingNoTejiaDel()
	{
		TDing ding=dingDAO.findById(goodsId);
		//ding.setGoodsDel("yes");
		//dingDAO.attachDirty(ding);
		dingDAO.delete(ding);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("dingManaNoTejia.action");
		return "succeed";
	}
	
	public String dingNoTejiaDelQian()
	{
		TDing ding=dingDAO.findById(goodsId);
		//ding.setGoodsDel("yes");
		//dingDAO.attachDirty(ding);
		dingDAO.delete(ding);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("dingManaNoTejiaMyQian.action");
		return "succeed";
	}
	
	public String dingManaNoTejia()
	{
		String sql="from TDing where goodsDel='no' order by goodsIsnottejia";
		List dingList=dingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<dingList.size();i++)
		{
			TDing ding=(TDing)dingList.get(i);
			System.out.println(ding.getGoodsCatelogId());
			//ding.setGoodsCatelogName(catelogDAO.findById(ding.getGoodsCatelogId()).getName());
			//ding.setGoodsPinpaiName(pinpaiDAO.findById(ding.getGoodsPinpaiId()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingList", dingList);
		return ActionSupport.SUCCESS;
	}
	
	public String dingManaNoTejiaMy()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String sql="from TDing where uid=" +user.getId()+"  and goodsDel='no'  order by goodsIsnottejia";
		List dingList=dingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<dingList.size();i++)
		{
			TDing ding=(TDing)dingList.get(i);
			System.out.println(ding.getGoodsCatelogId());
			//ding.setGoodsCatelogName(catelogDAO.findById(ding.getGoodsCatelogId()).getName());
			//ding.setGoodsPinpaiName(pinpaiDAO.findById(ding.getGoodsPinpaiId()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingList", dingList);
		return ActionSupport.SUCCESS;
	}
	
	public String dingShezhiTejia()
	{
		TDing ding=dingDAO.findById(goodsId);
		ding.setGoodsIsnottejia("yes");
		ding.setGoodsTejia(goodsTejia);
		dingDAO.attachDirty(ding);
		return ActionSupport.SUCCESS;
	}
	
	
	public String dingKucun()
	{
		String sql="from TDing where goodsDel='no' order by goodsIsnottejia";
		List dingList=dingDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingList", dingList);
		return ActionSupport.SUCCESS;
	}
	
	public String dingRuku()
	{
		TDing ding=dingDAO.findById(goodsId);
		ding.setGoodsKucun(ding.getGoodsKucun()+rukushuliang);
		ding.setGoodsTejia(goodsTejia);
		dingDAO.attachDirty(ding);
		return ActionSupport.SUCCESS;
	}
	
	/*public String dingYesTejiaAdd()
	{
		TDing ding=new TDing();
		ding.setGoodsCatelogId(goodsCatelogId);
		ding.setGoodsName(goodsName);
		ding.setGoodsMiaoshu(goodsMiaoshu);
		ding.setGoodsPic(fujian);
		ding.setGoodsYanse(goodsYanse);
		ding.setGoodsShichangjia(goodsShichangjia);
		ding.setGoodsTejia(goodsTejia);
		ding.setGoodsIsnottejia("yes");
		ding.setGoodsDel("no");
		dingDAO.save(ding);
		this.setMessage("ï¿½ï¿½ï¿½ï¿½ï¿½É¹ï¿½");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
		
	}
	
	public String dingYesTejiaDel()
	{
		TDing ding=dingDAO.findById(goodsId);
		ding.setGoodsDel("yes");
		dingDAO.attachDirty(ding);
		this.setMessage("ï¿½ï¿½ï¿½ï¿½ï¿½É¹ï¿½");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
	}
	
	
	public String dingManaYesTejia()
	{
		String sql="from TDing where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List dingList=dingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<dingList.size();i++)
		{
			TDing ding=(TDing)dingList.get(i);
			ding.setGoodsCatelogName(catelogDAO.findById(ding.getGoodsCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingList", dingList);
		return ActionSupport.SUCCESS;
	}*/
	
	public String dingDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TDing ding=dingDAO.findById(goodsId);
		request.put("ding", ding);
		return ActionSupport.SUCCESS;
	}
	
	public String dingNoTejiaEditPre()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TDing ding=dingDAO.findById(goodsId);
		request.put("ding", ding);
		return ActionSupport.SUCCESS;
	}
	
	public String dingDetail()
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
		
		TDing ding=dingDAO.findById(goodsId);
		ding.setGoodsPinpaiName(pinpaiDAO.findById(ding.getGoodsPinpaiId()).getName());
		request.put("ding", ding);
		
		String sql="from TPingluns where mid="+goodsId;
		List pinglunsList =pinglunsDAO.getHibernateTemplate().find(sql);
		request.put("pinglunsList", pinglunsList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String dingAllYesTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TDing where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsYesTejiaList=dingDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String dingAllNoTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TDing where goodsDel='no' and goodsIsnottejia='no' order by goodsCatelogId";
		List goodsYesTejiaList=dingDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String dingByCatelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TDing where goodsDel='no' and goodsCatelogId=? order by goodsCatelogId";
		Object[] con={catelogId};
		List goodsByCatelogList=dingDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsByCatelogList", goodsByCatelogList);
		
		System.out.println(goodsByCatelogList.size()+"^^^"+goodsCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	public String dingByPinpai()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TDing where goodsDel='no' and goodsPinpaiId=? order by goodsPinpaiId";
		Object[] con={pinpaiId};
		List goodsByCatelogList=dingDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsByCatelogList", goodsByCatelogList);
		
		System.out.println(goodsByCatelogList.size()+"^^^"+goodsCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	public String dingSearch()
	{
        Map<String, List<TDing>> request=(Map)ServletActionContext.getContext().get("request");
		String sql="";
		String sql2="";
		if(catelogId==0)
		{
			sql="from TDing where goodsDel='no' and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
			sql2="select goodsId from TDing where goodsDel='no' and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}
		else
		{
			sql="from TDing where goodsDel='no' and goodsCatelogId="+catelogId+" and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
			sql2="select goodsId from TDing where goodsDel='no' and goodsCatelogId="+catelogId+" and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}
		
		List dingList=dingDAO.getHibernateTemplate().find(sql);
		List goodsIdList=dingDAO.getHibernateTemplate().find(sql2);
		
		
		//
		Map session= ServletActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		if(user!=null){
			String ids = StringUtils.join(goodsIdList.toArray(),",");
			System.out.print(ids);
			String sql3 = "select * from (select goods_id from t_user_goods where user_id="+user.getId()+" and goods_id in ("+ids+") group by goods_id order by count(id) desc) temp left join t_goods g on temp.goods_id=g.goods_id";
			Session session1 = dingDAO.getSessionFactory().openSession();
			
			List<TDing> userGoodsList= session1.createSQLQuery(sql3).addEntity(TDing.class).list();
			if(userGoodsList.size()==0)userGoodsList=null;
			request.put("userGoodsList",userGoodsList);
			session1.close();
		}
		
		request.put("dingList",dingList);
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



	public TDingDAO getDingDAO() {
		return dingDAO;
	}


	public void setDingDAO(TDingDAO dingDAO) {
		this.dingDAO = dingDAO;
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
	
	
}
