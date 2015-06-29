package sistemaMarkoviano;

import java.util.ArrayList;

public class Agente {
	private int id;
	private ArrayList<Integer> coordinate = new ArrayList<Integer>();
	String messaggiOut; // questa deve essere una struttura da definire.
	private String colore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(ArrayList coordinate) {
		this.coordinate = coordinate;
	}	

}
