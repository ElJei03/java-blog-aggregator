package com.eljei.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eljei.jba.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}
