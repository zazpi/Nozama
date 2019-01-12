

//create Tabulator on DOM element with id "example-table"
const productsTable = new Tabulator("#product-list-table", {
	height:205, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
	ajaxURL: "/api/product/list", //assign data to table
	layout:"fitColumns", //fit columns to width of table (optional)
	columns:[ //Define Table Columns
		{title:"ID", field:"id", align: "center", width: 100},
		{title:"Name", field:"name",},
		{title:"Description", field:"description"},
		{title:"Stock", field:"stock"}
	],
	rowClick:function(e, row){ //trigger an alert message when the row is clicked
		alert("Row " + row.getData().id + " Clicked!!!!");
	},
});
