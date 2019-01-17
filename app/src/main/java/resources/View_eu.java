package resources;

import java.util.ListResourceBundle;

public class View_eu extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {

			// Header resources
			{"header.appName", "Nozama"},
			
			//Aside resources
			{"aside.general", "Orokorra"},
			{"aside.orderList", "Eskaeren zerrenda"},
			{"aside.productList", "Produktuen zerrenda"},
			{"aside.logout", "Itxi saioa"},
			
			//Body resources
			
			//General
			{"general.pageName", "Orokorra"},
			{"general.info", "Produktu salduenak"},
			
			//Order list
			{"orderList.pageName", "Eskaeren zerrenda"},
			{"orderList.orderId", "Eskaera ID"},
			{"orderList.assignedWarehouse", "Egokitutako biltegia"},
			{"orderList.entryDate", "Sarrera data"},
			{"orderList.departureDate", "Irteera data"},
			{"orderList.remove", "Ezabatu"},
			{"orderList.edit", "Editatu"},
			{"orderList.add", "Gehitu"},
			
			//Product list
			{"productList.pageName", "Produktuen zerrenda"},
			{"productList.id", "ID"},
			{"productList.name", "Izena"},
			{"productList.description", "Deskribapena"},
			{"productList.stock", "Stock"},
			{"productList.addStock", "Gehitu stocka"},
			{"productList.removeProduct", "Ezabatu"},
			{"productList.edit", "Editatu"},
			{"productList.addNewProduct", "Gehitu"},
			
			//Add product
			{"addProduct.pageName", "Gehitu produktua"},
			{"addProduct.productModelId","Produktu ID:"},
			{"addProduct.productModelName","Produktuaren izena:"},
			{"addProduct.productModelDescription","Produktuaren deskribapena:"},
			{"addProduct.size","Tamaina"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Pisua:"},
			{"addProduct.minStock", "Stock minimoa:"},
			{"addProduct.maxStock", "Stock maximoa:"},
			{"addProduct.addProduct", "Gehitu produktua"},
			
			//Product
			{"product.id","ID"},
			{"product.name","Izena"},
			{"product.description","Deskribapena"},
			{"product.size","Tamaina"},
			{"product.weight","Pisua"},
			{"product.desiredStock","Esperotako stocka"},
			{"product.history","Historikoa"},
			{"product.stockPerProduct","Biltegietako stocka"},
			{"product.orderDestination","Eskaeren norakoa"},
			
			//Add Stock
			{"addStock.pageName","Gehitu stocka"},
			{"addStock.quantity","Kopurua:"},
			{"addStock.warehouse","Biltegia"},
			{"addStock.shelfPosition","Apalategia"},
			{"addStock.entryDate","Sarrera data:"},
			{"addStock.addStock","Gehitu stocka"},
			
			//Dashboard
			{"dashboard.orderPeriod","Eskaera periodoa"},
			{"dashboard.orderDestination","Eskaeren norakoa"},
			{"dashboard.generalGauge","Totala"},
			{"dashboard.warehouse1Gauge","1. biltegia"},
			{"dashboard.warehouse2Gauge","2. biltegia"},
			
			//Footer resources
			{"footer.authors", "Copyright &copy; 2019 Zazpik garatua."},
			
			// Languages
			{"language.en", "Ingelera"},
			{"language.eu", "Euskara"},
			{"language.es", "Gaztelera"}
	};

}