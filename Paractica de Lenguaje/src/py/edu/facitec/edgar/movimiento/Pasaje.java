package py.edu.facitec.edgar.movimiento;

import py.edu.facitec.edgar.entidad.Turista;

public class Pasaje {
	
	private  Turista turista;
	
	private double precio;
	
	public Pasaje() {
		precio=0;
		
	turista = new Turista();
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pasaje [turista=" + turista + ", precio=" + precio + ", toString()=" + super.toString() + "]";
	}
	
	
	

}