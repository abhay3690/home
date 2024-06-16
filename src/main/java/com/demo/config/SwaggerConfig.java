package com.demo.config;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public-api").pathsToMatch("/api/**") // Specify the paths to match
				.build();
	}

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Blogging Application : BackEnd Api Project")
						.version("1.0")
						.description("Project of apis for bloging ")
						.contact(new Contact()
								.name("Abhay A Suthar")
								.email("abhaysuthar7777@gmail.com")))
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				.components(
						new Components()
						.addSecuritySchemes("bearerAuth", new SecurityScheme()
								.type(SecurityScheme.Type.HTTP)
								.scheme("bearer")
								.bearerFormat("JWT")));
	}
}