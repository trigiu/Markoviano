package GuiApplicazione;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MTransizione {
	
	public MTransizione(){
	 	int x = 10; //Numero stati agente
	 	JFrame f = new JFrame("Matrice delle transizioni");
	 	JPanel p = new JPanel();
	 	p.setLayout(new GridLayout(x+1, x+1));
	 	
	 	for(int r = 0; r < x; r++){
	 	    for(int c = 0; c < x; c++){
	 	    	if(r == 0 & c==0){
	 	    		p.add(new JLabel("\\"));
	 	    		
	 	    	}
	 	    	else if(r == 0)
	 	    	{
	 	    		String s="S" + new Integer(c).toString();
	 		 		p.add(new JLabel(s));
	 	    	}
	 	    	else if(c == 0){
	 	    		String s="S" + new Integer(r).toString();
	 		 		p.add(new JLabel(s));
	 	    	}else
	 	            p.add(new JTextField("",3));
	 	        }
	 	 }
	 		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	 	    f.add(p);
	 	    f.pack();
	 	    f.setVisible(true);
	   
	 	 }
}

