<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="product">
    <div class="dashboards-section">
        <div class="dashboards">
            <div id="timeseries"></div>
            <div id="piechart"></div>
            <div id="map"></div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/maps/modules/map.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/countries/es/es-all.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>

<script src="/static/js/product.js"></script>
<script>
	loadData(${productId});
</script>