package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	List<Producto> buscarProductos();
	double precioUnitario(int id);
	Producto actualizarProducto(int codigoProducto, int unidadesCompradas);
}