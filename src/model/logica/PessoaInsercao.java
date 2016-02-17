package model.logica;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaInsercao extends PessoaEntrada {

	@Override
	protected void grava(PessoaDAO dao, Pessoa pessoa) {
		dao.insere(pessoa);
	}	

}
