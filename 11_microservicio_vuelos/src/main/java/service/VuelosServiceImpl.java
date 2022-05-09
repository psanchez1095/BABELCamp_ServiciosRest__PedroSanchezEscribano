package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

//Instancia una clase mediante Spring
@Service
public class VuelosServiceImpl implements VuelosService {
	
	VuelosDao vuelosDao;
	
	//Poniendo service Autowired sobraria
	public VuelosServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public List<Vuelo> buscarVuelosDisponibles(int numeroPlazas) {
		return vuelosDao.findAll()
				.stream()
				.filter(aux -> aux.getPlazas() >= numeroPlazas)
				.distinct()
				.collect(Collectors.toList());
	}

	@Override
	public Vuelo actualizarVuelo(int idVuelo, int plazasReservadas) {
		Vuelo aux = vuelosDao.findById(idVuelo).orElse(null);
		if(aux!=null) {
			aux.setPlazas(aux.getPlazas()-plazasReservadas);
			vuelosDao.save(aux);
			return aux;
		}
		return aux;
	}

	
	}



	


