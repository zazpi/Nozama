<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=content id="productList">
	<div id="products">
		<table id="productTable" class="display">
			<thead>
				<tr>
					<th></th>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div id="buttons">
		<button>Add stock</button>
		<button>-</button>
		<button>Edit</button>
		<a href="/productList/addProduct">+</a>
	</div>
	
</div>