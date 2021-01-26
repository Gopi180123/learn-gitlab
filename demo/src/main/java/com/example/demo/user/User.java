package com.example.demo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	@Size(min=2, message="Name should have atleast two characters ")
private String name;
	@Past
private Date birthDate;
@Override
public String toString() {
	return "User [name=" + name + ", birthDate=" + birthDate + ", id=" + id + "]";
}
public User(String name, Date birthDate, Integer id) {
	super();
	this.name = name;
	this.birthDate = birthDate;
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
private Integer id;
}
