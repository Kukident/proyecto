import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ejecucion {
	static int id=0;
	public static void insertapersona (String[] str){
		String str1[];
		String str2[];
		String str3[];
		str1=separar.espacios(str[0]);
		str2=separar.espacios(str[2]);

		if(str1[1].equals("alumno")){
			leer.getpersonas().put(getid(),new alumno(str[1], getid(),str2[1],str1[1],str2[2],Integer.parseInt(str2[3].trim()),"", ""));
		}
		if(str1[1].equals("profesor")){
			str3=separar.espacios(str[4]);
			System.out.println(str3[1]);
			leer.getpersonas().put(getid(), new profesor(str[1], getid(),str2[0],str[1],str[3],Integer.parseInt(str3[1].trim()),""));
		}
	}
	private static Integer getid(){
		List<Integer> ids = new ArrayList<Integer>(leer.getpersonas().keySet());
		Collections.sort(ids);
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
