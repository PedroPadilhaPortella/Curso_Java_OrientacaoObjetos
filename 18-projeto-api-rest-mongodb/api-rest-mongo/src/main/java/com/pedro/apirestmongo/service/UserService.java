package com.pedro.apirestmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.apirestmongo.domain.User;
import com.pedro.apirestmongo.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return this.repository.findAll();
	}
}
