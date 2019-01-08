

// -- CHARTS --
const vlSpec = {
		 "$schema": "https://vega.github.io/schema/vega-lite/v3.json",
		  "width": 800,
		  "height": 500,
		  "projection": {
		    "type": "mercator"
		  },
		  "layer": [
		    {
		      "data": {
		        "url": "http://localhost:8080/static/spain.json",
		        "format": {
		          "type": "topojson",
		          "feature": "ESP_adm2"
		        }
		      },
		      "mark": {
		        "type": "geoshape",
		        "fill": "lightgray",
		        "stroke": "white"
		      }
		    },
		    {
		      "data": {
		        "url": "https://vega.github.io/vega-lite/data/us-state-.json"
		      },
		      "layer": [{
		        "mark": {
		          "type": "circle",
		          "color": "orange"
		        }
		      }]
		    }
		  ]
};
const vlSpec2 = {
};
vegaEmbed("#vis2", vlSpec2);