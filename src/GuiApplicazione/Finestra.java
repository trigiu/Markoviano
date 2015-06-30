package GuiApplicazione;

import java.awt.*;
import java.awt.event.*;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finestra extends JFrame {

     
    public Finestra() {

         
        setTitle("Menu Example");
        setSize(500, 500);
         
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
    public static void main(String[] args) {
        Finestra me = new Finestra();
        JPanel panel_sx = new JPanel();
        panel_sx.setSize((me.getWidth())/3, me.getHeight());
        panel_sx.setBackground(Color.BLUE);
        Dimension dim = new Dimension(me.getWidth()/3,me.getHeight());
        panel_sx.setPreferredSize(dim);
        me.getContentPane().add(panel_sx, BorderLayout.WEST);

        JPanel panel_dx = new JPanel();
        
        /* Dovremmo inserire La finestra che io creo tramite Azioni.java all' interno del panel
         * L' errore è di tipo adding a window to a container
         */
        Azioni a = new Azioni();
        panel_dx.add(a);
        a.setVisible(true);
        
        /* Da qua in giu è corretto */
        
        panel_dx.setSize((me.getWidth())*2/3, me.getHeight());
        //panel_dx.setBackground(Color.RED);
        me.getContentPane().add(panel_dx, BorderLayout.CENTER);       
        me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.setVisible(true);
    }
}