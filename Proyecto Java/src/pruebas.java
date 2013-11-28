import java.io.IOException;
import java.text.ParseException;


public class pruebas {
	public static void main(String[] args) throws ParseException, IOException {
		String cad="alumno caao";
		String[] cad1;
		int i=1;
		cad1=cad.split("["+ ' ' +"]");
		System.out.println(cad1[0].equals("alumno"));
		if(cad1[0].equals("alumno")){
			System.out.println("yes");	
		}
		System.out.println(cad1[0]);
		
		i=cad1.length-1;
		int j=0;
		while(j<=i){
			//System.out.println(cad1[j].trim());
			j++;			
		}
		}
}
