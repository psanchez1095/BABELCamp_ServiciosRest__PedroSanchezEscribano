package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;


@RestController
public class ProductController {

	// INYECTAMOS CLASE
	@Autowired
	ProductosService service;
	
	@PostMapping(value="Producto",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Producto a) {
		service.alta(a);
	}

	@DeleteMapping(value="Producto/{idProducto}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String eliminar(@PathVariable("idAlumno") int idAlumno) {
		return String.valueOf(service.baja(idAlumno));
	}
	
	@GetMapping(value ="Producto",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value ="Producto/{idProducto}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Producto buscarAlumno(@PathVariable("idProducto") int idProducto){
		return service.buscarPorId(idProducto);
	}
	
	@GetMapping(value ="Productos/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductosPorSeccion(@PathVariable("tematica") String tematica){
		return service.buscar(tematica);
	}

}
