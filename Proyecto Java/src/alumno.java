import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class alumno extends persona {
	DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	String fechaing; //Fecha de ingreso
	double nota; //Nota media
	String aprob; //Lista de asignaturas aprobadas
	String docerec; //Lista de asignaturas matriculadas
	List <String> listadocrec= new ArrayList<String>();
	List <String> listadoaprob= new ArrayList<String>();
	separar separar=new separar();

	String [] separados;
	int longcadena=0;


	public alumno(String nombre,int id, String fechanac, String tipo, String fechaing, double nota, String aprob, String docerec){
		this.nombre=nombre;
		this.id=id;
		this.fechanac=fechanac;
		this.tipo=tipo;
		this.fechaing=fechaing;
		this.nota=nota;
		this.aprob=aprob;
		this.docerec=docerec;

		if (aprob!=null){
			separar.comas(aprob,listadoaprob);
		}
		if (docerec!=null){
			separar.puntosycomas(docerec,listadocrec);
		}
	}

	public String getfechaing(){
		return fechaing;
	}

	public double getnota(){
		return nota;
	}

	public List<String> getaprob(){
		return listadoaprob;
	}

	public List<String> getdocerec(){
		return listadocrec;
	}
	public void putdocrec(String str1, String str2){
		this.listadocrec.add(str1+" "+str2);	
	}
	public void putnota(double nota){
		this.nota=nota;
	}
}
