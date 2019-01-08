<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class=content id="productList">
	<div id="orders">
		<table id="orderTable" class="display" style="width:100%">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Assigned warehouse</th>
					<th>Entry date</th>
					<th>Departure date</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div id="buttons">
		<button>-</button>
		<button>Edit</button>
		<button>+</button>
	</div>
	
</div>