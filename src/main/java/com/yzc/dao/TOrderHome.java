package com.yzc.dao;
// default package
// Generated 2019-9-27 10:53:04 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzc.entity.TItem;
import com.yzc.entity.TOrder;
import com.yzc.entity.TProduct;
import com.yzc.entity.TUser;
import com.yzc.pojo.OrderVO;
import com.yzc.pojo.ProductVO;

/**
 * Home object for domain model class TOrder.
 * @see .TOrder
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class TOrderHome {

	private static final Log log = LogFactory.getLog(TOrderHome.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Sid sid;

	public void persist(TOrder transientInstance) {
		log.debug("persisting TOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TOrder instance) {
		log.debug("attaching dirty TOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrder instance) {
		log.debug("attaching clean TOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TOrder persistentInstance) {
		log.debug("deleting TOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TOrder merge(TOrder detachedInstance) {
		log.debug("merging TOrder instance");
		try {
			TOrder result = (TOrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TOrder findById(java.lang.String id) {
		log.debug("getting TOrder instance with id: " + id);
		try {
			TOrder instance = (TOrder) sessionFactory.getCurrentSession().get("com.yzc.entity.TOrder", id);
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

	public List findByExample(TOrder instance) {
		log.debug("finding TOrder instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.yzc.entity.TOrder").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
    public OrderVO saveOrder(Set<ProductVO> products, TUser user) {
    	Date now = new Date();
    	String orderId = sid.nextShort();
    	TOrder order = new TOrder();
    	order.setCreateTime(now);
    	OrderVO ordervo = new OrderVO();
    	ordervo.setCreateTime(now);
    	order.setId(orderId);
    	ordervo.setId(orderId);
    	ordervo.setTItems(products);
    	Float totalAmount = 0.0f;
    	Float actualTotalAmount = 0.0f;
    	Set<TItem> items = new HashSet<TItem>();
    	for(ProductVO p:products) {
    		TProduct product = (TProduct) sessionFactory.getCurrentSession().get("com.yzc.entity.TProduct", p.getId());
    		//TProduct product = productDao.findById(p.getId());
    		TItem item = new TItem();
    		item.setTProduct(product);
    		item.setQuantity(p.getQuantity());
    		item.setTOrder(order);
    		items.add(item);
    		totalAmount += p.getQuantity()*product.getPrice();
    		actualTotalAmount += p.getQuantity()*product.getPrice();
    		System.out.println(p.getName()+","+p.getPrice()+","+p.getQuantity());
    		product.setStock(product.getStock()-p.getQuantity());
    		sessionFactory.getCurrentSession().merge(product);
    		sessionFactory.getCurrentSession().persist(item);
    	}
    	order.setTotalAmount(totalAmount);
    	order.setActualTotalAmount(actualTotalAmount);
    	ordervo.setTotalAmount(totalAmount);
    	ordervo.setActualTotalAmount(actualTotalAmount);
    	order.setTItems(items);
    	order.setTUser(user);
    	log.debug("persisting TOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(order);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
    	return ordervo;
    }    	
	
}
