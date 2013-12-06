import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class fechas {
	SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEEE H");

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
			dia="miercoles";
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
	public String dateastring(Date d1){
		String str[]=separar.espacios(df.format(d1));
		char letra=str[0].charAt(0);
		String letras=Character.toString(letra).toUpperCase();
		return letras+" "+str[1];
	}
}
