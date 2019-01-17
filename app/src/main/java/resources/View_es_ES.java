package resources;

import java.util.ListResourceBundle;

public class View_es_ES extends ListResourceBundle{

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
			{"aside.orderList", "Lista de pedidos"},
			{"aside.productList", "Lista de productos"},
			{"aside.simulator","Simulador"},
			{"aside.logout", "Cerrar sesión"},
			
			//Body resources
			
			//General
			{"general.pageName", "General"},
			{"general.info", "Lo más vendido"},
			
			//Order list
			{"orderList.pageName", "Lista de pedidos"},
			{"orderList.orderId", "Pedido ID"},
			{"orderList.assignedWarehouse", "Almacén asignado"},
			{"orderList.entryDate", "Fecha de entrada"},
			{"orderList.departureDate", "Fecha de salida"},
			{"orderList.remove", "Eliminar"},
			{"orderList.edit", "Editar"},
			{"orderList.add", "Añadir"},
			
			//Add order
			{"addOrder.pageName","Añadir pedido"},
			{"addOrder.searchProduct","Buscar producto: "},
			{"addOrder.addOrder","Añadir producto"},
			{"addOrder.destination","Destino (CP): "},
			
			//Product list
			{"productList.pageName", "Lista de productos"},
			{"productList.id", "ID"},
			{"productList.name", "Nombre"},
			{"productList.description", "Descripción"},
			{"productList.stock", "Stock"},
			{"productList.addStock", "Añadir stock"},
			{"productList.removeProduct", "Eliminar"},
			{"productList.edit", "Editar"},
			{"productList.addNewProduct", "Añadir"},
			
			//Add product
			{"addProduct.pageName", "Añadir producto"},
			{"addProduct.productModelId","ID del producto:"},
			{"addProduct.productModelName","Nombre del producto:"},
			{"addProduct.productModelDescription","Descripcion del producto:"},
			{"addProduct.size","Tamaño"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Peso:"},
			{"addProduct.minStock", "Stock minimo:"},
			{"addProduct.maxStock", "Stock máximo:"},
			{"addProduct.addProduct", "Añadir producto"},
			
			//Product
			{"product.id","ID"},
			{"product.name","Nombre"},
			{"product.description","Descripción"},
			{"product.size","Tamaño"},
			{"product.weight","Peso"},
			{"product.desiredStock","Stock deseado"},
			{"product.history","Histórico"},
			{"product.stockPerProduct","Stock por almacén"},
			{"product.orderDestination","Destino de los pedidos"},
			
			//Add Stock
			{"addStock.pageName","Añadir stock"},
			{"addStock.quantity","Cantidad:"},
			{"addStock.warehouse","Almacén"},
			{"addStock.shelfPosition","Posición de la estantería:"},
			{"addStock.entryDate","Fecha de entrada:"},
			{"addStock.addStock","Añadir stock"},
			
			//Dashboard
			{"dashboard.orderPeriod","Periodo de pedidos"},
			{"dashboard.orderDestination","Destino de pedidos"},
			{"dashboard.generalGauge","Total"},
			{"dashboard.warehouse1Gauge","Almacén 1"},
			{"dashboard.warehouse2Gauge","Almacén 2"},
			
			//Footer resources
			{"footer.authors", "Copyright &copy; desarrollado por Zazpi. Todos los derechos reservados"},
			
			// Languages
			{"language.en", "Inglés"},
			{"language.eu", "Vasco"},
			{"language.es", "Castellano"}
	};

}