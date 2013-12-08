/**Ordena la carga docente por orden creciente y en caso de empate
 * recurre al id*/

public class compcargadoce implements java.util.Comparator<String>{

	/**Compara dos strings con formato /h id/
	 * @param str1 String con hora e id
	 * @param str2 String con hora e id
	 * @return Si tienen las mismas horas lo devuelve comparado con los ids
	 * si no por el numero de horas*/
	public int compare(String str1, String str2) {
		int horas1=Integer.parseInt(separar.espacios(str1)[0]);
		int horas2=Integer.parseInt(separar.espacios(str2)[0]);
		int idp1=Integer.parseInt(separar.espacios(str1)[1]);
		int idp2=Integer.parseInt(separar.espacios(str2)[1]);


		if (horas1==horas2){
			return ((Integer) idp1).compareTo(idp2);
		}
		return ((Integer) horas1).compareTo(horas2);
	}
}
