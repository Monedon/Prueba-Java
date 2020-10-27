package modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	
	MateriaEnum nombre;
	List<String> notas = new ArrayList<String>();
	
	public Materia(MateriaEnum nombre, List<String> notas) {
		super();
		this.nombre = nombre;
		this.notas.addAll(notas);
	}
	
	public Materia(MateriaEnum nombre) {
		super();
		this.nombre = nombre;
		this.notas = new ArrayList<String>();
	}

	public MateriaEnum getNombre() {
		return nombre;
	}

	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}

	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas.addAll(notas);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	

}
