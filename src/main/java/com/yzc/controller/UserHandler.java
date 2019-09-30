package com.yzc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzc.dao.TProductHome;
import com.yzc.dao.TUserHome;
import com.yzc.entity.TUser;
import com.yzc.pojo.ActionResult;

@Controller
public class UserHandler {
	
	@Autowired
	private TUserHome userDao;
	
	@Autowired
	private TProductHome productDao;
	
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
            return ActionResult.ok(list.get(0));
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
		List list = productDao.findByExample(begin, rows);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("total", total);
		data.put("rows", list);
    	return ActionResult.ok(data);
    }
    
}
