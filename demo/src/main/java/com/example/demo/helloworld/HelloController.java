package com.example.demo.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	public MessageSource messageSource;
	@GetMapping(path="/hello")
	public String Hello() {
		return "Hello world";
	}
	@GetMapping(path="/helloi")
	public String Helloi(/* @RequestHeader(name ="Accept-Language", required=false) Locale locale */) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	@GetMapping(path="/hellow")
	public HelloWorldBean Hellow() {
		return new HelloWorldBean("Hello world");
	}
	@GetMapping(path="/hellow/pathvariable/{name}")
	public HelloWorldBean HelloWithName(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s", name));
	}
}
