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

import model.Vuelo;
import service.VuelosService;


@RestController
@CrossOrigin("*")
public class VuelosController {
		@Autowired
		VuelosService service;
		
	
		@GetMapping(value ="Vuelos/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vuelo> buscarVuelosDisponibles(@PathVariable("plazas") int plazas){
			return service.buscarVuelosDisponibles(plazas);
		}
		
		@PutMapping(value="Vuelo",produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean actualizarVuelo(@RequestParam("idVuelo") int idVuelo,@RequestParam("plazasReservadas") int plazasReservadas) {
			return service.actualizarVuelo(idVuelo, plazasReservadas);
		}
		
		@GetMapping(value ="Vuelo/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Vuelo buscarVuelo(@PathVariable("id") int id){
			return service.buscarVuelo(id);
		}
		
	
}
