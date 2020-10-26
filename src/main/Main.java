package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "C:\\Users\\moned\\eclipse-workspace\\Prueba-Java\\src\\datos\\datos.csv";

		List<String> lista = leeEnterosDesdeArchivo(filename);


		lista.forEach(System.out::println);
		//writeFile("Salida", enteros);

	}

	static List<String> leeEnterosDesdeArchivo(String nombreArchivo) {

		ArrayList<String> numeros = new ArrayList<String>();

		try {
			FileReader reader = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(reader);

			String data = buffer.readLine();
			while (data != null) {

				List<String> tmp = Arrays.asList(data);
				numeros.addAll(tmp);



				data = buffer.readLine(); // siguiente linea
			}
			buffer.close(); // almacenamiento temporal
			reader.close(); // lector de archivos

		} catch (Exception e) {
			System.out.println(e);
		}

		return numeros;

	}

	static void writeFile(String nombreArchivo, List<Integer> numeros) {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {

			archivo = new FileWriter(nombreArchivo, true);
			pw = new PrintWriter(archivo);
			int i;
			for (i = 0; i < numeros.size(); i++) {
				pw.print(numeros.get(i) + ",");
			}
			pw.close();
			archivo.close();

		} catch (Exception e) {
			System.out.println("Fichero " + nombreArchivo + " no se pudo crear " + e);
		}

	}

}
