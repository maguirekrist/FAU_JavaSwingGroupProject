package view.utility;

import java.io.File;
import java.util.Arrays;

public class FileUtils {

    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String png = "png";

    private final static String[] validFileTypes = { FileUtils.png, FileUtils.jpg, FileUtils.jpeg };

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();

        int i = s.lastIndexOf('.');

        if(i > 0 && i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    public static boolean isValidFileType(File f) {
        String extension = getExtension(f);

        if(extension != null)
        {
            if(Arrays.asList(validFileTypes).contains(extension)) {
                return true;
            }
        }

        return false;
    }

}
