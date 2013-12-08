import java.util.List;
/**Separa strings*/
public class separar {
	static String [] separados;
	int longcadena=0;
	int j=0;
	/**Separa strings por comas
	 * @param str String a separar
	 * @param listadoprerequi Listado en donde se guarda el string separado*/
	public void comas(String str, List<String> listadoprerequi){
		j=0;
		separados=str.split("["+ ',' +"]");//Separa el string con los prerequisitos y los guarda en una lista
		longcadena=separados.length-1;
		while (j<=longcadena){
			listadoprerequi.add(separados[j].trim());
			j++;	
		}
	}
	/**Separa strings por puntos y comas
	 * @param str String a separar
	 * @param grupos Listado en donde se guarda el string separado*/
	public void puntosycomas(String str, List <String> grupos){
		j=0;
		separados=str.split("["+ ';' +"]");//Separa el string con los grupos y los guarda en una lista
		longcadena=separados.length-1;
		while (j<=longcadena){
			grupos.add(separados[j].trim());
			j++;
		}
	}
	/**Separa strings por espacios
	 * @param str String a separar
	 * @return separados String ya separado*/
	public static String[] espacios(String str){
		separados=str.split("["+ ' ' +"]");//Divide el string por los espacios
		return separados;
	}
	/**Separa strings por comillas
	 * @param str String a separar
	 * @return separados String ya separado*/
	public static String[] comillas(String str){
		separados=str.split("["+ '"' +"]");//Divide el string por las comillas
		return separados;
	}
	/**Separa strings por barras
	 * @param str String a separar
	 * @return separados String ya separado*/
	public static String[] barras(String str){
		separados=str.split("["+ '/' +"]");//Divide el string por las barras
		return separados;
	}
}
