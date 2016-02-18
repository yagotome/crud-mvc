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
		function post(path, params, method) {
		    method = method || "post"; // Set method to post by default if not specified.
	
		    // The rest of this code assumes you are not using a library.
		    // It can be made less wordy if you use one.
		    var form = document.createElement("form");
		    form.setAttribute("method", method);
		    form.setAttribute("action", path);
	
		    for(var key in params) {
		        if(params.hasOwnProperty(key)) {
		            var hiddenField = document.createElement("input");
		            hiddenField.setAttribute("type", "hidden");
		            hiddenField.setAttribute("name", key);
		            hiddenField.setAttribute("value", params[key]);
	
		            form.appendChild(hiddenField);
		         }
		    }
	
		    document.body.appendChild(form);
		    form.submit();
		}
		function exclui(id, nome) {
			var ok = confirm("Deseja realmente excluir "+ nome +"?");
			if (ok){
				window.location.href = 'mvc?command=PessoaRemocao&id=' + id;
			}
		}
		function altera(id, nome, email, nasc, sexo) {
			var params = {
					"command" : "PessoaTelaAlteracao",
					"id" : id,
					"nome" : nome,
					"email" : email,
					"nasc" : nasc,
					"sexo" : sexo
			}
			post("mvc", params);
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