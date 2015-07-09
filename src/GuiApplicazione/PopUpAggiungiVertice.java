package GuiApplicazione;
import javax.swing.*;

import agentiMarkoviani.AgenteMarkoviano;
import sistemaMarkoviano.Agente;

public class PopUpAggiungiVertice extends Finestra {
	Agente oggettoAgente;
	
	PopUpAggiungiVertice()
	{
		  JTextField nomeField = new JTextField(5);
	      JTextField tipoField = new JTextField(5);
	      JTextField nField = new JTextField(5);
	      JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);

	      JPanel myPanel = new JPanel();
	      myPanel.setBounds(61, 11, 81, 140);
	      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	      myPanel.add(new JLabel("Nome:"));
	      myPanel.add(nomeField);
	      //myPanel.add(Box.createVerticalStrut(30)); // a spacer
	      myPanel.add(new JLabel("tipologia:"));
	      myPanel.add(tipoField);
	      myPanel.add(new JLabel("num stati:"));
	      myPanel.add(nField);
	      myPanel.add(new JLabel("X:"));
	      myPanel.add(xField);
	      myPanel.add(new JLabel("Y:"));
	      myPanel.add(yField);
	      //new MMessaggio(nField);

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
	      int nome = Integer.parseInt(nomeField.getText());
	      float x = Float.parseFloat(xField.getText());
	      float y = Float.parseFloat(yField.getText());
	      int tipo = Integer.parseInt(tipoField.getText());
	      int n = Integer.parseInt(nField.getText());
	      oggettoAgente = new Agente(nome, x, y, tipo, n);
	      
	      
	}
}
