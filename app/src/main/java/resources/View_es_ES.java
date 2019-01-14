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
			{"aside.logout", "Cerrar sesión"},
			
			//Body resources
			
			//General
			{"general.pageName", "General"},
			{"general.warehouseLocation", "Ubicación del almacén"},
			{"general.warehouseState", "Estado del almacén"},
			
			//Order list
			{"orderList.pageName", "Lista de pedidos"},
			{"orderList.orderId", "Pedido ID"},
			{"orderList.assignedWarehouse", "Almacén asignado"},
			{"orderList.entryDate", "Fecha de entrada"},
			{"orderList.departureDate", "Fecha de salida"},
			{"orderList.remove", "-"},
			{"orderList.edit", "Editar"},
			{"orderList.add", "+"},
			
			//Product list
			{"productList.pageName", "Lista de productos"},
			{"productList.id", "ID"},
			{"productList.name", "Nombre"},
			{"productList.description", "Descripción"},
			{"productList.stock", "Stock"},
			{"productList.addStock", "Añadir stock"},
			{"productList.removeProduct", "Eliminar producto"},
			{"productList.edit", "Editar"},
			{"productList.addNewProduct", "Añadir nuevo producto"},
			
			//Add product
			{"addProduct.pageName", "Añadir producto"},
			{"addProduct.productModelId","ID del modelo del producto:"},
			{"addProduct.productModelName","Nombre del modelo del producto:"},
			{"addProduct.productModelDescription","Descripcion del modelo del producto:"},
			{"addProduct.size","Tamaño"},
			{"addProduct.x","X:"},
			{"addProduct.y","Y:"},
			{"addProduct.z","Z:"},
			{"addProduct.weight","Peso:"},
			{"addProduct.addProduct", "Añadir producto"},
			
			//Add Stock
			{"addStock.pageName","Añadir stock"},
			{"addStock.quantity","Cantidad:"},
			{"addStock.warehouse","Almacén"},
			{"addStock.shelfPosition","Posición de la estantería:"},
			{"addStock.entryDate","Fecha de entrada:"},
			{"addStock.addStock","Fecha de salida:"},
			
			//Footer resources
			{"footer.authors", "Desarrollado por Zazpi"},
			
			// Languages
			{"language.en", "Inglés"},
			{"language.eu", "Vasco"},
			{"language.es", "Castellano"}
	};

}