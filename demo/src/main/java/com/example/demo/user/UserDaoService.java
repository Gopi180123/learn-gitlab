package com.example.demo.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<User>();
	
	static {
		users.add(new User("Ramya",new Date(),1));
		users.add(new User("Tulasi",new Date(),2));
		users.add(new User("Gopi",new Date(),3));
	}
	private int userscount=3;
public List<User> findAll(){
	return users;
}
public User findByID(Integer id) {
	for(User user: users) {
		if(user.getId()==id) {
			return user;
		}
	}
	return null;
	
}
public User deleteByID(Integer id) {
	Iterator<User> iterator=users.iterator();
	while(iterator.hasNext()) {
		User user=iterator.next();
		if(user.getId()==id) {
			iterator.remove();
			return user;
		}
		
	}
	
	return null;
	
}
public User save(User user) {
	//if(user.getId()==null||user.getId()==0) {
		user.setId(userscount++);
	
	users.add(user);
	return null;
}
}
