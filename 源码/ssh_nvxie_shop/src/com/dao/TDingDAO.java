package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TDing;

/**
 * Data access object (DAO) for domain model class TDing.
 * 
 * @see com.model.TDing
 * @author MyEclipse Persistence Tools
 */

public class TDingDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TDingDAO.class);

	// property constants
	public static final String GOODS_NAME = "goodsName";

	public static final String GOODS_MIAOSHU = "goodsMiaoshu";

	public static final String GOODS_PIC = "goodsPic";

	public static final String GOODS_YANSE = "goodsYanse";

	public static final String GOODS_SHICHANGJIA = "goodsShichangjia";

	public static final String GOODS_TEJIA = "goodsTejia";

	public static final String GOODS_ISNOTTEJIA = "goodsIsnottejia";

	public static final String GOODS_ISNOTTUIJIAN = "goodsIsnottuijian";

	public static final String GOODS_CATELOG_ID = "goodsCatelogId";

	public static final String GOODS_PINPAI_ID = "goodsPinpaiId";
	
	public static final String UID = "uid";
	 
	protected void initDao()
	{
		// do nothing
	}

	public void save(TDing transientInstance)
	{
		log.debug("saving TDing instance");
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

	public void delete(TDing persistentInstance)
	{
		log.debug("deleting TDing instance");
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

	public TDing findById(java.lang.Integer id)
	{
		log.debug("getting TDing instance with id: " + id);
		try
		{
			TDing instance = (TDing) getHibernateTemplate().get(
					"com.model.TDing", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDing instance)
	{
		log.debug("finding TDing instance by example");
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
		log.debug("finding TDing instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TDing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	 

	public List findByGoodsMiaoshu(Object goodsMiaoshu)
	{
		return findByProperty(GOODS_MIAOSHU, goodsMiaoshu);
	}

	public List findByGoodsPic(Object goodsPic)
	{
		return findByProperty(GOODS_PIC, goodsPic);
	}

	public List findByGoodsYanse(Object goodsYanse)
	{
		return findByProperty(GOODS_YANSE, goodsYanse);
	}

	public List findByGoodsShichangjia(Object goodsShichangjia)
	{
		return findByProperty(GOODS_SHICHANGJIA, goodsShichangjia);
	}

	public List findByGoodsTejia(Object goodsTejia)
	{
		return findByProperty(GOODS_TEJIA, goodsTejia);
	}

	public List findByGoodsIsnottejia(Object goodsIsnottejia)
	{
		return findByProperty(GOODS_ISNOTTEJIA, goodsIsnottejia);
	}

	public List findByGoodsIsnottuijian(Object goodsIsnottuijian)
	{
		return findByProperty(GOODS_ISNOTTUIJIAN, goodsIsnottuijian);
	}

	public List findByGoodsCatelogId(Object goodsCatelogId)
	{
		return findByProperty(GOODS_CATELOG_ID, goodsCatelogId);
	}

	public List findByGoodsPinpaiId(Object goodsPinpaiId)
	{
		return findByProperty(GOODS_PINPAI_ID, goodsPinpaiId);
	}
	
	public List findByGoodsUid(Object uid)
	{
		return findByProperty(UID, uid);
	}
	
	public List findAll()
	{
		log.debug("finding all TDing instances");
		try
		{
			String queryString = "from TDing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDing merge(TDing detachedInstance)
	{
		log.debug("merging TDing instance");
		try
		{
			TDing result = (TDing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDing instance)
	{
		log.debug("attaching dirty TDing instance");
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

	public void attachClean(TDing instance)
	{
		log.debug("attaching clean TDing instance");
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

	public static TDingDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TDingDAO) ctx.getBean("TDingDAO");
	}
}