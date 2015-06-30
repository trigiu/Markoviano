package GuiApplicazione;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


public class Azioni extends JFrame {
	protected static mxGraph graph = new mxGraph();
	protected static HashMap m = new HashMap();
	protected mxGraphComponent graphComponent;
	private JButton bottoneAggiungiVertice;
	private JButton bottoneAggiungiVerticeSottogruppo;
	private JButton bottoneElimina;
	private JButton bottoneAggiungiArco;
	private JButton bottoneAggiungiArcoIndotto;
	private JButton bottoneZoomIn;
	private JButton bottoneZoomOut;
	protected Object cell;
	
	public static HashMap getM() {
		return m;
	}

	public static mxGraph getGraph() {
		return graph;
	}

	public Azioni(){
		super("Catene di Markov");
		initGUI();
	}

	private void initGUI() {
		setSize(900, 700);
		setLocationRelativeTo(null);

		graph.setAllowLoops(true);
		
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		graphComponent.getGraphHandler().setRemoveCellsFromParent(false);
		graphComponent.setPreferredSize(new Dimension(870, 580));
		
        setLayout(new FlowLayout(FlowLayout.LEFT));
		
        ImageIcon vertice = new ImageIcon("Risorse/vertice.png");
        bottoneAggiungiVertice = new JButton(vertice);
        getContentPane().add(bottoneAggiungiVertice);
        bottoneAggiungiVertice.addActionListener(new ActionListener() {
                        
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiVertice add = new PopUpAggiungiVertice();
            }
        });
        
        ImageIcon verticeSottogruppo = new ImageIcon("Risorse/verticeSottogruppo.png");
        bottoneAggiungiVerticeSottogruppo = new JButton(verticeSottogruppo);
        getContentPane().add(bottoneAggiungiVerticeSottogruppo);
        bottoneAggiungiVerticeSottogruppo.addActionListener(new ActionListener() {
                        
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiVerticeSottogruppo addb = new PopUpAggiungiVerticeSottogruppo();
            }
        });
        
        ImageIcon arco = new ImageIcon("Risorse/arco.png");
        bottoneAggiungiArco = new JButton(arco);
        getContentPane().add(bottoneAggiungiArco);
        bottoneAggiungiArco.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiArco arco = new PopUpAggiungiArco();
            	
            }
        });        
        
        ImageIcon arcoIndotto = new ImageIcon("Risorse/arcoIndotto.png");
        bottoneAggiungiArcoIndotto = new JButton(arcoIndotto);
        getContentPane().add(bottoneAggiungiArcoIndotto);
        bottoneAggiungiArcoIndotto.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiArcoIndotto arcoi = new PopUpAggiungiArcoIndotto();
            	
            }
        });
        
        ImageIcon cancella = new ImageIcon("Risorse/cancella.png");
        bottoneElimina = new JButton(cancella);
        getContentPane().add(bottoneElimina);
        bottoneElimina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graph.getModel().remove(cell);
				
			}
		});
        
        ImageIcon zoomPiu = new ImageIcon("Risorse/zoomPiu.png");
        bottoneZoomIn = new JButton(zoomPiu);
        getContentPane().add(bottoneZoomIn);
        bottoneZoomIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphComponent.zoomIn();
				
			}
		});
        
        ImageIcon zoomMeno = new ImageIcon("Risorse/zoomMeno.png");
        bottoneZoomOut = new JButton(zoomMeno);
        getContentPane().add(bottoneZoomOut);
        bottoneZoomOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphComponent.zoomOut();
				
			}
		});
        
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
		{		
			public void mouseReleased(MouseEvent e)
			{
				cell = graphComponent.getCellAt(e.getX(), e.getY());
				if (e.isMetaDown())
				{
					//System.out.println( "Tasto Destro premuto" );
					try
					{
						if (((mxCell)cell).isVertex()) 
				        {
				        	//System.out.println("Vertice");
				        	MenuDestroVertice menuv = new MenuDestroVertice();
					        menuv.show(e.getComponent(), e.getX(), e.getY());			        	
						}
						else if(((mxCell)cell).isEdge())
						{
							//System.out.println("Edge");
							MenuDestroArco menua = new MenuDestroArco();
					        menua.show(e.getComponent(), e.getX(), e.getY());
						}
					}
					catch(Exception exc)
					{
						;
					}
			        
				}
				
			}
		});
        
        getContentPane().add(graphComponent);
        
        
        
	}

}