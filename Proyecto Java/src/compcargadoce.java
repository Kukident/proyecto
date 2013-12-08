

public class compcargadoce implements java.util.Comparator<String>{


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
