import java.io.IOException;
import java.text.ParseException;


public class main {

	public static void main(String[] args) throws ParseException, IOException {
		leer leer = new leer();
		leer.personas();//Lee el archivo personas y guarda profesores y alumnos en un map con key=id
		leer.materias();//Lee el archivo materias y las guarda en un map con key=id
		leer.ejecucion();//Lee el archivo con las ordenes a realizar y las guarda en una lista
		//System.out.println(separar.comillas(leer.getejecucion().get(0))[1].trim());
		ejecucion.insertapersona(separar.comillas(leer.getejecucion().get(0)));
		System.out.println(leer.getalumnos().get(0).getnota());
	}
}

