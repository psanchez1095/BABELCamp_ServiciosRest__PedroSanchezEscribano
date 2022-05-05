package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List<Pagina> buscar(String tematica);
	void alta(Pagina p);
	List<Pagina> paginas();
	void eliminar(String tematica);
	Pagina actualizar(Pagina pagina );
	void actualizar(String direccion,String tematica );
}
