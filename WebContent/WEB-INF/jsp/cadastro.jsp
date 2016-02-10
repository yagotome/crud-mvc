<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib tagdir="/WEB-INF/tags" prefix="yago" %>
	<title>
		${param.logica == 'PessoaTelaCadastro' ? 'Cadastro de uma pessoa' : 'Alteração de uma pessoa'}
	</title>
	<style>
		label {margin-right: 10px;}
	</style>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp" />
	<form action="mvc">
		<c:if test="${param.logica == 'PessoaTelaAlteracao'}">
			<yago:campoTexto label="Id:" id="id" type="number" value="${param.id}" />
			<br>
		</c:if>
		<yago:campoTexto label="Nome:" id="nome" value="${param.nome}" />
		<br>
		<yago:campoTexto label="E-mail:" type="email" id="email" value="${param.email}" />
		<br>
		<yago:campoTexto label="Data de nascimento:" type="date" id="data_nascimento" value="${param.nasc}" />		
		<br>
		<yago:comboSexo id="sexo" value="${param.sexo}" />
		<br>
		<div>
		<button name="logica" 
			value="${param.logica == 'PessoaTelaCadastro' ? 'PessoaInsercao' : 'PessoaAlteracao'}"
			>
			Salvar
		</button>
		</div>
	</form>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>