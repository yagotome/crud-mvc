package model.logica;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaAlteracao extends PessoaEntrada {

	@Override
	protected void grava(Pessoa pessoa) {
		PessoaDAO dao = new PessoaDAO();
		dao.atualiza(pessoa);
		dao.fechaConexao();
	}
	
}
