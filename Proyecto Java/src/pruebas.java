import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class pruebas {
	public static void main(String[] args) throws ParseException, IOException {
		List <String> listadoaprob= new ArrayList<String>();
		List <String> listadoprerequi= new ArrayList<String>();
		listadoaprob.add(0,"1");
		listadoaprob.add(1,"2");
		listadoprerequi.add(0,"4");
		listadoprerequi.add(1,"1");
		int i=0,j=0;
		while (i<2){
			while(j<2){
				if (listadoaprob.get(j).equals(listadoprerequi.get(i))){
					System.out.println("verdad");
				}
				j++;
			}
			j=0;
			i++;
		}

			System.out.println(listadoaprob);
		System.out.println(listadoprerequi);

	}
}
