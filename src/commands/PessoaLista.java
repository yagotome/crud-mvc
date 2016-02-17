package commands;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaLista implements Command {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("connection");		
		List<Pessoa> pessoas = new PessoaDAO(connection).getLista();
		request.setAttribute("pessoas", pessoas);
		return "/WEB-INF/jsp/lista-pessoa.jsp";
	}

}
