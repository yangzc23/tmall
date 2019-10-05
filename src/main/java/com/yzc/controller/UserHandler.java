package com.yzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzc.dao.TOrderHome;
import com.yzc.dao.TProductHome;
import com.yzc.dao.TUserHome;
import com.yzc.entity.TItem;
import com.yzc.entity.TOrder;
import com.yzc.entity.TProduct;
import com.yzc.entity.TUser;
import com.yzc.pojo.ActionResult;
import com.yzc.pojo.OrderVO;
import com.yzc.pojo.ProductVO;
import com.yzc.pojo.UserVO;

@Controller
public class UserHandler {
		
	@Autowired
	private TUserHome userDao;
	
	@Autowired
	private TProductHome productDao;
	
	@Autowired
	private TOrderHome orderDao;	
	
	/**
	 * 用户登录
	 * @param user
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/portal/login",method = RequestMethod.POST)
    @ResponseBody
    public ActionResult login(TUser user, HttpSession session){   
    	//查询用户表
        List list = userDao.findByExample(user);
        if(list.size()>0){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",list.get(0));
            //
            UserVO uservo = new UserVO();
            TUser tuser = (TUser)list.get(0);
            uservo.setId(tuser.getId());
            uservo.setUsername(tuser.getUsername());
            uservo.setCredit(tuser.getCredit());
            uservo.setAddress(tuser.getAddress());
            return ActionResult.ok(uservo);
        }
        return ActionResult.fail("用户名或密码错误，请重新登录！");
    }
    
	/**
	 * 用户退出
	 * @param user
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/portal/logout",method = RequestMethod.GET)
    @ResponseBody
    public ActionResult logout(HttpSession session){   
    	session.invalidate();
        return ActionResult.ok("退出登录！");
    }    
    
    /**
     * 获取商品列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/portal/list",method = RequestMethod.POST)
    @ResponseBody
    public ActionResult getProducts(@RequestBody Map<String,String> map) {
		//int rows = Integer.parseInt(req.getParameter("rows"));
		int rows = Integer.parseInt(map.get("rows"));
		//
		//int page = Integer.parseInt(req.getParameter("page"));
		int page = Integer.parseInt(map.get("page"));
		int begin = (page-1)*rows;
		int total = productDao.getTotal();
		List<TProduct> list = productDao.findByExample(begin, rows);
		List<ProductVO> list2 = new ArrayList<ProductVO>();
		Map<String,Object> data = new HashMap<String,Object>();
		for(TProduct p:list) {
			ProductVO pvo = new ProductVO();
			pvo.setId(p.getId());
			pvo.setName(p.getName());
			pvo.setImageUrl(p.getImageUrl());
			pvo.setPrice(p.getPrice());
			pvo.setStock(p.getStock());
			pvo.setQuantity(1);
			list2.add(pvo);
		}
		data.put("total", total);
		data.put("rows", list2);
    	return ActionResult.ok(data);
    }
    
    /**
     * 生成订单
     * @param products
     * @param session
     * @return
     */
    @RequestMapping(value = "/order/new",method = RequestMethod.POST)
    @ResponseBody
    public ActionResult createOrder(@RequestBody Set<ProductVO> products, HttpSession session) {
    	TUser user = (TUser)session.getAttribute("USER_SESSION");
    	return ActionResult.ok(orderDao.saveOrder(products, user));
    }    
  
    /**
     * 查询订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/detail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ActionResult getOrder(@PathVariable String id) {
    	TOrder order = orderDao.findById(id);
    	OrderVO ordervo = new OrderVO();
    	ordervo.setId(order.getId());
    	ordervo.setTotalAmount(order.getTotalAmount());
    	ordervo.setActualTotalAmount(order.getActualTotalAmount());
    	ordervo.setCreateTime(order.getCreateTime());
    	Set<TItem> items = order.getTItems();
    	Set<ProductVO> products = new HashSet<ProductVO>();
    	for(TItem item:items) {
    		ProductVO p = new ProductVO();
    		p.setId(item.getTProduct().getId());
    		p.setName(item.getTProduct().getName());
    		p.setPrice(item.getTProduct().getPrice());
    		p.setImageUrl(item.getTProduct().getImageUrl());
    		p.setQuantity(item.getQuantity());
    		products.add(p);
    	}
    	ordervo.setTItems(products);
    	return ActionResult.ok(ordervo);
    }        
    
    
}
