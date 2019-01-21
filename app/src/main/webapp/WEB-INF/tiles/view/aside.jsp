<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="menu">
    <span class="dropbtn">Menu</span>
    <nav class="menu-content">
        <a href="/"><fmt:message key="aside.general"/></a>
        <a href="/orderList"><fmt:message key="aside.orderList"/></a>
        <a href="/productList"><fmt:message key="aside.productList"/></a>
        <a href="/dashboard"><fmt:message key="aside.monitoring"/></a>
        <a href="/simulator"><fmt:message key="aside.simulator"/></a>
        <select id="locales" class="locales">
            <option disabled selected value><fmt:message key="language.change"/></option>
            <option value="es"><fmt:message key="language.es"/></option>
            <option value="en"><fmt:message key="language.en"/></option>
            <option value="eu"><fmt:message key="language.eu"/></option>
        </select>
        <a href="/logout"><fmt:message key="aside.logout"/></a>
    </nav>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/locale.js"></script>

 