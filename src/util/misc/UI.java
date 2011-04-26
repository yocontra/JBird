package util.misc;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

import static util.misc.IO.getExtension;

public class UI {

    public static String getComboInput(String[] options, String title, String comment) {
        return (String) JOptionPane.showInputDialog(null, comment,
                title, JOptionPane.QUESTION_MESSAGE, null,
                options,
                options[0]);
    }

    public static FileFilter getGenericFilter(final String extension) {
        return new FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extens = getExtension(f);
                if (extens != null) {
                    return extens.equals(extension);
                }
                return false;
            }

            public String getDescription() {
                return "." + extension + " File";
            }
        };
    }
}
