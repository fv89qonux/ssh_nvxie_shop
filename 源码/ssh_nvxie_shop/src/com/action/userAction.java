package com.action;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class userAction extends ActionSupport
{
	private Integer id;
	private String loginname;
	private String loginpw;
	private String xingming;
	
	private String xingbie;
	private String nianling;
	private String address;
	private String dianhua;
	
	private String shenhe;
	private String type;
	private String typename;
	private String money;
	private String jifen;
	private String qq;
	private String shenfenzheng;
	private String touxiang;
	private String youxiang;
	private String chushengnianyue;
	private String addtime;
	private String beizhu;
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	
	public String userReg()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TUser where loginname=?";
		Object[] c={loginname.trim()};
		List userList=userDAO.getHibernateTemplate().find(sql,c);
		if(userList.size()>0)
		{
			this.setMessage("账号已被占用，请重新注册");
			this.setPath("qiantai/default.jsp");
		}
		else
		{
			TUser user=new TUser();
			
			//user.setId(id);
			user.setLoginname(loginname);
			user.setLoginpw(loginpw);
			user.setXingming(xingming);
			
			user.setXingbie(xingbie);
			user.setNianling(nianling);
			user.setAddress(address);
			user.setDianhua(dianhua);
			
			user.setShenhe("no");
			user.setType(type);
			user.setMoney("0");
			user.setJifen("0");
			user.setBeizhu("0");
			/*<option value="2">普通用户</option>

			/*if(type.equals("1"))
			{
				user.setTypename("老师");
			}*/
			if(type.equals("2"))
			{
				user.setTypename("普通用户");
			}

			
			userDAO.save(user);
			
			this.setMessage("注册成功，请登录");
			this.setPath("qiantai/default.jsp");
		}
		
		return "succeed";
	}


	public String userAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();

		String sql="from TUser where loginname=?";
		Object[] c={loginname.trim()};
		List userList=userDAO.getHibernateTemplate().find(sql,c);
		if(userList.size()>0)
		{
			this.setMessage("账号已被占用，请重新添加");
			//this.setPath("qiantai/default.jsp");
		}
		else
		{
			TUser user=new TUser();

			//user.setId(id);
			user.setLoginname(loginname);
			user.setLoginpw(loginpw);
			user.setXingming(xingming);

			user.setXingbie(xingbie);
			user.setNianling(nianling);
			user.setAddress(address);
			user.setDianhua(dianhua);

			user.setShenhe("yes");
			user.setType(type);
			user.setMoney("0");
			user.setJifen("0");
			user.setBeizhu("0");
			/*<option value="2">普通用户</option>
            <option value="3">Java</option>
            <option value="4">信息安全</option>
            <option value="5">大数据</option>
            <option value="6">HTML5</option>
            <option value="7">SAP</option>
            <option value="8">UI</option>
            <option value="9">移动互联网</option>*/
			if(type.equals("0"))
			{
				user.setTypename("管理员");
			}
			/*if(type.equals("1"))
			{
				user.setTypename("员工");
			}*/
			if(type.equals("2"))
			{
				user.setTypename("普通用户");
			}
			/*if(type.equals("3"))
			{
				user.setTypename("班干部");
			}*/
		/*	if(type.equals("4"))
			{
				user.setTypename("信息安全");
			}
			if(type.equals("5"))
			{
				user.setTypename("大数据");
			}
			if(type.equals("6"))
			{
				user.setTypename("HTML5");
			}
			if(type.equals("7"))
			{
				user.setTypename("SAP");
			}
			if(type.equals("8"))
			{
				user.setTypename("UI");
			}
			if(type.equals("9"))
			{
				user.setTypename("移动互联网");
			}*/

			userDAO.save(user);

			this.setMessage("添加成功");
			this.setPath("userMana.action");
		}

		return "succeed";
	}

	public String userMana()
	{
		//String sql="from TUser where del='no'";
		String sql="from TUser ";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	public String userManaType0()
	{
		//String sql="from TUser where del='no'";
		String sql="from TUser where type='0'";
		List userList=userDAO.getHibernateTemplate().find(sql);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	public String userManaType1()
	{
		//String sql="from TUser where del='no'";
		String sql="from TUser where type='1'";
		List userList=userDAO.getHibernateTemplate().find(sql);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}

	public String userManaType2()
	{
		//String sql="from TUser where del='no'";
		String sql="from TUser where type='2'";
		List userList=userDAO.getHibernateTemplate().find(sql);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}

	public String userManaPing()
	{
		//String sql="from TUser where del='no'";
		String sql="from TUser where type='"+type+"'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userXinxi()
	{
		
		TUser user=userDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	public String userGet()
	{
		
		TUser user=userDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	public String userSet()
	{
		TUser user=userDAO.findById(id);
		//user.setShenhe("yes");
		user.setLoginname(loginname);
		user.setLoginpw(loginpw);
		user.setXingming(xingming);
		user.setDianhua(dianhua);
		user.setAddress(address);
		user.setNianling(nianling);
		
		userDAO.attachDirty(user);
		
		Map session=ActionContext.getContext().getSession();
		session.put("user", user);
		//userDAO.delete(user);
		//this.setMessage("操作成功");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "操作成功");
		//this.setPath("qiantai/default.jsp");
		return "succeed";
	}
	
	public String userChongzhi()
	{
		TUser user=userDAO.findById(id);
		//user.setShenhe("yes");
		//user.setLoginname(loginname);
		//user.setLoginpw(loginpw);
		//user.setXingming(xingming);
		//user.setDianhua(dianhua);
		//user.setAddress(address);
		//user.setNianling(nianling);
		
		user.setMoney(String.valueOf(( Integer.parseInt(money) + Integer.parseInt(user.getMoney()) )  ));
		userDAO.attachDirty(user);
		
		Map session=ActionContext.getContext().getSession();
		session.put("user", user);
		
		this.setMessage("操作成功");
		this.setPath("qiantai/default.jsp");
		return "succeed";
	}
	
	public String userDel()
	{
		TUser user=userDAO.findById(id);
		//user.setShenhe("no");
		//userDAO.attachDirty(user);
		userDAO.delete(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	public String userShenhe()
	{
		TUser user=userDAO.findById(id);
		user.setShenhe("yes");
		userDAO.attachDirty(user);
		//userDAO.delete(user);
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	public String userJinyong()
	{
		TUser user=userDAO.findById(id);
		user.setShenhe("no");
		userDAO.attachDirty(user);
		//userDAO.delete(user);
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
	}

	public String userLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("user");
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

	public String getLoginname()
	{
		return loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public TUserDAO geTUserDAO()
	{
		return userDAO;
	}

	public void seTUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getDianhua()
	{
		return dianhua;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
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



	public String getMoney() {
		return money;
	}



	public void setMoney(String money) {
		this.money = money;
	}



	public String getJifen() {
		return jifen;
	}



	public void setJifen(String jifen) {
		this.jifen = jifen;
	}



	public String getQq() {
		return qq;
	}



	public void setQq(String qq) {
		this.qq = qq;
	}



	public String getShenfenzheng() {
		return shenfenzheng;
	}



	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}



	public String getTouxiang() {
		return touxiang;
	}



	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}



	public String getYouxiang() {
		return youxiang;
	}



	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}



	public String getChushengnianyue() {
		return chushengnianyue;
	}



	public void setChushengnianyue(String chushengnianyue) {
		this.chushengnianyue = chushengnianyue;
	}



	public String getAddtime() {
		return addtime;
	}



	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}



	public String getBeizhu() {
		return beizhu;
	}



	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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



	public TUserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	
}
