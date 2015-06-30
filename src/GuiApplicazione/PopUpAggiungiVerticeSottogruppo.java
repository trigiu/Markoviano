package GuiApplicazione;
import javax.swing.*;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGraphModel;

public class PopUpAggiungiVerticeSottogruppo extends Azioni {
	
	PopUpAggiungiVerticeSottogruppo()
	{
		  JTextField nomeField = new JTextField(5);
	      JTextField parentOf = new JTextField(5);

	      JPanel myPanel = new JPanel();
	      myPanel.setBounds(61, 11, 81, 140);
	      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	      myPanel.add(new JLabel("Nome:"));
	      myPanel.add(nomeField);
	      myPanel.add(new JLabel("Sottogruppo:"));
	      myPanel.add(parentOf);

	      int result = JOptionPane.showConfirmDialog(null, myPanel, "Inserisci le proprietà", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  this.getGraph().getModel().beginUpdate();
	    	  Object parent = this.getGraph().getDefaultParent();
	    	  mxCell myCell = (mxCell) ((mxGraphModel)graph.getModel()).getCell(parentOf.getText());
			  Object v1 = this.getGraph().insertVertex(myCell, nomeField.getText(), nomeField.getText(), 330, 30, 100, 50, "verticalLabelPosition=bottom");
			  this.getM().put(nomeField.getText(), v1);
			  this.getGraph().getModel().endUpdate();
	      }
	      
	      
	}
}
