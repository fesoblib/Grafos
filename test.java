package Grafos;

import java.io.*;

public class test {
	static FileReader fr1, fr2;

	public static void main(String args[]) throws IOException {
		Graph grafo = new Graph();
		// He convertido la primera pagina del archivo .xlsx a .txt

		// Abrimos los archivos .txt
		// Data.txt
		File data = new File("/home/overlord/eclipse-workspace/EDAT/Laboratorio/src/Grafos/data.txt"); // txt con los
																										// datos
		fr1 = new FileReader(data);
		String[] datos = new String[100]; // Array para todos los datos
		BufferedReader br1 = new BufferedReader(fr1);

		// Relations.txt
		File relations = new File("/home/overlord/eclipse-workspace/EDAT/Laboratorio/src/Grafos/relations.txt");
		fr2 = new FileReader(relations);
		BufferedReader br2 = new BufferedReader(fr2);

		// Almacenamos los datos en el array
		for (int i = 0; i < 100; i++) {
			String row = br1.readLine();
			int tab = row.indexOf("\t");
			datos[i] = row.substring(tab + 1, row.length());
		}
		// Hacemos las inserciones
		for (int i = 0; i < 100; i++) {
			grafo.inserVertex(datos[i]);
		}

		// Creamos las relaciones
		for (int i = 1; i <= 399; i++) {
			String row = br2.readLine();
			int tab = row.indexOf("\t");
			/*
			 * Creamos la dirección con los parametros ("de", "a") La expresión es: Creamos
			 * una dirección "de" a "a"
			 */
			grafo.createDirection(Integer.parseInt(row.substring(0, tab)) - 1,
					Integer.parseInt(row.substring(tab + 1, row.length())) - 1);// Se le resta 1 ya que el ArrayList
																				// empieza en 0
		}

		// Hacemos una busqueda de profundidad x->Aleatoria entre 1 y 3 por cada dato
		for (int i = 0; i < 100; i++) {
			// La profundidad puede ser mayor a 3, pero son muy largas y no se verán en las
			// pruebas
			System.out.print(i + ".-  ");
			grafo.viewRelations(datos[i], (int) (Math.random() * 3 + 1));
			System.out.println();
		}
		/*
		 * ---------------EJEMPLO SIMPLE--------------- grafico.inserVertex("a");
		 * grafico.inserVertex("b"); grafico.inserVertex("c"); grafico.inserVertex("d");
		 * grafico.createDirection(0, 1); grafico.createDirection(1, 2);
		 * grafico.createDirection(2, 3); grafico.createDirection(2, 0);
		 * grafico.createDirection(3, 2);
		 * System.out.println(grafico.vertices.get(0).value);
		 * System.out.println(grafico.vertices.get(1).value);
		 * System.out.println(grafico.vertices.get(2).value);
		 * System.out.println(grafico.vertices.get(3).value);
		 * System.out.println(grafico.searchVertex(grafico.vertices.get(0).directions.
		 * get(0)).value); grafico.viewRelations("c", 1);
		 */
		br1.close();
		br2.close();
	}
}
