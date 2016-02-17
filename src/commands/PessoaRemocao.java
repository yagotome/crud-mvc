package commands;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaRemocao implements Command {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		Connection connection = (Connection) request.getAttribute("connection");
		PessoaDAO dao = new PessoaDAO(connection);
		dao.exclui(pessoa);
		return "mvc?command=PessoaLista";
	}

}
