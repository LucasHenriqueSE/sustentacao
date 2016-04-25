package br.com.fornax.sustentacao.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	@Override
	  public boolean preHandle(HttpServletRequest request,
	      HttpServletResponse response,
	      Object controller) throws Exception {
	      if(request.getRequestURI().equals("/sustentacao/painel") || request.getRequestURI().equals("/sustentacao/painel/")
	    		  || request.getSession().getAttribute("usuario") != null) {
	        return true;
	      }
	      else if(request.getRequestURI().equals("/sustentacao/logout")){
	    	  request.getSession().invalidate();
	    	  request.getSession().removeAttribute("usuario");
	      }
	      	response.sendRedirect("/sustentacao/painel");
	      return false;
	  }

}
