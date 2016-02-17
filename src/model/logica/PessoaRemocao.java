package model.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaRemocao implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		Connection connection = (Connection) request.getAttribute("connection");
		PessoaDAO dao = new PessoaDAO(connection);
		dao.exclui(pessoa);
		return "mvc?logica=PessoaLista";
	}

}
