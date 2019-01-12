<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="/static/css/vendors/normalize.css">
		<link rel="stylesheet" href="/static/css/vendors/Grid.css">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
        crossorigin="" />
		<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400" rel="stylesheet">
	    <link rel="stylesheet" href="/static/css/layout.css">
	    <link rel="stylesheet" href="/static/css/general.css">
	    <link rel="stylesheet" href="/static/css/productList.css">

	    <!-- Datatables -->
	</head>
	<body>
		<!-- Header -->
	<section class="section-header">
	</section>
	<section class="section-layout">

                <tiles:insertAttribute name="header" />

			<!-- Aside -->
			<tiles:insertAttribute name="aside" />
			<!-- Body -->
			<div class="main">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Footer -->

			<tiles:insertAttribute name="footer" />
	</section>
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
		<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
		crossorigin=""></script>
		<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
		<script src="https://unpkg.com/ionicons@4.5.0/dist/ionicons.js"></script>
		<script src="/static/js/general.js"></script>
		<script src="/static/js/client-api.js"></script>
		<script src="/static/js/orderList.js"></script>
		<script src="/static/js/productList.js"></script>
	</body>
</html>