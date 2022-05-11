package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vuelos")
public class Vuelo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	private String company;
	//EN LA BBDD ES TIPO VARCHAR
	private String fecha;
	private double precio;
	private int plazas;
	}
	

