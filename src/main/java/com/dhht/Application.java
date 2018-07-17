package com.dhht;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.dhht", "org.n3r.idworker"})
@ImportResource("classpath:transaction.xml")
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	 
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//	   return new HibernateJpaSessionFactoryBean();
//	}
	
//	   @Bean
//	    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf){
//	         return emf.unwrap(SessionFactory.class);
//	     }
}
