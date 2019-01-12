<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=product-list id="productList">
	<header class="product-list-header">
		<h2>Product List</h2>
			<nav>
				<a href="#" id="add-product">Add</a>
				<a href="#" id="delete-btn">Delete</a>
				<a href="#" id="edit">Edit</a>
				<a href="#" id="add-stock">Add stock</a>
			</nav>
	</header>
	<div class="table-container">
	<div id="product-list-table"></div>
	</div>
</div>