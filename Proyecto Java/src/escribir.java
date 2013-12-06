import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


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
	public void horario(String[] str,SortedMap<Date,Integer> horas, Map<Integer, materia> materias){
		List<Date> listahoras = new ArrayList<Date>(horas.keySet());
		fechas fechas = new fechas();
		int size,j=0;
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(str[2]));
			size=listahoras.size();
			while (j<size){
				System.out.println("////"+materias.get(horas.get(listahoras.get(j))).getid()+"\n"+materias.get(horas.get(listahoras.get(j))).getmateria()+"\n"+fechas.dateastring(listahoras.get(j)));
				bw.write(materias.get(horas.get(listahoras.get(j))).getid()+"\n"+materias.get(horas.get(listahoras.get(j))).getmateria()+"\n"+fechas.dateastring(listahoras.get(j))+"\n*\n");
				j++;
			}
			bw.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
