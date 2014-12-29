package dominio;

public class HuellaDigital {
	int alto, ancho;
	
	public HuellaDigital (int alto, int ancho){
		this.alto=alto;
		this.ancho=ancho;
	}
	public HuellaDigital(){ }
	
	public boolean compareTo(HuellaDigital huella){
		if(this.alto == huella.getAlto() && this.ancho == huella.getAncho())		
			return true;
		else
			return false;	
	}
	
	private int getAncho() {
		return ancho;
	}
	private int getAlto() {
		return alto;
	}
}
