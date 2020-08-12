package Grafos;
import java.util.ArrayList;
public class Graph {
	ArrayList <Vertex> vertices;//Representación de lista de adyacencia del Grafo
	Vertex source;//Vertice fuente
	String cadena="";
	public Graph() {
		vertices= new ArrayList<Vertex>();
	}
	public void inserVertex(String v) {
		vertices.add(new Vertex(v));
	}
	public Vertex searchVertex(String value) {//Busca el vértice en la lista de adyacencia del Grafo
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).value.equals(value))
				return vertices.get(i);
		}
		return null;
	}
	public void createDirection(int from, int to) {
		String aux=vertices.get(to).value; //Auxiliar que almacene el valor del vértice
		vertices.get(from).directions.add(aux); //Se añade la dirección a la lista del vértice buscado
	}
	public void viewRelations(String value,int depth) {//Valor del Vertice fuente y la profundidad
		source=searchVertex(value); //Obtengo el vértice del valor iniciado
		System.out.print(source.value+"->(");
		//cadena=(source.value+"->(");
		if(depth>0) {
			if(source.directions.size()>0) {
				for(int i=0;i<source.directions.size();i++) {
					viewRelations(searchVertex(source.directions.get(i)),depth-1);
					System.out.print(", ");
				}
			}
			else
				System.out.print("ND");
				/*cadena+="ND";// No Directions*/
		}
		System.out.print(")");
		//cadena+=")";
	}
	public void viewRelations(Vertex vertex, int depth) {
		System.out.print(vertex.value);
		//cadena+=(vertex.value+"->(");
		if(depth>0) {
			System.out.print("->(");
			if(vertex.directions.size()>0) {
				for(int i=0;i<vertex.directions.size();i++) {
					viewRelations(searchVertex(vertex.directions.get(i)),depth-1);
				}
			}
			else
				System.out.print("ND");
				//cadena+="ND";
			System.out.print(")");
		}
		//cadena+=")";
	}
}
