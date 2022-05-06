package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Country;
import service.CountryService;

@CrossOrigin("*")
@RestController
public class CountryController {
	
	@Autowired CountryService service;
	
	@GetMapping(value ="Regions",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	@GetMapping(value ="Countries/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Country> paiseEnContinente(@PathVariable("continente") String continente){
		return service.paisePorContinente(continente);
	}
	@GetMapping(value ="CountriesPopulation/{continente}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String habitantesContinente(@PathVariable("continente") String continente){
		return "Habitantes " + continente +" "+Long.toString(service.habitantesPorContinente(continente)) ;
	}
	
}
