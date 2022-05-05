package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	/**
	 * Metodo que se encargar de buscar los productos de la tematica que le llega por parametro
	 * @param tematica parametro string que contiene la tematica a buscar
	 * @return devuelve una lista de productos en caso de �xito,null en caso contrario
	 * */
	List<Producto> buscar(String tematica);
	
	/**
	 * Metodo que se encargar de buscar los productos 
	 * @return devuelve una lista de productos en caso de �xito,null en caso contrario
	 * */
	List<Producto> buscarTodos();
	
	/**
	 * Metodo que se encargar de buscar los productos de la tematica que le llega por parametro
	 * @param tematica parametro string que contiene la tematica a buscar
	 * @return devuelve una lista de productos en caso de �xito,null en caso contrario
	 * */
	Producto buscarPorId(int id);
	
	/** 
	 *  Metodo que se encargar de dar de alta un producto en el sistema
	 * @param p parametro de tipo Producto a dar de alta
	 * */
	void alta(Producto p);
	/** 
	 * Metodo que se encargar de eliminar un producto en el sistema
	 * @param nombreProducto parametro string que contiene el nombre del vehiculo
	 * que se va a eliminar 
	 * @return 
	 * */
	boolean baja(int id);
	
}
