<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/listSections.css">
<link rel="stylesheet" href="/static/css/orderList.css">
<fmt:bundle basename="resources.View">
<div class="list">
    <header class="list-header">
        <h2><fmt:message key="orderList.pageName"/></h2>
        <nav class="opt-btns">
            <a href="/orderList/addOrder"><fmt:message key="orderList.add"/></a>
        </nav>
    </header>
    <div class="table-container">
	    <div id="order-list-table"></div>
	    <div id="subOrder-list-table"></div>
    </div>
</div>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
<script src="/static/js/orderList.js"></script>