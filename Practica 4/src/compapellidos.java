import java.util.Comparator;


public class compapellidos implements  Comparator <Personas> {

	@Override
	public int compare(Personas arg0, Personas arg1) {//Compara apellidos, pasandolos a miniscula para que no tenga problemas si hay algun apellido mal escrito
		return arg0.getapellido1().toLowerCase().compareTo(arg1.getapellido1().toLowerCase());
	}

}
