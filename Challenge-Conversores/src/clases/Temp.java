package clases;

public class Temp {
	private String nombre;
	
	public Temp(String n) {
		nombre = n;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
