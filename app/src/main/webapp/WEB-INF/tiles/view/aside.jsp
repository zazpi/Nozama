<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="resources.View">
<div id="menu">
    <span class="dropbtn">Menu</span>
    <nav class="menu-content">
        <a href="/"><fmt:message key="aside.general"/></a>
        <a href="/orderList"><fmt:message key="aside.orderList"/></a>
        <a href="/productList"><fmt:message key="aside.productList"/></a>
        <a href="/dashboard">Dashboard</a>
        <a href="/simulator"><fmt:message key="aside.simulator"/></a>
        <!--<div id="languages">
			<select class="language-content">
	    	<option><fmt:message key="language.eu"/></option>
	    	<option><fmt:message key="language.es"/></option>
	    	<option><fmt:message key="language.en"/></option>
    		</select>
		</div>-->
        <a href="/logout"><fmt:message key="aside.logout"/></a>
    </nav>
</div>
</fmt:bundle>

 