package com.model;

/**
 * TOrder generated by MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable
{

	// Fields

	private Integer orderId;

	private String orderBianhao;

	private String orderDate;

	private String orderZhuangtai;
	
	private String odderSonghuodizhi;

	private String odderFukuangfangshi;
	

	private Integer orderUserId;
	private Integer fuid;
	
	private int orderJine=0;
	private String shifoufukuan;
	private String beizhu;
	// Constructors

	/** default constructor */
	public TOrder()
	{
	}

	/** full constructor */
	public TOrder(String orderBianhao, String orderDate, String orderZhuangtai,
			Integer orderUserId)
	{
		this.orderBianhao = orderBianhao;
		this.orderDate = orderDate;
		this.orderZhuangtai = orderZhuangtai;
		this.orderUserId = orderUserId;
	}

	// Property accessors

	public Integer getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(Integer orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderBianhao()
	{
		return this.orderBianhao;
	}

	public int getOrderJine()
	{
		return orderJine;
	}

	public void setOrderJine(int orderJine)
	{
		this.orderJine = orderJine;
	}
	

	public String getOdderFukuangfangshi()
	{
		return odderFukuangfangshi;
	}

	public void setOdderFukuangfangshi(String odderFukuangfangshi)
	{
		this.odderFukuangfangshi = odderFukuangfangshi;
	}

	public String getOdderSonghuodizhi()
	{
		return odderSonghuodizhi;
	}

	public void setOdderSonghuodizhi(String odderSonghuodizhi)
	{
		this.odderSonghuodizhi = odderSonghuodizhi;
	}

	public void setOrderBianhao(String orderBianhao)
	{
		this.orderBianhao = orderBianhao;
	}

	public String getOrderDate()
	{
		return this.orderDate;
	}

	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
	}

	public String getOrderZhuangtai()
	{
		return this.orderZhuangtai;
	}

	public void setOrderZhuangtai(String orderZhuangtai)
	{
		this.orderZhuangtai = orderZhuangtai;
	}

	public Integer getOrderUserId()
	{
		return this.orderUserId;
	}

	public void setOrderUserId(Integer orderUserId)
	{
		this.orderUserId = orderUserId;
	}

	public Integer getFuid() {
		return fuid;
	}

	public void setFuid(Integer fuid) {
		this.fuid = fuid;
	}

	public String getShifoufukuan() {
		return shifoufukuan;
	}

	public void setShifoufukuan(String shifoufukuan) {
		this.shifoufukuan = shifoufukuan;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	
}