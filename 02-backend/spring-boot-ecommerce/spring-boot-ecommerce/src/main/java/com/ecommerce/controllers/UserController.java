package com.ecommerce.controllers;


import java.time.LocalDate;
import java.util.List;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id) {
		return userService.findUserById(id);
		
	}

	
	@PostMapping("user/signup")
	public ResponseEntity<User> createUserSignup(@RequestBody User user) {
		System.out.println(user);
		User saveduser = userService.createUser(user);
		ResponseEntity<User> res = ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
		System.out.println(res);
		return res;
		//return "SingUp success";
		//return userService.createUser(user);
	}
	@PostMapping("/user/login")
	public ResponseEntity<User> Userlogin(@RequestBody User user) {

		User loggeduser = userService.Userlogin(user);
		if(loggeduser == null) {
			res =new ResponseEntity<User>(loggeduser,HttpStatus.BAD_REQUEST);
		}
		res =new ResponseEntity<User>(loggeduser,HttpStatus.ACCEPTED);
		System.out.println(res);
		System.out.println("Login success");
		return res;
	}
	
//	@PutMapping("update/{id}")
//	public User updatesUser(@PathVariable int id,@RequestBody User user) throws InvalidUserException {
//		return userService.updateUser(id, user);
//	}
//	
//	@DeleteMapping("delete/{id}")
//	public boolean deleteUser( @RequestBody User user,@PathVariable int id) throws InvalidUserException {
//		userService.deleteUser(user,id);
//		return true;
//
//}
//	@ExceptionHandler(InvalidUserException.class)
//	public ResponseEntity<ErrorMessage> handleException(HttpServletRequest req, InvalidUserException e){
//		ErrorMessage error = new ErrorMessage(e.getMessage(), LocalDate.now(), req.getRequestURL(), HttpStatus.BAD_REQUEST);
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//	}
}
