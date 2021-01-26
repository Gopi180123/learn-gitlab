package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("helloo.....");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver lr=new AcceptHeaderLocaleResolver();
		lr.setDefaultLocale(Locale.US);
		return lr;
	}
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource rms=new ResourceBundleMessageSource();
	 * rms.setBasename("messages"); return rms; }
	 */
}
