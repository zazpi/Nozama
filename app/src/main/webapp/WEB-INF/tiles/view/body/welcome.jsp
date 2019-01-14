<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
      crossorigin="" />
<link rel="stylesheet" href="/static/css/general.css">
<fmt:bundle basename="resources.View">
<section class="general">
    <div class="row">
    <div class="header-content">
        <h2><fmt:message key="general.warehouseLocation"/></h2>
        <div class="map-container">
            <div id="map"></div>
        </div>
    </div>
    <br />
    <div class="dashboards-section">
        <header>
            <h2><fmt:message key="general.warehouseState"/></h2>
        </header>
        <div class="dashboards">
            <div id="heatmap"></div>
        </div>
    </div>
    </div>
</section>
</fmt:bundle>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
        crossorigin=""></script>
<script src="https://code.highcharts.com/maps/highmaps.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/maps/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/countries/es/es-all.js"></script>
<script src="/static/js/general.js"></script>
