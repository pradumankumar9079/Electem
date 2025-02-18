package com.electems.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 *  @SpringBootAplication Annotations is the Entry point of springboot application ,it combines three annotations:
    @Configuration,@EnableAutoConfiguration,@ComponentScan
    By using @SpringBootApplication we can Enable the three bove three annotations

*/
@SpringBootApplication
/*
 * @nablecaching Annotation is used to enable the caching in spring boot Application 
 * to improvethe performance of Application
 */
@EnableCaching
/*
 * @EnableAsync annotation is used to enable the async methods by using 2Async annotation
 */
@EnableAsync
/*
 * @EnableTransactionManagement is used to enble the transaction management in spring boot application 
 */
@EnableTransactionManagement
public class StudentApplication {

	public static void main(String[] args) {
	    /*
	     * SpringApplication.run() method is used to launch the Spring Boot Application
	     * SpringApplication.run() initialize the ApplicationContext,Enable the Embedded Serve,starts Application lifeCycle 
	     * it will perform the AutoConfiguration and it will return the ApplicationContext
	     */
		SpringApplication.run(StudentApplication.class, args);
	}

}
