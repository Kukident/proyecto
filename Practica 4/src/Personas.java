import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Personas implements Comparable <Personas>{
	DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	String nombre;
	String apellido1;
	String apellido2;
	String dni;
	String sfecha;
	Date fecha;

	public Personas(String d, String n, String a1, String a2, String f) throws ParseException{
		dni=d;
		nombre=n;
		apellido1=a1;
		apellido2=a2;
		sfecha=f;
		fecha= df.parse(sfecha);
	}

	public String getdni(){
		return dni;
	}

	public String getnombre(){
		return nombre;
	}

	public String getapellido1(){
		return apellido1;
	}

	public String getapellido2(){
		return apellido2;
	}

	public String getfecha(){
		return sfecha;
	}

	public int compareTo(Personas o) {//Compara dos datos que que queramos, en este caso fechas
		return this.fecha.compareTo(o.fecha);
	}

	public String toString(){//Devuelve nombre primer apellido y edad
		int fecha1 = 2013 - (Integer.parseInt(sfecha.split("["+ '/' +"]")[2]));
		return nombre+" "+apellido1+" "+fecha1;
	}

}
