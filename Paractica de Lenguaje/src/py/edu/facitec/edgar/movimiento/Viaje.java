package py.edu.facitec.edgar.movimiento;

import java.math.BigDecimal;
import java.util.List;

import py.edu.facitec.edgar.entidad.Turista;
import py.edu.facitec.edgar.interfaz.TransporteInterfaz;

public  class Viaje implements TransporteInterfaz {
	
	private BigDecimal total;
	
	private Pasaje pasaje;
	
	
	public Viaje(){
		total=new BigDecimal(0);
		
		pasaje= new Pasaje();
		}
	

	public double pagar(int monto){
		return pasaje.getPrecio()*monto;
	}
	
	protected void cancelar(){
		
	}
	
	
	
	@Override
	public String toString() {
		return "Viaje [total=" + total + ", pasaje=" + pasaje + ", toString()=" + super.toString() + "]";
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Pasaje getPasaje() {
		return pasaje;
	}


	public void setPasaje(Pasaje pasaje) {
		this.pasaje = pasaje;
	}


	@Override
	public void viajar(List<Turista> turistas) {
		// TODO Auto-generated method stub
		
	}
	
	

}
