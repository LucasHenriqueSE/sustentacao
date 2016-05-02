package br.com.fornax.sustentacao.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitialiazer implements WebApplicationInitializer {

	@Override
	@SuppressWarnings("resource")
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Le as configuracoes do Spring que foram feitas via classe e anotacoes
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebSpringConfig.class);

		// Le as anotacoes contidas na classe do Spring
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(WebSpringConfig.class);

		// Faz com que o sistema entenda as requisicoes a partir da "/"
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}