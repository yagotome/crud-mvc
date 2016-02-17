package commands;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaAlteracao extends PessoaEntrada {

	@Override
	protected void grava(PessoaDAO dao, Pessoa pessoa) {
		dao.atualiza(pessoa);
	}
	
}
