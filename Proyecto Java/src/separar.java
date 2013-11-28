import java.util.List;


public class separar {
	static String [] separados;
	int longcadena=0;
	int j=0;

	public void comas(String str, List<String> listadoprerequi){
		j=0;
		separados=str.split("["+ ',' +"]");//Separa el string con los prerequisitos y los guarda en una lista
		longcadena=separados.length-1;
		while (j<=longcadena){
			listadoprerequi.add(separados[j].trim());
			j++;	
		}
	}
	public void puntosycomas(String str, List <String> grupos){
		j=0;
		separados=str.split("["+ ';' +"]");//Separa el string con los grupos y los guarda en una lista
		longcadena=separados.length-1;
		while (j<=longcadena){
			grupos.add(separados[j].trim());
			j++;
		}
	}
	public static String[] espacios(String str){
		separados=str.split("["+ ' ' +"]");//Divide el string por los espacios
		return separados;
	}
	public static String[] comillas(String str){
		separados=str.split("["+ '"' +"]");//Divide el string por las comillas
		return separados;
	}
	public static String[] barras(String str){
		separados=str.split("["+ '/' +"]");//Divide el string por las barras
		return separados;
	}
}
