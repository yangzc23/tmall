package com.yzc.dao;
// default package
// Generated 2019-9-27 10:53:04 by Hibernate Tools 4.3.5.Final

import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzc.entity.TUser;

/**
 * Home object for domain model class TUser.
 * @see .TUser
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class TUserHome {

	private static final Log log = LogFactory.getLog(TUserHome.class);

	//private final SessionFactory sessionFactory = getSessionFactory();
	
	@Autowired
	private SessionFactory sessionFactory;

/*	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}*/

	public void persist(TUser transientInstance) {
		log.debug("persisting TUser instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TUser findById(int id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) sessionFactory.getCurrentSession().get("com.yzc.entity.TUser", id);
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

/*	public List findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("TUser").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/
	
	public List findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria("com.yzc.entity.TUser");
			Criterion username = Restrictions.eq("username", instance.getUsername());
			Criterion password = Restrictions.eq("password", instance.getPassword());			
			List results = criteria.add(Restrictions.and(username, password)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}	
	
}
