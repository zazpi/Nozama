<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://unpkg.com/tabulator-tables@4.1.4/dist/css/tabulator.min.css" rel="stylesheet">
<link rel="stylesheet" href="/static/css/listSections.css">
<fmt:bundle basename="resources.View">
<div class="list">
    <header class="list-header">
        <h2><fmt:message key="orderList.pageName"/></h2>
        <nav class="opt-btns">
            <a href="#"><fmt:message key="orderList.add"/></a>
            <a href="#"><fmt:message key="orderList.edit"/></a>
            <a href="#"><fmt:message key="orderList.remove"/></a>
        </nav>
    </header>
    <div class="table-container">
    <div id="order-list-table"></div>
    </div>
</div>
</fmt:bundle>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.1.4/dist/js/tabulator.min.js"></script>
<script src="/static/js/orderList.js"></script>