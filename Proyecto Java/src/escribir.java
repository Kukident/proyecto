import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class escribir {

	public void avisos(String str) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/danielvilar2/Desktop/avisos.txt", true));
			bw.write(str);
			bw.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void horario(String[] str,SortedMap<Date,Integer> horas, Map<Integer, materia> materias){
		List<Date> listahoras = new ArrayList<Date>(horas.keySet());
		fechas fechas = new fechas();
		int size,j=0;
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(str[2]));
			size=listahoras.size();
			while (j<size){
				bw.write(materias.get(horas.get(listahoras.get(j))).getid()+"\n"
						+materias.get(horas.get(listahoras.get(j))).getmateria()+"\n"+fechas.dateastring(listahoras.get(j))+"\n*\n");
				j++;
			}
			bw.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void cargadocente(String[] str, Map<Integer, persona> personas, List<String> horas){
		int size,j=0,i=0,sizedoc;
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(str[1]));
			size=horas.size();
			while (j<size){
				sizedoc=((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).getdoceimp().size();
				bw.write(personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1])).getid()+"\n"+
						personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1])).gettipo()+"\n"+
						personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1])).getnombre()+"\n"+
						personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1])).getfechanac()+"\n"+
						((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).getdep()+"\n"+
						((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).gethorasig()+"\n");
				while (i<sizedoc){
					if (((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).getdoceimp().get(i).equals("")){
					}
					else{
						if (i!=sizedoc-1) {
							bw.write(((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).getdoceimp().get(i)+"; ");
						}
						else{
							bw.write(((profesor) personas.get(Integer.parseInt(separar.espacios(horas.get(j))[1]))).getdoceimp().get(i));
						}
					}
					i++;
				}
				bw.write("\n*\n");
				i=0;
				j++;
			}
			bw.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void personas(Map<Integer, persona> personas){
		List<Integer> ids = new ArrayList<Integer>(personas.keySet());
		int size,sizeaprob,sizedocerec,sizedoc,j=0,i=0,tipo;
		size=personas.size();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/danielvilar2/Desktop/personas2.txt"));
			while (j<size){
				bw.write(personas.get(ids.get(j)).getid()+"\n"+personas.get(ids.get(j)).gettipo()+"\n"+
						personas.get(ids.get(j)).getnombre()+"\n"+personas.get(ids.get(j)).getfechanac()+"\n");
				if (personas.get(ids.get(j)).gettipo().equals("alumno")){
					tipo=0;
				}
				else {
					tipo=1;
				}
				switch (tipo){
				case 0:{
					sizeaprob=((alumno) personas.get(ids.get(j))).getaprob().size();
					sizedocerec=((alumno) personas.get(ids.get(j))).getdocerec().size();
					bw.write(((alumno) personas.get(ids.get(j))).getfechaing()+"\n");
					while (i<sizeaprob){
						if (((alumno) personas.get(ids.get(j))).getaprob().get(0).equals("")){
							bw.write("\n");
						}
						else{
							if (i!=sizeaprob-1){
								bw.write(((alumno) personas.get(ids.get(j))).getaprob().get(i)+", ");
							}
							else{
								bw.write(((alumno) personas.get(ids.get(j))).getaprob().get(i)+"\n");
							}
						}
						i++;
					}
					i=0;
					bw.write(((alumno) personas.get(ids.get(j))).getnota()+"\n");
					while (i<sizedocerec){
						if (((alumno) personas.get(ids.get(j))).getdocerec().get(0).equals("")){
							bw.write("\n");
						}
						else{
							if (i!=sizedocerec-1){
								bw.write(((alumno) personas.get(ids.get(j))).getdocerec().get(i)+"; ");
							}
							else{
								bw.write(((alumno) personas.get(ids.get(j))).getdocerec().get(i)+"\n");
							}
						}
						i++;
					}
					i=0;
					bw.write("*\n");
					break;
				}
				case 1:{
					sizedoc=((profesor) personas.get(ids.get(j))).getdoceimp().size();
					bw.write(((profesor) personas.get(ids.get(j))).getdep()+"\n"+((profesor) personas.get(ids.get(j))).gethorasig()+"\n");
					while (i<sizedoc){
						if (((profesor) personas.get(ids.get(j))).getdoceimp().get(0).equals("")){
							bw.write("\n");
						}
						else{
							if (i!=sizedoc-1){
								bw.write(((profesor) personas.get(ids.get(j))).getdoceimp().get(i)+"; ");
							}
							else{
								bw.write(((profesor) personas.get(ids.get(j))).getdoceimp().get(i)+"\n");
							}
						}
						i++;
					}
					i=0;
					bw.write("*\n");
					break;
				}
				}
				j++;
			}
			bw.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
