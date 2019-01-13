<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="/static/css/vendors/normalize.css">
		<link rel="stylesheet" href="/static/css/vendors/Grid.css">
		<link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400" rel="stylesheet">
	    <link rel="stylesheet" href="/static/css/layout.css">
	</head>
	<body>
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
		<script src="https://unpkg.com/ionicons@4.5.0/dist/ionicons.js"></script>
	</body>
</html>