package model.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaTelaCadastro implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return "/WEB-INF/jsp/cadastro.jsp";
	}

}
