package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {

	List<Vuelo> buscarVuelosDisponibles(int numeroPlazas);

	Vuelo actualizarVuelo(int idVuelo, int plazasReservadas);
	
	Vuelo buscarVuelo(int id);
	
}
