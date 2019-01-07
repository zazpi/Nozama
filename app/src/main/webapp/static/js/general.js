const greenLineCoords = [
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
]).addTo(map);

// -- CHARTS --
const vlSpec = {
    "$schema": "https://vega.github.io/schema/vega-lite/v3.json",
    "width": 500,
    "height": 200,
    "data": {
        "values": [
            {"a": "C", "b": 2}, {"a": "C", "b": 7}, {"a": "C", "b": 4},
            {"a": "D", "b": 1}, {"a": "D", "b": 2}, {"a": "D", "b": 6},
            {"a": "E", "b": 8}, {"a": "E", "b": 4}, {"a": "E", "b": 7}
        ]
    },
    "mark": "bar",
    "encoding": {
        "y": {"field": "a", "type": "nominal"},
        "x": {
            "aggregate": "average", "field": "b", "type": "quantitative",
            "axis": {
                "title": "Average of b"
            }
        }
    }
};
const vlSpec2 = {
    "width": 500,
    "height": 250,
    "autosize": {
    "type": "fit",
        "contains": "padding"
},
    "data": {
    "values": [
        {"a": "A","b": 28}, {"a": "B","b": 55}, {"a": "C","b": 43},
        {"a": "D","b": 91}, {"a": "E","b": 81}, {"a": "F","b": 53},
        {"a": "G","b": 19}, {"a": "H","b": 87}, {"a": "I","b": 52}
    ]
},
    "mark": "bar",
    "encoding": {
    "x": {"field": "a", "type": "ordinal"},
    "y": {"field": "b", "type": "quantitative"}
}
};

vegaEmbed("#vis", vlSpec);
vegaEmbed("#vis2", vlSpec2);