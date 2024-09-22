package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPingluns;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPingluns entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TPingluns
 * @author MyEclipse Persistence Tools
 */

public class TPinglunsDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPinglunsDAO.class);
	// property constants
	public static final String NEIRONG = "neirong";
	public static final String SHIJIAN = "shijian";
	

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPingluns transientInstance)
	{
		log.debug("saving TPingluns instance");
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

	public void delete(TPingluns persistentInstance)
	{
		log.debug("deleting TPingluns instance");
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

	public TPingluns findById(java.lang.Integer id)
	{
		log.debug("getting TPingluns instance with id: " + id);
		try
		{
			TPingluns instance = (TPingluns) getHibernateTemplate().get(
					"com.model.TPingluns", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPingluns instance)
	{
		log.debug("finding TPingluns instance by example");
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
		log.debug("finding TPingluns instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPingluns as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNeirong(Object neirong)
	{
		return findByProperty(NEIRONG, neirong);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}



	public List findAll()
	{
		log.debug("finding all TPingluns instances");
		try
		{
			String queryString = "from TPingluns";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPingluns merge(TPingluns detachedInstance)
	{
		log.debug("merging TPingluns instance");
		try
		{
			TPingluns result = (TPingluns) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPingluns instance)
	{
		log.debug("attaching dirty TPingluns instance");
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

	public void attachClean(TPingluns instance)
	{
		log.debug("attaching clean TPingluns instance");
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

	public static TPinglunsDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPinglunsDAO) ctx.getBean("TPinglunsDAO");
	}
}