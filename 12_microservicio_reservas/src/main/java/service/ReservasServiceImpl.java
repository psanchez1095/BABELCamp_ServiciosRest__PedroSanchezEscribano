package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import dto.ReservaDto;
import model.Hotel;
import model.Reserva;
import model.Vuelo;

//Instancia una clase mediante Spring
@Service
public class ReservasServiceImpl implements ReservasService {
	
	ReservasDao reservasDao;
	RestTemplate template;
	String urlHoteles="http://localhost:8000/hoteles";
	String urlVuelos="http://localhost:8500/vuelos";
	
	//Poniendo service Autowired sobraria
	public ReservasServiceImpl(@Autowired ReservasDao reservasDao,@Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}

	@Override
	public Reserva altaReserva(ReservaDto a) {
		
		/*Vuelo vuelo = template.getForObject(urlVuelos+"/Vuelo/"+a.getVuelo(), Vuelo.class);
		Hotel hotel = template.getForObject(urlHoteles+"/HotelById/"+a.getHotel(), Hotel.class);
		
		if(hotel!=null && vuelo.getPlazas() >=a.getPlazas()) {
			
			Reserva aux = new Reserva(a.getIdReserva(),a.getNombre(),a.getDni(),a.getHotel(),a.getVuelo());
			
			template.put(urlVuelos+"/Vuelo/"+"?idVuelo="+a.getVuelo()+"&plazasReservadas="+a.getPlazas(),null);
			
			reservasDao.save(aux);
			return aux;
		}
		return null;
		*/
		Reserva aux = new Reserva(a.getIdReserva(),a.getNombre(),a.getDni(),a.getHotel(),a.getVuelo());
		ResponseEntity<String> response = template.exchange(urlVuelos+"/Vuelo/"+"?idVuelo="+a.getVuelo()+"&plazasReservadas="+a.getPlazas(), HttpMethod.PUT,null,String.class);
		if (response.getBody().equals("true")) {
			reservasDao.save(aux);
			return aux;
		}
		else return null;
		}
		//METODO EXCHANGE 
	

	@Override
	public List<Reserva> buscarReservas() {
		return reservasDao.findAll();
		
	}


	
	}



	


