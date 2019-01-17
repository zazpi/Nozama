<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/addOrder.css">
<fmt:bundle basename="resources.View">
<div class=content id="addOrder">
	<form:form method="POST"
    	action="/api/product/add" modelAttribute="orders"
    	id="addorder" cssClass="product-formfill">
		<header>
			<h2><fmt:message key="addOrder.pageName"/></h2>
		</header>
		<div class="form-container">
			<label id="searchLabel"><fmt:message key="addOrder.searchProduct"/></label>
			<input id="searchInput"/>
		</div>
		<div class="table-container">
			<div id="product-list-table"></div>
			<div id="order-table"></div>
		</div>
		<input type="submit" value="<fmt:message key='addOrder.addOrder'/>" id="submit-btn"/>
	</form:form>
	</div>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
<script src="/static/js/addOrder.js"></script>