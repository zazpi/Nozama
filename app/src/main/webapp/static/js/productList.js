$(document).ready(() => {
    const productsTable = new Tabulator("#product-list-table", {
        height: 486,
        ajaxURL: "/api/product/list",
        layout: "fitColumns",
        tooltips: true,
        addRowPos: "top",
        history: true,
        pagination: "local",
        paginationSize: 18,
        rowClick:productClick,
        columns: [
            {title: "ID", field: "id", align: "center", width: 100,rowClick:productClick},
            {title: "Name", field: "name"},
            {title: "Description", field: "description"},
            {title: "Stock", field: "stock"}
        ]
    });
   
    function productClick(e,row){
    	window.location = "/product?productId=" + row.getIndex(0);
    }

    // FIXME: The below api requests can be used once backend functionality is correctly functional.
    /*$("#delete-btn").click(async () => {
        const deleteUrl = "/api/product/delete";
        const data = productsTable.getSelectedData();
        let ids = data.map((data) => {
           return data.id;
        });
        const params = {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({productIds: ids}),
            method: "POST"
        };

        await fetch(deleteUrl, params);
    });*/

    /*$("#edit").click(async () => {
        const preloadUrl = "/api/product/preload";
        const data = productsTable.getSelectedData();
        console.log(data);
        let id = data[0].id;
        const params = {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({productId: id}),
            method: "POST"
        };
        await fetch(preloadUrl, params);
    });*/
});



