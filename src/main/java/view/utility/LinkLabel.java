package view.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Link decoration (decorator pattern)

/**
 * Applies link decoration to Labels
 */
public class LinkLabel extends MouseAdapter {

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JLabel) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
        ((JLabel) e.getSource()).setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JLabel) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        ((JLabel) e.getSource()).setForeground(Color.BLACK);
    }
}
