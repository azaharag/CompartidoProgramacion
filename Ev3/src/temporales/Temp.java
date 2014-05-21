package temporales;

import java.io.File;
import java.io.IOException;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File tmp=File.createTempFile("tmp", "zz", new File("."));
			File tmp2=File.createTempFile("tmp", "zz", new File("."));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
