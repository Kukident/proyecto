import java.io.IOException;
import java.text.ParseException;


public class pruebas {
	public static void main(String[] args) throws ParseException, IOException {
		String cad="23 7; 10 23";
		String[] cad1;
		int i=1;
		cad1=cad.split("["+ ';' +"]");
		i=cad1.length-1;
		int j=0;
		while(j<=i){
			System.out.println(cad1[j].trim());
			j++;			
		}
		}
}
