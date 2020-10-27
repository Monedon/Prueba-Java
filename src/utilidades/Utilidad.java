package utilidades;

import modelo.MateriaEnum;

public class Utilidad {
	
	public void limpiarPantalla() {
		
		int[] it = new int[20];
		for(int i = 0; i<it.length;i++) {
			System.out.println("");
		}
			
	} 

	public void print(String text) {
		System.out.println(text);
	}

	public void print(int num) {
		System.out.println(num);
	}

	public int devolverIndiceMateria(MateriaEnum materia) {
		
		int ramo = 0;
		if (materia == MateriaEnum.MATEMATICAS) {
			ramo = 0;
		} else if (materia == MateriaEnum.LENGUAJE) {
			ramo = 1;
		} else if (materia == MateriaEnum.CIENCIA) {
			ramo = 2;
		} else {
			ramo = 4;
		}

		return ramo;
	}
	
	public MateriaEnum devolverMateriaInt(int num) {
		
		MateriaEnum materia;
		
		if(num == 1) {
			materia = MateriaEnum.MATEMATICAS;
		}else if(num == 2) {
			materia = MateriaEnum.LENGUAJE;
		}else if(num == 3) {
			materia = MateriaEnum.CIENCIA;
		}else {
			materia = MateriaEnum.HISTORIA;
		}
		
		return materia;
		
	}

}
