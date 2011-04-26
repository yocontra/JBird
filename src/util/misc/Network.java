package util.misc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Network {
    public static double getLatestVersion() {
		try {
			InputStream is = new URL("http://recoders.org/contra/jbird/version.php").openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			return Double.parseDouble(reader.readLine().trim());
		} catch (Exception ignored) {
		}
		return -1;
	}
}
