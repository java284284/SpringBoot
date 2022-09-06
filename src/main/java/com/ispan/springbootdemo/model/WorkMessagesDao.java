package com.ispan.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkMessagesDao extends JpaRepository<WorkMessages, Integer> {

	public WorkMessages findFirstByOrderByAddedDesc();
	
}