<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
        crossorigin="" />
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400" rel="stylesheet">
	    <link rel="stylesheet" href="/static/css/layout.css">
	    <link rel="stylesheet" href="/static/css/general.css">
	</head>
	<body>
		<!-- Header -->
   		<div id="header">
   			<tiles:insertAttribute name="header" />
   		</div>

		<div id="layout">
			<a href="#menu" id="menuLink" class="menu-link">
		        <!-- Hamburger icon -->
		        <span></span>
    		</a>
			<!-- Aside -->
			<tiles:insertAttribute name="aside" />
			<!-- Body -->
			<div id="main">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Footer -->
			<!-- <tiles:insertAttribute name="footer" /> -->
		</div>
		<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
		crossorigin=""></script>
		<script src="https://cdn.jsdelivr.net/npm/vega@4.3.0"></script>
		<script src="https://cdn.jsdelivr.net/npm/vega-lite@3.0.0-rc10"></script>
		<script src="https://cdn.jsdelivr.net/npm/vega-embed@3.24.1"></script>
		<script src="/static/js/menu.js"></script>
		<script src="/static/js/general.js"></script>
		<script src="/static/js/client-api.js"></script>
	</body>
</html>