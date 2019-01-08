$(document).ready( function () {
    $('#productTable').DataTable({
    	ajax: {
    		url: "api/product/list",
    		dataSrc: ""
    	}, 
    	columns: [
    		{
    			data:"id"
    		},
    		{
    			data:"name"
    		},
    		{
    			data:"description"
    		}
    	]
    });
} );