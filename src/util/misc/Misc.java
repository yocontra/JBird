package util.misc;

import java.util.Random;

public class Misc {

    public static String getRandomString(int length, boolean simple) {
        simple = true;
        if (!simple) {
            Random rand = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                sb.append(new char[rand.nextInt(255)]);
            }
            return sb.toString();
        } else {
            String charset = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890$_";
            Random rand = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                sb.append(charset.charAt(rand.nextInt(charset.length())));
            }
            return sb.toString() + rand.nextInt(20);
        }
    }
}
