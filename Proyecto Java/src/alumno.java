import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**Crea alumnos y almacena sus datos */
public class alumno extends persona {
	DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	String fechaing; 
	double nota; 
	String aprob; 
	String docerec;
	List <String> listadocrec= new ArrayList<String>();
	List <String> listadoaprob= new ArrayList<String>();
	separar separar=new separar();

	String [] separados;
	int longcadena=0;

	/**Crea a alumno con los datos*/
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
	/**Devuelve fecha de ingreso*/
	public String getfechaing(){
		return fechaing;
	}
	/**Devuelve nota*/
	public double getnota(){
		return nota;
	}
	/**Devuelve asignatruas aprobadas*/
	public List<String> getaprob(){
		return listadoaprob;
	}
	/**Devuelve docencia recibida*/
	public List<String> getdocerec(){
		return listadocrec;
	}
	/**Guarda docencia recibida*/
	public void putdocrec(String str1, String str2){
		this.listadocrec.add(str1+" "+str2);	
	}
	/**Guarda nota*/
	public void putnota(double nota){
		this.nota=nota;
	}
}
