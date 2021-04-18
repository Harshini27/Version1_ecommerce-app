package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User findUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		return optional.orElse(null);
	}
	
	public User createUser(User user)  {
		User users = userRepository.findByEmail(user.getEmail());
		if(users.getEmail().equals(user.getEmail()))
		{
			return null;
		}
		else
		{
			return userRepository.save(user);
		}
	}
	
	public User Userlogin(User user) {
		  User users = userRepository.findByEmail(user.getEmail());
		  System.out.println(users.getEmail());
		  System.out.println(users.getPassword());
		  if(users==null)
		  {
			  return null;
		  }
		  if(user.getEmail().equals(users.getEmail()) && user.getPassword().equals(users.getPassword()) )
		  {
			  return users;
		  }
		  else
		  {
			  return null;
		  }
		  
	}

}
