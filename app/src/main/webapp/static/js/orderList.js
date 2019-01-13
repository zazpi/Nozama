const ordersTable = new Tabulator("#orders-table", {
    height: 205,
    ajaxURL: "/api/order/list",
    layout: "fitColumns",
    tooltips: true,
    addRowPos: "top",
    history: true,
    pagination: "local",
    paginationSize: 15,
    layoutColumnsOnNewData: true,
    columns: [
        {title: "ID", field: "id", align: "center", width: 100},
        {title: "Destination", field: "destination"},
        {title: "Entry Date", field: "entryDate"},
        {title: "Entry Date", field: "suborders"}
    ]
    /*rowClick:function(e, row){
        alert("Row " + row.getData().id + " Clicked!!!!");
    },*/
});