package com.tophire.boot;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tophire.config.TophireRootConfig;
import com.tophire.config.TophireWebConfig;

public class TopHireDispatcherServletIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {TophireRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {TophireWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"*.htm"};
	}

}
