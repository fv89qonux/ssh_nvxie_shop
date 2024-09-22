package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPinglun;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPinglun entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see TPinglun
 * @author MyEclipse Persistence Tools
 */

public class TPinglunDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPinglunDAO.class);
	// property constants
	public static final String NEIRONG = "neirong";
	public static final String SHIJIAN = "shijian";
	public static final String ZHAOPIAN_ID = "zhaopianId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPinglun transientInstance)
	{
		log.debug("saving TPinglun instance");
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

	public void delete(TPinglun persistentInstance)
	{
		log.debug("deleting TPinglun instance");
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

	public TPinglun findById(Integer id)
	{
		log.debug("getting TPinglun instance with id: " + id);
		try
		{
			TPinglun instance = (TPinglun) getHibernateTemplate().get(
					"com.model.TPinglun", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPinglun instance)
	{
		log.debug("finding TPinglun instance by example");
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
		log.debug("finding TPinglun instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPinglun as model where model."
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

	public List findByZhaopianId(Object zhaopianId)
	{
		return findByProperty(ZHAOPIAN_ID, zhaopianId);
	}

	public List findAll()
	{
		log.debug("finding all TPinglun instances");
		try
		{
			String queryString = "from TPinglun";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPinglun merge(TPinglun detachedInstance)
	{
		log.debug("merging TPinglun instance");
		try
		{
			TPinglun result = (TPinglun) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPinglun instance)
	{
		log.debug("attaching dirty TPinglun instance");
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

	public void attachClean(TPinglun instance)
	{
		log.debug("attaching clean TPinglun instance");
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

	public static TPinglunDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPinglunDAO) ctx.getBean("TPinglunDAO");
	}
}