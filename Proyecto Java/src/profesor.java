import java.util.ArrayList;
import java.util.List;


public class profesor extends persona {

	String dep; //Departamento
	int horasig; //Horas asignables
	String doceimp; //Lista de docencia impartida
	List <String> listadodoceimp= new ArrayList<String>();
	static 	List <String> listadodoce= new ArrayList<String>();
	separar separar=new separar();


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

	public String getdep(){
		return dep;
	}

	public int gethorasig(){
		return horasig;
	}

	public List<String> getdoceimp(){
		return listadodoceimp;
	}
	public void putdoceimp(String str1, String str2){
		this.listadodoceimp.add(str1+" "+str2);	
	}

}
