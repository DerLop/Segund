package py.edu.facitec.edgar.entidad;

import java.util.Date;
import java.util.List;

public class Turista extends Entidad {
	private String nombre;
	private Date fechaNacimiento;
	
	private List<TarjetaDeCredito>tarjetas;
	
	public Turista(){
		nombre="";
		fechaNacimiento=new Date();		
	}

	@Override
	public Integer obtenerCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Turista(String nombre, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void agregarTargeta(TarjetaDeCredito tarjeta){
		
		tarjetas.add(tarjeta);
	}
	
	
	public void imprimirTarjeta(){
		for (TarjetaDeCredito tar : tarjetas) {
			System.out.println(tar.toString());
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<TarjetaDeCredito> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaDeCredito> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return "Turista [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", tarjetas=" + tarjetas
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	


}
