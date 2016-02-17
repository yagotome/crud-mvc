<!DOCTYPE html>
<html>
<head>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<meta charset="utf-8">
	<title>Página inicial</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp" />
	<h2>Bem vindos ao crud-mvc.</h2>
	<h4>Aqui você vai poder cadastrar, alterar, remover e listar pessoas.</h4>	
	<button id="bCadastro">Cadastro</button>
	<button id="bAlteracao">Alteração</button>
	<button id="bListagem">Listagem</button>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
<script type="text/javascript">
	document.getElementById("bCadastro").onclick = function() {
		document.location.href = "mvc?command=PessoaTelaCadastro";
	}
	document.getElementById("bAlteracao").onclick = function() {
		document.location.href = "mvc?command=PessoaTelaAlteracao";
	}
	document.getElementById("bListagem").onclick = function() {
		document.location.href = "mvc?command=PessoaLista";
	}
</script>

</html>