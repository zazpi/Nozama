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
    selectable:1,
    dataLoaded:function(){
    	this.selectRow(1);
    },
    columns: [
        {title: "ID", field: "id", align: "center", width: 100},
        {title: "Destination", field: "destination"},
        {title: "Entry Date", field: "entryDate"},
        {title: "Sent", field: "sent", formatter: "tickCross"}
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
    	header = data[0].origin.toUpperCase();
    	departure = data[0].departureDate;
    	if(departure != null)
    		header += " (Sent: " + departure + ")";
    	return header;
    },
    columns: [
    	{title: "ID", field: "subOrderId", align: "center", width: 100},
        {title: "Product model ID", field: "productModelId", align: "center"},
        {title: "Name", field: "name"},
        {title: "Ready", field: "ready", formatter: "tickCross"}
        ]
});

