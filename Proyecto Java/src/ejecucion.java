import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ejecucion {
	static int id=0;
	public static void insertapersona (String[] str){
		String str1[];
		String str2[];
		str1=separar.espacios(str[0]);
		str2=separar.espacios(str[2]);
		if(str1[0].equals("alumno"));{
			leer.getalumnos().put(getid(),new alumno(str[1], getid(),str2[1],str1[1],str2[2],Integer.parseInt(str2[3].trim()), null, null));
			System.out.println(leer.getalumnos().keySet());
		}			
		}
	private static Integer getid(){
		List<Integer> ids = new ArrayList<Integer>(leer.getalumnos().keySet());
		int size=ids.size();
		int j=0;
		while (j<size){
		if	(ids.get(j).equals(id)){
			id++;
			continue;
		}	
		j++;
		}
		return id;
	}
	}
