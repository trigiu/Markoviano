package sistemaMarkoviano;

import java.util.ArrayList;

public class Agente extends Tipologia {
	private int id;
	//private ArrayList<Integer> coordinate = new ArrayList<Integer>();tolto arraylist per le coordinate
	//inserite le coordinate x,y come due float e i metodi set e get
	private float coordX;
	private float coordY;
	String messaggiOut; // questa deve essere una struttura da definire.
	private String colore;

	
	public Agente(int id, float coordX, float coordY, int tipologia, int numstati){
		this.id = id;
		super.setIdClasse(tipologia);
		this.coordX = coordX;
		this.coordY = coordY;
		super.setNumeroStati(numstati);				
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//public ArrayList getCoordinate() {
	//	return coordinate;
	//}
	public float getcoordX(){
		return coordX;
	}
	
	public float getcoordY(){
		return coordY;
	}
	



	//public void setCoordinate(ArrayList coordinate) {
	//	this.coordinate = coordinate;
	//}	
	

}
