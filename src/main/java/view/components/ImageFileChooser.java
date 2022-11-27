package view.components;

import view.utility.ImageFileView;
import view.utility.ImageFilter;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

public class ImageFileChooser extends JFileChooser {

    public ImageFileChooser() {
        this.setFileFilter(new ImageFilter());
        this.setFileView(new ImageFileView());
    }

}
