package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		request.setAttribute("connection", connection);
		chain.doFilter(request, response);
		try {
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
