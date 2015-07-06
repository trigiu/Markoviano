package GuiApplicazione;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;


final class Pannello extends JPanel {
	
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Container c = getParent();
        if (c != null) {
            d = c.getSize();
        } else {
            return new Dimension(10, 10);
        }
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        //int s = (w < h ? w : h);
        return new Dimension(w/3, h);
    }	
	
}


public class Finestra extends JFrame {
	
	static Finestra frame;
	protected static mxGraph graph = new mxGraph();
	protected static HashMap m = new HashMap();
	protected static mxGraphComponent graphComponent;
	private static JButton bottoneAggiungiVertice;
	private static JButton bottoneAggiungiVerticeSottogruppo;
	private static JButton bottoneElimina;
	private static JButton bottoneAggiungiArco;
	private static JButton bottoneAggiungiArcoIndotto;
	private static JButton bottoneZoomIn;
	private static JButton bottoneZoomOut;
	protected static Object cell;
	private int larghezzaFrame, altezzaFrame;
	
	public static HashMap getM() {
		return m;
	}

	public static mxGraph getGraph() {
		return graph;
	}
     
    public Finestra() {

         
        setTitle("Catene di Markov");
        
        Toolkit mioToolkit = Toolkit.getDefaultToolkit();
		Dimension dimensioniSchermo = mioToolkit.getScreenSize();
		
		larghezzaFrame = (int) (dimensioniSchermo.getWidth());
		altezzaFrame = (int) (dimensioniSchermo.getHeight());

        
        setSize(larghezzaFrame, altezzaFrame);
         
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
         
        // Add the menubar to the frame
        setJMenuBar(menuBar);
         
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");
         
        // Create and add CheckButton as a menu item to one of the drop down
        // menu
        JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");
        // Create and add Radio Buttons as simple menu items to one of the drop
        // down menu
        JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
                "Radio Button1");
        JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem(
                "Radio Button2");
        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAction1);
        bg.add(radioAction2);
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.add(checkAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.addSeparator();
        editMenu.add(radioAction1);
        editMenu.add(radioAction2);
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the new action");
            }
        });
    }
    
    private void panelSx()
    {
        Pannello panel_sx = new Pannello();       
        panel_sx.setSize((frame.getWidth())/3, frame.getHeight());
        panel_sx.setBackground(Color.BLUE);
        Dimension dim = new Dimension(frame.getWidth()/3,frame.getHeight());
        panel_sx.setPreferredSize(dim);
        
    	//Pannello panel_sx = new Pannello();
        //panel_sx.setSize((frame.getWidth())/3, frame.getHeight());
        //panel_sx.setBackground(Color.BLUE);
        //Dimension dim = new Dimension(frame.getWidth()/3,frame.getHeight());
        //panel_sx.setPreferredSize(dim);
        
        //frame.getContentPane().add(panel_sx, BorderLayout.WEST);
        frame.add(panel_sx, BorderLayout.WEST);
        
    }
    
    void panelDx() {
    	JPanel panel_dx = new JPanel();
    	graph.setAllowLoops(true);
		
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		graphComponent.getGraphHandler().setRemoveCellsFromParent(false);
		graphComponent.setPreferredSize(new Dimension(frame.getWidth()*2/3,frame.getHeight()));
		
        panel_dx.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        ImageIcon vertice = new ImageIcon("Risorse/vertice.png");
        bottoneAggiungiVertice = new JButton(vertice);
        frame.getContentPane().add(bottoneAggiungiVertice);
        bottoneAggiungiVertice.addActionListener(new ActionListener() {
                        
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiVertice add = new PopUpAggiungiVertice();
            }
        });
        panel_dx.add(bottoneAggiungiVertice);
        
        
        ImageIcon verticeSottogruppo = new ImageIcon("Risorse/verticeSottogruppo.png");
        bottoneAggiungiVerticeSottogruppo = new JButton(verticeSottogruppo);
        frame.getContentPane().add(bottoneAggiungiVerticeSottogruppo);
        bottoneAggiungiVerticeSottogruppo.addActionListener(new ActionListener() {
                        
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiVerticeSottogruppo addb = new PopUpAggiungiVerticeSottogruppo();
            }
        });
        panel_dx.add(bottoneAggiungiVerticeSottogruppo);
        
        ImageIcon arco = new ImageIcon("Risorse/arco.png");
        bottoneAggiungiArco = new JButton(arco);
        frame.getContentPane().add(bottoneAggiungiArco);
        bottoneAggiungiArco.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiArco arco = new PopUpAggiungiArco();
            	
            }
        });
        panel_dx.add(bottoneAggiungiArco);
        
        ImageIcon arcoIndotto = new ImageIcon("Risorse/arcoIndotto.png");
        bottoneAggiungiArcoIndotto = new JButton(arcoIndotto);
        frame.getContentPane().add(bottoneAggiungiArcoIndotto);
        bottoneAggiungiArcoIndotto.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	PopUpAggiungiArcoIndotto arcoi = new PopUpAggiungiArcoIndotto();
            	
            }
        });
        panel_dx.add(bottoneAggiungiArcoIndotto);
        
        ImageIcon cancella = new ImageIcon("Risorse/cancella.png");
        bottoneElimina = new JButton(cancella);
        frame.getContentPane().add(bottoneElimina);
        bottoneElimina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graph.getModel().remove(cell);
				
			}
		});
        panel_dx.add(bottoneElimina);
        
        ImageIcon zoomPiu = new ImageIcon("Risorse/zoomPiu.png");
        bottoneZoomIn = new JButton(zoomPiu);
        frame.getContentPane().add(bottoneZoomIn);
        bottoneZoomIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphComponent.zoomIn();
				
			}
		});
        panel_dx.add(bottoneZoomIn);
        
        ImageIcon zoomMeno = new ImageIcon("Risorse/zoomMeno.png");
        bottoneZoomOut = new JButton(zoomMeno);
        frame.getContentPane().add(bottoneZoomOut);
        bottoneZoomOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphComponent.zoomOut();
				
			}
		});
        panel_dx.add(bottoneZoomOut);
        
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
        
        panel_dx.add(graphComponent);
        
        
        panel_dx.setSize((frame.getWidth())*2/3, frame.getHeight());
        frame.getContentPane().add(panel_dx, BorderLayout.CENTER);       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
    
    public static void main(String[] args) {
        
    	frame = new Finestra();

    	
    	JPanel panel_sx = new Pannello();
        
        panel_sx.setSize((frame.getWidth())/3, frame.getHeight());
        panel_sx.setBackground(Color.BLUE);
        Dimension dim = new Dimension(frame.getWidth()/3,frame.getHeight());
        panel_sx.setPreferredSize(dim);
        
        frame.getContentPane().add(panel_sx, BorderLayout.WEST);
    	//frame.panelSx();
    	frame.panelDx();
        frame.setVisible(true);
    }
}