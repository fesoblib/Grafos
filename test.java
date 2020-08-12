package Grafos;

import java.io.*;

public class test {
	public static void main(String args[]) throws IOException{
		Graph grafico= new Graph();
		//He convertido la primera pagina del archivo .xlsx a .txt
		//Abrimos el archivo .txt
		File archivo = new File("/home/overlord/Descargas/dataset.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		//Hacemos la lectura y las inserciones
		/*for(int i=1;i<=100;i++) {
			if(i<10)
				System.out.println(br.readLine().substring(2));
			else if(i<100)
				System.out.println(br.readLine().substring(3));
			else
				System.out.println(br.readLine().substring(4));
		}*/
		grafico.inserVertex("a");
		grafico.inserVertex("b");
		grafico.inserVertex("c");
		grafico.inserVertex("d");
		grafico.createDirection(0, 1);
		grafico.createDirection(1, 2);
		grafico.createDirection(2, 3);
		grafico.createDirection(2, 0);
		grafico.createDirection(3, 2);
		System.out.println(grafico.vertices.get(0).value);
		System.out.println(grafico.vertices.get(1).value);
		System.out.println(grafico.vertices.get(2).value);
		System.out.println(grafico.vertices.get(3).value);
		System.out.println(grafico.searchVertex(grafico.vertices.get(0).directions.get(0)).value);
		grafico.viewRelations("c", 1);
		br.close();
	}
}
