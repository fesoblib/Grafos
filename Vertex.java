package Grafos;
import java.util.ArrayList;
public class Vertex {
	ArrayList<String> directions; //Representación de los nodos de adyacencia de un nodo
	String value; //El valor del vértice
	public Vertex() {
	}
	public Vertex(String value) {
		this.value=value;
		directions=new ArrayList<String>();
	}
	public String printDirections() {
		String p="";
		for(int i=0;i<directions.size();i++) {
			p+=(directions.get(i)+" ");
		}
		return p;
	}
}
