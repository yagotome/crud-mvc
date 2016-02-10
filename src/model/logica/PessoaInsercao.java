package model.logica;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaInsercao extends PessoaEntrada {

	@Override
	protected void grava(Pessoa pessoa) {
		PessoaDAO dao = new PessoaDAO();
		dao.insere(pessoa);
		dao.fechaConexao();
	}	

}
