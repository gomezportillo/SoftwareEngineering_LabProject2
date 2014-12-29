package dominio;

public class Entrenador extends Miembro {
	private String rango;
	
	public Entrenador(String pin, String nombre) {
		super(nombre, pin);
		rango = "aprendiz";
	}
}
