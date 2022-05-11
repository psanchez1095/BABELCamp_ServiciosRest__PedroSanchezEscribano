package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {
	
	Hotel buscarHotel(int id);
	Hotel buscarHotel(String nombre);
	List<Hotel> buscarHotelesDisponibles();
}
