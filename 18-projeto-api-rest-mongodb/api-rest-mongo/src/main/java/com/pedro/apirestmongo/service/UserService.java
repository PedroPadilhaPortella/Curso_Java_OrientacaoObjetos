package com.pedro.apirestmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.apirestmongo.domain.User;
import com.pedro.apirestmongo.repository.UserRepository;
import com.pedro.apirestmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService
{
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = this.repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
