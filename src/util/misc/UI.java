package util.misc;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

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
                String extension = IO.getExtension(f);
                if (extension != null) {
                    if (extension.equals(extension)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }

            public String getDescription() {
                return "." + extension + " File";
            }
        };
    }
}
