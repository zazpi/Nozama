function loadData(id,minstock,maxstock){ 
	//Timeseries
	$.each(names, function (i, name) {
	    $.getJSON('/api/history/gethistory?productId='+ id + '&warehouseId=' + i,    function (data) {
	        seriesOptions[i] = {
	            name: name,
	            data: data
	        };
	        seriesCounter += 1;
	        if (seriesCounter === names.length) {
	        	createTimeSeries(seriesOptions,minstock,maxstock);
	        }
	    });
	});
	//PieChart
	$.getJSON('/api/stock/getproductwarehousestock?productId=' + id,    function (data) {
		createPiechart(data);
	});
	//Map
	$.getJSON('/api/order/list-location-product?productId=' + id,    function (data) {
		createMap(data);
	});
}


//Product stock and order history (Timeseries)
var seriesOptions = [],
    seriesCounter = 0,
    names = ['Total','Warehouse 1','Warehouse 2'];

function createTimeSeries(data,minstock,maxstock) {
	
    Highcharts.stockChart('timeseries', {
        rangeSelector: {
            selected: 4
        },
        yAxis: {
        	max: 1500,
        	min: 0,
            plotLines: [{
                value: 0,
                width: 2,
                color: 'silver'
            },
            {
            	value: 150,
            	color: 'red',
            	dashStyle: 'shortdash',
            	width: 1,
            	label: {text: 'minimum stock'}
            },
            {
            	value: 1000,
            	color: 'red',
            	dashStyle: 'shortdash',
            	width: 1,
            	label: {text: 'maximum stock'}
            }]
        },

        tooltip: {
            valueDecimals: 2,
            split: true
        },
        series: data
    });
}

//Stock per warehouse (PieChart)
function createPiechart(data){
	Highcharts.chart('piechart', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.y:.1f} ({point.percentage:.1f}%)</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                }
	            }
	        }
	    },
		title: {
			text: ''
		},
	    series: [{
	        name: 'Stock',
	        colorByPoint: true,
	        data: data
	    }]
	});
}
// Map
function createMap(data){
	Highcharts.mapChart('map', {
		 chart: {
		     map: 'countries/es/es-all'
		 },
		 mapNavigation: {
		     enabled: true,
		     buttonOptions: {
		         verticalAlign: 'bottom'
		     }
		 },
		 colorAxis: {
		     min: 0
	     },
		 title: {
			 text: ''
		 },
		 series: [{
		     data: data,
		     name: 'Number of orders',
		     states: {
		         hover: {
		             color: '#BADA55'
		         }
		     }
		 }]
		});
}