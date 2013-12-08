import java.util.ArrayList;
import java.util.List;
/**Crea profesores y almacena sus datos*/
public class profesor extends persona {

	String dep; //Departamento
	int horasig; //Horas asignables
	String doceimp; //Lista de docencia impartida
	List <String> listadodoceimp= new ArrayList<String>();
	static 	List <String> listadodoce= new ArrayList<String>();
	separar separar=new separar();

	/**Crea a profesor con los datos*/
	public profesor(String nombre,int id, String fechanac, String tipo,String dep, int horasig,String doceimp){
		this.nombre=nombre;
		this.id=id;
		this.fechanac=fechanac;
		this.tipo=tipo;
		this.dep=dep;
		this.horasig=horasig;
		this.doceimp=doceimp;

		separar.puntosycomas(doceimp,listadodoceimp);
		separar.puntosycomas(doceimp,listadodoce);
	}
	/**Devuelve departamento*/
	public String getdep(){
		return dep;
	}
	/**Devuelve horas asignables*/
	public int gethorasig(){
		return horasig;
	}
	/**Devuelve docencia impartida*/
	public List<String> getdoceimp(){
		return listadodoceimp;
	}
	/**Guarda docencia impartida*/
	public void putdoceimp(String str1, String str2){
		this.listadodoceimp.add(str1+" "+str2);	
	}

}
