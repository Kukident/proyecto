import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**Leer los distintos archivos .txt*/
public class leer {
	Map<Integer,materia> mapmateria= new HashMap<Integer,materia>();
	Map<Integer,persona> mappersona= new HashMap<Integer,persona>();
	List <String> listaejec = new ArrayList <String>();
	List <String> notas = new ArrayList <String>();

	/**Devuelve un map de personas, con key=id y value=personas*/
	public Map<Integer, persona> getpersonas(){
		return mappersona;
	}
	/**Devuelve un map de materias, con key=id y value=materias*/
	public Map<Integer, materia> getmaterias(){
		return mapmateria;
	}
	/**Devuelve una lista con las ejecuciones*/
	public List<String> getejecucion(){
		return listaejec;
	}
	/**Devuelve una lista con las notas*/
	public List<String> getnotas(){
		return notas;
	}
	/**Lee el archivo materias y las guarda en un map
	 * @throws ParseException
	 * @throws IOException*/
	public void materias() throws ParseException, IOException{
		int id=0;
		String materia=null;
		String siglas=null;
		String prerequi=null;
		String grupos=null;
		int lineas=0;

		String ruta = "/Users/danielvilar2/Downloads/pruebasProyectoPII/testCorrectaEjecucion/entrada/materias.txt";
		File archivo = new File (ruta);
		String linea=null;

		try{
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)
			{
				switch (lineas){
				case 0:
				{
					if(linea.equals("*")){
						lineas=-1;
						break;
					}
					id=Integer.parseInt(linea);
					break;
				}
				case 1:{
					materia=linea;
					break;
				}
				case 2:{
					siglas=linea;
					break;
				}
				case 3:{
					prerequi=linea;
					break;
				}
				case 4:{
					grupos=linea;
					mapmateria.put(id, new materia(id,materia,siglas,prerequi,grupos));
					lineas=-1;
					break;
				}
				}
				lineas++;
			}
			buf.close();//Cerramos el buffer y el lector del archivo
			lector.close();
		}
		catch (FileNotFoundException ex){//Si no existe el archivo lanza una excepcion
			System.out.println("No hay archivo");
		}
	}
	/**Lee el archivo de ejecucion y lo guarda en un listado
	 * @throws ParseException
	 * @throws IOExcepton*/
	public void ejecucion() throws ParseException, IOException{

		String ruta = "/Users/danielvilar2/Downloads/pruebasProyectoPII/testCorrectaEjecucion/entrada/ejecucion.txt";
		File archivo = new File (ruta);
		String linea=null;

		try{
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)
			{
				listaejec.add(linea);
			}
			buf.close();//Cerramos el buffer y el lector del archivo
			lector.close();
		}
		catch (FileNotFoundException ex){//Si no existe el archivo lanza una excepcion
			System.out.println("No hay archivo");
		}
	}
	/**Lee el archivo personas y lo guarda en un map
	 * @throws ParseException
	 * @throws IOException*/
	public void personas() throws ParseException, IOException{
		String nombre=null;
		int id=0;
		String fechanac=null;
		String tipo=null;
		String fechaing=null;
		double nota=0;
		String dep=null;
		int horasig=0;
		String aprob=null;
		String docerec=null; 
		String doceimp=null;


		String cad="alumno";

		int lineas=0;


		String ruta = "/Users/danielvilar2/Downloads/pruebasProyectoPII/testCorrectaEjecucion/entrada/personas.txt";
		File archivo = new File (ruta);
		String linea=null;

		try{
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)
			{
				switch (lineas){
				case 0:
				{
					if(linea.equals("*")){
						lineas=-1;
						break;
					}
					id=Integer.parseInt(linea);
					break;
				}
				case 1:
				{
					tipo=linea;
					break;
				}
				case 2:
				{
					nombre=linea;
					break;
				}
				case 3:
				{
					fechanac=linea;
					break;
				}
				case 4:
				{
					if(tipo.equals(cad)){
						fechaing=linea;
					}
					else{
						dep=linea;
					}
					break;
				}
				case 5:
				{
					if(tipo.equals(cad)){
						aprob=linea;
					}
					else{
						horasig=Integer.parseInt(linea);
					}
					break;
				}
				case 6:
				{
					if (tipo.equals(cad))
					{
						nota=Double.parseDouble(linea);
					}
					else{
						doceimp=linea;
						mappersona.put(id, new profesor(nombre, id, fechanac,tipo,dep,horasig,doceimp));
						lineas=-1;
					}
					break; 
				}
				case 7:
				{
					if(tipo.equals(cad)){
						docerec=linea;
						mappersona.put(id,new alumno(nombre,id,fechanac,tipo,fechaing,nota,aprob,docerec));
						lineas=-1;
					}
					break;
				}
				}
				lineas++;
			}
			buf.close();//Cerramos el buffer y el lector del archivo
			lector.close();
		}
		catch (FileNotFoundException ex){//Si no existe el archivo lanza una excepcion
			System.out.println("No hay archivo");
		}
	}
	/**Lee el archivo con las notas y lo guarda en una lista
	 * @param ruta Ruta donde se encuentra el archivo a leer
	 * @throws ParseException
	 * @throws IOException*/
	public void notas(String ruta) throws ParseException, IOException{
		File archivo = new File (ruta);
		String linea=null;

		try{
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)
			{
				notas.add(linea);
			}
			buf.close();//Cerramos el buffer y el lector del archivo
			lector.close();
		}
		catch (FileNotFoundException ex){//Si no existe el archivo lanza una excepcion
			System.out.println("No hay archivo");
		}
	}
}
