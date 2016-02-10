<%@attribute name="id" required="true" %>
<%@attribute name="value"%>
<div>
	<label for="${id}">Sexo:* </label>		
	<select id="${id}" name="${id}" required>
		<option value="">Selecione</option>
		<option value="Masculino" ${value == 'Masculino' ? 'selected' : ''}>Masculino</option>
		<option value="Feminino" ${value == 'Feminino' ? 'selected' : ''}>Feminino</option>
	</select>	
</div>