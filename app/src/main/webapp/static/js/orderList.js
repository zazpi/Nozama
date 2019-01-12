const ordersTable = new Tabulator("#orders-table", {
	height:205, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
	ajaxURL: "/api/order/list", //assign data to table
	layout:"fitColumns", //fit columns to width of table (optional)
	columns:[ //Define Table Columns
		{title:"ID", field:"id", align: "center", width: 100},
		{title:"Origin", field:"origin",},
		{title:"Destination", field:"destination"},
		{title:"Entry Date", field:"entrydate"},
		{title:"Departure Date", field:"deperturedate"}
	],
	rowClick:function(e, row){ //trigger an alert message when the row is clicked
		alert("Row " + row.getData().id + " Clicked!!!!");
	},
});