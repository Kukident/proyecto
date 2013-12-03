import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ejecucion {
	static int id=1;
	static avisos avisos = new avisos();

	public void insertapersona (String[] str, Map<Integer, persona> mapa){
		String str1[];
		String str2[];
		String str3[];
		str1=separar.espacios(str[0]);
		str2=separar.espacios(str[2]);

		if(str1[1].equals("alumno")&&(avisos.fechaingreso(str2[1])&avisos.notamedia(Integer.parseInt(str2[3].trim()))&avisos.imp())){
			mapa.put(getid(mapa),new alumno(str[1], getid(mapa),str2[1],str1[1],str2[2],Integer.parseInt(str2[3].trim()),"", ""));
		}
		if(str1[1].equals("profesor")){
			str3=separar.espacios(str[4]);
			if (avisos.horasincorr(Integer.parseInt(str3[1].trim()))&avisos.imp()){
				mapa.put(getid(mapa), new profesor(str[1], getid(mapa),str2[0],str[1],str[3],Integer.parseInt(str3[1].trim()),""));
			}
		}
	}
	private Integer getid(Map<Integer, persona> mapa){
		List<Integer> ids = new ArrayList<Integer>(mapa.keySet());
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
	public void asignarcargadocente(String[] str, Map<Integer, persona> personas, Map <Integer,materia> materias){
		int idp,idm,idg;
		idp=Integer.parseInt(str[1]);
		idm=Integer.parseInt(str[2]);
		if (avisos.profesorinex(idp,personas)&avisos.materiainex(idm,materias,str[3])&avisos.imp()){
		((profesor) personas.get(idp)).putdoceimp(str[2],str[3]);
		}
	}
}
