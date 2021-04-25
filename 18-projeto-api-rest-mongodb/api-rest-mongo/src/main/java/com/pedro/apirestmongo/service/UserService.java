

package com.pedro.apirestmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.apirestmongo.domain.User;
import com.pedro.apirestmongo.dto.UserDTO;
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
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public void delete(String id) {
		this.findById(id);
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User userDB = findById(user.getId());
		this.updateData(userDB, user);
		return repository.save(userDB);
	}
	
	public void updateData(User userDB, User user) {
		userDB.setName(user.getName());
		userDB.setEmail(user.getEmail());
	}
}
