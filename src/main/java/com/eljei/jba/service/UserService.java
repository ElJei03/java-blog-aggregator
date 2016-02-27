package com.eljei.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.annotations.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eljei.jba.entity.Blog;
import com.eljei.jba.entity.Item;
import com.eljei.jba.entity.Role;
import com.eljei.jba.entity.User;
import com.eljei.jba.repository.BlogRepository;
import com.eljei.jba.repository.ItemRepository;
import com.eljei.jba.repository.RoleRepository;
import com.eljei.jba.repository.UserRepository;

import javassist.runtime.Desc;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs= blogRepository.findByUser(user);
		for(Blog blog : blogs){
		List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, org.springframework.data.domain.Sort.Direction.DESC, "publishdate"));
		blog.setItem(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findOneWithBlogs(String name) {
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
		
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

}
