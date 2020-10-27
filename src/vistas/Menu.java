package vistas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import modelo.Alumno;
import modelo.Materia;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	AlumnoServicio alumnoServicio;
	ArchivosServicio archivoServicio;
	Scanner scanner;
	List<Alumno> alumnos;
	Utilidad util = new Utilidad();

	private void cargarDatos() {

		String filename = "C:\\Users\\moned\\eclipse-workspace\\Prueba-Java\\src\\datos\\notas.csv";
		ArchivosServicio datos = new ArchivosServicio();
		List<Alumno> lista = datos.cargarDatos(filename);
		lista.stream().forEach(e -> alumnos.add(e));

	}

	private void exportarDatos() {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {

			archivo = new FileWriter("Salida", true);
			pw = new PrintWriter(archivo);
			int i;
			// for (i = 0; i < numeros.size(); i++) {
			// pw.print(numeros.get(i) + ",");
			// }
			pw.close();
			archivo.close();

		} catch (Exception e) {
			System.out.println("Fichero  no se pudo crear " + e);
		}

	}

	public void crearAlummno() {

		List<Materia> materia = new ArrayList<Materia>();
		System.out.println("Ingresa rut: ");
		String rut = scanner.nextLine();
		System.out.println("Ingresa nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Ingresa apellido: ");
		String apellido = scanner.nextLine();
		System.out.println("Ingresa direccion: ");
		String direccion = scanner.nextLine();

		Alumno alumno = new Alumno(rut, nombre, apellido, direccion, materia);
		alumnos.add(alumno);

	}

	private void agregarMateria() {

		boolean res = false;
		String rut;
		do {
			System.out.println("Ingrese Rut de alumno: ");
			rut = scanner.nextLine();
			if (validarRut(rut)) {
				res = true;
			}else {
				System.out.println("Rut incorrecto");
			}
		} while (res == false);
		String r = rut;
		do {
			System.out.println("Seleccione numero de materia: "
					+ "\n1. MATEMATICA\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
			String materia = scanner.nextLine();
			if (Integer.parseInt(materia) <0 || Integer.parseInt(materia) >4) {
				Alumno al = (Alumno) alumnos.stream().filter(e -> e.getRut() == r);
				al.getMaterias().add(new Materia(util.devolverMateriaInt((Integer.parseInt(materia)))));
				res = true;
			}else {
				System.out.println("Opcion incorrecta");
			}
		} while (res == false);
		
		System.out.println("Materia agregada");


	}

	private boolean validarRut(String rut) {
		// TODO Auto-generated method stub
		for (Alumno a : alumnos) {
			if (a.getRut().equals(rut)) {
				return true;
			}
		}
		return false;
	}

	private void agregarNotaPasoUno() {
		
		boolean res = false;
		String rut;
		do {
			System.out.println("Ingrese Rut de alumno: ");
			rut = scanner.nextLine();
			if (validarRut(rut)) {
				res = true;
			}else {
				System.out.println("Rut incorrecto");
			}
		} while (res == false);
		String r = rut;
		do {
			System.out.println("Alumno tiene las siguientes materias: ");
			Alumno al = (Alumno) alumnos.stream().filter(e -> e.getRut() == r);
			
			System.out.println("Seleccione numero de materia: "
					+ "\n1. MATEMATICA\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
			String materia = scanner.nextLine();
			if (Integer.parseInt(materia) <0 || Integer.parseInt(materia) >4) {
				
				al.getMaterias().add(new Materia(util.devolverMateriaInt((Integer.parseInt(materia)))));
				res = true;
			}else {
				System.out.println("Opcion incorrecta");
			}
		} while (res == false);
		
		System.out.println("Materia agregada");

		

	}

	private void listarAlummnos() {

	}

}
