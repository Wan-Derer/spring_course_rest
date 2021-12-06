package com.zaurtregulov.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//  @Override
//  public void onStartup(ServletContext servletContext) throws ServletException {
//    super.onStartup(servletContext);
//
//    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//    encodingFilter.setEncoding("utf-8");
//    encodingFilter.setForceEncoding(true);
//
//    FilterRegistration.Dynamic filterReg = servletContext.addFilter("encoding-filter", encodingFilter);
//
//    filterReg.addMappingForUrlPatterns(null, true, "/*");
//
//  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{MyConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
