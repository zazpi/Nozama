<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="resources.View">
<link rel="stylesheet" href="/static/css/product.css">
<section class="product">
	<div id="productInfo">
		<table>
			<tr>
				<th><fmt:message key="product.id"/></th>
				<th><fmt:message key="product.name"/></th>
				<th><fmt:message key="product.description"/></th>
				<th><fmt:message key="product.size"/></th>
				<th><fmt:message key="product.weight"/></th>
				<th><fmt:message key="product.desiredStock"/></th>
			</tr>
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.x}x${product.y}x${product.x}</td>
				<td>${product.weight}</td>
				<td>${product.minStock}-${product.maxStock}</td>
			</tr>
		</table>
	</div>
	<div class="header-content" id="timeseriesGraph">
		<header>
            <h2><fmt:message key="product.history"/></h2>
        </header>
        <div id="timeseries"></div>
	</div>
	<div class="header-content" id="piechartGraph">
		<header>
            <h2><fmt:message key="product.stockPerProduct"/></h2>
        </header>
        <div id="piechart"></div>
	</div>
	<div class="header-content" id="mapGraph">
		<header>
            <h2><fmt:message key="product.orderDestination"/></h2>
        </header>
        <div id="map"></div>
	</div>
</section>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/maps/modules/map.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/countries/es/es-all.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>

<script src="/static/js/product.js"></script>
<script>
	loadData(${product.id},${product.minStock},${product.maxStock});
</script>