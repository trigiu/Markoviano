package GuiApplicazione;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class MenuDestroArco extends JPopupMenu {
    JMenuItem anItem = new JMenuItem();
    public MenuDestroArco(){
        anItem = new JMenuItem("Propriet� Arco");
        add(anItem);
        add(anItem);
    }
}