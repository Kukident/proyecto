import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
/**Maneja los avisos que pueden generar los distintos tipos de comandos*/
public class avisos {
	escribir escribir = new escribir();
	String avisolinea="";
	/**Pasa la cadena de caracteres al objeto escribir, que guarda los avisos en un archivo txt
	 * @return true */
	public boolean imp(){
		if (avisolinea.length()!=0){
			avisolinea=avisolinea.substring(0,avisolinea.length()-1);
			avisolinea=avisolinea.concat("\n");
			try {
				escribir.avisos(avisolinea);
			} catch (IOException e) {
				// TODO Bloque catch generado autom‡ticamente
				e.printStackTrace();
			}
		}
		avisolinea="";
		return true;
	}
	/**Comprueba si la fecha de ingreso es correcta
	 * @param str Fecha de nacimiento
	 * @param str1 Fecha de ingreso
	 * @return true Si la fecha de ingreso es correcta
	 * @return false Si la fecha de ingreso es incorrecta */
	public boolean fechaingreso(String str,String str1){
		String separado[];
		String separado1[];
		int a–onac;
		int a–oing;
		int edad;
		separado=separar.barras(str);
		separado1=separar.barras(str1);
		a–onac=Integer.parseInt(separado[2]);
		a–oing=Integer.parseInt(separado1[2]);
		edad=a–oing-a–onac;
		if (edad>=15 && edad<=65){
			return true;
		}
		else{
			avisolinea="Fecha de ingreso incorrecta ";
			return false;
		}
	}
	/**Comprueba si la nota media es correcta
	 * @param nota Nota a comprobar
	 * @return true Si la nota esta entre los valores correctos
	 * @return false Si no lo esta*/
	public boolean notamedia(Double nota){
		if (nota<=10 && nota>=0 ){
			return true;
		}
		else{
			avisolinea=avisolinea.concat("Nota media incorrecta ");
			return false;
		}
	}
	/**Comprueba si las horas asignables son correctas
	 * @param horas Horas a comprobar 
	 * @return true Si las horas estan entre los valores correctos*/
	public boolean horasincorr(Integer horas){
		if (horas<=20 && horas>=0 ){
			return true;
		}
		else{
			avisolinea="Numero de horas incorrecto ";
			return false;
		}
	}
	/**Comprueba si el profesor existe
	 * @param idp ID del profesor a comprobar
	 * @param personas Map con todas las personas
	 * @return true Si el profesor existe */
	public boolean profesorinex(Integer idp, Map<Integer, persona> personas){
		List<Integer> ids = new ArrayList<Integer>(personas.keySet());	
		int size=ids.size();
		int j=0;
		while (j<size){
			if	(ids.get(j).equals(idp)){
				if (personas.get(idp).gettipo().equals("profesor")){
					return true;
				}
				avisolinea="Profesor inexistente ";
				return false;
			}	
			j++;
		}
		avisolinea="Profesor inexistente ";
		return false;
	}
	/** Comprueba si la materia y grupo existen
	 * @param idm ID de la materia a comprobar (Int)
	 * @param materias Map con todas las materias
	 * @param idg ID del grupo (string)
	 * @return true Si materia y grupo existen*/
	public boolean materiainex(Integer idm, Map<Integer, materia> materias, String idg){
		List<Integer> ids = new ArrayList<Integer>(materias.keySet());	
		int size=ids.size();
		int j=0;
		while (j<size){
			if	(ids.get(j).equals(idm)){
				int i=0;
				int size1=materias.get(idm).getgrupos().size();
				while (i<size1){
					if ((separar.espacios(materias.get(idm).getgrupos().get(i))[0]).equals(idg)){
						return true;
					}
					i++;
				}
				if (idg.equals("-1")){
					return true;
				}
				else{
					avisolinea="Grupo inexistente ";
					return false;
				}
			}
			j++;
		}
		avisolinea=avisolinea.concat("Materia inexistente ");
		return false;
	}
	/**Comprueba si el grupo ya ha sido asignado a algun profesor
	 * @param idm ID de la materia
	 * @param idg ID del grupo
	 * @return true Si el grupo aun no ha sido asignado */
	public boolean grupoyaasignado(String idm, String idg){
		int size=profesor.listadodoce.size();
		int j=0;
		while (j<size){
			if (profesor.listadodoce.get(j).trim().equals(idm+" "+idg)){
				avisolinea=avisolinea.concat("Grupo ya asignado ");
				return false;
			}
			j++;
		}
		return true;
	}
	/**Comprueba si el alumno existe
	 * @param idp ID de alumno a comprobar
	 * @param personas Map con todas las personas
	 * @return true Si el alumno existe*/
	public boolean alumnoinex(Integer idp, Map<Integer, persona> personas){
		List<Integer> ids = new ArrayList<Integer>(personas.keySet());	
		int size=ids.size();
		int j=0;
		while (j<size){
			if	(ids.get(j).equals(idp)){
				if (personas.get(idp).gettipo().equals("alumno")){
					return true;
				}
				avisolinea=avisolinea.concat("Alumno inexistente ");
				return false;
			}	
			j++;
		}
		avisolinea=avisolinea.concat("Alumno inexistente ");
		return false;
	}
	/**Comprueba si los prerequisitos para una asignaturas estan cumplidos
	 * @param idp ID del alumno
	 * @param personas Map con todas las personas
	 * @param idm ID de la materia
	 * @param materias Map con todas las materias
	 * @return true Si los prerequisitos estan cumplidos */
	public boolean prerequisitos(Integer idp, Map<Integer, persona> personas, Integer idm,Map<Integer, materia> materias ){
		int sizem=((alumno) personas.get(idp)).getaprob().size();
		int sizerequi=materias.get(idm).getprerequi().size();
		int j=0,i=0;
		if (!((alumno) personas.get(idp)).getaprob().get(0).equals("")){
			while (i<sizerequi){
				if (materias.get(idm).getprerequi().get(0).equals("")){
					return true;
				}
				else{
					while (j<sizem){
						if (Integer.parseInt(((alumno) personas.get(idp)).getaprob().get(j).trim())==Integer.parseInt(materias.get(idm).getprerequi().get(i).trim())){
							return true;
						}
						j++;
					}
				}
				j=0;
				i++;
			}
		}
		if (materias.get(idm).getprerequi().get(0).equals("")){
			return true;
		}
		if (avisolinea.equals("Materia inexistente ")||avisolinea.equals("Alumno inexistente Materia inexistente ")){
			return false;
		}
		else{
			avisolinea=avisolinea.concat("No cumple requisitos ");
		}
		return false;
	}
	/** Comprueba si el alumno ya esta matriculado en la asignatura
	 * @param idp ID del alumno
	 * @param personas Map con todas las personas
	 * @param idm ID de la materia
	 * @return false Si el alumno esta matriculado en la asignatura*/
	public boolean yamatriculado(Integer idp, Map<Integer, persona> personas, Integer idm){
		int size=((alumno) personas.get(idp)).getdocerec().size();
		int j=0;
		if (!((alumno) personas.get(idp)).getdocerec().get(0).equals("")){
			while (j<size){
				if (Integer.parseInt(separar.espacios(((alumno) personas.get(idp)).getdocerec().get(j).trim())[0])==idm){
					avisolinea=avisolinea.concat("Ya es alumno de la materia indicada ");
					return false;				}
				j++;
			}
		}
		return true;
	}
	/**Comprueba si el alumno esta matriculado en alguna asignatura
	 * @param idp ID del alumno
	 * @param personas Map con todas las personas
	 * @return true Si el alumno esta matriculado en alguna asignatura*/
	public boolean alumnosinasignaciones(Integer idp, Map<Integer, persona> personas){
		if (((alumno) personas.get(idp)).getdocerec().get(0).equals("")){
			avisolinea=avisolinea.concat("Alumno sin asignaciones ");
			return false;
		}
		return true;
	}
	/**Comprueba si existen profesores en el map
	 * @param personas Map con todas las personas
	 * @return true Si existe algun profesor en el map*/
	public boolean noprofesores(Map<Integer, persona> personas){
		List<Integer> ids = new ArrayList<Integer>(personas.keySet());
		int size, j=0;
		size=ids.size();
		while (j<size){
			if (personas.get(ids.get(j)).gettipo().equals("profesor")){
				return true;
			}
			j++;
		}
		avisolinea=avisolinea.concat("No hay profesores ");
		return false;
	}
	/**Imprime el comando incorrecto en el archivo de avisos.
	 * @param str Comando*/
	public void comandoincorrecto(String str[]){
		int j=0;
		avisolinea=avisolinea.concat("Comando incorrecto: ");
		while(j<str.length){
			avisolinea=avisolinea.concat(str[j]+" ");
			j++;
		}
	}
	/**Comprueba que la fecha ingresada sea valida
	 * @param str String con la fecha
	 * @return true Si la fecha tiene un formato valido*/
	public boolean fechacorrecta(String str){
		String separado[];
		separado=separar.barras(str);
		if(Integer.parseInt(separado[1])>12||Integer.parseInt(separado[0])>31){
			return false;
		}
		return true;
	}
}