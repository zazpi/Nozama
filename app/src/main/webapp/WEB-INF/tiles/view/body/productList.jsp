<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/listSections.css">
<section class="list">
	<header class="list-header">
		<h2>Product List</h2>
			<nav class="opt-btns">
				<a href="#" id="add-product">Add</a>
				<a href="#" id="delete-btn">Delete</a>
				<a href="#" id="edit">Edit</a>
				<a href="#" id="add-stock">Add stock</a>
			</nav>
	</header>
	<div class="table-container">
	<div id="product-list-table"></div>
	</div>
</section>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
<script src="/static/js/productList.js"></script>