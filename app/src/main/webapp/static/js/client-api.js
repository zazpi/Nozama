async function getWarehouseData() {
    try {
        const result = await fetch("/api/warehouse");
        const data = await result.json();
        console.log(data);
        return data;
    }catch(error){
        return "Unable to load warehouse data.";
    }
}

async function getProductsData() {
    try {
        const result = await fetch("/api/products");
        const data = await result.json();
        return data;
    }catch (error) {
        return "Unable to load products.";
    }
}