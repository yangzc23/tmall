package com.yzc.dao;
// default package
// Generated 2019-9-27 10:53:04 by Hibernate Tools 4.3.5.Final

import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzc.entity.TItem;

/**
 * Home object for domain model class TItem.
 * @see .TItem
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class TItemHome {

	private static final Log log = LogFactory.getLog(TItemHome.class);

	@Autowired
	private SessionFactory sessionFactory;


	public void persist(TItem transientInstance) {
		log.debug("persisting TItem instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TItem instance) {
		log.debug("attaching dirty TItem instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TItem instance) {
		log.debug("attaching clean TItem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TItem persistentInstance) {
		log.debug("deleting TItem instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TItem merge(TItem detachedInstance) {
		log.debug("merging TItem instance");
		try {
			TItem result = (TItem) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TItem findById(int id) {
		log.debug("getting TItem instance with id: " + id);
		try {
			TItem instance = (TItem) sessionFactory.getCurrentSession().get("com.yzc.entity.TItem", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TItem instance) {
		log.debug("finding TItem instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.yzc.entity.TItem").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
