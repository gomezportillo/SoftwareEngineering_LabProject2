package dominio;

public class Maquina.java {
	private String nombre;
	private int sala;
	boolean ocupada = false;

	public Máquina(String _nombre, int _sala) {
		this.nombre = _nombre;
		this.sala = _sala;
	}
	
	public void setLibre(){
		this.ocupada = false;
	}
	public void setOcupada(){
		this.ocupada = true;
	}
	
}
