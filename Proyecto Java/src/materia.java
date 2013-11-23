import java.util.ArrayList;
import java.util.List;


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

	public materia(int id, String materia, String siglas,String prerequi,String grupos){
		this.id=id;
		this.materia=materia;
		this.siglas=siglas;
		this.prerequi=prerequi;
		this.grupos=grupos;
		
		
		separar.comas(prerequi,listadoprerequi);
		separar.puntosycomas(grupos,listadogrupos);
		
	}
	
	public int getid(){
		return id;
	}
	public String getmateria(){
		return materia;
	}
	public String getsiglas(){
		return siglas;
	}
	public List<String> getprerequi(){
		return listadoprerequi;
	}
	public List<String> getgrupos(){
		return listadogrupos;
	}
	
}