package com.demo.config;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	public static final String[] PUBLIC_URLS = { "/api/v1/auth/**", "/v3/api-docs/**", "/swagger-resources/**", "swagger-ui/**", "/webjars/**" };

	private final JWTAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers(PUBLIC_URLS).permitAll()
//		.requestMatchers("/api/v1/auth/**").permitAll()
//		.requestMatchers("/v3/api-docs").permitAll()
//		.requestMatchers(HttpMethod.GET).permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}