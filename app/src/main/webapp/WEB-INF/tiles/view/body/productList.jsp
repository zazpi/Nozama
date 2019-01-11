<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=product-list id="productList">
	<header class="product-list-header">
		<h2>Product List</h2>
	</header>
	<div id="products" class="product-list-content">
		<table id="productTable" class="display">
			<thead>
				<tr>
					<th></th>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Stock</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="buttons" class="product-list-btns">
		<div id="add-stock">Add stock</div>
		<div id="remove-product">Remove product</div>
		<div id="edit">Edit</div>
		<a href="/productList/addProduct">Add new product</a>
	</div>
</div>