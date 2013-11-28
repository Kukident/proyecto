import java.io.IOException;
import java.text.ParseException;


public class main {

	public static void main(String[] args) throws ParseException, IOException {
		leer leer = new leer();
		ejecucion ejecucion = new ejecucion();
		leer.personas();//Lee el archivo personas y guarda profesores y alumnos en un map con key=id
		leer.materias();//Lee el archivo materias y las guarda en un map con key=id
		leer.ejecucion();//Lee el archivo con las ordenes a realizar y las guarda en una lista

		//System.out.println(((alumno) leer.getpersonas().get(2)).getnota());

		//System.out.println(separar.comillas(leer.getejecucion().get(0))[1].trim());
		System.out.println(leer.getpersonas().keySet());
		ejecucion.insertapersona((separar.comillas(leer.getejecucion().get(0))), leer.getpersonas());
		System.out.println(leer.getpersonas().keySet());
		ejecucion.insertapersona((separar.comillas(leer.getejecucion().get(1))), leer.getpersonas());
		System.out.println(leer.getpersonas().keySet());
		//System.out.println(((profesor) leer.getpersonas().get(5)).getdep());

		//System.out.println(leer.getpersonas().get(0).getnombre());
	}
}

