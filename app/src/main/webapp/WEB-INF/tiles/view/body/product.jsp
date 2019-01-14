<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="product">
    <div class="dashboards-section">
        <div class="dashboards">
            <div id="highstock"></div>
            <div id="piechart"></div>
        </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/export-data.js"></script>
<script src="/static/js/product.js"></script>
<script>
	loadData(${productId});
</script>