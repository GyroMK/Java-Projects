package modelo;

public class Jugador {
	private String nombre;
	private String deporte;
	private int tiempo;
	
	public Jugador(String nombre, String deporte, int tiempo){
		this.nombre = nombre;
		this.deporte = deporte;
		this.tiempo = tiempo;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
