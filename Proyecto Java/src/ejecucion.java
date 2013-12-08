import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
/**Ejecuta los distintos comandos del archivo ejecucion*/
public class ejecucion {
	static int id=1;
	static avisos avisos = new avisos();
	escribir escribir = new escribir();

	/**Inserta una nueva persona en el sistema
	 * @param str Contiene la linea ejecucion separa por comillas
	 * @param mapa Map con las todas las personas*/
	public void insertapersona (String[] str, Map<Integer, persona> mapa){
		String str1[];
		String str2[];
		String str3[];
		if ((str.length==3||str.length==5)&(str[1].length()<=75)){
			str1=separar.espacios(str[0]);
			str2=separar.espacios(str[2]);


			if(str1[1].equals("alumno")&&(avisos.fechaingreso(str2[1],str2[2])&avisos.notamedia(Double.parseDouble(str2[3].trim()))&avisos.imp())){
				if(avisos.fechacorrecta(str2[1])&avisos.fechacorrecta(str2[2])){
					mapa.put(getid(mapa),new alumno(str[1], getid(mapa),str2[1],str1[1],str2[2],Double.parseDouble(str2[3].trim()),"", ""));
				}
				else{
					avisos.comandoincorrecto(str);
					avisos.imp();
				}
			}
			if(str1[1].equals("profesor")){
				str3=separar.espacios(str[4]);
				if (avisos.fechacorrecta(str2[1])&str[3].length()<=40){
					if (avisos.horasincorr(Integer.parseInt(str3[1].trim()))&avisos.imp()){
						mapa.put(getid(mapa), new profesor(str[1], getid(mapa),str2[1],str1[1],str[3],Integer.parseInt(str3[1].trim()),""));
					}
				}
				else{
					avisos.comandoincorrecto(str);
					avisos.imp();
				}
			}
		}
		else {
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
	/**Asigna un nuevo id a la persona indicada, el id sera el primero disponible por orden
	 * @param mapa Map con todas las personas
	 * @return id Devuelve el primer id disponible por orden*/
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
	/**Asigna carga docente a un profesor dado
	 * @param str Contiene la linea de ejecucion separa por espacios
	 * @param personas Map con todas las personas
	 * @param materias Map con todas las materias*/
	public void asignarcargadocente(String[] str, Map<Integer, persona> personas, Map <Integer,materia> materias){
		int idp,idm;
		if (str.length==4){
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
		else{
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
	/**Matricula a un alumno en una materia
	 * @param str Contiene la linea de ejecucion separa por espacios
	 * @param personas Map con todas las personas
	 * @param materias Map con todas las materias*/
	public void matricularalumno(String[] str, Map<Integer, persona> personas, Map <Integer,materia> materias){
		int idp,idm;
		if (str.length==4){
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
		else{
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
	/**Evalua una materia
	 * @param str Contiene la linea de ejecucion separa por espacios
	 * @param personas Map con todas las personas
	 * @param materias Map con todas las materias
	 * @throws ParseException
	 * @throws IOException*/
	public void evaluarmateria(String[] str, Map<Integer, persona> personas, Map<Integer, materia> materias) throws ParseException, IOException{
		int idm,idp, j=0, i=0, sizenot, sizemat;
		double nota, notamedia;
		if (str.length==3){
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
					nota=Double.parseDouble(separar.espacios(leer.getnotas().get(j).trim())[1]);
					if (nota>=5){
						while (i<sizemat){
							if (Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(i))[0])==idm){
								((alumno) personas.get(idp)).getdocerec().remove(i);
								((alumno) personas.get(idp)).getaprob().add(str[1]);
								if (((alumno) personas.get(idp)).getdocerec().isEmpty()){
									((alumno) personas.get(idp)).getdocerec().add("");
								}
								if (((alumno) personas.get(idp)).getaprob().get(0).equals("")){
									((alumno) personas.get(idp)).getaprob().remove(0);
								}
								notamedia=((((alumno) personas.get(idp)).getnota())+nota)/(((alumno) personas.get(idp)).getaprob().size());
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
								if (((alumno) personas.get(idp)).getdocerec().isEmpty()){
									((alumno) personas.get(idp)).getdocerec().add("");
								}
								break;
							}
							i++;
						}
					}
					i=0;
					j++;
				}
			}
		}
		else{
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
	/**Genera un horario para el alumno dado
	 * @param str Contiene la linea de ejecucion separa por espacios
	 * @param personas Map con todas las personas
	 * @param materias Map con todas las materias
	 * @throws ParseException
	 * @throws IOException */
	public void obtenercalendario(String[] str, Map<Integer, persona> personas, Map<Integer, materia> materias) throws ParseException, IOException{
		SortedMap<Date,Integer> horas = new TreeMap<Date,Integer>();
		fechas fechas = new fechas();
		if(str.length==3){
			int idp=Integer.parseInt(str[1]);
			int sizedocerec,sizegrupos,j=0,i=0,idm,idg;
			if ((avisos.alumnoinex(idp, personas)&&avisos.alumnosinasignaciones(idp, personas))&avisos.imp()){
				sizedocerec=((alumno) personas.get(idp)).getdocerec().size();
				while (j<sizedocerec){
					idm=Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(j))[0]);
					idg=Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(j))[1]);
					sizegrupos=materias.get(idm).getgrupos().size();
					while (i<sizegrupos){
						if (Integer.parseInt(separar.espacios(materias.get(idm).getgrupos().get(i))[0])==idg){
							horas.put(fechas.stringadate(separar.espacios(materias.get(idm).getgrupos().get(i))),idm);
						}
						i++;
					}
					i=0;
					j++;
				}
				escribir.horario(str, horas, materias);
			}
		}
		else {
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
	/**Genera una lista con los profesores ordenados por carga docente
	 * @param str Contiene la linea de ejecucion separa por espacios
	 * @param personas Map con todas las personas
	 * @param materias Map con todas las materias
	 * @throws IOException */
	public void ordenarporcargadocente(String[] str, Map<Integer, persona> personas, Map<Integer, materia> materias) throws IOException{
		List<String> horas = new ArrayList<String>();
		List<Integer> ids = new ArrayList<Integer>(personas.keySet());
		int j=0,size;
		if (str.length==2){
			if (avisos.noprofesores(personas)&avisos.imp()){
				size=personas.size();
				while (j<size){
					if (personas.get(ids.get(j)).gettipo().equals("profesor")){
						if (((profesor) personas.get(ids.get(j))).getdoceimp().get(0).equals("")){
							horas.add("0"+" "+ids.get(j));
						}
						else{
							horas.add(Integer.toString(((profesor) personas.get(ids.get(j))).getdoceimp().size())+" "+ids.get(j));
						}
					}
					j++;
				}
				Collections.sort(horas,new compcargadoce());
				escribir.cargadocente(str, personas, horas);
			}
		}
		else {
			avisos.comandoincorrecto(str);
			avisos.imp();
		}
	}
}
