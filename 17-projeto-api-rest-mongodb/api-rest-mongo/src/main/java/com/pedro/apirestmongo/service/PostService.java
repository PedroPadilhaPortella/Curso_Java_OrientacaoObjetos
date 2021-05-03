

package com.pedro.apirestmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.apirestmongo.domain.Post;
import com.pedro.apirestmongo.repository.PostRepository;
import com.pedro.apirestmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService
{
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = this.repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSeach(String text, Date minDate, Date maxDate) {
		maxDate= new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
