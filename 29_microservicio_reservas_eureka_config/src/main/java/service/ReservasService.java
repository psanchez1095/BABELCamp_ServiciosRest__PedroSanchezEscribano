package service;

import java.util.List;

import dto.ReservaDto;
import model.Reserva;

public interface ReservasService {
	
		Reserva altaReserva(ReservaDto a);

		List<Reserva> buscarReservas();
	
}
