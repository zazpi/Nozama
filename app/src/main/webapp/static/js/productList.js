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
    			data:"0"
    		},
    		{
    			data:"1"
    		},
    		{
    			data:"2"
    		},
    		{
    			data:"7"
    		}
    	],
    	scrollY: 335
    });
} );