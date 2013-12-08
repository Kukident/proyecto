import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**Convierte un string de fechas en un date y viceversa*/
public class fechas {
	SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEEE H");
	/**Convierte un string de fechas a un date
	 * @param str Fecha en formato D H (L 16)
	 * @return d1 Fecha en formato Dia H (lunes 16)
	 * throws ParseException*/
	public Date stringadate(String[] str) throws ParseException{
		String dia=null;
		char letra=str[1].charAt(0);

		switch (letra){
		case 'L':{
			dia="lunes";
			break;
		}
		case 'M':{
			dia="martes";
			break;
		}
		case 'X':{
			dia="miércoles";
			break;
		}
		case 'J':{
			dia="jueves";
			break;
		}
		case 'V':{
			dia="viernes";
			break;
		}
		}
		dia=dia+" "+str[2];
		Date d1=df.parse(dia);
		return d1;
	}
	/**Convierte un date en un string
	 * @param d1 Fecha en formato Dia H (Lunes 16)
	 * @return Devuelve un string con formato D H (L 16)*/
	public String dateastring(Date d1){
		String letras;
		String str[]=separar.espacios(df.format(d1));
		if (str[0].equals("miércoles")){
			letras="X";
		}
		else {
			char letra=str[0].charAt(0);
			letras=Character.toString(letra).toUpperCase();
		}
		return letras+" "+str[1];
	}
}
