package model.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import model.dao.PessoaDAO;

abstract class PessoaEntrada implements Logica {
	
	@Override
	public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("data_nascimento");
		String sexo = request.getParameter("sexo");
		Pessoa pessoa = new Pessoa();
		if (id != null) {
			pessoa.setId(Integer.parseInt(id));
		}
		pessoa.setNome(nome);		
		pessoa.setEmail(email);
		try {
			Date date =	new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			pessoa.setDataNascimento(calendar);
		} catch (ParseException e) {
			throw new RuntimeException("Erro de conversão da data"); 
		}
		pessoa.setSexo(sexo);
		
		Connection connection = (Connection) request.getAttribute("connection");
		grava(new PessoaDAO(connection), pessoa);
		
		return "mvc?logica=PessoaLista";
	}
	
	protected abstract void grava(PessoaDAO dao, Pessoa pessoa);
	
}
