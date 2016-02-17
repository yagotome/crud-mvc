package commands;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaInsercao extends PessoaEntrada {

	@Override
	protected void grava(PessoaDAO dao, Pessoa pessoa) {
		dao.insere(pessoa);
	}	

}
