package GuiApplicazione;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Proprieta
{
	public Proprieta(){
			 	
			
		 	JFrame f = new JFrame("Proprietà");
		    f.getContentPane().setLayout(new FlowLayout());
		    f.getContentPane().add(new JTextField("ID"));
		    f.getContentPane().add(new JTextField("Categoria", 8));
		    JTextField t = new JTextField("Num. Stati", 5);
		    t.setHorizontalAlignment(JTextField.RIGHT);
		    f.getContentPane().add(t);
		    /*
		    JTextArea a = new JTextArea("Note");
		    a.setHorizontalAlignment(JTextField.DOWN);
		    f.getContentPane().add(a);
		    f.getContentPane().add(new JTextField("Text field 5", 3));
		    */
		    f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		    f.pack();
		    f.setVisible(true);
		
		
		    

	
	
	//pack();
    //setSize(600, 600);
	}
}