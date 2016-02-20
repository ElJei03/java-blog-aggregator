package com.eljei.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eljei.jba.entity.Blog;


public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
