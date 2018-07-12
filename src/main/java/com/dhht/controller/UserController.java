package com.dhht.controller;

import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.entity.User;
import com.dhht.service.user.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	  private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
      
	@RequestMapping("/getUser")
	//@ResponseBody  //转成json格式传到页面
	public User hello() {
		User user = new User();
		user.setAge(12);
		user.setBirthday(new Date());
		user.setName("老王");
		user.setPassword("123");
		return user;
	}
	
	@RequestMapping("/hello")
	public ModelAndView str(ModelAndView mv) {
		mv.setViewName("helloJsp1");
		mv.addObject("name", 1234);
		return  mv;
	}
	
	@RequestMapping("getById")
	public User getById(User user) {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
		User u = userService.getById(user.getId());
		return u;
	}
}
