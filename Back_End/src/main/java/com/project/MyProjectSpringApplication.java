package com.project;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;


@SpringBootApplication
public class MyProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectSpringApplication.class, args);

	}
	@Bean
	@Primary
	public  static BCryptPasswordEncoder getpce() {
		return new BCryptPasswordEncoder ();
	}

	public static String hash(String password, int row) {
		return BCrypt.hashpw(password, BCrypt.gensalt(row));
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("sylvain.javadev@gmail.com");
	    mailSender.setPassword("mamivwyviyhfhfbz");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");

	     
	    return mailSender;
	}
	
//	@Bean
//	public SimpleMailMessage templateSimpleMessage() {
//	    SimpleMailMessage message = new SimpleMailMessage();
//	    message.setText(
//	      "This is the test email template for your email:\n%s\n");
//	    return message;
//	}
	

}
