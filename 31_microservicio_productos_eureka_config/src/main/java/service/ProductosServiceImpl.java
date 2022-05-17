package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;


//Instancia una clase mediante Spring
@Service
public class ProductosServiceImpl implements ProductosService {
	
	ProductosDao productosDao;
	
	//Poniendo service Autowired sobraria
	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}


	@Override
	public List<Producto> buscarProductos() {
		return productosDao.findAll();
				
	}

	@Override
	public double precioUnitario(int id) {
		return productosDao.findById(id).get().getPrecioUnitario();
	}

	@Override
	public Producto actualizarProducto(int codigoProducto, int unidadesCompradas) {
		Producto aux = productosDao.findById(codigoProducto).orElse(null);
		if(aux!=null) {
			aux.setStock(unidadesCompradas);
			productosDao.save(aux);
			return aux;
		}
		return null;
	}


	

}
