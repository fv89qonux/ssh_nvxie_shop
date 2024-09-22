package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TUserGoods;

/**
 * Data access object (DAO) for domain model class TUser.
 * 
 * @see com.model.TUser
 * @author MyEclipse Persistence Tools
 */

public class TUserGoodsDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TUserGoodsDAO.class);


	protected void initDao()
	{
		// do nothing
	}

	public void save(TUserGoods transientInstance)
	{
		log.debug("saving TUserGoods instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public TUserGoods findById(java.lang.Integer id)
	{
		log.debug("getting TUserGoods instance with id: " + id);
		try
		{
			TUserGoods instance = (TUserGoods) getHibernateTemplate().get(
					"com.model.TUserGoods", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TUserGoods instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TUserGoods as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public static TUserGoodsDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TUserGoodsDAO) ctx.getBean("TUserGoods");
	}
}