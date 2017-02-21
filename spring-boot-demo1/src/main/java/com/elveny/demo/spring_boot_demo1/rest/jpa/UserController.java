package com.elveny.demo.spring_boot_demo1.rest.jpa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/jpa/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repository;
	
	@ResponseBody
	@RequestMapping("")
	String hello(){
		return "hello, this is jpa test of user.";
	}
	
	@RequestMapping("save")
	@ResponseBody
	String save(@RequestParam("name") String name, @RequestParam("age") int age) {
		// save a couple of customers
		repository.save(new User(name, age));

		return "success";
	}
	
	@RequestMapping("findAll")
	@ResponseBody
	List<User> findAll(){
		// fetch all customers
		log.info("users found with findAll()");
		log.info("-------------------------------");
		List<User> users = new ArrayList<User>();
		for (User user : repository.findAll()) {
			users.add(user);
		}

		return users;
	}
	
	@RequestMapping("findOne/{id}")
	@ResponseBody
	User findOne(@PathVariable long id){
		User user = new User();
		
		user = repository.findOne(id);
		
		return user;
	}
	
	@RequestMapping("findByName/{name}")
	@ResponseBody
	List<User> findByName(@PathVariable String name){
		// fetch all customers
		log.info("users found with findByName/{name}");
		log.info("-------------------------------");
		List<User> users = new ArrayList<User>();
		for (User user : repository.findByName(name)) {
			users.add(user);
		}

		return users;
	}
	
	@RequestMapping("findSimpleTest")
	@ResponseBody
	List<User> findSimpleTest(){
		// fetch all customers
		log.info("users found with findSimpleTest}");
		log.info("-------------------------------");
		List<User> users = new ArrayList<User>();
		for (Object[] items : repository.findSimpleTest()) {
			User user = new User();
			user.setId((Long)items[0]);
			user.setName((String)items[1]);
			users.add(user);
		}

		return users;
	}
}
