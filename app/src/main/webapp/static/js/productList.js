$(document).ready( function () {	
    $('#productTable').DataTable({
    	ajax: {
    		url: "/api/product/list",
    		dataSrc: ""
    	}, 
    	columns: [
    		{
    			"defaultContent": "<input type='radio' value=''/>"
    		},
    		{
    			data:"id"
    		},
    		{
    			data:"name"
    		},
    		{
    			data:"description"
    		},
    		{
    			data:"stock"
    		}
    	],
    	scrollY: 335
    });
} );