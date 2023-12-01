package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info=@Info(title="Cab Booking API", version="1.2", description="Cab Booking Application is a backend focused web API, User can log in as Admin, Customer, or Driver and book a cab. Built using Java, Hibernate, Mysql, Maven, and SpringBoot."))
//@RequestMapping("/api")
//@EnableSwagger2
public class CabBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}
	
	/*@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	    		  .apis(RequestHandlerSelectors.any())
	    		  .paths(PathSelectors.any())
	    		  .build();
	   }
	   */
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
	LocalValidatorFactoryBean lvfb=new LocalValidatorFactoryBean();
	lvfb.setValidationMessageSource(ms);
	return lvfb;
	}
	
}
