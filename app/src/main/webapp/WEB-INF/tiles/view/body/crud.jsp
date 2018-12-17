<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=content id="crud">
	<form:form method="POST"
    	action="processForm" modelAttribute="productmodel"
    	id="productform">
    	<h3>Insert/Edit</h3>
    	<table>
    		<tr>
            	<td><form:label path="id">Id</form:label></td>
                <td><form:input path="id" required="required"/></td>
            </tr>
    		<tr>
            	<td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" required="required"/></td>
            </tr>
    		<tr>
            	<td><form:label path="description">Description</form:label></td>
                <td><form:input path="description" required="required"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
    	</table>
	</form:form>
	<div id="table">
		<h3>List</h3>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td> ${product.id} </td>
					<td> ${product.name} </td>
					<td> ${product.description} </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</div>