import java.util.ArrayList;
import java.util.List;
/**Crea materias y guarda sus datos*/
public class materia {
	int id=0;
	String materia=null;
	String siglas=null;
	String prerequi=null;
	String grupos=null;
	List <String> listadoprerequi= new ArrayList<String>();
	List <String> listadogrupos= new ArrayList<String>();
	separar separar=new separar();
	String [] separados;
	int longcadena=0;
	/**Crea una materia con los datos*/
	public materia(int id, String materia, String siglas,String prerequi,String grupos){
		this.id=id;
		this.materia=materia;
		this.siglas=siglas;
		this.prerequi=prerequi;
		this.grupos=grupos;


		separar.comas(prerequi,listadoprerequi);
		separar.puntosycomas(grupos,listadogrupos);

	}
	/**Devuelve id*/
	public int getid(){
		return id;
	}
	/**Devuelve el nombre de la materia*/
	public String getmateria(){
		return materia;
	}
	/**Devuleve las siglas de la materia*/
	public String getsiglas(){
		return siglas;
	}
	/**Devuelve los prerequisitos necesarios para matricularse*/
	public List<String> getprerequi(){
		return listadoprerequi;
	}
	/**Devuelve los grupos*/
	public List<String> getgrupos(){
		return listadogrupos;
	}

}