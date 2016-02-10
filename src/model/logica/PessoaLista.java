package model.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import model.dao.PessoaDAO;

public class PessoaLista implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> pessoas = dao.getLista();
		dao.fechaConexao();
		request.setAttribute("pessoas", pessoas);
		return "/WEB-INF/jsp/lista-pessoa.jsp";
	}

}
