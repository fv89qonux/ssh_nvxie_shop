package com.model;

/**
 * TXinwen entity. @author MyEclipse Persistence Tools
 */

public class TXinwen implements java.io.Serializable
{

	// Fields

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
	private TLeibie leibie;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getLeibieId() {
		return leibieId;
	}

	public void setLeibieId(Integer leibieId) {
		this.leibieId = leibieId;
	}

	public TLeibie getLeibie() {
		return leibie;
	}

	public void setLeibie(TLeibie leibie) {
		this.leibie = leibie;
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

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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