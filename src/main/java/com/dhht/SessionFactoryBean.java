package com.dhht;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryBean {
	    @Bean
	    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf){
	         return emf.unwrap(SessionFactory.class);
	     }
}
