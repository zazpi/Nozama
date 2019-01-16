package resources;

import java.util.ListResourceBundle;

public class View extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {

			// Header resources
			{"header.appName", "Nozama"},
			
			//Aside resources
			{"aside.general", "General"},
			{"aside.orderList", "Order list"},
			{"aside.productList", "Product list"},
			{"aside.simulator","Simulator"},
			{"aside.logout", "Logout"},
			
			//Body resources
			
			//General
			{"general.pageName", "General"},
			{"general.warehouseLocation", "Warehouse location"},
			{"general.warehouseState", "Warehouse state"},
			
			//Order list
			{"orderList.pageName", "Order list"},
			{"orderList.orderId", "Order ID"},
			{"orderList.assignedWarehouse", "Assigned warehouse"},
			{"orderList.entryDate", "Entry date"},
			{"orderList.departureDate", "Departure date"},
			{"orderList.remove", "Delete"},
			{"orderList.edit", "Edit"},
			{"orderList.add", "Add"},
			
			//Product list
			{"productList.pageName", "Product list"},
			{"productList.id", "ID"},
			{"productList.name", "Name"},
			{"productList.description", "Description"},
			{"productList.stock", "Stock"},
			{"productList.addStock", "Add stock"},
			{"productList.removeProduct", "Delete"},
			{"productList.edit", "Edit"},
			{"productList.addNewProduct", "Add"},
			
			//Add product
			{"addProduct.pageName", "Add product"},
			{"addProduct.productModelId","Product model ID:"},
			{"addProduct.productModelName","Product model name:"},
			{"addProduct.productModelDescription","Product model description:"},
			{"addProduct.size","Size"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Weight:"},
			{"addProduct.addProduct", "Add product"},
			
			//Add Stock
			{"addStock.pageName","Add stock"},
			{"addStock.quantity","Quantity:"},
			{"addStock.warehouse","Warehouse"},
			{"addStock.shelfPosition","Shelf position:"},
			{"addStock.entryDate","Entry date:"},
			{"addStock.addStock","Add stock"},
			
			//Footer resources
			{"footer.authors", "Copyright &copy; 2019 by Zazpi. All rights reserved."},
			
			// Languages
			{"language.en", "English"},
			{"language.eu", "Basque"},
			{"language.es", "Spanish"}
			
	};

}
