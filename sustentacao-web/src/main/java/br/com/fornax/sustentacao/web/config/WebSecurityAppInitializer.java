package br.com.fornax.sustentacao.web.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSecurityAppInitializer extends AbstractSecurityWebApplicationInitializer {

	public WebSecurityAppInitializer() {
		super(WebSecurityConfig.class);
	}
}