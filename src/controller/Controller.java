package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.logica.Logica;


@WebServlet("/mvc")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeLogica = "model.logica." 
					+ request.getParameter("logica");
		try {
			Class<?> classe = Class.forName(nomeLogica);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
