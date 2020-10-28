package vistas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	AlumnoServicio alumnoServicio;
	ArchivosServicio archivoServicio;
	static Scanner scanner = new Scanner(System.in);
	static List<Alumno> alumnos = new ArrayList<Alumno>();
	static Utilidad util = new Utilidad();

	public static void cargarDatos() {

		String filename = "C:\\Users\\moned\\eclipse-workspace\\Prueba-Java\\src\\datos\\notas.csv";
		ArchivosServicio datos = new ArchivosServicio();
		List<Alumno> lista = datos.cargarDatos(filename);
		lista.stream().forEach(e -> alumnos.add(e));

	}

	public static void exportarDatos() {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {

			archivo = new FileWriter("Salida", true);
			pw = new PrintWriter(archivo);
			for(Alumno e : alumnos) {
				
				pw.println(e);
			}
			pw.close();
			archivo.close();

		} catch (Exception e) {
			System.out.println("Fichero  no se pudo crear " + e);
		}

	}

	public static void crearAlummno() {

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

	public static void agregarMateria() {

		boolean res = false;
		String rut;
		do {
			System.out.println("Ingrese Rut de alumno: ");
			rut = scanner.nextLine();
			if (validarRut(rut)) {
				res = true;
			} else {
				System.out.println("Rut incorrecto");
			}
		} while (res == false);
		String r = rut;
		do {
			System.out.println(
					"Seleccione numero de materia: " + "\n1. MATEMATICA\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
			String materia = scanner.nextLine();
			Materia ramo ;
			if (Integer.parseInt(materia) > 0 || Integer.parseInt(materia) < 4) {
				System.out.println("entró a agregar materia");
				ramo = new Materia(util.devolverMateriaInt(Integer.parseInt(materia)));
				alumnos.stream().filter(e -> e.getRut().equals(r))
				.map(e->e.getMaterias().add(ramo)).collect(Collectors.toList());
				res = true;
			} else {
				System.out.println("Opcion incorrecta");
			}
		} while (res == false);

		System.out.println("Materia agregada");

	}

	public static boolean validarRut(String rut) {
		// TODO Auto-generated method stub
		for (Alumno a : alumnos) {
			if (a.getRut().equals(rut)) {
				return true;
			}
		}
		return false;
	}

	public static void agregarNotaPasoUno() {

		boolean res = false;
		String rut;
		do {
			System.out.println("Ingrese Rut de alumno: ");
			rut = scanner.nextLine();
			if (validarRut(rut)) {
				res = true;
			} else {
				System.out.println("Rut incorrecto");
			}
		} while (res == false);
		String r = rut;
		do {
			int i = 0;
			System.out.println("Alumno tiene las siguientes materias: ");
			Stream<Alumno> al = alumnos.stream().filter(e -> e.getRut().equals(r));
			System.out.println(al.map(e -> e.getMaterias()).collect(Collectors.toList()));
			

			System.out.println("Seleccione numero de materia: ");
			String materia = scanner.nextLine();
			if (Integer.parseInt(materia) < 1 || Integer.parseInt(materia) > 4) {
				System.out.println("Ingrese nota");
				String nota = scanner.nextLine();
				//al.getMaterias().get(Integer.parseInt(materia) - 1).getNotas().add(nota);
				res = true;
			} else {
				System.out.println("Opcion incorrecta");
			}
		} while (res == false);

		System.out.println("Materia agregada");

	}

	public static void listarAlummnos() {

		for (Alumno e : alumnos) {
			System.out.println("Rut: " + e.getRut() + "\nNombre: " + e.getNombre() + "" + "\nApellido: "
					+ e.getApellido() + "\nDireccion: " + e.getDireccion());
			for (Materia m : e.getMaterias()) {
				System.out.println(m.getNombre());

				m.getNotas().forEach(System.out::println);
			}
		}
		scanner.nextLine();
	}

}
