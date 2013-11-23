import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ordenarfecha {

	public static void main(String[] args) throws IOException, ParseException {
		String ruta = "/Users/danielvilar2/Desktop/a.txt";
		File archivo = new File (ruta);
		String linea=null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		List<Personas> listado = new ArrayList <Personas>();

		String dni=null;//Como en la practica 4, se usa el dni, utilizo la misma clase personas, pero dejando el dni en null
		String nombre;
		String apellido1;
		String apellido2;
		String fecha;

		try {//Lee el archivo
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)
			{
				nombre=linea.split("["+ '*' +"]")[0];//Parte el string y guarda cada dato en su variable
				apellido1=linea.split("["+ '*' +"]")[1].split(" ")[0];
				apellido2=linea.split("["+ '*' +"]")[1].split(" ")[1];
				fecha=linea.split("["+ '*' +"]")[2];
				listado.add(new Personas(dni,nombre,apellido1,apellido2,fecha));//A–ade el objeto personas a la lista
			}
			buf.close();//Cerramos los buffers de lectura del teclado
			lector.close();
		}
		catch (FileNotFoundException ex){
			System.out.println("No hay archivo");
		}
		Collections.sort(listado);//Ordena el listado de manera predeterminada por fecha de nacimiento
		for(Personas t: listado) System.out.println(t);//
		try {//Guardamos el listado ordenado en el documento
			fichero = new FileWriter("/Users/danielvilar2/Desktop/a .txt");
			pw = new PrintWriter(fichero);
			for(Personas t: listado) pw.println(t.getnombre()+"*"+t.getapellido1()+"*"+t.getapellido2()+"*"+t.getfecha());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		fichero.close();//Cerramos el fichero
	}

}
