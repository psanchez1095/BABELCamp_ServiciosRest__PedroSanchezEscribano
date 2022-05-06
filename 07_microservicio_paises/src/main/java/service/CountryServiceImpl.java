package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Country;

@Service
public class CountryServiceImpl implements CountryService{
	RestTemplate template;
	String urlBase="https://restcountries.com/v2/all";
	
	public CountryServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	Country[] countries;
	@PostConstruct
	public void init() {
		countries = template.getForObject(urlBase,Country[].class);
	}
	@Override
	public List<Country> paisePorContinente(String continente) {
		countries = template.getForObject(urlBase, Country[].class);
		return Arrays
				.stream(countries)
				.filter(x -> x.getRegion().equals(continente))
				.distinct()
				.collect(Collectors.toList());
	}


	@Override
	public long habitantesPorContinente(String continente) {
		countries = template.getForObject(urlBase, Country[].class);
		return Arrays
				.stream(countries)
				.filter(x -> x.getRegion().equals(continente))
				.collect(Collectors.summingLong(x -> x.getPopulation()));	
	}


	@Override
	public List<String> continentes() {
		countries = template.getForObject(urlBase, Country[].class);
		return Arrays
				.stream(countries)
				.map(x -> x.getRegion())
				.collect(Collectors.toList());
	}

}
