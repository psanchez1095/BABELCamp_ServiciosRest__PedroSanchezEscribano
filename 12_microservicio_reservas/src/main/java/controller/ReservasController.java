package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.ReservaDto;
import model.Reserva;
import model.Vuelo;
import service.ReservasService;


@RestController
@CrossOrigin("*")
public class ReservasController {
		@Autowired
		ReservasService service;
		@PostMapping(value="Reserva",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public Reserva alta(@RequestBody ReservaDto a) {
			return service.altaReserva(a);
		}
		@GetMapping(value="Reservas",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Reserva>  buscarReservas() {
			return service.buscarReservas();
		}
		
		
	
}
