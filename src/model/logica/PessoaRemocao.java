package model.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaRemocao implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa p = new Pessoa();
		p.setId(id);
		PessoaDAO dao = new PessoaDAO();
		dao.exclui(p);
		dao.fechaConexao();
		return "mvc?logica=PessoaLista";
	}

}
