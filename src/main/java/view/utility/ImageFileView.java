package view.utility;

import javax.swing.*;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;

public class ImageFileView extends FileView {

    @Override
    public Icon getIcon(File f) {
        if(FileUtils.isValidFileType(f)) {
            ImageIcon icon = new ImageIcon(f.getPath(), "test");
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            return icon;
        }

        return super.getIcon(f);
    }
}
