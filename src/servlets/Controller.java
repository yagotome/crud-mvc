package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;


@WebServlet("/mvc")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCommand = "commands." 
					+ request.getParameter("command");
		try {
			Class<?> classe = Class.forName(nomeCommand);
			Command command = (Command) classe.newInstance();
			String pagina = command.executa(request, response);						
			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
		}
	}
}
