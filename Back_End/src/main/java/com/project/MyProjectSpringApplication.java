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
	    mailSender.setHost("smtp.live.com");
	    mailSender.setPort(25);
	     
	    mailSender.setUsername("sylvain-guehria@hotmail.fr");
	    mailSender.setPassword("ymvtqimskmxsgiid");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.ssl.trust", "smtp.live.com");
	   // props.setProperty("mail.smtp.ssl.enable", "true");

//	    props.put("mail.smtp.socketFactory.port", 25);
//	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//	    props.put("mail.smtp.socketFactory.fallback", "false");

//   
	     
	    return mailSender;
	}
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText(
	      "This is the test email template for your email:\n%s\n");
	    return message;
	}
	

}
