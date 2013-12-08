import java.io.IOException;
import java.text.ParseException;
//Faltan avisos para solape
//Creo dos veces el objeto escribir una en avisos y otra en ejecucuion. PUEDE GENERAR PROBLEMAS A LA HORA DE IMPRIMIR
import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) throws ParseException, IOException {
		leer leer = new leer();
		ejecucion ejecucion = new ejecucion();
		escribir escribir = new escribir();
		leer.personas();//Lee el archivo personas y guarda profesores y alumnos en un map con key=id
		leer.materias();//Lee el archivo materias y las guarda en un map con key=id
		leer.ejecucion();//Lee el archivo con las ordenes a realizar y las guarda en una lista


		List<Integer> ids = new ArrayList<Integer>(leer.getpersonas().keySet());
		int j=0,i=0,size;
		size=leer.getejecucion().size();
		while (j<size){
			if (separar.espacios(leer.getejecucion().get(j))[0].equals("InsertaPersona")){
				ejecucion.insertapersona((separar.comillas(leer.getejecucion().get(j))), leer.getpersonas());
			}
			else if (separar.espacios(leer.getejecucion().get(j))[0].equals("Asigna")){
				ejecucion.asignarcargadocente((separar.espacios(leer.getejecucion().get(j))), leer.getpersonas(), leer.getmaterias());
			}
			else if (separar.espacios(leer.getejecucion().get(j))[0].equals("Matricula")){
				ejecucion.matricularalumno((separar.espacios(leer.getejecucion().get(j))), leer.getpersonas(), leer.getmaterias());
			}
			else if (separar.espacios(leer.getejecucion().get(j))[0].equals("Evalua")){
				ejecucion.evaluarmateria((separar.espacios(leer.getejecucion().get(j))), leer.getpersonas(), leer.getmaterias());
			}
			else if (separar.espacios(leer.getejecucion().get(j))[0].equals("ObtenCalendario")){
				ejecucion.obtenercalendario((separar.espacios(leer.getejecucion().get(j))), leer.getpersonas(), leer.getmaterias());
			}
			else if (separar.espacios(leer.getejecucion().get(j))[0].equals("OrdenaProfesoresPorCargaDocente")){
				ejecucion.ordenarporcargadocente((separar.espacios(leer.getejecucion().get(j))), leer.getpersonas(), leer.getmaterias());
			}
			j++;
		}
		escribir.personas(leer.getpersonas());
	}
}

/*

		//System.out.println(((alumno) leer.getpersonas().get(2)).getnota());

		//System.out.println(separar.comillas(leer.getejecucion().get(0))[1].trim());
		System.out.println(leer.getpersonas().keySet());
		ejecucion.insertapersona((separar.comillas(leer.getejecucion().get(0))), leer.getpersonas());
		System.out.println(leer.getpersonas().keySet());
		ejecucion.insertapersona((separar.comillas(leer.getejecucion().get(1))), leer.getpersonas());
		System.out.println(leer.getpersonas().keySet());
		//Asignar carga docente
		System.out.println("Asignar cargadocente");
		//System.out.println(((profesor) leer.getpersonas().get(4)).getdoceimp());
		//ejecucion.asignarcargadocente((separar.espacios(leer.getejecucion().get(2))), leer.getpersonas(), leer.getmaterias());
		//System.out.println(leer.getejecucion().get(2));
		//System.out.println(((profesor) leer.getpersonas().get(4)).getdoceimp());
		//Matricular Alumno
		System.out.println("Matricular alumno");
		System.out.println(((alumno) leer.getpersonas().get(9)).getdocerec());
		ejecucion.matricularalumno((separar.espacios(leer.getejecucion().get(3))), leer.getpersonas(), leer.getmaterias());
		System.out.println(((alumno) leer.getpersonas().get(9)).getdocerec());
		//Evaluar materia
		System.out.println("Evaluar materia");
		System.out.println(((alumno) leer.getpersonas().get(2)).getdocerec());
		//ejecucion.evaluarmateria((separar.espacios(leer.getejecucion().get(4))), leer.getpersonas(), leer.getmaterias());
		System.out.println(((alumno) leer.getpersonas().get(2)).getdocerec());
		System.out.println(((alumno) leer.getpersonas().get(2)).getaprob());
		//Obtener calendario
		System.out.println("Obtener calendario");
		ejecucion.obtenercalendario((separar.espacios(leer.getejecucion().get(5))), leer.getpersonas(), leer.getmaterias());
		//Ordenar por carga docente
		System.out.println("Ordenar por carga docente");
		ejecucion.ordenarporcargadocente((separar.espacios(leer.getejecucion().get(6))), leer.getpersonas(), leer.getmaterias());

		escribir.personas(leer.getpersonas());



	}
}

 */