package com.eljei.jba.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eljei.jba.entity.User;
import com.eljei.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostConstruct
	public void Init(){
	
		User useradmin = new User();
		useradmin.setName("Admin");
		userRepository.save(useradmin);
		
		
		
		
	}
	

}
