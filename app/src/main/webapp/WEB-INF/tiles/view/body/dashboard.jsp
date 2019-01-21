<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/static/css/dashboard.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section class="dashboard">
    <div id="map-heatmap">
        <div id="heatmapGraph">
            <header>
                <h2><fmt:message key="dashboard.orderPeriod"/></h2>
            </header>
            <div id="heatmap"></div>
        </div>
        <div id="mapGraph">
            <header>
                <h2><fmt:message key="dashboard.orderDestination"/></h2>
            </header>
            <div id="map"></div>
        </div>
    </div>
    <div id="gauges">
        <div id="gaugeGraph1">
            <header>
                <h2><fmt:message key="dashboard.generalGauge"/></h2>
            </header>
            <div id="gauge0"></div>
        </div>
        <div id="gaugeGraph2">
            <header>
                <h2><fmt:message key="dashboard.warehouse1Gauge"/></h2>
            </header>
            <div id="gauge1"></div>
        </div>
        <div id="gaugeGraph3">
            <header>
                <h2><fmt:message key="dashboard.warehouse2Gauge"/></h2>
            </header>
            <div id="gauge2"></div>
        </div>
    </div>
    <div id="timeseriesGraph">
        <header>
            <h2><fmt:message key="dashboard.timeseries"/></h2>
        </header>
        <div id="timeseries"></div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/maps/modules/map.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/countries/es/es-all.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/heatmap.js"></script>
<script src="https://code.highcharts.com/modules/solid-gauge.js"></script>


<script src="/static/js/dashboard.js"></script>