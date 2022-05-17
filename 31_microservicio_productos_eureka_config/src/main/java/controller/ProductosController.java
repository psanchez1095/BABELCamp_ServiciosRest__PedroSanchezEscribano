package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.Producto;
import service.ProductosService;


@RestController
@CrossOrigin("*")
public class ProductosController {
		@Autowired
		ProductosService service;
		
		@GetMapping(value ="PrecioUnitario/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public double buscarPrecioUnitario(@PathVariable("id") int id){
			return service.precioUnitario(id);
		}

		@GetMapping(value ="Productos",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Producto> productos(){
			return service.buscarProductos();
		}
		
		@PutMapping(value ="Producto",produces=MediaType.APPLICATION_JSON_VALUE)
		public Producto actualizarStock(@RequestParam("codigoProducto") int codigoProducto,@RequestParam("unidades") int unidades){
			return service.actualizarProducto(codigoProducto, unidades);
		}
		
		
}