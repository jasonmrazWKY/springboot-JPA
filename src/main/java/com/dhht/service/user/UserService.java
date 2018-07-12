package com.dhht.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dhht.dao.BaseDao;
import com.dhht.entity.User;

@Service
public class UserService {
	
	@Autowired
	 private BaseDao<User> userDao;
	
	//@Transactional(readOnly=true)
	//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true )
	public User  getById(String  userId) {
		return userDao.get(User.class, userId);
	}

}
