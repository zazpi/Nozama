<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/general.css">
<section class="general">
    <div class="header-content">
        <h2><fmt:message key="general.info"/></h2>
        <div class="map-container">
            <div id="map"></div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/wordcloud.js"></script>
<script src="/static/js/general.js"></script>
