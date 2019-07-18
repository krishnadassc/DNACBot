package com.cisco.dnac.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration(
		exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com")
@EnableWebMvc
@EnableScheduling
@EnableSwagger2
public class DnacAutoBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnacAutoBotApplication.class, args);
	}

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.or(PathSelectors.ant("/rest/*/*/*")

						, PathSelectors.regex("/rest/*")))
				.build().apiInfo(getSwaggerApiInfo());
	}
	
	private ApiInfo getSwaggerApiInfo() {
		return new ApiInfo("DNAC RESTful API Documentation", null, "1.0", null,
				new Contact(null, null, null), null, null);
	}
}
