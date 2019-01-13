const productsTable = new Tabulator("#product-list-table", {
    height: 400,
    ajaxURL: "/api/product/list",
    layout: "fitColumns",
    tooltips: true,
    addRowPos: "top",
    history: true,
    pagination: "local",
    paginationSize: 15,
    layoutColumnsOnNewData: true,
    columns: [
        {title: "ID", field: "id", align: "center", width: 100},
        {title: "Name", field: "name",},
        {title: "Description", field: "description"},
        {title: "Stock", field: "stock"}
    ],
    /*rowClick:function(e, row){ //trigger an alert message when the row is clicked
        alert("Row " + row.getData().id + " Clicked!!!!");
    },*/
});
