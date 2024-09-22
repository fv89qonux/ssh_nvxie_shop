package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPinpai;

/**
 * Data access object (DAO) for domain model class TPinpai.
 * 
 * @see com.model.TPinpai
 * @author MyEclipse Persistence Tools
 */

public class TPinpaiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPinpaiDAO.class);

	// property constants
	public static final String NAME = "name";

	public static final String MIAOSHU = "miaoshu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPinpai transientInstance)
	{
		log.debug("saving TPinpai instance");
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

	public void delete(TPinpai persistentInstance)
	{
		log.debug("deleting TPinpai instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPinpai findById(java.lang.Integer id)
	{
		log.debug("getting TPinpai instance with id: " + id);
		try
		{
			TPinpai instance = (TPinpai) getHibernateTemplate().get(
					"com.model.TPinpai", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPinpai instance)
	{
		log.debug("finding TPinpai instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TPinpai instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPinpai as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPinpaiName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByPinpaiMiaoshu(Object miaoshu)
	{
		return findByProperty(MIAOSHU, miaoshu);
	}

	public List findAll()
	{
		log.debug("finding all TPinpai instances");
		try
		{
			String queryString = "from TPinpai";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPinpai merge(TPinpai detachedInstance)
	{
		log.debug("merging TPinpai instance");
		try
		{
			TPinpai result = (TPinpai) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPinpai instance)
	{
		log.debug("attaching dirty TPinpai instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPinpai instance)
	{
		log.debug("attaching clean TPinpai instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TPinpaiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPinpaiDAO) ctx.getBean("TPinpaiDAO");
	}
}