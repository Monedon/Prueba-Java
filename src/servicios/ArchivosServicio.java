package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

public class ArchivosServicio {

	List<Alumno> alumnosACargar;
	PromedioServicioImp prom;

	public List<Alumno> cargarDatos(String ruta) {

		// System.out.println("entrada al metodo");
		List<Alumno> datos = new ArrayList<Alumno>();
		List<Materia> ramos = new ArrayList<Materia>();
		Alumno alumno = null;
		Materia materia;
		String rut = "";
		List<String> notas = new ArrayList<String>();

		try {
			FileReader reader = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(reader);

			String data = buffer.readLine();
			while (data != null) {

				List<String> tmp = Arrays.asList(data.split(","));
				String it = tmp.get(0);
				if (rut == "") {
					// System.out.println("Primer alumno");
					notas.add(tmp.get(3));
					materia = new Materia(devolverMateriaEnum(tmp.get(2)), notas);
					ramos.add(materia);
					alumno = new Alumno(tmp.get(0), tmp.get(1), ramos);
					datos.add(alumno);
				} else if (tmp.get(0).equals(rut)) {
					List<Materia> ram = alumno.getMaterias();
					int cont = 0;
					boolean t = false;
					for (Materia mat : ram) {
						if (mat.getNombre().equals(devolverMateriaEnum(tmp.get(2)))) {
							if (mat.getNombre().equals(devolverMateriaEnum("LENGUAJE"))) {
								cont = 1;
							}
							t = true;
						}
					}
					if (t) {
						alumno.getMaterias().get(cont).getNotas().add(tmp.get(3));
					} else {
						notas = new ArrayList<String>();
						notas.add(tmp.get(3));
						materia = new Materia(devolverMateriaEnum(tmp.get(2)), notas);
						alumno.getMaterias().add(materia);
					}
				} else {
					notas = new ArrayList<String>();
					notas.add(tmp.get(3));
					materia = new Materia(devolverMateriaEnum(tmp.get(2)), notas);
					ramos = new ArrayList<Materia>();
					ramos.add(materia);
					alumno = new Alumno(tmp.get(0), tmp.get(1), ramos);
					datos.add(alumno);

				}

				rut = tmp.get(0);
				data = buffer.readLine(); // siguiente linea
			}
			buffer.close(); // almacenamiento temporal
			reader.close(); // lector de archivos

		} catch (Exception e) {
			System.out.println(e);
		}

		return datos;

	}

	static MateriaEnum devolverMateriaEnum(String text) {
		MateriaEnum materia = null;
		if (text.equals("MATEMATICAS")) {
			materia = MateriaEnum.MATEMATICAS;
		} else if (text.equals("LENGUAJE")) {
			materia = MateriaEnum.LENGUAJE;
		} else if (text.equals("CIENCIA")) {
			materia = MateriaEnum.CIENCIA;
		} else {
			materia = MateriaEnum.HISTORIA;
		}

		return materia;

	}

	static String devolverMateriaString(MateriaEnum materia) {
		String ramo = null;

		if (materia == MateriaEnum.MATEMATICAS) {
			ramo = "MATEMATICAS";
		} else if (materia == MateriaEnum.LENGUAJE) {
			ramo = "LENGUAJE";
		} else if (materia == MateriaEnum.CIENCIA) {
			ramo = "CIENCIA";
		} else {
			ramo = "HISTORIA";
		}

		return ramo;
	}


	private void exportarDatos(Map<String, Alumno> alumnos) {

	}

}
