import java.io.IOException;
import java.text.ParseException;
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
		int idp,idm;
		idp=Integer.parseInt(str[1]);
		idm=Integer.parseInt(str[2]);
		if (avisos.profesorinex(idp,personas)&avisos.materiainex(idm,materias,str[3])&avisos.grupoyaasignado(str[2], str[3])&avisos.imp()){
			if (((profesor) personas.get(idp)).getdoceimp().get(0).equals("")){//Si la lista esta vacia (tiene un espacio en blanco en la primera posicion), se sobreescribe
				((profesor) personas.get(idp)).getdoceimp().set(0,str[2]+" "+str[3]);
			}
			else{
				((profesor) personas.get(idp)).putdoceimp(str[2],str[3]);
			}
		}
	}
	public void matricularalumno(String[] str, Map<Integer, persona> personas, Map <Integer,materia> materias){
		int idp,idm;
		idp=Integer.parseInt(str[1]);
		idm=Integer.parseInt(str[2]);
		if (((avisos.alumnoinex(idp,personas)&avisos.materiainex(idm, materias, str[3]))&&(avisos.prerequisitos(idp,personas,idm,materias)&avisos.yamatriculado(idp,personas,idm)))&avisos.imp()){
			if (((alumno) personas.get(idp)).getdocerec().get(0).equals("")){//Si la lista esta vacia (tiene un espacio en blanco en la primera posicion), se sobreescribe
				((alumno) personas.get(idp)).getdocerec().set(0,str[2]+" "+str[3]);
			}
			else {
				((alumno) personas.get(idp)).putdocrec(str[2],str[3]);
			}
		}
	}
	public void evaluarmateria(String[] str, Map<Integer, persona> personas, Map<Integer, materia> materias) throws ParseException, IOException{
		int idm,idp, j=0, i=0, sizenot, sizemat;
		double nota, notamedia;
		String idg="-1";
		String ruta=null;
		idm=Integer.parseInt(str[1]);
		ruta=str[2];
		leer leer = new leer();
		leer.notas(ruta);	
		sizenot=leer.getnotas().size();
		if (avisos.materiainex(idm,materias,idg)&avisos.imp()){
			while (j<sizenot){
				idp=Integer.parseInt(separar.espacios(leer.getnotas().get(j).trim())[0]);
				sizemat=((alumno) personas.get(idp)).getdocerec().size();
				nota=Integer.parseInt(separar.espacios(leer.getnotas().get(j).trim())[1]);
				if (nota>=5){
					while (i<sizemat){
						if (Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(i))[0])==idm){
							((alumno) personas.get(idp)).getdocerec().remove(i);
							((alumno) personas.get(idp)).getaprob().add(str[1]);
							notamedia=((((alumno) personas.get(idp)).getnota())+nota)/(((alumno) personas.get(idp)).getaprob().size());
							if (((alumno) personas.get(idp)).getaprob().get(0).equals("")){
								((alumno) personas.get(idp)).getaprob().remove(0);
							}
							((alumno) personas.get(idp)).putnota(notamedia);
							break;
						}
						i++;
					}
				}
				else {
					while (i<sizemat){
						if (Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(i).trim())[0])==idm){
							((alumno) personas.get(idp)).getdocerec().remove(i);
							break;
						}
						i++;
					}
				}
				j++;
			}
		}
	}
	public void obtenercalendario(String[] str, Map<Integer, persona> personas, Map<Integer, materia> materias){
		List<String> horas = new ArrayList<String>();

		int idp=Integer.parseInt(str[1]);
		int sizedocerec,sizegrupos,j=0,i=0,idm,idg;
		System.out.println(((alumno) personas.get(idp)).getdocerec());
		sizedocerec=((alumno) personas.get(idp)).getdocerec().size();
		while (j<sizedocerec){
			idm=Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(j))[0]);
			idg=Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(j))[1]);
			sizegrupos=materias.get(idm).getgrupos().size();
			while (i<sizegrupos){
				if (Integer.parseInt(separar.espacios(materias.get(idm).getgrupos().get(i))[0])==idg){
					//Funcion escribir
				}
				i++;
			}
			j++;
		}

	}
}
