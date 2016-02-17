package model.logica;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaAlteracao extends PessoaEntrada {

	@Override
	protected void grava(PessoaDAO dao, Pessoa pessoa) {
		dao.atualiza(pessoa);
	}
	
}
