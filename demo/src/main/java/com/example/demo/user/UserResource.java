package com.example.demo.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoservice;

	// getallusers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoservice.findAll();
	}

	// get user specific
	@GetMapping("/user/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id) {
		
		User user= userDaoservice.findByID(id);
		if(user==null) {
			throw new UserNotFoundException("id " +id);
		}
		EntityModel<User> resource = EntityModel.of(user);
		//resource.add(Link.of("/user/{id}").withRel(LinkRelation.of("/users")));
		
		  WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(this.getClass(),retrieveAllUsers());
		  
		  resource.add(linkTo.withRel("all-users"));
		 	
		return resource;
	}
		

		@DeleteMapping("/user/{id}")
		public User deleteUser(@PathVariable Integer id) {
			User user= userDaoservice.deleteByID(id);
			if(user==null) {
				throw new UserNotFoundException("id " +id);
			}
			return user;
		}

	// get user specific
	@PostMapping( "/users")
	public /*ResponseEntity<Object>*/ void createUser(@Valid @RequestBody User user) {
		User save=userDaoservice.save(user);
		//URI uriLocation=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		//return ResponseEntity.created(uriLocation).build();
	}

}
