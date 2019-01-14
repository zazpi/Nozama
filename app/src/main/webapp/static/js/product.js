//Product stock and order history

var seriesOptions = [],
    seriesCounter = 0,
    names = ['Stock'];

function createTimeSeries() {
	
    Highcharts.stockChart('highstock', {
        rangeSelector: {
            selected: 4
        },
        title: {
            text: 'Product history'
        },
        yAxis: {
            plotLines: [{
                value: 0,
                width: 2,
                color: 'silver'
            },
            {
            	value: 50,
            	color: 'red',
            	dashStyle: 'shortdash',
            	width: 2,
            	label: {text: 'minimum stock'}
            },
            {
            	value: 150,
            	color: 'red',
            	dashStyle: 'shortdash',
            	width: 2,
            	label: {text: 'maximum stock'}
            }]
        },
        plotOptions: {
            series: {
                compare: 'percent',
                showInNavigator: true
            }
        },
        tooltip: {
            valueDecimals: 2,
            split: true
        },
        series: seriesOptions
    });
}

function loadData(id){
	
	$.each(names, function (i, name) {
	    $.getJSON('/api/history/gethistory?productId='+ id,    function (data) {
	        seriesOptions[i] = {
	            name: name,
	            data: data
	        };
	        seriesCounter += 1;
	        if (seriesCounter === names.length) {
	        	createTimeSeries();
	        }
	    });
	});
}

//Stock per warehouse
$.getJSON('/api/stock/getproductwarehousestock?productId=5',    function (data) {
Highcharts.chart('piechart', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Product per warehouse'
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
    series: [{
        name: 'Stock',
        colorByPoint: true,
        data: data
    }]
});
});