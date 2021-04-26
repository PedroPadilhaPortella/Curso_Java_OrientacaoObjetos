package com.pedro.apirestmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.apirestmongo.domain.Post;
import com.pedro.apirestmongo.domain.User;
import com.pedro.apirestmongo.dto.UserDTO;
import com.pedro.apirestmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource
{
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = this.service.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> new UserDTO (user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = this.service.findById(id);
		UserDTO userDTO =  new UserDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
		User user = this.service.fromDTO(userDTO);
		user = this.service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
		User user = this.service.fromDTO(userDTO);
		user.setId(id);
		service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User user = this.service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}