package sistemaMarkoviano;

public class Tipologia {
	private int idClasse;
	private int uuid; //casomai da togliere
	private int numeroStati;
	private StructTransizione[][] matriceRaggiungibilita;

	public void setIdClasse(int tipo){
		this.idClasse = tipo;
	}
	
	public void setNumeroStati(int numstati){
		this.numeroStati = numstati;
	}
}


