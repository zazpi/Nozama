$(document).ready( function () {
    $('#orderTable').DataTable({
    	ajax: {
    		url: "/api/order/list",
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