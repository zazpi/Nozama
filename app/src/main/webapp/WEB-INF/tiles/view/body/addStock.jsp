<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/addStock.css">
<link rel="stylesheet" href="/static/css/calendar.css">
<div class=content id="addStock">
    <form:form method="POST"
               action="/api/stock/add" modelAttribute="productstack"
               id="addstock" cssClass="product-formfill">

        <header>
            <h2><fmt:message key="addStock.pageName"/></h2>
        </header>

        <div class="form-container">
            <form:label path="model.id"><fmt:message key="productList.id"/></form:label>
            <form:input path="model.id" required="required"/>

            <form:label path="stock"><fmt:message key="addStock.quantity"/></form:label>
            <form:input path="stock" required="required"/>

            <form:label path="shelf.id2"><fmt:message key="addStock.warehouse"/></form:label>
            <form:select path="shelf.id2" items="${warehouses}" itemLabel="name" itemValue="id"></form:select>


            <form:label path="shelf.id"><fmt:message key="addStock.shelfPosition"/></form:label>
            <form:input path="shelf.id" required="required"/>

            <label><fmt:message key="addStock.entryDate"/></label>
            <input name="todays_date" onfocus="showCalendarControl(this);" type="text" required="required"><br>
        </div>

        <input type="submit" value="<fmt:message key="addStock.addStock"/>" id="submit-btn"/><br>
    </form:form>
</div>
<script src="/static/js/calendar.js"></script>