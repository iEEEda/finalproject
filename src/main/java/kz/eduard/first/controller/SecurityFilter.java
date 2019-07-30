package kz.eduard.first.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/jsp/*"}, initParams = { @WebInitParam(name = "INDEX_PATH", value = "/index.jsp") })
public class SecurityFilter implements Filter {
  private String indexPath;
  public void init(FilterConfig filterConfig) throws ServletException {
      indexPath = filterConfig.getInitParameter("INDEX_PATH");
  }
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.sendRedirect(request.getContextPath() + indexPath);
    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {}
}