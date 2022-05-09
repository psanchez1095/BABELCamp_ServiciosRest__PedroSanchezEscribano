package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

//Instancia una clase mediante Spring
@Service
public class HotelesServiceImpl implements HotelesService {
	
	HotelesDao hotelesDao;
	
	//Poniendo service Autowired sobraria
	public HotelesServiceImpl(@Autowired HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}

	@Override
	public Hotel buscarHotel(String nombre) {
		return hotelesDao.findHotelByNombre(nombre);
	}

	@Override
	public List<Hotel> buscarHoteles() {
		return hotelesDao.findAll();
	}



	

}
