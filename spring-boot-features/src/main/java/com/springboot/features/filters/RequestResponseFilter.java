package com.springboot.features.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestResponseFilter implements Filter {
	private static final Log log = LogFactory.getLog(RequestResponseFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {

		// before sending the request to the controller

		log.info("before sending the request to the controller");
		log.info("Remote Host: " + req.getRemoteHost());
		filterChain.doFilter(req, res);

		// after getting the response from controller and before sending it to
		// the client
		log.info("before sending the response to the client");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
