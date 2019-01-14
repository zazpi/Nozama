<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/addProduct.css">
<fmt:bundle basename="resources.View">
<div class=content id="addProduct">
	<form:form method="POST"
    	action="/api/product/new" modelAttribute="productmodel"
    	id="addproduct" cssClass="product-formfill">
		<header>
			<h2><fmt:message key="addProduct.pageName"/></h2>
		</header>
		<div class="addproduct-data">
		<form:label path="id"><fmt:message key="addProduct.productModelId"/></form:label>
		<form:input path="id" required="required"/>

		<form:label path="name"><fmt:message key="addProduct.productModelName"/></form:label>
		<form:input path="name" required="required"/><br>
		</div>

		<label><fmt:message key="addProduct.size"/></label>
		<div class="addproduct-metrics">
		<form:label path="x"><fmt:message key="addProduct.x"/></form:label>
		<form:input path="x" required="required"/>
		<form:label path="y"><fmt:message key="addProduct.y"/></form:label>
		<form:input path="y" required="required"/>
		<form:label path="z"><fmt:message key="addProduct.z"/></form:label>
		<form:input path="z" required="required"/>
		<form:label path="weight"><fmt:message key="addProduct.weight"/></form:label>
		<form:input path="weight" required="required"/><br>
		</div>
			<div class="addproduct-description">
				<form:label path="description"><fmt:message key="addProduct.productModelDescription"/></form:label>
				<!-- <textarea placeholder="Write the description"
                style="width:50%; height:10em;" required></textarea><br/><br/> -->
				<form:textarea path="description" required="required"></form:textarea><br>
			</div>
		<input type="submit" value="<fmt:message key='addProduct.addProduct'/>" id="submit-btn"/>
		
	</form:form>
</div>
</fmt:bundle>