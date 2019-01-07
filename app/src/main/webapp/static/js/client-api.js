const getWarehouseData = async () => {
    try {
        const result = await fetch("/api/warehouse");
        const data = await result.json();
        console.log(data);
        return data;
    }catch(error){
        return "Unable to load warehouse data.";
    }
};

const getProductsData = async () => {
    try {
        const result = await fetch("/api/products");
        const data = await result.json();
        return data;
    }catch (error) {
        return "Unable to load products.";
    }
};




