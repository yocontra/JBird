package util.misc;

import static util.misc.Settings.*;

public class LogHandler {

    private final String Name;

    public LogHandler(String className) {
        Name = className;
    }

    public void log(String msg) {
        System.out.println("[" + Name + "]" + msg);
    }

    public void debug(String msg) {
        if (DEBUG) {
            log("[DEBUG]" + msg);
        }
    }

    public void error(String msg) {
        log("[ERROR]" + msg);
    }
}