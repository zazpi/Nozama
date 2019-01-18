<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="resources.View">
<header class="section-header">
	<div id="logo">
		<img onclick="nozamaClick()" id="nozamaLogo" src="/static/img/nozamaLogo.png">
	</div>
	<div id="languages">
		<select class="language-content">
	    	<option><fmt:message key="language.eu"/></option>
	    	<option><fmt:message key="language.es"/></option>
	    	<option><fmt:message key="language.en"/></option>
    	</select>
	</div>
	
</header>
</fmt:bundle>
<script src="/static/js/layout.js"></script>