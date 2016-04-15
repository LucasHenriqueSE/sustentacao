package br.com.fornax.sustentacao.config.web;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSecurityAppInitializer extends AbstractSecurityWebApplicationInitializer {

	public WebSecurityAppInitializer() {
		super(WebSecurityConfig.class);
	}
}