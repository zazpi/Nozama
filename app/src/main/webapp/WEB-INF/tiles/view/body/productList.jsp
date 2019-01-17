<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/listSections.css">
<fmt:bundle basename="resources.View">
<section class="list">
	<header class="list-header">
		<h2><fmt:message key="productList.pageName"/></h2>
			<nav class="opt-btns">
				<a href="/productList/addProduct" id="add-product"><fmt:message key="productList.addNewProduct"/></a>
				<a href="/productList/addStock" id="add-stock"><fmt:message key="productList.addStock"/></a>
			</nav>
	</header><br>
	<div class="searchSection">
		<label id="searchLabel">Search: </label>
		<input id="serachInput"/>
	</div>
	<div class="table-container">
	<div id="product-list-table"></div>
	</div>
</section>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
<script src="/static/js/productList.js"></script>