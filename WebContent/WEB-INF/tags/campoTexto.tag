<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="id" required="true"%>
<%@attribute name="label"%>
<%@attribute name="type"%>
<%@attribute name="name"%>
<%@attribute name="value"%>
<div>
	<c:if test="${not empty label}">
		<label for="${id}">${label}</label>
	</c:if>
	<input type="${empty type ? 'text' : type}" value="${value}"
			id="${id}" name="${empty name ? id : name}">
</div>