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
        rowClick:productClick,
        columns: [
            {title: "ID", field: "id", align: "center", width: 100,rowClick:productClick},
            {title: "Name", field: "name"},
            {title: "Description", field: "description"}
        ],
        ajaxRequesting:function(url, params){
        	setTimeout(function(){productsTable.replaceData();},5000);
        }
    });
   
    function productClick(e,row){
    	
    }
});

$(document).ready(() => {
    const productsTable = new Tabulator("#order-table", {
        height: 301,
        ajaxURL: "",
        layout: "fitColumns",
        tooltips: true,
        addRowPos: "top",
        history: true,
        pagination: "local",
        paginationSize: 10,
        rowClick:productClick,
        columns: [
            {title: "ID", field: "id", align: "center", width: 100},
            {title: "Name", field: "name"},
            {title: "Description", field: "description"}
        ],
        ajaxRequesting:function(url, params){
        	setTimeout(function(){productsTable.replaceData();},5000);
        }
    });
   
    function productClick(e,row){
    	
    }
});