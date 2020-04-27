package com.inventory.search.InventorySearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.inventory.search"})
@EntityScan(basePackages = {"com.inventory.search"})
@EnableJpaRepositories(basePackages = {"com.inventory.search"})
@EnableTransactionManagement
@EnableCaching
public class InventorySearchApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InventorySearchApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InventorySearchApplication.class);
    }

}
