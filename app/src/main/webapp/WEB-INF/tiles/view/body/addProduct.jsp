<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=content id="addProduct">
	<form:form method="POST"
    	action="/api/product/new" modelAttribute="productmodel"
    	id="addproduct">
	
		<form:label path="id">Product model ID:</form:label>
		<form:input path="id" required="required"/>
		
		<form:label path="name">Product model name:</form:label>
		<form:input path="name" required="required"/><br>
		
		<form:label path="description">Product model description:</form:label>
		<!-- <textarea placeholder="Write the description"
		style="width:50%; height:10em;" required></textarea><br/><br/> -->
		<form:textarea path="description" required="required"></form:textarea><br>
		
		<label><b>Size</b></label>
		<form:label path="x">X:</form:label>
		<form:input path="x" required="required"/>
		<form:label path="y">Y:</form:label>
		<form:input path="y" required="required"/>
		<form:label path="z">Z:</form:label>
		<form:input path="z" required="required"/>
		<form:label path="weight">Weight:</form:label>
		<form:input path="weight" required="required"/><br>
		
		<input type="submit" value="Add product"/>
		
	</form:form>
	
</div>