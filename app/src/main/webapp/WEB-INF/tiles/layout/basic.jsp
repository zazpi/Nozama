<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
		<link rel="stylesheet" href="/static/css/layout.css">
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
		<script src="/static/js/menu.js"></script>
	</body>
</html>