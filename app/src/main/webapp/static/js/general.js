/*const greenLineCoords = [
	[42.8585981, -2.6842947],
	[42.8605487, -2.6772625],
	[42.8650418, -2.6606937],
	[42.8641521, -2.6498906],
	[42.8661933, -2.6387743]
];

const map = L.map('map').setView([42.8585981, -2.6842947], 14);
L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
	maxZoom: 18,
	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
		'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
		'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
	id: 'mapbox.streets'
}).addTo(map);

const gPolyline = L.polyline(greenLineCoords, {
	color: 'green'
}).addTo(map);

const marker = L.marker([42.8585981, -2.6842947]).addTo(map).bindPopup("<br>Hello there</b>").openPopup();

const circle = L.circle([42.8585981, -2.6842947], {
	color: 'red',
	fillColor: '#f03',
	fillOpacity: 0.5,
	radius: 500
}).addTo(map);

const polygon = L.polygon([
	[42.8585981, -2.6842947],
	[42.8585992, -2.6842941],
	[42.8585985, -2.6842939]
]).addTo(map);*/


$.getJSON('/api/stock/getwordcloud',    function (data) {
	createWordCloud(data);
});

function createWordCloud(data){
	Highcharts.chart('map', {
		  series: [{
		    type: 'wordcloud',
		    data: data,
		    name: 'Stock'
		  }],
		  title: {
		    text: 'Wordcloud of stock'
		  }
		});
}
