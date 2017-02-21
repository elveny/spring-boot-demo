package com.elveny.demo.spring_boot_demo1.rest.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	List<User> findByName(String name);
	
	@Query("select t.id, t.name from User t")
    List<Object[]> findSimpleTest();
}
