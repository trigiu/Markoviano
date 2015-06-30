package GuiApplicazione;
import javax.swing.*;

public class PopUpAggiungiVertice extends Azioni {
	
	PopUpAggiungiVertice()
	{
		  JTextField nomeField = new JTextField(5);
	      JTextField yField = new JTextField(5);

	      JPanel myPanel = new JPanel();
	      myPanel.setBounds(61, 11, 81, 140);
	      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	      myPanel.add(new JLabel("Nome:"));
	      myPanel.add(nomeField);
	      //myPanel.add(Box.createVerticalStrut(30)); // a spacer
	      myPanel.add(new JLabel("y:"));
	      myPanel.add(yField);

	      int result = JOptionPane.showConfirmDialog(null, myPanel, "Inserisci le proprietà", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	         //System.out.println("x value: " + xField.getText());
	         //System.out.println("y value: " + yField.getText());
	    	  this.getGraph().getModel().beginUpdate();
	    	  Object parent = this.getGraph().getDefaultParent(); 
			  Object v1 = this.getGraph().insertVertex(parent, nomeField.getText(), nomeField.getText(), 330, 30, 100, 50, "verticalLabelPosition=bottom");
			  this.getM().put(nomeField.getText(), v1);
			  this.getGraph().getModel().endUpdate();
	      }
	      
	      
	}
}
