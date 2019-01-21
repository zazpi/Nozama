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
			{"general.info", "Best seller"},
			
			//Order list
			{"orderList.pageName", "Order list"},
			{"orderList.orderId", "Order ID"},
			{"orderList.assignedWarehouse", "Assigned warehouse"},
			{"orderList.entryDate", "Entry date"},
			{"orderList.departureDate", "Departure date"},
			{"orderList.remove", "Delete"},
			{"orderList.edit", "Edit"},
			{"orderList.add", "Add"},
			
			//Add order
			{"addOrder.pageName","Add order"},
			{"addOrder.searchProduct","Search product: "},
			{"addOrder.addOrder","Add order"},
			{"addOrder.destination","Destination (PC): "},
			{"addOrder.productList","Product list"},
			{"addOrder.order","Order"},
			
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
			{"addProduct.productModelId","Product ID:"},
			{"addProduct.productModelName","Product name:"},
			{"addProduct.productModelDescription","Product description:"},
			{"addProduct.size","Size"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Weight:"},
			{"addProduct.minStock", "Maximum stock:"},
			{"addProduct.maxStock", "Minimum stock:"},
			{"addProduct.addProduct", "Add product"},
			
			//Product
			{"product.id","ID"},
			{"product.name","Name"},
			{"product.description","Description"},
			{"product.size","Size"},
			{"product.weight","Weight"},
			{"product.desiredStock","Desired stock"},
			{"product.history","History"},
			{"product.stockPerProduct","Stock per warehouse"},
			{"product.orderDestination","Order destination"},
			
			//Add Stock
			{"addStock.pageName","Add stock"},
			{"addStock.quantity","Quantity:"},
			{"addStock.warehouse","Warehouse"},
			{"addStock.shelfPosition","Shelf position:"},
			{"addStock.entryDate","Entry date:"},
			{"addStock.addStock","Add stock"},
			
			//Dashboard
			{"dashboard.orderPeriod","Order period"},
			{"dashboard.orderDestination","Order destination"},
			{"dashboard.generalGauge","Total"},
			{"dashboard.warehouse1Gauge","Warehouse 1"},
			{"dashboard.warehouse2Gauge","Warehouse 2"},
			{"dashboard.timeseries","Stock history"},
			
			//Footer resources
			{"footer.authors", "Copyright &copy; 2019 by Zazpi. All rights reserved."},
			
			// Languages
			{"language.en", "English"},
			{"language.eu", "Basque"},
			{"language.es", "Spanish"}
			
	};

}
