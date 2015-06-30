package GuiApplicazione;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class MenuDestroVertice extends JPopupMenu {
    JMenuItem anItem = new JMenuItem();
    public MenuDestroVertice(){
        anItem = new JMenuItem("Proprietà Vertice");
        add(anItem);
        add(anItem);
    }
}
