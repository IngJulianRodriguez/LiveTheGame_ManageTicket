package com.livethegame.ManageTicket;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = "com.livethegame.ManageTicket")
public class ManageTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageTicketApplication.class, args);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Live The Game Manage Ticket api services")
				.description("")
				.termsOfServiceUrl("")
				.contact(new Contact("Julian Rodriguez", "", ""))
				.license("Pragma")
				.licenseUrl("")
				.version("1.0")
				.build();
	}


	//main Swagger config definition
	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("manageTicket-apis")
				.apiInfo(apiInfo())
				//set up JWT input
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.livethegame"))
				.paths(PathSelectors.any())
				.build()
				.tags(new Tag("Api Manage Ticket", "") {});
	}

	//define API key to include the header
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	//condigure JWT security with global Autorization Scope

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
