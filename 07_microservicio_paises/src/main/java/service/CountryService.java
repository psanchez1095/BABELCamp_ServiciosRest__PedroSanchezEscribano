package service;

import java.util.List;

import model.Country;

public interface CountryService {
	List<Country> paisePorContinente(String continente);
	long habitantesPorContinente(String continente);
	List<String> continentes();
}
