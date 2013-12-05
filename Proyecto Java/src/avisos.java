import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class avisos {
	escribir escribir = new escribir();
	String avisolinea="";
	public boolean imp(){//Pasa la cadena de caracteres al objeto imprimir, para guardar los avisos en un archivo txt
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
	public boolean fechaingreso(String str){
		Calendar calendar = new GregorianCalendar();
		String separado[];
		int a–onac;
		int a–oact;
		int edad;
		separado=separar.barras(str);
		a–onac=Integer.parseInt(separado[2]);
		a–oact=calendar.get(Calendar.YEAR);
		edad=a–oact-a–onac;
		if (edad>=15 && edad<=65){
			return true;
		}
		else{
			avisolinea="Fecha de ingreso incorrecta ";
			return false;
		}
	}

	public boolean notamedia(Integer nota){
		if (nota<=10 && nota>=0 ){
			return true;
		}
		else{
			avisolinea=avisolinea.concat("Nota media incorrecta ");
			return false;
		}
	}
	public boolean horasincorr(Integer horas){
		if (horas<=20 && horas>=0 ){
			return true;
		}
		else{
			avisolinea="Numero de horas incorrecto ";
			return false;
		}
	}
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
}