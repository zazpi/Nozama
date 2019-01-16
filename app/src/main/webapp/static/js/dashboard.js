$( document ).ready(function(){
	//Heatmap
	$.getJSON('/api/order/list-day-month',    function (data) {
		drawHeatMap(data);
	});
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
		    text: 'Orders per month per weekday'
		  },
		  xAxis: {
		    categories: ['null','January', 'Febrary', 'March', 'April', 'May', 'June',
		    	'July', 'August', 'September', 'October','November','December']
		  },
		  yAxis: {
		    categories: ['Sunday','Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday','Saturday'],
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
		      return '<b>' + this.series.xAxis.categories[this.point.x] + '</b> sold <br><b>' +
		        this.point.value + '</b> items on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
		    }
		  },
		  series: [{
		    name: 'Orders per day',
		    borderWidth: 1,
		    data:data,
		    dataLabels: {
		      enabled: true,
		      color: '#000000'
		    }
		  }]

		});	
}
