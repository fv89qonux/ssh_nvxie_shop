package com.model;

/**
 * TPinglun1 entity. @author MyEclipse Persistence Tools
 */

public class TPinglun implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String neirong;
	private String shijian;
	private Integer xinwenId;
	
	private Integer uid;

	private TUser user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
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

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	
}