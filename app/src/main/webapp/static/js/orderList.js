// FIXME: use this as starting point for future backend communication work
/*const getProductsData = async () => {
    try {
        const result = await fetch("/api/order/list");
        const data = await result.json();
        console.log(data);
    }catch (error) {
        return "Unable to load products.";
    }
};*/

const ordersTable = new Tabulator("#order-list-table", {
    height: 400,
    ajaxURL: "/api/order/list",
    layout: "fitColumns",
    tooltips: true,
    addRowPos: "top",
    history: true,
    pagination: "local",
    paginationSize: 15,
    layoutColumnsOnNewData: true,
    // FIXME: this options above is to use with suborders but it seems we don't have that data filled yet
    dataTree:true,
    dataTreeStartExpanded:true,
    //-----------------------------------------
    columns: [
        {title: "ID", field: "id", align: "center", width: 100},
        {title: "Destination", field: "destination"},
        {title: "Entry Date", field: "entryDate"},
    ]
    /*rowClick:function(e, row){
        alert("Row " + row.getData().id + " Clicked!!!!");
    },*/
});

