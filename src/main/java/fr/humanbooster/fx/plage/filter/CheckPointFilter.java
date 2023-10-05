package fr.humanbooster.fx.plage.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // Premier filtre à exécuter lorsque le serveur reçoit une requête HTTP
public class CheckPointFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// On enrichit l'objet request avec un nouvel attribut msDepart
		Date date = new Date();
		System.out.println(date + " passage dans CheckPointFilter");
		((HttpServletRequest) request).setAttribute("msDepart", date.getTime());
		// On passe la main
		chain.doFilter(request, response);

	}

}
