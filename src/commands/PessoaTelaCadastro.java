package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaTelaCadastro implements Command {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return "/WEB-INF/jsp/cadastro.jsp";
	}

}
