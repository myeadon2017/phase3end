package com.phase3end.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

//This will be used as a Swagger configuration file for Swagger documentation purposes
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		//return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(ApiInfo()).select().paths(postPaths()).build();
	return new Docket (DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.phase3end")).build();
	}

private Predicate<String> postPaths(){
	return or(regex("/api/posts.*"), regex("/list-tasks.*"));
}

}
