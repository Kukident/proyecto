import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class pruebas {
	public static void main(String[] args) throws ParseException, IOException {
		SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEEE H");
		String horas="9";
		String dia="Lunes 9";
		
		Date d1=df.parse(dia);
		String dia1=df.format(d1);

		System.out.println(d1);
		System.out.println(dia1);

	}
}
