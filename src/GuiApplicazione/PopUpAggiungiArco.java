package GuiApplicazione;
import javax.swing.*;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class PopUpAggiungiArco extends Finestra {
	
	PopUpAggiungiArco(){
		Object parent = this.getGraph().getDefaultParent();
        
        JTextField verticeSorgente = new JTextField(5);
	    JTextField verticeDestinatario = new JTextField(5);
	    JTextField nomeArco = new JTextField(5);
	    

	    JPanel myPanel = new JPanel();
	    myPanel.setBounds(61, 11, 81, 140);
	    myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	    myPanel.add(new JLabel("Vertice Sorgente:"));
	    myPanel.add(verticeSorgente);
	    myPanel.add(new JLabel("Vertice Destinatario:"));
	    myPanel.add(verticeDestinatario);
	    myPanel.add(new JLabel("Nome Arco:"));
	    myPanel.add(nomeArco);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Inserisci le proprietà", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	    	Object v1 = this.getM().get(verticeSorgente.getText());
	    	Object v2 = this.getM().get(verticeDestinatario.getText());
	    	Object a = this.getGraph().insertEdge(parent, nomeArco.getText(), nomeArco.getText(), v1, v2);
	    	
	    }
        
	}
}