package clases;

import superclases.EntidadConNombre;
import superclases.EntidadPortada;

public class Temporada extends EntidadPortada {
	private byte numeroTemporadas;

	public Temporada(String nombre, String descripcion, byte numeroTemporadas) {
		super(nombre, descripcion);
		this.numeroTemporadas = numeroTemporadas;
	}

	public byte getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(byte numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}
	
	
	

}
