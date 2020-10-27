package vistas;

import java.util.Scanner;

import utilidades.Utilidad;

public class MenuTemplate {

	Scanner scanner = new Scanner(System.in);
	Utilidad util = new Utilidad();

	private void cargarDatos() {

	}

	private void exportarDatos() {

	}

	private void crearAlummno() {

	}

	private void agregarMateria() {

	}

	private void agregarNotaPasoUno() {

	}

	private void listarAlummnos() {

	}

	private void terminarPrograma() {

	}

	public void iniciarMenu() {

		boolean opcion = false;
		do {
			System.out.println("\n1. Crear Alumnos\r\n" + "2. Listar Alumnos\r\n" + "3. Agregar Materias\r\n"
					+ "4. Agregar Notas\r\n" + "5. Cargar Datos\r\n" + "6. Exportar Datos\r\n" + "7. Salir\r\n"
					+ "Selección:\r\n");

			String op = scanner.nextLine();

			if (Integer.parseInt(op) < 0 || Integer.parseInt(op) > 7) {
				util.limpiarPantalla();
				System.out.println("Opcion Incorrecta");
			} else {
				switch (op) {

				case "1":
					Menu.crearAlummno();
					break;

				case "2":					
					Menu.listarAlummnos();
					break;

				case "3":
					Menu.agregarMateria();
					break;

				case "4":
					Menu.agregarNotaPasoUno();
					break;

				case "5":
					Menu.cargarDatos();
					break;

				case "6":
					Menu.exportarDatos();
					break;

				case "7":
					opcion = true;
					break;

				}
			}

		} while (opcion == false);
	}

}
