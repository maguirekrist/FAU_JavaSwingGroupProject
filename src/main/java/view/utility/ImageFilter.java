package view.utility;

import view.components.ImageFileChooser;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Arrays;

public class ImageFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if(f.isDirectory())
        {
            return true;
        }

        if(FileUtils.isValidFileType(f))
            return true;

        return false;
    }

    @Override
    public String getDescription() {
        return "Images";
    }
}
