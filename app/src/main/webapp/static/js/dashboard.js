$(document).ready(function(){
	//Heatmap
	$.getJSON('/api/order/list-day-month',    function (data) {
		drawHeatMap(data);
	});
	//Map
	$.getJSON('/api/order/list-location',    function (data) {
		createMap(data);
	});
	
	const warehouseIds = [0,1,2];
	$.each(warehouseIds, (index, id) => {
		$.getJSON('/api/stock/getcapacity?warehouseId=' + id, (data) => {
			createGauge([data],'gauge' + id);
		});
	});
	//Gauge

});

function drawHeatMap(data){
	Highcharts.chart('heatmap', {
		  chart: {
		    type: 'heatmap',
		    marginTop: 40,
		    marginBottom: 80,
		    plotBorderWidth: 1
		  },
		  title: {
		    text: ''
		  },
		  xAxis: {
		    categories: ['January', 'Febrary', 'March', 'April', 'May', 'June',
		    	'July', 'August', 'September', 'October','November','December']
		  },
		  yAxis: {
		    categories: ['1','2', '3', '4', '5', '6', '7','8','9','10',
		    	'11','12', '13', '14', '15', '16', '17','18','19','20',
		    	'21','22', '23', '24', '25', '26', '27','28','29','30','31'],
		    title: null
		  },
		  colorAxis: {
		    min: 0,
		    minColor: '#FFFFFF',
		    maxColor: Highcharts.getOptions().colors[0]
		  },
		  legend: {
		    align: 'right',
		    layout: 'vertical',
		    margin: 0,
		    verticalAlign: 'top',
		    y: 20,
		    symbolHeight: 280
		  },
		  tooltip: {
		    formatter: function () {
		      return '<b>' + this.series.yAxis.categories[this.point.y] + " "+ this.series.xAxis.categories[this.point.x] + '</b>' +
		          '<br>N orders: <br><b>' + this.point.value + '</b>';
		    }
		  },
		  series: [{
		    name: 'Orders per day',
		    borderWidth: 1,
		    data:data,
		    dataLabels: {
		      enabled: false,
		      color: '#000000'
		    }
		  }]

		});	
}

//Map
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
		 title: {
		   text: ''
		 },
		 colorAxis: {
		     min: 0
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

// Gauges
function createGauge(data,container){
	Highcharts.chart(container,{
	    chart: {
	        type: 'solidgauge'
	    },
	    title: null,
	    pane: {
	        center: ['50%', '60%'],
	        size: '90%',
	        startAngle: -90,
	        endAngle: 90,
	        background: {
	            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
	            innerRadius: '60%',
	            outerRadius: '100%',
	            shape: 'arc'
	        }
	    },
	    tooltip: {
	        enabled: false
	    },
	    // the value axis
	    yAxis: {
	        stops: [
	            [0.1, '#55BF3B'], // green
	            [0.5, '#DDDF0D'], // yellow
	            [0.9, '#DF5353'] // red
	        ],
	        lineWidth: 0,
	        minorTickInterval: null,
	        tickAmount: 2,
	        title: {
	            y: -70
	        },
	        labels: {
	            y: 16
	        },
	        min: 0,
	        max: 100,
	    },
	    plotOptions: {
	        solidgauge: {
	            dataLabels: {
	                y: 5,
	                borderWidth: 0,
	                useHTML: true
	            }
	        }
	    },
	    series: [{
	        name: 'RPM',
	        data: data,
	        dataLabels: {
	            format: '<div style="text-align:center"><span style="font-size:50px;color:' +
	                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || '#2f3542') + '">{y:.1f}%</span><br/>' +
	                   '<span style="font-size:12px;color:silver">Capacity</span></div>'
	        }
	    }]

	});
}
