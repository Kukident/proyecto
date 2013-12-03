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
					System.out.println(separar.espacios(materias.get(idm).getgrupos().get(i))[0]);
					i++;
				}
				avisolinea="Grupo inexistente ";
				return false;
			}
			j++;
		}
		avisolinea="Materia inexistente ";
		return false;
	}
}
