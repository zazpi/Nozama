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
			{"general.warehouseLocation", "Biltegiaren kokapena"},
			{"general.warehouseState", "Biltegiaren egoera"},
			
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
			{"addProduct.productModelId","Produktu ereduaren ID:"},
			{"addProduct.productModelName","Produktu ereduaren izena:"},
			{"addProduct.productModelDescription","Produktu ereduaren deskribapena:"},
			{"addProduct.size","Tamaina"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Pisua:"},
			{"addProduct.addProduct", "Gehitu produktua"},
			
			//Add Stock
			{"addStock.pageName","Gheitu stocka"},
			{"addStock.quantity","Kopurua:"},
			{"addStock.warehouse","Biltegia"},
			{"addStock.shelfPosition","Apalategiaren posizioa"},
			{"addStock.entryDate","Sarrera data:"},
			{"addStock.addStock","Gheitu stocka"},
			
			//Footer resources
			{"footer.authors", "Copyright &copy; 2019 Zazpik garatua."},
			
			// Languages
			{"language.en", "Ingelera"},
			{"language.eu", "Euskara"},
			{"language.es", "Gaztelera"}
	};

}