package service;

import java.util.List;

import model.Pedido;
import model.Producto;

public interface PedidosService {
	
	List<Pedido> getPedidos();
	Pedido altaPedido(Pedido pedido);
	
}