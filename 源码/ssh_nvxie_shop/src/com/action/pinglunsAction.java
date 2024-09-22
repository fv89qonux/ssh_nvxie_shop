package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TPinglunsDAO;
import com.model.TUser;
import com.model.TPingluns;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class pinglunsAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String shijian;
	private Integer mid;
	
	private Integer uid;
	
	
	private TPinglunsDAO pinglunsDAO;
	private String message;
	private String path;
	
	public String pinglunsAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TPingluns pingluns=new TPingluns();
		
		//pingluns.setId(id);
		pingluns.setNeirong(neirong);
		pingluns.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		pingluns.setMid(mid);
		
		pingluns.setUid(user.getId());
		
		pinglunsDAO.save(pingluns);
		
		this.setMessage("操作成功");
		this.setPath("myOrder.action");
		return "succeed";
	}
	
	public String pinglunsMana()
	{
		String sql="from TPingluns where mid="+mid;
		List pinglunsList=pinglunsDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinglunsList", pinglunsList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String pinglunsDel()
	{
		
		TPingluns pingluns=pinglunsDAO.findById(id);
		pinglunsDAO.delete(pingluns);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "评论信息删除完毕");
		return "msg";
	}

	
	







	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
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

	public TPinglunsDAO getPinglunsDAO() {
		return pinglunsDAO;
	}

	public void setPinglunsDAO(TPinglunsDAO pinglunsDAO) {
		this.pinglunsDAO = pinglunsDAO;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
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

}
