<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zazpi.nozama.model.ProductModel" %>
<link rel="stylesheet" href="/static/css/addProduct.css">
<div class=content id="editProduct">
    <form:form method="POST"
               action="/api/product/update" modelAttribute="productmodel"
               id="editProduct" cssClass="product-formfill">
        <header>
            <h2>Product Form Fill</h2>
        </header>
        <div class="addproduct-data">
            <form:label path="id">Product model ID:</form:label>
            <form:input path="id" required="required" value="${requestScope.product.id}"/>

            <form:label path="name">Product model name:</form:label>
            <form:input path="name" required="required" value="${requestScope.product.name}"/><br>
        </div>

        <label><b>Size</b></label>
        <div class="addproduct-metrics">
            <form:label path="x">X:</form:label>
            <form:input path="x" required="required" value="${requestScope.product.x}"/>
            <form:label path="y">Y:</form:label>
            <form:input path="y" required="required" value="${requestScope.product.y}"/>
            <form:label path="z">Z:</form:label>
            <form:input path="z" required="required" value="${requestScope.product.z}"/>
            <form:label path="weight">Weight:</form:label>
            <form:input path="weight" required="required" value="${requestScope.product.weight}"/><br>
        </div>
        <div class="addproduct-description">
            <form:label path="description">Product model description:</form:label>
            <!-- <textarea placeholder="Write the description"
            style="width:50%; height:10em;" required></textarea><br/><br/> -->
            <form:textarea path="description" required="required" value="${requestScope.product.description}"></form:textarea><br>
        </div>
        <input type="submit" value="Edit product" id="submit-btn"/>

    </form:form>
</div>