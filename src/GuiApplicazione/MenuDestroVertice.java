package GuiApplicazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class MenuDestroVertice extends JPopupMenu {
    //JMenuItem anItem = new JMenuItem();
    public MenuDestroVertice(){
        //COMANDO INTERNO AL POP UP
        JMenuItem item = new JMenuItem("Proprietà");
        item.addActionListener(new ActionListener() {
        	
        //QUI VANNO INSERITI I COMANDI DEL POP UP	
          public void actionPerformed(ActionEvent e) {
        	  Proprieta pu = new Proprieta();
        	  System.out.println("Proprietà");
          }
        });
        add(item);
        
        item = new JMenuItem("Messaggi");
        item.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	MMessaggio mm = new MMessaggio(); //bisogna passare l'agente selezionato e tutti gli altri agenti, 
            System.out.println("Matrice dei messaggi");
          }
        });
        add(item);
        
        item = new JMenuItem("Transizioni");
        item.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	MTransizione mt = new MTransizione(); //bisogna passare l'agente per avere gli stati
            System.out.println("Matrice transizione");
          }
        });
        add(item);
    	
    	
    	
    	
    	
    	
    	/*
        anItem = new JMenuItem("Proprietà Vertice");
        add(anItem);
        add(anItem);
        */
    }
}
