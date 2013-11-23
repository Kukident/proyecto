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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//me cago en la leche merche

public class main {

	public static void main(String[] args) throws ParseException, IOException {

		String ruta = "/Users/danielvilar2/Desktop/dni.txt";
		File archivo = new File (ruta);
		String linea=null;
		Scanner sc = new Scanner(System.in);
		FileWriter fichero = null;
		PrintWriter pw = null;

		List<Personas> listado = new ArrayList <Personas>();
		Map<String,Personas> map= new HashMap<String,Personas>();

		int bucle=0;

		String DNI;
		String nombre;
		String apellido1;
		String apellido2;
		String fecha;

		try {//Lee el archivo
			FileReader lector = new FileReader(archivo);
			BufferedReader buf = new BufferedReader(lector);
			while ((linea = buf.readLine()) != null)//Mientras que no llegue al final del archivo va separando la cadena en los distintos datos
			{
				DNI=linea.split("["+ '*' +"]")[0];
				nombre=linea.split("["+ '*' +"]")[1];
				apellido1=linea.split("["+ '*' +"]")[2].split(" ")[0];
				apellido2=linea.split("["+ '*' +"]")[2].split(" ")[1];
				fecha=linea.split("["+ '*' +"]")[3];
				listado.add(new Personas(DNI,nombre,apellido1,apellido2,fecha));//A–ade el objeto a la lista
				map.put(DNI, new Personas(DNI,nombre,apellido1,apellido2,fecha));//A–ade el objeto al mapa
			}
			buf.close();//Cerramos el buffer y el lector del archivo
			lector.close();
		}
		catch (FileNotFoundException ex){//Si no existe el archivo lanza una excepcion
			System.out.println("No hay archivo");
		}

		while (bucle!=5){
			System.out.println("1 - A–adir una nueva persona.\n2 - Ordena por fecha de nacimiento\n3 - Ordenar por apellidos\n4 - Buscar por DNI\n5 - Salir");
			bucle= sc.nextInt();
			sc.nextLine();
			switch (bucle){
			case 1:{//A–adir nueva persona al sistema
				System.out.println("A–adir una nueva persona:");
				System.out.println("Introduzca el DNI: ");
				DNI=sc.nextLine();
				System.out.println("Introduzca el nombre:");
				nombre=sc.nextLine();
				System.out.println("Introduzca el primer apellido:");
				apellido1=sc.nextLine();
				System.out.println("Introduza el segundo apellido:");
				apellido2=sc.nextLine();
				System.out.println("Introduzca la fecha de nacimiento en el siguente formato (dd/mm/aaaa):");
				fecha=sc.nextLine();
				listado.add(new Personas(DNI,nombre,apellido1,apellido2,fecha));//A–adimos la nueva persona a la lista y al mapa
				map.put(DNI, new Personas(DNI, nombre, apellido1,apellido2,fecha));
			
				try {
					fichero = new FileWriter("/Users/danielvilar2/Desktop/dni.txt",true);//Abre el fichero y a–ade a la ultima linea la persona que acabamos de a–adir
					pw = new PrintWriter(fichero);
						pw.println(DNI+"*"+nombre+"*"+apellido1+"*"+apellido2+"*"+fecha);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				fichero.close();//Cerramos el fichero
				break;
			}
			case 2:{
				Collections.sort(listado);//Ordenamos el listado, por defecto por fecha de nacimiento
				for(Personas t: listado) System.out.println(t); //Imprimimos el nombre, apellido y edad  
				break;

			}
			case 3:{
				Collections.sort(listado, new compapellidos());//Oredamos el listado por 1¼ apellido, creado el comparador
				for(Personas t: listado) System.out.println(t);   
				break;
			}
			case 4:{
				do{
					System.out.println("Introduzca el DNI que desea buscar:");
					DNI=sc.nextLine();
					if	(map.get(DNI)==null){//Si el dni no se encuentra se pide que introduzca uno nuevo
						System.out.println("El DNI introducido no se encuentra");
						continue;
					}
					System.out.println(map.get(DNI));//Imprime el valor asociado al dni
					break;
				}while (map.get(DNI)==null);
			}
			}

		}
	}
}

