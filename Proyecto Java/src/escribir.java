import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class escribir {

	public void avisos(String str) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/danielvilar2/Desktop/avisos.txt", true));
			bw.write(str);
			bw.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
