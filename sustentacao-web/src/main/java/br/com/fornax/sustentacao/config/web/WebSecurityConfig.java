package br.com.fornax.sustentacao.config.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fornax.sustentacao.config.dao.ConfigDAO;
import br.com.fornax.sustentacao.config.service.ConfigService;

@Configuration
@EnableWebSecurity
@Import({ ConfigDAO.class, ConfigService.class })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.
		jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("select login as usuario,senha as senha, ativo as enabled from usuario where login = ? ")
		.authoritiesByUsernameQuery(
						"select u.codigo_usuario as usuario, p.descricao as authority from perfil p, usuario u where"
								+ " u.codigo_perfil = p.codigo_perfil and u.login = ?")
				.getUserDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/painel/**").authenticated().antMatchers("/").access("permitAll")
				.antMatchers("/403/").access("permitAll").and().formLogin().usernameParameter("login")
				.passwordParameter("senha").loginPage("/").loginProcessingUrl("/autenticar").failureUrl("/")
				.defaultSuccessUrl("/painel/").and().logout().deleteCookies("remove").invalidateHttpSession(false)
				.logoutUrl("/logout/").logoutSuccessUrl("/")
				// habilitar depois, estudar os problemas com chamadas AJAX
				.and().csrf().disable().exceptionHandling().accessDeniedPage("/403/");
		// controla o numero de sesssoes por usuario, neste caso 1 sessao ativa
		// por usuario.
		http.sessionManagement().maximumSessions(1).expiredUrl("/logout/");
	}
}