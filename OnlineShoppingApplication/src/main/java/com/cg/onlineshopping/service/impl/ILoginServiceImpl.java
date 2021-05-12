package com.cg.onlineshopping.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.error.UserNotFoundException;
import com.cg.onlineshopping.repository.ILoginRepository;
import com.cg.onlineshopping.service.ILoginService;
@Service
public class ILoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	Logger logger = LoggerFactory.getLogger(ILoginServiceImpl.class);

    //To add user
	@Override
	@Transactional
	public User addUser(User user) {
		logger.info("User addUser()");
		if(user == null)
			throw new UserNotFoundException();
		else {
			loginRepo.save(user);
			return user;
		}
	}
    //To remove user
	@Override
	@Transactional
	public User removeUser(Integer userId) {
		logger.info("User removeUser()");
		Optional<User> users = loginRepo.findById(userId);
		if(!users.isPresent())
			throw new UserNotFoundException();
		else {
			loginRepo.deleteById(userId);
			return users.get();
		}
	}
    //To validate user
	@Override
	@Transactional
	public User validateUser(Integer userId) {
		logger.info("User validateUser()");
		String pass = loginRepo.getPassword(userId);
		User u = loginRepo.findValidateUser(userId,pass);
		if(u == null)
			throw new UserNotFoundException();
		else
			return u;	
		}

    //for signing out
	@Override
	@Transactional
	public User signOut(User user) {
		// TODO Auto-generated method stub
				return null;
	}
}
	