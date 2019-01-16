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
    height: 460,
    ajaxURL: "/api/order/list",
    layout: "fitColumns",
    tooltips: true,
    addRowPos: "top",
    pagination: "local",
    paginationSize: 18,
    columns: [
        {title: "ID", field: "id", align: "center", width: 100},
        {title: "Destination", field: "destination"},
        {title: "Entry Date", field: "entryDate"}
    ],
    rowClick:function(e, row){
    	ordersProductsTable.replaceData("/api/order/subOrderList?orderId="+row.getData().id);
    }
});

const ordersProductsTable = new Tabulator("#subOrder-list-table", {
    height: 460,
    ajaxURL: "/api/order/subOrderList?orderId=1",
    layout: "fitColumns",
    tooltips: true,
    addRowPos: "top",
    pagination: "local",
    paginationSize: 18,
    groupBy: "subOrderId",
    groupHeader: function(value, count, data, group){
    	console.log(data);
    	return data[0].origin;
    },
    columns: [
    	{title: "ID", field: "subOrderId", align: "center", width: 100},
        {title: "Product model ID", field: "productModelId", align: "center"},
        {title: "Name", field: "name"},
        {title: "Ready", field: "ready", formatter: "tickCross"}
        ]
});

