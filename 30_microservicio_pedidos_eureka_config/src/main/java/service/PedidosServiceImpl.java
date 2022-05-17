package service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;
import model.Producto;


//Instancia una clase mediante Spring
@Service
public class PedidosServiceImpl implements PedidosService {
	
	PedidosDao pedidosDao;
	RestTemplate template;
	String urlMicroProducto="http://servicio-productos/productos";
	//Poniendo service Autowired sobraria
	public PedidosServiceImpl(@Autowired PedidosDao pedidosDao,@Autowired RestTemplate template) {
		super();
		this.pedidosDao = pedidosDao;
		this.template = template;
	}

	@Override
	public List<Pedido> getPedidos() {
		return pedidosDao.findAll();
	}

	@Override
	public Pedido altaPedido(Pedido pedido) {
		double precioProducto = template.getForObject(urlMicroProducto + "/PrecioUnitario/" +pedido.getCodigoProducto(), double.class);
		ResponseEntity<String> response = template.exchange(urlMicroProducto+"/Producto/"+"?codigoProducto="+pedido.getCodigoProducto()+"&unidades="+pedido.getUnidades(),HttpMethod.PUT,null,String.class,pedido.getCodigoProducto(),pedido.getUnidades());
		String cuerpo = response.getBody();
		
		if(precioProducto != 0 && cuerpo != null) {
			pedido.setFechaPedido(new Date());
			pedido.setTotal(pedido.getUnidades()*precioProducto);
			pedidosDao.save(pedido);
			return pedido;
		}
		return null;
	}


	

	

}