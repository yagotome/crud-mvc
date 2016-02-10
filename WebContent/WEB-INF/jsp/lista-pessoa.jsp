<!DOCTYPE html>
<html>
<head>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<meta charset="utf-8">
	<title>Listagem de pessoas</title>
	<style type="text/css">
		td {
			margin: 5px 20px;
		}
	</style>
	<script type="text/javascript">		
		function exclui(id, nome) {
			var ok = confirm("Deseja realmente excluir "+ nome +"?");
			if (ok){
				window.location.href = 'mvc?logica=PessoaRemocao&id=' + id;
			}
		}
		function altera(id, nome, email, nasc, sexo) {
			window.location.href = 'mvc?logica=PessoaTelaAlteracao&id=' + id
					+ '&nome=' + nome + '&email=' + email 
					+ '&nasc=' + nasc + '&sexo=' + sexo;
		}
	</script>
</head>
<body>
	<c:import url="header.jsp" />
	<table>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Idade</td>
			<td>Data de nascimento</td>
			<td>Sexo</td>
			<td>Excluir</td>			
			<td>Alterar</td>
		</tr>
		<c:forEach var="pessoa" items="${pessoas}">
			<tr>
				<td>${pessoa.id}</td>
				<td>${pessoa.nome}</td>
				<td>${empty pessoa.email ? 'E-mail não informado' : pessoa.email}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pessoa.dataNascimento.time}"/></td>
				<td>${pessoa.sexo}</td>				
				<td style="text-align: center;">
					<button onclick="exclui('${pessoa.id}', '${pessoa.nome}')">X</button>
				</td>
				<td style="text-align: center;">
					<button onclick="altera('${pessoa.id}', '${pessoa.nome}', '${pessoa.email}'
							, '<fmt:formatDate pattern="yyyy-MM-dd" value="${pessoa.dataNascimento.time}"/>'
							, '${pessoa.sexo}')">
						&#10004;
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>	
	<c:import url="footer.jsp" />
</body>
</html>