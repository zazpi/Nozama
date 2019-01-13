const ordersTable = new Tabulator("#orders-table", {
	height:205,
	ajaxURL: "/api/order/list", //assign data to table
	layout:"fitColumns", //fit columns to width of table (optional)
	columns:[ //Define Table Columns
		{title:"ID", field:"id", align: "center", width: 100},
		{title:"Destination", field:"destination"},
		{title:"Entry Date", field:"entryDate"},
		{title:"Entry Date", field:"suborders"}
	],
	rowClick:function(e, row){ //trigger an alert message when the row is clicked
		alert("Row " + row.getData().id + " Clicked!!!!");
	},
});