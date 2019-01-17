$(document).ready(() => {
    const productsTable = new Tabulator("#product-list-table", {
        height: 301,
        ajaxURL: "/api/product/list",
        layout: "fitColumns",
        tooltips: true,
        addRowPos: "top",
        history: true,
        pagination: "local",
        paginationSize: 10,
        movableRows:true,
        movableRowsReceiver: "insert",
        movableRowsSender: "delete",
        movableRowsConnectedTables: "#order-table",
        columns: [
            {title: "ID", field: "id", align: "center", width: 100},
            {title: "Name", field: "name"},
            {title: "Description", field: "description"},
            {formatter:printIcon, width:40, align:"center"}
        ],
        rowClick:function(e, row){
        	orderProducts.addRow(row.getData(),true);
        	row.delete();}
    });
    const orderProducts = new Tabulator("#order-table", {
        height: 301,
        ajaxURL: "",
        layout: "fitColumns",
        tooltips: true,
        addRowPos: "top",
        history: true,
        pagination: "local",
        paginationSize: 10,
        movableRows:true,
        movableRowsReceiver: "insert",
        movableRowsSender: "delete",
        movableRowsConnectedTables: "#product-list-table",
        columns: [
            {title: "ID", field: "id", align: "center", width: 100},
            {title: "Name", field: "name"},
            {title: "Description", field: "description"},
            {formatter:printIcon, width:40, align:"center"}
        ],
        rowClick:function(e, row){
        	productsTable.addRow(row.getData(),true);
        	row.delete();}
    });
    var printIcon = function(cell, formatterParams, onRendered){ 
        return "<i class='fa fa-print'></i>";
    };
    $("#searchInput").keyup(function(){
    	var inp = $("#searchInput");
    	//productsTable.setFilter("name","like",inp.val());
    	var val = inp.val();
    	productsTable.setFilter([[{field:"name", type:"like", value:val},
    		                      {field:"description", type:"like", value:val},
    		                      {field:"id", type:"like", value:val}]]);
    });
    
    const redirect = async () => {
    	window.location.replace("/orderList");
    }
    $("#submit-btn").click(function(){
    	destination =  $("#destinationInput").val();
    	if(destination == "") return;
    	products = "&products=";
    	$.each(orderProducts.getData(), function( index, value ) {
    		if(index != 0)
    			products = products + ",";
    		products = products + value.id;
    	});
    	url = "/api/order/new?destination=" + destination + products;
    	console.log(url);
    	$.get(url,redirect());
    	
    	
    });
});
