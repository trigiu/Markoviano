package GuiApplicazione;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

//import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.WindowEvent;



public class MMessaggio implements ActionListener {
	int x = 3; // Stati mittente
	int y = 8; // Stati destinatario aka l'agente selezionato
	JFrame f;
	JPanel p;
	ArrayList values = new ArrayList(); // Contiene i tokens in una matrice x-y che rappresenta la probabilit� di percezione del messaggio allo stato i mittente e j destinatario.
	ArrayList memory = new ArrayList();
	//String[][][] memory = new String[][][x]; //lista delle matrici di messaggi caricati
	JComboBox sender;
	int local_index = 0;
	/*
	 * Sistemare memory in maniera tale che si riferisca agli elementi del JCombobox sender
	 * con memory[sender.getSelectedIndex()] dovrebbe spuntare la matrice di messaggi String[x][y] dove x sono gli stati mittente e y gli stati del destinatario.
	 * */
	
	public MMessaggio(){
	 	
	 	
	 	String [] agents = {"3","4","6","10"}; // lista degli stati degli altri agenti presenti
	 	
	 	
	 	sender = new JComboBox(agents);
	 	local_index = sender.getSelectedIndex();
	 	x = Integer.parseInt((String)sender.getSelectedItem());
	 	
	 	for(int i = 0; i<sender.getItemCount(); i++)
	 	{
	 		int nx = Integer.parseInt(agents[i]);
	 		String[][] ns = new String[nx][y];
	 		for(int k=0; k<nx; k++){
	 			for(int j=0; j<y; j++){
	 				ns[k][j] = "0";
	 				
	 			}}
	 		memory.add(i,ns);
	 		
	 	}
	 	
	 	JButton save = new JButton("Salva");
	 	save.addActionListener(this);
	 	sender.addActionListener(this);
	 	//sender.addActionListener(this);

	 	
	 	f = new JFrame("Matrice percezione dei messaggi");
	 	
	 	JPanel p1 = new JPanel();
	 	p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
	 	p1.add(new JLabel("Seleziona l'agente mittente: "));
	 	p1.add(sender);
	 	p = new JPanel();
	 	p.setLayout(new GridLayout(this.x+1, this.y+1));
	 	
	 	
	 	for(int r = 0; r < this.x+1; r++){ //indice x -> Stati mittente
	 	    for(int c = 0; c < this.y+1; c++){ //indice y -> Stati destinatario (s� stesso)
	 	    	if(r == 0 & c==0){
	 	    		p.add(new JLabel("\\")); //posizione incrocio
	 	    		
	 	    	}
	 	    	else if(r == 0) //ascisse 
	 	    	{
	 	    		System.out.println(c);
	 	    		String s="D" + new Integer(c).toString();
	 		 		p.add(new JLabel(s));
	 	    	}
	 	    	else if(c == 0){
	 	    		System.out.println(x);
	 	    		String s="M" + new Integer(r).toString();
	 		 		p.add(new JLabel(s));
	 	    	}else
	 	    	{
	 	    		JTextField t = new JTextField("",3);
	 	    		values.add(t);
	 	            p.add(t);
	 	    	}
	 	    	}
	 	 }
	 		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	 		f.getContentPane().add(p1, BorderLayout.NORTH);
	 		f.getContentPane().add(p, BorderLayout.CENTER);
	 	    f.pack();
	 	    f.setVisible(true);
	   
	 	 }
	
	 public void actionPerformed(ActionEvent e) {
		 	this.memory.set(local_index, this.save_matrix());
		 	
		 	
	        
		 	JComboBox cb = (JComboBox)e.getSource();
	        //aggiorna stati del mittente
	        this.x =  Integer.parseInt((String)cb.getSelectedItem());
	        //this.local_index = cb.getSelectedIndex();
	        
	        System.out.print("Aggiorno local_index che vale ");
	        System.out.println(this.local_index);
	        this.local_index = sender.getSelectedIndex();
	        System.out.print("Adesso che è aggiornato vale:");
	        System.out.println(this.local_index);
	        
	        //this.x = Integer.parseInt((String)sender.getSelectedItem());
	        // Rimuovi pannello
	        this.values = new ArrayList();
	        f.getContentPane().invalidate();
	        p.removeAll();
	        f.getContentPane().remove(p);
	       
	        // Creazione del nuovo pannello
	        this.refresh();
	        
	        f.getContentPane().add(p, BorderLayout.CENTER);
	        f.getContentPane().revalidate();
	    }
	
	private String[][] save_matrix()
	{
		int i = 0;
		int j = 0;
		String[][] register = new String[x][y]; //crea una matrice di Stringhe
		for( Object element : values ) { 
			   JTextField nelement = (JTextField) element; //prende l'elemento presente in values cge � di tipo JTextField
			   register[i][j]=nelement.getText(); //prende il messaggio (Stringa) e lo pone nel campo register[i][j]
			   String verify = "Mittente a stato "+new Integer(i+1).toString()+"\nDestinatario a stato "+new Integer(j+1).toString()+"\ngenera il messaggio " +register[i][j];
			   System.out.println(verify);
			   j++;
			   if(!(j<y))
			   {
				i++;
				j=0;
			   }
			}
		return register;
	}
	
	private void load_matrix()
	{
		for( Object element : values ) { 
			   JTextField nelement = (JTextField) element;
			   
		for(int r = 0; r < x; r++){
	 	    for(int c = 0; c < y; c++){
	 	    
	 	    
	 	    }}}
	}
	 
	private void refresh()
	{
		//crea il nuovo pannello
		JPanel new_p = new JPanel();
		new_p.setLayout(new GridLayout(x+1, y+1));
		for(int r = 0; r < x+1; r++){
	 	    for(int c = 0; c < y+1; c++){
	 	    	if(r == 0 & c==0){
	 	    		new_p.add(new JLabel("\\"));
	 	    	}
	 	    	else if(r == 0)
	 	    	{
	 	    		String s="M" + new Integer(c).toString();
	 		 		new_p.add(new JLabel(s));
	 	    	}
	 	    	else if(c == 0){
	 	    		String s="D" + new Integer(r).toString();
	 		 		new_p.add(new JLabel(s));
	 	    	}else{
	 	    			String m = "";
		 	    		//if(memory.get(this.sender.getSelectedIndex())!= null)
		 	    		//{
		 	    			System.out.println("Caricamento in corso...");
		 	    			
		 	    			String[][] val = new String[x][y]; 
		 	    			
		 	    			//val = (String[][])memory.get(this.sender.getSelectedIndex());	
		 	    			val = (String[][])memory.get(local_index);//Non so perch� non va all'indice desiderato
		 	    			
		 	    			int a[] = new int[]{x,r,y,c,local_index, val.length, val[0].length};
		 	    			System.out.println(Arrays.toString(a));
	 	    				for (int li=0; li<x; li++)
	 	    				  { for (int lj=0;lj<y;lj++) {
	 	    				    System.out.print( val[li][lj]+" ");
	 	    				  } 
	 	    				  System.out.println();
	 	    				  }
	 	    				
	 	    				m = (String)val[r-1][c-1];	
	 	    				System.out.println(m);
		 	    		//}
	 	    			JTextField t = new JTextField(m,3);;
		 	    		
	 	    			values.add(t);
		 	    		new_p.add(t);
		 	    		System.out.println("Salvato");
		 	    		
 	    			}

	 	    	}
	 	        }
	 	 
		this.p = new_p;
	}
}
