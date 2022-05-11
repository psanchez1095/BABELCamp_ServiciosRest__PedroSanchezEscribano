package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Hotel;
import service.HotelesService;


@RestController
@CrossOrigin("*")
public class HotelesController {
		@Autowired
		HotelesService service;
		@ApiOperation(value="Devuelve una lista con los datos de un hotel ")
		@GetMapping(value ="HotelById/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Hotel buscarHotel(@ApiParam(value="Id del hotel")
		@PathVariable("id") int id){
			return service.buscarHotel(id);
		}
	
		@GetMapping(value ="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Hotel buscarHotel(@PathVariable("nombre") String nombre){
			return service.buscarHotel(nombre);
		}
		
		@GetMapping(value ="HotelesDisponibles",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Hotel> hoteles(){
			return service.buscarHotelesDisponibles();
		}
		
}
